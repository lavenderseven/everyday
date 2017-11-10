当try-with-resources结构中抛出一个异常，同时FileInputStreami被关闭时（调用了其close方法）也抛出一个异常，try-with-resources结构中抛出的异常会向外传播，而FileInputStreami被关闭时抛出的异常被抑制了。这与文章开始处利用旧风格代码的例子（在finally语句块中关闭资源）相反。

可以在块中使用多个资源而且这些资源都能被自动地关闭。下面是例子：

private static void printFileJava7() throws IOException {
    try(  FileInputStream     input         = new FileInputStream("file.txt");
          BufferedInputStream bufferedInput = new BufferedInputStream(input)

    ) {
        int data = bufferedInput.read();
            System.out.print((char) data);

    		data = bufferedInput.read();
        }

    }

}
上面的例子在try关键字后的括号里创建了两个资源——FileInputStream 和BufferedInputStream。
当程序运行离开try语句块时，这两个资源都会被自动关闭。
这些资源将按照他们被创建顺序的逆序来关闭。首先BufferedInputStream 会被关闭，然后FileInputStream会被关闭。

