package com.xueyouwang.xueyou.service;

import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {

    //上传资源文件
    Result uploadFile(MultipartFile file , HttpServletRequest request);

    //下载资源文件
    Result downloadFile(HttpServletRequest request, HttpServletResponse response);

    //查询所有文件资源列表
    Result queryFiles();

}
