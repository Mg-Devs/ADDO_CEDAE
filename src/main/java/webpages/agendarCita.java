/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import com.adoo.cedae.Cita;
import com.adoo.cedae.Medico;
import com.adoo.cedae.Paciente;
import com.adoo.cedae.Recepcionista;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
public class agendarCita extends HttpServlet {

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
            out.println(" <!DOCTYPE html>");
            out.println(" <html lang=\"en\">");
            out.println(" <head>");
            out.println(" <meta charset=\"utf-8\">");
            out.println(" <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">");
            out.println(" <title>CEDAE - Inicio</title>");
            out.println(" <meta content=\"\" name=\"descriptison\">");
            out.println(" <meta content=\"\" name=\"keywords\">");
            out.println(" <!-- Favicons -->");
            out.println(" <link href=\"assets/img/favicon.png\" rel=\"icon\">");
            out.println(" <link href=\"assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">");
            out.println(" <!-- Google Fonts -->");
            out.println(" <link href=\"https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,700,700i&display=swap\" rel=\"stylesheet\">");
            out.println(" <!-- Vendor CSS Files -->");
            out.println(" <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/animate.css/animate.min.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/icofont/icofont.min.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/venobox/venobox.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/owl.carousel/assets/owl.carousel.min.css\" rel=\"stylesheet\">");
            out.println(" <link href=\"assets/vendor/aos/aos.css\" rel=\"stylesheet\">");
            out.println(" <!-- Template Main CSS File -->");
            out.println(" <link href=\"assets/css/style.css\" rel=\"stylesheet\">");
            out.println(" <!-- Date Picker -->");
            out.println(" <link rel=\"stylesheet\" href=\"assets/vendor/flat-picker/flatpickr.min.css\">");
            out.println(" <link rel=\"stylesheet\" href=\"assets/vendor/flat-picker/themes/material_blue.css\">");
            out.println(" <!-- =======================================================");
            out.println(" * Template Name: Moderna - v2.1.0");
            out.println(" * Template URL: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/");
            out.println(" * Author: BootstrapMade.com");
            out.println(" * License: https://bootstrapmade.com/license/");
            out.println(" ======================================================== -->");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <!-- ======= Header ======= -->");
            out.println(" <header id=\"header\" class=\"fixed-top\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"logo float-left\">");
            out.println(" <!-- h1 class=\"text-light\"><a href=\"/CEDAE\"><span>Moderna</span></a></h1-->");
            out.println(" <!-- Uncomment below if you prefer to use an image logo -->");
            out.println(" <a href=\"/CEDAE\"><img src=\"assets/img/cedae-logoWnL.png\" alt=\"CEDAE\" class=\"img-fluid\"></a>");
            out.println(" </div>");
            out.println(" <nav class=\"nav-menu float-right d-none d-lg-block\">");
            out.println(" <ul>");
            out.println(" <li class=\"active\"><a href=\"/CEDAE\">Inicio</a></li>");
            out.println(" <li><a href=\"about.html\">Nosotros</a></li>");
            out.println(" <li><a href=\"services.html\">Servicios</a></li>");
            out.println(" <li><a href=\"contact.html\">Contacto</a></li>");
            out.println(" <li><a href=\"contact.html\">Facturacion</a></li>");
            out.println(" <li><a href=\"/CEDAE/agendarCita\" class=\"btn-get-started\">Agendar Cita</a></li>");
            out.println(" <li><a href=\"/CEDAE/login\">Ingresar</a></li>");
            out.println(" </ul>");
            out.println(" </nav><!-- .nav-menu -->");
            out.println(" </div>");
            out.println(" </header><!-- End Header -->");
            out.println(" <main id=\"main\">");
            out.println(" <!-- ======= Contact Section ======= -->");
            out.println(" <section class=\"breadcrumbs\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"d-flex justify-content-between align-items-center\">");
            out.println(" <h2>Agendar Cita</h2>");
            out.println(" <ol>");
            out.println(" <li><a href=\"/CEDAE\">Incio</a></li>");
            out.println(" <li>Agendar Cita</li>");
            out.println(" </ol>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </section><!-- End Contact Section -->");
            out.println(" <!-- ======= Sucursal Section ======= -->");
            out.println(" <section class=\"contact\" data-aos=\"fade-up\" data-aos-easing=\"ease-in-out\" data-aos-duration=\"500\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-lg-12\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-calendar\"></i>");
            out.println(" <h3>¿Primera Cita?</h3>");
            out.println(" <p>Puedes realizar tu cita por correo con el siguiente formulario, contactarnos por los medios que proporcionasmos mas abajo.</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-at\"></i>");
            out.println(" <h3>Agendar cita por correo</h3>");
            out.println(" <form action=\"agendarCita\" method=\"post\" role=\"form\" class=\"php-email-form\">");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col-md-6 form-group\">");
            out.println(" <input type=\"text\" name=\"name\" class=\"form-control\" id=\"name\" placeholder=\"Nombre\" data-rule=\"minlen:4\" data-msg=\"Ingresa al menos 4 letras\" />");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-6 form-group\">");
            out.println(" <input type=\"text\" class=\"form-control\" name=\"lastname\" id=\"lastname\" placeholder=\"Apellido\" data-rule=\"minlen:4\" data-msg=\"Ingresa al menos 4 letras\" />");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-group\">");
            out.println(" <input type=\"email\" class=\"form-control\" name=\"email\" id=\"email\" placeholder=\"Correo electronico\" data-rule=\"minlen:4\" data-msg=\"Ingresa un correo valido\" />");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col-md-6 form-group\">");
            out.println(" <input type=\"number\" name=\"tel\" class=\"form-control\" id=\"tel\" placeholder=\"Telefono\" data-rule=\"minlen:10\" data-msg=\"Ingresa un número telefonico valido\" />");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-6 form-group\">");
            out.println(" <select class=\"form-control\" id=\"sucursal\" name=\"sucursal\" data-rule=\"required\" data-msg=\"Elije una sucursal valida\">");
            out.println(" <option value=\"null\">Elegir Sucursal</option>");
            out.println(" <option value=\"La Roma\">La Roma</option>");
            out.println(" <option value=\"Satelite\">Satelite</option>");
            out.println(" </select>");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"form-row\">");
            out.println(" <div class=\"col-md-6 form-group\">");
            //<input id="date1"  placeholder="MM/DD/YYYY" data-input />
            out.println(" <input class=\"form-control\" name=\"date\" id=\"date\" placeholder=\"Fecha\" data-input data-rule=\"required\" data-msg=\"Elije una fecha valida\" />");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-6 form-group\">");
            out.println(" <select class=\"form-control\" id=\"time\" name=\"time\" data-rule=\"required\" data-msg=\"Elije una hora\" disabled>");
            out.println(" <option value=\"null\">Elige la hora</option>");
            out.println(" </select>");
            out.println(" <div class=\"validate\"></div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"mb-3\">");
            out.println(" <div class=\"loading\">Loading</div>");
            out.println(" <div class=\"error-message\"></div>");
            out.println(" <div class=\"sent-message\">Your message has been sent. Thank you!</div>");
            out.println(" </div>");
            out.println(" <div class=\"text-center\"><button type=\"submit\">Agendar Cita</button></div>");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-map\"></i>");
            out.println(" <h3>CEDAE Roma</h3>");
            out.println(" <p>Tuxpan 2 interior 902, colonia Roma Sur, Cuauhtémoc, Ciudad de México</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-envelope\"></i>");
            out.println(" <h3>Correo Electronico</h3>");
            out.println(" <p>roma@cedae.mx</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-phone-call\"></i>");
            out.println(" <h3>Llamanos</h3>");
            out.println(" <p>55 5264 2721<br>55 5264 1567</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bxl-whatsapp\"></i>");
            out.println(" <h3>Envianos un mensaje</h3>");
            out.println(" <p>55 1816 9408</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6\">");
            out.println(" <div class=\"map\">");
            out.println(" <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3763.125374723646!2d-99.1699912846699!3d19.406988186898946!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85d1ff6ab464a5f5%3A0xcdf74a7f00cc35b!2sCedae!5e0!3m2!1ses-419!2smx!4v1566316404798!5m2!1ses-419!2smx\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\"></iframe> ");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6 mt-3\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-12\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-map\"></i>");
            out.println(" <h3>CEDAE Satélite</h3>");
            out.println(" <p>Circuito Cirujanos #11 int 201, Cd. Satélite, 53100 Naucalpan de Juárez, Méx.</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-envelope\"></i>");
            out.println(" <h3>Correo Electronico</h3>");
            out.println(" <p>satelite@cedae.mx</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-phone-call\"></i>");
            out.println(" <h3>Llamanos</h3>");
            out.println(" <p>55 7095 2151</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-4\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bxl-whatsapp\"></i>");
            out.println(" <h3>Envianos un mensaje</h3>");
            out.println(" <p>55 4993 9627</p>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6 mt-3\">");
            out.println(" <div class=\"map\">");
            out.println(" <iframe src=\"https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d60190.57380262096!2d-99.2345411132153!3d19.4594095883908!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x85d202d7acd7b6ab%3A0x3e659ed19cee7dc2!2sCentro+Dermatol%C3%B3gico+de+Alta+Especialidad+Dra.+Jatziri+Ch%C3%A1vez!5e0!3m2!1ses-419!2smx!4v1566316429304!5m2!1ses-419!2smx\" frameborder=\"0\" style=\"border:0;\" allowfullscreen=\"\"></iframe>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </section><!-- End Sucursal Section -->");
            out.println(" </main><!-- End #main -->");
            out.println(" <!-- ======= Footer ======= -->");
            out.println(" <footer id=\"footer\" data-aos=\"fade-up\" data-aos-easing=\"ease-in-out\" data-aos-duration=\"500\">");
            out.println(" <!--div class=\"footer-newsletter\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-lg-6\">");
            out.println(" <h4>Our Newsletter</h4>");
            out.println(" <p>Tamen quem nulla quae legam multos aute sint culpa legam noster magna</p>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6\">");
            out.println(" <form action=\"\" method=\"post\">");
            out.println(" <input type=\"email\" name=\"email\"><input type=\"submit\" value=\"Subscribe\">");
            out.println(" </form>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div-->");
            out.println(" <div class=\"footer-top\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-lg-3 col-md-6 footer-links\">");
            out.println(" <h4>Enlaces Utiles</h4>");
            out.println(" <ul>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Inicio</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Nosotros</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Servicios</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Contacto</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Facturación</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Agendar Cita</a></li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-3 col-md-6 footer-links\">");
            out.println(" <h4>Nuestros Servicios</h4>");
            out.println(" <ul>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Dermatología Cosmética</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Tratamientos de la Piel</a></li>");
            out.println(" <li><i class=\"bx bx-chevron-right\"></i> <a href=\"#\">Tratamientos de la Piel</a></li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-3 col-md-6 footer-contact\">");
            out.println(" <h4>Contactanos</h4>");
            out.println(" <p>");
            out.println(" Tuxpan 2 interior 902 <br>");
            out.println(" Roma Sur, Cuauhtémoc<br>");
            out.println(" Ciudad de México <br><br>");
            out.println(" <strong>Phone:</strong> 55 5264 1567<br>");
            out.println(" <strong>Email:</strong> roma@cedae.mx<br>");
            out.println(" </p>");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-3 col-md-6 footer-info\">");
            out.println(" <h3>Sobre CEDAE</h3>");
            out.println(" <p>Somos un centro dermatológico dirigido por la Dra. Jatziri Chávez, miembro de la Sociedad Mexicana de Dermatología y de la Sociedad Mexicana de Cirugía Dermatológica y Oncológica. Contamos con tecnología de punta para el cuidado de la piel, pelo y uñas.</p>");
            out.println(" <div class=\"social-links mt-3\">");
            out.println(" <a href=\"#\" class=\"facebook\"><i class=\"bx bxl-facebook\"></i></a>");
            out.println(" <a href=\"#\" class=\"instagram\"><i class=\"bx bxl-instagram\"></i></a>");
            out.println(" <a href=\"#\" class=\"linkedin\"><i class=\"bx bxl-youtube\"></i></a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"copyright\">");
            out.println(" © Copyright <strong><span>CEDAE</span></strong>. All Rights Reserved");
            out.println(" </div>");
            out.println(" <div class=\"credits\">");
            out.println(" <!-- All the links in the footer should remain intact. -->");
            out.println(" <!-- You can delete the links only if you purchased the pro version. -->");
            out.println(" <!-- Licensing information: https://bootstrapmade.com/license/ -->");
            out.println(" <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/ -->");
            out.println(" Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </footer><!-- End Footer -->");
            out.println(" <a href=\"#\" class=\"back-to-top\"><i class=\"icofont-simple-up\"></i></a>");
            out.println(" <!-- Vendor JS Files -->");
            out.println(" <script src=\"assets/vendor/jquery/jquery.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/jquery.easing/jquery.easing.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/php-email-form/validate.js\"></script>");
            out.println(" <script src=\"assets/vendor/venobox/venobox.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/waypoints/jquery.waypoints.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/counterup/counterup.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/owl.carousel/owl.carousel.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>");
            out.println(" <script src=\"assets/vendor/aos/aos.js\"></script>");
            out.println(" <!-- Template Main JS File -->");
            out.println(" <script src=\"assets/js/main.js\"></script>");
            out.println(" <!-- Date Picker -->");
            out.println(" <script src=\"assets/vendor/flat-picker/flatpickr.js\"></script>");
            out.println(" <!-- Modal -->");
            out.println(" <div class=\"modal fade\" id=\"confirmation\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"confirmation\" aria-hidden=\"true\">");
            out.println(" <div class=\"modal-dialog modal-dialog-centered\" role=\"document\">");
            out.println(" <div class=\"modal-content\">");
            out.println(" <div class=\"modal-body\">");
            out.println(" <div class=\"info-box\">");
            out.println(" <i class=\"bx bx-check-circle\"></i>");
            out.println(" <h3>¡Listo!</h3>");
            out.println(" <p>Te hemos enviado un email de confirmación. Revisa tu correo.</p>");
            out.println(" <!--a role=\"button\" href=\"/CEDAE\" class=\"btn btn-info mt-4\" data-dismiss=\"modal\">Aceptar</a-->");
            out.println(" <a role=\"button\" href=\"/CEDAE\" class=\"btn btn-info mt-4\">Aceptar</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
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
        int action = Integer.parseInt(request.getParameter("action"));
        String result="Error";
        if(action == 0){
            result = "{\"hrdisp\":[";
            Recepcionista auxObj = new Recepcionista();
            boolean horarioDisp[] = auxObj.getHorarioParaCita(request.getParameter("date").replace('/', '-'), request.getParameter("sucursal"), 4);
            
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
        }
        if(action == 1){
            Paciente nPaciente = new Paciente(request.getParameter("name"), request.getParameter("lastname"), request.getParameter("email"), Long.parseLong(request.getParameter("tel")));
            if(nPaciente.isRegistered(request.getParameter("email")))
                result ="{\"message\": \"Este Correo ya se encuentra registrado, te recomendamos ponerte en contacto con la clinica.\"}";
            else{
                nPaciente.guardarPacienteTemp();
                Recepcionista helper = new Recepcionista();
                String cMedicT = helper.medicoTitDisponible(request.getParameter("date").replace('/', '-'), request.getParameter("sucursal"), request.getParameter("time"),4);
                String cMedicA = helper.medicoAuxDisponible(request.getParameter("date").replace('/', '-'), request.getParameter("sucursal"), request.getParameter("time"),4);
                Medico medic = new Medico(cMedicT,true);
                Medico medic2 = new Medico(cMedicA,false);
                result ="{\"message\": \"";
                result += helper.generarCita(nPaciente, medic, medic2, request.getParameter("sucursal"), request.getParameter("date").replace('/', '-'), request.getParameter("time"),4);
                result += "\"}";
            }
        }
        
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
            
        out.print(result);
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
