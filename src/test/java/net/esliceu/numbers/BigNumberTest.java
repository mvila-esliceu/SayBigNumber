package net.esliceu.numbers;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BigNumberTest {
    @Test
    public void compara_dos_bignumbers_son_iguals() {
        BigNumber bigNumber1 = new BigNumber("2");
        BigNumber bigNumber2 = new BigNumber("2");

        assertEquals(true, bigNumber1.equals(bigNumber2));
    }

    @Test
    public void compara_dos_bignumbers_son_equivalents() {
        BigNumber bigNumber1 = new BigNumber("000");
        BigNumber bigNumber2 = new BigNumber("0");

        assertEquals(true, bigNumber1.equals(bigNumber2));
    }

    @Test
    public void compara_dos_amb_tres_retorna_menys_un() {
        compara("2", "3", -1);
    }

    @Test
    public void compara_tres_amb_dos_retorna_un() {
        compara("3", "2", 1);
    }

    @Test
    public void compara_vint_amb_vint_i_un_retorna_menys_un() {
        compara("20", "21", -1);
    }

    @Test
    public void compara_vint_amb_3_retorna_un() {
        compara("20", "3", 1);
    }


    @Test
    public void compara_vint_amb_zerozerotres_retorna_un() {
        compara("20", "003", 1);
    }


    @Test
    public void compara_tres_amb_vint_retorna_mensy_un() {
        compara("3", "20", -1);
    }


    @Test
    public void suma_0_mes_0_dona_zero() {
        String primerNumber = "0";
        String segonNumber = "0";
        String expected = "0";
        suma(primerNumber, segonNumber, expected);
    }

    @Test
    public void suma_1_mes_0_dona_un() {
        suma("1", "0", "1");
    }

    @Test
    public void suma_11_mes_22_dona_trenta_tres() {
        suma("10", "22", "32");
    }

    @Test
    public void suma_17_mes_25_dona_quaranta_dos() {
        suma("17", "25", "42");
    }

    @Test
    public void suma_100_mes_1_dona_cent_un() {
        suma("100", "1", "101");
    }

    @Test
    public void suma_1_mes_100_dona_cent_un() {
        suma("1", "100", "101");
    }


    @Test
    public void suma_1245_mes_323_dona_mil_cinc_cents_seixanta_vuit() {
        suma("1245", "323", "1568");
    }



    @Test
    public void suma_10000000000000000245_mes_10000000000000000000_dona_molt() {
        suma("10000000000000000245", "00000100000000000000", "10000100000000000245");
    }

    @Test
    public void resta_1_menys_1_dona_0() {
        resta("1", "1", "0");
    }

    @Test
    public void resta_10_menys_1_dona_9() {
        resta("10", "1", "9");
    }

    @Test
    public void resta_211_menys_199_dona_12() {
        resta("211", "199", "12");
    }

    @Test
    public void resta_8211_menys_299_dona_7912() {
        resta("8211", "299", "7912");
    }


    private void resta(String primerNumber, String segonNumber, String expected) {
        BigNumber primerBigNumber = new BigNumber(primerNumber);
        BigNumber segonBigNumber = new BigNumber(segonNumber);
        assertEquals(expected, primerBigNumber.subtract(segonBigNumber));
    }


    private void suma(String primerNumber, String segonNumber, String expected) {
        BigNumber primerBigNumber = new BigNumber(primerNumber);
        BigNumber segonBigNumber = new BigNumber(segonNumber);
        assertEquals(expected, primerBigNumber.add(segonBigNumber));
    }

    private void compara(String first, String second, int expected) {
        BigNumber primerBigNumber = new BigNumber(first);
        BigNumber segonBigNumber = new BigNumber(second);


        assertEquals(expected, primerBigNumber.compareTo(segonBigNumber));
    }
}
