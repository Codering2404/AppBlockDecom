package com.android.installreferrer.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.media3.common.JBEE.bfIdKSjLOVjG;
import com.android.installreferrer.commons.InstallReferrerCommons;
import com.google.android.finsky.externalreferrer.IGetInstallReferrerService;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class InstallReferrerClientImpl extends InstallReferrerClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f57594a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f57595b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private IGetInstallReferrerService f57596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ServiceConnection f57597d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface ClientState {
        public static final int CLOSED = 3;
        public static final int CONNECTED = 2;
        public static final int CONNECTING = 1;
        public static final int DISCONNECTED = 0;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class InstallReferrerServiceConnection implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InstallReferrerStateListener f57598a;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Install Referrer service disconnected.");
            InstallReferrerClientImpl.this.f57596c = null;
            InstallReferrerClientImpl.this.f57594a = 0;
            this.f57598a.onInstallReferrerServiceDisconnected();
        }

        private InstallReferrerServiceConnection(InstallReferrerStateListener installReferrerStateListener) {
            if (installReferrerStateListener == null) {
                throw new RuntimeException("Please specify a listener to know when setup is done.");
            }
            this.f57598a = installReferrerStateListener;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            InstallReferrerCommons.logVerbose(bfIdKSjLOVjG.dBEJHxNbv, "Install Referrer service connected.");
            InstallReferrerClientImpl.this.f57596c = IGetInstallReferrerService.Stub.h5(iBinder);
            InstallReferrerClientImpl.this.f57594a = 2;
            this.f57598a.onInstallReferrerSetupFinished(0);
        }
    }

    public InstallReferrerClientImpl(Context context) {
        this.f57595b = context.getApplicationContext();
    }

    private boolean c() {
        return this.f57595b.getPackageManager().getPackageInfo("com.android.vending", ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).versionCode >= 80837300;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void endConnection() {
        this.f57594a = 3;
        if (this.f57597d != null) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Unbinding from service.");
            this.f57595b.unbindService(this.f57597d);
            this.f57597d = null;
        }
        this.f57596c = null;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public ReferrerDetails getInstallReferrer() throws RemoteException {
        if (!isReady()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.f57595b.getPackageName());
        try {
            return new ReferrerDetails(this.f57596c.c(bundle));
        } catch (RemoteException e3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "RemoteException getting install referrer information");
            this.f57594a = 0;
            throw e3;
        }
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public boolean isReady() {
        return (this.f57594a != 2 || this.f57596c == null || this.f57597d == null) ? false : true;
    }

    @Override // com.android.installreferrer.api.InstallReferrerClient
    public void startConnection(InstallReferrerStateListener installReferrerStateListener) {
        ServiceInfo serviceInfo;
        if (isReady()) {
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            installReferrerStateListener.onInstallReferrerSetupFinished(0);
            return;
        }
        int i3 = this.f57594a;
        if (i3 == 1) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        if (i3 == 3) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            installReferrerStateListener.onInstallReferrerSetupFinished(3);
            return;
        }
        InstallReferrerCommons.logVerbose("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        List<ResolveInfo> listQueryIntentServices = this.f57595b.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.f57594a = 0;
            InstallReferrerCommons.logVerbose("InstallReferrerClient", "Install Referrer service unavailable on device.");
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if (!"com.android.vending".equals(str) || str2 == null || !c()) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
            this.f57594a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(2);
            return;
        }
        Intent intent2 = new Intent(intent);
        InstallReferrerServiceConnection installReferrerServiceConnection = new InstallReferrerServiceConnection(installReferrerStateListener);
        this.f57597d = installReferrerServiceConnection;
        try {
            if (this.f57595b.bindService(intent2, installReferrerServiceConnection, 1)) {
                InstallReferrerCommons.logVerbose("InstallReferrerClient", "Service was bonded successfully.");
                return;
            }
            InstallReferrerCommons.logWarn("InstallReferrerClient", "Connection to service is blocked.");
            this.f57594a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(1);
        } catch (SecurityException unused) {
            InstallReferrerCommons.logWarn("InstallReferrerClient", "No permission to connect to service.");
            this.f57594a = 0;
            installReferrerStateListener.onInstallReferrerSetupFinished(4);
        }
    }
}
