package com.company.food_online_service.util;

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

    public Response(String error) {
        this.error = error;
    }

    public Response(T data, long dataAmount){
        this.data = data;
        this.dataAmount = dataAmount;
    }
}