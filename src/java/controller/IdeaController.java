/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.*;
import estructura.FileUploadMD;
import estructura.ItemEstructura;
import estructura.Login;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import model.*;
import net.sf.json.JSONObject;
import nsga.persona.CorreoType;
import nsga.persona.IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage;
import nsga.persona.IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage;
import nsga.persona.PersonaType;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.codehaus.jettison.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/idea")
public class IdeaController {

    ConvocatoriaDao convDao = new ConvocatoriaDao();
    IdeaDao ideaDao = new IdeaDao();
    ItemCatalogoDao itemDao = new ItemCatalogoDao();
    NsgaSoapDao wsNsga = new NsgaSoapDao();
    UsuarioDao usrDao = new UsuarioDao();
    ParticipanteDao partDao = new ParticipanteDao();
    CiiuDao ciiuDao = new CiiuDao();
    Utiles util = new Utiles();
    AdjuntoDao adjDao = new AdjuntoDao();

    Utiles u = new Utiles();
    Gson g = new Gson();

//    String localPath = "/Users/utpl/bancoideas/";
    String localPath = "/app/glassfish/glassfish4/glassfish/domains/domain1/applications/bancoideas/";

//    private static final String SERVER_UPLOAD_OFERTA_LOCATION_FOLDER = "/app/glassfish/glassfish4/glassfish/domains/domain1/applications/opencampus/";
//    private static final String URL = "http://dataviz.utpl.edu.ec/opencampus/revisar.htm";
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest req) {
        int id_us = Integer.parseInt(req.getParameter("us"));
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());
        }
        model.addAttribute("convocatorias", session.getAttribute("convocatorias"));
//        ModelAndView mv = new ModelAndView("idea/index");
        List<ItemCatalogo> tipos = itemDao.listar_condicion("catalogo.id", 1); // obtiene los items de los TIPOS de ideas
        List<ItemCatalogo> areas = itemDao.listar_condicion("catalogo.id", 2); // obtiene los items de las AREAS de clasificación de las ideas
        List<ItemCatalogo> mediaTipo = itemDao.listar_condicion("catalogo.id", 4); // obtiene los items de las AREAS de clasificación de las ideas
        model.addAttribute("mediaTipo", mediaTipo);
        model.addAttribute("tipos", tipos);
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
        }
        List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
        model.addAttribute("participantes", participantes);

        Login login = new Login("", "");
        model.addAttribute("login", login);

//        return "idea/index";
        return "../index";
    }

    @RequestMapping(value = "/participante", method = RequestMethod.GET)
    public String participante(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());
        }
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

        Login login = new Login("", "");
        model.addAttribute("login", login);

        return "idea/index";
    }

    @RequestMapping(value = "/estadogestacion", method = RequestMethod.GET)
    public String estadogestacion(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());
        }
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

        Login login = new Login("", "");
        model.addAttribute("login", login);

        return "idea/index";
    }

    @RequestMapping(value = "/publicar", method = RequestMethod.GET)
    public String publicar(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession(true);
        if (session.getAttribute("menu") != null) {
            model.addAttribute("nombre", session.getAttribute("nombre").toString());
            model.addAttribute("menu", session.getAttribute("menu"));
            model.addAttribute("foto", session.getAttribute("foto").toString());
        }
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        int idUs = Integer.parseInt(req.getParameter("us"));

        Idea idea = ideaDao.buscar(idIdea);

        model.addAttribute("fase", "publicacion");
        model.addAttribute("idea", idea);
        model.addAttribute("idConv", idea.getConvocatoria().getId());
        model.addAttribute("us", idUs);

        List<Participante> participantes = partDao.listar_condicion("idea.id", idIdea);
        model.addAttribute("participantes", participantes);

        Login login = new Login("", "");
        model.addAttribute("login", login);

        return "idea/index";
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        int id_conv = Integer.parseInt(req.getParameter("id_conv"));
        List<Idea> ideas = ideaDao.listar_condicion("convocatoria.id", "publicar", id_conv, 1);
        model.addAttribute("ideas", ideas);
        Login login = new Login("", "");
        model.addAttribute("login", login);
        return "idea/lista";
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    @ResponseBody
    public void buscar(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        String cadena = req.getParameter("cadena");
        String q = "from Idea a where a.publicar = 1 and (a.nombre like '%" + cadena + "%' or a.descripcion like '%" + cadena + "%' or a.kw like '%" + cadena + "%' ) ";

        List<Idea> ideas = ideaDao.listar_condicion_query(q);

//        JSONObject json = new JSONObject();
//        json.put("results", ideas.size());
//        json.put("data", ideas);
        Gson gson = new Gson();
        String json = gson.toJson(ideas);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @RequestMapping(value = "/buscarporid", method = RequestMethod.GET)
    @ResponseBody
    public void buscarporid(Model model, HttpServletRequest req, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        int id_idea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(id_idea);
        Gson gson = new Gson();
        String json = gson.toJson(idea);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
//    @ResponseBody
    public String guardar(@RequestParam("imagen") MultipartFile imagen, @RequestParam("adjuntos") MultipartFile adj, Model model, HttpServletRequest req) throws UnsupportedEncodingException {
        String imgNombre = "utpl.png";
        String adjuntos = "";
        try {
            Utiles u = new Utiles();
            u.guardarArchivo(imagen);
            u.guardarArchivo(adj);
            imgNombre = "nuevaimagen";
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List items = upload.parseRequest(req);
            for (Object item : items) {
                FileItem uploaded = (FileItem) item;
                if (!uploaded.isFormField()) {
                    // No es campo de formulario, guardamos el fichero en algún sitio
                    if (!uploaded.getName().equals("")) {
                        String nombre = uploaded.getName();
                        String tipo = uploaded.getContentType();

                        if (nombre != null) {
                            int cont = 1;
                            while (encontrarArchivo(localPath, nombre)) {
                                nombre = nombre + "_" + cont + "." + "png";
                                cont++;
                            }
                        }
                        File fichero = new File(localPath, nombre);
                        uploaded.write(fichero);
                        if (uploaded.getFieldName().equals("imagen")) {
                            imgNombre = nombre;
                        }
                        if (uploaded.getFieldName().equals("adjuntos")) {

                        }
                    }
                }
            }
        } catch (Exception ex) {

        }

        int idConv = Integer.parseInt(req.getParameter("conv"));
        Convocatoria conv = convDao.buscar(idConv);
        int idUs = Integer.parseInt(req.getParameter("id_us"));
        int idIdea = -1;
        try {
            idIdea = Integer.parseInt(req.getParameter("id_idea"));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            if (req.getParameter("imagen") != null) {
                imgNombre = req.getParameter("imagen");
            }
        } catch (Exception ex) {
        }
        //guardamos adjunto si es que existe
        try {
            if (req.getParameter("adjuntos") != null) {
                adjuntos = req.getParameter("adjuntos");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        String nombre = new String(req.getParameter("nombre").getBytes("ISO-8859-1"), "UTF-8") + " ..";
        String descripcion = new String(req.getParameter("descripcion").getBytes("ISO-8859-1"), "UTF-8");
        String objetivo = new String(req.getParameter("objetivo").getBytes("ISO-8859-1"), "UTF-8");
        String mercado = new String(req.getParameter("mercado").getBytes("ISO-8859-1"), "UTF-8");
        String lugar = new String(req.getParameter("lugar").getBytes("ISO-8859-1"), "UTF-8");
        String kw = new String(req.getParameter("kw").getBytes("ISO-8859-1"), "UTF-8");

        String facebook = new String(req.getParameter("facebook").getBytes("ISO-8859-1"), "UTF-8");
        String twitter = new String(req.getParameter("twitter").getBytes("ISO-8859-1"), "UTF-8");
        String youtube = new String(req.getParameter("youtube").getBytes("ISO-8859-1"), "UTF-8");

        int tipo = Integer.parseInt(req.getParameter("tipo"));
        String ciiu = req.getParameter("ciiu");
        Ciiu itemCiiu = ciiuDao.buscar("nombre", ciiu);
        ItemCatalogo icTipo = itemDao.buscar(tipo);
        ItemCatalogo icEstado = itemDao.buscar(7);//estado REGISTRADA
        Usuario us = usrDao.buscar(idUs);

        Idea idea = new Idea();
        if (idIdea != -1) {
            idea = ideaDao.buscar(idIdea);
        }
        idea.setNombre(nombre);
        idea.setDescripcion(descripcion);
        idea.setObjetivo(objetivo);
        idea.setMercadoPotencial(mercado);
        idea.setLugar(lugar);
        idea.setKw(kw);
        idea.setPublicar(Boolean.FALSE);
        idea.setImagen(imgNombre);

        idea.setFacebook(facebook);
        idea.setTwitter(twitter);
        idea.setYoutube(youtube);

        idea.setConvocatoria(conv);
        idea.setRegister(new Date());
        idea.setCiiu(itemCiiu);
        idea.setItemCatalogoByEstado(icEstado);
        idea.setItemCatalogoByTipo(icTipo);
        idea.setUsuario(us);

        if (idIdea == -1) {
            idea = ideaDao.guardar(idea);
        } else if (idIdea != -1) {
            idea = ideaDao.actualizar(idea);
        }
        Adjunto ad = new Adjunto();
        ad.setIdea(idea);
        ad.setNombre(adjuntos);
        adjDao.guardar(ad);
        return "ok";
//        return "redirect:/idea/participante.htm?us=" + idUs + "&id_idea=" + idea.getId() + "&test";
    }
//    @RequestMapping(value = "/guardar", method = RequestMethod.POST)
////    public String guardar(Model model, HttpServletRequest req, @RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {
//    public String guardar(@Valid @ModelAttribute("idea") FileUploadMD archivo, Model model, HttpServletRequest req) throws UnsupportedEncodingException {
//        int idConv = Integer.parseInt(req.getParameter("conv"));
//        Convocatoria conv = convDao.buscar(idConv);
//        int idUs = Integer.parseInt(req.getParameter("id_us"));
//        int idIdea = -1;
//        try {
//            idIdea = Integer.parseInt(req.getParameter("id_idea"));
//        } catch (Exception ex) {
//            System.out.println(ex.getMessage());
//        }
//
//        String imgNombre = "logo_utpl.png";
////        try {
////            if (req.getParameter("file") != null) {
//////                imgNombre = util.guardarArchivo((MultipartFile)req.getParameter("file"));
////            }
////        } catch (Exception ex) {
////        }
//        //guardamos adjunto si es que existe
////        String adjunto = "";
////        try {
////            if (archivo.getFileAdjunto() != null) {
////                adjunto = util.guardarArchivo(archivo.getFileAdjunto());
////            }
////        } catch (Exception ex) {
////            System.out.println(ex.getMessage());
////        }
//        String nombre = new String(req.getParameter("nombre").getBytes("ISO-8859-1"), "UTF-8");
//        String descripcion = new String(req.getParameter("descripcion").getBytes("ISO-8859-1"), "UTF-8");
//        String objetivo = new String(req.getParameter("objetivo").getBytes("ISO-8859-1"), "UTF-8");
//        String mercado = new String(req.getParameter("mercado").getBytes("ISO-8859-1"), "UTF-8");
//        String lugar = new String(req.getParameter("lugar").getBytes("ISO-8859-1"), "UTF-8");
//        String kw = new String(req.getParameter("kw").getBytes("ISO-8859-1"), "UTF-8");
//
//        String facebook = new String(req.getParameter("facebook").getBytes("ISO-8859-1"), "UTF-8");
//        String twitter = new String(req.getParameter("twitter").getBytes("ISO-8859-1"), "UTF-8");
//        String youtube = new String(req.getParameter("youtube").getBytes("ISO-8859-1"), "UTF-8");
//
//        int tipo = Integer.parseInt(req.getParameter("tipo"));
//        String ciiu = req.getParameter("ciiu");
//        Ciiu itemCiiu = ciiuDao.buscar("nombre", ciiu);
//        ItemCatalogo icTipo = itemDao.buscar(tipo);
//        ItemCatalogo icEstado = itemDao.buscar(7);//estado REGISTRADA
//        Usuario us = usrDao.buscar(idUs);
//
//        Idea idea = new Idea();
//        if (idIdea != -1) {
//            idea = ideaDao.buscar(idIdea);
//        }
//        idea.setNombre(nombre);
//        idea.setDescripcion(descripcion);
//        idea.setObjetivo(objetivo);
//        idea.setMercadoPotencial(mercado);
//        idea.setLugar(lugar);
//        idea.setKw(kw);
//        idea.setPublicar(Boolean.FALSE);
//        idea.setImagen("utpl.png");
//
//        idea.setFacebook(facebook);
//        idea.setTwitter(twitter);
//        idea.setYoutube(youtube);
//
//        idea.setConvocatoria(conv);
//        idea.setRegister(new Date());
//        idea.setCiiu(itemCiiu);
//        idea.setItemCatalogoByEstado(icEstado);
//        idea.setItemCatalogoByTipo(icTipo);
//        idea.setUsuario(us);
//
//        idea.setImagen(imgNombre);
//
//        if (idIdea == -1) {
//            idea = ideaDao.guardar(idea);
//        } else if (idIdea != -1) {
//            idea = ideaDao.actualizar(idea);
//        }
//        Adjunto adj = new Adjunto();
//        adj.setIdea(idea);
////        adj.setNombre(adjunto);
//        adjDao.guardar(adj);
//        return "redirect://idea/participante.htm?us=" + idUs + "&id_idea=" + idea.getId();
////        return "redirect://idea/index.htm?id_conv=" + idConv + "&id_idea=" + idea.getId();
//    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String uploadFile(@Valid
            @ModelAttribute("archivo") FileUploadMD archivo, Model model
    ) throws IOException,
            JSONException {

        //SI FORMATO ES IMAGEN GUARDARLA EN IMAGEN IDENTIFICATIVA TABLA IDEA
        //SI FORMATO ES PDF GUARDARLA COMO ADJUNTO CON EL ID DE LA IDEA
        //CUANDO GUARDO LAS IMAGENES, SE DEBE RETORNAR EL NOMBRE  PARA LUEGO ENVIARLAS EN EL FORM Y GUARDAR EN LA TABLA DE ADJUNTOS
        if (archivo != null) {
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
        model.addAttribute("msg", "OK");
        return "index";
    }

    @RequestMapping(value = "/removefile", method = RequestMethod.POST, consumes = "application/json", produces = MediaType.TEXT_HTML)
    public String removefile(String archivo
    ) {
        File file = new File(localPath + archivo);
        file.delete();
        return "index";
    }

    @RequestMapping(value = "/agregarParticipante", method = RequestMethod.POST)
    public String agregarParticipante(Model model,
            HttpServletRequest req
    ) throws UnsupportedEncodingException,
            IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage,
            IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
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
        return "redirect://idea/participante.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idea.getId();
    }

    @RequestMapping(value = "/estadogestacion", method = RequestMethod.POST)
    public String estadogestacion_guardar(Model model,
            HttpServletRequest req
    ) throws UnsupportedEncodingException,
            IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage,
            IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);
        int eg = Integer.parseInt(req.getParameter("eg"));
        ItemCatalogo ic_eg = itemDao.buscar(eg);
        idea.setItemCatalogoByEstadoGestacion(ic_eg);
        ideaDao.actualizar(idea);
        return "redirect://idea/publicar.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idIdea;
    }

    @RequestMapping(value = "/publicar", method = RequestMethod.POST)
    public String publicar_guardar(Model model,
            HttpServletRequest req
    ) throws UnsupportedEncodingException,
            IPersonaESConsultarPorUsloguinBusinessExceptionTypeFaultMessage,
            IPersonaESConsultarPorIdentificacionBusinessExceptionTypeFaultMessage {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        Idea idea = ideaDao.buscar(idIdea);
        idea.setPublicar(Boolean.TRUE);
        ideaDao.actualizar(idea);
        return "redirect://idea/publicar.htm?us=" + idea.getUsuario().getId() + "&id_idea=" + idIdea;
    }

    @RequestMapping(value = "/eliminar", method = RequestMethod.POST)
    public String eliminarIdea(Model model,
            HttpServletRequest req
    ) throws UnsupportedEncodingException {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        int idUs = Integer.parseInt(req.getParameter("us"));
        //eliminamos participantes
        List<Participante> part = partDao.listar_condicion("idea.id", idIdea);
        for (Participante p : part) {
            partDao.eliminar(p.getId());
        }
        //se elimina la idea
        ideaDao.eliminar(idIdea);
        return "redirect://principal.htm?us=" + idUs;
    }

    @RequestMapping(value = "/eliminarParticipante", method = RequestMethod.POST)
    public String eliminarParticipante(Model model,
            HttpServletRequest req
    ) throws UnsupportedEncodingException {
        int idIdea = Integer.parseInt(req.getParameter("id_idea"));
        int idPart = Integer.parseInt(req.getParameter("id_part"));
        int idUs = Integer.parseInt(req.getParameter("us"));
        partDao.eliminar(idPart);
        return "redirect://idea/participante.htm?id_idea=" + idIdea + "&us=" + idUs;
    }

    @RequestMapping(value = "/buscarpersona", method = RequestMethod.GET)
    @ResponseBody
    public void obtener_usuario_nsga(@RequestParam("valor") String valor,
            @RequestParam("opcion") String opcion,
            HttpServletResponse response
    ) {
        try {
            response.setContentType("text/html;charset=utf-8");
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

    @RequestMapping(value = "/listitem", method = RequestMethod.GET)
    @ResponseBody
    public void listitem(Model model, HttpServletRequest req, HttpServletResponse response) {
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
            String result = new String(g.toJson(lista).getBytes("UTF-8")); // 
            PrintWriter out = response.getWriter();
            out.print(result);
            out.flush();
        } catch (Exception ex) {

        }
    }

//    @RequestMapping(value = "/index", method = RequestMethod.POST)
//    public void uploadFile(@Valid @ModelAttribute("archivo") FileUploadMD archivo,
//            Model model) throws UnsupportedEncodingException, IOException {
//        if (archivo.getFile() != null) {
//            //Se crea el directorio en el servidor si aún no ha sido creado
//            File directorio = new File(localPath);
//            if (!directorio.exists()) {
//                directorio.mkdir();
//            }
//
//            //subimos el nuevo archivo al servidor 
//            InputStream inputStream = null;
//            OutputStream outputStream = null;
//            MultipartFile multipartFile = archivo.getFile();
//            String fileNombre = new String(multipartFile.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8");
//            int posUltima = fileNombre.lastIndexOf(".");
////            String partes[] = fileNombre.split("\\.");
//            String nombre = fileNombre.substring(0, posUltima + 1);//partes[0];
//            String tipo = fileNombre.substring(posUltima, fileNombre.length());//partes[1];
//
//            if (fileNombre != null) {
//                int cont = 1;
//                while (encontrarArchivo(localPath, fileNombre)) {
//                    fileNombre = nombre + "_" + cont + "." + tipo;
//                    cont++;
//                }
//                try {
//                    inputStream = multipartFile.getInputStream();
//                    String dir = localPath + fileNombre;
//                    File newFile = new File(dir);
//                    newFile.createNewFile();
//                    outputStream = new FileOutputStream(newFile);
//
//                    int read = 0;
//                    byte[] bytes = new byte[1024];
//                    while ((read = inputStream.read(bytes)) != -1) {
//                        outputStream.write(bytes, 0, read);
//                    }
//                    outputStream.flush();
//                    outputStream.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
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

//    @RequestMapping(value = "/removefile", method = RequestMethod.POST, consumes = "application/json", produces = MediaType.TEXT_HTML)
//    public String removefile(String archivo) {
//        File file = new File(localPath + archivo);
//        file.delete();
//        return "index";
//    }
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
}
