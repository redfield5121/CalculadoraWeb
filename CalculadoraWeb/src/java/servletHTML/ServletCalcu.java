package servletHTML;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;
import static jdk.nashorn.internal.objects.NativeFunction.function;

public class ServletCalcu extends HttpServlet {

    int num1, num2;
    float res;

    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException {
        num1 = Integer.parseInt(peticion.getParameter("num1"));
        num2 = Integer.parseInt(peticion.getParameter("num2"));
        String opcion = peticion.getParameter("Ope");

        PrintWriter out = new PrintWriter(respuesta.getOutputStream());

        out.println("<html>");
        out.println("<head><title>Respuesta a Calculadora del Servlet</title></head>");
        out.println("<body style='margin: 0px ; background-color:black'>");

        if (opcion.equals("Suma")) {
            res = num1 + num2;
        } else if (opcion.equals("Resta")) {
            res = num1 - num2;
        } else if (opcion.equals("Multi")) {
            res = num1 * num2;
        } else if (opcion.equals("Divi")) {

            res = num1 / num2;
        }
        
        out.println("<Font color=\"white\" size=\"5\">El Resultado a la operación es: " + res + "</Font>");
        out.println("</body></html>");
        out.close();
    }
}
