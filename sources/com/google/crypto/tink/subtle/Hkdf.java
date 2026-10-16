package com.google.crypto.tink.subtle;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class Hkdf {
    public static byte[] a(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, int i3) throws GeneralSecurityException {
        Mac mac = (Mac) EngineFactory.f87433c.a(str);
        if (i3 > mac.getMacLength() * 255) {
            throw new GeneralSecurityException("size too large");
        }
        if (bArr2 == null || bArr2.length == 0) {
            mac.init(new SecretKeySpec(new byte[mac.getMacLength()], str));
        } else {
            mac.init(new SecretKeySpec(bArr2, str));
        }
        byte[] bArr4 = new byte[i3];
        mac.init(new SecretKeySpec(mac.doFinal(bArr), str));
        byte[] bArrDoFinal = new byte[0];
        int i4 = 1;
        int length = 0;
        while (true) {
            mac.update(bArrDoFinal);
            mac.update(bArr3);
            mac.update((byte) i4);
            bArrDoFinal = mac.doFinal();
            if (bArrDoFinal.length + length >= i3) {
                System.arraycopy(bArrDoFinal, 0, bArr4, length, i3 - length);
                return bArr4;
            }
            System.arraycopy(bArrDoFinal, 0, bArr4, length, bArrDoFinal.length);
            length += bArrDoFinal.length;
            i4++;
        }
    }
}
