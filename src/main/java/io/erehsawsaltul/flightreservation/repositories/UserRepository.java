package io.erehsawsaltul.flightreservation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.erehsawsaltul.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
