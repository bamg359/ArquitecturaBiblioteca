package personallibrary;

import java.util.Scanner;

public class LibraryService {

    static Scanner sc = new Scanner(System.in);

    public static void createBook(){
        System.out.println("Ingrese el nombre del libro: ");
        String bookName = sc.nextLine();
        System.out.println("Ingrese el nombre del autor");
        String author = sc.nextLine();
        System.out.println("Ingrese el ISBN");
        String isbn = sc.nextLine();
        System.out.println("Ingrese el número de páginas");
        int pages = sc.nextInt();
        System.out.println("Ingrese la categoria");
        String category = sc.next();

        LibraryModel registerBook = new LibraryModel();

        registerBook.setBookName(bookName);
        registerBook.setAuthor(author);
        registerBook.setIsbn(isbn);
        registerBook.setPages(pages);
        registerBook.setCategory(category);

        LibraryDAO.registerBookDB(registerBook);


    }

    public static void updateBook(){
        System.out.println("Indique el nombre del libro a actualizar:");
        String bookName = sc.nextLine();

        System.out.println("Indique el nombre del Autor a Actualizar");
        String author= sc.nextLine();

        System.out.println("Indique el ID del libro a actualizar");
        int  id_book = sc.nextInt();

        LibraryModel updatingBook = new LibraryModel();

        updatingBook.setBookName(bookName);
        updatingBook.setAuthor(author);
        updatingBook.setId_book(id_book);

        LibraryDAO.updateBookDB(updatingBook);


    }

    public static  void listBook(){

        LibraryDAO.listBookDB();

    }

    public static void deleteBook(){
        System.out.println("Indique el ID del libro a eliminar: ");
        int id_book = sc.nextInt();
        LibraryDAO.deleteBookDB(id_book);


    }







}
