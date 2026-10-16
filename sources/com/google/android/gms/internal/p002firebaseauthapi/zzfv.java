package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv {
    private static final zzor<zzfz> zza = new zzor() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfy
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzor
        public final zzbi zza(zzcb zzcbVar, Integer num) {
            return zzfw.zza((zzfz) zzcbVar, zzaal.zza(32), num);
        }
    };
    private static final zzps<zzfw, zzba> zzb = zzps.zza(new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfx
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
        public final Object zza(zzbi zzbiVar) {
            return zzib.zza((zzfw) zzbiVar);
        }
    }, zzfw.class, zzba.class);

    public static void zza(boolean z2) throws GeneralSecurityException {
        zzie.zza();
        zzox zzoxVarZza = zzox.zza();
        HashMap map = new HashMap();
        map.put("XAES_256_GCM_192_BIT_NONCE", zzfm.zzg);
        map.put("XAES_256_GCM_192_BIT_NONCE_NO_PREFIX", zzfm.zzh);
        map.put("XAES_256_GCM_160_BIT_NONCE_NO_PREFIX", zzfm.zzi);
        map.put("X_AES_GCM_8_BYTE_SALT_NO_PREFIX", zzfm.zzj);
        zzoxVarZza.zza(Collections.unmodifiableMap(map));
        zzpa.zza().zza(zzb);
        zzop.zza().zza(zza, zzfz.class);
    }
}
