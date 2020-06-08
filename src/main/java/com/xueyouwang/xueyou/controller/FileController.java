package com.xueyouwang.xueyou.controller;

import com.xueyouwang.xueyou.service.FileService;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    /**
     * 上传资源文件接口
     * @param file
     * @param request
     * @return
     */
    @RequestMapping(value="/uploadSource" , method = RequestMethod.POST)
    @ResponseBody
    public Result uploadSource(@RequestParam("file") MultipartFile file , HttpServletRequest request) {
        return fileService.uploadFile(file, request);
    }

    /**
     * 资源文件下载接口
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/download")
    public Result downloadFile(HttpServletRequest request, HttpServletResponse response) {
        return fileService.downloadFile(request, response);
    }

    /**
     * 查询所有文件资源列表
     * @return
     */
    @RequestMapping(value="/queryFiles" , method = RequestMethod.GET)
    @ResponseBody
    public Result queryFiles(){
        return fileService.queryFiles();
    }

}
