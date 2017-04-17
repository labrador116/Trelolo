package com.example.sbt_markin_aa.trelolo.model.services;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

/**
 * Created by sbt-markin-aa on 14.04.17.
 */
@RunWith(AndroidJUnit4.class)
public class CheckInputDataServiceTest {

    @Test
    public void checkInputDataLoginTestPositiveResult(){
        boolean result= CheckInputDataService.checkInputDataLogin(InstrumentationRegistry.getTargetContext(),"test");
        Assert.assertSame(true,result);
    }
    @Test
    public void checkInputDataLoginTestNegativeResult(){
        boolean result= CheckInputDataService.checkInputDataLogin(InstrumentationRegistry.getTargetContext(),"admin");
        Assert.assertSame(false,result);
    }
    @Test
    public void checkInputPasswordTestPositiveResult(){
        boolean result= false;
        if(CheckInputDataService.checkInputDataLogin(InstrumentationRegistry.getTargetContext(),"test")){
            result=CheckInputDataService.checkInputPassword(InstrumentationRegistry.getTargetContext(),"test");
        }
        Assert.assertSame(true,result);
    }
    @Test
    public void checkInputPasswordTestNegativeResult(){
        boolean result= false;
        if(CheckInputDataService.checkInputDataLogin(InstrumentationRegistry.getTargetContext(),"test")){
            result=CheckInputDataService.checkInputPassword(InstrumentationRegistry.getTargetContext(),"qqqqqqq");
        }
        Assert.assertSame(false,result);
    }

}
