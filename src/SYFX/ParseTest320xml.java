package SYFX;

import com.sun.org.apache.xalan.internal.lib.NodeInfo;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParseTest320xml {
    /**
     * 1.根据节点值获取相应的子节点
     */

    public Element getNodeElement(String nodei) throws DocumentException {
        String Nodei="Node"+nodei;//获取相应的子节点
//        System.out.println(Nodei);
        Element nodeiElement=null;

        SAXReader reader=new SAXReader();
        Document document=reader.read("test320.xml");//获取test320.xml的文件
        Element root=document.getRootElement();//获取根节点
        List<Element> elementsList=root.elements();//获取所有的子节点

//        System.out.println(elementsList.size());

        for (int i=0;i<elementsList.size();i++){
            List<Attribute> list=elementsList.get(i).attributes();

            if(list.get(0).getValue().equals(Nodei)){
                nodeiElement = elementsList.get(i);//获取指定属性值的子节点
            }
        }
        return nodeiElement;//return child node
    }

    /**
     * 获取指定根节点下的所有子节点
     */
    public List<Element> getChildNodeList(Element nodeiElement){
        List<Element> NodeiInfoList=nodeiElement.elements();//获取指定节点id为nodei节点下的所有子节点信息
        return  NodeiInfoList;//返回List
    }


    /**
     * 根据获取到的子节点进行相应的获取信息
     * 获取节点名字
     */
    public String getNodeName(List<Element> NodeiInfoList){

        String name= NodeiInfoList.get(11).element("string").getTextTrim();//获取名字
        return name;//返回名字
    }

    /**
     * 3.获取子节点类型
     */
    public String  getNodeType(List<Element> NodeiInfoList){
       String realORvirtual=NodeiInfoList.get(13).element("string").getTextTrim();
       String yesORno=NodeiInfoList.get(13).element("boolean").getTextTrim();
       if(realORvirtual.equals("realnode")&&yesORno.equals("yes")){
           return "实装节点";
       }else{
           return "虚拟节点";
       }
    }

    /**
     * 4.获取节点状态
     */
    public String getNodeStatus(List<Element> NodeiInfoList){

        String run=NodeiInfoList.get(5).element("boolean").getTextTrim();
        if(run.equals("true")){
            return "run";
        }else{
            return "stop";//@TODO 需要商量之后再确定
        }
    }

    /**
     * 5.获取设备商名字
     */
    public String getDeviceManufacturer(List<Element> NodeiInfoList){
        List<Element> manufacturerList=NodeiInfoList.get(14).elements();
        String manufacturerName=manufacturerList.get(1).getTextTrim();//获取名字
        return manufacturerName;//返回厂商的名字
    }
    /**
     * 6.获取所在地名字
     */
    public ArrayList getAddress(List<Element> NodeiInfoList){

        Element element0=NodeiInfoList.get(9).element("object");
        List<Element> list=element0.elements();
        String location1=list.get(0).getTextTrim();//获取第一个参数
        String location2=list.get(1).getTextTrim();//获取第二个参数

        ArrayList<String> locationArraylist=new ArrayList<>();
        locationArraylist.add(location1);
        locationArraylist.add(location2);//将location信息加进去
        return locationArraylist;
    }

    /**
     * 7.获取经度纬度
     */

    public HashMap<String,String> getLongandLatitude(List<Element> NodeiInfoList){
        HashMap<String,String> hashMap=new HashMap<>();
        return hashMap;
    }
    /**
     * 8.获取节点IP
     */
    public String getNodeIP(List<Element> NodeiInfoList){

        List<Element> list=NodeiInfoList.get(3).elements();
        String ip=list.get(1).getTextTrim();//获取相应的IP
        return ip;
    }

    /********************************************************************************/
    /*******************************获取链路信息**************************************/
    /********************************************************************************/

    /**
     * 1.根据节点值获取相应的子节点
     */
    public Element geLinkElement(String linkID) throws DocumentException {//Link ID需要使用Link.get(i)来代替
        Element linkElement=null;
        SAXReader reader=new SAXReader();
        Document document=reader.read("test320.xml");//获取test320.xml的文件
        Element root=document.getRootElement();//获取根节点
        List<Element> elementsList=root.elements();//获取所有的子节点

        for (int i=0;i<elementsList.size();i++){
            List<Element> childElement=elementsList.get(i).elements();//获取所有节点下的子节点
            if(childElement.get(0).getTextTrim().equals(linkID)){
                linkElement=elementsList.get(i);
            }

        }
        return linkElement;//返回链路节点
    }
    /**
     * 获取指定根节点下的所有子节点
     */
    public List<Element> getChildLinkList(Element linkeElement){
        List<Element> LinkInfoList=linkeElement.elements();//获取指定节点id为nodei节点下的所有子节点信息
        return  LinkInfoList;//返回List
    }

//    /**
//     * 1.获取指定链路类型
//     */
//    public String getLinkType(List<Element> LinkInfoList){
//
//    }
//
//    /**
//     * 2.获取指定链路状态
//     */
//    public String getLinkStatus(List<Element> LinkInfoList){
//
//    }

    /**
     * 3.获取链路带宽
     */
    public String getLinkBandWidth(List<Element> LinkInfoList){
        List<Element> element1=LinkInfoList.get(8).elements();//获取带宽所在的子节点下的所有孩子节点
        String BandWidth=element1.get(1).getTextTrim();//获取第二个孩子节点
        return BandWidth;//返回相应的值
    }
    /**
     * 3.获取链路起始节点
     */
    public String getLinkStartNode(List<Element> LinkInfoList){
        List<Element> element2=LinkInfoList.get(4).elements();//获取带宽所在的子节点下的所有孩子节点
        String StartNode=element2.get(1).getTextTrim();
        return StartNode;
    }
    /**
     * 3.获取链路目的节点
     */
    public String getLinkDestNode(List<Element> LinkInfoList){
        List<Element> element3=LinkInfoList.get(45).elements();//获取带宽所在的子节点下的所有孩子节点
        String DestNode=element3.get(1).getTextTrim();
        return DestNode;
    }



}
