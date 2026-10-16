package com.appsflyer.internal;

/* JADX INFO: loaded from: classes4.dex */
public class AFg1rSDK {
    public static void AFInAppEventParameterName(byte[] bArr, byte b3, long j3) {
        for (int i3 = 0; i3 < bArr.length; i3++) {
            if (((1 << i3) & j3) != 0) {
                bArr[i3] = (byte) (bArr[i3] ^ b3);
            }
        }
    }
}
