package com.ehsanmashhadi.helpdroid;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.ehsanmashhadi.helpdroid.application.ApplicationUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ApplicationUtilTest {

    @Mock
    private Context mContext;

    @Mock
    private ApplicationInfo mApplicationInfo;

    @Before
    public void before() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testIsDebuggable_true() {
        mApplicationInfo.flags = ApplicationInfo.FLAG_DEBUGGABLE;
        Mockito.when(mContext.getApplicationInfo()).thenReturn(mApplicationInfo);
        Assert.assertTrue(ApplicationUtil.isDebuggable(mContext));
    }

    @Test
    public void testIsDebuggable_false() {
        Mockito.when(mContext.getApplicationInfo()).thenReturn(mApplicationInfo);
        Assert.assertFalse(ApplicationUtil.isDebuggable(mContext));
    }
}