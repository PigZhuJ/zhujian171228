package SYFX;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 解析xml文件
 */
public class FXXTAnalysis {

    ArrayList<String> NodeList = new ArrayList();//获取节点 ArrayList
    ArrayList<String> LinkList = new ArrayList();//获取链路 ArrayList
    ArrayList IPList = new ArrayList();//获取ip ArrayList

    /**
     * 1.生成Doucument 对象 方法
     */
    public Document getDocument(String url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    /**
     * 2.获取根节点的方法
     */
    public List<Element> getListElement(Document document) throws DocumentException {
        Element root = document.getRootElement();//获取根节点元素对象
        List<Element> listElement = root.elements();//获取
        return listElement;
    }

    /**
     * 3.get QueryType 和 NetID 的方法
     */
    public HashMap<String,String> getQueryandType(List<Element> listElement) throws DocumentException {
        HashMap<String, String> hashMap=new HashMap<>();
        List<Attribute> attribute=listElement.get(0).attributes();
        for (int i=0;i<attribute.size();i++){
            hashMap.put(attribute.get(i).getName(),attribute.get(i).getValue());
        }
        return hashMap;//返回HashMap的值
    }
    /**
     * 4.通过解析获得节点Node的ArrayList<>
     */
    public ArrayList getNodeList(List<Element> listElement) throws DocumentException {
        List<Element> nodeList = listElement.get(1).elements();//获取Nodes节点底下的所有子节点
        for (int i = 0; i < nodeList.size(); i++) {
            Attribute attribute = nodeList.get(i).attribute("ID");
            NodeList.add(attribute.getValue());//获取节点值
        }
        return NodeList;
    }

    /**
     * 5.通过解析获得节点Link的ArrayList<>
     */
    public ArrayList getLinkList(List<Element> listElement) throws DocumentException {
        List<Element> linkList = listElement.get(2).elements();//获取LInks节点底下的所有子节点
        for (int i = 0; i < linkList.size(); i++) {
            Attribute attribute = linkList.get(i).attribute("ID");
            LinkList.add(attribute.getValue());//获取节点值
        }
        return LinkList;
    }

    /**
     * 6.通过解析获得节点Link的ArrayList<>
     */
    public ArrayList getIPList(List<Element> listElement) throws DocumentException {
        List<Element> ipList = listElement.get(3).elements();//获取IPs节点底下的所有子节点
        for (int i = 0; i < ipList.size(); i++) {
            Attribute attribute = ipList.get(i).attribute("ID");
            IPList.add(attribute.getValue());//获取节点值
        }
        return IPList;
    }
}
