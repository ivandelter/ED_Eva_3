package com.pruebas;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.service.SmartPhoneServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Test1 {
    private SmartPhoneServiceImpl sps;

    @Test
    @Order(2)
    @DisplayName("Count prueba 1")
    void count1(){
        sps = new SmartPhoneServiceImpl();

        assertNotNull(sps.count());
    }

    @Test
    @Order(1)
    @DisplayName("Count prueba 2")
    void count2(){
        sps = new SmartPhoneServiceImpl();
        assertTrue(sps.count() > 0);
    }

    @Test
    @Order(3)
    @DisplayName("Count prueba 3")
    void count3(){
        sps = new SmartPhoneServiceImpl();
        assertEquals(3, sps.count());
    }

    @Test
    @DisplayName("Count prueba 4")
    void count4(){
        sps = new SmartPhoneServiceImpl();
        assertEquals(4, sps.count());
    }

    @Test
    @DisplayName("Count prueba buscar")
    void findOne(){
        sps = new SmartPhoneServiceImpl();
        assertThrows(IllegalArgumentException.class, () -> {
            sps.findOne(null);
        });
    }

    @Test
    @DisplayName("Count prueba contar todos")
    void countAll() {
        sps = new SmartPhoneServiceImpl();
        assertAll(
                "Grupo 3.1, 3.2 y 3.3",
                () -> assertNotNull(sps.count()),
                () -> assertTrue(sps.count() > 0),
                () -> assertEquals(3, sps.count())
        );
    }

    /*@BeforeEach
    void mensajeEach(){
        System.out.println("Llamado desde un before each");
    }*/

    /*@BeforeAll
    static void mensajeAll(){
        System.out.println("Llamado desde un before all");
    }*/

    /*@AfterAll
    static void mensajeAll2(){
        System.out.println("Llamado desde un after all.");
    }*/

    /*@AfterEach
    void mensajeEach2(){
        System.out.println("Llamado desde un after each");
    }*/
}