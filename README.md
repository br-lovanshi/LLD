## System Desing



- [ ] Data Structure & Algorithms
- [ ] Core Java
- [ ] RDBMS
- [ ] Spring Boot
- [ ] Kafka
- [ ] Redis
- [ ] Unit Testing
- [ ] Microservices
- [ ] System Design
- [x] LLD
- [ ] AWS
- [ ] UI - Angular/React


---

- **Low Level Design (LLD):  **LLD is how to implement, its fills the gaps between design and development before starting an actual implementation/development we do lld.
How classes are interacting with each other, how much classes, objects, methods, atributes are needed we defined  in low level design.



1. **OOPS:  **
> 1. **Encapsulation**: Binding data into a single unit.



```

public class Student{
  private int id;
  private String name;

  public Student(int id, String name){
     this.id = id;
     this.name = name;
  }
} 
```
> **2. Abstraction:  **Show only  method signature and hide its implementation for simplicity.

```
  public interface StudentService{
    Student getStudentData(int id);
    void setStudentData(Student student);
  }
  // or
  public abstract StudentService{
    int id = 0;
    abstract Student getStudentData(int id);
    public void getStudents(){
      
    }
  }`﻿` 
```
> ** ﻿3. Inheritance:** Inherit parents properties into children. 

```
public class Student{
  void greet(){}
} 

public class Junior extends Student{
  
  @Override
  public void greet(){
    System.out.println("Greeting from juniors");
  }
}
```
> 4. Polymorphism: Many forms of same entity/class

```
public class Student{
  
  // Complietime polymorphism/ method overloading
  void getStudent(int roll){
  }
  
  void getStudent(int roll, String isJunior){
  }

  void getStudent(double roll){
  }
}

// method overrding

public class Junior extends Student{
  
  @Override
  public void getStudent(int roll){
  }
  
}
 
class Main{
  
  public static void main(String args[]){
    
    // runtime polymorphism
    Student student = new Student();
    student.getStudent(10);
    
    Student junior = new Junior();
    junior.getStudent(10);
  }
}
```


1. **Class Relationship**
2. **UML**
3. **SOLID Principles**
4. **Desing Patterns**


