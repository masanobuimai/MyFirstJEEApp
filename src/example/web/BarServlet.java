package example.web;

import com.example.entity.Book;
import com.example.service.BookService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bar", urlPatterns = { "/bar" })
public class BarServlet extends HttpServlet {
    @EJB
    private BookService bookService;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>FooServlet</title>");
            out.println("</head>");
            out.println("<body><pre>");
            for (Book book : bookService.findAll()) {
                out.println(book);
            }
            out.println("</pre></body>");
            out.println("</html>");
        }
    }
}
