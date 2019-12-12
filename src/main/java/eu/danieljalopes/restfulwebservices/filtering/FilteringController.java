package eu.danieljalopes.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("value 1", "value 2", "value 3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveSomeBeanList() {
		return  Arrays.asList(new SomeBean("value 1", "value 2", "value 3"),new SomeBean("value 12", "value 22", "value 32"));
	}
	
	
	//Show field1 and field2
	@GetMapping("/filtering2")
	public MappingJacksonValue retrieveSomeBean2() {
		
		SomeBean2 someBean2 = new SomeBean2("value 1", "value 2", "value 3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(someBean2);
		mapping.setFilters(filters);
		
		return mapping;
	}
	
	//Show field2 and field3
	@GetMapping("/filtering-list2")
	public MappingJacksonValue retrieveSomeBeanList2() {
		List<SomeBean2> list =  Arrays.asList(new SomeBean2("value 1", "value 2", "value 3"),new SomeBean2("value 12", "value 22", "value 32"));
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2","field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		
		
		return mapping;
	}
}
