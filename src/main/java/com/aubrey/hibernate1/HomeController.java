package com.aubrey.hibernate1;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		//get list of books from DAO
		
		List <Book> books = DAO.getAllBooks();
		
		//get list of books add to the model
		model.addAttribute("bookList", books );
		
		return "list";
		
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(Model model, HttpServletRequest request) {
		//get list of books from DAO
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		int sales = Integer.parseInt(request.getParameter("sales"));
		String imprint = request.getParameter("imprint");
		String publisher = request.getParameter("publisher");
		int yearPublished = Integer.parseInt(request.getParameter("yearPublished"));
		String genre = request.getParameter("genre");
		int status = Integer.parseInt(request.getParameter("status"));
		int borrower = Integer.parseInt(request.getParameter("borrower"));
		


		Book j = new Book(title, author, sales, imprint, publisher, yearPublished, genre, status, borrower);
		
		int books = DAO.addBook(j);
		
		//get list of books add to the model
		
		model.addAttribute("title", title );
		model.addAttribute("author", author );
		model.addAttribute("sales", sales );
		model.addAttribute("imprint", imprint );
		model.addAttribute("publisher", publisher );
		model.addAttribute("yearPublished", title );
		model.addAttribute("genre", genre );
		model.addAttribute("status", status );
		model.addAttribute("borrower", borrower );

		
		return "anthony";
		
	}
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Model model, HttpServletRequest request) {
		int rank = Integer.parseInt(request.getParameter("delete"));
		Book b = DAO.deleteBook(rank);
		
		model.addAttribute("title", b.getTitle());
		model.addAttribute("author", b.getAuthor());
		model.addAttribute("yearPub", b.getYearPublished());

  
		return "delete";
}
}
