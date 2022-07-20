package mx.com.cdc.apihub.ve;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class MainTest {


    @Test
    public void testImmutableCollections() {

        List<String> fruits = Arrays.asList(new String[]{"Mangosteen", "Durian fruit", "Longan"});

        assertThrows(UnsupportedOperationException.class, () -> {
            fruits.add("Mango");
            fruits.remove(1);
        });

        assertEquals(3, fruits.size());

    }
}