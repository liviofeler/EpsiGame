package com.octest.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epsigames.bdd.JeuxBDD;

/**
 * Servlet implementation class TestUtilisateurBDD
 */
@WebServlet( "/TestUtilisateurBDD" )
public class TestUtilisateurBDD extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestUtilisateurBDD() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
        JeuxBDD tableJeux = new JeuxBDD();
        request.setAttribute( "jeux", tableJeux.recupererJeux() );
        this.getServletContext().getRequestDispatcher( "/WEB-INF/bonjour.jsp" ).forward( request, response );
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    /*
     * protected void doPost( HttpServletRequest request, HttpServletResponse
     * response ) throws ServletException, IOException { // TODO Auto-generated
     * method stub Utilisateur utilisateur = new Utilisateur();
     * utilisateur.setNom( request.getParameter( "nom" ) );
     * utilisateur.setPrenom( request.getParameter( "prenom" ) );
     * utilisateur.setAdresse( request.getParameter( "adresse" ) );
     * utilisateur.setEmail( request.getParameter( "email" ) );
     * utilisateur.setPlateforme( request.getParameter( "console" ) );
     * utilisateur.setMotDePasse( request.getParameter( "motDePasse" ) );
     * 
     * UtilisateurBDD tableUtilisateur = new UtilisateurBDD();
     * tableUtilisateur.ajouterUtilisateur( utilisateur );
     * this.getServletContext().getRequestDispatcher( "/WEB-INF/inscription.jsp"
     * ).forward( request, response ); }
     */

}
