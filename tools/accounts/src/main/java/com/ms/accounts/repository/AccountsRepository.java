package com.ms.accounts.repository;

import com.ms.accounts.entity.Accounts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    /**
     * Retrieves an account associated with the specified customer ID.
     *
     * @param customerId the ID of the customer whose account is to be retrieved.
     * @return an Optional containing the account if found, or an empty Optional if no account exists for the given customer ID.
     */
    Optional<Accounts> findByCustomerId(Long customerId);

    /**
     * Deletes an account by customer id.
     *
     * @param customerId the customer id.
     */
    @Transactional
    @Modifying
    void deleteByCustomerId(Long customerId);
}
