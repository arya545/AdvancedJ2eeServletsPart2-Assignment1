package com.inf;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayHeader
 */
@WebServlet("/DisplayHeader")
public class DisplayHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHeader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String title="HTTP Header Request Example";
		String docType="<!doctype html public \"-//w3c//dtd html 4.0 " +
		         "transitional//en\">\n";
		out.println(docType+
				"<html>\n"+
				"<head><title>"+title+"</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n"+
				"<h1 align=\"center\">"+title+"</h1>\n"+
				"<table width=\"100%\"  border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>header Name</th><th>Header value(s)</th>\n"+
				"<\tr>\n");
		
		Enumeration<String>  headerNames=request.getHeaderNames();
		
		while (headerNames.hasMoreElements())
		{
			String paramNames=headerNames.nextElement();
			out.println("<tr><td>"+paramNames+"</td>\n");
			String paramValues=request.getHeader(paramNames);
			out.println("<td>"+paramValues+"</td></tr>\n");
		}
		out.println("</table>\n</body></html>");
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
