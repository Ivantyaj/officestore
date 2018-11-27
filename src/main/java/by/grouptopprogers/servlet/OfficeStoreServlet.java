package by.grouptopprogers.servlet;

import by.grouptopprogers.entity.Category;
import by.grouptopprogers.parsers.MyDOMparser;
import org.xml.sax.SAXException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;



public class OfficeStoreServlet extends HttpServlet {

    List<Category> categoryList = null;

    public void init() throws ServletException {
        try {
            categoryList = MyDOMparser.getInstance().parseFile();
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // response.setContentType("text/html");
       // response.setCharacterEncoding("UTF-8");
       // PrintWriter printWriter = response.getWriter();
//        List<Category> categoryList = null;
//        try {
//            categoryList = MyDOMparser.getInstance().parseFile();
//        } catch (SAXException | ParserConfigurationException e) {
//            e.printStackTrace();
//        }
        request.setAttribute("categoryList", categoryList);
        this.getServletContext().getRequestDispatcher("WEB-INF/index.jsp").forward(request,response);

//                request.getSergetCgetRequestDispatcher("WEB-INF/index.jsp");
//        rd.forward(request, response);
//        printWriter.println("<p align=\"center\">");
//        printWriter.println("PRODUCTS");
//        printWriter.println("</span>");
//
//        try {
//            for (Category category : categoryList) {
//                printWriter.println("<table border=1 align=\"center\">");
//                printWriter.println("<caption>" +
//                        category.getNameCategory() +
//                        "</caption>");
//                printWriter.println("<tr>" +
//                        "<th>ID</th>" +
//                        "<th>Type</th>" +
//                        "<th>Company</th>" +
//                        "<th>Purpose</th>" +
//                        "<th>Currency</th>" +
//                        "<th>Value</th>" +
//                        "</tr>");
//                printWriter.println("<tr>");
//                for (Product product : category.getListProducts()) {
//                    printWriter.println("<tr><td>" + product.getId() + "</td>");
//                    printWriter.println("<td>" + product.getType() + "</td>");
//                    printWriter.println("<td>" + product.getCompany() + "</td>");
//                    printWriter.println("<td>" + product.getPurpose() + "</td>");
//                    printWriter.println("<td>" + product.getCost().getCurrency() + "</td>");
//                    printWriter.println("<td>" + product.getCost().getValue() + "</td></tr>");
//                }
//                printWriter.println("</tr>");
//                printWriter.println("</table>");
//            }
//        } catch (Exception e) {
//            throw new ServletException(e);
//        }


    }
}
