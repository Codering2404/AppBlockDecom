package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Security;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhkv {
    private static final String[] zza = {"GmsCore_OpenSSL", "AndroidOpenSSL", "Conscrypt"};

    @Nullable
    public static Provider zza() {
        String[] strArr = zza;
        for (int i3 = 0; i3 < 3; i3++) {
            Provider provider = Security.getProvider(strArr[i3]);
            if (provider != null) {
                return provider;
            }
        }
        return null;
    }
}
