package com.verizon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.esd.model.Plan;
import com.verizon.esd.service.PlanApi;
import com.verizon.esd.service.PlanService;
import com.verizon.esd.service.PlanServiceImp;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers=PlanApi.class)
public class PlansApiTest {

		private MockMvc mockMvc;

		@Autowired
		private WebApplicationContext webApplicationContext;

		@MockBean
		private  PlanServiceImp planServiceMock;

		@Before
		public void setUp() {
			mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		}

		@After
		public void tearDown() {
			mockMvc = null;
		}

		@Test
		public void testListPlans() throws Exception{
			assertThat(this.planServiceMock).isNotNull();
			List<Plan> plistPage = new ArrayList<>();
			plistPage.add(new Plan());
			when(planServiceMock.getAllPlans()).thenReturn(plistPage);
			
			mockMvc.perform(get("/plans"))
			.andExpect(status().isOk())
			.andDo(print());
		}
		@Test
		public void testListPlansBySpeed() throws Exception{
			assertThat(this.planServiceMock).isNotNull();
			List<Plan> plistPage = new ArrayList<>();
			plistPage.add(new Plan());
			when(planServiceMock.getPlansBySpeed(5)).thenReturn(plistPage);
			
			mockMvc.perform(get("/plans/speed/5"))
			.andExpect(status().isOk())
			.andDo(print());
		}
		@Test
		public void testListPlansByUsage() throws Exception{
			assertThat(this.planServiceMock).isNotNull();
			List<Plan> plistPage = new ArrayList<>();
			plistPage.add(new Plan());
			when(planServiceMock.getPlansByUsage(250)).thenReturn(plistPage);
			
			mockMvc.perform(get("/plans/maxUsage/250"))
			.andExpect(status().isOk())
			.andDo(print());
		}
		/*@Test
		public void handleDoSearchEmplyoee() throws Exception{
			assertThat(this.planServiceMock).isNotNull();
			
			Plan elistPage = planServiceMock.getPlan("TL001");

			when(planServiceMock.getPlan("TL001")).thenReturn(elistPage);
			
			
			mockMvc.perform(get("plans/pTitle/TL001"))
			.andExpect(status().isOk())
			.andExpect(view().name("searchPage"))
			.andDo(print());
			
		}*/

		
}

