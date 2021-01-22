/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages.sections;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Medico;
import com.adoo.cedae.Paciente;
import com.adoo.cedae.Producto;
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
@WebServlet(name = "pacienteApi", urlPatterns = {"/api/sections/paciente"})
public class paciente extends HttpServlet {

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
        
        Recepcionista recepcion = new Recepcionista();
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            citas = recepcion.GetMisCitas(session.getAttribute("curp").toString());
        } catch (SQLException ex) {
            Logger.getLogger(recepcionista.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            
            //out.println(" <div class=\"row\">");
            //out.println(" <div class=\"col-md-2\">");
            out.println(" <button class=\"btn btn-info btn-icon-split mb-4\" id=\"agProd\" onclick=\"agProd()\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Agendar Cita</span>");
            out.println(" </button>");
            //out.println(" </div>");
            //out.println(" </div>");
             
            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Sucursal</th>");
            out.println(" <th>Hora</th>");
            out.println(" <th>Fecha</th>");
            out.println(" <th>Doctor</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Sucursal</th>");
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
                out.println(" <td data-cpaciente=\""+cita.getPaciente().getCurp()+"\">"+cita.getSucursal()+"</td>");
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
    
    protected void vExpedienteSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Paciente paciente = new Paciente(session.getAttribute("curp").toString());
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
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Expediente #"+paciente.getExpediente().getNoExpediente()+"<span id=\"nExp\"></span></h6>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-2 offset-7\">");
            out.println(" <label> </label>");
            out.println(" </div>");
            out.println(" </div>");
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
                out.println(" </div>");
                out.println(" </div>");
            }
            
            out.println(" ");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
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
            /*case "recetas":
                vcitaspp(request, response);
                break;*/
            case "vexped":
                vExpedienteSection(request, response);
                break;
            /*case "vExpedientes":
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
            case "getMedSuc":
                getMedSuc(request, response);
                break;
            case "createCita":
                createCita(request, response);
                break;
            /*case "pCita":
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
    
    protected void cFecha(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            String result = "{\"hrdisp\":[";
            Recepcionista auxObj = new Recepcionista();
            auxObj.setSucursal(request.getParameter("sucursal"));
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
    
    protected void getMedSuc(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        try {
            String medic = "", pac = "";
            Recepcionista auxObj = new Recepcionista();
            ArrayList<Medico> medicos = auxObj.GetMedicosPac(session.getAttribute("curp").toString(),request.getParameter("sucursal"));
            if(medicos.size()>0){
                for (Medico medico : medicos) {
                    if(medico.isMedicoTitular()){
                        medico.getAllData();
                        medic+= "{\"nombre\":\""+medico.getNombre()+" "+medico.getApellidos()+"\", \"curp\":\""+medico.getCurp()+"\"},";
                    }
                }
                medic = medic.substring(0, medic.length()-1);
            }
            
            out.print("{\"status\":1,\"message\":\"OK\", \"medicos\":["+medic+"]}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
        }
    }
    
    protected void createCita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        System.out.println("Curp Med: "+request.getParameter("cMed"));
        
        try {
            Recepcionista auxObj = new Recepcionista();
            auxObj.setSucursal(request.getParameter("sucursal"));
            String res = auxObj.generarCita(new Paciente(session.getAttribute("curp").toString()), new Medico(request.getParameter("cMed"), true), new Medico(auxObj.medicoAuxDisponible(request.getParameter("date").replace('/', '-'), auxObj.getSucursal(), request.getParameter("hora"), Integer.parseInt(request.getParameter("durac"))), false), auxObj.getSucursal(), request.getParameter("date").replace('/', '-'), request.getParameter("hora"), Integer.parseInt(request.getParameter("durac")));
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
            Recepcionista auxObj = new Recepcionista();
            auxObj.setSucursal(request.getParameter("sucursal"));
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
            Recepcionista auxObj = new Recepcionista();
            auxObj.cancelarCita(Integer.parseInt(request.getParameter("idCita")));
            
            out.print("{\"status\":1,\"message\":\"OK\"}");
        } catch (Exception ex) {
            out.print("{\"status\":0,\"message\":\"FAIL: "+ex.getMessage()+"\"}");
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

}
