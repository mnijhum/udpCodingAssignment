package com.nijhum.udpCodingAssignment;

import com.nijhum.udpCodingAssignment.parent.entity.Parent;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class ParentControllerTest extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createParent() throws Exception {
        String uri = "/api/parent";
        Parent parent = new Parent();
        parent.setComponentId(1L);
        parent.setFirstName("John");
        parent.setLastName("Cena");
        parent.setStreetAddress("Mohakhali");
        parent.setCity("Dhaka");
        parent.setState("Dhaka");
        parent.setZip("1212");
        String inputJson = super.mapToJson(parent);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"componentId\":1,\"firstName\":\"John\",\"lastName\":\"Cena\",\"streetAddress\":\"Mohakhali\",\"city\":\"Dhaka\",\"state\":\"Dhaka\",\"zip\":\"1212\"}");
    }
    @Test
    public void getParentList() throws Exception {
        String uri = "/api/parent";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        Parent [] parentList = super.mapFromJson(content, Parent[].class);
        assertTrue(parentList.length > 0);
    }
    @Test
    public void updateParent() throws Exception {
        String uri = "/api/parent/1";
        Parent parent = new Parent();
        parent.setComponentId(1L);
        parent.setFirstName("Batista");
        parent.setLastName("Snow");
        parent.setStreetAddress("Shahbag");
        parent.setCity("Dhaka");
        parent.setState("Dhaka");
        parent.setZip("1210");
        String inputJson = super.mapToJson(parent);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "{\"componentId\":1,\"firstName\":\"Batista\",\"lastName\":\"Snow\",\"streetAddress\":\"Shahbag\",\"city\":\"Dhaka\",\"state\":\"Dhaka\",\"zip\":\"1210\"}");
    }
    @Test
    public void deleteParent() throws Exception {
        String uri = "/api/parent/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Parent is deleted successsfully");
    }
}
