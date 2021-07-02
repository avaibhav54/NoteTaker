package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.note;
import com.helper.FactoryProvider;

/**
 * Servlet implementation class saveNoteServlet
 */
public class saveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	String s1=request.getParameter("title");
	String s2=request.getParameter("content");
	note n=new note(s1,s2,new Date()); 
Session s=	FactoryProvider.getFactory().openSession();
Transaction tx=s.beginTransaction();

s.save(n);
tx.commit();
s.close();

out.println("<h1 style='text-align:center;'>your data is successfully added thankyou </h1>");
out.println("<h1 style='text-align:center;'><a href='allNotes.jsp'>View All Notes</a></h1>");
out.println("<h1 style='text-align:center;'><a href='index.jsp'>Go To Home Page</a></h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
