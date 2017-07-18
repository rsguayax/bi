/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import util.Utiles;

/**
 *
 * @author TAWSBC
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    Utiles util = new Utiles();

    UsuarioDao usrDao = new UsuarioDao();
//    @Autowired
    UsuarioAuthDao usaDao = new UsuarioAuthDao();
//    @Autowired
    RolDao rolDao = new RolDao();
    
    RolUsuarioDao rusDao = new RolUsuarioDao();
//    @Autowired
    RolFuncionalidadDao rfuDao = new RolFuncionalidadDao();
//    @Autowired
    ConvocatoriaDao conDao = new ConvocatoriaDao();

    NsgaSoapDao wsNsga = new NsgaSoapDao();

}
