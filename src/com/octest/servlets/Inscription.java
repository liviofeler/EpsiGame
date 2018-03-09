package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epsigames.beans.Utilisateur;
import com.epsigames.forms.InscriptionForm;

/**
 * Servlet implementation class Inscription
 */
@WebServlet( "/Inscription" )
public class Inscription extends HttpServlet {
    private static final long  serialVersionUID = 1L;
    public static final String VUE              = "/WEB-INF/inscription.jsp";
    public static final String ATT_USER         = "utilisateur";
    public static final String ATT_FORM         = "form";

    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        // affichage de la page d'inscription
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm();

        /*
         * Appel au traitement et à la validation de la requête, et récupération
         * du bean en resultnt
         */
        Utilisateur utilisateur = form.inscrireUtilisateur( request );
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, utilisateur );
        /* Transmission de la paire d'objet request/response ànotre JSP */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

}
