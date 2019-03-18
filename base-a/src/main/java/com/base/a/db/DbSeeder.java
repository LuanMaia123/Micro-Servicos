package com.base.a.db;

import com.base.a.model.Debt;
import com.base.a.model.Person;
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
        Person person1 = new Person("fulano","1231232345",
                "Rua 18"
        );

        Person person2 = new Person("fulano2","32154376532",
                "Rua 20"

        );
        Person person3 = new Person("fulano3","09874883212",
                "Rua 30"

        );

        this.personRepository.deleteAll();

        List<Person> personList = Arrays.asList(person1, person2, person3);
        this.personRepository.save(personList);
        personList = this.personRepository.findAll();

        for(Person person : personList){
            HashSet<Debt> debts = new HashSet(Arrays.asList(
                    new Debt("Debt1", 1299d, person),
                    new Debt("Debt2", 500d, person)
            ));
            person.setDebts(debts);
            this.personRepository.save(person);
        }

    }
}
