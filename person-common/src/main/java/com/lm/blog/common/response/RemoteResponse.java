package com.lm.blog.common.response;
import java.io.Serializable;

/**
 * @Author Administrator
 * @Description 统一响应
 * @Date 2023/1/20
 */

public class RemoteResponse<T> implements Serializable {

    /**
     * 序列化uid
     */
    private static final long serialVersionUID = 586262417756505439L;

    /**
     * 成功状态码
     */
    public static final int SUCCESS = 200;

    /**
     * 服务端内部异常状态码
     */
    public static final int FAILURE = 500;

    /**
     * 非法参数
     */
    public static final int ILLEGAL_PARAMETER = 501;

    /**
     * 客户端请求有语法错误，不能被服务器所理解
     */
    public static final int EXCEPTION = 400;

    /**
     * 未授权
     */
    public static final int UNAUTHORIZED = 401;

    /**
     * request id
     */
    private Long queryId;

    /**
     * 总数量
     */
    private long total;

    /**
     * 返回值状态码
     * {@link RemoteResponse#SUCCESS}
     * {@link RemoteResponse#FAILURE}
     * {@link RemoteResponse#EXCEPTION}
     * {@link RemoteResponse#ILLEGAL_PARAMETER}
     * {@link RemoteResponse#UNAUTHORIZED}
     */
    private int code;

    /**
     * 返回结果描述信息
     */
    private String msg;

    /**
     * 返回结果数据
     */
    private T data;

    /**
     * 是否存在下一页
     */
    private boolean hasNext;

    public RemoteResponse() {
        //
    }

    public RemoteResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> RemoteResponse<T> custom() {
        return new RemoteResponse<>();
    }

    public int getCode() {
        return this.code;
    }

    public RemoteResponse<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public RemoteResponse<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public RemoteResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public RemoteResponse<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public boolean isSuccess() {
        return this.code == SUCCESS;
    }

    public RemoteResponse<T> setSuccess() {
        code = SUCCESS;
        this.msg = "success";
        return this;
    }

    public RemoteResponse<T> setFailure(final String msg) {
        code = FAILURE;
        this.msg = msg;
        return this;
    }

    public RemoteResponse<T> setException(final String msg) {
        code = EXCEPTION;
        this.msg = msg;
        return this;
    }

    public RemoteResponse<T> setIllegalParameter(final String msg) {
        code = ILLEGAL_PARAMETER;
        this.msg = msg;
        return this;
    }

    public Long getQueryId() {
        return queryId;
    }

    public RemoteResponse<T> setQueryId(Long queryId) {
        this.queryId = queryId;
        return this;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public RemoteResponse<T> setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }

    public RemoteResponse<T> build() {
        return this;
    }

    public RemoteResponse<T> failure(String msg) {
        this.code = FAILURE;
        this.msg = msg;
        return this;
    }

    public RemoteResponse<T> failure() {
        this.code = FAILURE;
        this.msg = "server error";
        return this;
    }

    public static RemoteResponse<Boolean> success() {
        final RemoteResponse response =
                RemoteResponse
                        .<Boolean>custom()
                        .setSuccess()
                        .setData(Boolean.TRUE);
        return response;
    }

    public static <T> RemoteResponse<T> success(T data) {
        final RemoteResponse<T> response =
                RemoteResponse
                        .<T>custom()
                        .setSuccess()
                        .setData(data);
        return response;
    }

    @Override
    public String toString() {
        return "RemoteResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
