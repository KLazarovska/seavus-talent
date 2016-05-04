import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/home")
public class WebCalculatorServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("com.seavus.WebCalclator.doGet");
        printMessage(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("com.seavus.WebCalculator.doPost");
        printMessage(req, resp);
    }

    private void printMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	HttpSession session = req.getSession();
		ArrayList<Calculation> calculations = (ArrayList<Calculation>) session.getAttribute("calculations");
		if (calculations == null) {
			calculations = new ArrayList<Calculation>();
		}

		resp.setContentType("text/html");
    	
    	
    	try{
    		int value1 = Integer.parseInt(req.getParameter("value1"));
        	int value2 = Integer.parseInt(req.getParameter("value2"));
            int result = 0;
            String operation = req.getParameter("operation");
            Calculation calculation = new Calculation(value1, value2, operation);
            
            calculations.add(calculation);
            session.setAttribute("calculations", calculations);
            
            if (operation.equals("add")){
            	result = value1 + value2;
            }else if (operation.equals("substract")){
            	result = value1 - value2;
            }
            
            resp.setContentType("text/html");
            resp.getWriter().println("Result = " + Integer.toString(result));
            
    	}catch(IllegalArgumentException e){
    		resp.getWriter().println("Invalid arguments!");
    	}
    }
}