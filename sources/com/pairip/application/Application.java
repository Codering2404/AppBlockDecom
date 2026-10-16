package com.pairip.application;

import android.content.Context;
import com.pairip.SignatureCheck;
import com.pairip.VMRunner;
import com.pairip.licensecheck.LicenseClient;
import cz.mobilesoft.appblock.AppBlockApplication;

/* JADX INFO: loaded from: classes2.dex */
public class Application extends AppBlockApplication {
    @Override // cz.mobilesoft.coreblock.LockieApplication, androidx.multidex.MultiDexApplication, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        VMRunner.setContext(context);
        SignatureCheck.verifyIntegrity(context);
        LicenseClient.checkLicense(context);
        super.attachBaseContext(context);
    }
}
