/*
package delete.mokitoTested;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MainTest {


    //-----------------------------------------------------------------------------------------------
    @Mock
    List<Integer> annotationMock;

    @Test
    void main() {

        //полностью виртуальный объект, вызовы методов заглушены.
        ArrayList mockList = Mockito.mock(ArrayList.class);
        annotationMock.add(2);
        mockList.add("sad");

    }

    //-----------------------------------------------------------------------------------------------
    //Вариант Spy1

    @Spy
    List mockSpyListAnnotation = new ArrayList<String>();

    @Test
    void testSpy() {
        //Вариант Spy2
        //Объект ArrayList есть внутри Mockito обращение перенаправляет запросы основному объекту, но возможно измерение поведения
        List<String> spyList = Mockito.spy(new ArrayList<String>());
        spyList.add("one");
        spyList.add("two");
        assertEquals(spyList, spyList);
    }

    //-----------------------------------------------------------------------------------------------

    @Mock
    ArrayList<String> testMockArray;

    @Disabled
    @Test
    public void testMethodReturn() {
        Mockito.doReturn(10).when(testMockArray).size();
        assertEquals(10, testMockArray.size());

        Mockito.when(testMockArray.size()).thenReturn(9);
        assertEquals(9, testMockArray.size());
    }


    //-----------------------------------------------------------------------------------------------
    @Test
    public void testThrown() {
        Mockito.doThrow(NullPointerException.class).when(testMockArray).get(0);
        assertThrows(NullPointerException.class, () -> testMockArray.get(0));

        Mockito.when(testMockArray.isEmpty()).thenThrow(ClassCastException.class);
        assertThrows(ClassCastException.class, () -> testMockArray.isEmpty());
    }

    //-----------------------------------------------------------------------------------------------
//Не понял смысл работы метода doAnswer
    public void testDoAnswer() {
        Mockito.doAnswer(invocation -> {
            Object argument = invocation.getArgument(0);
            return argument;
        });
    }

    //-----------------------------------------------------------------------------------------------

    @Test
    @DisplayName("Test verify")
    public void testMethodVerify() {
        String s = testMockArray.get(10);
        Mockito.verify(testMockArray).get(10);
    }


    //-----------------------------------------------------------------------------------------------
    @Test
    @DisplayName("Verify n count")
    public void testVerify() {
        VerificationMode never = Mockito.never();
        int size3 = Mockito.verify(testMockArray, never).size();
        System.out.println(size3 + " size 3 mockito never");

        int size = testMockArray.size();

        Mockito.verify(testMockArray, Mockito.atMostOnce()).size();
        int size1 = testMockArray.size();
        int size2 = testMockArray.size();

        VerificationMode verificationMode = Mockito.times(3);
        int size4 = Mockito.verify(testMockArray, verificationMode).size();
        System.out.println(size4 + " size 4 mockito times");

        VerificationMode atLeast = Mockito.atLeast(2);
        Mockito.verify(testMockArray, atLeast).size();

        VerificationMode atLeastOnce = Mockito.atLeastOnce();
        Mockito.verify(testMockArray, atLeastOnce).size();

        Mockito.verify(testMockArray, Mockito.atMost(5)).size();


    }
    //-----------------------------------------------------------------------------------------------

    @Test
    public void testInOrder() {
        testMockArray.get(1);
        testMockArray.get(2);
        testMockArray.size();
        testMockArray.remove(2);
        testMockArray.size();

        InOrder inOrder = Mockito.inOrder(testMockArray);
        inOrder.verify(testMockArray).get(1);
        inOrder.verify(testMockArray).get(2);
        inOrder.verify(testMockArray).size();
        inOrder.verify(testMockArray).remove(2);
        inOrder.verify(testMockArray).size();
    }

    //Не получилось написать тест
    public void testStaticMethod() {

        try (MockedStatic<System> staticMock = Mockito.mockStatic(System.class)) {
            staticMock.when(System::currentTimeMillis).thenReturn(4);

            assertEquals(4, System.currentTimeMillis());
        }
    }


    //-----------------------------------------------------------------------------------------------

}*/
