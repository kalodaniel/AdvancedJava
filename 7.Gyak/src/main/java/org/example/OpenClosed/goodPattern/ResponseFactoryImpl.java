package org.example.OpenClosed.goodPattern;

public class ResponseFactoryImpl implements ResponseFactory {
    @Override
    public ValueProvider get(int value) {
        ValueProvider vp;

            if(value < 50){
                vp = new Minus2Response();
            }else{
                vp = new Minus1Response();
            }
        return vp;
    }
}
