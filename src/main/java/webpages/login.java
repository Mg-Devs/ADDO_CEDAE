/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import com.adoo.cedae.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mario
 */
public class login extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

            out.println(" <html lang=\"en\">");
            out.println(" <head>");
            out.println(" <meta charset=\"utf-8\">");
            out.println(" <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
            out.println(" <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">");
            out.println(" <meta name=\"description\" content=\"\">");
            out.println(" <meta name=\"author\" content=\"\">");
            out.println(" <title>CEDAE - Login</title>");
            out.println(" <link href=\"assets/img/favicon.png\" rel=\"icon\">");
            out.println(" <link href=\"assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">");
            out.println(" <!-- Custom fonts for this template-->");
            out.println(" <link href=\"assets/vendor/fontawesome-free/css/all.min.css\" rel=\"stylesheet\" type=\"text/css\">");
            out.println(" <link");
            out.println(" href=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"");
            out.println(" rel=\"stylesheet\">");
            out.println(" <!-- Custom styles for this template-->");
            out.println(" <link href=\"assets/css/sb-admin-2.min.css\" rel=\"stylesheet\">");
            out.println(" </head>");
            out.println(" <body class=\"bg-gradient-primary\">");
            out.println(" <div class=\"container mt-5\">");
            out.println(" <!-- Outer Row -->");
            out.println(" <div class=\"row justify-content-center\">");
            out.println(" <div class=\"col-md-12 text-center\">");
            out.println(" <div class=\"\">");
            out.println(" <img src=\"assets/img/cedae-logoWnL.png\" alt=\"CEDAE\" class=\"img-fluid\">");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-8 col-lg-5\">");
            out.println(" <div class=\"card o-hidden border-0 shadow-lg my-5\">");
            out.println(" <div class=\"card-body p-0\">");
            out.println(" <div class=\"p-5\">");
            out.println(" <div class=\"text-center\">");
            out.println(" <h1 class=\"h4 text-gray-900 mb-4\">Iniciar Sesion</h1>");
            out.println(" </div>");
            out.println(" <form class=\"user\">");
            out.println(" <div class=\"form-group\">");
            out.println(" <input type=\"email\" class=\"form-control form-control-user\"");
            out.println(" id=\"email\" name=\"email\" aria-describedby=\"emailHelp\"");
            out.println(" placeholder=\"Correo Electronico\" data-rule=\"email\" data-msg=\"Ingresa un correo valido\">");
            out.println(" <div class=\"validate text-center mt-1\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"form-group\">");
            out.println(" <input type=\"password\" class=\"form-control form-control-user\"");
            out.println(" id=\"password\" name=\"password\" placeholder=\"Contraseña\" data-rule=\"required\" data-msg=\"Ingresa la contraseña\">");
            out.println(" <div class=\"validate text-center mt-1\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"form-group\">");
            out.println(" <div class=\"custom-control custom-checkbox small\">");
            out.println(" <input type=\"checkbox\" class=\"custom-control-input\" id=\"customCheck\">");
            out.println(" <label class=\"custom-control-label\" for=\"customCheck\">Recuerdme</label>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <button type=\"submit\" id=\"login\" class=\"btn btn-primary btn-user btn-block\">");
            out.println(" Ingresar");
            out.println(" </button>");
            out.println(" <div id=\"loginInfo\" class=\"validate text-center mt-2\"></div>");
            out.println(" </form>");
            out.println(" <hr>");
            out.println(" <div class=\"text-center\">");
            out.println(" <a class=\"small\" href=\"forgot-password.html\">Olvide mi contraseña</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
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
            out.println(" <script src=\"assets/js/login.js\" type=\"text/javascript\"></script>");
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
        Persona user = new Persona();
        String result = user.logIn(request.getParameter("email"), request.getParameter("password"));
        int state = 0;

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        if(result.contains("OK")){
            state = 1;
            HttpSession session = request.getSession(true);
            session.setAttribute("nombre", user.getNombre());
            session.setAttribute("apellido", user.getApellidos());
            session.setAttribute("curp", user.getCurp());
            session.setAttribute("email", user.getEmail());
        }
            
        out.print("{\"status\":"+state+",\"message\":\""+result+"\"}");
        
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
