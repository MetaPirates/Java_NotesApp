package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.NoteApp.EntityProvider;
import com.Tables.NoteTable;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
    public DeleteNote() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		EntityManager em=EntityProvider.getManager();
		em.getTransaction().begin();
		NoteTable note=em.find(NoteTable.class, id);
		em.remove(note);
		
		System.out.println("successfully deleted");
		em.getTransaction().commit();
		response.sendRedirect("AllNotes.jsp");
		em.close();
	
	}

	

}
