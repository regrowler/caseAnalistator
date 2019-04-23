import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import java.io.*;
public class algo4servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        RequestDispatcher dispatcher = request.getRequestDispatcher("algo4.html");
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        }
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        algo4.main(request,response);
//        caseA.Case(request,response);
    }
}