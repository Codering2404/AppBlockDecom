package com.facebook.stetho.websocket;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class MaskingHelper {
    MaskingHelper() {
    }

    public static void unmask(byte[] bArr, byte[] bArr2, int i3, int i4) {
        int i5 = 0;
        while (true) {
            int i6 = i4 - 1;
            if (i4 <= 0) {
                return;
            }
            bArr2[i3] = (byte) (bArr[i5 % bArr.length] ^ bArr2[i3]);
            i3++;
            i4 = i6;
            i5++;
        }
    }
}
