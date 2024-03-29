/**
 * 
 */
package br.com.randrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.randrade.data.vo.v1.PersonVO;
import br.com.randrade.data.vo.v2.PersonVOV2;
import br.com.randrade.services.PersonServices;

/**
 * 
 */
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

	@Autowired
	private PersonServices personServices;
	
	@GetMapping(value = "/{id}")
	public PersonVO findById(@PathVariable(value = "id") Long id) {
		
		return personServices.findById(id);
	}
	
	@DeleteMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id) {
		
		personServices.deletePerson(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO createPerson(@RequestBody PersonVO person) {
		
		return personServices.createPerson(person);
	}
	
	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 createPersonV2(@RequestBody PersonVOV2 person) {
		
		return personServices.createPersonV2(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO updatePerson(@RequestBody PersonVO person) {
		
		return personServices.updatePerson(person);
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll(){
		
		return personServices.findAll();
	}	
}
