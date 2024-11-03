package library.transactions;

import library.books.Book;
import library.members.Member;

public class Transaction {
    private Book book;
    private Member member;

    public Transaction(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    public void issueBook() {
        if (book.isAvailable()) {
            book.setAvailability(false);
            System.out.println("Book issued to " + member.getName());
        } else {
            System.out.println("Book is not available.");
        }
    }

    public void returnBook() {
        book.setAvailability(true);
        System.out.println("Book returned by " + member.getName());
    }
}
