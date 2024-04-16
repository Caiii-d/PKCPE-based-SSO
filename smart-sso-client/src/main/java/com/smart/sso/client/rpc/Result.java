package com.smart.sso.client.rpc;

import java.beans.Transient;
import java.io.Serializable;

/**
 * 返回结果
 */
public class Result<T> implements Serializable {
    
    private static final long serialVersionUID = 1956544564021082972L;
    
    public static final int SUCCESS_CODE = 1;// 成功
    
    public static final int ERROR_CODE = 9999;// 未知错误

    /** 成功 */
    @SuppressWarnings("rawtypes")
    public static final Result SUCCESS = createSuccess();

	/**
	 * 结果体
	 */
	protected T data;

	/**
	 * 状态码
	 */
	protected int code;

	/**
	 * 信息
	 */
	protected String message;

	private Result() {
		super();
	}
	
    /**
     * 创建一个Result对象
     * @return Result对象
     */
    public static <T> Result<T> create() {
        return new Result<>();
    }

    /**
     * 创建一个Result对象，并设置code
     * @param code 状态码
     * @return Result对象
     */
    public static <T> Result<T> create(int code) {
        Result<T> r = create();
        r.setCode(code);
        return r;
    }
    
    /**
     * 创建一个Result对象，并设置code和message
     * @param code 状态码
     * @param message 消息
     * @return Result对象
     */
    public static <T> Result<T> create(int code, String message) {
        Result<T> r = create(code);
        r.setMessage(message);
        return r;
    }
    
    /**
     * 创建一个Result对象，并设置code和message
     * @return Result对象
     */
    @SuppressWarnings("unchecked")
	public static final <T> Result<T> success() {
		return SUCCESS;
	}

	/**
	 * 创建一个Result对象，并设置code
	 * @return Result对象
	 */
	public static <T> Result<T> createSuccess() {
		return create(SUCCESS_CODE);
	}
	
	/**
	 * 创建一个Result对象，并设置code和data
	 * @param data 数据
	 * @return Result对象
	 */
	public static <T> Result<T> createSuccess(T data) {
		Result<T> r = createSuccess();
		r.setData(data);
        return r;
	}

	/**
	 * 创建一个Result对象，并设置code、data和message
	 * @param data 数据
	 * @param message 消息
	 * @return Result对象
	 */
	public static <T> Result<T> createSuccess(T data, String message) {
		Result<T> r = createSuccess(data);
		r.setMessage(message);
        return r;
	}
	
	/**
	 * 创建一个Result对象，并设置code和message
	 * @param message 消息
	 * @return Result对象
	 */
	public static <T> Result<T> createError(String message) {
        return create(ERROR_CODE, message);
    }
	
	/**
	 * 获取data
	 * @return data
	 */
	public T getData() {
		return data;
	}

	/**
	 * 设置data
	 * @param data data
	 * @return Result对象
	 */
	public Result<T> setData(T data) {
		this.data = data;
		return this;
	}

	/**
	 * 获取code
	 * @return code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * 设置code
	 * @param code code
	 * @return Result对象
	 */
	public Result<T> setCode(int code) {
		this.code = code;
		return this;
	}

	/**
	 * 获取message
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * 设置message
	 * @param message message
	 * @return Result对象
	 */
	public Result<T> setMessage(String message) {
		this.message = message;
		return this;
	}
	
	/**
	 * 判断是否成功
	 * @return 是否成功
	 */
	@Transient
    public boolean isSuccess() {
        return SUCCESS_CODE == code;
    }
}
