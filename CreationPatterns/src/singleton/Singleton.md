# What is Singleton

Singleton does exactly what it sounds like, it creates allows the creation of one and only one instance of an object. 

This is useful if you have a thing that you want to be accessible and the same across the application. The most common example is logging... Generally the goal is to capture all of the output from a process into a file, so you will create a logger instance that dumps into that one place. Then infinity copies of a process could kick off but they all log to one central location. 

