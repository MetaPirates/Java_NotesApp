package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import com.NoteApp.EntityProvider;
import com.Tables.NoteTable;

import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UpdateServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("formtitle");
		String content=request.getParameter("formcontent");
		EntityManager em=EntityProvider.getManager();
		NoteTable note=em.find(NoteTable.class, id);
		em.getTransaction().begin();
		note.setTitle(title);
		note.setContent(content);
		note.setDate(new Date());
		em.getTransaction().commit();
		PrintWriter out=response.getWriter();
		out.print("<h1>Note updated</h1>");
		out.print("<a href='index.jsp'>Home</a>");
		em.close();
		
	}

	
	

}
