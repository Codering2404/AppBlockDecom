package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhk implements zzgy {
    private final zzhb zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    zzhk(zzhb zzhbVar, String str, Object[] objArr) {
        this.zza = zzhbVar;
        this.zzb = str;
        this.zzc = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.zzd = cCharAt;
            return;
        }
        int i3 = cCharAt & 8191;
        int i4 = 1;
        int i5 = 13;
        while (true) {
            int i6 = i4 + 1;
            char cCharAt2 = str.charAt(i4);
            if (cCharAt2 < 55296) {
                this.zzd = i3 | (cCharAt2 << i5);
                return;
            } else {
                i3 |= (cCharAt2 & 8191) << i5;
                i5 += 13;
                i4 = i6;
            }
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzgy
    public final zzhb zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgy
    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzgy
    public final int zzc() {
        int i3 = this.zzd;
        if ((i3 & 1) != 0) {
            return 1;
        }
        return (i3 & 4) == 4 ? 3 : 2;
    }

    final String zzd() {
        return this.zzb;
    }

    final Object[] zze() {
        return this.zzc;
    }
}
