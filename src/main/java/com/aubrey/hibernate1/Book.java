package com.aubrey.hibernate1;

public class Book {
	private int rank;
	private String title;
	private String author;
	private int sales;
	private String imprint;
	private String publisher;
	private int yearPublished;
	private String genre;
	private int status;
	private int borrower;

	public Book() {
		super();
	}

	public Book(String title, String author, int sales, String imprint, String publisher, int yearPublished,
			String genre, int status, int borrower) {
		this.title = title;
		this.author = author;
		this.sales = sales;
		this.imprint = imprint;
		this.publisher = publisher;
		this.yearPublished = yearPublished;
		this.genre = genre;
		this.status = status;
		this.borrower = borrower;
	}
	public void setRank(int rank){
		this.rank = rank;
	}
	public int getRank(){
		return rank;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public String getImprint() {
		return imprint;
	}

	public void setImprint(String imprint) {
		this.imprint = imprint;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int yearPublished) {
		this.yearPublished = yearPublished;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getBorrower() {
		return borrower;
	}

	public void setBorrower(int borrower) {
		this.borrower = borrower;
	}

}
