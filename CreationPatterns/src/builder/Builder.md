# Why use the Builder creation pattern?

This pattern is useful when most of the time there is a known default value for each option in an object, but each option should be configurable as well. Frequently these can be found around network call protocol objects. Using this pattern you can protect the constructor from external use but forcing users to go through the builder. 

Another use for this is you can create test object builders that default all of the fields and it becomes clear in the context of the test exactly what you are altering from the default for the purposes of this test. 

Note: with Kotlin's ability to default values and name variables in constructors makes this one _less_ useful in this context

The partner example is one that creates a burger with known default values. One of the interesting things with this pattern in Kotlin is you could set the value to nullable (with no default) in the builder constructor, and set the field as not nullable in the burger object. Then the build would have to check the values are not null or catch an NPE and display a message that indicates what fields are required. For instance: if you were doing something with Passwords. 