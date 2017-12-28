package SYFX;

import org.dom4j.Document;
import org.dom4j.DocumentException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 对实验分析系统的测试
 */
public class Test {
    public static void main(String[] args) throws IOException, DocumentException, ClassNotFoundException {
        FXXTAnalysis fxxtAnalysis =new FXXTAnalysis();
        Document document=fxxtAnalysis.getDocument("Test.xml");
        List list=fxxtAnalysis.getListElement(document);
        HashMap<String,String> hashMap=fxxtAnalysis.getQueryandType(list);

        ArrayList nodelist=fxxtAnalysis.getNodeList(list);
        for (int i=0;i<nodelist.size();i++){
            System.out.println(nodelist.get(i));
        }
        ArrayList linklist=fxxtAnalysis.getLinkList(list);
        ArrayList iplist=fxxtAnalysis.getIPList(list);

        FXXT fxxt=new FXXT();

        fxxt.creatZyxyxml(nodelist,linklist,iplist);
        fxxt.creatTpxy(nodelist,linklist);
        System.out.println("单身狗没有平安夜，也没有圣诞！");
        System.out.println(" xml file creat completed!!!");
    }
}
