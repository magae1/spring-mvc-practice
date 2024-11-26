package org.conan.utils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.conan.mapper.TimeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTest {
    @Setter(onMethod_ = {@Autowired})
    private TimeMapper timeMapper;

    @Test
    public void testGetTime()  {
        System.out.println("interface getTime");
        System.out.println(timeMapper.getClass().getName());
        System.out.println(timeMapper.getTime());
    }

    @Test
    public void testGetTime2() {
        System.out.println("interface getTime2");
        System.out.println(timeMapper.getTime2());
    }
}
