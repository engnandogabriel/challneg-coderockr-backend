package com.project.Coderock.domain.value_objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatusTest {

    @Test
    @DisplayName("Should be create a new Status and change a value")
    void create() throws Exception{
        Status status = Status.create();
        Assertions.assertEquals("in_investment", status.getStatus());
        status.setWithdrawn();
        Assertions.assertEquals("withdrawn", status.getStatus());
    }
}