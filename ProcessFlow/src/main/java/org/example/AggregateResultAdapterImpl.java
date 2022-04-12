package org.example;

public class AggregateResultAdapterImpl implements AggregateResultAdapter {

    @Override
    public String count(String dataForCount) {
        String[] separated = splitByComma(dataForCount);
        double sum = 0, avg = 0;
        int counter=0;
        for (String data:separated) {
            counter++;
            if(counter%2==0) {
                sum = sum + Double.parseDouble(data);
            }
        }

        avg = sum/(counter/2);

        for(int i=0; i<separated.length;i++){
            if(i%2!=0){
                separated[i] = String.valueOf(avg);
            }
        }

        return makeOneString(separated);
    }

    private String makeOneString(String[] separated){
        String concated="";

        for(int i=0; i<separated.length;i++){
            if(i%2==0){
                concated = concated + separated[i]+";";
            }else{
                concated = concated + separated[i]+"\n";
            }
        }
        return concated;
    }

    private String[] splitByComma(String pair){
        String delimiter1 = "\n";
        String delimiter2 = ";";
        pair = pair.replaceAll(delimiter2,delimiter1);
        String[] separated = pair.split(delimiter1);
        return separated;
    }
}
