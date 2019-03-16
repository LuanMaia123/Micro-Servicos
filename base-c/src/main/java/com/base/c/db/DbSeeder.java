package com.base.c.db;

import com.base.c.document.LastPurchase;
import com.base.c.document.Person;
import com.base.c.document.Transaction;
import com.base.c.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {
    private PersonRepository personRepository;

    public DbSeeder(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        Person person1 = new Person("123456789",
                "teste1",
                Arrays.asList(
                        new LastPurchase("Loja1", new Date(), 120000d),
                        new LastPurchase("Loja2", new Date(), 50000d)
                ),
                Arrays.asList(
                        new Transaction(new Date(),1500d),
                        new Transaction(new Date(), 200d)
                )
        );

        Person person2 = new Person("91231231212",
                "teste2",
                Arrays.asList(
                        new LastPurchase("Loja1", new Date(), 230d),
                        new LastPurchase("Loja2", new Date(), 460d)
                ),
                Arrays.asList(
                        new Transaction(new Date(),1500d),
                        new Transaction(new Date(), 200d)
                )
        );

        Person person3 = new Person("321312311",
                "teste3",
                Arrays.asList(
                        new LastPurchase("Loja1", new Date(), 300d),
                        new LastPurchase("Loja2", new Date(), 120d)
                ),
                Arrays.asList(
                        new Transaction(new Date(),1500d),
                        new Transaction(new Date(), 200d)
                )
        );

        this.personRepository.deleteAll();

        List<Person> personList = Arrays.asList(person1, person2, person3);
        this.personRepository.save(personList);
    }
}
