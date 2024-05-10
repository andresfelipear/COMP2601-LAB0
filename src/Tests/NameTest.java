import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest
{
    Name n1;
    Name n2;

    @BeforeEach
    void setUp()
    {
        n1 = new Name("tigER", "wooDS");
        n2 = new Name("eLoN", "MuSk");
    }

    @AfterEach
    void tearDown()
    {
        n1 = null;
        n2 = null;
    }

    @Test
    void getInitials()
    {
        assertEquals("T.W.", n1.getInitials());
        assertEquals("E.M.", n2.getInitials());
    }

    @Test
    void getFullName()
    {
        assertEquals("Tiger Woods", n1.getFullName());
        assertEquals("Elon Musk", n2.getFullName());
    }

    @Test
    void getFirst()
    {
        Name name = new Name("tigER", "wooDS");
        assertEquals("tigER", name.getFirst());

        name = new Name("eLoN", "MuSk");
        assertEquals("eLoN", name.getFirst());

    }

    @Test
    public void constructorThrows_withBadArgument() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(null, "wooDS");
        });

        String expectedMessage = "bad first name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void emptyFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("", "wooDS");
        });

        String expectedMessage = "bad first name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void whiteSpaceFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name(" ", "wooDS");
        });

        String expectedMessage = "bad first name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void containsAdminFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("admin", "wooDS");
        });

        String expectedMessage = "bad first name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void tooLongFirstName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("asdasjdasdhdsajdjasdjasdjsdjasdajsdjasdjasdjasdjsadjasdjasdjasjdasjdasjdasjdasjdsajdasdjd", "wooDS");
        });

        String expectedMessage = "bad first name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void emptyLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("Tiger", "");
        });

        String expectedMessage = "bad last name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void whiteSpaceLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("TigeR", " ");
        });

        String expectedMessage = "bad last name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void containsAdminLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("Tiger", "adminWoods");
        });

        String expectedMessage = "bad last name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }

    @Test
    public void tooLongLastName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Name name = new Name("Tiger", "asdasjdasdhdsajdjasdjasdjsdjasdajsdjasdjasdjasdjsadjasdjasdjasjdasjdasjdasjdasjdsajdasdjd");
        });

        String expectedMessage = "bad last name!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.equals(expectedMessage));
    }







}