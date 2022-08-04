package serviceTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.*;

import java.beans.PersistenceDelegate;

import static org.junit.Assert.*;
public class FirstTest {
//    private static String name;
//    @Before
//    public void beforeTest() {
//        System.out.println("im first run");
//        name = "sara";
//    }
//    @Before
//    public void beforeTest2() {
//        System.out.println("im first run");
//        name = "amir";
//    }

//    @Test
//    public void testInitString() {
//        System.out.println(name);
//        assertNull(name);
//        System.out.println("then before im run");
//        System.out.println(name);
//        System.out.println();
//    }
//
//    @After
//    public void inits() {
//        name = "amir";
//        System.out.println("at the end im run");
//        System.out.println(name);
//    }
//    @After
//    public void inits2() {
//        name = "sara";
//        System.out.println("at the end im run");
//        System.out.println(name);
//    }
//    @Test
//    public void TestSum(){
//        assertNotEquals(19,Main.sum(9,10));
//
//         !   assertEquals() =   assertNotEquals();
//    }

// وقتی می گیم ازرت ایککوال یعنی دو طرف متد باید با هم برابر باشن
//

    @Test
    public void checkPersonCreat(){
        Person person = new Person("sara ");
        assertNotNull(person.getName());
       // assertNotNull(person.age);
    }

}
