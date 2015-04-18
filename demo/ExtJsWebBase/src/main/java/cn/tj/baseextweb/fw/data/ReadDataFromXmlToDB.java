package cn.tj.baseextweb.fw.data;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

public class ReadDataFromXmlToDB {

    public void exec(String path) {
        ConverXmlToBean rdfxtb = new ConverXmlToBean();

        try {
            List<DbTable> tables = rdfxtb.exec(path);
            JdbcUtils jdbc = JdbcUtils.newInstance();

            for (DbTable t : tables) {
                jdbc.getJdbcTemplate().execute(createInsertSql(t));
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String createInsertSql(DbTable table) {

        StringBuilder sb = new StringBuilder();

        StringBuilder sbField = new StringBuilder();
        StringBuilder sbValue = new StringBuilder();
        for (DbField f : table.getFields()) {
            sbField.append(f.getFieldName()).append(",");
            sbValue.append("'").append(f.getFieldValue()).append("',");
        }

        int lenField = sbField.length();
        int lenValue = sbValue.length();
        sbField.deleteCharAt(lenField - 1);
        sbValue.deleteCharAt(lenValue - 1);

        sb.append("insert into ");
        sb.append(table.getTableName());
        sb.append(" (");
        sb.append(sbField);
        sb.append(") values (");
        sb.append(sbValue);

        sb.append(");");

        return sb.toString();
    }

    public static void main(String[] args) {
        new ReadDataFromXmlToDB().exec("D:\\codedev\\workspace\\BaseExtWeb\\data\\user_data.xml");
    }
}
