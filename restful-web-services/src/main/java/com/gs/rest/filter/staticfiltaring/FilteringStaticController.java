package com.gs.rest.filter.staticfiltaring;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController

public class FilteringStaticController {
	// field1,field2
		@GetMapping("/filtering")
		public SomeBean retrieveSomeBean() {
			SomeBean someBean = new SomeBean("value1", "value2", "value3");
			return someBean;
		}

		// field2, field3
		@GetMapping("/filtering-list")
		public List<SomeBean> retrieveListOfSomeBeans() {
			List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
					new SomeBean("value12", "value22", "value32"));
			return list;
		}
		
		// field1,field2
		@GetMapping("/filtering1")
		public SomeBean1 retrieveSomeBean1() {
			SomeBean1 someBean = new SomeBean1("value1", "value2", "value3");
			return someBean;
		}

		// field2, field3
		@GetMapping("/filtering-list1")
		public List<SomeBean1> retrieveListOfSomeBeans1() {
			List<SomeBean1> list = Arrays.asList(new SomeBean1("value1", "value2", "value3"),
					new SomeBean1("value12", "value22", "value32"));
			return list;
		}


	}