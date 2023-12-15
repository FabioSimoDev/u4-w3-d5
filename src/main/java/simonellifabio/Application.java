package simonellifabio;

import simonellifabio.entities.*;
import simonellifabio.entities.DAO.CatalogItemsDAO;
import simonellifabio.entities.DAO.LoanDAO;
import simonellifabio.entities.DAO.UserDAO;
import simonellifabio.entities.enums.magazine.Periodicity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Application {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblioteca");
        EntityManager em = emf.createEntityManager();

//        User newUser = new User();
//        newUser.setFirstName("Nome");
//        newUser.setLastName("Cognome");
//        newUser.setBirthDate(LocalDate.now());
//        newUser.setLoanList(new ArrayList<>());
//        newUser.setCardNumber(UUID.randomUUID());
//
//        Book newBook = new Book();
//        newBook.setISBN("978-3-16-148410-0");
//        newBook.setTitle("Esempio libro");
//        newBook.setPublicationYear(2023);
//        newBook.setPageCount(300);
//        newBook.setAuthor("Esempio autore");
//        newBook.setGenre("Fantasy");
//        newBook.setLoanList(new ArrayList<>());
//
//        Magazine newMagazine = new Magazine();
//        newMagazine.setISBN("434-3-16-324201-0");
//        newMagazine.setTitle("Esempio Rivista");
//        newMagazine.setPublicationYear(2023);
//        newMagazine.setPageCount(40);
//        newMagazine.setLoanList(new ArrayList<>());
//        newMagazine.setPeriodicity(Periodicity.MENSILE);
//
//        Loan newLoan = new Loan();
//        newLoan.setUser(newUser);
//        newLoan.setItem(newBook);
//        newLoan.setLoanDate(LocalDate.now());
//        newLoan.setExpectedReturnDate(LocalDate.now().plusDays(30));
//        newLoan.setActualReturnDate(LocalDate.of(2023, Month.DECEMBER, 21));
//
////        newUser.getLoanList().add(newLoan);
////        newBook.getLoanList().add(newLoan);
//
//        UserDAO userDAO = new UserDAO(em);
//        userDAO.save(newUser);
//
//        CatalogItemsDAO catalogItemsDAO = new CatalogItemsDAO(em);
//        catalogItemsDAO.save(newBook);
//        catalogItemsDAO.save(newMagazine);
//
//        LoanDAO loanDAO = new LoanDAO(em);
//        loanDAO.save(newLoan);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        CatalogItemsDAO catalogItemsDAO = new CatalogItemsDAO(em);
        List<CatalogItem> found;
        do{
            System.out.println("1 per aggiungere un elemento al catalogo" +
                    "\n2 per rimuovere un elemento tramite codice ISBN" +
                    "\n3 per cercare un elemento tramite codice ISBN" +
                    "\n4 per cercare un elemento tramite anno di pubblicazione" +
                    "\n5 per cercare per autore" +
                    "\n6 per cercare per titolo o parte di un titolo" +
                    "\n7 per cercare elementi attualmente in prestito dato un numero di tessera utente" +
                    "\n8 per cercare tutti i prestiti scaduti");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Inserisci codice ISBN");
                    String isbn = scanner.nextLine();
                    found = catalogItemsDAO.findByISBN(isbn);

                    for(CatalogItem item : found){
                        System.out.println(item);
                    }
                    break;
                case 4:
                    System.out.println("inserisci anno di pubblicazione");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    found = catalogItemsDAO.findByPublishingYear(year);

                    for(CatalogItem item : found){
                        System.out.println(found);
                    }
                    break;
                case 5:
                    System.out.println("inserisci nome autore");
                    String author = scanner.nextLine();
                    found = catalogItemsDAO.findByAuthor(author);

                    for(CatalogItem item : found){
                        System.out.println(item.toString());
                    }
                    break;
                case 6:
                    System.out.println("inserisci il titolo (o parte)");
                    String title = scanner.nextLine();
                    found = catalogItemsDAO.findByTitle(title);

                    for(CatalogItem item : found){
                        System.out.println(item);
                    }
                    break;
                default:
                    exit = true;
            }
        }while(!exit);

        em.close();
        emf.close();

    }
}
