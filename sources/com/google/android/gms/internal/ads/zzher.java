package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzher implements zzhdn {
    zzher() {
    }

    @Override // com.google.android.gms.internal.ads.zzhdn
    public final Object zza(zzhec zzhecVar, Class cls) throws GeneralSecurityException {
        if (cls == zzhdi.class) {
            return cls.cast(zzhjy.zza(zzhecVar, zzheq.zza));
        }
        throw new GeneralSecurityException("AeadConfigurationV1 can only create AEADs");
    }
}
