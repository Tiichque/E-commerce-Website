// To save as "<TOMCAT_HOME>\webapps\hello\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
import jakarta.servlet.*;             // Tomcat 10
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
//import javax.servlet.*;             // Tomcat 9
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;

@WebServlet("/addtocart2")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class addtocart2 extends HttpServlet {

   // The doGet() runs once per HTTP GET request to this servlet.
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
      // Set the MIME type for the response message
      response.setContentType("text/html");
      // Get a output writer to write the response message into the network socket
      PrintWriter out = response.getWriter();

      // Print an HTML page as the output of the query
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Add to cart</title>");
      out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap.css\" />");
      out.println("<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap\" rel=\"stylesheet\">");
      out.println("<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" />");
      out.println("<link href=\"css/style.css\" rel=\"stylesheet\" />");
      out.println("<link href=\"css/responsive.css\" rel=\"stylesheet\" />");
      out.println("</head>");
      out.println("<body>");

      out.println("<header class=\"header_section header_inner\">");
      out.println("<div class=\"container\">");
      out.println("<nav class=\"navbar navbar-expand-lg custom_nav-container \">");
      out.println("<a class=\"navbar-brand\" href=\"index.html\">");
      out.println("<span>Floram</span>");
      out.println("</a>");
      out.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");
      out.println("<span class=\"\"> </span>");
      out.println("</button>");
      out.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
      out.println("<ul class=\"navbar-nav  ml-auto\">");
      out.println("<li class=\"nav-item active\">");
      out.println("<a class=\"nav-link\" href=\"index.html\"><img src=\"images/homeicon.png\" style=\"padding-bottom:2px; width: 22px; height: 20px;\"><span class=\"sr-only\">(current)</span></a>");
      out.println("</li>");
      out.println("<li class=\"nav-item\">");
      out.println("<a class=\"nav-link\" href=\"products.html\"><img src=\"images/products-icon.png\" style=\"padding-bottom:2px; width: 20px; height: 17px;\"></a>");
      out.println("</li>");
      out.println("<li class=\"nav-item\">");
      out.println("<a class=\"nav-link\" href=\"checkout.html\" style=\"background-color: rgb(167, 167, 167);\">");
      out.println("<img src=\"images/shopping-bag.png\" style=\"padding-bottom:3px; width: 20px; height: 19px;\">");
      out.println("</a>");
      out.println("</ul>");
      out.println("</div>");
      out.println("</nav>");
      out.println("</div>");
      out.println("</header>");

      out.println("<section class='about_section layout_padding'>");
      out.println("<div class='container  '> ");
      out.println("<div class='row'>");
      out.println("<div class='col-md-6 '> ");
      out.println("<div class='img-box'>");
      out.println("<img src='images/products/product2gold.webp' alt=''>");
      out.println("</div>");
      out.println("</div>");
      out.println("<div class='col-md-6'>");
      out.println("<div class='detail-box'>");
      out.println("<div class='heading_container'>");
      out.println("<h2>Thank you for your order!</h2>");
      out.println("</div>");
      out.println("<p>");
      out.println("Gigachad Round");
      out.println("</p>");
      out.println("<a href='index.html'>Continue shopping</a>");
      out.println("<a href='checkout.html'>Check out now</a>");
      out.println("</div>");
      out.println("</div>");
      out.println("</div>");
      out.println("</div>");
      out.println("</section>");

      try (
         // Step 1: Allocate a database 'Connection' object
         Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/ mystore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
               "myuser", "xxxx");   // For MySQL
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         // Step 2: Allocate a 'Statement' object in the Connection
         Statement stmt = conn.createStatement();
      ) {
         // Step 3 & 4: Execute a SQL SELECT query and Process the query result
         // Retrieve the books' id. Can order more than one books.
              int count;
              String sqlStr = "INSERT INTO orders (name, colour, qty, buyer) VALUES ("
                     + "'" + "Gigachad Round" + "'" + "," + "'" + request.getParameter("colour") + "'" + "," + request.getParameter("qty") + ", '" + request.getParameter("buyer") + "'" + ")";
              // out.println("<p>" + sqlStr + "</p>");  // for debugging
               count = stmt.executeUpdate(sqlStr);
               //out.println("<p>" + count + " record inserted.</p>");
              // out.println("<h3>Your order has been confirmed.</h3>");
            
              // out.println("<h3>Thank you.<h3>");


      } catch(Exception ex) {
         out.println("<p>Error: " + ex.getMessage() + "</p>");
         out.println("<p>Check Tomcat console for details.</p>");
         ex.printStackTrace();
      }  // Step 5: Close conn and stmt - Done automatically by try-with-resources (JDK 7)
 
      out.println("</body></html>");
      out.close();
    }
}

