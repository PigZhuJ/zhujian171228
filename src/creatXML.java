import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


/**
 * 创建xml文件
 */
public class creatXML {
    public static void main(String[] args) throws IOException {


        Element root = DocumentHelper.createElement("Records");//record
        Document document = DocumentHelper.createDocument(root);//创建根节点文件


        //把生成的xml文档存放在硬盘上  true代表是否换行
        OutputFormat format = new OutputFormat("    ",true);
        format.setEncoding("UTF-8");//设置编码格式
        XMLWriter xmlWriter = null;
            xmlWriter = new XMLWriter(new FileOutputStream("SendFileArea4.xml"),format);
        xmlWriter.write(document);
        xmlWriter.close();
    }

}