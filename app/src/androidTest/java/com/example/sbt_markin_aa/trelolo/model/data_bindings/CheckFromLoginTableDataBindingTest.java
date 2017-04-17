package com.example.sbt_markin_aa.trelolo.model.data_bindings;

import android.database.Cursor;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.base.Verify;
import android.support.test.runner.AndroidJUnit4;

import com.example.sbt_markin_aa.trelolo.model.database.cursor_wrappers.LoginTableCursorWrapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by sbt-markin-aa on 17.04.17.
 */

@RunWith(AndroidJUnit4.class)
public class CheckFromLoginTableDataBindingTest {
    @Test
    public void checkPersonLoginPositiveTest(){
        LoginTableCursorWrapper actual= CheckFromLoginTableDataBinding.checkPersonLogin(InstrumentationRegistry.getTargetContext(),"test");
        actual.moveToFirst();
        Assert.assertSame(actual.checkPerson(), true);
    }

    @Test
    public void checkPersonLoginNegativeTest(){
        LoginTableCursorWrapper actual= CheckFromLoginTableDataBinding.checkPersonLogin(InstrumentationRegistry.getTargetContext(),"admin");
        actual.moveToFirst();
        Assert.assertSame(actual.checkPerson(), false);
    }

    @Test
    public void checkPersonPasswordPositiveTest(){
        LoginTableCursorWrapper actual= CheckFromLoginTableDataBinding.checkPersonPassword(InstrumentationRegistry.getTargetContext(),"test");
        actual.moveToFirst();
        Assert.assertSame(actual.checkPerson(), true);
    }

    @Test
    public void checkPersonPasswordNegativeTest(){
        LoginTableCursorWrapper actual= CheckFromLoginTableDataBinding.checkPersonPassword(InstrumentationRegistry.getTargetContext(),"admin");
        actual.moveToFirst();
        Assert.assertSame(actual.checkPerson(), false);
    }
}
