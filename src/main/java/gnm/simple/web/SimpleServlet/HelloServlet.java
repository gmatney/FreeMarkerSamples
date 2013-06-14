package gnm.simple.web.SimpleServlet;

import gnm.simple.web.session.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private static List<User> userList = new ArrayList<User>();
	
	//Just prepare static data to display on screen
	static {
		userList.add(new User("Alex", "Adams"));
		userList.add(new User("Billy", "Brown"));
		userList.add(new User("Charley", "Carpenter"));
		userList.add(new User("David", "Doe"));
		userList.add(new User("Julio", "Jones"));
		userList.add(new User("Armond", "Armstead"));
		userList.add(new User("Janoris", "Jenkins"));
		userList.add(new User("Garrett", "Goebel"));
		userList.add(new User("Joshua", "Jarboe"));
		userList.add(new User("Brendan", "Beal"));
		userList.add(new User("Brice", "Butler"));
		userList.add(new User("Brandon", "Beachum"));
		userList.add(new User("Terrance", "Toliver"));
		userList.add(new User("Chris", "Culliver"));
		userList.add(new User("Tyrod", "Taylor"));
		userList.add(new User("Armando", "Allen"));
		userList.add(new User("Bryan", "Bulaga"));
		userList.add(new User("Gary", "Gray"));
		userList.add(new User("Mitch", "Mustain"));
		userList.add(new User("Robert", "Rose"));
		userList.add(new User("Tim", "Tebow"));
		userList.add(new User("Stephen", "Schilling"));
		userList.add(new User("Michael", "Morgan"));
		userList.add(new User("Dorin", "Dickerson"));
		userList.add(new User("Ryan", "Reynolds"));
		userList.add(new User("Dan", "Doering"));
		userList.add(new User("Mohamed", "Massaquoi"));
		userList.add(new User("Mario", "Manningham"));
		userList.add(new User("Curtis", "Crouch"));
		userList.add(new User("Avery", "Atkins"));
		userList.add(new User("Terrance", "Taylor"));
		userList.add(new User("Willie", "Williams"));
		userList.add(new User("Cameron", "Colvin"));
		userList.add(new User("Lance", "Leggett"));
		userList.add(new User("Brandon", "Barrett"));
		userList.add(new User("Brandon", "Braxton"));
		userList.add(new User("Josh", "Johnson"));
		userList.add(new User("Brian", "Brohm"));
		userList.add(new User("Doug", "Dutch"));
		userList.add(new User("Steve", "Smith"));
		userList.add(new User("Dennis", "Dixon"));
		userList.add(new User("Mike", "Mason"));
		userList.add(new User("Donovan", "Davis"));
		userList.add(new User("Jason", "Jack"));
		userList.add(new User("Craig", "Chambers"));
		userList.add(new User("Julian", "Jenkins"));
		userList.add(new User("Doug", "Datish"));
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Put the user list in request and 
		//let freemarker paint it.
		request.setAttribute("users", userList);
		
		request.getRequestDispatcher("/helloListOfPeople.ftl").forward(request, response);

	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		
		if(null != firstname && null != lastname
				&& !firstname.isEmpty() && !lastname.isEmpty()) {
			
			synchronized (userList) {
				userList.add(new User(firstname, lastname));
			}
			
		}
		
		doGet(request, response);
	}
}
