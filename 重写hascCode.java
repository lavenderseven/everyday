.为什么要重写equals呢？因为在java的集合框架中，是通过equals来判断两个对象是否相等的
在hibernate中，经常使用set集合来保存相关对象，而set集合是不允许重复的。在向HashSet集合中添加元素时，其实只要重写equals()这一条也可以。但当hashset中元素比较多时，或者是重写的equals()方法比较复杂时，我们只用equals()方法进行比较判断，效率也会非常低，所以引入了hashCode()这个方法，只是为了提高效率，且这是非常有必要的
当equals()方法被override时，hashCode()也要被override
在每个改写了equals()方法的类中，必须要改写hashCode()方法。如果不这样做，就会违反Object.hashCode的通用约定，从而导致该类无法与所有基于hash的集合类结合在一起正常运作，这样的集合类包括HashMap、HashSet和HashTable。
没有改写hashCode()方法，从而导致两个相等的实例具有不相等的散列码