package com.xueyouwang.xueyou.dao;

import com.xueyouwang.xueyou.entity.FilePath;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName: FileDao
 * Package: com.xueyouwang.xueyou.dao
 * Description:
 *
 * @Date: 2020/6/7 13:29
 * @Author:zpc@qq.com
 */
@Repository
@Mapper
public interface FileDao {

    //插询所有文件资源
    List<FilePath> queryFiles();

    //根据id插询资源文件
    FilePath queryFileById(@Param("id") Integer id);

    //新增文件资源
    int addFile(FilePath filePath);
}
