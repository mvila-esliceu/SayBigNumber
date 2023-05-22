package net.esliceu.numbers;


import org.junit.*;


/**
 * Test list:
 *  1. Nombres naturals (0-9) --> OK
 *  2. Decenes
 *      2.1 Decenes (30-99)
 *      2.2 Primera dezena (10-19)
 *      2.3 Segona dezena (20-29)
 *  //D-U-C
 *  5. Negatius
 *  6. Centenes
 *  7. Nombres més complexes: 10, 20, 11...19, 21...29, 30...
 */


public class NumbersCatTest {

    private Numbers numbers;
    
    @Before
    public void before() {
        numbers = new NumbersCat();        
    }

    @Test
    public void donat_0_retorna_Zero() {
        Assert.assertEquals("Zero", numbers.say(0));
    }

    @Test
    public void donat_1_retorna_Un() {
        Assert.assertEquals("Un", numbers.say(1));
    }

    @Test
    public void donat_2_retorna_Dos() {
        Assert.assertEquals("Dos", numbers.say(2));
    }


    @Test
    public void donat_7_retornat_Set() {
        Assert.assertEquals("Set", numbers.say(7));
    }

    @Test
    public void donat_3_negatiu_retorna_Menys_tres() {
        Assert.assertEquals("Menys tres", numbers.say(-3));
    }

    @Test
    public void donat_31_retorna_Trenta_un() {
        Assert.assertEquals("Trenta-un", numbers.say(31));
    }

    @Test
    public void donat_33_retorna_Trenta_tres() {
        Assert.assertEquals("Trenta-tres", numbers.say(33));
    }

    @Test
    public void donat_30_retorna_Trenta() {
        Assert.assertEquals("Trenta", numbers.say(30));
    }

    @Test
    public void donat_20_retorna_Vint() {
        Assert.assertEquals("Vint", numbers.say(20));
    }


    @Test
    public void donat_21_retorna_Vint_i_un() {
        Assert.assertEquals("Vint-i-un", numbers.say(21));
    }

    @Test
    public void donat_10_retorna_Deu() {
        Assert.assertEquals("Deu", numbers.say(10));
    }

    @Test
    public void donat_11_retorna_Onze() {
        Assert.assertEquals("Onze", numbers.say(11));
    }

    @Test
    public void donat_15_retornat_Quinze() {
        Assert.assertEquals("Quinze", numbers.say(15));
    }

    @Test
    @Ignore
    public void donat_100_retorna_Cent() {
        Assert.assertEquals("Cent", numbers.say(100));

    }
}
