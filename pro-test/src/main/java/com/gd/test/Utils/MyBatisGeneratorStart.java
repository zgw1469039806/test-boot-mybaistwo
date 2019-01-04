package com.gd.test.Utils;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Author alan.wang   QQ:3103484396
 * @Description TODO
 */
public class MyBatisGeneratorStart
{
    public static void main(String[] args)
    {

        try
        {
            Scanner input =  new Scanner(System.in);


            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            Properties properties = new Properties();
            properties.setProperty("projectDic" , System.getProperty("user.dir"));
            ConfigurationParser cp = new ConfigurationParser(properties , warnings);
            Configuration config = cp.parseConfiguration(MyBatisGeneratorStart.class.getClassLoader().getResourceAsStream("generatorConfig.xml"));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
