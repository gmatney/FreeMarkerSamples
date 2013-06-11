package gnm.simple.web.SimpleServlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 637319258624190838L;

	public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
        throws ServletException, IOException {
	PrintWriter out = response.getWriter();
	out.println( "SimpleServlet Executed" );
        out.flush();
        out.close();
    }
}