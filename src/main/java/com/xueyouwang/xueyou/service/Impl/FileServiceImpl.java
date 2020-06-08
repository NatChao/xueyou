package com.xueyouwang.xueyou.service.Impl;

import com.xueyouwang.xueyou.dao.FileDao;
import com.xueyouwang.xueyou.entity.FilePath;
import com.xueyouwang.xueyou.response.ResponseResult;
import com.xueyouwang.xueyou.service.FileService;
import com.xueyouwang.xueyou.utlis.FileUtil;
import com.xueyouwang.xueyou.utlis.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public Result uploadFile(MultipartFile file, HttpServletRequest request) {
        String pathString = null;
        if(file!=null) {
            pathString = "D:/image/" +file.getOriginalFilename();
            FilePath filePath = new FilePath();

            filePath.setFileName(file.getOriginalFilename());
            filePath.setPath("D:/image/"+file.getOriginalFilename());
            filePath.setCreateTime(LocalDateTime.now());
            filePath.setDowncounts(0);
            //filePath.setId(2);让数据库id自增或使用唯一标识赋值
            filePath.setType("文学");
            fileDao.addFile(filePath);
        }

        try {
            File files=new File(pathString);
            //打印查看上传路径
            System.out.println(pathString);
            if(!files.getParentFile().exists()){
                files.getParentFile().mkdirs();
            }
            file.transferTo(files);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Map<String, Object> reMap = new HashMap<>();
        reMap.put("pathString", pathString);
        return ResponseResult.genSuccessResult(reMap, "上传成功");
    }

    @Override
    public Result downloadFile(HttpServletRequest request, HttpServletResponse response) {
        String fileName = null;// 设置文件名，根据业务需要替换成要下载的文件名
        fileName = request.getParameter("Filename");
        try {
            fileName = URLDecoder.decode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(fileName);
        if (fileName != null) {
            //设置文件路径
            String realPath = "D:/image";
            File file = new File(realPath , fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                    return ResponseResult.genSuccessResult();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return ResponseResult.genFailResult("资源文件名称不存在");
    }

    @Override
    public Result queryFiles() {
        List<FilePath> fileList = fileDao.queryFiles();
        for (FilePath filePath : fileList) {
            System.out.println(filePath.getFileName());
        }
        FileUtil fileUtil = new FileUtil();
        fileUtil.setData(fileList);
        return ResponseResult.genSuccessResult(fileUtil);
    }

}
