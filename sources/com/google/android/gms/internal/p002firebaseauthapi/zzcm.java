package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.internal.p002firebaseauthapi.zzwx;
import com.google.android.gms.internal.p002firebaseauthapi.zzxh;
import com.google.android.gms.internal.p002firebaseauthapi.zzxk;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcm {
    static {
        Charset.forName(Utf8Charset.NAME);
    }

    public static zzxk zza(zzxh zzxhVar) {
        zzxk.zza zzaVarZza = zzxk.zza().zza(zzxhVar.zzb());
        for (zzxh.zzb zzbVar : zzxhVar.zze()) {
            zzaVarZza.zza((zzxk.zzb) ((zzalf) zzxk.zzb.zza().zza(zzbVar.zzb().zzf()).zza(zzbVar.zzc()).zza(zzbVar.zzf()).zza(zzbVar.zza()).zze()));
        }
        return (zzxk) ((zzalf) zzaVarZza.zze());
    }

    public static void zzb(zzxh zzxhVar) throws GeneralSecurityException {
        int iZzb = zzxhVar.zzb();
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = true;
        for (zzxh.zzb zzbVar : zzxhVar.zze()) {
            if (zzbVar.zzc() == zzxc.ENABLED) {
                if (!zzbVar.zzg()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.zza())));
                }
                if (zzbVar.zzf() == zzxz.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.zza())));
                }
                if (zzbVar.zzc() == zzxc.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.zza())));
                }
                if (zzbVar.zza() == iZzb) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                if (zzbVar.zzb().zzb() != zzwx.zzb.ASYMMETRIC_PUBLIC) {
                    z3 = false;
                }
                i3++;
            }
        }
        if (i3 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z3) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
