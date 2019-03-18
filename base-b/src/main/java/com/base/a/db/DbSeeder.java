package com.base.a.db;

import com.base.a.model.Asset;
import com.base.a.model.Person;
import com.base.a.repository.AssetRepository;
import com.base.a.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private PersonRepository personRepository;

    public DbSeeder(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Person person1 = new Person("fulano",
                18,
                "1500",
                "Rua 18"
        );

        Person person2 = new Person("fulano2",
                30,
                "3000",
                "Rua 20"

        );
        Person person3 = new Person("fulano3",
                45,
                "4500",
                "Rua 30"

        );

        this.personRepository.deleteAll();

        List<Person> personList = Arrays.asList(person1, person2, person3);
        this.personRepository.save(personList);
        personList = this.personRepository.findAll();

        for(Person person : personList){
            HashSet<Asset> assetsPerson = new HashSet(Arrays.asList(
                    new Asset("Asset1", 1299d, person),
                    new Asset("Asset2", 500d, person)
            ));
            person.setAssets(assetsPerson);
            this.personRepository.save(person);
        }

    }
}
