package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zziv;
import com.google.android.gms.internal.p002firebaseauthapi.zzrh;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzre {
    private static final zzps<zzra, zzqw> zza = zzps.zza(new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrd
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
        public final Object zza(zzbi zzbiVar) {
            return new zzsg((zzra) zzbiVar);
        }
    }, zzra.class, zzqw.class);
    private static final zzps<zzra, zzcc> zzb = zzps.zza(new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
        public final Object zza(zzbi zzbiVar) {
            return zzaag.zza((zzra) zzbiVar);
        }
    }, zzra.class, zzcc.class);
    private static final zzbh<zzcc> zzc = zzod.zza("type.googleapis.com/google.crypto.tink.HmacKey", zzcc.class, zzwx.zzb.SYMMETRIC, zzwb.zzg());
    private static final zzot<zzrh> zzd = new zzot() { // from class: com.google.android.gms.internal.firebase-auth-api.zzrf
    };
    private static final zzor<zzrh> zze = new zzor() { // from class: com.google.android.gms.internal.firebase-auth-api.zzri
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzor
        public final zzbi zza(zzcb zzcbVar, Integer num) {
            return zzre.zza((zzrh) zzcbVar, num);
        }
    };
    private static final zziv.zza zzf = zziv.zza.zzb;

    static zzra zza(zzrh zzrhVar, @Nullable Integer num) throws GeneralSecurityException {
        return zzra.zzc().zza(zzrhVar).zza(zzaal.zza(zzrhVar.zzc())).zza(num).zza();
    }

    public static void zza(boolean z2) throws GeneralSecurityException {
        zziv.zza zzaVar = zzf;
        if (zzaVar.zza()) {
            zzsj.zza();
            zzpa.zza().zza(zza);
            zzpa.zza().zza(zzb);
            zzox zzoxVarZza = zzox.zza();
            HashMap map = new HashMap();
            map.put("HMAC_SHA256_128BITTAG", zzrt.zza);
            zzrh.zzb zzbVarZzb = zzrh.zzd().zza(32).zzb(16);
            zzrh.zzc zzcVar = zzrh.zzc.zzd;
            zzrh.zzb zzbVarZza = zzbVarZzb.zza(zzcVar);
            zzrh.zza zzaVar2 = zzrh.zza.zzc;
            map.put("HMAC_SHA256_128BITTAG_RAW", zzbVarZza.zza(zzaVar2).zza());
            zzrh.zzb zzbVarZzb2 = zzrh.zzd().zza(32).zzb(32);
            zzrh.zzc zzcVar2 = zzrh.zzc.zza;
            map.put("HMAC_SHA256_256BITTAG", zzbVarZzb2.zza(zzcVar2).zza(zzaVar2).zza());
            map.put("HMAC_SHA256_256BITTAG_RAW", zzrh.zzd().zza(32).zzb(32).zza(zzcVar).zza(zzaVar2).zza());
            zzrh.zzb zzbVarZza2 = zzrh.zzd().zza(64).zzb(16).zza(zzcVar2);
            zzrh.zza zzaVar3 = zzrh.zza.zze;
            map.put("HMAC_SHA512_128BITTAG", zzbVarZza2.zza(zzaVar3).zza());
            map.put("HMAC_SHA512_128BITTAG_RAW", zzrh.zzd().zza(64).zzb(16).zza(zzcVar).zza(zzaVar3).zza());
            map.put("HMAC_SHA512_256BITTAG", zzrh.zzd().zza(64).zzb(32).zza(zzcVar2).zza(zzaVar3).zza());
            map.put("HMAC_SHA512_256BITTAG_RAW", zzrh.zzd().zza(64).zzb(32).zza(zzcVar).zza(zzaVar3).zza());
            map.put("HMAC_SHA512_512BITTAG", zzrt.zzb);
            map.put("HMAC_SHA512_512BITTAG_RAW", zzrh.zzd().zza(64).zzb(64).zza(zzcVar).zza(zzaVar3).zza());
            zzoxVarZza.zza(Collections.unmodifiableMap(map));
            zzop.zza().zza(zze, zzrh.class);
            zzou.zza().zza(zzd, zzrh.class);
            zznq.zza().zza((zzbh) zzc, zzaVar, true);
            return;
        }
        throw new GeneralSecurityException("Can not use HMAC in FIPS-mode, as BoringCrypto module is not available.");
    }
}
