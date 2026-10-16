package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzs extends zzv {
    final /* synthetic */ zzp zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzs(zzw zzwVar, CharSequence charSequence, zzp zzpVar) {
        super(zzwVar, charSequence);
        this.zza = zzpVar;
    }

    @Override // com.google.android.gms.internal.common.zzv
    final int zzc(int i3) {
        CharSequence charSequence = ((zzv) this).zzb;
        int length = charSequence.length();
        zzr.zzc(i3, length, "index");
        while (i3 < length) {
            if (this.zza.zza(charSequence.charAt(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.common.zzv
    final int zzd(int i3) {
        return i3 + 1;
    }
}
