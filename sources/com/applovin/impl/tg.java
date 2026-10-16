package com.applovin.impl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class tg {
    public static List a(byte[] bArr) {
        long jB = b(c(bArr));
        long jB2 = b(3840L);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(a(jB));
        arrayList.add(a(jB2));
        return arrayList;
    }

    public static int b(byte[] bArr) {
        return bArr[9] & 255;
    }

    private static int c(byte[] bArr) {
        return (bArr[10] & 255) | ((bArr[11] & 255) << 8);
    }

    private static long b(long j3) {
        return (j3 * 1000000000) / 48000;
    }

    private static byte[] a(long j3) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j3).array();
    }
}
