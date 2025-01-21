package com.ms.accounts.service;

import com.ms.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * Create Account
     *
     * @param customerDto - CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * Fetch Account Details
     *
     * @param mobileNumber - Mobile Number of customer
     * @return details of the customer
     */
    CustomerDto fetchAccountDetails(String mobileNumber);


    /**
     * Update an existing account with the provided customer details.
     *
     * @param customerDto - CustomerDto object containing updated account information.
     * @return true if the account was successfully updated, false otherwise.
     */
    boolean updateAccount(CustomerDto customerDto);


    public boolean deleteAccount(String mobileNumber);
}
