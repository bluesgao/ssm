package com.gx.app.ssm.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.opencsv.CSVParser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.extern.slf4j.Slf4j;

/**
 * 如果出现第一列读取不到的情况请修改编码模式为UTF-8, (UTF-8-BOM模式会丢失第一列)
 *
 * @author pc1010
 */
@Slf4j
public class CsvUtils {

    /**
     * 解析csv文件并转成bean
     *
     * @param file  csv文件
     * @param clazz 类
     * @param <T>   泛型
     * @return 泛型bean集合
     */
    public static <T> List<T> parse(File file, Class<T> clazz) {
        try {
            List<T> result = new ArrayList<T>();
            InputStream fileInput = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(fileInput,"utf-8");
            HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(clazz);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in).withSeparator(CSVParser.DEFAULT_SEPARATOR).withThrowExceptions(false)
                    .withMappingStrategy(strategy).build();
            Iterator<T> iterator = csvToBean.iterator();
            while (iterator.hasNext()) {
                try {
                    T t = iterator.next();
                    result.add(t);
                } catch (Exception e) {
                    log.error("parse error:{}",e);
                }
            }
            return result;
        } catch (Exception e) {
            log.error("parse error:{}",e);
            return null;
        }
    }

    public static <T> List<T> parse(InputStream inputStream, Class<T> clazz) {
        try {
            List<T> result = new ArrayList<T>();
            InputStreamReader in = new InputStreamReader(inputStream,"utf-8");
            HeaderColumnNameMappingStrategy<T> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(clazz);
            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(in).withSeparator(CSVParser.DEFAULT_SEPARATOR).withThrowExceptions(false)
                    .withMappingStrategy(strategy).build();
            Iterator<T> iterator = csvToBean.iterator();
            while (iterator.hasNext()) {
                try {
                    T t = iterator.next();
                    result.add(t);
                } catch (Exception e) {
                    log.error("parse error:{}",e);
                }
            }
            return result;
        } catch (Exception e) {
            log.error("parse error:{}",e);
            return null;
        }
    }
}