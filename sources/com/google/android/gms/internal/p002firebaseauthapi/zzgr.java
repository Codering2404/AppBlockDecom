package com.google.android.gms.internal.p002firebaseauthapi;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgr {
    private static final ThreadLocal<Cipher> zza = new zzgu();

    public static AlgorithmParameterSpec zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public static SecretKey zzb(byte[] bArr) throws GeneralSecurityException {
        zzaai.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec zza(byte[] bArr, int i3, int i4) {
        Integer numZzb = zzqn.zzb();
        return (numZzb == null || numZzb.intValue() > 19) ? new GCMParameterSpec(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, bArr, i3, i4) : new IvParameterSpec(bArr, i3, i4);
    }

    public static Cipher zza() {
        return zza.get();
    }
}
