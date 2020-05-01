package com.gs.rest.filter.dynamicFiltaring;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController

public class FilteringDynamicController {
	// field1,field2
		@GetMapping("/dynamicfiltering")
		public MappingJacksonValue dynamicretrieveSomeBean() {
			SomeBeanDynamic someBean = new SomeBeanDynamic("value1", "value2", "value3");
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
			MappingJacksonValue mapping = new MappingJacksonValue(someBean);
			mapping.setFilters(filters);

			return mapping;
		}

		// field2, field3
		@GetMapping("/dynamicfiltering-list")
		public MappingJacksonValue dynamicretrieveListOfSomeBeans() {
			List<SomeBeanDynamic> list = Arrays.asList(new SomeBeanDynamic("value1", "value2", "value3"),
					new SomeBeanDynamic("value12", "value22", "value32"));
			SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
			FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
			MappingJacksonValue mapping = new MappingJacksonValue(list);
			mapping.setFilters(filters);
			return mapping;
		}
		
		
	}