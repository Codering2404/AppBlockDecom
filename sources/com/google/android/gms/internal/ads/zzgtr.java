package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgtr extends zzgtw {
    zzgtr(zzgty zzgtyVar, CharSequence charSequence, int i3) {
        super(zzgtyVar, charSequence);
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzc(int i3) {
        int i4 = i3 + 4000;
        if (i4 < ((zzgtw) this).zzb.length()) {
            return i4;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    public final int zzd(int i3) {
        return i3;
    }
}
