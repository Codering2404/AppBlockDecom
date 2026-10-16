package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdf implements zzfci {
    final String zza;
    final int zzb;

    /* synthetic */ zzfdf(String str, int i3, byte[] bArr) {
        this.zza = str;
        this.zzb = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlP)).booleanValue()) {
            String str = this.zza;
            if (!TextUtils.isEmpty(str)) {
                bundle.putString("topics", str);
            }
            int i3 = this.zzb;
            if (i3 != -1) {
                bundle.putInt("atps", i3);
            }
        }
    }
}
