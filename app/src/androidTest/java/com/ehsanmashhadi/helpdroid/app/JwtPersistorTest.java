package com.ehsanmashhadi.helpdroid.app;

import android.content.Context;
import androidx.test.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ehsanmashhadi.helpdroid.network.SharedPreferencesJwtPersister;


public class JwtPersistorTest {

    private static SharedPreferencesJwtPersister sharedPreferencesJwtPersistor;

    @BeforeClass
    public static void setUp() {

        Context context = InstrumentationRegistry.getTargetContext();
        sharedPreferencesJwtPersistor = new SharedPreferencesJwtPersister(context);
    }

    @Test
    public void saveJwt() {

        String jwt = "mockJwt";
        boolean result = sharedPreferencesJwtPersistor.save(jwt);
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get();
        Assert.assertEquals(jwt, expectedJwt);
    }

    @Test
    public void saveJwtWithIdentifier() {

        String jwt = "mockJwt";
        String identifier = "identifier";

        boolean result = sharedPreferencesJwtPersistor.save(jwt, identifier);
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get(identifier);
        Assert.assertEquals(jwt, expectedJwt);
    }

    @Test
    public void clearJwt() {

        String jwt = "mockJwt";
        boolean result = sharedPreferencesJwtPersistor.save(jwt);
        Assert.assertTrue(result);
        result = sharedPreferencesJwtPersistor.delete();
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get();
        Assert.assertNull(expectedJwt);
    }

    @Test
    public void clearJwtWithIdentifier() {

        String jwt = "mockJwt";
        String identifier = "mockIdentifier";
        boolean result = sharedPreferencesJwtPersistor.save(jwt, identifier);
        Assert.assertTrue(result);
        result = sharedPreferencesJwtPersistor.delete(identifier);
        Assert.assertTrue(result);
        String expectedJwt = sharedPreferencesJwtPersistor.get(identifier);
        Assert.assertNull(expectedJwt);
    }
}
