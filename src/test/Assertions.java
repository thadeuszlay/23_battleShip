package test;

import org.junit.*;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by think on 21.05.17.
 */
public class Assertions {
    private ArrayList<String> testList;

    @BeforeClass
    public static void onceExecutedBeforeAll() {
        System.out.println("@BeforeClass: onceExecutedBeforeAll");
    }

    @Before
    public void executedBeforeEach() {
        ArrayList<String> testList = new ArrayList<>();
        System.out.println("@Before: executedBeforeEach");
    }

    @AfterClass
    public static void onceExecutedAfterAll() {
        System.out.println("@AfterClass: onceExecutedAfterAll");
    }

    @After
    public void executedAfterEach() {
        testList.clear();
        System.out.println("@After: executedAfterEach");
    }

    @Test
    public void EmptyCollection() {
        ArrayList<String> testList = new ArrayList<>();
        Assert.assertTrue(testList.isEmpty());
        System.out.println("@Test: EmptyArrayList");

    }

    @Test
    public void OneItemCollection() {
        ArrayList<String> testList = new ArrayList<>();
        testList.add("oneItem");
        assertEquals(1, testList.size());
        System.out.println("@Test: OneItemArrayList");
    }
}
