package by.grouptopprogers.servlet;

import by.grouptopprogers.entity.Category;
import by.grouptopprogers.entity.Product;
import by.grouptopprogers.parsers.MyDOMparser;
import org.xml.sax.SAXException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class OfficeStoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        List<Category> categoryList = null;
        try {
            categoryList = MyDOMparser.getInstance().parseFile();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        printWriter.println("<p align=\"center\">");
        printWriter.println("PRODUCTS");
        printWriter.println("</span>");
        printWriter.println("<table border=1 align=\"center\">");
        try {
            printWriter.println("<tr>" +
                    "<th>Category name</th>" +
                    "<th>ID</th>" +
                    "<th>Type</th>" +
                    "<th>Company</th>" +
                    "<th>Purpose</th>" +
                    "<th>Currency</th>" +
                    "<th>Value</th>" +
                    "</tr>");
            for (Category category : categoryList) {
                printWriter.println("<tr>");
                printWriter.println("<td>" + category.getNameCategory() + "</td>");
                for (Product product : category.getListProducts()) {
                    printWriter.println("<td>" + product.getId() + "</td>");
                    printWriter.println("<td>" + product.getType() + "</td>");
                    printWriter.println("<td>" + product.getCompany() + "</td>");
                    printWriter.println("<td>" + product.getPurpose() + "</td>");
                    printWriter.println("<td>" + product.getCost().getCurrency() + "</td>");
                    printWriter.println("<td>" + product.getCost().getValue() + "</td>");
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
        printWriter.println("</table>");

    }
}
