package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgtp extends zzgtw {
    final /* synthetic */ zzgsx zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgtp(zzgty zzgtyVar, CharSequence charSequence, zzgsx zzgsxVar) {
        super(zzgtyVar, charSequence);
        this.zza = zzgsxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    final int zzc(int i3) {
        CharSequence charSequence = ((zzgtw) this).zzb;
        int length = charSequence.length();
        zzgtj.zzn(i3, length, "index");
        while (i3 < length) {
            if (this.zza.zzb(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgtw
    final int zzd(int i3) {
        return i3 + 1;
    }
}
