package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzaa extends zzd<String> {
    final CharSequence zza;
    private final zzf zzb;
    private int zze;
    private int zzd = 0;
    private final boolean zzc = false;

    zzaa(zzt zztVar, CharSequence charSequence) {
        this.zzb = zztVar.zza;
        this.zze = zztVar.zzc;
        this.zza = charSequence;
    }

    abstract int zza(int i3);

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzd
    protected final /* synthetic */ String zza() {
        int i3 = this.zzd;
        while (true) {
            int i4 = this.zzd;
            if (i4 == -1) {
                zzb();
                return null;
            }
            int iZzb = zzb(i4);
            if (iZzb == -1) {
                iZzb = this.zza.length();
                this.zzd = -1;
            } else {
                this.zzd = zza(iZzb);
            }
            int i5 = this.zzd;
            if (i5 != i3) {
                while (i3 < iZzb && this.zzb.zza(this.zza.charAt(i3))) {
                    i3++;
                }
                while (iZzb > i3 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                    iZzb--;
                }
                int i6 = this.zze;
                if (i6 == 1) {
                    iZzb = this.zza.length();
                    this.zzd = -1;
                    while (iZzb > i3 && this.zzb.zza(this.zza.charAt(iZzb - 1))) {
                        iZzb--;
                    }
                } else {
                    this.zze = i6 - 1;
                }
                return this.zza.subSequence(i3, iZzb).toString();
            }
            int i7 = i5 + 1;
            this.zzd = i7;
            if (i7 > this.zza.length()) {
                this.zzd = -1;
            }
        }
    }

    abstract int zzb(int i3);
}
