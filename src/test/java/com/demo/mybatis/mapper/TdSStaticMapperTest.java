package com.demo.mybatis.mapper;

import com.demo.mybatis.model.TdSStatic;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.eclipse.core.runtime.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Krystal on 2019/7/17.
 */
public class TdSStaticMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != reader) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void testSelectAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{
            List<TdSStatic> tdSStatic = sqlSession.selectList("selectAll",10);
            Assert.isNotNull(tdSStatic);
        }finally {
            sqlSession.close();
        }
    }

    private void printList(List<TdSStatic> tdSStatics){
        for(TdSStatic sStatic:tdSStatics){
            System.out.println(sStatic.getDataName()+":"+sStatic.getDataId());
        }
    }
}
