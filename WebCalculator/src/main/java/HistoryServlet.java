import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		printMessage(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		printMessage(req, resp);
	}

	private void printMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		ArrayList<Calculation> calculations = (ArrayList<Calculation>) session.getAttribute("calculations");

		if (calculations == null) {
			calculations = new ArrayList<Calculation>();
		} else {
			resp.setContentType("text/html");

			for (Calculation calculation : calculations) {
				resp.getWriter().println("input 1 = " + calculation.getInputValue1() + " | input 2 = "
						+ calculation.getInputValue2() + " | operation " + calculation.getOperation() + "<br>");
			}
		}
	}
}
