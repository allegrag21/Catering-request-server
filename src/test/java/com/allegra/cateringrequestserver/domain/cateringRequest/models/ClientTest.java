package com.allegra.cateringrequestserver.domain.cateringRequest.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    public void constructorTest01(){
        Client client = new Client();
        client.setId(1L);

        String expected = "1 Janet McKoy JM@user.com Night Life October 23rd 2023 - November 1st 2023";
        String actual = client.toString();

        Assertions.assertEquals(expected, actual);
    }
}


