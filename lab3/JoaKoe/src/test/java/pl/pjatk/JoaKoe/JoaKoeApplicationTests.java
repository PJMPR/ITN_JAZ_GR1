package pl.pjatk.JoaKoe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import pl.pjatk.JoaKoe.contract.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.json.BasicJsonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class HelloControllerTest {


		@Autowired
		private ObjectMapper objectMapper;
		@Autowired
		private MockMvc mvc;
		BasicJsonTester json = new BasicJsonTester(getClass());

		@Test
		public void testPathAndQueryParams() throws Exception {
			/*
			 * na adres localhost:8080/homework dodać parametry path'a (@PathVariable) oraz parametr query (@RequestParam) o nazwie 'query'
			 *
			 * */
			mvc.perform(MockMvcRequestBuilders.get("/homework/test?query=test").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string("path:test query:test"));

			mvc.perform(MockMvcRequestBuilders.get("/homework/test1?query=test1").accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string("path:test1 query:test1"));
		}

		@Test
		public void testPostAndPutMethod() throws Exception {

			Person person = new Person();
			person.setAge(32);
			person.setName("Ala");
			person.setSurname("Kot");


			/*
			 * na adres localhost:8080/homework/person metodą post wysyłamy jsona i go spowrotem otrzymujemy w odpowiedzi
			 * */
			mvc.perform(post("/homework/person")
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(person)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("Ala"))
					.andExpect(jsonPath("$.surname").value("Kot"))
					.andExpect(jsonPath("$.age").value(32))
			;

			/*
			 * na adres localhost:8080/homework/person/1 metodą put (wykorzystujemy @PathVariable) wysyłamy jsona i go spowrotem otrzymujemy w odpowiedzi
			 * */
			mvc.perform(put("/homework/person/1")
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(person)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("Ala"))
					.andExpect(jsonPath("$.surname").value("Kot"))
					.andExpect(jsonPath("$.age").value(32))
			;
			mvc.perform(put("/homework/person/2")
					.contentType("application/json")
					.content(objectMapper.writeValueAsString(person)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.name").value("Ala"))
					.andExpect(jsonPath("$.surname").value("Kot"))
					.andExpect(jsonPath("$.age").value(32))
			;

		}

		@Test
		public void testDeletePerson() throws Exception {
			/*
			 * na adres localhost:8080/homework/person/1 (..2,3) metodą delete dostajemy jedynie status odpowiedzi 200 (ok)
			 * */
			mvc.perform(delete("/homework/person/1")).andExpect(status().isOk());
			mvc.perform(delete("/homework/person/2")).andExpect(status().isOk());
			mvc.perform(delete("/homework/person/3")).andExpect(status().isOk());
		}
	}
