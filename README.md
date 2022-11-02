<h1>Spring Framework Jargons</h1>

<h3>Beans</h3>

<p>Beans are the objects of classes that are managed by Spring. Traditionally, objects used to create their own dependencies, but Spring manages all the dependencies of an object and instantiates the object after injecting the required dependencies. The @Component annotation is the most common method of defining beans.</p>
<pre>
<code>
@Component
public class Vehicle {

}
</code>
</pre>

<h3>Autowiring</h3>
<p>The process of identifying a dependency, looking for a match, and then populating the dependency is called autowiring. The @Autowired annotation tells Spring to find and inject a collaborating bean into another. If more than one bean of the same type is available, Spring throws an error. In the following scenario, two beans of type Operator are detected by Spring:</p>

<pre>
<code>
@Component
class Arithmetic(){
    @Autowired
    private Operator operator;
    //...
}

@Component
class Addition implements Operator {

}

@Component
class Subtraction implements Operator {

}

</code>
</pre>

<p>Spring will not know which bean to inject in the Arithmetic bean unless the developer explicitly specifies it.</p>

<h3>Dependency injection</h3>

<p>Dependency injection is the process by which Spring looks up the beans that are needed for a particular bean to function and injects them as a dependency. Spring can perform dependency injection by using constructor or by using a setter method.</p>

<h3>Inversion of Control</h3>

<p>Traditionally, the class which needed the dependency created an instance of the dependency. The class decided when to create the dependency and how to create it. For example, Engine class is a dependency of Vehicle class, which creates its object:</p>

<pre>
<code>
class Vehicle{
  
    private Engine engine = new Engine();
    //...
}
</code>
</pre>

<p>Spring takes this responsibility from the class and creates the object itself. The developer simply mentions the dependency and the framework takes care of the rest.</p>

<pre>
<code>
class Vehicle{
 
    private Engine engine;
    //...
}
</code>
</pre>

<p>Thus, control moves from the component that needs the dependency to the framework. The framework takes the responsibility for finding out the dependencies of a component, ensuring their availability and injecting them in the component. This process is called Inversion of Control.</p>


<h3>IoC container</h3>

<p>An IoC container is a framework that provides the Inversion of Control functionality.

The IoC container manages the beans. For the above mentioned example, it creates an instance of the Engine class, then creates an instance of Vehicle class, and then injects the Engine object as a dependency into the Vehicle object.</p>

<pre>
<code>
class Vehicle {
    private Engine engine;
    //...   
}
</code>
</pre>

<p>IoC container is a generic term. It is not framework specific. Spring offers two implementations of the IoC container:

Bean factory
Application context
</p>

<h3>Implementations of IoC</h3>

<p>Both of them are interfaces that have different implementations available. Application context is the typical IoC container in the context of Spring. Spring recommends using it unless there is a memory concern, like in a mobile device. If available memory is low, bean factory should be used.</p>

<h3>Bean factory</h3>

<p>The basic version of the Spring IoC container is bean factory. It is the legacy IoC container and provides basic management for beans and wiring of dependencies. In Spring, bean factory still exists to provide backward compatibility.</p>

<h3>Application context</h3>

<p>Application context adds more features to the bean factory that are typically needed by an enterprise application. It is the most important part of the Spring framework. All the core logic of Spring happens here. It includes basic management of beans and wiring of dependencies as provided by the bean factory. Additional features in application context include Spring AOP features, internationalization, web application context, etc.</p>