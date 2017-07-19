### java常量：
* public static final Integer ADV_STATUS_START = 1;
    默认情况下，定义的常量是在对象创建时被初始化，如果在建立常量时，直接赋一个固定的值，那么这个常量的值就是恒定不变的。
* public final Double ADV_STATUS_TEST =Math.random();
     默认情况下，定义的常量是在对象创建时被初始化，如果在建立常量时，是通过其他对象或函数来赋值（如随机数Random对象），那么每次建立对象是其给常量的初始化值可能不同
* static:告诉编译器，在代码装载时候就初始化常量的值，后续创建对象的时候，只引用常量对象的地址，而不对其再进行初始化
