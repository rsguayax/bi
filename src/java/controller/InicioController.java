/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import auth_rest.Autenticacion;
import auth_rest.AuthenticationData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import dao.*;
import estructura.FileUploadMD;
import estructura.ItemEstructura;
import estructura.Login;
import estructura.Menu;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import model.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import nsga.persona.CorreoType;
import nsga.persona.IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage;
import nsga.persona.IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage;
import nsga.persona.PersonaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.RequestParam;
import util.Utiles;
//import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author utpl
 */
@Controller
//@RequestMapping("/inicio")
public class InicioController {

    ConvocatoriaDao convDao = new ConvocatoriaDao();
    IdeaDao ideaDao = new IdeaDao();
    ItemCatalogoDao itemDao = new ItemCatalogoDao();
    NsgaSoapDao wsNsga = new NsgaSoapDao();
    UsuarioDao usrDao = new UsuarioDao();

    ParticipanteDao partDao = new ParticipanteDao();

    Utiles util = new Utiles();

    UsuarioAuthDao usaDao = new UsuarioAuthDao();
    RolDao rolDao = new RolDao();
    RolUsuarioDao rusDao = new RolUsuarioDao();
    RolFuncionalidadDao rfuDao = new RolFuncionalidadDao();
    ConvocatoriaDao conDao = new ConvocatoriaDao();

    Gson g = new Gson();

    ConvocatoriaResponsableDao convrDao = new ConvocatoriaResponsableDao();

//    String localPath = "/Users/utpl/bancoideas/";
    String localPath = "/app/glassfish/glassfish4/glassfish/domains/domain1/applications/bancoideas/";

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public String login(Model model) {
        Login login = new Login("", "");
        model.addAttribute("login", login);
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest req) {
        List<Convocatoria> conv = convDao.listar();
//        ModelAndView mv = new ModelAndView("index");
        model.addAttribute("convocatorias", conv);
        model.addAttribute("innovadores", partDao.obtenerInnovadores());
        Login login = new Login("", "");
        model.addAttribute("login", login);

        long count_convocatorias = convDao.listar_sentencia_sql_count("select count(*) from Convocatoria");
        model.addAttribute("count_convocatorias", count_convocatorias);

        long count_emprendedores = convDao.listar_sentencia_sql_count("select count(*) from Participante");
        model.addAttribute("count_emprendedores", count_emprendedores);

//        return mv;
        return "index";
    }

    @RequestMapping(value = "/index2", method = RequestMethod.GET)
    public String index2(Model model, HttpServletRequest req) {
        List<Convocatoria> conv = convDao.listar();
//        ModelAndView mv = new ModelAndView("index");
        model.addAttribute("convocatorias", conv);
        model.addAttribute("innovadores", partDao.obtenerInnovadores());
        Login login = new Login("", "");
        model.addAttribute("login", login);
//        return mv;
        return "admin/index";
    }

    @RequestMapping(value = "/principal", method = RequestMethod.GET)
    public String principal(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        int idUs = Integer.parseInt(req.getParameter("us"));
        try {
            if (session.getAttribute("menu") != null) {
                model.addAttribute("nombre", session.getAttribute("nombre").toString());
                model.addAttribute("menu", session.getAttribute("menu"));
                model.addAttribute("foto", session.getAttribute("foto").toString());
                String f = session.getAttribute("foto").toString();
                model.addAttribute("convocatorias", session.getAttribute("convocatorias"));
                Login login = new Login("", "");
                model.addAttribute("login", login);

                int id_conv = -1;
                try {
                    id_conv = Integer.parseInt(req.getParameter("conv"));
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                boolean evaluador = false;
                List<Idea> ideas = new ArrayList<>();
                //listar ideas del usuario
                evaluador = true;
                if (id_conv == -1) {
                    ideas = ideaDao.listar_condicion("usuario.id", idUs);
                } else { //listar todas las ideas de la convocatoria
                    ConvocatoriaResponsable cr = convrDao.buscar("convocatoria.id", "usuario.id", id_conv, idUs);
                    if (cr != null) {
                        ideas = ideaDao.listar_condicion("convocatoria.id", id_conv);
                        evaluador = true;
                    }
                }
                for (Idea idea : ideas) {
                    idea.setImagen("/recursos/img/utpl.png");
                }
//                JSONArray array = new JSONArray();
//                for (Idea i : ideas) {
//                    JSONObject j = new JSONObject();
//                    j.put("id", i.getId());
//                    j.put("nombre", i.getNombre());
//                    j.put("descripcion", i.getDescripcion());
//                    j.put("kw", i.getKw());
//                    j.put("imagen", "/recursos/img/utpl.png");
//                    array.add(j);
//                }
                model.addAttribute("evaluador", evaluador);
                model.addAttribute("ideas", ideas);
                model.addAttribute("us", idUs);
                model.addAttribute("conv", id_conv);
                return "index";
            }
        } catch (Exception ex) {
            model.addAttribute("mensaje", ex.getMessage());
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String login(@ModelAttribute("login") Login login, Model model, HttpServletRequest req) {
        try {
            req.setCharacterEncoding("UTF-8");
            if (!login.getUsername().equals("") && !login.getPassword().equals("")) {
                String usuario = login.getUsername();
                if(usuario.contains("@")){
                    usuario = usuario.substring(0, usuario.indexOf("@"));
                }
                String pass = login.getPassword();
                String encrypt = util.md5(pass);
                Autenticacion t = new Autenticacion();
                UsuarioAuth usr = usaDao.buscar("user", usuario);
                boolean auth = false;
                boolean authEva = true;
                if (usr != null) {//innovador existe en base de datos con sus credenciales
                    if (usr.getPassword() != null && !usr.getPassword().equals("")) {
                        if (usr.getUser().equals(usuario) && usr.getPassword().equals(encrypt)) {
                            usr.setUltimoIngreso(new Date());
                            usaDao.actualizar(usr);
                            auth = true;
                        } else {
                            auth = true;
                            AuthenticationData autenticacion = null;
                            System.out.println("***se está iniciando la autenticación para: " + usr.getUser());
                            try {
                                autenticacion = t.authenticate(usuario, pass);
                                System.out.println("***auth successful obtenido para: " + autenticacion.Data.Nombres);
                            } catch (Exception ex) {
                                System.out.println("msg println");
                                Logger.getLogger("***Error en autenticación").log(Level.SEVERE, "error en autenticación para:  " + usr.getUser() + ">> " + ex.getMessage());
                            }
                            Logger.getLogger("***fin de auth.").log(Level.SEVERE, "fin de autenticación para: " + usr.getUser());
                            if (autenticacion.Status == 1) {
                                usr.setPassword(encrypt);
                                usr.setUltimoIngreso(new Date());
                                usaDao.actualizar(usr);
                                auth = true;
                            } else {
                                model.addAttribute("mensaje", "Usuario o clave incorrectos");
                            }
                        }
                    } else {//validamos credenciales en servicio NSGA
                        auth = true;
//                        AuthenticationData autenticacion = t.authenticate(usuario, pass);
//                        if (autenticacion.Status == 1) {
//                            usr.setPassword(encrypt);
//                            usr.setUltimoIngreso(new Date());
//                            usaDao.actualizar(usr);
//                            auth = true;
//                        } else {
//                            model.addAttribute("mensaje", "Usuario o clave incorrectos");
//                        }
                    }
                } else {
//                    AuthenticationData autenticacion = t.authenticate(usuario, pass);
//                    if (autenticacion.Status == 1) {
//                        PersonaType p = wsNsga.buscar_persona_cedula_nsga(autenticacion.Data.Identificacion);
                    PersonaType p = wsNsga.buscar_persona_usuario_nsga(usuario);
                    String nombre = p.getPrimerNombre() + " " + p.getSegundoNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido();
                    Usuario us = new Usuario(p.getId(), p.getIdentificacion(), nombre, "", new Date(), Boolean.TRUE);
                    us = usrDao.guardar(us);
                    UsuarioAuth usa = new UsuarioAuth(us, usuario, encrypt, new Date());
                    usr = usaDao.guardar(usa);
                    //Agregamos el rol de innovador:  ROL INNOVADOR = 1
                    RolUsuario ru = rusDao.buscar("rol.id", "usuario.id", 1, us.getId());
                    if (ru == null) {
                        Rol rol = rolDao.buscar(1); //rol innnovador
                        ru = new RolUsuario(rol, us);
                        rusDao.guardar(ru);
                    }
                    auth = true;
//                    } else {
//                        model.addAttribute("mensaje", autenticacion.Message + " : " + autenticacion.Status);
//                    }
                }
                if (auth) {// es innovador
                    String foto = "/bancoideas/recursos/img/user-profile.png";
                    List<Menu> menu = generarMenuUsuario(usr.getUsuario().getId());
                    HttpSession sesion = req.getSession(true);
                    sesion.setAttribute("nombre", usr.getUsuario().getNombre());
                    sesion.setAttribute("username", usr.getUser());
                    sesion.setAttribute("idusuario", usr.getUsuario().getGuid());
                    sesion.setAttribute("cedula", usr.getUsuario().getCedula());

                    sesion.setAttribute("usuario", usr.getUsuario());

                    sesion.setAttribute("menu", menu);
                    List<Convocatoria> convocatorias = conDao.listar();//solo convocatorias activas
                    sesion.setAttribute("convocatorias", convocatorias);
//                    sesion.setAttribute("periodo", conDao.buscar("principal", 1).getPeriodo());

                    //obtenemos la foto del docente desde SICA
                    try {
                        try {
                            String cedula = usr.getUsuario().getCedula();
                            if (cedula.length() > 10) {
                                cedula = cedula.substring(0, 10);
                            }
                            Client cliente = Client.create();
                            WebResource recurso;
                            String URI = "https://sica.utpl.edu.ec/api/persons/" + cedula + "/";
                            recurso = cliente.resource(URI);
                            String resultado = recurso.accept(MediaType.APPLICATION_JSON).get(String.class);
                            org.json.JSONObject resultados = new org.json.JSONObject(resultado);
                            if (!resultados.getString("image").equals("")) {
//                                "https://sica.utpl.edu.ec/media/uploads/fotos/" +
                                foto = resultados.getString("image");
                            }
                        } catch (Exception ex) {
                            System.out.println("");
                        }
                    } catch (Exception ex) {
                        System.out.println("");
                    }
                    int id_conv = -1;
                    try {
                        String fechaActual = format.format(new Date());
                        id_conv = convDao.buscar_id("SELECT convocatoria.id FROM ConvocatoriaResponsable WHERE usuario.id = " + usr.getUsuario().getId() + " AND '" + fechaActual + "' between convocatoria.fechaInicio AND convocatoria.fechaFin");
                    } catch (Exception ex) {
                    }
                    sesion.setAttribute("foto", foto);
                    if (id_conv == -1) {
                        return "redirect:/principal.htm?us=" + usr.getUsuario().getId();
                    } else {
                        return "redirect:/principal.htm?us=" + usr.getUsuario().getId() + "&conv=" + id_conv;
                    }
                } else {// es estudiante
                    model.addAttribute("mensaje", "Usuario o clave incorrectos.!");
                    return "index";
                }
            } else {
                model.addAttribute("mensaje", "Es necesario ingresar el usuario y la clave.");
                return "login";
            }
        } catch (Exception ex2) {
            System.out.println(ex2.getMessage());
            model.addAttribute("mensaje", "No se ha podido autenticar: " + ex2.getMessage());
        }
        return "login";
    }

    public List<Menu> generarMenuUsuario(int usuario) {
        List<Menu> menu = new ArrayList<Menu>();
        List<Funcionalidad> funcionalidades = new ArrayList<Funcionalidad>();

        //encontrar roles del usuario
        List<RolUsuario> roles = rusDao.listar_condicion("usuario.id", usuario);
        //si no tiene roles, entonces le asignamos por defecto rol de innovador
        if (roles.size() == 0) {
            Rol rol = rolDao.buscar(1);
            Usuario usr = usrDao.buscar(usuario);
            RolUsuario ru = new RolUsuario(rol, usr);
            rusDao.guardar(ru);
        }

        if (roles != null && roles.size() > 0) {
            for (RolUsuario ru : roles) {
                //encontrar funcionalidades de cada rol
                List<RolFuncionalidad> rolFuncionalidades = rfuDao.listar_condicion("rol.id", ru.getRol().getId());
                for (RolFuncionalidad rf : rolFuncionalidades) {
                    funcionalidades.add(rf.getFuncionalidad());
//                    funcionalidades.add(new Funcionalidad(rf.getFuncionalidad().getId(), rf.getFuncionalidad().getPadre(), rf.getFuncionalidad().getNombre(), rf.getFuncionalidad().getUrl(), rf.getFuncionalidad().getEstado(), rf.getFuncionalidad().getIcono()));
                }
            }
        } else {
            List<RolFuncionalidad> rolFuncionalidades = rfuDao.listar_condicion("rol.id", 2); // rol estudiante = 2
            for (RolFuncionalidad rf : rolFuncionalidades) {
                funcionalidades.add(rf.getFuncionalidad());
//                funcionalidades.add(new Funcionalidad(rf.getFuncionalidad().getId(), rf.getFuncionalidad().getPadre(), rf.getFuncionalidad().getNombre(), rf.getFuncionalidad().getUrl(), rf.getFuncionalidad().getEstado(), rf.getFuncionalidad().getIcono()));

            }
        }

        List<Funcionalidad> items = new ArrayList<Funcionalidad>();
        if (funcionalidades.size() >= 1) {
            int cont = funcionalidades.size();
            try {
                boolean bol = funcionalidades.get(0).getEstado();
                String pad = funcionalidades.get(0).getPadre();
                for (Funcionalidad f : funcionalidades) {
                    if (f.getPadre().equals("0") && f.getEstado()) {
                        menu.add(new Menu(f, items));
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

            for (Menu m : menu) {
                List<Funcionalidad> funcs = new ArrayList<Funcionalidad>();
                for (Funcionalidad f : funcionalidades) {
                    if (f.getEstado()) {
                        if (f.getPadre().equals(String.valueOf(m.getTitulo().getId()))) {
                            funcs.add(f);
                        }
                    }
                }
                m.setItems(funcs);
            }
        }
        return menu;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
//    @ResponseBody
    public String login(HttpServletRequest req) {
        HttpSession sesion = req.getSession(true);
        sesion.invalidate();
        return "redirect:/";
    }

    @RequestMapping(value = "/nuevousuario", method = RequestMethod.POST)
    public String nuevo_usuario(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
        String exmsg = "";
        try {
            String nombre = new String(req.getParameter("nombres").getBytes("ISO-8859-1"), "UTF-8").trim().toUpperCase();
            String user = req.getParameter("usr");
            String email = new String(req.getParameter("email").getBytes("ISO-8859-1"), "UTF-8").trim();
            UsuarioAuth auth = usaDao.buscar("user", user);

            Usuario us = usrDao.buscar("correo", email);
            if (auth == null && us == null) {
                String password = new String(req.getParameter("password").getBytes("ISO-8859-1"), "UTF-8").trim();
                String encrypt = util.md5(password);
                Usuario usr = usrDao.guardar(new Usuario(null, null, nombre, email, new Date(), Boolean.TRUE));
//            String userpart[] = email.split("@");
                usaDao.guardar(new UsuarioAuth(usr, user, encrypt, null));
                Rol rol = rolDao.buscar(1); // Rol "Usuario"
                rusDao.guardar(new RolUsuario(rol, usr));
                return "redirect://index.htm?action=newuser";
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            exmsg = ex.getMessage();
        }
        Login login = new Login("", "");
        model.addAttribute("login", login);
        model.addAttribute("mensaje", exmsg + "->No se ha creado el usuario. El usuario y/o correo ingresado ya existe");
        return "index";
    }

    //LISTAR CONVOCATORIAS
    @RequestMapping(value = "/convocatorias", method = RequestMethod.GET)
    @ResponseBody
    public String listar_convocatorias(HttpServletRequest req) {
        Gson g = new Gson();
        List<Convocatoria> convs = new ArrayList<>();
        try {
            ConvocatoriaDao convDao = new ConvocatoriaDao();
            convs = convDao.listar();
        } catch (Exception ex) {
        }
        return g.toJson(convs);
    }

    //LISTAR EMPRENDEDORES
    @RequestMapping(value = "/emprendedores", method = RequestMethod.GET)
    @ResponseBody
    public String listar_emprendedores(HttpServletRequest req) {
        Gson g = new Gson();
        List<RolUsuario> usuarios = new ArrayList<>();
        try {
            ConvocatoriaDao convDao = new ConvocatoriaDao();
            usuarios = rusDao.listar_condicion("rol.id", 1);
        } catch (Exception ex) {
        }
        return g.toJson(usuarios);
    }

    //LISTAR EVALUADORES
    @RequestMapping(value = "/evaluadores", method = RequestMethod.GET)
    @ResponseBody
    public String listar_evaluadores(HttpServletRequest req) {
        Gson g = new Gson();
        List<RolUsuario> usuarios = new ArrayList<>();
        try {
            ConvocatoriaDao convDao = new ConvocatoriaDao();
            usuarios = rusDao.listar_condicion("rol.id", 2);
        } catch (Exception ex) {
        }
        return g.toJson(usuarios);
    }

    //LISTAR PATROCINADORES
    @RequestMapping(value = "/patrocinadores", method = RequestMethod.GET)
    @ResponseBody
    public String listar_patrocinadores(HttpServletRequest req) {
        Gson g = new Gson();
        List<RolUsuario> usuarios = new ArrayList<>();
        try {
            ConvocatoriaDao convDao = new ConvocatoriaDao();
            usuarios = rusDao.listar_condicion("rol.id", 3);
        } catch (Exception ex) {
        }
        return g.toJson(usuarios);
    }

//    CONTROLADOR IDEAS ******
    CiiuDao ciiuDao = new CiiuDao();
    AdjuntoDao adjDao = new AdjuntoDao();

    Utiles u = new Utiles();
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @RequestMapping(value = "/idea_index", method = RequestMethod.GET)
    public String idea_index(Model model, HttpServletRequest req) {
        int id_us = Integer.parseInt(req.getParameter("us"));
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());

            String fechaActual = format.format(new Date());
            model.addAttribute("convocatorias", conDao.listar_where(" WHERE '" + fechaActual + "' between fechaInicio AND fechaFin"));
//        ModelAndView mv = new ModelAndView("idea/index");
            List<ItemCatalogo> tipos = itemDao.listar_condicion("catalogo.id", 1); // obtiene los items de los TIPOS de ideas
            List<ItemCatalogo> areas = itemDao.listar_condicion("catalogo.id", 2); // obtiene los items de las AREAS de clasificación de las ideas
            List<ItemCatalogo> mediaTipo = itemDao.listar_condicion("catalogo.id", 4); // obtiene los items de las AREAS de clasificación de las ideas
            List<ItemCatalogo> tiposAdjuntos = itemDao.listar_condicion("catalogo.id", 8); // obtiene los items de los tipos de adjuntos
            model.addAttribute("mediaTipo", mediaTipo);
            model.addAttribute("tipos", tipos);
            model.addAttribute("tipos_adjuntos", tiposAdjuntos);
            model.addAttribute("areas", areas);
            model.addAttribute("fase", "idea");
            model.addAttribute("us", id_us);

            model.addAttribute("nueva", req.getParameter("nueva"));

            List<ItemCatalogo> estadosgestacion = itemDao.listar_condicion("catalogo.id", 7); // obtiene los items de estados de gestación de una idea
            model.addAttribute("estadosgestacion", estadosgestacion);
            int idIdea = -1;
            try {
                idIdea = Integer.parseInt(req.getParameter("id_idea"));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            if (idIdea != -1) {
                Idea idea = ideaDao.buscar(idIdea);
                model.addAttribute("idea", idea);
                List<Adjunto> adjuntos = adjDao.listar_condicion("idea.id", idea.getId());
                model.addAttribute("adjuntos", adjuntos);
            }
            List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
            model.addAttribute("participantes", participantes);

            Login login = new Login("", "");
            model.addAttribute("login", login);

            model.addAttribute("opcion", req.getParameter("opcion"));

            int id_conv = -1;
            try {
                String fa = format.format(new Date());
                id_conv = convDao.buscar_id("SELECT convocatoria.id FROM ConvocatoriaResponsable WHERE usuario.id = " + id_us + " AND '" + fa + "' between convocatoria.fechaInicio AND convocatoria.fechaFin");
            } catch (Exception ex) {
            }
            return "index";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/participante", method = RequestMethod.GET)
    public String participante(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());

            int idIdea = Integer.parseInt(req.getParameter("id_idea"));
            int idUs = Integer.parseInt(req.getParameter("us"));
            Idea idea = ideaDao.buscar(idIdea);
            List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
            List<ItemCatalogo> funcion = itemDao.listar_condicion("catalogo.id", 5); // obtiene los items de las AREAS de clasificación de las ideas
            model.addAttribute("funcion", funcion);
            model.addAttribute("fase", "participante");
            model.addAttribute("participantes", participantes);
            model.addAttribute("idea", idea);
            model.addAttribute("idConv", idea.getConvocatoria().getId());
            model.addAttribute("us", idUs);

            model.addAttribute("nueva", req.getParameter("nueva"));

            Login login = new Login("", "");
            model.addAttribute("login", login);

            model.addAttribute("opcion", req.getParameter("opcion"));

            return "index";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/estadogestacion", method = RequestMethod.GET)
    public String estadogestacion(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());

            int idIdea = Integer.parseInt(req.getParameter("id_idea"));
            int idUs = Integer.parseInt(req.getParameter("us"));

            Idea idea = ideaDao.buscar(idIdea);

            model.addAttribute("fase", "estadogestacion");
            model.addAttribute("idea", idea);
            model.addAttribute("idConv", idea.getConvocatoria().getId());
            model.addAttribute("us", idUs);

            List<ItemCatalogo> estadosgestacion = itemDao.listar_condicion("catalogo.id", 7);//items de estados de gestación de la idea
            model.addAttribute("estadosgestacion", estadosgestacion);

            List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
            model.addAttribute("participantes", participantes);

            model.addAttribute("nueva", req.getParameter("nueva"));

            Login login = new Login("", "");
            model.addAttribute("login", login);

            model.addAttribute("opcion", req.getParameter("opcion"));

            return "index";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/publicar", method = RequestMethod.GET)
    public String publicar(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());

            int idIdea = Integer.parseInt(req.getParameter("id_idea"));
            int idUs = Integer.parseInt(req.getParameter("us"));

            Idea idea = ideaDao.buscar(idIdea);

            model.addAttribute("fase", "publicacion");
            model.addAttribute("idea", idea);
            model.addAttribute("idConv", idea.getConvocatoria().getId());
            model.addAttribute("us", idUs);

            List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
            model.addAttribute("participantes", participantes);

            model.addAttribute("nueva", req.getParameter("nueva"));

            Login login = new Login("", "");
            model.addAttribute("login", login);

            model.addAttribute("opcion", req.getParameter("opcion"));

            return "index";
        }
        return "redirect:/";
    }

//    @RequestMapping(value = "/listar", method = RequestMethod.GET)
//    public String listar(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
//        int id_conv = Integer.parseInt(req.getParameter("id_conv"));
//        List<Idea> ideas = ideaDao.listar_condicion("convocatoria.id", "publicar", id_conv, 1);
//        model.addAttribute("ideas", ideas);
//        Login login = new Login("", "");
//        model.addAttribute("login", login);
//        return "idea/lista";
//    }
    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    @ResponseBody
    public void buscar(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        try {
            String cadena = req.getParameter("cadena");
            String tipo = req.getParameter("tipo");
            String q = "";
            String json = "";
            Gson gson = new Gson();
            JSONArray array = new JSONArray();
            if (tipo.equals("idea_r")) {
                if (!cadena.equals("")) {
                    q = "from Idea a where (a.nombre like '%" + cadena + "%' or a.descripcion like '%" + cadena + "%' or a.kw like '%" + cadena + "%' ) ";
                } else {
                    q = "from Idea a";
                }
                List<Idea> ideas = ideaDao.listar_condicion_query(q);
                json = gson.toJson(ideas);
                for (Idea i : ideas) {
                    JSONObject j = new JSONObject();
                    j.put("id", i.getId());
                    j.put("nombre", i.getNombre());
                    j.put("descripcion", i.getDescripcion());
                    j.put("kw", i.getKw());
                    j.put("imagen", "/bancoideas/recursos/img/utpl.png");
                    array.add(j);
                }
            } else if (tipo.equals("idea_v")) {
                if (!cadena.equals("")) {
                    q = "from Idea a where a.publicar = 1 and (a.nombre like '%" + cadena + "%' or a.descripcion like '%" + cadena + "%' or a.kw like '%" + cadena + "%' ) ";
                } else {
                    q = "from Idea a where a.publicar = 1";
                }
                List<Idea> ideas = ideaDao.listar_condicion_query(q);
                json = gson.toJson(ideas);
                for (Idea i : ideas) {
                    JSONObject j = new JSONObject();
                    j.put("id", i.getId());
                    j.put("nombre", i.getNombre());
                    j.put("descripcion", i.getDescripcion());
                    j.put("kw", i.getKw());
                    j.put("imagen", "/bancoideas/recursos/img/logo.png");
                    array.add(j);
                }
            } else if (tipo.equals("innovador")) {
                if (!cadena.equals("")) {
                    q = "from Participante p where p.nombre like '%" + cadena + "%' ";
                } else {
                    q = "from Participante p";
                }
                List<Participante> participantes = partDao.listar_condicion_query(q);
                for (Participante p : participantes) {
                    JSONObject j = new JSONObject();
                    j.put("id", p.getId());
                    j.put("nombre", p.getNombre());
                    j.put("descripcion", p.getUsuario().getCorreo() + "<br/>" + p.getUsuario().getRegister());
                    j.put("kw", "rol: " + p.getItemCatalogo().getNombre());
                    j.put("imagen", "/bancoideas/recursos/img/user-profile.png");
                    array.add(j);
                }
                /**
                 * ********************
                 */
                if (!cadena.equals("")) {
                    q = "from Idea i where i.usuario.nombre like '%" + cadena + "%' ";
                } else {
                    q = "from Idea i";
                }
                List<Idea> innovadores = ideaDao.listar_condicion_query(q);
                for (Idea i : innovadores) {
                    JSONObject j = new JSONObject();
                    j.put("id", i.getUsuario().getId());
                    j.put("nombre", i.getUsuario().getNombre());
                    j.put("descripcion", i.getUsuario().getCorreo() + "<br/>" + i.getUsuario().getRegister());
                    j.put("kw", "idea: " + i.getNombre());
                    j.put("imagen", "/bancoideas/recursos/img/user-profile.png");
                    array.add(j);
                }
            } else if (tipo.equals("evaluador")) {
                if (!cadena.equals("")) {
                    q = "from ConvocatoriaResponsable cr where cr.usuario.nombre like '%" + cadena + "%' ";
                } else {
                    q = "from ConvocatoriaResponsable cr";
                }
                List<ConvocatoriaResponsable> evaluadores = convrDao.listar_condicion_query(q);
                for (ConvocatoriaResponsable cr : evaluadores) {
                    JSONObject j = new JSONObject();
                    j.put("id", cr.getId());
                    j.put("nombre", cr.getUsuario().getNombre());
                    j.put("descripcion", cr.getUsuario().getCorreo() + "<br/>" + cr.getUsuario().getRegister());
                    j.put("kw", "convocatoria: " + cr.getConvocatoria().getNombre());
                    j.put("imagen", "/bancoideas/recursos/img/user-profile.png");
                    array.add(j);
                }
            } else if (tipo.equals("convocatoria")) {
                if (!cadena.equals("")) {
                    q = "from Convocatoria c where c.nombre like '%" + cadena + "%' ";
                } else {
                    q = "from Convocatoria c";
                }
                List<Convocatoria> convocatorias = convDao.listar_condicion_query(q);
                for (Convocatoria c : convocatorias) {
                    JSONObject j = new JSONObject();
                    j.put("id", c.getId());
                    j.put("nombre", c.getNombre());
                    j.put("descripcion", "inicio: " + c.getFechaInicio() + "<br/>" + "fin: " + c.getFechaFin());
                    j.put("kw", c.getDescripcion());
                    j.put("imagen", c.getImagen());
                    array.add(j);
                }
            }
            json = gson.toJson(array);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
//            JSONArray array = new JSONArray();
//            for (Idea idea : ideas) {
//                JSONObject json = new JSONObject();
//                json.put("id", idea.getId());
//                json.put("nombre", idea.getNombre());
//                json.put("descripcion", idea.getDescripcion());
//                json.put("kw", idea.getKw());
//                json.put("imagen", idea.getImagen());
//                array.add(json);
//            }
//            Gson gson = new Gson();
//            String result =  gson.toJson(array);
//            return new String(result.getBytes("ISO-8859-1"), "UTF-8");
        } catch (Exception ex) {

        }
//        return null;
    }

    @RequestMapping(value = "/buscarporid", method = RequestMethod.GET)
    @ResponseBody
    public void buscarporid(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");
        int id_idea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(id_idea);
        Gson gson = new Gson();
        String json = gson.toJson(idea);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
    public String guardar(HttpServletRequest req, Model model, @ModelAttribute("idea") FileUploadMD archivo
    ) throws UnsupportedEncodingException, IOException {
        int idUs = Integer.parseInt(req.getParameter("id_us"));
        int idIdea = -1;
        try {
            idIdea = Integer.parseInt(req.getParameter("id_idea"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        Idea idea = new Idea();
        if (idIdea != -1) {
            idea = ideaDao.buscar(idIdea);
        }
        try {
            int idConv = Integer.parseInt(req.getParameter("conv"));
            Convocatoria conv = convDao.buscar(idConv);

            String nombre = new String(req.getParameter("nombre").getBytes("ISO-8859-1"), "UTF-8");
            String descripcion = new String(req.getParameter("descripcion").getBytes("ISO-8859-1"), "UTF-8");

            String imgNombre = "utpl.png";
            try {
                Utiles u = new Utiles();
                if (archivo.getImagen().getSize() > 0) {
                    imgNombre = u.guardarArchivo(archivo.getImagen());
                }
            } catch (Exception ex) {
            }
            String lugar = new String(req.getParameter("lugar").getBytes("ISO-8859-1"), "UTF-8");
            String kw = new String(req.getParameter("kw").getBytes("ISO-8859-1"), "UTF-8");
            int tipoIdea = Integer.parseInt(req.getParameter("opcion"));
            idea.setNombre(nombre);
            idea.setDescripcion(descripcion);
            idea.setKw(kw);
            idea.setLugar(lugar);
            idea.setConvocatoria(conv);
            idea.setRegister(new Date());
            idea.setTipoIdea(tipoIdea);
            ItemCatalogo icEstado = itemDao.buscar(7);//estado REGISTRADA
            idea.setItemCatalogoByEstado(icEstado);
            Usuario us = usrDao.buscar(idUs);
            idea.setUsuario(us);
            idea.setPublicar(Boolean.FALSE); //cuando el responsable de la convocatoria evalúe la idea, se hará publica
            if (tipoIdea == 1) {//idea con datos básicos
                if (idIdea == -1) {
                    idea.setImagen(imgNombre);
                    idea = ideaDao.guardar(idea);
                } else if (idIdea != -1) {
                    if (!imgNombre.equals("utpl.png")) {
                        idea.setImagen(imgNombre);
                    }
                    idea = ideaDao.actualizar(idea);
                }
            } else if (tipoIdea == 2) {
                String objetivo = new String(req.getParameter("objetivo").getBytes("ISO-8859-1"), "UTF-8");
                String mercado = new String(req.getParameter("mercado").getBytes("ISO-8859-1"), "UTF-8");

                int tipo = Integer.parseInt(req.getParameter("tipo"));
                String ciiu = req.getParameter("ciiu");
                Ciiu itemCiiu = null;
                if (!ciiu.equals("")) {
                    itemCiiu = ciiuDao.buscar(Integer.parseInt(ciiu));
                }
                ItemCatalogo icTipo = itemDao.buscar(tipo);

                idea.setObjetivo(objetivo);
                idea.setMercadoPotencial(mercado);

                idea.setCiiu(itemCiiu);
                idea.setItemCatalogoByTipo(icTipo);

                if (idIdea == -1) {
                    idea.setImagen(imgNombre);
                    idea = ideaDao.guardar(idea);
                } else if (idIdea != -1) {
                    if (!imgNombre.equals("utpl.png")) {
                        idea.setImagen(imgNombre);
                    }
                    idea = ideaDao.actualizar(idea);
                }
            }
            //guardamos adjuntos
            Adjunto adj = null;
            try {
                ItemCatalogo adjArchivo = itemDao.buscar(43); // adjunto tipo archivo
                if (archivo.getAdjuntos() != null) {
                    adj = new Adjunto();
                    for (MultipartFile adjunto : archivo.getAdjuntos()) {
                        if (adjunto.getSize() > 0) {
                            String nombre_adjunto = u.guardarArchivo(adjunto);
                            adj.setIdea(idea);
                            adj.setNombre(nombre_adjunto);
                            adj.setRegister(new Date());
                            adj.setItemCatalogo(adjArchivo);
                            adjDao.guardar(adj);
                        }
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                ItemCatalogo adjFacebook = itemDao.buscar(44); // adjunto tipo facebook
                for (String item : archivo.getFacebook()) {
                    if (!item.equals("")) {
                        adj.setIdea(idea);
                        adj.setNombre(item);
                        adj.setRegister(new Date());
                        adj.setItemCatalogo(adjFacebook);
                        adjDao.guardar(adj);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                ItemCatalogo adjTwitter = itemDao.buscar(45); // adjunto tipo twitter
                for (String item : archivo.getTwitter()) {
                    if (!item.equals("")) {
                        adj.setIdea(idea);
                        adj.setNombre(item);
                        adj.setRegister(new Date());
                        adj.setItemCatalogo(adjTwitter);
                        adjDao.guardar(adj);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            try {
                ItemCatalogo adjYoutube = itemDao.buscar(46); // adjunto tipo youtube
                for (String item : archivo.getYoutube()) {
                    if (!item.equals("")) {
                        adj.setIdea(idea);
                        adj.setNombre(item);
                        adj.setRegister(new Date());
                        adj.setItemCatalogo(adjYoutube);
                        adjDao.guardar(adj);
                    }
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        if (idea.getTipoIdea() == 1) {
            return "redirect:/principal.htm?us=" + idUs;
        } else {
            return "redirect:/idea_index.htm?us=" + idUs + "&id_idea=" + idea.getId() + "&nueva=true&opcion=" + idea.getTipoIdea();
        }
    }

    @RequestMapping(value = "/agregarParticipante", method = RequestMethod.POST)
    public String agregarParticipante(Model model, HttpServletRequest req) throws UnsupportedEncodingException, IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage, IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);

        String nombre = req.getParameter("pnombre");
        String identificacion = req.getParameter("pidentificacion");
//        String usuario = req.getParameter("pusuario");
        int funcion = Integer.parseInt(req.getParameter("funcion"));
        ItemCatalogo icFuncion = itemDao.buscar(funcion);

        Usuario existe = usrDao.buscar("cedula", identificacion);
        if (existe == null) {
            PersonaType p = wsNsga.buscar_persona_cedula_nsga(identificacion);
            if (p != null) {
                existe = new Usuario();
                String persona = p.getPrimerNombre() + " " + p.getSegundoNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido();
                existe.setGuid(p.getId());
                existe.setCedula(p.getIdentificacion());
                existe.setNombre(nombre);
                existe.setEstado(Boolean.TRUE);
                existe.setRegister(new Date());
                List<CorreoType> correos = p.getCorreos();
                for (CorreoType correo : correos) {
                    if (correo.getCorreo().contains("@utpl.edu.ec")) {
                        existe.setCorreo(correo.getCorreo());
                    } else {
                        existe.setCorreo(correo.getCorreo());
                    }
                }
                existe = usrDao.guardar(existe);
            }
        }

        Participante part = new Participante();
        part.setIdea(idea);
        part.setItemCatalogo(icFuncion);
        part.setUsuario(existe);
        part.setNombre(nombre);

        part = partDao.guardar(part);
//        return "redirect://idea/estadogestacion.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idIdea;
        return "redirect:/participante.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idea.getId() + "&nueva=true&opcion=" + idea.getTipoIdea();
    }

    @RequestMapping(value = "/estadogestacion", method = RequestMethod.POST)
    public String estadogestacion_guardar(Model model, HttpServletRequest req) throws UnsupportedEncodingException, IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage, IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);
        String comentario = req.getParameter("estadoComentario");
        int eg = Integer.parseInt(req.getParameter("eg"));
        ItemCatalogo ic_eg = itemDao.buscar(eg);
        idea.setItemCatalogoByEstadoGestacion(ic_eg);
        idea.setEstadoComentario(comentario);
        ideaDao.actualizar(idea);
        return "redirect:/publicar.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idIdea + "&nueva=true&opcion=" + idea.getTipoIdea();
    }

    @RequestMapping(value = "/publicar", method = RequestMethod.POST)
    public String publicar_guardar(Model model, HttpServletRequest req) throws UnsupportedEncodingException, IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage, IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);
        idea.setPublicar(Boolean.TRUE);
        ideaDao.actualizar(idea);
        return "redirect:/publicar.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idIdea + "&nueva=true&opcion=" + idea.getTipoIdea();
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public String eliminarIdea(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        int idUs = Integer.parseInt(req.getParameter("us"));
        //eliminamos participantes
        List<Participante> part = partDao.listar_condicion("idea.id", idIdea);
        for (Participante p : part) {
            partDao.eliminar(p.getId());
        }
        List<Adjunto> adj = adjDao.listar_condicion("idea.id", idIdea);
        for (Adjunto a : adj) {
            adjDao.eliminar(a.getId());
        }
        //se elimina la idea
        ideaDao.eliminar(idIdea);
        return "redirect://principal.htm?us=" + idUs;
    }

    @RequestMapping(value = "/eliminarParticipante", method = RequestMethod.POST)
    public String eliminarParticipante(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);
        int idPart = Integer.parseInt(req.getParameter("id_part"));
        int idUs = Integer.parseInt(req.getParameter("us"));
        partDao.eliminar(idPart);
        return "redirect:/participante.htm?id_idea=" + idIdea + "&us=" + idUs + "&nueva=true&opcion=" + idea.getTipoIdea();
    }

    @RequestMapping(value = "/buscarpersona", method = RequestMethod.GET)
    @ResponseBody
    public void obtener_usuario_nsga(@RequestParam("valor") String valor,
            @RequestParam("opcion") String opcion, HttpServletResponse response
    ) {
        try {
            response.setContentType("application/json;charset=utf-8");
            PersonaType p = null;
            if (opcion.equals("id")) {
                p = wsNsga.buscar_persona_cedula_nsga(valor);
            } else if (opcion.equals("us")) {
                p = wsNsga.buscar_persona_usuario_nsga(valor);
            }

            Usuario us = new Usuario();
            if (p != null) {
                String nombre = p.getPrimerNombre() + " " + p.getSegundoNombre() + " " + p.getPrimerApellido() + " " + p.getSegundoApellido();
                us.setCedula(p.getIdentificacion());
                us.setNombre(nombre);
            }
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(us);
            PrintWriter out = response.getWriter();
            out.print(json);
            out.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        IdeaController ic = new IdeaController();
        ic.ejecutar();
    }

    public void ejecutar() {
        List<ItemCatalogo> tipos = itemDao.listar_condicion("id", 1);
        System.out.println(tipos.size());
    }

//    @RequestMapping(value = "/listitem", method = RequestMethod.GET)
//    @ResponseBody
//    public void listitem(Model model, HttpServletRequest req, HttpServletResponse response) {
//        response.setContentType("application/json;charset=utf-8");
//        JSONObject json = new JSONObject();
//        Gson g = new Gson();
//        try {
//            String cadena = new String(req.getParameter("term").getBytes("ISO-8859-1"), "UTF-8");
//            List<Ciiu> lista = ciiuDao.listar_condicion_query("from Ciiu c where c.nombre like '%" + cadena + "%'");
//            String result = new String(g.toJson(lista).getBytes("ISO-8859-1"), "UTF-8");
//            PrintWriter out = response.getWriter();
//            out.print(result);
//            out.flush();
//        } catch (Exception ex) {
//
//        }
//    }
    @RequestMapping(value = "/listitem", method = RequestMethod.GET)
    @ResponseBody
    public void listitem(Model model, HttpServletRequest req, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        JSONObject json = new JSONObject();
        Gson g = new Gson();
        try {
            String cadena = "";
            try {
                cadena = new String(req.getParameter("term").getBytes("ISO-8859-1"), "UTF-8");
            } catch (Exception ex) {
            }

            List<Ciiu> lista = null;
            if (!cadena.equals("")) {
                lista = ciiuDao.listar_condicion_query("from Ciiu c where c.nombre like '%" + cadena + "%'");
            } else {
                lista = ciiuDao.listar();
            }
            String result = g.toJson(lista);//new String(g.toJson(lista).getBytes("UTF-8")); // 
            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        } catch (Exception ex) {

        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public void uploadFile(@Valid
            @ModelAttribute("archivo") FileUploadMD archivo,
            Model model) throws UnsupportedEncodingException, IOException {
        if (archivo.getImagen() != null) {
            //Se crea el directorio en el servidor si aún no ha sido creado
            File directorio = new File(localPath);
            if (!directorio.exists()) {
                directorio.mkdir();
            }

            //subimos el nuevo archivo al servidor 
            InputStream inputStream = null;
            OutputStream outputStream = null;
            MultipartFile multipartFile = archivo.getImagen();
            String fileNombre = new String(multipartFile.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
            int posUltima = fileNombre.lastIndexOf(".");
//            String partes[] = fileNombre.split("\\.");
            String nombre = fileNombre.substring(0, posUltima + 1);//partes[0];
            String tipo = fileNombre.substring(posUltima, fileNombre.length());//partes[1];

            if (fileNombre != null) {
                int cont = 1;
                while (encontrarArchivo(localPath, fileNombre)) {
                    fileNombre = nombre + "_" + cont + "." + tipo;
                    cont++;
                }
                try {
                    inputStream = multipartFile.getInputStream();
                    String dir = localPath + fileNombre;
                    File newFile = new File(dir);
                    newFile.createNewFile();
                    outputStream = new FileOutputStream(newFile);

                    int read = 0;
                    byte[] bytes = new byte[1024];
                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }
                    outputStream.flush();
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean encontrarArchivo(String carpeta, String nombre_archivo) throws IOException {
        File directorio = new File(carpeta);
        File[] archivos = directorio.listFiles();
        for (File f : archivos) {
            if (f.isFile()) {
                if (!f.getName().equals(".DS_Store")) {
                    if (f.getName().equals(nombre_archivo)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public void items(Model model, HttpServletRequest req, HttpServletResponse response) {
        response.setContentType("application/json;charset=utf-8");
        try {
            List<Ciiu> items = ciiuDao.listar(" order by id asc");
            List<ItemEstructura> jerarquia = new ArrayList<ItemEstructura>();
            boolean inicio = true;
            for (Ciiu i : items) {
                for (ItemEstructura raiz : jerarquia) {
                    ItemEstructura item = new ItemEstructura(i.getId(), i.getNombre(), "", "0", "", false, "white", new ArrayList<ItemEstructura>(), 0);
                    if (i.getPadre() == raiz.getId()) {
                        raiz.getChildren().add(item);
                    } else {
                        for (ItemEstructura n1 : raiz.getChildren()) {
                            if (i.getPadre() == n1.getId()) {
                                n1.getChildren().add(item);
                            } else {
                                for (ItemEstructura n2 : n1.getChildren()) {
                                    if (i.getPadre() == n2.getId()) {
                                        n2.getChildren().add(item);
                                    } else {
                                        for (ItemEstructura n3 : n2.getChildren()) {
                                            if (i.getPadre() == n3.getId()) {
                                                n3.getChildren().add(item);
                                            } else {
                                                for (ItemEstructura n4 : n3.getChildren()) {
                                                    if (i.getPadre() == n4.getId()) {
                                                        n4.getChildren().add(item);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (inicio) {
                    jerarquia.add(new ItemEstructura(i.getId(), i.getNombre(), "", "0", "glyphicon glyphicon-home", true, "white", new ArrayList<ItemEstructura>(), 0));
                    inicio = false;
                }
            }
            String result = g.toJson(jerarquia);
            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

//    @RequestMapping(value = "/eliminar_imagen", method = RequestMethod.POST)
//    @ResponseBody
//    public void eliminar_imagen(String id_idea) {
//        try{
//            Idea idea = ideaDao.buscar(Integer.parseInt(id_idea));
//            idea.setImagen("");
//            ideaDao.actualizar(idea);
//        }catch(Exception ex){
//            
//        }
//    }
//    
//    @RequestMapping(value = "/eliminar_adjunto", method = RequestMethod.POST)
//    @ResponseBody
//    public void eliminar_adjuntos(String id_adjunto) {
//        try{
//            adjDao.eliminar(Integer.parseInt(id_adjunto));
//        }catch(Exception ex){
//            
//        }
//    }
//    
//    @RequestMapping(value = "/removefile", method = RequestMethod.POST, consumes = "application/json", produces = MediaType.TEXT_HTML)
//    public String removefile(String archivo) {
//        File file = new File(localPath + archivo);
//        file.delete();
//        return "OK";
//    }
    @RequestMapping(value = "/eliminar_imagen", method = RequestMethod.GET)
    @ResponseBody
    public void eliminar_imagen(HttpServletRequest req) {
        try {
            Idea idea = ideaDao.buscar(Integer.parseInt(req.getParameter("id_idea")));
            idea.setImagen("");
            ideaDao.actualizar(idea);
        } catch (Exception ex) {

        }
    }

    @RequestMapping(value = "/eliminar_adjunto", method = RequestMethod.GET)
    @ResponseBody
    public void eliminar_adjuntos(HttpServletRequest req) {
        try {
            adjDao.eliminar(Integer.parseInt(req.getParameter("id_adjunto")));
        } catch (Exception ex) {

        }
    }

    @RequestMapping(value = "/removefile", method = RequestMethod.GET)
    @ResponseBody
    public void removefile(HttpServletRequest req) {
        File file = new File(localPath + req.getParameter("nombre"));
        file.delete();
    }

    @RequestMapping(value = "/evaluar", method = RequestMethod.POST)
    public String evaluarIdea(Model model, HttpServletRequest req) throws UnsupportedEncodingException {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        int idUs = Integer.parseInt(req.getParameter("us"));
        String comentario = new String(req.getParameter("comentario").getBytes("ISO-8859-1"), "UTF-8");
        Idea idea = ideaDao.buscar(idIdea);
        if (idea != null) {
            ItemCatalogo estado = itemDao.buscar(8);
            idea.setPublicar(true);
            idea.setItemCatalogoByEstado(estado);
            idea.setComentarioEvaluacion(comentario);
            ideaDao.actualizar(idea);
        }
        int id_conv = -1;
        try {
            String fechaActual = format.format(new Date());
            id_conv = convDao.buscar_id("SELECT convocatoria.id FROM ConvocatoriaResponsable WHERE usuario.id = " + idUs + " AND '" + fechaActual + "' between convocatoria.fechaInicio AND convocatoria.fechaFin");
        } catch (Exception ex) {
        }
        return "redirect://principal.htm?us=" + idUs + "&conv=" + id_conv;
    }
}
