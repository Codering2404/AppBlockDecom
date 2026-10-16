package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import androidx.core.os.BuildCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzarz extends zzarx {
    private int zza = 0;
    private final Context zzb;
    private final String zzc;
    private zzbej zzd;
    private ServiceConnection zze;

    public zzarz(Context context) {
        this.zzb = context.getApplicationContext();
        String packageName = (BuildCompat.c() && SdkExtensions.getExtensionVersion(34) >= 8 && Process.isSdkSandbox()) ? i.a(context.getSystemService(h.a())).getClientPackageName() : context.getPackageName();
        this.zzc = packageName;
    }

    @Override // com.google.android.gms.internal.ads.zzarx
    public final boolean zza() {
        return (this.zza != 2 || this.zzd == null || this.zze == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzarx
    public final void zzb(zzasa zzasaVar) {
        ServiceInfo serviceInfo;
        if (zza()) {
            zzasc.zza("InstallReferrerClient", "Service connection is valid. No need to re-initialize.");
            zzasaVar.zza(0);
            return;
        }
        int i3 = this.zza;
        if (i3 == 1) {
            zzasc.zzb("InstallReferrerClient", "Client is already in the process of connecting to the service.");
            zzasaVar.zza(3);
            return;
        }
        if (i3 == 3) {
            zzasc.zzb("InstallReferrerClient", "Client was already closed and can't be reused. Please create another instance.");
            zzasaVar.zza(3);
            return;
        }
        zzasc.zza("InstallReferrerClient", "Starting install referrer service setup.");
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        Context context = this.zzb;
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty() || (serviceInfo = listQueryIntentServices.get(0).serviceInfo) == null) {
            this.zza = 0;
            zzasc.zza("InstallReferrerClient", "Install Referrer service unavailable on device.");
            zzasaVar.zza(2);
            return;
        }
        String str = serviceInfo.packageName;
        String str2 = serviceInfo.name;
        if ("com.android.vending".equals(str) && str2 != null) {
            try {
                if (context.getPackageManager().getPackageInfo("com.android.vending", ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD).versionCode >= 80837300) {
                    Intent intent2 = new Intent(intent);
                    zzary zzaryVar = new zzary(this, zzasaVar, null);
                    this.zze = zzaryVar;
                    try {
                        if (this.zzb.bindService(intent2, zzaryVar, 1)) {
                            zzasc.zza("InstallReferrerClient", "Service was bonded successfully.");
                            return;
                        }
                        zzasc.zzb("InstallReferrerClient", "Connection to service is blocked.");
                        this.zza = 0;
                        zzasaVar.zza(1);
                        return;
                    } catch (SecurityException unused) {
                        zzasc.zzb("InstallReferrerClient", "No permission to connect to service.");
                        this.zza = 0;
                        zzasaVar.zza(4);
                        return;
                    }
                }
            } catch (PackageManager.NameNotFoundException unused2) {
            }
        }
        zzasc.zzb("InstallReferrerClient", "Play Store missing or incompatible. Version 8.3.73 or later required.");
        this.zza = 0;
        zzasaVar.zza(2);
    }

    @Override // com.google.android.gms.internal.ads.zzarx
    public final void zzc() {
        this.zza = 3;
        if (this.zze != null) {
            zzasc.zza("InstallReferrerClient", "Unbinding from service.");
            this.zzb.unbindService(this.zze);
            this.zze = null;
        }
        this.zzd = null;
    }

    @Override // com.google.android.gms.internal.ads.zzarx
    public final zzasb zzd() throws RemoteException {
        if (!zza()) {
            throw new IllegalStateException("Service not connected. Please start a connection before using the service.");
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", this.zzc);
        try {
            return new zzasb(this.zzd.zze(bundle));
        } catch (RemoteException e3) {
            zzasc.zzb("InstallReferrerClient", "RemoteException getting install referrer information");
            this.zza = 0;
            throw e3;
        }
    }

    final /* synthetic */ void zze(int i3) {
        this.zza = i3;
    }

    final /* synthetic */ void zzf(zzbej zzbejVar) {
        this.zzd = zzbejVar;
    }
}
