/**hashtable与hashmap的区别*/
//首先从三个方面入手：线程安全、同步（synchronized）、速度
//hashmap是非synchronized(线程不安全的，多个线程不能共享hashmap),key、value可以为null;
  public int size() {
        return size;
    }
//hastable是synchronized（线程安全的，多个线程可以可以共享一个hashtable),key、value不可以为null
//在多线程环境且未作同步的情况下，对同一个HashMap做put操作可能导致两个或以上线程同时做rehash动作，就可能导致循环键表出现一旦出现现场等将无法终止持续占用CPU，导致CPU使用率居高不下
  public synchronized int size() {
        return count;
    }

*多线程的应用不是为了提高运行效率，而是为了提高资源使用效率
/**多线程——(只针对单CPU):线程切换是需要时间消耗的，所以采用一个拥有两个线程的进程执行所需要的时间比一个线程的进程执行两次所需要的时间要多一些。
即采用多线程不会提高程序的执行速度，反而会降低速度，但是对于用户来说，可以减少用户的响应时间*/

//关于java启动：
1:main函数—— main 方法是一个起点，从main方法这里开始一行一行执行
2:web项目是由容器启动的，也就是服务器,Tomcat之类。


//关于servlet:
1:servlet 全称javaServlet，使用java编写的服务器端程序。
主要功能在于交互式地浏览和修改数据，生成动态web内容，servlet 可以响应任何类型的请求，但绝大多数情况下servlet只用来扩展基于http协议的web服务器。



google查看缓存文件：
//chrome://version/
//chrome://cache/


//Java web项目listener Filter servlet启动顺序和配置


//队列

//mysql数据库优化：索引、缓存、


//mysql性能测试


//配置防火墙的好处？

//数据库连接池


//项目之间通信
