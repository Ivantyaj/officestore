package by.grouptopprogers.servlet;

import by.grouptopprogers.entity.Category;
import by.grouptopprogers.parsers.MyDOMparser;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;


public class OfficeStoreServlet extends HttpServlet {

    private List<Category> categoryList = null;

    public void init() {
        try {
            categoryList = MyDOMparser.getInstance().parseFile();

        } catch (SAXException
                | ParserConfigurationException
                | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("categoryList", categoryList);
        request.getRequestDispatcher("/WEB-INF/view/index.jsp")
                .forward(request, response);
    }
}
