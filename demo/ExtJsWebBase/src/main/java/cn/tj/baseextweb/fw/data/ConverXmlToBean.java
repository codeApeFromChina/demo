package cn.tj.baseextweb.fw.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConverXmlToBean {

    public List<DbTable> exec(String xmlpath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {

        List<DbTable> ret = new ArrayList<DbTable>();

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = builder.parse(new File(xmlpath));

        XPath xpath = XPathFactory.newInstance().newXPath();

        XPathExpression expr = xpath.compile("//db-data");
        Node dbdata = (Node) expr.evaluate(document, XPathConstants.NODE);

        NodeList nodes = dbdata.getChildNodes();

        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            if (node.getNodeType() == 1) {
                DbTable table = new DbTable();
                table.setTableName(node.getNodeName());

                List<DbField> fields = new ArrayList<DbField>();
                NamedNodeMap attributes = node.getAttributes();
                for (int j = 0; j < attributes.getLength(); j++) {
                    DbField field = new DbField();
                    field.setFieldName(attributes.item(j).getNodeName());
                    field.setFieldValue(attributes.item(j).getNodeValue());
                    fields.add(field);
                }
                table.setFields(fields);

                ret.add(table);
            }
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {

        ConverXmlToBean rdfxtb = new ConverXmlToBean();

        List<DbTable> tables = rdfxtb.exec("D:\\codedev\\workspace\\BaseExtWeb\\data\\user_data.xml");

        for (DbTable table : tables) {
            System.out.println("table name: " + table.getTableName());
            for (DbField field : table.getFields()) {
                System.out.println("       + " + field.getFieldName() + ": " + field.getFieldValue());
            }
        }

    }
}
