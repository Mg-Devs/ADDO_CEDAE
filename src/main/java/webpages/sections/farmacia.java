/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages.sections;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            out.println(" <tr>");
            out.println(" <td>Gel Moussant Limpiador Purificante</td>");
            out.println(" <td>154754.5</td>");
            out.println(" <td>400ml</td>");
            out.println(" <td>61</td>");
            out.println(" <td>2023/04/25</td>");
            out.println(" <td>$320</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Acniben Skin Rx Gel Crema Hidratante</td>");
            out.println(" <td>200070.4</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>25</td>");
            out.println(" <td>2022/07/25</td>");
            out.println(" <td>$170</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bioderma Sebium Gel Espumoso Limpiador Purificante</td>");
            out.println(" <td>166650.5</td>");
            out.println(" <td>500ml</td>");
            out.println(" <td>15</td>");
            out.println(" <td>2021/01/12</td>");
            out.println(" <td>$86</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Nutradeica Gel-Crema Facial Piel Seborreica</td>");
            out.println(" <td>154888.7</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>22</td>");
            out.println(" <td>2021/03/29</td>");
            out.println(" <td>$433</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bioderma Sébium Sensitive Cuidado Calmante Antiimperfecciones</td>");
            out.println(" <td>184310.4</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>33</td>");
            out.println(" <td>2022/11/28</td>");
            out.println(" <td>$162</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Fotoprotector Pediatrics Fusion Fluid Mineral Baby SPF50+</td>");
            out.println(" <td>178899.3</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>61</td>");
            out.println(" <td>2025/12/02</td>");
            out.println(" <td>$372</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare Tensage Ampollas</td>");
            out.println(" <td>FD5502340</td>");
            out.println(" <td>20x2ml</td>");
            out.println(" <td>59</td>");
            out.println(" <td>2025/08/06</td>");
            out.println(" <td>$137</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Lierac Sunissime Fluido Protector Revitalizante Rostro SPF50+</td>");
            out.println(" <td>L0037</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>55</td>");
            out.println(" <td>2021/10/14</td>");
            out.println(" <td>$327</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bella Aurora Bio10 Solar Protector</td>");
            out.println(" <td>197615.4</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>39</td>");
            out.println(" <td>2025/09/15</td>");
            out.println(" <td>$205</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Apivita Express Beauty Sheet Mask Algarroba</td>");
            out.println(" <td>00-22-44-154</td>");
            out.println(" <td>20ml</td>");
            out.println(" <td>23</td>");
            out.println(" <td>2028/12/13</td>");
            out.println(" <td>$103</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Eucerin Pack Hyaluron-Filler Crema Día PNM</td>");
            out.println(" <td>FD55203</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>30</td>");
            out.println(" <td>2028/12/19</td>");
            out.println(" <td>$900</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Martiderm Proteos Screen SPF50+</td>");
            out.println(" <td>193613.4</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>22</td>");
            out.println(" <td>2023/03/03</td>");
            out.println(" <td>$342</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>La Roche-Posay Solución Micelar</td>");
            out.println(" <td>317171.7</td>");
            out.println(" <td>200ml</td>");
            out.println(" <td>36</td>");
            out.println(" <td>2028/10/16</td>");
            out.println(" <td>$470</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>CeraVe Gel Limpiador Espumoso</td>");
            out.println(" <td>187652.2</td>");
            out.println(" <td>473 ml</td>");
            out.println(" <td>43</td>");
            out.println(" <td>2022/12/18</td>");
            out.println(" <td>$313</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Biretix Pack Tri-Active</td>");
            out.println(" <td>P190828</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>19</td>");
            out.println(" <td>2022/03/17</td>");
            out.println(" <td>$385</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Neostrata Gel Forte Salicílico</td>");
            out.println(" <td>213017.3</td>");
            out.println(" <td>100ml</td>");
            out.println(" <td>66</td>");
            out.println(" <td>2022/11/27</td>");
            out.println(" <td>$198</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Sensilis Skin Delight Peeling Negro Revitalizante</td>");
            out.println(" <td>176389.1</td>");
            out.println(" <td>75g</td>");
            out.println(" <td>64</td>");
            out.println(" <td>2023/06/09</td>");
            out.println(" <td>$725</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare C Peel Gel 5 sobres</td>");
            out.println(" <td>171350.6</td>");
            out.println(" <td>6ml</td>");
            out.println(" <td>59</td>");
            out.println(" <td>2022/04/10</td>");
            out.println(" <td>$237</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Repavar Monoderma C10 Revitalizante Duplo</td>");
            out.println(" <td>586545FDT</td>");
            out.println(" <td>2x28 Cápsulas</td>");
            out.println(" <td>41</td>");
            out.println(" <td>2022/10/13</td>");
            out.println(" <td>$632</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Martiderm Proteos Hydra Plus</td>");
            out.println(" <td>247379.9</td>");
            out.println(" <td>30 Ampollas</td>");
            out.println(" <td>35</td>");
            out.println(" <td>2022/09/26</td>");
            out.println(" <td>$217</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare Pack Radiance C Oil</td>");
            out.println(" <td>P171315</td>");
            out.println(" <td>30 Ampollas</td>");
            out.println(" <td>30</td>");
            out.println(" <td>2021/09/03</td>");
            out.println(" <td>$345</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Neostrata Skin Active Matrix Serum Antioxidante</td>");
            out.println(" <td>167065.6</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>40</td>");
            out.println(" <td>2023/06/25</td>");
            out.println(" <td>$675</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Plante System Fluido Desfatigante Facial Précieuse Edelweiss</td>");
            out.println(" <td>176331.0</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>21</td>");
            out.println(" <td>2021/12/12</td>");
            out.println(" <td>$106</td>");
            out.println(" <td>");
            out.println(" <button class=\"btn btn-sm btn-primary btn-circle\" onclick=\"editProd(this)\">");
            out.println(" <i class=\"fas fa-edit\"></i>");
            out.println(" </button>");
            out.println(" <button class=\"btn btn-sm btn-danger btn-circle\" onclick=\"deleteProd(this)\">");
            out.println(" <i class=\"fas fa-trash\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
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
            out.println(" <tr>");
            out.println(" <td>Gel Moussant Limpiador Purificante</td>");
            out.println(" <td>154754.5</td>");
            out.println(" <td>400ml</td>");
            out.println(" <td>61</td>");
            out.println(" <td>2023/04/25</td>");
            out.println(" <td>$320</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Acniben Skin Rx Gel Crema Hidratante</td>");
            out.println(" <td>200070.4</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>25</td>");
            out.println(" <td>2022/07/25</td>");
            out.println(" <td>$170</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bioderma Sebium Gel Espumoso Limpiador Purificante</td>");
            out.println(" <td>166650.5</td>");
            out.println(" <td>500ml</td>");
            out.println(" <td>15</td>");
            out.println(" <td>2021/01/12</td>");
            out.println(" <td>$86</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Nutradeica Gel-Crema Facial Piel Seborreica</td>");
            out.println(" <td>154888.7</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>22</td>");
            out.println(" <td>2021/03/29</td>");
            out.println(" <td>$433</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bioderma Sébium Sensitive Cuidado Calmante Antiimperfecciones</td>");
            out.println(" <td>184310.4</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>33</td>");
            out.println(" <td>2022/11/28</td>");
            out.println(" <td>$162</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Isdin Fotoprotector Pediatrics Fusion Fluid Mineral Baby SPF50+</td>");
            out.println(" <td>178899.3</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>61</td>");
            out.println(" <td>2025/12/02</td>");
            out.println(" <td>$372</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare Tensage Ampollas</td>");
            out.println(" <td>FD5502340</td>");
            out.println(" <td>20x2ml</td>");
            out.println(" <td>59</td>");
            out.println(" <td>2025/08/06</td>");
            out.println(" <td>$137</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Lierac Sunissime Fluido Protector Revitalizante Rostro SPF50+</td>");
            out.println(" <td>L0037</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>55</td>");
            out.println(" <td>2021/10/14</td>");
            out.println(" <td>$327</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Bella Aurora Bio10 Solar Protector</td>");
            out.println(" <td>197615.4</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>39</td>");
            out.println(" <td>2025/09/15</td>");
            out.println(" <td>$205</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Apivita Express Beauty Sheet Mask Algarroba</td>");
            out.println(" <td>00-22-44-154</td>");
            out.println(" <td>20ml</td>");
            out.println(" <td>23</td>");
            out.println(" <td>2028/12/13</td>");
            out.println(" <td>$103</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Eucerin Pack Hyaluron-Filler Crema Día PNM</td>");
            out.println(" <td>FD55203</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>30</td>");
            out.println(" <td>2028/12/19</td>");
            out.println(" <td>$900</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Martiderm Proteos Screen SPF50+</td>");
            out.println(" <td>193613.4</td>");
            out.println(" <td>40ml</td>");
            out.println(" <td>22</td>");
            out.println(" <td>2023/03/03</td>");
            out.println(" <td>$342</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>La Roche-Posay Solución Micelar</td>");
            out.println(" <td>317171.7</td>");
            out.println(" <td>200ml</td>");
            out.println(" <td>36</td>");
            out.println(" <td>2028/10/16</td>");
            out.println(" <td>$470</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>CeraVe Gel Limpiador Espumoso</td>");
            out.println(" <td>187652.2</td>");
            out.println(" <td>473 ml</td>");
            out.println(" <td>43</td>");
            out.println(" <td>2022/12/18</td>");
            out.println(" <td>$313</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Biretix Pack Tri-Active</td>");
            out.println(" <td>P190828</td>");
            out.println(" <td>50ml</td>");
            out.println(" <td>19</td>");
            out.println(" <td>2022/03/17</td>");
            out.println(" <td>$385</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Neostrata Gel Forte Salicílico</td>");
            out.println(" <td>213017.3</td>");
            out.println(" <td>100ml</td>");
            out.println(" <td>66</td>");
            out.println(" <td>2022/11/27</td>");
            out.println(" <td>$198</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Sensilis Skin Delight Peeling Negro Revitalizante</td>");
            out.println(" <td>176389.1</td>");
            out.println(" <td>75g</td>");
            out.println(" <td>64</td>");
            out.println(" <td>2023/06/09</td>");
            out.println(" <td>$725</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare C Peel Gel 5 sobres</td>");
            out.println(" <td>171350.6</td>");
            out.println(" <td>6ml</td>");
            out.println(" <td>59</td>");
            out.println(" <td>2022/04/10</td>");
            out.println(" <td>$237</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Repavar Monoderma C10 Revitalizante Duplo</td>");
            out.println(" <td>586545FDT</td>");
            out.println(" <td>2x28 Cápsulas</td>");
            out.println(" <td>41</td>");
            out.println(" <td>2022/10/13</td>");
            out.println(" <td>$632</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Martiderm Proteos Hydra Plus</td>");
            out.println(" <td>247379.9</td>");
            out.println(" <td>30 Ampollas</td>");
            out.println(" <td>35</td>");
            out.println(" <td>2022/09/26</td>");
            out.println(" <td>$217</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Endocare Pack Radiance C Oil</td>");
            out.println(" <td>P171315</td>");
            out.println(" <td>30 Ampollas</td>");
            out.println(" <td>30</td>");
            out.println(" <td>2021/09/03</td>");
            out.println(" <td>$345</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Neostrata Skin Active Matrix Serum Antioxidante</td>");
            out.println(" <td>167065.6</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>40</td>");
            out.println(" <td>2023/06/25</td>");
            out.println(" <td>$675</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
            out.println(" <tr>");
            out.println(" <td>Plante System Fluido Desfatigante Facial Précieuse Edelweiss</td>");
            out.println(" <td>176331.0</td>");
            out.println(" <td>30ml</td>");
            out.println(" <td>21</td>");
            out.println(" <td>2021/12/12</td>");
            out.println(" <td>$106</td>");
            out.println(" <td class=\"text-center\">");
            out.println(" <button class=\"btn btn-sm btn-info btn-circle\" onclick=\"addProd(this)\">");
            out.println(" <i class=\"fas fa-plus\"></i>");
            out.println(" </button>");
            out.println(" </td>");
            out.println(" </tr>");
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
            out.println(" <a role=\"button\" class=\"btn btn-success btn-icon-split disabled\" id=\"createExpediente\">");
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
        //processRequest(request, response);
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
