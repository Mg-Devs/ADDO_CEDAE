/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages.sections;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Medico;
import com.adoo.cedae.Paciente;
import com.adoo.cedae.Recepcionista;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mario
 */
@WebServlet(name = "recepcionistaApi", urlPatterns = {"/api/sections/recepcionista"})
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
    
    protected void vCitas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Recepcionista recepcion = new Recepcionista(session.getAttribute("curp").toString(), 0);
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            citas = recepcion.GetCitas();
        } catch (SQLException ex) {
            Logger.getLogger(webpages.recepcionista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
        }
    }
    
    protected void vcitaspp(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Recepcionista recepcion = new Recepcionista(session.getAttribute("curp").toString(), 0);
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            citas = recepcion.GetCitasPP();
        } catch (SQLException ex) {
            Logger.getLogger(webpages.recepcionista.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Pagar</h1>");
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
             
            out.println(" <div class=\"col-md-12\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Citas Pendientes De Pagar</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
             
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
                out.println(" <button class=\"btn btn-sm btn-success btn-circle\" onclick=\"payProd(this)\">");
                out.println(" <i class=\"fas fa-dollar-sign\"></i>");
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
        String section = request.getParameter("section");
        switch (section) {
            case "vcitas":
                vCitas(request, response);
                break;
            case "vcitaspp":
                vcitaspp(request, response);
                break;
            /*case "pacientes":
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
                break;*/
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
        session = request.getSession(false);
        String section = request.getParameter("action");
        switch (section) {
            case "cFecha":
                cFecha(request, response);
                break;
            case "modCita":
                modCita(request, response);
                break;
            case "delCita":
                delCita(request, response);
                break;
            case "getMedPac":
                getMedPac(request, response);
                break;
            case "createCita":
                createCita(request, response);
                break;
            case "pCita":
                pCita(request, response);
                break;
            case "pCitaCrear":
                pCitaCrear(request, response);
                break;
            case "pagarCita":
                pagarCita(request, response);
                break;
            /*case "agenda":
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
    
    protected void cFecha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            String result = "{\"hrdisp\":[";
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            boolean horarioDisp[] = auxObj.getHorarioParaCitaMedico(request.getParameter("curpmed"), request.getParameter("date").replace('/', '-'), auxObj.getSucursal(), Integer.parseInt(request.getParameter("durac")));

            for (int i = 0; i < horarioDisp.length; i++) {
                if(horarioDisp[i]){
                    LocalTime hora = LocalTime.parse("09:00",DateTimeFormatter.ofPattern("HH:mm"));
                    hora=hora.plusHours((long)i/4);
                    if((i/4f)%4 != 0){
                        hora=hora.plusMinutes((long) (((i/4f)%4 - (i/4)%4)*1500f/25));
                    }
                    result+="\""+hora.toString()+"\""+",";
                }
            }
            result = result.substring(0, result.length()-1);
            result+= "]}";
            out.print(result);
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void pCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            String result = "{\"hrdisp\":[";
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);;
            boolean horarioDisp[] = auxObj.getHorarioParaCita(request.getParameter("date").replace('/', '-'), auxObj.getSucursal(), 4);
            
            for (int i = 0; i < horarioDisp.length; i++) {
                if(horarioDisp[i]){
                    LocalTime hora = LocalTime.parse("09:00",DateTimeFormatter.ofPattern("HH:mm"));
                    hora=hora.plusHours((long)i/4);
                    if((i/4f)%4 != 0){
                        hora=hora.plusMinutes((long) (((i/4f)%4 - (i/4)%4)*1500f/25));
                    }
                    result+="\""+hora.toString()+"\""+",";
                }
            }
            result = result.substring(0, result.length()-1);
            result+= "]}";
            out.print(result);
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void getMedPac(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            String medic = "", pac = "";
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            ArrayList<Medico> medicos = auxObj.GetMedicos();
            ArrayList<Paciente> pacientes = auxObj.GetPacientes();
            for (Medico medico : medicos) {
                if(medico.isMedicoTitular()){
                    medico.getAllData();
                    medic+= "{\"nombre\":\""+medico.getNombre()+" "+medico.getApellidos()+"\", \"curp\":\""+medico.getCurp()+"\"},";
                }
            }
            medic = medic.substring(0, medic.length()-1);
            
            for (Paciente paciente : pacientes) {
                paciente.getAllData();
                pac+= "{\"nombre\":\""+paciente.getNombre()+" "+paciente.getApellidos()+"\", \"curp\":\""+paciente.getCurp()+"\"},";
            }
            pac = pac.substring(0, pac.length()-1);
            
            out.print("{\"status\":1,\"message\":\"OK\", \"medicos\":["+medic+"], \"pacientes\":["+pac+"]}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void pCitaCrear(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        String result;
        
        Paciente nPaciente = new Paciente(request.getParameter("name"), request.getParameter("lastname"), request.getParameter("email"), Long.parseLong(request.getParameter("tel")));
        if(nPaciente.isRegistered(request.getParameter("email")))
            result ="{\"status\":0, \"message\": \"Este Correo ya se encuentra registrado, te recomendamos ponerte en contacto con la clinica.\"}";
        else{
            nPaciente.guardarPacienteTemp();
            Recepcionista helper = new Recepcionista(session.getAttribute("curp").toString(), 0);
            String cMedicT = helper.medicoTitDisponible(request.getParameter("date").replace('/', '-'), helper.getSucursal(), request.getParameter("time"),4);
            String cMedicA = helper.medicoAuxDisponible(request.getParameter("date").replace('/', '-'), helper.getSucursal(), request.getParameter("time"),4);
            Medico medic = new Medico(cMedicT,true);
            Medico medic2 = new Medico(cMedicA,false);
            result ="{\"status\":1, \"message\": \"";
            result += helper.generarCita(nPaciente, medic, medic2, helper.getSucursal(), request.getParameter("date").replace('/', '-'), request.getParameter("time"),4);
            result += "\"}";
        }
        
        out.print(result);
    }
    
    protected void createCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            String res = auxObj.generarCita(new Paciente(request.getParameter("cPac")), new Medico(request.getParameter("cMed"), true), new Medico(auxObj.medicoAuxDisponible(request.getParameter("date").replace('/', '-'), auxObj.getSucursal(), request.getParameter("hora"), Integer.parseInt(request.getParameter("durac"))), false), auxObj.getSucursal(), request.getParameter("date").replace('/', '-'), request.getParameter("hora"), Integer.parseInt(request.getParameter("durac")));
            if(res.equals("OK"))
                out.print("{\"status\":1,\"message\":\"OK\"}");
            else
                out.print("{\"status\":0,\"message\":\""+res+"\"}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void modCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            auxObj.modificarCita(Integer.parseInt(request.getParameter("idCita")), LocalDate.parse(request.getParameter("date").replace('/', '-')), LocalTime.parse(request.getParameter("hora")), Integer.parseInt(request.getParameter("durac")));
            
            out.print("{\"status\":1,\"message\":\"OK\"}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void delCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            auxObj.cancelarCita(Integer.parseInt(request.getParameter("idCita")));
            
            out.print("{\"status\":1,\"message\":\"OK\"}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void pagarCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            Recepcionista auxObj = new Recepcionista(session.getAttribute("curp").toString(), 0);
            auxObj.pagarCita(Integer.parseInt(request.getParameter("idCita")));
            
            out.print("{\"status\":1,\"message\":\"OK\"}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
