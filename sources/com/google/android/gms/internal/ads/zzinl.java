package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzinl extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzinl(zzbjr zzbjrVar) {
        this.zza = new WeakReference(zzbjrVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbjr zzbjrVar = (zzbjr) this.zza.get();
        if (zzbjrVar != null) {
            zzbjrVar.zzf(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbjr zzbjrVar = (zzbjr) this.zza.get();
        if (zzbjrVar != null) {
            zzbjrVar.zzg();
        }
    }
}
