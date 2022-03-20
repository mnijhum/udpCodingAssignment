package com.nijhum.udpCodingAssignment;

import com.nijhum.udpCodingAssignment.child.model.Child;
import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ChildControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createChild() throws Exception {

        Parent parent = new Parent();
        parent.setComponentId(1L);
        parent.setFirstName("John");
        parent.setLastName("Cena");
        parent.setStreetAddress("Mohakhali");
        parent.setCity("Dhaka");
        parent.setState("Dhaka");
        parent.setZip("1212");

        String uri = "/api/child";
        Child child = new Child();
        child.setComponentId(1L);
        child.setFirstName("John");
        child.setLastName("Cena");
        child.setParent(parent);
        String inputJson = super.mapToJson(child);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"componentId\":1,\"firstName\":\"John\",\"lastName\":\"Cena\",\"parent\":{\"componentId\":1,\"firstName\":\"John\",\"lastName\":\"Snow\",\"streetAddress\":\"Shahbag\",\"city\":\"Dhaka\",\"state\":\"Dhaka\",\"zip\":\"1210\"}}");
    }
    @Test
    public void getChildList() throws Exception {
        String uri = "/api/child";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Child [] childList = super.mapFromJson(content, Child[].class);
        assertTrue(childList.length > 0);
    }
    @Test
    public void updateChild() throws Exception {

        Parent parent = new Parent();
        parent.setComponentId(1L);
        parent.setFirstName("John");
        parent.setLastName("Cena");
        parent.setStreetAddress("Mohakhali");
        parent.setCity("Dhaka");
        parent.setState("Dhaka");
        parent.setZip("1212");

        String uri = "/api/child/1";

        Child child = new Child();
        child.setComponentId(1L);
        child.setFirstName("test");
        child.setLastName("Child");
        child.setParent(parent);
        String inputJson = super.mapToJson(child);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"componentId\":1,\"firstName\":\"test\",\"lastName\":\"Child\",\"parent\":{\"componentId\":1,\"firstName\":\"John\",\"lastName\":\"Snow\",\"streetAddress\":\"Shahbag\",\"city\":\"Dhaka\",\"state\":\"Dhaka\",\"zip\":\"1210\"}}");
    }
    @Test
    public void deleteChild() throws Exception {
        String uri = "/api/child/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "");
    }
}
