/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author viter
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        String msg = "";
        //formatador do formato de hora
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
        LocalDateTime now = LocalDateTime.now();// adquire o horário atual
        int hora = Integer.parseInt(dtf.format(now));
        
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        if(5 < hora && hora < 12){//manha
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "de":
                    msg = "Guten Morgen, ";
                    break;
                case "jp":
                    msg = "Ohayō, ";
                    break;
                case "es":
                    msg = "Buen día, ";
                    break;
            }
        }
        else if(12 < hora && hora < 18){//tarde
            switch(lang){
                case "pt":
                    msg = "Boa tarde, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "de":
                    msg = "Guten Tag, ";
                    break;
                case "jp":
                    msg = "Kon'nichiwa, ";
                    break;
                case "es":
                    msg = "Buenas tardes, ";
                    break;
            }
        }
        else{//noite
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Goodnight, ";
                    break;
                case "fr":
                    msg = "bonne nuit, ";
                    break;
                case "de":
                    msg = "Gute Nacht, ";
                    break;
                case "jp":
                    msg = "Oyasuminasai, ";
                    break;
                case "es":
                    msg = "buenas noches, ";
                    break;
            }
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        
        String trat = request.getParameter("trat");
        switch(trat){
            case "0":
                msg = msg+nome+"!";
                break;
            case "1":
                switch(lang){
                    case "pt":
                        msg = msg+" Senhor "+nome+"!";
                        break;
                    case "en":
                        msg = msg+" Sir "+nome+"!";
                        break;
                    case "fr":
                        msg = msg+" Monsieur "+nome+"!";
                        break;
                    case "de":
                    msg = msg+" Herr "+nome+"!";
                        break;
                    case "jp":
                    msg = msg+" Shi "+nome+"!";
                        break;
                    case "es":
                    msg = msg+" Señor "+nome+"!";
                        break;
                }
                break;
            case "2":
                switch(lang){
                    case "pt":
                        msg = msg+" Senhora. "+nome+"!";
                        break;
                    case "en":
                        msg = msg+" Lady "+nome+"!";
                        break;
                    case "fr":
                        msg = msg+" Madame "+nome+"!";
                        break;
                    case "de":
                    msg = msg+" Frau "+nome+"!";
                        break;
                    case "jp":
                    msg = msg+" Fujin "+nome+"!";
                        break;
                    case "es":
                    msg = msg+" Señora "+nome+"!";
                        break;
                }
                break;
        } 

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        String msg = "";
        //formatador do formato de hora
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH");
        LocalDateTime now = LocalDateTime.now();// adquire o horário atual
        int hora = Integer.parseInt(dtf.format(now));
        String lang = request.getParameter("lang");
        if(lang==null)
            lang = "pt";
        if(5 < hora && hora < 12){//manha
            switch(lang){
                case "pt":
                    msg = "Bom dia, ";
                    break;
                case "en":
                    msg = "Good morning, ";
                    break;
                case "fr":
                    msg = "Bonjour, ";
                    break;
                case "de":
                    msg = "Guten Morgen, ";
                    break;
                case "jp":
                    msg = "Ohayō, ";
                    break;
                case "es":
                    msg = "Buen día, ";
                    break;
            }
        }
        else if(12 < hora && hora < 18){//tarde
            switch(lang){
                case "pt":
                    msg = "Boa tarde, ";
                    break;
                case "en":
                    msg = "Good afternoon, ";
                    break;
                case "fr":
                    msg = "Bon après-midi, ";
                    break;
                case "de":
                    msg = "Guten Tag, ";
                    break;
                case "jp":
                    msg = "Kon'nichiwa, ";
                    break;
                case "es":
                    msg = "Buenas tardes, ";
                    break;
            }
        }
        else{//noite
            switch(lang){
                case "pt":
                    msg = "Boa noite, ";
                    break;
                case "en":
                    msg = "Goodnight, ";
                    break;
                case "fr":
                    msg = "bonne nuit, ";
                    break;
                case "de":
                    msg = "Gute Nacht, ";
                    break;
                case "jp":
                    msg = "Oyasuminasai, ";
                    break;
                case "es":
                    msg = "buenas noches, ";
                    break;
            }
        }
        
        String nome = request.getParameter("nome");

        if(nome==null)
            nome = "Fulano";
        
        
        String trat = request.getParameter("trat");
        switch(trat){
            case "0":
                msg = msg+nome+"!";
                break;
            case "1":
                switch(lang){
                    case "pt":
                        msg = msg+" Senhor. "+nome+"!";
                        break;
                    case "en":
                        msg = msg+" Sir "+nome+"!";
                        break;
                    case "fr":
                        msg = msg+" Monsieur "+nome+"!";
                        break;
                    case "de":
                    msg = msg+" Herr "+nome+"!";
                        break;
                    case "jp":
                    msg = msg+" Shi "+nome+"!";
                        break;
                    case "es":
                    msg = msg+" Señor "+nome+"!";
                        break;
                }
                break;
            case "2":
                switch(lang){
                    case "pt":
                        msg = msg+" Senhora. "+nome+"!";
                        break;
                    case "en":
                        msg = msg+" Lady "+nome+"!";
                        break;
                    case "fr":
                        msg = msg+" Madame "+nome+"!";
                        break;
                    case "de":
                    msg = msg+" Frau "+nome+"!";
                        break;
                    case "jp":
                    msg = msg+" Fujin "+nome+"!";
                        break;
                    case "es":
                    msg = msg+" Señora "+nome+"!";
                        break;
                }
                break;
        } 
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
