package secure.vault.demo.controllers;

import secure.vault.demo.entities.DataVault;
import secure.vault.demo.entities.TestingEntity;
import secure.vault.demo.entities.TestingModel;
import secure.vault.demo.repositories.IDataVaultRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;


@RestController
@RequestMapping("/api-vault")
public class DataVaultController {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataVaultController.class);
    private final IDataVaultRepository dataVaultRepository;

    public DataVaultController(IDataVaultRepository personRepository) {
        this.dataVaultRepository = personRepository;
    }

    @PostMapping("/data")
    @ResponseStatus(HttpStatus.CREATED)
    public DataVault postPerson(@RequestBody DataVault person) {
        return dataVaultRepository.save(person);
    }


    @GetMapping("/data/{id}")
    public ResponseEntity<DataVault> getPerson(@PathVariable String id) {
        DataVault person = dataVaultRepository.findOne(id);
        if (person == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(person);
    }
    
  
    @DeleteMapping("/data/{id}")
    public Long deletePerson(@PathVariable String id) {
        return dataVaultRepository.delete(id);
    }

    @PutMapping("/data")
    public DataVault putPerson(@RequestBody DataVault person) {
        return dataVaultRepository.update(person);
    }


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public final Exception handleAllExceptions(RuntimeException e) {
        LOGGER.error("Internal server error.", e);
        return e;
    }
    

}
