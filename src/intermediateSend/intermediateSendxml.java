package intermediateSend;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 创建intermediateSend.xml
 */
public class intermediateSendxml {
    public static void main(String[] args) throws IOException {


        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("Records");//获取根节点
        Element table = root.addElement("Table").addAttribute("Name", "GLW_PERF_MIDL");

        OutputFormat outputFormat = OutputFormat.createPrettyPrint();
        outputFormat.setEncoding("utf8");
        outputFormat.setNewlines(true);
        XMLWriter xmlWriter=new XMLWriter(new FileWriter("intermediateSend.xml" ),outputFormat);
        xmlWriter.write(document);
        xmlWriter.close();
    }
}
