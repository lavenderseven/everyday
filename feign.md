###  spring feign
* feign是一个声明式web service客户端，spring cloud对feign进行了封装，支持了spring mvc标准注解和httpmessageconverters
* Decoder：解码器，将HTTP响应数据反序列化为java对象是由解码器(Decoder)完成的。
* Encoder:编码器，将方法签名中方法参数对象序列化为请求参数放到HTTP请求中的过程，是由编码器(Encoder)完成的。
* 默认使用jdk原生URLConnection发送请求，没有连接池，