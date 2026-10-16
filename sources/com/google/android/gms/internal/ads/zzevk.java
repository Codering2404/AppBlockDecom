package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzevk implements zzfci {
    private final String zza;
    private final boolean zzb;

    public zzevk(String str, boolean z2) {
        this.zza = str;
        this.zzb = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        String str = this.zza;
        Bundle bundle = (Bundle) obj;
        if (str != null) {
            Bundle bundleZza = zzfln.zza(bundle, jTYhJgqLBN.KSTFxoAWPsgMU);
            bundleZza.putString("afai", str);
            bundleZza.putBoolean("is_afai_lat", this.zzb);
        }
    }
}
