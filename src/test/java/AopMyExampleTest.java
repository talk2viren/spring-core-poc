
/* Use cases / Aspected = Logging
    Transaction
    loggin
    performance

    https://www.youtube.com/watch?v=Og9Fyew8ltQ
    https://github.com/in28minutes/SpringIn28Minutes/blob/master/1.BasicExample/src/test/java/com/in28minutes/example/spring/business/aop/AOPExampleTest.java


// Satic
    Aspect : Usecase
    Pointcut : expression to intersept
    ex: execution(* com.in28minutes.example.spring.business.aop.HiByeService.*(..))
    Advice : Action / what to be done once pointcut is met

// Dynamic : Runtime

//Dynamic - Runtime
    //Join point: a point during the execution of a program, such as the execution of a method or the handling of an exception.
    //In Spring AOP, a join point always represents a method execution.
    //Weaving: linking aspects with other application types or objects to create an advised object. This can be done at compile time (using the AspectJ compiler, for example), load time, or at runtime. Spring AOP, like other pure Java AOP frameworks, performs weaving at runtime.
*/

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

public class AopMyExampleTest {
}

@Aspect
@Component
class MyAspect {
    @Before("execution(* com.in28minutes.example.spring.business.aop.HiByeService.*(..))")
    public void before(JoinPoint joinPoint) {
        System.out.print("Before ");
        System.out.print(joinPoint.getSignature().getName() + " called with ");
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(pointcut = "execution(* com.in28minutes.example.spring.business.aop.HiByeService.*(..))", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        System.out.print("After ");
        System.out.print(joinPoint.getSignature().getName());
        System.out.println(" result is " + result);
    }

}

@Component
class HiByeService {
    public void sayHi(String name) {
        System.out.println("Hi " + name);
    }

    public void sayBye() {
        System.out.println("Bye");
    }

    public String returnSomething() {
        return "Hi Bye";
    }
}