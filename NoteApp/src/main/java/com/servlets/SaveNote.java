package com.servlets;


import java.io.IOException;
import java.io.PrintWriter;

import jakarta.persistence.*;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Date;
import java.util.Random;

import com.NoteApp.EntityProvider;
import com.Tables.NoteTable;

@WebServlet("/SaveNote")
public class SaveNote extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SaveNote() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet called");
		
		String title=request.getParameter("formtitle");
		String content=request.getParameter("formcontent");
		Random r=new Random();
		try {
		
		EntityManager em=EntityProvider.getManager();
		em.getTransaction().begin();
		NoteTable note=new NoteTable(r.nextInt(1000),title,content,new Date());
		em.persist(note);
		em.getTransaction().commit();
		PrintWriter out=response.getWriter();
		out.print("<h1>Note Added</h1>");
		out.print("<a href='index.jsp'>Home</a>");
		em.close();
		
		}catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
	}

}
