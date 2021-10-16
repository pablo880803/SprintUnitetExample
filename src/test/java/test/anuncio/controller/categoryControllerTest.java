package test.anuncio.controller;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import test.anuncio.entity.category;
import test.anuncio.service.advertisementsServiceImpl;
import test.anuncio.service.categoryServiceImpl;
import test.anuncio.service.productServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(categoryController.class)
//@WithMockUser
//@ExtendWith(MockitoExtension.class)
//@RunWith(JUnitPlatform.class)
//@ContextConfiguration(classes = {categoryServiceImpl.class})
public class categoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    categoryServiceImpl categoryServiceImpl;

    @MockBean
    advertisementsServiceImpl advertisementsServiceImpl;

    @MockBean
    productServiceImpl productServiceImpl;

    String exampleCategoryJson="{\"idcategory\":5,\"name\":\"Trailer TV\",\"description\":\"Trailer TV\",\"hasLength\":true}";


    @Test
    public void getAllcategoryAPI() throws Exception
    {
        category category=new category(Long.parseLong("5"),"Trailer TV","Trailer TV",true);

        // studentService.addCourse to respond back with mockCourse
        Mockito.when(categoryServiceImpl.Createcategory(Mockito.any(category.class))).thenReturn(category);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/api/category").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        System.out.println(result.getResponse());
        String expected = "{idcategory:5,name:Trailer TV,description:Trailer TV,hasLength:true}";

        // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

        //JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);


        assertEquals(HttpStatus.OK.value(), response.getStatus());

//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/category")).andReturn();//.andDo(print())
//        mvcResult.andExpect(MockMvcResultMatchers.status().isOk());
//                .andExpect(MockMvcResultMatchers.jsonPath("$.category").exists())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.category[*].idcategory").isNotEmpty());
    }

    @Test
    public void createCategoria() throws Exception {
        category category=new category(Long.parseLong("5"),"Trailer TV","Trailer TV",true);

        // studentService.addCourse to respond back with mockCourse
        Mockito.when(categoryServiceImpl.Createcategory(Mockito.any(category.class))).thenReturn(category);

        // Send course as body to /students/Student1/courses
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/category")
                .accept(MediaType.APPLICATION_JSON).content(exampleCategoryJson)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

        //assertEquals("http://localhost:8080/api/category/4",response.getHeader(HttpHeaders.LOCATION));

    }



}
