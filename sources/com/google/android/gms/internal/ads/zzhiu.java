package com.google.android.gms.internal.ads;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhiu {
    private static final ThreadLocal zza = new zzhit();

    public static Cipher zza() {
        return (Cipher) zza.get();
    }

    public static SecretKey zzb(byte[] bArr) throws GeneralSecurityException {
        zziax.zza(bArr.length);
        return new SecretKeySpec(bArr, "AES");
    }

    public static AlgorithmParameterSpec zzc(byte[] bArr, int i3, int i4) {
        zzhnz.zzd();
        return new GCMParameterSpec(ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, bArr, i3, 12);
    }
}
