package com.google.android.gms.internal.ads;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzeam extends zzeaq {
    private long zza;
    private int zzb;
    private byte zzc;

    zzeam() {
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final zzeaq zza(long j3) {
        this.zza = j3;
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final zzeaq zzb(int i3) {
        this.zzb = i3;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeaq
    public final zzear zzc() {
        if (this.zzc == 3) {
            return new zzean(this.zza, this.zzb, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzc & 1) == 0) {
            sb.append(" id");
        }
        if ((this.zzc & 2) == 0) {
            sb.append(rnFwbPAQmQTnL.OqNyEoZHcIq);
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
