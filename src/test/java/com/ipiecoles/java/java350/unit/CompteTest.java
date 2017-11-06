package com.ipiecoles.java.java350.unit;

import com.ipiecoles.java.java350.Compte;
import com.ipiecoles.java.java350.utils.TestUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class CompteTest {

    @Test
    public void testCompte(){
        //Given
        String input = "C" + TestUtils.LINE_SEPARATOR + "123" + TestUtils.LINE_SEPARATOR + "500" + TestUtils.LINE_SEPARATOR;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        //When
        Compte c = new Compte();

        //Then
        Assertions.assertThat(c.getTypeCompte()).isEqualTo("Courant");
        Assertions.assertThat(c.getNumeroCompte()).isEqualTo("123");
        Assertions.assertThat(c.getValeurCourante()).isEqualTo(500.0);
    }
    
    @Test
    public void test_Compte_Epargne(){
        //Given
        String input = "J" + TestUtils.LINE_SEPARATOR + "123" + TestUtils.LINE_SEPARATOR + "500" + TestUtils.LINE_SEPARATOR;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        //When
        Compte c = new Compte();

        //Then
        Assertions.assertThat(c.getTypeCompte()).isEqualTo("Joint");
        Assertions.assertThat(c.getNumeroCompte()).isEqualTo("123");
        Assertions.assertThat(c.getValeurCourante()).isEqualTo(500.0);
    }
    
    @Test
    //Should prevent the false epargne type and force the user to choose a valid count type
    public void test_Compte_Epargne_With_False_String(){
        //Given
        String input = "F" + TestUtils.LINE_SEPARATOR + "123" + TestUtils.LINE_SEPARATOR + "500" + TestUtils.LINE_SEPARATOR;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        //When
        Compte c = new Compte("NotEparnge");

        //Then
        Assertions.assertThat(c.getTypeCompte()).isNotEqualTo("NotEpargne");
        Assertions.assertThat(c.getTypeCompte()).isEqualTo("Courant");
    }
 
    @Test
    public void Should_Not_Let_The_Initial_Value_To_A_Negative_Value(){
        //Given
        String input = "C" + TestUtils.LINE_SEPARATOR + "123" + TestUtils.LINE_SEPARATOR + "500" + TestUtils.LINE_SEPARATOR;
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        //When
        Compte c = new Compte();

        //Then
        Assertions.assertThat(c.getValeurCourante()).isNotEqualTo(-500.0);
    }
    
}
