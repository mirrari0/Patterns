# Why would you want to use a factory?

Factory Method pattern abstracts the decision-making away from the class that is using the object. 

This allows you a few advantages, one of which is that you make the decisions on how/why to implement in one location and can reuse that factory call all over the place. THEN if you need to modify that process, you have one location to update and it will be propagated through out the codebase. 

Another advantage is that you can easily test all the exposed implementations to ensure that you know exactly what is getting returned out of the factory and have test that can help define why. 

Finally, the first sentence, it hides all of the logic about who/what/when/where/how to create an instance of a thing and instead allows the end user to just get the thing with minimal inputs. 

IN my mind, this is similar in logic to why you would want to create/maintain/distribute SDK's to interface with your apis. 