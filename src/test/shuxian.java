package test;

import java.util.ArrayList;

public class shuxian {
    public static void main(String[] args) {
        ArrayList arrayList=new ArrayList();
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        arrayList.add("a");
        String hopInfo="";
        for(int i=0;i<arrayList.size();i++){
            if(i<arrayList.size()-1){
                hopInfo=hopInfo+arrayList.get(i)+"|";
            }else{
                hopInfo=hopInfo+arrayList.get(i);
            }
        }
        System.out.print(hopInfo);
    }
}
