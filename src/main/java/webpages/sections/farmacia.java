/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages.sections;

import com.adoo.cedae.Empleado;
import com.adoo.cedae.Farmacia;
import com.adoo.cedae.Lote;
import com.adoo.cedae.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author mario
 */
@WebServlet(name = "apiFarmacia", urlPatterns = {"/api/sections/farmacia"})
public class farmacia extends HttpServlet {

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

    protected void vInventarioSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado encargado = new Empleado(session.getAttribute("curp").toString(), 0);
        Farmacia farm = new Farmacia(encargado.getSucursal());
        ArrayList<Producto> productos = farm.Cargar_Productos_Sucursal();
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println(" <!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Inventario</h1>");
            out.println(" </div>");
            out.println(" </div>");

            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");

            out.println(" <div class=\"col-md-12\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Productos</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <button class=\"btn btn-info btn-icon-split mb-4\" id=\"agProd\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Agregar Producto</span>");
            out.println(" </button>");

            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>SKU</th>");
            out.println(" <th>Tamaño</th>");
            out.println(" <th>Unidades</th>");
            out.println(" <th>Fecha de Expiración Proxima</th>");
            out.println(" <th>Precio</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>SKU</th>");
            out.println(" <th>Tamaño</th>");
            out.println(" <th>Unidades</th>");
            out.println(" <th>Fecha de Expiración Proxima</th>");
            out.println(" <th>Precio</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");
            
            for(Producto producto : productos) {
                out.println(" <tr>");
                out.println(" <td>"+producto.getnombre()+"</td>");
                out.println(" <td>"+producto.getSku()+"</td>");
                out.println(" <td>"+producto.getTamano()+"</td>");
                out.println(" <td>"+producto.getUnidadesTotales()+"</td>");
                out.println(" <td>"+producto.getCaducidadProxima().toString()+"</td>");
                out.println(" <td>$"+producto.getPrecio()+"</td>");
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
        }
    }

    protected void nVentaSection(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Empleado encargado = new Empleado(session.getAttribute("curp").toString(), 0);
        Farmacia farm = new Farmacia(encargado.getSucursal());
        ArrayList<Producto> productos = farm.Cargar_Productos_Sucursal();
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!-- Page Heading -->");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col\">");
            out.println(" <h1 class=\"h3 mb-4 text-gray-800\">Realizar Venta</h1>");
            out.println(" </div>");
            out.println(" </div>");
             
            out.println(" <!-- CONTENT -->");
            out.println(" <div class=\"row\" id=\"content-panel\">");
             
            out.println(" <div class=\"col-md-8\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Productos</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <div class=\"table-responsive\">");
            out.println(" <table class=\"table table-bordered\" id=\"dataTable\" width=\"100%\" cellspacing=\"0\">");
            out.println(" <thead>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>SKU</th>");
            out.println(" <th>Tamaño</th>");
            out.println(" <th>Unidades</th>");
            out.println(" <th>Fecha de Expiración</th>");
            out.println(" <th>Precio</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </thead>");
            out.println(" <tfoot>");
            out.println(" <tr>");
            out.println(" <th>Nombre</th>");
            out.println(" <th>SKU</th>");
            out.println(" <th>Tamaño</th>");
            out.println(" <th>Unidades</th>");
            out.println(" <th>Fecha de Expiración</th>");
            out.println(" <th>Precio</th>");
            out.println(" <th>Opciones</th>");
            out.println(" </tr>");
            out.println(" </tfoot>");
            out.println(" <tbody id=\"productTable\">");
            
            for(Producto producto : productos) {
                out.println(" <tr>");
                out.println(" <td>"+producto.getnombre()+"</td>");
                out.println(" <td>"+producto.getSku()+"</td>");
                out.println(" <td>"+producto.getTamano()+"</td>");
                out.println(" <td>"+producto.getUnidadesTotales()+"</td>");
                out.println(" <td>"+producto.getCaducidadProxima().toString()+"</td>");
                out.println(" <td>$"+producto.getPrecio()+"</td>");
                out.println(" <td>");
                out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
                out.println(" <i class=\"fas fa-plus\"></i>");
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
            out.println(" <div class=\"col-md-4\">");
            out.println(" <!-- Products -->");
            out.println(" <div class=\"card shadow mb-4\">");
            out.println(" <div class=\"card-header py-3\">");
            out.println(" <h6 class=\"m-0 font-weight-bold text-primary\">Cuenta</h6>");
            out.println(" </div>");
            out.println(" <div class=\"card-body\">");
            out.println(" <div id=\"productos\"></div>");
            out.println(" <div class=\"text-right\"><strong>Total: </strong><span id=\"total\">$0</span></div>");
            out.println(" <div>");
            out.println(" <a role=\"button\" class=\"btn btn-success btn-icon-split\" onclick=\"sell()\">");
            out.println(" <span class=\"icon text-white-50\">");
            out.println(" <i class=\"fas fa-check\"></i>");
            out.println(" </span>");
            out.println(" <span class=\"text\">Confirmar</span>");
            out.println(" </a>");
            out.println(" </div>");
            out.println(" </div>");
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
            case "inventario":
                vInventarioSection(request, response);
                break;
            case "nventa":
                nVentaSection(request, response);
                break;
            /*case "pacientes":
                pacientesSection(request, response);
                break;
            case "vExpedientes":
                vExpedientesSection(request, response);
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
        
        String json = request.getParameter("test");
        json = json.replace("\\\"","\""); 
        System.out.println(json);
        if(!"".equals(json)){
            Empleado encargado = new Empleado(session.getAttribute("curp").toString(), 0);
            Farmacia farm = new Farmacia(encargado.getSucursal());
            farm.Cargar_Productos_Sucursal();
            try {
                farm.actualizar_stock_venta(json);
            } catch (ParseException | java.text.ParseException | SQLException ex) {
                Logger.getLogger(farmacia.class.getName()).log(Level.SEVERE, null, ex);
            }
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
