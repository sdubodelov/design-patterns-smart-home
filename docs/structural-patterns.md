## Structural patterns

### Adapter
**Adapter** is a structural design pattern that allows objects with incompatible interfaces to collaborate.

![adapter-structure](assets/structural/adapter-structure.png)

See more [Adapter...](structural/adapter.md)

### Bridge
Bridge is a structural design pattern that lets you split a large class or a set of closely related classes into two separate hierarchies—abstraction and implementation—which can be developed independently of each other.

![bridge-structure](assets/structural/bridge-structure.png)

See more [Bridge...](structural/bridge.md)

### Composite
Composite is a structural design pattern that lets you compose objects into tree structures and then work with these structures as if they were individual objects.
Using the Composite pattern makes sense only when the core model of your app can be represented as a tree.
![](assets/structural/composite-structure.png)

- Use the Composite pattern when you have to implement a tree-like object structure.
- Use the pattern when you want the client code to treat both simple and complex elements uniformly.

### Decorator
Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.
### Facade
Facade is a structural design pattern that provides a simplified interface to a library, a framework, or any other complex set of classes.

### Flyweight
Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
### Proxy
Proxy is a structural design pattern that lets you provide a substitute or placeholder for another object. A proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object.