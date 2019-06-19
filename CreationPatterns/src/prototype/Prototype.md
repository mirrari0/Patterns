# What is Prototype?

Prototype is when you have a fixed, basic object that you clone instead of 'creating' a new object. When objects get large enough that instantiation takes real time compared to copying, cloning becomes a better solution. 

So in this case, we create one instance of the object, and have some fixed variations that are available between a Leopard and a Jaguar. We opted to make the member variables private, but in theory you could hold a base version of a thing and when you need a new one you would clone it and then could modify any part of the cloned object to meet your needs. 