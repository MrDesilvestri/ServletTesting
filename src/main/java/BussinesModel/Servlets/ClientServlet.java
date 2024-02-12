/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package BussinesModel.Servlets;

import BussinesModel.Servlets.Models.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author carlo
 */
@WebServlet(name = "ClientServlet", urlPatterns = {"/ClientServlet"})
public class ClientServlet extends HttpServlet {

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

        List<Client>clients = new ArrayList();
        
        clients.add(new Client("Carlos", 23, "Carpintero"));
        clients.add(new Client("Albert", 27, "Ingeniero"));
        clients.add(new Client("David", 50, "Profesora"));

        response.setContentType("application/json");
               
        
        JSONObject[] jsonResponse = setJsonArray(clients);

        JSONArray jsonArray = new JSONArray();
        
        
        for (JSONObject obj : jsonResponse) {
            jsonArray.add(obj);
        }

        

        
        response.getWriter().write(jsonArray.toJSONString());

        out.flush();
        
        
    }
    
    private JSONObject[] setJsonArray(List<Client> clients) {
    JSONObject[] jsonArray = new JSONObject[clients.size()]; // Inicializar el arreglo con el tamaño de clients

    for (int i = 0; i < clients.size(); i++) {
        JSONObject obj = new JSONObject();
        obj.put("name", clients.get(i).getName());
        obj.put("age", clients.get(i).getAge());
        obj.put("job", clients.get(i).getJob());
        jsonArray[i] = obj;
    }
    

    return jsonArray;
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
