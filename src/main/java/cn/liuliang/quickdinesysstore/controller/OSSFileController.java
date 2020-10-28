package cn.liuliang.quickdinesysstore.controller;

import cn.liuliang.quickdinesysstore.base.result.ResultDTO;
import cn.liuliang.quickdinesysstore.service.OSSFileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Package： cn.liuliang.quickdinesysstore.controller
 * @Author： liuliang
 * @CreateTime： 2020/10/26 - 9:11
 * @Description：
 */
@Api(value = "OSS文件上传管理", tags = "OSS文件上传管理")
@CrossOrigin
@RestController
@RequestMapping("/oss/file")
public class OSSFileController {

    @Autowired
    private OSSFileService ossFileService;


    @ApiOperation(value = "文件上传" , notes = "文件上传，传入模块名称是区分图片秀还是菜品等图片")
    @PostMapping("/upload")
    public ResultDTO upload(
            @ApiParam(value = "文件对象", required = true) @RequestParam("file") MultipartFile file,
            @ApiParam(value = "文件上传的模块名称（目录名称）", required = true) @RequestParam("module") String module) {
        String uploadUrl = "";
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        uploadUrl = ossFileService.upload(inputStream, module, file.getOriginalFilename());
        return ResultDTO.success().message("上传成功！").data("url", uploadUrl);
    }

    @ApiOperation(value = "文件删除" , notes = "根据传入的图片url进行删除")
    @GetMapping("/remove")
    public ResultDTO removeFile(
            @ApiParam(value = "要删除的文件路径", required = true) @RequestParam String url) {
        ossFileService.removeFile(url);
        return ResultDTO.success().message("文件刪除成功");
    }


}
