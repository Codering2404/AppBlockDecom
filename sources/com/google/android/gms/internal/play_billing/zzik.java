package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzik {
    protected static final int zza(String str, byte[] bArr, int i3, int i4) {
        byte[] bytes = str.getBytes(zzga.zza);
        int length = bytes.length;
        if (length - i3 > i4) {
            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
        }
        System.arraycopy(bytes, 0, bArr, i3, length);
        return i3 + length;
    }
}
