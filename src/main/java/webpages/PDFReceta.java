/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Medico;
import com.adoo.cedae.Paciente;
import com.adoo.cedae.Producto;
import com.adoo.cedae.Receta;
import com.adoo.cedae.resources.Security;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
public class PDFReceta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idR = request.getParameter("recipe");
        Security encrypt = new Security();
        String dd = encrypt.desencriptar(idR);
        System.out.println(dd);
        Receta receta = new Receta(Integer.parseInt(encrypt.desencriptar(idR)));
        ArrayList<Producto> productos = new ArrayList<>();
        Cita cita = null;
        try {
            receta.getAllData();
            cita = new Cita(receta.getIdCitaReceta());
            cita.getAllData();
            cita.getPaciente().getAllData();
            cita.getMedicoTit().getAllData();
            productos = receta.JSONtoProduct();
        } catch (SQLException ex) {
            Logger.getLogger(PDFReceta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println(" <html lang=\"en\">");
            out.println(" ");
            out.println(" <head>");
            out.println(" ");
            out.println(" <meta charset=\"utf-8\">");
            out.println(" <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println(" <meta name=\"description\" content=\"\">");
            out.println(" <meta name=\"author\" content=\"\">");
            out.println(" <!-- Favicons -->");
            out.println(" <link href=\"../assets/img/favicon.png\" rel=\"icon\">");
            out.println(" ");
            out.println(" <title>CEDAE - Imprimir Receta</title>");
            out.println(" ");
            out.println(" <!-- Custom fonts for this template-->");
            out.println(" <link href=\"../assets/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println(" <link");
            out.println(" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"");
            out.println(" rel=\"stylesheet\">");
            out.println(" ");
            out.println(" <!-- Custom styles for this template-->");
            out.println(" <link href=\"../assets/css/sb-admin-2.min.css\" rel=\"stylesheet\">");
            out.println(" ");
            out.println(" </head>");
            out.println(" ");
            out.println(" <body>");
            out.println(" <div style=\"background-color: #929292; -webkit-print-color-adjust:exact;\">");
            out.println(" <div class=\"container pt-5 pb-5\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-sm-4 offset-1 pt-3 text-center\">");
            out.println(" <img src=\"../assets/img/faviconW.png\" width=\"100\" height=\"100\" alt=\"Cedae\"/>");
            out.println(" <h5 class=\"text-white\">CEDAE</h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-sm-5 offset-2\">");
            out.println(" <hr>");
            out.println(" <h5 class=\"text-white text-sm-right\">"+cita.getMedicoTit().getNombre()+" "+cita.getMedicoTit().getApellidos()+"</h5>");
            out.println(" <hr>");
            out.println(" <small class=\"text-white text-sm-right\">"+receta.getSucursal()+"</small>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <!-- Page Wrapper -->");
            out.println(" <div id=\"wrapper\" class=\"container mt-4\">");
            out.println(" <!-- Content Wrapper -->");
            out.println(" <div class=\"d-flex flex-column\">");
            out.println(" ");
            out.println(" <!-- Main Content -->");
            out.println(" <div id=\"content\">");
            out.println(" <!-- End of Topbar -->");
            out.println(" ");
            out.println(" <!-- Begin Page Content -->");
            out.println(" <div>");
            out.println(" ");
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-8\">");
            out.println(" <h4 class=\"mb-4 text-gray-800\">Nombre: <span>"+cita.getPaciente().getNombre()+" "+cita.getPaciente().getApellidos()+"</span></h4>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h4 class=\"mb-4 text-gray-800\">Fecha: <span>"+cita.getFecha()+"</span></h4>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Peso: <span>"+receta.getPeso()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Estatura: <span>"+receta.getEstatura()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Presion Arterial: <span>"+receta.getPresArterial()+"</span></h5>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" ");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Frecuencia Cardiaca: <span>"+receta.getFrecCardiaca()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Frecuencia Respiratoria: <span>"+receta.getFrecResp()+"</span></h5>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <h5 class=\"mb-4 text-gray-800\">Temperatura: <span>"+receta.getTemp()+"</span></h5>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <hr>");
            
            for (Producto producto : productos) {
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
            out.println(" <!-- /.container-fluid -->");
            out.println(" ");
            out.println(" </div>");
            out.println(" <!-- End of Main Content -->");
            out.println(" ");
            out.println(" <!-- Footer -->");
            out.println(" <footer class=\"sticky-footer bg-white\">");
            out.println(" <div class=\"container my-auto\">");
            out.println(" <div class=\"copyright text-center my-auto\">");
            out.println(" <span>Copyright © CEDAE 2020</span>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </footer>");
            out.println(" <!-- End of Footer -->");
            out.println(" ");
            out.println(" </div>");
            out.println(" <!-- End of Content Wrapper -->");
            out.println(" ");
            out.println(" </div>");
            out.println(" <script>");
            out.println(" window.onload = (event) => {");
            out.println(" window.print();");
            out.println(" };");
            out.println(" </script>");
            out.println(" ");
            out.println(" </body>");
            out.println(" ");
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
        processRequest(request, response);
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
