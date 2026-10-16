package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzod<P> implements zzbh<P> {
    final String zza;
    final zzwx.zzb zzb;
    private final Class<P> zzc;

    zzod(String str, Class<P> cls, zzwx.zzb zzbVar, zzamv<? extends zzamm> zzamvVar) {
        this.zza = str;
        this.zzc = cls;
        this.zzb = zzbVar;
    }

    public static <P> zzbh<P> zza(String str, Class<P> cls, zzwx.zzb zzbVar, zzamv<? extends zzamm> zzamvVar) {
        return new zzod(str, cls, zzbVar, zzamvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final P zzb(zzajv zzajvVar) throws GeneralSecurityException {
        return (P) zzpa.zza().zza(zzoz.zza().zza(zzqb.zza(this.zza, zzajvVar, this.zzb, zzxz.RAW, null), zzbf.zza()), this.zzc);
    }

    public static <P> zzcd<P> zza(String str, Class<P> cls, zzamv<? extends zzamm> zzamvVar) {
        return new zzoc(str, cls, zzamvVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final zzwx zza(zzajv zzajvVar) throws GeneralSecurityException {
        zzqb zzqbVar = (zzqb) zzoz.zza().zza(zzop.zza().zza(zzoz.zza().zza(zzqe.zza((zzxb) ((zzalf) zzxb.zza().zza(this.zza).zza(zzajvVar).zza(zzxz.RAW).zze()))), (Integer) null), zzqb.class, zzbf.zza());
        return (zzwx) ((zzalf) zzwx.zza().zza(zzqbVar.zzf()).zza(zzqbVar.zzd()).zza(zzqbVar.zza()).zze());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final String zzb() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbh
    public final Class<P> zza() {
        return this.zzc;
    }
}
