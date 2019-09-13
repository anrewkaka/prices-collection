package xyz.lannt.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import xyz.lannt.infrastructure.repository.MarketSummaryRepository;

@RestController
@RequestMapping("test")
public class SampleController {

	@Autowired
	MarketSummaryRepository marketSummaryRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get() {
		return marketSummaryRepository.get();
	}
}
