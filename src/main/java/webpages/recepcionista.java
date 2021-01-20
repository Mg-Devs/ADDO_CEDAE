/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Recepcionista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mario
 */
public class recepcionista extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    HttpSession session;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Recepcionista recepcion = new Recepcionista(session.getAttribute("curp").toString(), 0);
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            citas = recepcion.GetCitas();
        } catch (SQLException ex) {
            Logger.getLogger(recepcionista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println(" <html lang=\"en\">");
             
            out.println(" <head>");
             
            out.println(" <meta charset=\"utf-8\">");
            out.println(" <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println(" <meta name=\"description\" content=\"\">");
            out.println(" <meta name=\"author\" content=\"\">");
            out.println(" <!-- Favicons -->");
            out.println(" <link href=\"assets/img/favicon.png\" rel=\"icon\">");
             
            out.println(" <title>CEDAE - Recepcion</title>");
             
            out.println(" <!-- Custom fonts for this template-->");
            out.println(" <link href=\"assets/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println(" <link");
            out.println(" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"");
            out.println(" rel=\"stylesheet\">");
             
            out.println(" <!-- Custom styles for this template-->");
            out.println(" <link href=\"assets/css/sb-admin-2.min.css\" rel=\"stylesheet\">");
             
            out.println(" <!-- Custom styles for this page -->");
            out.println(" <link href=\"assets/vendor/datatables/dataTables.bootstrap4.min.css\" rel=\"stylesheet\">");
            
            out.println(" <!-- Date Picker -->");
            out.println(" <link rel=\"stylesheet\" href=\"assets/vendor/flat-picker/flatpickr.min.css\">");
            out.println(" <link rel=\"stylesheet\" href=\"assets/vendor/flat-picker/themes/material_blue.css\">");
             
            out.println(" </head>");
             
            out.println(" <body id=\"page-top\">");
             
            out.println(" <!-- Page Wrapper -->");
            out.println(" <div id=\"wrapper\">");
             
            out.println(" <!-- Sidebar -->");
            out.println(" <ul class=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\" id=\"accordionSidebar\">");
             
            out.println(" <!-- Sidebar - Brand -->");
            out.println(" <a class=\"sidebar-brand d-flex align-items-center justify-content-center\" href=\"index.html\">");
            out.println(" <div class=\"sidebar-brand-icon rotate-n-15\">");
            out.println(" <img src=\"assets/img/faviconW.png\" width=\"39\" height=\"39\" alt=\"Cedae\"/>");
            out.println(" </div>");
            out.println(" <div class=\"sidebar-brand-text mx-3\">CEDAE</div>");
            out.println(" </a>");
             
            out.println(" <!-- Divider -->");
            out.println(" <hr class=\"sidebar-divider my-0\">");
             
            out.println(" <!-- Nav Item - Dashboard -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link\" href=\"index.html\">");
            out.println(" <i class=\"fas fa-fw fa-tachometer-alt\"></i>");
            out.println(" <span>Dashboard</span>");
            out.println(" </a>");
            out.println(" </li>");
             
            out.println(" <!-- Divider -->");
            out.println(" <hr class=\"sidebar-divider\">");
             
            out.println(" <!-- Heading -->");
            out.println(" <div class=\"sidebar-heading\">");
            out.println(" Recepción");
            out.println(" </div>");
             
            out.println(" <!-- Nav Item - Dashboard -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link\" href=\"api/sections/recepcionista?section=vcitas\">");
            out.println(" <i class=\"fas fa-fw fa-heartbeat active\"></i>");
            out.println(" <span>Ver citas</span>");
            out.println(" </a>");
            out.println(" </li>");
            
            out.println(" <!-- Nav Item - Dashboard -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link\" href=\"api/sections/recepcionista?section=vcitaspp\">");
            out.println(" <i class=\"fas fa-fw fa-dollar-sign active\"></i>");
            out.println(" <span>Pagar</span>");
            out.println(" </a>");
            out.println(" </li>");
             
            /*out.println(" <!-- Nav Item - Pages Collapse Menu -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\"");
            out.println(" aria-expanded=\"true\" aria-controls=\"collapseTwo\">");
            out.println(" <i class=\"fas fa-fw fa-shopping-basket\"></i>");
            out.println(" <span>Consultar</span>");
            out.println(" </a>");
            out.println(" <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">");
            out.println(" <div class=\"bg-white py-2 collapse-inner rounded\">");
            out.println(" <h6 class=\"collapse-header\">Opciones:</h6>");
            out.println(" <a class=\"collapse-item\" href=\"api/sections/recepcionista?section=cpacientes\">Consultar paciente</a>");
            out.println(" <a class=\"collapse-item disabled\" href=\"api/sections/recepcionista?section=cmedico\">Consultar medico</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </li>");*/
             
            out.println(" <!-- Divider -->");
            out.println(" <hr class=\"sidebar-divider\">");
             
            out.println(" <!-- Heading -->");
            out.println(" <div class=\"sidebar-heading\">");
            out.println(" OPCIONES");
            out.println(" </div>");
             
            out.println(" <!-- Nav Item - Config -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link\" href=\"charts.html\">");
            out.println(" <i class=\"fas fa-fw fa-user-cog\"></i>");
            out.println(" <span>Configuración</span></a>");
            out.println(" </li>");
             
            out.println(" <!-- Nav Item - Logout -->");
            out.println(" <li class=\"nav-item\">");
            out.println(" <a class=\"nav-link\" href=\"tables.html\">");
            out.println(" <i class=\"fas fa-fw fa-sign-out-alt\"></i>");
            out.println(" <span>Cerrar Sesion</span></a>");
            out.println(" </li>");
             
            out.println(" <!-- Divider -->");
            out.println(" <hr class=\"sidebar-divider d-none d-md-block\">");
             
            out.println(" <!-- Sidebar Toggler (Sidebar) -->");
            out.println(" <div class=\"text-center d-none d-md-inline\">");
            out.println(" <button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>");
            out.println(" </div>");
             
            out.println(" </ul>");
            out.println(" <!-- End of Sidebar -->");
             
            out.println(" <!-- Content Wrapper -->");
            out.println(" <div id=\"content-wrapper\" class=\"d-flex flex-column\">");
             
            out.println(" <!-- Main Content -->");
            out.println(" <div id=\"content\">");
             
            out.println(" <!-- Topbar -->");
            out.println(" <nav class=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">");
             
            out.println(" <!-- Sidebar Toggle (Topbar) -->");
            out.println(" <button id=\"sidebarToggleTop\" class=\"btn btn-link d-md-none rounded-circle mr-3\">");
            out.println(" <i class=\"fa fa-bars\"></i>");
            out.println(" </button>");
             
            out.println(" <!-- Topbar Search -->");
            out.println(" <form");
            out.println(" class=\"d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search\">");
            out.println(" <div class=\"input-group\">");
            out.println(" <input type=\"text\" class=\"form-control bg-light border-0 small\" placeholder=\"Buscar...\"");
            out.println(" aria-label=\"Search\" aria-describedby=\"basic-addon2\">");
            out.println(" <div class=\"input-group-append\">");
            out.println(" <button class=\"btn btn-primary\" type=\"button\">");
            out.println(" <i class=\"fas fa-search fa-sm\"></i>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
             
            out.println(" <!-- Topbar Navbar -->");
            out.println(" <ul class=\"navbar-nav ml-auto\">");
             
            out.println(" <!-- Nav Item - Search Dropdown (Visible Only XS) -->");
            out.println(" <li class=\"nav-item dropdown no-arrow d-sm-none\">");
            out.println(" <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"searchDropdown\" role=\"button\"");
            out.println(" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
            out.println(" <i class=\"fas fa-search fa-fw\"></i>");
            out.println(" </a>");
            out.println(" <!-- Dropdown - Messages -->");
            out.println(" <div class=\"dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in\"");
            out.println(" aria-labelledby=\"searchDropdown\">");
            out.println(" <form class=\"form-inline mr-auto w-100 navbar-search\">");
            out.println(" <div class=\"input-group\">");
            out.println(" <input type=\"text\" class=\"form-control bg-light border-0 small\"");
            out.println(" placeholder=\"Buscar...\" aria-label=\"Search\"");
            out.println(" aria-describedby=\"basic-addon2\">");
            out.println(" <div class=\"input-group-append\">");
            out.println(" <button class=\"btn btn-primary\" type=\"button\">");
            out.println(" <i class=\"fas fa-search fa-sm\"></i>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </li>");
             
            out.println(" <!-- Nav Item - Alerts -->");
            out.println(" <li class=\"nav-item dropdown no-arrow mx-1\">");
            out.println(" <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"alertsDropdown\" role=\"button\"");
            out.println(" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
            out.println(" <i class=\"fas fa-bell fa-fw\"></i>");
            out.println(" <!-- Counter - Alerts -->");
            out.println(" <span class=\"badge badge-danger badge-counter\">2</span>");
            out.println(" </a>");
            out.println(" <!-- Dropdown - Alerts -->");
            out.println(" <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"");
            out.println(" aria-labelledby=\"alertsDropdown\">");
            out.println(" <h6 class=\"dropdown-header\">");
            out.println(" Notificaiones");
            out.println(" </h6>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"mr-3\">");
            out.println(" <div class=\"icon-circle bg-warning\">");
            out.println(" <i class=\"fas fa-exclamation-triangle text-white\"></i>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div>");
            out.println(" <div class=\"small text-gray-500\">December 12, 2019</div>");
            out.println(" <span class=\"font-weight-bold\">Quedan 15 unidades de: Pomada de la campana 35g</span>");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"mr-3\">");
            out.println(" <div class=\"icon-circle bg-success\">");
            out.println(" <i class=\"fas fa-clock text-white\"></i>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div>");
            out.println(" <div class=\"small text-gray-500\">December 7, 2019</div>");
            out.println(" Canespie Bifonazol 10 mg/g 20 gr. Con lote: XXXX caducara en 3 meses.");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Todas las notificaciones</a>");
            out.println(" </div>");
            out.println(" </li>");
             
            out.println(" <!-- Nav Item - Messages -->");
            out.println(" <li class=\"nav-item dropdown no-arrow mx-1\">");
            out.println(" <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"messagesDropdown\" role=\"button\"");
            out.println(" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
            out.println(" <i class=\"fas fa-envelope fa-fw\"></i>");
            out.println(" <!-- Counter - Messages -->");
            out.println(" <span class=\"badge badge-danger badge-counter\">7</span>");
            out.println(" </a>");
            out.println(" <!-- Dropdown - Messages -->");
            out.println(" <div class=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"");
            out.println(" aria-labelledby=\"messagesDropdown\">");
            out.println(" <h6 class=\"dropdown-header\">");
            out.println(" Mensajes");
            out.println(" </h6>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"dropdown-list-image mr-3\">");
            out.println(" <img class=\"rounded-circle\" src=\"assets/img/undraw_profile_1.svg\"");
            out.println(" alt=\"\">");
            out.println(" <div class=\"status-indicator bg-success\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"font-weight-bold\">");
            out.println(" <div class=\"text-truncate\">Hi there! I am wondering if you can help me with a");
            out.println(" problem I've been having.</div>");
            out.println(" <div class=\"small text-gray-500\">Emily Fowler · 58m</div>");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"dropdown-list-image mr-3\">");
            out.println(" <img class=\"rounded-circle\" src=\"assets/img/undraw_profile_2.svg\"");
            out.println(" alt=\"\">");
            out.println(" <div class=\"status-indicator\"></div>");
            out.println(" </div>");
            out.println(" <div>");
            out.println(" <div class=\"text-truncate\">I have the photos that you ordered last month, how");
            out.println(" would you like them sent to you?</div>");
            out.println(" <div class=\"small text-gray-500\">Jae Chun · 1d</div>");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"dropdown-list-image mr-3\">");
            out.println(" <img class=\"rounded-circle\" src=\"assets/img/undraw_profile_3.svg\"");
            out.println(" alt=\"\">");
            out.println(" <div class=\"status-indicator bg-warning\"></div>");
            out.println(" </div>");
            out.println(" <div>");
            out.println(" <div class=\"text-truncate\">Last month's report looks great, I am very happy with");
            out.println(" the progress so far, keep up the good work!</div>");
            out.println(" <div class=\"small text-gray-500\">Morgan Alvarez · 2d</div>");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item d-flex align-items-center\" href=\"#\">");
            out.println(" <div class=\"dropdown-list-image mr-3\">");
            out.println(" <img class=\"rounded-circle\" src=\"https://source.unsplash.com/Mv9hjnEUHR4/60x60\"");
            out.println(" alt=\"\">");
            out.println(" <div class=\"status-indicator bg-success\"></div>");
            out.println(" </div>");
            out.println(" <div>");
            out.println(" <div class=\"text-truncate\">Am I a good boy? The reason I ask is because someone");
            out.println(" told me that people say this to all dogs, even if they aren't good...</div>");
            out.println(" <div class=\"small text-gray-500\">Chicken the Dog · 2w</div>");
            out.println(" </div>");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item text-center small text-gray-500\" href=\"#\">Ver todos los mensajes</a>");
            out.println(" </div>");
            out.println(" </li>");
             
            out.println(" <div class=\"topbar-divider d-none d-sm-block\"></div>");
             
            out.println(" <!-- Nav Item - User Information -->");
            out.println(" <li class=\"nav-item dropdown no-arrow\">");
            out.println(" <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\" role=\"button\"");
            out.println(" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
            out.println(" <span class=\"mr-2 d-none d-lg-inline text-gray-600 small\">Gregory House</span>");
            out.println(" <img class=\"img-profile rounded-circle\"");
            out.println(" src=\"assets/img/undraw_profile.svg\">");
            out.println(" </a>");
            out.println(" <!-- Dropdown - User Information -->");
            out.println(" <div class=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"");
            out.println(" aria-labelledby=\"userDropdown\">");
            out.println(" <a class=\"dropdown-item\" href=\"#\">");
            out.println(" <i class=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i>");
            out.println(" Perfil");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item\" href=\"#\">");
            out.println(" <i class=\"fas fa-cogs fa-sm fa-fw mr-2 text-gray-400\"></i>");
            out.println(" Configuración");
            out.println(" </a>");
            out.println(" <a class=\"dropdown-item\" href=\"#\">");
            out.println(" <i class=\"fas fa-list fa-sm fa-fw mr-2 text-gray-400\"></i>");
            out.println(" Actividad");
            out.println(" </a>");
            out.println(" <div class=\"dropdown-divider\"></div>");
            out.println(" <a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#logoutModal\">");
            out.println(" <i class=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>");
            out.println(" Cerrar Sesion");
            out.println(" </a>");
            out.println(" </div>");
            out.println(" </li>");
             
            out.println(" </ul>");
             
            out.println(" </nav>");
            out.println(" <!-- End of Topbar -->");
             
            out.println(" <!-- Begin Page Content -->");
            out.println(" <div class=\"container-fluid\" id=\"content-page\">");
             
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Citas</h1>");
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
             
            out.println(" <div class=\"col-md-12\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Citas proximas</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            
            //out.println(" <div class=\"row\">");
            //out.println(" <div class=\"col-md-2\">");
            out.println(" <button class=\"btn btn-info btn-icon-split mb-4\" id=\"agProd\" onclick=\"agProd()\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Agendar Cita</span>");
            out.println(" </button>");
            //out.println(" </div>");
            //out.println(" <div class=\"col-md-2\">");
            out.println(" <button class=\"btn btn-success btn-icon-split mb-4\" id=\"agProd\" onclick=\"primeraCita()\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Primera Cita</span>");
            out.println(" </button>");
            //out.println(" </div>");
            //out.println(" </div>");
             
            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Paciente</th>");
            out.println(" <th>Hora</th>");
            out.println(" <th>Fecha</th>");
            out.println(" <th>Doctor</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Paciente</th>");
            out.println(" <th>Hora</th>");
            out.println(" <th>Fecha</th>");
            out.println(" <th>Doctor</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");
            
            for (Cita cita : citas) {
                cita.getPaciente().getData();
                cita.getMedicoTit().getAllData();
                out.println(" <tr data-idcita=\""+cita.getIdCita()+"\">");
                out.println(" <td data-cpaciente=\""+cita.getPaciente().getCurp()+"\">"+cita.getPaciente().getNombre()+" "+cita.getPaciente().getApellidos()+"</td>");
                out.println(" <td>"+cita.getHora()+"</td>");
                out.println(" <td>"+cita.getFecha()+"</td>");
                out.println(" <td data-cmedico=\""+cita.getMedicoTit().getCurp()+"\">"+cita.getMedicoTit().getNombre()+" "+cita.getMedicoTit().getApellidos()+"</td>");
                out.println(" <td>");
                out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
                out.println(" <i class=\"fas fa-edit\"></i>");
                out.println(" </button>");
                out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
                out.println(" <i class=\"fas fa-trash\"></i>");
                out.println(" </button>");
                out.println(" </td>");
                out.println(" </tr>");
                
            }
            
             
            out.println(" </tbody>");
            out.println(" </table>");
            out.println(" </div>");
             
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <!-- /.container-fluid -->");
             
            out.println(" </div>");
            out.println(" <!-- End of Main Content -->");
             
            out.println(" <!-- Footer -->");
            out.println(" <footer class=\"sticky-footer bg-white\">");
            out.println(" <div class=\"container my-auto\">");
            out.println(" <div class=\"copyright text-center my-auto\">");
            out.println(" <span>Copyright © CEDAE 2020</span>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </footer>");
            out.println(" <!-- End of Footer -->");
             
            out.println(" </div>");
            out.println(" <!-- End of Content Wrapper -->");
             
            out.println(" </div>");
            out.println(" <!-- End of Page Wrapper -->");
             
            out.println(" <!-- Scroll to Top Button-->");
            out.println(" <a class=\"scroll-to-top rounded\" href=\"#page-top\">");
            out.println(" <i class=\"fas fa-angle-up\"></i>");
            out.println(" </a>");
             
            out.println(" <!-- Logout Modal-->");
            out.println(" <div class=\"modal fade\" id=\"logoutModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\"");
            out.println(" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-header\">");
            out.println(" <h5 class=\"modal-title\" id=\"exampleModalLabel\">Listo para salir?</h5>");
            out.println(" <button class=\"close\" type=\"button\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println(" <span aria-hidden=\"true\">×</span>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" <div class=\"modal-body\">Elige \"Cerrar Sesion\" abajo si estas seguro de cerrar sesion.</div>");
            out.println(" <div class=\"modal-footer\">");
            out.println(" <button class=\"btn btn-secondary\" type=\"button\" data-dismiss=\"modal\">Cancelar</button>");
            out.println(" <a class=\"btn btn-primary\" href=\"login.html\">Cerrar Sesion</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" <!-- Modals -->");
            out.println(" <div class=\"modal fade\" id=\"deleteItem\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-header\">");
            out.println(" <h5 class=\"modal-title\" id=\"exampleModalLongTitle\">Cancelar Cita</h5>");
            out.println(" <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println(" <span aria-hidden=\"true\">×</span>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" <div class=\"modal-body\">");
            out.println(" ¿Estas seguro de cancelar la cita de: <span id=\"ittd\"></span>?");
            out.println(" </div>");
            out.println(" <div class=\"modal-footer\">");
            out.println(" <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>");
            out.println(" <button type=\"button\" class=\"btn btn-danger\" onclick=\"deleteConfirmed()\">Si, eliminar</button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" <div class=\"modal fade\" id=\"editItem\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-header\">");
            out.println(" <h5 class=\"modal-title\" id=\"addEddTitle\">Agendar Cita</h5>");
            out.println(" <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println(" <span aria-hidden=\"true\">×</span>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" <div class=\"modal-body\">");
            out.println(" <form>");
            out.println(" <input type=\"hidden\" id=\"curpmed\" name=\"curpmed\" class=\"form-control\" placeholder=\"Nombre paciente\">");
            out.println(" <input type=\"hidden\" id=\"curppac\" name=\"curppac\" class=\"form-control\" placeholder=\"Nombre paciente\">");
            out.println(" <input type=\"hidden\" id=\"idcita\" name=\"idcita\" class=\"form-control\" placeholder=\"Nombre paciente\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\" id=\"pacInput\">");
            
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" id=\"medInput\">");
            
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"doctor\">Duración</label>");
            out.println(" <select class=\"form-control\" id=\"durac\" name=\"durac\" data-rule=\"required\" data-msg=\"Elije una hora\">");
            out.println(" <option value=\"1\">15 minutos</option>");
            out.println(" <option value=\"2\" selected>30 minutos</option>");
            out.println(" <option value=\"3\">45 minutos</option>");
            out.println(" <option value=\"4\">60 minutos</option>");
            out.println(" <option value=\"5\">1 hora 15 minutos</option>");
            out.println(" <option value=\"6\">1 hora 30 minutos</option>");
            out.println(" </select>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" id=\"time-input\">");
            out.println(" <label for=\"fecha\">Fecha</label>");
            out.println(" <input class=\"form-control\" name=\"fecha\" id=\"fecha\" placeholder=\"Fecha\" data-input data-rule=\"required\" data-msg=\"Elije una fecha valida\" />");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"hora\">Hora</label>");
            out.println(" <select class=\"form-control\" id=\"hora\" name=\"hora\" data-rule=\"required\" data-msg=\"Elije una hora\" disabled>");
            out.println(" <option value=\"null\">Elige la hora</option>");
            out.println(" </select>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" <div class=\"modal-footer\">");
            out.println(" <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>");
            out.println(" <button type=\"button\" id=\"modalAction\" class=\"btn btn-primary\">Modificar</button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            
            
            out.println(" <div class=\"modal fade\" id=\"primerCita\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-header\">");
            out.println(" <h5 class=\"modal-title\" id=\"addEddTitle\">Agendar Primer Cita</h5>");
            out.println(" <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println(" <span aria-hidden=\"true\">×</span>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" <div class=\"modal-body\">");
            out.println(" <form id=\"personal-info\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\" >");
            out.println(" <label for=\"name\">Nombre paciente</label>");
            out.println(" <input type=\"text\" name=\"namepc\" class=\"form-control\" id=\"namepc\" placeholder=\"Nombre\" data-rule=\"minlen:4\" data-msg=\"Ingresa al menos 4 letras\" />");
            out.println(" </div>");
            out.println(" <div class=\"col\" >");
            out.println(" <label for=\"name\">Apellido paciente</label>");
            out.println(" <input type=\"text\" class=\"form-control\" name=\"lastnamepc\" id=\"lastnamepc\" placeholder=\"Apellido\" data-rule=\"minlen:4\" data-msg=\"Ingresa al menos 4 letras\" />");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" >");
            out.println(" <label for=\"doctor\">Correo Electronico</label>");
            out.println(" <input type=\"email\" class=\"form-control\" name=\"emailpc\" id=\"emailpc\" placeholder=\"Correo electronico\" data-rule=\"minlen:4\" data-msg=\"Ingresa un correo valido\" />");
            out.println(" </div>");
            out.println(" </div>");
            
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" >");
            out.println(" <label for=\"fecha\">Telefono</label>");
            out.println(" <input type=\"number\" name=\"telpc\" class=\"form-control\" id=\"telpc\" placeholder=\"Telefono\" data-rule=\"minlen:10\" data-msg=\"Ingresa un número telefonico valido\" />");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" >");
            out.println(" <label for=\"fecha\">Fecha</label>");
            out.println(" <input class=\"form-control\" name=\"datepc\" id=\"datepc\" placeholder=\"Fecha\" data-input data-rule=\"required\" data-msg=\"Elije una fecha valida\" />");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"hora\">Hora</label>");
            out.println(" <select class=\"form-control\" id=\"horapc\" name=\"horapc\" data-rule=\"required\" data-msg=\"Elije una hora\" disabled>");
            out.println(" <option value=\"null\">Elige la hora</option>");
            out.println(" </select>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" <div class=\"modal-footer\">");
            out.println(" <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>");
            out.println(" <button type=\"button\" onclick=\"agendPrimerCita()\" class=\"btn btn-primary\">Agendar Primer Cita</button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            
            
            out.println(" <div class=\"modal fade\" id=\"pagarCita\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog modal-dialog-centered modal-lg\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-header\">");
            out.println(" <h5 class=\"modal-title\" id=\"addEddTitle\">Pagar Cita</h5>");
            out.println(" <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">");
            out.println(" <span aria-hidden=\"true\">×</span>");
            out.println(" </button>");
            out.println(" </div>");
            out.println(" <div class=\"modal-body\">");
            out.println(" <form>");
            out.println(" <input type=\"hidden\" id=\"idcita2p\" name=\"idcita2p\" class=\"form-control\" placeholder=\"Nombre paciente\">");
            
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\" >");
            out.println(" <label for=\"name\">Nombre paciente</label>");
            out.println(" <input type=\"text\" id=\"namepay\" name=\"namepay\" class=\"form-control\" placeholder=\"Nombre paciente\" disabled>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\" >");
            out.println(" <label for=\"name\">Doctor</label>");
            out.println(" <input type=\"text\" id=\"doctorpay\" name=\"doctorpay\" class=\"form-control\" placeholder=\"Nombre doctor\" disabled>");
            out.println(" </div>");
            out.println(" </div>");
            
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"fecha\">Fecha</label>");
            out.println(" <input class=\"form-control\" type=\"date\" name=\"fechapay\" id=\"fechapay\" disabled />");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"hora\">Hora</label>");
            out.println(" <input class=\"form-control\" type=\"time\" name=\"horapay\" id=\"horapay\" disabled />");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" <hr>");
            
            
            out.println(" <div id=\"payService\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"fecha\">Concepto</label>");
            out.println(" <input class=\"form-control\" type=\"text\" name=\"citapricename\" id=\"citapricename\" value=\"Cita\" disabled />");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <label for=\"hora\">Precio</label>");
            out.println(" <input class=\"form-control\" type=\"numeric\" min=\"0\" name=\"citaprice\" id=\"citaprice\"/>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-3 mt-4 align-self-end\">");
            out.println(" <button type=\"button\" onclick=\"aggProdToPay()\" class=\"btn btn-info\">Agregar Servicio</button>");
            out.println(" </div>");
            out.println(" </div>");
            
            out.println(" </div>");
            out.println(" <div class=\"modal-footer\">");
            out.println(" <button type=\"button\" class=\"btn btn-secondary\" data-dismiss=\"modal\">Cancelar</button>");
            out.println(" <button type=\"button\" onclick=\"pagarCita()\" class=\"btn btn-primary\">Pagar</button>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            
            
            out.println(" <!-- Bootstrap core JavaScript-->");
            out.println(" <script src=\"assets/vendor/jquery/jquery.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>");
             
            out.println(" <!-- Core plugin JavaScript-->");
            out.println(" <script src=\"assets/vendor/jquery-easing/jquery.easing.min.js\"></script>");
             
            out.println(" <!-- Custom scripts for all pages-->");
            out.println(" <script src=\"assets/js/sb-admin-2.min.js\"></script>");
            out.println(" <script src=\"assets/js/citas.js\"></script>");
            out.println(" <script src=\"assets/js/navigation.js\"></script>");
            out.println(" <script src=\"assets/js/recepcionista.js\"></script>");
             
            out.println(" <!-- Page level plugins -->");
            out.println(" <script src=\"assets/vendor/datatables/jquery.dataTables.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/datatables/dataTables.bootstrap4.min.js\"></script> ");
             
            out.println(" <!-- Page level custom scripts -->");
            out.println(" <script src=\"assets/js/demo/datatables-demo.js\"></script>");
            
            out.println(" <!-- Date Picker -->");
            out.println(" <script src=\"assets/vendor/flat-picker/flatpickr.js\"></script>");
             
            out.println(" </body>");
             
            out.println(" </html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        if (session == null) {
            response.sendRedirect(request.getContextPath());
        }else{
            processRequest(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
