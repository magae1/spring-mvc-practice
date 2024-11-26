package org.conan.utils;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
    @Setter(onMethod_ = {@Autowired})
    private WebApplicationContext ctx;
    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
    }

    @Test
    public void testList() throws Exception {
        System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap());
    }

    @Test
    public void testRegister() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/write")
                        .param("title", "controller test 제목")
                        .param("content", "controller test 내용")
                        .param("writer", "controller test 작성자"))
                .andReturn().getModelAndView().getViewName();
        System.out.println(resultPage);
    }

    @Test
    public void testRead() throws Exception {
        System.out.println(mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
                        .param("bno","4"))
                .andReturn().getModelAndView().getModelMap());
    }

    @Test
    public void testModify() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/modify")
                        .param("bno","1")
                        .param("title", "controller test 수정된 제목")
                        .param("content", "controller test 수정된 내용")
                        .param("writer", "controller test 수정된 작성자"))
                .andReturn().getModelAndView().getViewName();
        System.out.println(resultPage);
    }

    @Test
    public void testRemove() throws Exception {
        String resultPage = mockMvc.perform(MockMvcRequestBuilders.post("/board/remove")
                        .param("bno", "18"))
                .andReturn().getModelAndView().getViewName();
        System.out.println(resultPage);
    }

}
