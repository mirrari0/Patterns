# Why use an Abstract Factory Pattern?

This is a scenario where the factory you maybe using, and all of the related classes and objects, could change but have fixed relationships.

SO in this example we are really after creating and manipulating a cook object. Each cook though maybe associated with many other objects, such as a restaurant type which has different things in it. The attached example doesn't do a great job of demoing this... but a hotdog stand has very different available equipment and information than a cheesecake factory even though they are both different types of 'restaurants'.

So in this case, the pizza factory could also create/return a Pizzaria restaurant object with a Pizza Oven and salad bar, while the burger factory would return a griddle, ice cream machine, and a fryer. 