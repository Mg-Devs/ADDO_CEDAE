/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webpages;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mario
 */
public class index extends HttpServlet {

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
            out.println(" <!-- =======================================================");
            out.println(" * Template Name: Moderna - v2.1.0");
            out.println(" * Template URL: https://bootstrapmade.com/free-bootstrap-template-corporate-moderna/");
            out.println(" * Author: BootstrapMade.com");
            out.println(" * License: https://bootstrapmade.com/license/");
            out.println(" ======================================================== -->");
            out.println(" </head>");
            out.println(" <body>");
            out.println(" <!-- ======= Header ======= -->");
            out.println(" <header id=\"header\" class=\"fixed-top header-transparent\">");
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
            out.println(" <li><a href=\"/CEDAE/agendarCita\" class=\"btn-get-started\">Agendar Cita</a></li> ");
            out.println(" <li><a href=\"/CEDAE/login\">Ingresar</a></li>");
            out.println(" </ul>");
            out.println(" </nav><!-- .nav-menu -->");
            out.println(" </div>");
            out.println(" </header><!-- End Header -->");
            out.println(" <!-- ======= Hero Section ======= -->");
            out.println(" <section id=\"hero\" class=\"d-flex justify-cntent-center align-items-center\">");
            out.println(" <div id=\"heroCarousel\" class=\"container carousel carousel-fade\" data-ride=\"carousel\">");
            out.println(" <!-- Slide 1 -->");
            out.println(" <div class=\"carousel-item active\">");
            out.println(" <div class=\"carousel-container\">");
            out.println(" <h2 class=\"animate__animated animate__fadeInDown\">Bienvenido a <span>CEDAE</span></h2>");
            out.println(" <p class=\"animate__animated animate__fadeInUp\">Conoce a nuestros expertos.</p>");
            out.println(" <a href=\"\" class=\"btn-get-started animate__animated animate__fadeInUp\">Aprender Mas</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <!-- Slide 2 -->");
            out.println(" <div class=\"carousel-item\">");
            out.println(" <div class=\"carousel-container\">");
            out.println(" <h2 class=\"animate__animated animate__fadeInDown\">Dermatologia Oncológica</h2>");
            out.println(" <p class=\"animate__animated animate__fadeInUp\">Especializada.</p>");
            out.println(" <a href=\"\" class=\"btn-get-started animate__animated animate__fadeInUp\">Aprender Mas</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <a class=\"carousel-control-prev\" href=\"#heroCarousel\" role=\"button\" data-slide=\"prev\">");
            out.println(" <span class=\"carousel-control-prev-icon bx bx-chevron-left\" aria-hidden=\"true\"></span>");
            out.println(" <span class=\"sr-only\">Previous</span>");
            out.println(" </a>");
            out.println(" <a class=\"carousel-control-next\" href=\"#heroCarousel\" role=\"button\" data-slide=\"next\">");
            out.println(" <span class=\"carousel-control-next-icon bx bx-chevron-right\" aria-hidden=\"true\"></span>");
            out.println(" <span class=\"sr-only\">Next</span>");
            out.println(" </a>");
            out.println(" </div>");
            out.println(" </section><!-- End Hero -->");
            out.println(" <main id=\"main\">");
            out.println(" <!-- ======= Features Section ======= -->");
            out.println(" <section class=\"features\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"section-title\">");
            out.println(" <h2>Bienvenido a CEDAE</h2>");
            out.println(" <p>Somos un centro dermatológico dirigido por la Dra. Jatziri Chávez, miembro de la Sociedad Mexicana de Dermatología y de la Sociedad Mexicana de Cirugía Dermatológica y Oncológica. Contamos con tecnología de punta para el cuidado de la piel, pelo y uñas.</p>");
            out.println(" </div>");
            out.println(" <div class=\"row\" data-aos=\"fade-up\">");
            out.println(" <div class=\"col-md-5\">");
            out.println(" <img src=\"assets/img/team/dra-jatziri-chavez-374x524.png\" class=\"img-fluid\" alt=\"\">");
            out.println(" </div>");
            out.println(" <div class=\"col-md-7 pt-4\">");
            out.println(" <h3>En CEDAE somos expertos en el tratamiento de cáncer de piel.</h3>");
            out.println(" <p class=\"font-italic\">");
            out.println(" Dra. Jatziri Chávez.");
            out.println(" </p>");
            out.println(" <ul>");
            out.println(" <li><i class=\"icofont-check\"></i> Dermatología clínica, oncológica, quirúrgica y cosmética.</li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </section><!-- End Features Section --> ");
            out.println(" <!-- ======= Why Us Section ======= -->");
            out.println(" <section class=\"why-us section-bg\" data-aos=\"fade-up\" date-aos-delay=\"200\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-lg-6 video-box\">");
            out.println(" <img src=\"assets/img/cedae-home-940x460.png\" class=\"img-fluid\" alt=\"\">");
            out.println(" <!--a href=\"https://www.youtube.com/watch?v=jDDaplaOz7Q\" class=\"venobox play-btn mb-4\" data-vbtype=\"video\" data-autoplay=\"true\"></a-->");
            out.println(" </div>");
            out.println(" <div class=\"col-lg-6 d-flex flex-column justify-content-center p-5\">");
            out.println(" <div class=\"icon-box\">");
            out.println(" <div class=\"icon\"><i class=\"bx bx-award\"></i></div>");
            out.println(" <h4 class=\"title\"><a href=\"\">CEDAE</a></h4>");
            out.println(" <p class=\"description\">La salud y la belleza deben estar en las manos de profesionales. En el Centro Dermatológico de Alta Especialidad ofrecemos tratamientos de vanguardia para el cuidado de la piel. En CEDAE, lo más importante eres tú.</p>");
            out.println(" </div>");
            out.println(" <a href=\"#\">Ver todos los servicios</a>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </section><!-- End Why Us Section -->");
            out.println(" <!-- ======= Services Section ======= -->");
            out.println(" <section class=\"services\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
            out.println(" <div class=\"col-md-6 col-lg-4 d-flex align-items-stretch\" data-aos=\"fade-up\">");
            out.println(" <div class=\"icon-box icon-box-cyan\">");
            out.println(" <img src=\"assets/img/services/dermatologia-cosmetica.jpg\" class=\"img-fluid\" alt=\"\">");
            out.println(" <h4 class=\"title mt-4\"><a href=\"\">Dermatología Cosmética</a></h4>");
            out.println(" <p class=\"description\">La dermatología cosmética está orientada a rehabilitar la apariencia externa de la piel. Innovadores tratamientos para piel y cuerpo como:</p>");
            out.println(" <ul>");
            out.println(" <li><i class=\"icofont-check\"></i> Radiofrecuencia médica</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Luz pulsada</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Depilación Láser</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Cavitación</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Hidra Facial</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Láser para retiro de Tatuaje</li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-6 col-lg-4 d-flex align-items-stretch\" data-aos=\"fade-up\">");
            out.println(" <div class=\"icon-box icon-box-cyan\">");
            out.println(" <img src=\"assets/img/services/dermatologia-clinica.png\" class=\"img-fluid\" alt=\"\">");
            out.println(" <h4 class=\"title mt-4\"><a href=\"\">Tratamientos de la Piel</a></h4>");
            out.println(" <p class=\"description\">Tratamientos de la piel enfocados a diagnosticar, rehabilitar y mejorar la apariencia de piel y cuerpo y tratar cualquier enfermedad de la piel, uñas y mucosas.</p>");
            out.println(" <ul>");
            out.println(" <li><i class=\"icofont-check\"></i> Análisis digital de cabello</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Diagnóstico y tratamiento de acné</li>");
            out.println(" <li><i class=\"icofont-check\"></i> Diagnóstico y tratamiento de Melasma (paño)</li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" <div class=\"col-md-6 col-lg-4 d-flex align-items-stretch\" data-aos=\"fade-up\">");
            out.println(" <div class=\"icon-box icon-box-cyan\">");
            out.println(" <img src=\"assets/img/services/dermatologia-oncologica.png\" class=\"img-fluid\" alt=\"\">");
            out.println(" <h4 class=\"title mt-4\"><a href=\"\">Dermatología Oncológica</a></h4>");
            out.println(" <p class=\"description\">La dermatología oncológica se ocupa de la prevención, el estudio, diagnóstico, tratamiento y seguimiento del cáncer de piel.</p>");
            out.println(" <ul>");
            out.println(" <li><i class=\"icofont-check\"></i> Dermatología oncológica</li>");
            out.println(" </ul>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </div>");
            out.println(" </section><!-- End Services Section -->");
            out.println(" <!-- ======= Sucursal Section ======= -->");
            out.println(" <section class=\"contact section-bg\" data-aos=\"fade-up\" data-aos-easing=\"ease-in-out\" data-aos-duration=\"500\">");
            out.println(" <div class=\"container\">");
            out.println(" <div class=\"row\">");
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
            out.println(" ");
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
