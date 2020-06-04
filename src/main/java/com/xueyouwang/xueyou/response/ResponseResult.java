package com.xueyouwang.xueyou.response;

import com.xueyouwang.xueyou.utlis.Result;
import com.xueyouwang.xueyou.utlis.ResultCode;

/**
 * @author wangkui
 */
public class ResponseResult {

    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功！";
    private static final String DEFAULT_SUCCESS_DELETE_MESSAGE = "删除成功";
    private static final String DEFAULT_SUCCESS_UPDATE_MESSAGE = "修改成功";
    private static final String DEFAULT_FAIL_DELETE_MESSAGE = "删除失败";
    private static final String DEFAULT_FAIL_UPDATE_MESSAGE = "修改失败";

    public static Result genSuccessResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }
    public static Result genSuccessResult(String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message);
    }

    public static Result genSuccessResult(Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }
    public static Result genSuccessResult(String message,Object data) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }
    public static Result genFailResult(String message) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(message);
    }
    public static Result genFailResult(Object data) {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setData(data);
    }
    public static Result genFailResult(String message, ResultCode resultCode) {
        return new Result()
                .setCode(resultCode)
                .setMessage(message);
    }

    public static Result genNotLogin() {
        return new Result()
                .setCode(ResultCode.UNAUTHORIZED)
                .setMessage("用户未登录！");
    }

    public static Result genPermissions() {
        return new Result()
                .setCode(ResultCode.PERMISSIONS)
                .setMessage("用户权限不足！");
    }

    public static Result genPermissions(String message) {
        return new Result()
                .setCode(ResultCode.PERMISSIONS)
                .setMessage(message);
    }

    public static Result genFailDeleteResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_FAIL_DELETE_MESSAGE);
    }

    public static Result genFailUpdateResult() {
        return new Result()
                .setCode(ResultCode.FAIL)
                .setMessage(DEFAULT_FAIL_UPDATE_MESSAGE);
    }

    public static Result genSuccessDeleteResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_DELETE_MESSAGE);
    }

    public static Result genSuccessUpdateResult() {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_UPDATE_MESSAGE);
    }

    public static Result genSuccessResult(Object data, String message) {
        return new Result()
                .setCode(ResultCode.SUCCESS)
                .setMessage(message)
                .setData(data);
    }

    public static Result genFailLinkResult() {
        return new Result()
                .setCode(ResultCode.LINK_NOT_FOUND)
                .setMessage("链接不存在");
    }

    public static Result genInsufficientInventory(Object data) {
        return new Result()
                .setCode(ResultCode.INSUFFICIENT_INVENTORY)
                .setMessage("库存不足")
                .setData(data);
    }

    public static Result genSoldOut() {
        return new Result()
                .setCode(ResultCode.SOLD_OUT)
                .setMessage("已售完");
    }

    public static Result genShelves() {
        return new Result()
                .setCode(ResultCode.SHELVES)
                .setMessage("已下架");
    }

    public static Result genOrderGoodsFail(Object data) {
        return new Result()
                .setCode(ResultCode.ORDERGOODSFAIL)
                .setMessage("商品已删除或库存不足")
                .setData(data);
    }
}
