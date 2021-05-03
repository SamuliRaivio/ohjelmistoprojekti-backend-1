package com.example.ohjelmistoprojektiBackend.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ohjelmistoprojektiBackend.domain.Kysely;
import com.example.ohjelmistoprojektiBackend.domain.KyselyRepository;
import com.example.ohjelmistoprojektiBackend.domain.Kysymys;
import com.example.ohjelmistoprojektiBackend.domain.KysymysRepository;


@RequestMapping("/api")
@RestController
public class ControllerClass {
		
	
	
	
	@Autowired
	KyselyRepository kyselyRepository; 
	
	@Autowired
	KysymysRepository krepo;
	
	
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public @ResponseBody List<Kysymys> getAllkyselyt2() {
			return (List<Kysymys>) krepo.findAll();
		}
	
	@GetMapping("/kyselyt/{id}")
    public ResponseEntity < Kysely > getKyselyById(@PathVariable(value = "kysely_id") Long kyselyId)
    throws ResourceNotFoundException {
        Kysely kysely = kyselyRepository.findById(kyselyId)
            .orElseThrow(() -> new ResourceNotFoundException("Kysely not found for this id : " + kyselyId));
        return ResponseEntity.ok().body(kysely);
    }
	
	@PostMapping("/kyselyt")
    public Kysely createKysely(@RequestBody Kysely kysely) {
        return kyselyRepository.save(kysely);
    }
	
	@PutMapping("/kyselyt/{id}")
    public ResponseEntity < Kysely > updateKysely(@PathVariable(value = "kysely_id") Long kyselyId,
        @RequestBody Kysely kyselyDetails) throws ResourceNotFoundException {
        Kysely kysely = kyselyRepository.findById(kyselyId)
            .orElseThrow(() -> new ResourceNotFoundException("Kysely not found for this id : " + kyselyId));

        kysely.setKysely_id(kyselyDetails.getKysely_id());
       
        final Kysely updatedKysely = kyselyRepository.save(kysely);
        return ResponseEntity.ok(updatedKysely);
    }
	
	@DeleteMapping("/kyselyt/{id}")
    public Map < String, Boolean > deleteKysely(@PathVariable(value = "kysely_id") Long kyselyId)
    throws ResourceNotFoundException {
        Kysely kysely = kyselyRepository.findById(kyselyId)
            .orElseThrow(() -> new ResourceNotFoundException("Kysely not found for this id : " + kyselyId));

        kyselyRepository.delete(kysely);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@RequestMapping(value="/api", method = RequestMethod.GET)
    public @ResponseBody List<Kysely> kyselyListaRest() {	
        return (List<Kysely>) kyselyRepository.findAll();
    }    
	
	@RequestMapping(value="/api", method = RequestMethod.POST)
    public @ResponseBody Kysely saveKyselyRest(@RequestBody Kysely kysely) {	
    	return kyselyRepository.save(kysely);
    }

	
	
}
