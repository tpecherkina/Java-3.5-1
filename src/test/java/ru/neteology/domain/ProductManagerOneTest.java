package ru.neteology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerOneTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    private Product book1;

    {
        book1 = new Book(1, "Один", 2, "Автор1");
    }

    @Test
    void searchTitleOneBook() {
        manager.add(book1);
        Product[] expected = new Product[]{book1};
        Product[] actual = manager.searchBy("Один");

        assertArrayEquals(expected, actual);
    }
}