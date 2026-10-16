package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import androidx.browser.customtabs.CustomTabsSession;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbjp extends CustomTabsServiceConnection {
    public static final /* synthetic */ int zza = 0;
    private final AtomicBoolean zzb = new AtomicBoolean(false);
    private Context zzc;
    private zzdzl zzd;
    private CustomTabsSession zze;
    private CustomTabsClient zzf;

    private final void zzf(Context context) {
        String strD;
        if (this.zzf != null || context == null || (strD = CustomTabsClient.d(context, null)) == null || strD.equals(context.getPackageName())) {
            return;
        }
        CustomTabsClient.a(context, strD, this);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        this.zzf = customTabsClient;
        customTabsClient.h(0L);
        this.zze = customTabsClient.f(new zzbjm(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.zzf = null;
        this.zze = null;
    }

    public final void zza(Context context, zzdzl zzdzlVar) {
        if (this.zzb.getAndSet(true)) {
            return;
        }
        this.zzc = context;
        this.zzd = zzdzlVar;
        zzf(context);
    }

    public final CustomTabsSession zzb() {
        if (this.zze == null) {
            zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbjo
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd();
                }
            });
        }
        return this.zze;
    }

    public final void zzc(final int i3) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzfz)).booleanValue() || this.zzd == null) {
            return;
        }
        zzcfr.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbjn
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze(i3);
            }
        });
    }

    final /* synthetic */ void zzd() {
        zzf(this.zzc);
    }

    final /* synthetic */ void zze(int i3) {
        zzdzl zzdzlVar = this.zzd;
        if (zzdzlVar != null) {
            zzdzk zzdzkVarZza = zzdzlVar.zza();
            zzdzkVarZza.zzc("action", "cct_nav");
            zzdzkVarZza.zzc("cct_navs", String.valueOf(i3));
            zzdzkVarZza.zzd();
        }
    }
}
