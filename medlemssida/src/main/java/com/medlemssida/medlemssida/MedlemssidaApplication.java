package com.medlemssida.medlemssida;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedlemssidaApplication {


	public static final List<Member> listOfMembers = new ArrayList<>();

    static {
        listOfMembers.add(new Member("Eric", 1));
        listOfMembers.add(new Member("Börje", 2));

    }

	public static void main(String[] args) {
		SpringApplication.run(MedlemssidaApplication.class, args);
	}
}
