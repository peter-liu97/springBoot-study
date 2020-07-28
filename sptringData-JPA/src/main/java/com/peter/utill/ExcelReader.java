package com.peter.utill;

import com.peter.pojo.BisMulti;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class ExcelReader {
    public List<BisMulti>   readerExcel (){
        List<BisMulti> resultList = new ArrayList<>();

        Workbook wb = null;

        Sheet sheet = null;

        Row row = null;

        List<Map<String, String>> list = null;

        String cellData = null;

        String filePath = "/Users/liushimin/Downloads/lalla.xlsx";
//        String filePath = "C:\\Users\\yueworld\\Downloads\\多经点位模板0717.xlsx";

        String columns[] = {"项目简称", "商业公司名称", "项目ID", "多经ID","多经编号","多经类型","多经类型","内外场","起租面积㎡","租金标准","位置区域","最大面积㎡","其中(m)：长度","其中(m)：长度","宽度","高度"};

        wb = readExcel(filePath);

        if (wb != null) {

            //用来存放表中数据

            list = new ArrayList<Map<String, String>>();

            //获取第一个sheet

            sheet = wb.getSheetAt(0);

            //获取最大行数

            int rownum = sheet.getPhysicalNumberOfRows();

            //获取第一行

            row = sheet.getRow(0);

            //获取最大列数

            int colnum = row.getPhysicalNumberOfCells();

            for (int i = 1; i < rownum; i++) {

                Map<String, String> map = new LinkedHashMap<String, String>();

                row = sheet.getRow(i);

                if (row != null) {

                    for (int j = 0; j < colnum; j++) {

                        cellData = (String) getCellFormatValue(row.getCell(j));

                        map.put(columns[j], cellData);

                    }

                } else {

                    break;

                }

                list.add(map);

            }


        }

        //遍历解析出来的list

        for (Map<String, String> map : list) {
            BisMulti bisMulti = new BisMulti();

            for (Map.Entry<String, String> entry : map.entrySet()) {
                //"多经ID", "租金标准", "平日租金标准(元/个/月)",
                // "周末租金标准(元/个/月)", "节假日租金标准(元/个/月)"
                if(entry.getKey()=="多经ID"){
                    bisMulti.setBisMultiId(entry.getValue());
                }
//                else if(entry.getKey()=="平日租金标准(元/个/月)"){
//                    bisMulti.setMultiPriceWeekend(entry.getValue());
//                }else if(entry.getKey()=="周末租金标准(元/个/月)"){
//                    bisMulti.setMultiGrade(entry.getValue());
//                }else if(entry.getKey()=="节假日租金标准(元/个/月)"){
//                    bisMulti.setMultiPriceHolidays(entry.getValue());
//                }
            }
            resultList.add(bisMulti);
        }

        return resultList;
    }

    //读取excel

    public static Workbook readExcel(String filePath) {

        Workbook wb = null;

        if (filePath == null) {

            return null;

        }

        String extString = filePath.substring(filePath.lastIndexOf("."));

        InputStream is = null;

        try {

            is = new FileInputStream(filePath);

            if (".xls".equals(extString)) {

                return wb = new HSSFWorkbook(is);

            } else if (".xlsx".equals(extString)) {

                return wb = new XSSFWorkbook(is);

            } else {

                return wb = null;

            }


        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return wb;

    }

    public static Object getCellFormatValue(Cell cell) {

        Object returnValue = null;
        switch (cell.getCellType()) {
            case NUMERIC:   //数字
                Double doubleValue = cell.getNumericCellValue();
                // 格式化科学计数法，取一位整数
                DecimalFormat df = new DecimalFormat("0");
                returnValue = df.format(doubleValue);
                break;
            case STRING:    //字符串
                returnValue = cell.getStringCellValue();
                break;
            case BOOLEAN:   //布尔
                Boolean booleanValue = cell.getBooleanCellValue();
                returnValue = booleanValue.toString();
                break;
            case BLANK:     // 空值
                break;
            case FORMULA:   // 公式
                returnValue = cell.getCellFormula();
                break;
            case ERROR:     // 故障
                break;
            default:
                break;
        }
        return returnValue;
    }


}
