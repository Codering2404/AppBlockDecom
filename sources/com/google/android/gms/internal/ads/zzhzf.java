package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhzf extends ThreadLocal {
    zzhzf() {
    }

    protected static final Cipher zza() {
        try {
            return (Cipher) zzhzz.zza.zzb("AES/CTR/NOPADDING");
        } catch (GeneralSecurityException e3) {
            throw new IllegalStateException(e3);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
