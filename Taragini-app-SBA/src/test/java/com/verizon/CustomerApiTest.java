package com.verizon;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.verizon.esd.TestUtil.TestUtil;
import com.verizon.esd.model.Customer;
import com.verizon.esd.service.CustomerApi;
import com.verizon.esd.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = CustomerApi.class)
public class CustomerApiTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@MockBean
	private CustomerService custServiceMock;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@After
	public void tearDown() {
		mockMvc = null;
	}
	@Test
	public void testGetAllCustomers() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		List<Customer> cList = new ArrayList<>();
		cList.add(new Customer());

		when(custServiceMock.getAllCustomers()).thenReturn(cList);

		mockMvc.perform(get("/customers")).andExpect(status().isOk()).andDo(print());

	}
	
	@Test
	public void testAddCustomer() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		Customer cust = new Customer();

//		cust.setEmpName("Raima");
//		cust.setBasic(8977);
//		cust.setHra(45);
//		emp.setDateOfJoining(null);
//		emp.setDept(Department.HR);
		
		cust.setName("Rishabh Goyal");
		cust.setAddress("asdgasiuygd");
		cust.setMbno("9464796251");

		Customer custAdded = new Customer();
		
		custAdded.setName("Rishabh Goyal");
		custAdded.setAddress("asdgasiuygd");
		custAdded.setMbno("9464796251");
		
//		empAdded.setEmpId(14);
//		empAdded.setEmpName("Raima");
//		empAdded.setBasic(8977);
//		empAdded.setHra(45);
//		empAdded.setDateOfJoining(null);
//		empAdded.setDept(Department.HR);

		System.out.println(cust);
	}

	/*@Test
	public void testDeleteCustomer() throws Exception {
		assertThat(this.custServiceMock).isNotNull();

		int cid = 1;
		boolean c=true;

		when(custServiceMock.removeCustomer(cid)).thenReturn(true);

		mockMvc.perform(delete("/customers/10")).andExpect(status().isOk()).andDo(print());

	}*/
}