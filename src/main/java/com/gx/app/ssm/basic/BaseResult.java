package com.gx.app.ssm.basic;

import java.io.Serializable;
import java.util.Objects;

public class BaseResult<T> implements Serializable {
    private boolean success;//成功标志
    private String code;//返回码
    private String msg;//反悔码描述
    private T data;//数据

    private BaseResult() {
    }

    private BaseResult(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static BaseResult success() {
        Builder builder = new Builder();
        builder.setSuccess(true);
        builder.setCode("0000");
        builder.setMsg("common success");
        builder.setData(null);
        return builder.build();
    }

    public static BaseResult successWithMsg(String msg) {
        Objects.requireNonNull(msg, "msg is null");
        Builder builder = new Builder();
        builder.setSuccess(true);
        builder.setCode("0000");
        builder.setMsg(msg);
        builder.setData(null);
        return builder.build();
    }

    public static <T> BaseResult<T> successWithData(T data) {
        Objects.requireNonNull(data, "data is null");
        Builder builder = new Builder();
        builder.setSuccess(true);
        builder.setCode("0000");
        builder.setMsg("common success");
        builder.setData(data);
        return builder.build();
    }

    public static BaseResult error() {
        Builder builder = new Builder();
        builder.setSuccess(false);
        builder.setCode("9999");
        builder.setMsg("common error");
        builder.setData(null);
        return builder.build();
    }

    public static BaseResult errorWithCause(String cause) {
        Objects.requireNonNull(cause, "error cause is null");
        Builder builder = new Builder();
        builder.setSuccess(false);
        builder.setCode("9999");
        builder.setMsg(cause);
        builder.setData(null);
        return builder.build();
    }

    public static BaseResult errorWithCodeAndMsg(String code, String cause) {
        Objects.requireNonNull(code, "error code is null");
        Objects.requireNonNull(cause, "error cause is null");
        Builder builder = new Builder();
        builder.setSuccess(false);
        builder.setCode(code);
        builder.setMsg(cause);
        builder.setData(null);
        return builder.build();
    }

    public static class Builder<T> {
        private boolean success;
        private String code;
        private String msg;
        private T data;

        private Builder() {
        }

        public Builder setSuccess(boolean success) {
            this.success = success;
            return this;
        }

        public Builder setCode(String code) {
            this.code = code;
            return this;
        }

        public Builder setMsg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder setData(T data) {
            this.data = data;
            return this;
        }

        public BaseResult<T> build() {
            return new BaseResult<>(success, code, msg, data);
        }
    }


}
