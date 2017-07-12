/**上传文件*/
//html页面在不用插件的情况下必须使用form表单，
<html>
    <head>
        <title>Upload a file please</title>
    </head>
    <body>
        <h1>Please upload a file</h1>
        <form method="post" action="/form" enctype="multipart/form-data">
            <input type="text" name="name"/>
            <input type="file" name="file"/>
            <input type="submit"/>
        </form>
    </body>
</html>
//需要设置页面编码为：enctype="multipart/form-data"，文件上传是二进制形式
//Ajax不能直接传送文件
//后台接收：如果是springMVC 后台，也可以用别的插件比如apache的apache fileupload
@Controller
public class FileUploadController {

    @PostMapping("/form")
    public String handleFormUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            // store the bytes somewhere
            return "redirect:uploadSuccess";
        }

        return "redirect:uploadFailure";
    }

}//消息转换机制HttpMessageConverter



