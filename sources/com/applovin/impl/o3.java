package com.applovin.impl;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f62170a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String[] f62171b = {"", "A", "B", "C"};

    public static String a(int i3, int i4, int i5) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public static List a(boolean z2) {
        return Collections.singletonList(z2 ? new byte[]{1} : new byte[]{0});
    }

    public static String a(bh bhVar) {
        bhVar.d(24);
        int iB = bhVar.b(2);
        boolean zC = bhVar.c();
        int iB2 = bhVar.b(5);
        int i3 = 0;
        for (int i4 = 0; i4 < 32; i4++) {
            if (bhVar.c()) {
                i3 |= 1 << i4;
            }
        }
        int i5 = 6;
        int[] iArr = new int[6];
        for (int i6 = 0; i6 < 6; i6++) {
            iArr[i6] = bhVar.b(8);
        }
        StringBuilder sb = new StringBuilder(xp.a("hvc1.%s%d.%X.%c%d", f62171b[iB], Integer.valueOf(iB2), Integer.valueOf(i3), Character.valueOf(zC ? 'H' : 'L'), Integer.valueOf(bhVar.b(8))));
        while (i5 > 0 && iArr[i5 - 1] == 0) {
            i5--;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i7])));
        }
        return sb.toString();
    }

    public static byte[] a(byte[] bArr, int i3, int i4) {
        byte[] bArr2 = f62170a;
        byte[] bArr3 = new byte[bArr2.length + i4];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i3, bArr3, bArr2.length, i4);
        return bArr3;
    }

    public static boolean a(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    public static Pair a(byte[] bArr) {
        ah ahVar = new ah(bArr);
        ahVar.f(9);
        int iW = ahVar.w();
        ahVar.f(20);
        return Pair.create(Integer.valueOf(ahVar.A()), Integer.valueOf(iW));
    }
}
