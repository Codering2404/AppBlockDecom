package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzch {
    private static final zzch zza = new zzch();

    private zzch() {
    }

    static zzch zza() {
        return zza;
    }

    public static zzch zza(@Nullable zzch zzchVar) throws GeneralSecurityException {
        if (zzchVar != null) {
            return zzchVar;
        }
        throw new GeneralSecurityException("SecretKeyAccess is required");
    }
}
