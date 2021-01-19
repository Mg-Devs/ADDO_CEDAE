/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages.sections;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Empleado;
import com.adoo.cedae.Expediente;
import com.adoo.cedae.Farmacia;
import com.adoo.cedae.Medico;
import com.adoo.cedae.Paciente;
import com.adoo.cedae.Persona;
import com.adoo.cedae.Producto;
import com.adoo.cedae.Receta;
import com.adoo.cedae.resources.Security;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;

/**
 *
 * @author mario
 */
@WebServlet(name = "apiMedico", urlPatterns = {"/api/sections/medico"})
public class medico extends HttpServlet {

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

    protected void sectionNF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- 404 Error Text -->");
            out.println(" <div class=\"text-center mt-5\">");
            out.println(" <div class=\"error mx-auto\" data-text=\"404\">404</div>");
            out.println(" <p class=\"lead text-gray-800 mb-5\">Page Not Found</p>");
            out.println(" <p class=\"text-gray-500 mb-0\">It looks like you found a glitch in the matrix...</p>");
            out.println(" <a href=\"#\">← Back to Dashboard</a>");
            out.println(" </div>");
        }
    }

    protected void dashboardSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<h1>Servlet medico at " + request.getContextPath() + "</h1>");
            out.println(request.getParameter("section"));
        }
    }

    protected void agendaSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Medico medTit = new Medico(session.getAttribute("curp").toString(), true);
        ArrayList<Cita> citas = medTit.getAgenda();
        Security encrypt = new Security();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Mis Citas</h1>");
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

            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Paciente</th>");
            out.println(" <th>Hora</th>");
            out.println(" <th>Fecha</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Paciente</th>");
            out.println(" <th>Hora</th>");
            out.println(" <th>Fecha</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");

            for (Cita cita : citas) {
                out.println(" <tr data-id=\""+cita.getIdCita()+"\" data-recipe=\""+(cita.getReceta()!=null?encrypt.encriptar("0"+cita.getReceta().getIdReceta()):"null")+"\" data-place=\""+cita.getSucursal()+"\">");
                out.println(" <td>" + cita.getPaciente().getNombre() + " " + cita.getPaciente().getApellidos() + "</td>");
                out.println(" <td>" + cita.getHora() + "</td>");
                out.println(" <td>" + cita.getFecha().toString().replace('-', '/') + "</td>");
                out.println(" <td>");
                out.println(" <button class=\"btn btn-sm btn-success btn-circle\" alt=\"Mas Detalles\" onclick=\"verCita(this)\">");
                out.println(" <i class=\"fas fa-eye\"></i>");
                out.println(" </button>");
                if (cita.getPaciente().getCurp().matches("^TMP\\d{10,15}$")) {
                    out.println(" <button class=\"btn btn-sm btn-info btn-circle\" alt=\"Crear Expediente\" onclick=\"navigationHelper('api/sections/medico?section=cExpediente&curp=" + cita.getPaciente().getCurp() + "')\">");
                    out.println(" <i class=\"fas fa-plus\"></i>");
                    out.println(" </button>");
                }
                out.println(" </td>");
            }

            out.println(" </tbody>");
            out.println(" </table>");
            out.println(" </div>");

            out.println(" </div>");
            out.println(" </div>");

            out.println(" </div>");
            out.println(" </div>");
        }
    }

    protected void pacientesSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Pacientes</h1>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
            out.println(" ");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Mis Pacientes</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" ");
            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>CURP</th>");
            out.println(" <th>Ultima Cita</th>");
            out.println(" <th>Proxima Cita</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>CURP</th>");
            out.println(" <th>Ultima Cita</th>");
            out.println(" <th>Proxima Cita</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");
            out.println(" <tr>");
            out.println(" <td>Nina Alcazar</td>");
            out.println(" <td>154754.5</td>");
            out.println(" <td>2023/04/25</td>");
            out.println(" <td>2023/04/25</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Abril Morcillo</td>");
            out.println(" <td>200070.4</td>");
            out.println(" <td>2022/07/25</td>");
            out.println(" <td>-</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Marco-Antonio Peñalver</td>");
            out.println(" <td>166650.5</td>");
            out.println(" <td>2021/01/12</td>");
            out.println(" <td>-</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>John Hurtado</td>");
            out.println(" <td>154888.7</td>");
            out.println(" <td>2021/03/29</td>");
            out.println(" <td>2021/03/29</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Israel Cifuentes</td>");
            out.println(" <td>184310.4</td>");
            out.println(" <td>2022/11/28</td>");
            out.println(" <td>2022/11/28</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Elisabet Gomez</td>");
            out.println(" <td>178899.3</td>");
            out.println(" <td>2025/12/02</td>");
            out.println(" <td>2025/12/02</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Jesica Quesada</td>");
            out.println(" <td>FD5502340</td>");
            out.println(" <td>2025/08/06</td>");
            out.println(" <td>2025/08/06</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Salvadora Snchez</td>");
            out.println(" <td>L0037</td>");
            out.println(" <td>2021/10/14</td>");
            out.println(" <td>-</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Irene Candela</td>");
            out.println(" <td>197615.4</td>");
            out.println(" <td>2025/09/15</td>");
            out.println(" <td>2025/09/15</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Jose-Maria Chico</td>");
            out.println(" <td>00-22-44-154</td>");
            out.println(" <td>2028/12/13</td>");
            out.println(" <td>2028/12/13</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Pol Domingo</td>");
            out.println(" <td>FD55203</td>");
            out.println(" <td>2028/12/19</td>");
            out.println(" <td>-</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Maria-Jesus Narvaez</td>");
            out.println(" <td>193613.4</td>");
            out.println(" <td>2023/03/03</td>");
            out.println(" <td>2023/03/03</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-eye\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" ");
            out.println(" </tbody>");
            out.println(" </table>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
        }
    }

    protected void cRecetaSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idCita = request.getParameter("helper");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Crear Receta</h1>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <a role=\"button\" class=\"btn btn-success btn-icon-split \" id=\"recButton\" onclick=\"generarReceta()\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-check\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Generar Receta</span>");
            out.println(" </a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
            out.println("<div class=\"col-lg-6\">");
            out.println(" <!-- Exam -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Examen Fisico</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <input type=\"hidden\" id=\"idC\" name=\"idC\" value=\""+idCita+"\">");
            out.println(" <form id=\"examen-fisi\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"peso\" name=\"peso\" class=\"form-control\" placeholder=\"Peso\">");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"estatura\" name=\"estatura\" class=\"form-control\" placeholder=\"Estatura (cm)\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"pressArte\" name=\"pressArte\" class=\"form-control\" placeholder=\"Presión Arterial\">");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"frecCard\" name=\"frecCard\" class=\"form-control\" placeholder=\"Frecuencia Cardiaca\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"frecResp\" name=\"frecResp\" class=\"form-control\" placeholder=\"Frecuencia Respiratoria\">");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"temp\" name=\"temp\" class=\"form-control\" placeholder=\"Temperatura\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Productos</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <button class=\"btn btn-info btn-icon-split mb-4\" id=\"agProd\" onclick='aggProducto()'>");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Agregar Producto</span>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-success btn-icon-split mb-4\" id=\"agOtroProd\" onclick='aggOtroPorducto()'>");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Producto No Registrado</span>");
            out.println(" </button>");
            out.println(" <div id=\"productos\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" ");
            out.println(" <div class=\"col-lg-6\">");
            out.println(" <!-- Evaluation -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Evaluación y Plan de Seguimiento</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"evaluation\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col-8\">");
            out.println(" <input type=\"text\" id=\"diagn\" name=\"diagn\" class=\"form-control\" placeholder=\"Diagnostico\">");
            out.println(" </div>");
            out.println(" <div class=\"col-4\">");
            out.println(" <input type=\"text\" id=\"cie\" name=\"cie\" class=\"form-control\" placeholder=\"CIE\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"desc\" name=\"desc\" rows=\"5\" placeholder=\"Descripcíon\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <img src=\"assets/img/hbody.jpg\" width=\"400\" height=\"300\"/>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"obs\" name=\"obs\" rows=\"12\" placeholder=\"Observaciones\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"planseg\" name=\"planseg\" rows=\"5\" placeholder=\"Plan de Seguimiento\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
        }
    }

    protected void cExpedienteSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Paciente nPaciente = new Paciente(request.getParameter("helper"));
        if (!nPaciente.getData()) {
            sectionNF(request, response);
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Crear Expediente</h1>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <a role=\"button\" class=\"btn btn-success btn-icon-split\" id=\"createExpediente\" onclick='createExpediente(this)'>");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-check\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Guardar Expediente</span>");
            out.println(" </a>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");

            out.println(" <div class=\"col-lg-6\">");

            out.println(" <!-- Personal Info -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Información Personal</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"personal-info\">");
            out.println(" <input type=\"hidden\" id=\"pid\" name=\"pid\" class=\"form-control\" value=\"" + nPaciente.getCurp() + "\" disabled>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"name\" name=\"name\" class=\"form-control\" value=\"" + nPaciente.getNombre() + "\" placeholder=\"Nombre(s)\" data-rule=\"required\" data-msg=\"Ingresa el nombre\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"lastname\" name=\"lastname\" value=\"" + nPaciente.getApellidos() + "\" class=\"form-control\" placeholder=\"Apellidos\" data-rule=\"required\" data-msg=\"Ingresa el apellido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"date\" id=\"birthdate\" name=\"birthdate\" class=\"form-control\" placeholder=\"Fecha de Naciemiento\" data-rule=\"required\" data-msg=\"Ingresa la fecha de nacimiento\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <select class=\"custom-select mr-sm-2\" id=\"sexo\" name=\"sexo\" data-rule=\"required\" data-msg=\"Selecciona el Sexo\">");
            out.println(" <option selected value=\"null\">Sexo</option>");
            out.println(" <option value=\"1\">Masculino</option>");
            out.println(" <option value=\"2\">Femenino</option>");
            out.println(" <option value=\"3\">Otro</option>");
            out.println(" </select>");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"text\" id=\"curp\" name=\"curp\" class=\"form-control\" placeholder=\"CURP\" data-rule=\"curp\" data-msg=\"Ingresa un CURP valido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"text\" id=\"occup\" name=\"occup\" class=\"form-control\" placeholder=\"Ocupación\">");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <select class=\"custom-select mr-sm-2\" id=\"estcivil\" name=\"estcivil\">");
            out.println(" <option selected>Estado Civil</option>");
            out.println(" <option value=\"1\">Casado</option>");
            out.println(" <option value=\"2\">Soltero</option>");
            out.println(" <option value=\"3\">Otro</option>");
            out.println(" </select>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"tel\" id=\"tel\" name=\"tel\" value=\"" + nPaciente.getTelefono() + "\" class=\"form-control\" placeholder=\"Telefono\" data-rule=\"required\" data-msg=\"Ingresa el telefono\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"text\" id=\"secure\" name=\"secure\" class=\"form-control\" placeholder=\"Aseguradora\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"email\" id=\"email\" name=\"email\" value=\"" + nPaciente.getEmail() + "\" class=\"form-control\" placeholder=\"Correo Electronico\" data-rule=\"email\" data-msg=\"Ingresa un correo valido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" <!-- Address Info -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Dirección</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"address-info\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"dir\" name=\"dir\" class=\"form-control\" placeholder=\"Direccion\" data-rule=\"minlen:10\" data-msg=\"Ingresa una dirección\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"text\" id=\"colonia\" name=\"colonia\" class=\"form-control\" placeholder=\"Colonia\" data-rule=\"required\" data-msg=\"Ingresa la colonia\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <select class=\"custom-select mr-sm-2\" id=\"entfed\" name=\"entfed\" data-rule=\"required\" data-msg=\"Selecciona una opcion\">");
            out.println(" <option selected value=\"null\">Entidad Federativa</option>");
            out.println(" <option value=\"Aguascalientes\">Aguascalientes</option>");
            out.println(" <option value=\"Baja California\">Baja California</option>");
            out.println(" <option value=\"Baja California Sur\">Baja California Sur</option>");
            out.println(" <option value=\"Campeche\">Campeche</option>");
            out.println(" <option value=\"Chiapas\">Chiapas</option>");
            out.println(" <option value=\"Chihuahua\">Chihuahua</option>");
            out.println(" <option value=\"CDMX\">Ciudad de México</option>");
            out.println(" <option value=\"Coahuila\">Coahuila</option>");
            out.println(" <option value=\"Colima\">Colima</option>");
            out.println(" <option value=\"Durango\">Durango</option>");
            out.println(" <option value=\"Estado de México\">Estado de México</option>");
            out.println(" <option value=\"Guanajuato\">Guanajuato</option>");
            out.println(" <option value=\"Guerrero\">Guerrero</option>");
            out.println(" <option value=\"Hidalgo\">Hidalgo</option>");
            out.println(" <option value=\"Jalisco\">Jalisco</option>");
            out.println(" <option value=\"Michoacán\">Michoacán</option>");
            out.println(" <option value=\"Morelos\">Morelos</option>");
            out.println(" <option value=\"Nayarit\">Nayarit</option>");
            out.println(" <option value=\"Nuevo León\">Nuevo León</option>");
            out.println(" <option value=\"Oaxaca\">Oaxaca</option>");
            out.println(" <option value=\"Puebla\">Puebla</option>");
            out.println(" <option value=\"Querétaro\">Querétaro</option>");
            out.println(" <option value=\"Quintana Roo\">Quintana Roo</option>");
            out.println(" <option value=\"San Luis Potosí\">San Luis Potosí</option>");
            out.println(" <option value=\"Sinaloa\">Sinaloa</option>");
            out.println(" <option value=\"Sonora\">Sonora</option>");
            out.println(" <option value=\"Tabasco\">Tabasco</option>");
            out.println(" <option value=\"Tamaulipas\">Tamaulipas</option>");
            out.println(" <option value=\"Tlaxcala\">Tlaxcala</option>");
            out.println(" <option value=\"Veracruz\">Veracruz</option>");
            out.println(" <option value=\"Yucatán\">Yucatán</option>");
            out.println(" <option value=\"Zacatecas\">Zacatecas</option>");
            out.println(" </select>");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col mt-2\">");
            out.println(" <input type=\"number\" id=\"cp\" name=\"cp\" class=\"form-control\" placeholder=\"Codigo Postal\" data-rule=\"required\" data-msg=\"Ingresa el codigo postal\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col mt-2\">");

            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" <!-- History Info -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Antecedentes</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"history-info\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"alergias\" name=\"alergias\" class=\"form-control\" placeholder=\"Alergias\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"anteHered\" name=\"anteHered\" class=\"form-control\" placeholder=\"Antecedentes Heredofamiliares\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"antePato\" name=\"antePato\" class=\"form-control\" placeholder=\"Antecedentes Personales Patológicos\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"padeciActual\" name=\"padeciActual\" rows=\"8\" placeholder=\"Padecimiento Actual\" data-rule=\"required\" data-msg=\"Ingresa el pacedimiento\"></textarea>");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" </div>");

            out.println(" <div class=\"col-lg-6\">");

            out.println(" <!-- Exam -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Examen Fisico</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"examen-fisi\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"peso\" name=\"peso\" class=\"form-control\" placeholder=\"Peso\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"estatura\" name=\"estatura\" class=\"form-control\" placeholder=\"Estatura (cm)\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"pressArte\" name=\"pressArte\" class=\"form-control\" placeholder=\"Presión Arterial\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"frecCard\" name=\"frecCard\" class=\"form-control\" placeholder=\"Frecuencia Cardiaca\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"frecResp\" name=\"frecResp\" class=\"form-control\" placeholder=\"Frecuencia Respiratoria\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"number\" id=\"temp\" name=\"temp\" class=\"form-control\" placeholder=\"Temperatura\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"topogr\" name=\"topogr\" class=\"form-control\" placeholder=\"Topografia\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"morfo\" name=\"morfo\" rows=\"5\" placeholder=\"Morfologia\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"panex\" name=\"panex\" class=\"form-control\" placeholder=\"Piel y Anexos\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <input type=\"text\" id=\"tratAnt\" name=\"tratAnt\" class=\"form-control\" placeholder=\"Tratamiento Anterior\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" <!-- Evaluation -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Evaluación y Plan de Seguimiento</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <form id=\"evaluation\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col col-8\">");
            out.println(" <input type=\"text\" id=\"diagn\" name=\"diagn\" class=\"form-control\" placeholder=\"Diagnostico\" data-rule=\"required\" data-msg=\"Este campo es requerido\">");
            out.println(" <div class=\"validate text-center\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col-4\">");
            out.println(" <input type=\"text\" id=\"cie\" name=\"cie\" class=\"form-control\" placeholder=\"CIE\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"desc\" name=\"desc\" rows=\"5\" placeholder=\"Descripcíon\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <img src=\"assets/img/hbody.jpg\" width=\"400\" height=\"300\"/>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"obs\" name=\"obs\" rows=\"12\" placeholder=\"Observaciones\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row mt-2\">");
            out.println(" <div class=\"col\">");
            out.println(" <textarea class=\"form-control\" id=\"planseg\" name=\"planseg\" rows=\"5\" placeholder=\"Plan de Seguimiento\"></textarea>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" </div>");
            out.println(" </div>");
        }
    }

    protected void vExpedientesSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Medico medic = new Medico(session.getAttribute("curp").toString(), true);
        ArrayList<Persona> pacientes = medic.getExp();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Ver Expedientes</h1>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
            out.println(" ");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Mis Expedientes Asociados</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" ");
            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>CURP</th>");
            out.println(" <th>Fecha de Actualización</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>CURP</th>");
            out.println(" <th>Fecha de Actualización</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");
            
            for (Persona persona : pacientes) {
                out.println(" <tr>");
                out.println(" <td>"+persona.getNombre()+" "+persona.getApellidos()+"</td>");
                out.println(" <td>"+persona.getCurp()+"</td>");
                out.println(" <td>"+persona.getFechaRegistro()+"</td>");
                out.println(" <td>");
                out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editExp(this)\">");
                out.println(" <i class=\"fas fa-edit\"></i>");
                out.println(" </button>");
                out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"navigationHelper('api/sections/medico?section=vExpediente&curp=" + persona.getCurp() + "')\">");
                out.println(" <i class=\"fas fa-eye\"></i>");
                out.println(" </button>");
                out.println(" </td>");
                out.println(" </tr>");
            }
            
            out.println(" ");
            out.println(" </tbody>");
            out.println(" </table>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
        }
    }

    protected void vExpedienteSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Curp = request.getParameter("helper");
        Paciente paciente = new Paciente(Curp);
        paciente.getAllData();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Ver Expediente</h1>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
            out.println(" ");
            out.println(" <div class=\"col-lg-12\">");
            out.println(" ");
            out.println(" <!-- Personal Info -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Expediente #"+paciente.getExpediente().getNoExpediente()+"<span id=\"nExp\"></span></h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <div class=\"row container\">");
            out.println(" <div class=\"col\">");
            out.println(" <img class=\"img-profile rounded-circle\" width=\"150\" height=\"150\"");
            out.println(" src=\"assets/img/undraw_profile.svg\">");
            out.println(" <br>");
            out.println(" <h4 class=\"mt-4\" id=\"patient\">"+paciente.getNombre()+" "+paciente.getApellidos()+"</h4>");
            out.println(" <h5 class=\"mt-4\" id=\"edad\">"+paciente.getEdad()+" Años</h5>");
            out.println(" <h5 class=\"mt-4\">Sexo: <span id=\"sexo\">"+(paciente.getExpediente().getGenero()==0?"Masculino":"Femeninio")+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Tel: <span id=\"tel\">"+paciente.getTelefono()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Email: <span id=\"mail\">"+paciente.getEmail()+"</span></h5>");
            out.println(" ");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <h5 class=\"mt-4\">Dirección: <span id=\"dir\">"+paciente.getDireccion()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\"><span id=\"colonia\">"+paciente.getColonia()+"</span> CP: <span id=\"cp\">"+paciente.getCp()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\" id=\"entfed\">"+paciente.getEntFed()+"</h5>");
            out.println(" <h5 class=\"mt-4\">Estado Civil: <span id=\"estcivil\">"+paciente.getExpediente().getEstadoCivil()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Ocupacion: <span id=\"occup\">"+paciente.getExpediente().getOcupacion()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Aseguradora: <span id=\"secure\">"+paciente.getExpediente().getSecure()+"</span></h5>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <!-- Divider -->");
            out.println(" <hr>");
            out.println(" <div class=\"row container\">");
            out.println(" <h4>Antecedentes</h4>");
            out.println(" <div class=\"col-12\">");
            out.println(" <h5 class=\"mt-4\">Alergias: <span id=\"alergias\">"+paciente.getExpediente().getAlergias()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Antecedentes Heredofamiliares: <span id=\"anteHered\">"+paciente.getExpediente().getAntecedentesheredofam()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Antecedentes Personales Patológicos: <span id=\"antePato\">"+paciente.getExpediente().getAntecedentepersonales()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Pacedimiento Actual:</h5>");
            out.println(" <p id=\"padeciActual\">"+paciente.getExpediente().getPacedimentoactual()+"</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <!-- Divider -->");
            out.println(" <hr>");
            out.println(" <h4 class=\"ml-2\">Examen Fisico</h4>");
            out.println(" <div class=\"row container\">");
            out.println(" <div class=\"col-6\">");
            out.println(" <h5 class=\"mt-4\">Peso: <span id=\"peso\">"+paciente.getExpediente().getPeso()+"</span>Kg</h5>");
            out.println(" <h5 class=\"mt-4\">Presión Arterial: <span id=\"pressArte\">"+paciente.getExpediente().getPresArt()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Frecuencia Respiratoria: <span id=\"frecResp\">"+paciente.getExpediente().getFrecResp()+"</span>rpm</h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-6\">");
            out.println(" <h5 class=\"mt-4\">Estatura: <span id=\"estatura\">"+paciente.getExpediente().getEstatura()+"</span>cm</h5>");
            out.println(" <h5 class=\"mt-4\">Frecuencia Cardiaca: <span id=\"frecCard\">"+paciente.getExpediente().getFrecCard()+"</span>ppm</h5>");
            out.println(" <h5 class=\"mt-4\">Temperatura: <span id=\"temp\">"+paciente.getExpediente().getTemper()+"</span>C°</h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-12\">");
            out.println(" <h5 class=\"mt-4\">Topografia: <span id=\"topogr\">"+paciente.getExpediente().getTopografia()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Morfologia:</h5>");
            out.println(" <p id=\"morfo\">"+paciente.getExpediente().getMorfologia()+"</p>");
            out.println(" <h5 class=\"mt-4\">Piel y Anexos: <span id=\"panex\">"+paciente.getExpediente().getPielyAnex()+"</span></h5>");
            out.println(" <h5 class=\"mt-4\">Tratamiento Anterior: <span id=\"tratAnt\">"+paciente.getExpediente().getTratAnterior()+"</span></h5>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <!-- Divider -->");
            out.println(" <hr>");
            out.println(" <h4 class=\"ml-2\">Evaluación y Plan de Seguimiento</h4>");
            out.println(" <div class=\"row container\">");
            out.println(" <div class=\"col-9\">");
            out.println(" <h5 class=\"mt-4\">Diagnostico: <span id=\"diagn\">"+paciente.getExpediente().getDiagnosti()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-3\">");
            out.println(" <h5 class=\"mt-4\">CIE: <span id=\"cie\">"+paciente.getExpediente().getCie()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-12\">");
            out.println(" <h5 class=\"mt-4\">Descripcion:</h5>");
            out.println(" <p id=\"desc\">"+paciente.getExpediente().getDescr()+"</p>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <img src=\"assets/img/hbody.jpg\" width=\"400\" height=\"300\"/>");
            out.println(" </div>");
            out.println(" <div class=\"col\">");
            out.println(" <h5 class=\"mt-4\">Observaciones:</h5>");
            out.println(" <p id=\"obs\">"+paciente.getExpediente().getObservaciones()+"</p>");
            out.println(" </div>");
            out.println(" <div class=\"col-12\">");
            out.println(" <h5 class=\"mt-4\">Plan de Seguimiento:</h5>");
            out.println(" <p id=\"planseg\">"+paciente.getExpediente().getPlanseg()+"</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
            
            for (Cita cita : paciente.getAgenda()) {
            
                out.println(" <div class=\"card shadow mb-4\">");
                out.println(" <div class=\"card-header py-3\">");
                out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Cita "+cita.getFecha()+" "+cita.getHora()+"<span id=\"nExp\"></span></h6>");
                out.println(" </div>");
                out.println(" <div class=\"card-body\">");
                out.println(" <div class=\"row container\">");
                out.println(" <div class=\"col\">");
                out.println(" <h5 class=\"\">Diagnostico: <span id=\"sexo\">"+cita.getReceta().getDiagnostico()+"</span></h5>");
                out.println(" <h5 class=\"mt-4\">Descripcion: <span id=\"tel\">"+cita.getReceta().getDescripcion()+"</span></h5>");
                out.println(" ");
                out.println(" </div>");
                out.println(" <div class=\"col\">");
                out.println(" <h5 >CIE: <span id=\"dir\">"+cita.getReceta().getCie()+"</span></h5>");
                out.println(" <h5 class=\"mt-4\">Observaciones: <span id=\"dir\">"+cita.getReceta().getObserv()+"</span></h5>");
                out.println(" </div>");
                out.println(" </div>");
                out.println(" <!-- Divider -->");
                out.println(" <hr>");
                out.println(" <h4 class=\"ml-2\">Examen Fisico</h4>");
                out.println(" <div class=\"row container\">");
                out.println(" <div class=\"col-6\">");
                out.println(" <h5 class=\"mt-4\">Peso: <span id=\"peso\">"+cita.getReceta().getPeso()+"</span>Kg</h5>");
                out.println(" <h5 class=\"mt-4\">Presión Arterial: <span id=\"pressArte\">"+cita.getReceta().getPresArterial()+"</span></h5>");
                out.println(" <h5 class=\"mt-4\">Frecuencia Respiratoria: <span id=\"frecResp\">"+cita.getReceta().getFrecResp()+"</span>rpm</h5>");
                out.println(" </div>");
                out.println(" <div class=\"col-6\">");
                out.println(" <h5 class=\"mt-4\">Estatura: <span id=\"estatura\">"+cita.getReceta().getEstatura()+"</span>cm</h5>");
                out.println(" <h5 class=\"mt-4\">Frecuencia Cardiaca: <span id=\"frecCard\">"+cita.getReceta().getFrecCardiaca()+"</span>ppm</h5>");
                out.println(" <h5 class=\"mt-4\">Temperatura: <span id=\"temp\">"+cita.getReceta().getTemp()+"</span>C°</h5>");
                out.println(" </div>");
                out.println(" </div>");
                out.println(" <!-- Divider -->");
                out.println(" <hr>");
                out.println(" <h4 class=\"ml-2\">Receta</h4>");
                out.println(" <div class=\"row container\">");
                out.println(" <div class=\"col-12\">");
                
                for (Producto producto : cita.getReceta().JSONtoProduct()) {
                    out.println(" <div class=\"row\">");
                    if(producto.getSku() != null){
                        out.println(" <div class=\"col-md-2\">");
                        out.println(" <h5 class=\"mb-4 text-gray-800\">SKU: "+producto.getSku()+"</h5>");
                        out.println(" </div>");
                    }
                    out.println(" <div class=\"col-md-5\">");
                    out.println(" <h5 class=\"mb-4 text-gray-800\">Nombre: "+producto.getnombre()+"</h5>");
                    out.println(" </div>");
                    out.println(" <div class=\"col-md-4\">");
                    out.println(" <h5 class=\"mb-5 text-gray-800\">Indicaciones: "+producto.getsucursal()+"</h5>");
                    out.println(" </div>");
                    out.println(" </div>");
                }
                
                out.println(" </div>");
                out.println(" </div>");
            }
            
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
        String section = request.getParameter("section");
        switch (section) {
            case "cExpediente":
                cExpedienteSection(request, response);
                break;
            case "cReceta":
                cRecetaSection(request, response);
                break;
            case "pacientes":
                pacientesSection(request, response);
                break;
            case "vExpedientes":
                vExpedientesSection(request, response);
                break;
            case "vExpediente":
                vExpedienteSection(request, response);
                break;
            case "agenda":
                agendaSection(request, response);
                break;
            default:
                sectionNF(request, response);

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
        String action = request.getParameter("action");
        switch (action) {
            case "cExpediente":
                cExpediente(request, response);
                break;
            case "getProd":
                getProductos(request, response);
                break;
            case "cReceta":
                cReceta(request, response);
                break;
            /*case "vExpedientes":
                vExpedientesSection(request, response);
                break;
            case "agenda":
                agendaSection(request, response);
                break;*/
            default:
                sectionNF(request, response);

        }
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

    protected void cExpediente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        Expediente exped = new Expediente(Integer.parseInt(request.getParameter("estcivil")), Integer.parseInt(request.getParameter("sexo")), request.getParameter("occup"), request.getParameter("secure"), request.getParameter("alergias"),
                request.getParameter("anteHered"), request.getParameter("antePato"), request.getParameter("padeciActual"), Integer.parseInt(request.getParameter("peso")), Integer.parseInt(request.getParameter("estatura")),
                request.getParameter("pressArte"), request.getParameter("frecCard"), request.getParameter("frecResp"), Float.parseFloat(request.getParameter("temp")), request.getParameter("topogr"), request.getParameter("morfo"),
                request.getParameter("panex"), request.getParameter("tratAnt"), request.getParameter("diagn"), request.getParameter("cie"), request.getParameter("desc"), request.getParameter("obs"), request.getParameter("planseg"));

        Paciente nPaciente = new Paciente(69, exped, false, request.getParameter("name"), request.getParameter("lastname"), request.getParameter("curp"), Period.between(LocalDate.parse(request.getParameter("birthdate")), LocalDate.now()).getYears(),
                 request.getParameter("email"), "jejejejeje", Long.parseLong(request.getParameter("tel")), LocalDate.parse(request.getParameter("birthdate")), LocalDate.now(), request.getParameter("dir"), request.getParameter("colonia"),
                request.getParameter("entfed"), Integer.parseInt(request.getParameter("cp")));
        Medico medic = new Medico(session.getAttribute("curp").toString(), true);

        nPaciente.guardaPac(request.getParameter("pid"));
        medic.addPaciente(nPaciente);
        exped.crearExpediente(nPaciente.getCurp());

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print("{\"status\":1,\"message\":\"" + nPaciente.getCurp() + "\"}");
    }
    
    protected void getProductos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession(false);
        Empleado encargado = new Empleado(session.getAttribute("curp").toString(), 0);
        Farmacia farm = new Farmacia(encargado.getSucursal());
        ArrayList<Producto> productos = farm.Cargar_Productos_Sucursal();
        String json="";
        for (Producto producto : productos) {
            json+="{\"sku\":\""+producto.getSku()+"\",\"nombre\":\""+producto.getnombre()+"\",\"tamano\":\""+producto.getTamano()+"\"},";
        }
        json = json.substring(0, json.length()-1);
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        out.print("{\"status\":1,\"message\":[" + json + "]}");
    }
    
    
    protected void cReceta(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Receta receta = new Receta(request.getParameter("diagn"), request.getParameter("cie"), request.getParameter("diagn"), request.getParameter("obs"), request.getParameter("planseg"), Float.parseFloat(request.getParameter("peso")), Float.parseFloat(request.getParameter("estatura")), request.getParameter("pressArte"), request.getParameter("frecCard"), request.getParameter("frecResp"), request.getParameter("temp"), request.getParameter("productos"));
        Security encrypt = new Security();
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            receta.saveReceta(Integer.parseInt(request.getParameter("idC")));
            out.print("{\"status\":1,\"message\":\""+encrypt.encriptar(receta.getIdReceta()+"")+"\"}");
        } catch (SQLException ex) {
            Logger.getLogger(medico.class.getName()).log(Level.SEVERE, null, ex);
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
        
    }

}
