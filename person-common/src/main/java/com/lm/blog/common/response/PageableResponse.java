package com.lm.blog.common.response;
import java.io.Serializable;

/**
 * @Author Administrator
 * @Description 分页统一响应
 * @Date 2023/1/20
 */
public class PageableResponse<T> implements Serializable {

    /**
     * 序列化uid
     */
    private static final long serialVersionUID = 586262417756505439L;

    /**
     * request id
     */
    private Long queryId;

    /**
     * 返回值状态码
     * {@link RemoteResponse#SUCCESS}
     * {@link RemoteResponse#FAILURE}
     * {@link RemoteResponse#EXCEPTION}
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
     * 总数量
     */
    private long total;

    /**
     * 每页的大小
     */
    private int pageSize;

    /**
     * 页码的偏移量
     */
    private int pageNo;

    /**
     * 是否存在下一页
     */
    private boolean hasNext;

    private PageableResponse() {
        //
    }

    public PageableResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> PageableResponse<T> custom() {
        return new PageableResponse<>();
    }

    public int getCode() {
        return this.code;
    }

    public PageableResponse<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return this.msg;
    }

    public PageableResponse<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public PageableResponse<T> setData(T data) {
        this.data = data;
        return this;
    }

    public long getTotal() {
        return total;
    }

    public PageableResponse<T> setTotal(long total) {
        this.total = total;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageableResponse<T> setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getPageNo() {
        return pageNo;
    }

    public PageableResponse<T> setPageNo(int pageNo) {
        this.pageNo = pageNo;
        return this;
    }

    public boolean isSuccess() {
        return this.code == RemoteResponse.SUCCESS;
    }

    public PageableResponse<T> setSuccess() {
        code = RemoteResponse.SUCCESS;
        return this;
    }

    public PageableResponse<T> setFailure(final String msg) {
        code = RemoteResponse.FAILURE;
        this.msg = msg;
        return this;
    }

    public PageableResponse<T> setException(final String msg) {
        code = RemoteResponse.EXCEPTION;
        this.msg = msg;
        return this;
    }

    public Long getQueryId() {
        return queryId;
    }

    public PageableResponse<T> setQueryId(Long queryId) {
        this.queryId = queryId;
        return this;
    }

    public boolean getHasNext() {
        return hasNext;
    }

    public PageableResponse<T> setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
        return this;
    }

    public PageableResponse<T> failure(String msg) {
        this.code = RemoteResponse.FAILURE;
        this.msg = msg;
        return this;
    }

    public PageableResponse<T> failure() {
        this.code = RemoteResponse.FAILURE;
        this.msg = "server error";
        return this;
    }

    public PageableResponse<T> build() {
        return this;
    }

    public RemoteResponse<T> toRemoteResponse() {
        return RemoteResponse.<T>custom()
                .setTotal(total)
                .setData(data)
                .setCode(code)
                .setMsg(msg)
                .setQueryId(queryId)
                .build();
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

