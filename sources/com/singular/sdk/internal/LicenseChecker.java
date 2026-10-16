package com.singular.sdk.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.vending.licensing.ILicenseResultListener;
import com.android.vending.licensing.ILicensingService;
import com.singular.sdk.internal.LicenseApiHelper;
import java.security.SecureRandom;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class LicenseChecker implements ServiceConnection {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final SecureRandom f92599g = new SecureRandom();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final SingularLog f92600h = SingularLog.f(LicenseApiHelper.class.getSimpleName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ILicensingService f92601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f92602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LicenseApiHelper.LicenseResultHandler f92603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f92604d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f92605f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResultListener extends ILicenseResultListener.Stub {
        private ResultListener() {
        }

        @Override // com.android.vending.licensing.ILicenseResultListener
        public void b2(int i3, String str, String str2) {
            LicenseChecker.this.f92603c.a(i3, str, str2);
        }
    }

    public LicenseChecker(Context context, LicenseApiHelper.LicenseResultHandler licenseResultHandler) {
        HandlerThread handlerThread = new HandlerThread("license_checker");
        handlerThread.start();
        this.f92602b = context;
        this.f92605f = context.getPackageName();
        this.f92604d = new Handler(handlerThread.getLooper());
        this.f92603c = licenseResultHandler;
    }

    private int c() {
        return f92599g.nextInt();
    }

    public synchronized void b() {
        ILicensingService iLicensingService = this.f92601a;
        if (iLicensingService == null) {
            SingularLog singularLog = f92600h;
            singularLog.h("Binding to licensing service.");
            try {
                if (!this.f92602b.bindService(new Intent("com.android.vending.licensing.ILicensingService").setPackage("com.android.vending"), this, 1)) {
                    singularLog.c("Could not bind to service.");
                    this.f92603c.a(-1, "Binding failed", "");
                }
            } catch (SecurityException e3) {
                f92600h.d("SecurityException", e3);
                this.f92603c.a(-1, String.format("Exception: %s, Message: %s", e3.toString(), e3.getMessage()), "");
            }
            f92600h.h("Binding done.");
        } else {
            try {
                iLicensingService.N1(c(), this.f92605f, new ResultListener());
            } catch (RemoteException e4) {
                f92600h.d("RemoteException in checkLicense call.", e4);
                this.f92603c.a(-1, String.format("Exception: %s, Message: %s", e4.toString(), e4.getMessage()), "");
            }
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        SingularLog singularLog = f92600h;
        singularLog.h("onServiceConnected.");
        ILicensingService iLicensingServiceX3 = ILicensingService.Stub.x3(iBinder);
        this.f92601a = iLicensingServiceX3;
        try {
            iLicensingServiceX3.N1(c(), this.f92605f, new ResultListener());
            singularLog.h("checkLicense call done.");
        } catch (RemoteException e3) {
            f92600h.d("RemoteException in checkLicense call.", e3);
            this.f92603c.a(-1, e3.toString(), "");
        }
    }

    @Override // android.content.ServiceConnection
    public synchronized void onServiceDisconnected(ComponentName componentName) {
        f92600h.h("Service unexpectedly disconnected.");
        this.f92601a = null;
    }
}
