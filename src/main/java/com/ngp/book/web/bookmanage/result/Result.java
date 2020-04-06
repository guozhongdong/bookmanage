package com.ngp.book.web.bookmanage.result;

/**
 * @author gzd
 * @date 2020/4/6 下午12:51
 */
public class Result<T> {

    private boolean success;
    private String message;
    private T result;
    private String errorCode;
    private long total;

    public Result()
    {

        this.success = true;
    }

    public Result(boolean success, String message)
    {
        this.success = success;
        this.message = message;
    }

    public Result(T result){
        this.success = true;
        this.result = result;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public void setError(String errorCode, String message) {
        setSuccess(false);
        this.errorCode = errorCode;
        setMessage(message);
    }
    @Override
    public String toString()
    {
        return "Result [success=" + this.success + ", message=" + this.message + "]";
    }
}
