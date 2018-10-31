package project.models;

import project.constants.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
public void createPersonTest(){
   // Person person=new Person("Ivan",18, Gender.MALE);
 //   assertEquals("Ivan", person.getName());
  //  assertEquals(18, person.getAge());
    assertThrows(IllegalArgumentException.class,  ()->new Person("Ivan",101, Gender.MALE));

}


}