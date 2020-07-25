package com.travanleo.comment;

public class CommonResponse<T> {
    public static final String SUCCESS = "success";
    public static final String FAILED = "failed";

    public static final int SUCCESS_CODE = 200;
    public static final int FAILURE_CODE = 500;

    private int responseCode;
    private String responseMessage;
private T data;

    public CommonResponse(int responseCode, String responseMessage, T data) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.data = data;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

}
