package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbjm extends CustomTabsCallback {
    final /* synthetic */ zzbjp zza;

    zzbjm(zzbjp zzbjpVar) {
        Objects.requireNonNull(zzbjpVar);
        this.zza = zzbjpVar;
    }

    @Override // androidx.browser.customtabs.CustomTabsCallback
    public final void onNavigationEvent(int i3, Bundle bundle) {
        this.zza.zzc(i3);
    }
}
