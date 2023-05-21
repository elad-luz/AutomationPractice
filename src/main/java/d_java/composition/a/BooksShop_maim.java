package d_java.composition.a;

public class BooksShop_maim {

	public static void main(String[] args) {
		
		/** OUR Book Shop is made of:
		 * Books objects - but each Book is also composing a predefined objects of Author & Publisher.
		 * So to make a book you first need to have an author & publisher.
		 */
		
		// instances
		
//		Object objectGivenname = new Constructor(inputs);
		BookPublisher highTech = new BookPublisher("highTech", "ISRAEL"); // publisher instance is declared & initiated under class: bookPublisher
		System.out.println("details of bookPublisher " + highTech.toString());
		
		BookAuthor GalM = new BookAuthor("Gal Matalon", "Netanya"); // author instance is declared & initiated under class: bookAuthor
		System.out.println("details of bookAuthor: " + GalM.toString());
		
		// book instance is declared & initiated under class: book (that is linked to (composing) bookPublisher & bookAuthor classes (take object from them)
		
		Book book1 = new Book("The java world for QA", 2022, 100, GalM, highTech); // book1
		System.out.println("1. details of " + book1.toString());
		System.out.println(book1.whoIsTheAuthor() + " of: " + book1.getName()); // print-out the author of book1
		System.out.println(book1.whoIsThePublisher() + " of: " + book1.getName() +"\n"); // print-out the publisher of book1
		System.out.print("==> book1.printInfo():");
		book1.printInfo();

		Book book2 = new Book("The selenium world for QA", 2022, 90, GalM, highTech); // book2
		System.out.println("2. details of " + book2.toString());
		System.out.println(book2.whoIsTheAuthor() + " of: " + book2.getName()); // print-out the author of book2
		System.out.println(book2.whoIsThePublisher() + " of: " + book2.getName() +"\n"); // print-out the publisher of book2
		System.out.print("==> book12.printInfo():");
		book2.printInfo();

		System.out.println("NOW: " +book2.getName() +" have a discount of: 10 from price of: " + book2.getPrice()); // discount 10 from priced
		System.out.println("New price is: " + book2.discountPrice(10));
	}
	
	/** MORE:
		Author auothor1 = new Author("Elad Luz", "Brenner 1", 48); // Author must be defined before Book because it is used within book
		Publisher publisher1 = new Publisher("Pub", "Israel"); // Same as above
		AnyBook book1 = new AnyBook("Art", 2018, 100, auothor1, publisher1);
		
		System.out.println(book1.getInfo() + "\n");
		book1.printInfo();
		
		//
		Author auothor2 = new Author("Luz Elad", "Brenner 1, 21", 48); // Author must be defined before Book because it is used within book
		Publisher publisher2 = new Publisher("Publish House", "Israel"); // Same as above
		AnyBook book2 = new AnyBook("Architecture", 2018, 50, auothor2, publisher2);
		
		book2.printInfo();
		double dp = 3; // discount on Price is: 3	
		System.out.println("discount on Price is: " + dp + " - the new Price is: " + book2.discountPrice(dp));
	 */

}
