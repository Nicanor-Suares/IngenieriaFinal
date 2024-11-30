import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDate;
import testingfinal.PaseMensual;
import testingfinal.PaseVencidoException;
import testingfinal.Socio;

public class mixGymTest {
    private static Socio s1;
    private static Socio s2;
    private static PaseMensual paseMensual;
    private static int testNumber = 0;

    @BeforeClass
    public static void antesDeTodo() {
        s1 = new Socio(12345678, "Nicanor");
        s2 = new Socio(87654321, "Pablo");
        paseMensual = new PaseMensual(1, LocalDate.of(2024, 11, 1), LocalDate.now(), 8, true, s1);
        System.out.println("Inicializando las pruebas.");
    }

    @AfterClass
    public static void despuesDeTodo() {
        System.out.println(LocalDate.now().minusDays(1) + ": Fin de las pruebas.");
    }

    @Before
    public void antesDeCadaPrueba() {
        testNumber++;
        System.out.println("========== Test #" + testNumber + " ==========");
    }

    @After
    public void despuesDeCadaPrueba() {
        System.out.println("======================================");
    }

    @Test(timeout = 30)
    public void noAndaElCheck() throws InterruptedException {
        Thread.sleep(60);
    }

    @Test
    public void testSociosDiferentes() {
        assertNotSame("Los socios deberían ser diferentes", s1.sociosDiferentes(s2));
    }

    @Test
    public void descontarPaseTest() throws PaseVencidoException {
        int nroPase = 1;
        LocalDate fechaIni = LocalDate.now().minusMonths(1);
        LocalDate fechaFin = LocalDate.now();
        int entradas = 8;
        boolean estado = true;
        
        Socio socio = new Socio(12366678, "Pepe");

        PaseMensual pase = new PaseMensual(nroPase, fechaIni, fechaFin, entradas, estado, socio);

        int entradasRestantes = pase.descontarPase();
        assertEquals("El número de entradas debe haber disminuido en 1.", 7, entradasRestantes);
    }


    @Test
    public void descontarPaseTest2() {
        PaseMensual paseSinEntradas = new PaseMensual(2, LocalDate.now(), LocalDate.now(), 0, true, s1);
        try {
            paseSinEntradas.descontarPase();
            fail("No debería descontar entradas de un pase sin entradas");
        } catch (PaseVencidoException e) {
            System.out.println("Se manejó correctamente el caso de pase sin entradas.");
        }
    }

    @Test(expected = PaseVencidoException.class)
    public void descontarPaseTest3() throws PaseVencidoException {
        PaseMensual paseVencido = new PaseMensual(3, LocalDate.now().minusDays(10), LocalDate.now().minusDays(1), 8, true, s1);
        paseVencido.descontarPase();
    }

    @Test
    public void comprarGatoradeTest() {
        int precio = s1.ComprarGatorade("2x1", 2100);
        assertEquals("El precio debería ser 1050 para el código 2x1", 1050, precio);
    }
}