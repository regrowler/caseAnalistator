import java.io.*;
import java.lang.reflect.Array;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import Caser.Analisator;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class main extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("main.html");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
//        algo4.main(request,response);
        caseA.Case(request,response);
    }
}
