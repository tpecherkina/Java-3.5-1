package ru.neteology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1;

    {
        book1 = new Book(1, "Один", 2, "Автор1");
    }

    private Product book2 = new Book(2, "Два", 2, "Автор2");
    private Product book3 = new Book(3, "Три", 2, "Автор3");
    private Product book4 = new Book(4, "Четыре", 2, "Автор4");
    private Product book5 = new Book(5, "Пять", 2, "Автор5");
    private Product smartphone1 = new Smartphone(6, "Телефон1", 2, "Samsung");
    private Product smartphone2 = new Smartphone(7, "Телефон2", 2, "Samsung");
    private Product smartphone3 = new Smartphone(8, "Телефон3", 2, "Samsung");
    private Product smartphone4 = new Smartphone(9, "Телефон5", 2, "Apple");
    private Product smartphone5 = new Smartphone(10, "Телефон6", 2, "Apple");

    @BeforeEach
    public void setUp() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(book4);
        manager.add(book5);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
        manager.add(smartphone4);
        manager.add(smartphone5);
    }

    @Test
    void searchTitleBook() {
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Три");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchAuthorBook() {
        Product[] expected = new Product[]{book3};
        Product[] actual = manager.searchBy("Автор3");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchNameSmartphone() {
        Product[] expected = new Product[]{smartphone1};
        Product[] actual = manager.searchBy("Телефон1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchProducerSmartphone() {
        Product[] expected = new Product[]{smartphone1, smartphone2, smartphone3};
        Product[] actual = manager.searchBy("Samsung");
        assertArrayEquals(expected, actual);
    }


}
