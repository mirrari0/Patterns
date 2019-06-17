# Why use an Abstract Factory Pattern?

A reason you may select this pattern is if you have clusters of dependant objects that change instances based on the initial object. This allows the user to only need to know about the initial objects and all the subsequent/related objects are dropped into place automagically. 
 
An example of this is if you are attempting to create an Operating System agnostic program, you could hide any OS specific things inside of the factory. This saves the user from having to care about what OS they are on and makes the flow of the program easier to grok by removing extra if/else statements in core logic. 