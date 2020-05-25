package com.xueyouwang.xueyou.entity;

public enum  ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    LINK_NOT_FOUND(403),//链接不存在
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误
    PERMISSIONS(406),//权限不足
    REQUEST_ERROR(405),//请求错误(用在机构邀请艺术家错误返回)
    INSUFFICIENT_INVENTORY(407),//库存不足
    SOLD_OUT(408),//已售完
    SHELVES(409),//已下架
    ORDERGOODSFAIL(410);//订单商品已删除或库存不足

    public int code;

    ResultCode(int code) {
        this.code = code;
    }
}
