package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epsigames.beans.Jeux;
import com.epsigames.forms.AjoutJeuxForm;

/**
 * Servlet implementation class AjouterJeux
 */
@WebServlet( "/AjouterJeux" )
public class AjouterJeux extends HttpServlet {
    /**
     * 
     */
    private static final long  serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/ajoutJeux.jsp";
    public static final String ATT_Jeux         = "jeux";
    public static final String ATT_FORM         = "form";

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        AjoutJeuxForm form = new AjoutJeuxForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en resultnt
         */
        Jeux jeux = form.ajouterJeux( request );
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_Jeux, jeux );

        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
