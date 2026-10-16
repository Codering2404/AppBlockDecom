package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyv extends ThreadLocal<Cipher> {
    zzyv() {
    }

    private static Cipher zza() {
        try {
            return zzzj.zza.zza("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return zza();
    }
}
