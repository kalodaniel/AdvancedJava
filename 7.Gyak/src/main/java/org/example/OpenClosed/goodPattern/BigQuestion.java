package org.example.OpenClosed.goodPattern;

public class BigQuestion {
    ResponseFactory responseFactory;

    public BigQuestion(ResponseFactory responseFactory){
        this.responseFactory = responseFactory;
    }

    public int get(int value) {
        return responseFactory.get(value).get(value);
    }
}
