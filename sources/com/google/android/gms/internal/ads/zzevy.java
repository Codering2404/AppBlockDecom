package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevy implements zzfci {
    final String zza;
    final int zzb;

    public zzevy(String str, int i3) {
        this.zza = str;
        this.zzb = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        int i3;
        String str = this.zza;
        Bundle bundle = (Bundle) obj;
        if (TextUtils.isEmpty(str) || (i3 = this.zzb) == -1) {
            return;
        }
        Bundle bundleZza = zzfln.zza(bundle, "pii");
        bundle.putBundle("pii", bundleZza);
        bundleZza.putString("pvid", str);
        bundleZza.putInt("pvid_s", i3);
    }
}
