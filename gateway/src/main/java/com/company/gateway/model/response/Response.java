package com.company.gateway.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Response<T>{
    private T data;
    private long dataAmount;
    private String error;

    public Response(T data){
        this.data = data;
    }

    public Response(T data, String error) {
        this.error = error;
        this.data = data;
    }

    public Response(T data, long dataAmount){
        this.data = data;
        this.dataAmount = dataAmount;
    }
}