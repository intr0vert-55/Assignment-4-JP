import library.books.Book;
import library.members.Member;
import library.transactions.Transaction;

public class LibraryManagement {
    public static void main(String[] args) {
        Book book = new Book("The Song of Ice and Fire", "George RR Martin", "9780061122415");
        Member member = new Member("M001", "Jon Snow");
        
        Transaction transaction = new Transaction(book, member);
        transaction.issueBook();
        transaction.returnBook();
    }
}
