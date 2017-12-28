package SYFX;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 试验分析系统创建xml表格的
 */
public class FXXT {
    /**
     * 资源响应的xml表格生成方法
     */

         ParseTest320xml p=new ParseTest320xml();


     public void creatZyxyxml(ArrayList Node,ArrayList Link,ArrayList IPID) throws IOException, DocumentException {
         Document document=DocumentHelper.createDocument();
         Element root=document.addElement("Scenario");//添加根节点

         root.addAttribute("ID","GUID");//增加属性
         //增加Scenario的子节点
         Element element0=root.addElement("Generic");
         element0.addAttribute("QueryType","1").addAttribute("NetID","2");//增加子节点Generic的属性值
        //增加Nodes子节点
         Element element1=root.addElement("Nodes");
         element1.addAttribute("BeginIndex","0").addAttribute("EndIndex","100").addAttribute("Total","101");
         //增加Links子节点
         Element element2=root.addElement("Links");
         element2.addAttribute("BeginIndex","0").addAttribute("EndIndex","100").addAttribute("Total","101");
         //增加Links子节点
         Element element3=root.addElement("IPs");
         element3.addAttribute("BeginIndex","0").addAttribute("EndIndex","100").addAttribute("Total","101");
         /**
          * 1.根据要查询的节点数，输出打印相应的节点信息
          */
         for (int i=0;i<Node.size();i++){

             List<Element> list=p.getChildNodeList(p.getNodeElement(String.valueOf(Node.get(i))));

            Element element=element1.addElement("Node");
            element.addElement("info").addAttribute("Name","ID").addAttribute("Value","GUID");
             element.addElement("info").addAttribute("Name","Name").addAttribute("Value",p.getNodeName(list));
             element.addElement("info").addAttribute("Name","NodeType").addAttribute("Value",p.getNodeType(list));
             element.addElement("info").addAttribute("Name","NodeStatus").addAttribute("Value",p.getNodeStatus(list));
             element.addElement("info").addAttribute("Name","DeviceManufacturer").addAttribute("Value",p.getDeviceManufacturer(list));
             element.addElement("info").addAttribute("Name","Address").addAttribute("Value","所在地");
             element.addElement("info").addAttribute("Name","Longitude").addAttribute("Value","经度");
             element.addElement("info").addAttribute("Name","Latitude").addAttribute("Value","纬度");

         }
         /**
          * 2.根据要查询的链路数，输出打印响应的链路信息
          */
        for (int j=0;j<Link.size();j++){
            Element element=element2.addElement("Link");
            element.addElement("info").addAttribute("Name","ID").addAttribute("Value","GUID");
            element.addElement("info").addAttribute("Name","LinkType").addAttribute("Value","链路类型");
            element.addElement("info").addAttribute("Name","LinkStatus").addAttribute("Value","链路状态");
            element.addElement("info").addAttribute("Name","BandWidth").addAttribute("Value","带宽");
            element.addElement("info").addAttribute("Name","StartNode").addAttribute("Value","起始节点");
            element.addElement("info").addAttribute("Name","DestNode").addAttribute("Value","目的节点");
            element.addElement("info").addAttribute("Name","Comment").addAttribute("Value","备注");
        }
         /**
          * 3.根据要查询的IP数，输出打印相应的IP数
          */
        for (int k=0;k<IPID.size();k++){
            Element element=element3.addElement("IP");
            element.addElement("info").addAttribute("Name","IpAddress").addAttribute("Value","IP地址");
            element.addElement("info").addAttribute("Name","MaskLength").addAttribute("Value","掩码位数");
        }

         /**
          * 4.输出
          */
         OutputFormat outputFormat=OutputFormat.createPrettyPrint();
         outputFormat.setEncoding("utf-8");//设置按格式输出
         outputFormat.setNewlines(true);
         XMLWriter xmlWriter=new XMLWriter(new FileWriter("ziyuanxiangying.xml"),outputFormat);
         xmlWriter.write(document);//写入文件
         xmlWriter.close();//关闭
     }


    /**
     * 拓扑响应的xml表格生成方法
     */
    public void creatTpxy(ArrayList Node,ArrayList Link) throws IOException {
        Document document=DocumentHelper.createDocument();
        Element root=document.addElement("Scenario");//添加根节点

        root.addAttribute("ID","GUID");//增加属性
        //增加Scenario的子节点
        Element element0=root.addElement("Generic");
        element0.addAttribute("QueryType","2").addAttribute("NetID","2");//增加子节点Generic的属性值
        //增加Nodes子节点
        Element element1=root.addElement("Nodes");
        element1.addAttribute("BeginIndex","0").addAttribute("EndIndex","100").addAttribute("Total","101");
        //增加Links子节点
        Element element2=root.addElement("Links");
        element2.addAttribute("BeginIndex","0").addAttribute("EndIndex","100").addAttribute("Total","101");

        /**
         * 1.根据要查询的节点数，输出打印相应的节点信息
         */
        for (int i=0;i<Node.size();i++){
            Element element=element1.addElement("Node");
            element.addElement("info").addAttribute("Name","ID").addAttribute("Value","GUID");
            element.addElement("info").addAttribute("Name","Name").addAttribute("Value","名称");
            element.addElement("info").addAttribute("Name","NodeType").addAttribute("Value","节点类型");
            element.addElement("info").addAttribute("Name","NodeStatus").addAttribute("Value","节点状态");
            element.addElement("info").addAttribute("Name","ResourceID").addAttribute("Value","资源ID");
            element.addElement("info").addAttribute("Name","Comment").addAttribute("Value","备注");
        }
        /**
         * 2.根据要查询的链路数，输出打印响应的链路信息
         */
        for (int j=0;j<Link.size();j++){
            Element element=element2.addElement("Link");
            element.addElement("info").addAttribute("Name","ID").addAttribute("Value","GUID");
            element.addElement("info").addAttribute("Name","LinkType").addAttribute("Value","链路类型");
            element.addElement("info").addAttribute("Name","LinkStatus").addAttribute("Value","链路状态");
            element.addElement("info").addAttribute("Name","BusinessType").addAttribute("Value","业务类型");
            element.addElement("info").addAttribute("Name","StartNode").addAttribute("Value","起始节点");
            element.addElement("info").addAttribute("Name","DestNode").addAttribute("Value","目的节点");
            element.addElement("info").addAttribute("Name","ResourceID").addAttribute("Value","资源ID");
            element.addElement("info").addAttribute("Name","Comment").addAttribute("Value","备注");
        }
        /**
         * 3.输出
         */
        OutputFormat outputFormat=OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf-8");//设置按格式输出
        outputFormat.setNewlines(true);
        XMLWriter xmlWriter=new XMLWriter(new FileWriter("tuopuxiangying.xml"),outputFormat);
        xmlWriter.write(document);//写入文件
        xmlWriter.close();//关闭
    }
}
