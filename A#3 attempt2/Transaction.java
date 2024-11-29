import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Transaction {

    private static Transaction instance;

    private Transaction(){}

    public static Transaction getTransaction()
    {
        if(instance == null)
            {instance = new Transaction();}
        return instance;
    }

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            System.out.println(transactionDetails);
            saveTransaction(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }

    //save transactions as a string
    public void saveTransaction(String string)
    {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Transactions.txt"));
            writer.write(string);
            writer.write("\n");
            
            writer.close();
        } catch (IOException e) {
            // default catch
            e.printStackTrace();
        }
    
    }
    //retreive history
    public void displayTransactionHistory()
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Transactions.txt"));
            System.out.println(reader.read());
            reader.close();
        }
        catch(FileNotFoundException e )
        {
            System.out.println("file not found");
        }
        catch(IOException e)
        {
            // default catch
            e.printStackTrace();}
    }
}