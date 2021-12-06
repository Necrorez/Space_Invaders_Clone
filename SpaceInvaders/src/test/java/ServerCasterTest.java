import SpaceX05.Observer.ClientListener;
import SpaceX05.Observer.ServerCaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServerCasterTest {

    private ServerCaster underTest;

    @BeforeEach
    void setUp() {
        underTest = new ServerCaster();
    }
    @DisplayName("Test for Observer pattern add and update")
    @Test
    void ServerCasterTestUpdateAndAdd() {
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        var clientListener = new ServerCaster();
        clientListener.addObserver(new ClientListener(printWriter));
        clientListener.notifyPlayers("START");
        String expected = expectedStringWriter.toString();
        assertEquals("START\n", expected);
    }

    @DisplayName("Test for Observer pattern remove")
    @Test
    void ServerCasterTestRemove() {
        StringWriter expectedStringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(expectedStringWriter);
        var clientListener = new ServerCaster();

        var toRemove = new ClientListener(printWriter);
        clientListener.addObserver(toRemove);
        clientListener.notifyPlayers("START");
        String expected = expectedStringWriter.toString();
        assertEquals("START\n", expected);
        clientListener.removeObserver(toRemove);
        clientListener.notifyPlayers("END");
        expected = expectedStringWriter.toString();
        assertNotEquals("BEGIN\nEND\n", expected);
    }


}