package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class na {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f61992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f61994c;

    private na(List list, int i3, String str) {
        this.f61992a = list;
        this.f61993b = i3;
        this.f61994c = str;
    }

    public static na a(ah ahVar) throws ch {
        try {
            ahVar.g(21);
            int iW = ahVar.w() & 3;
            int iW2 = ahVar.w();
            int iD = ahVar.d();
            int i3 = 0;
            for (int i4 = 0; i4 < iW2; i4++) {
                ahVar.g(1);
                int iC = ahVar.C();
                for (int i5 = 0; i5 < iC; i5++) {
                    int iC2 = ahVar.C();
                    i3 += iC2 + 4;
                    ahVar.g(iC2);
                }
            }
            ahVar.f(iD);
            byte[] bArr = new byte[i3];
            int i6 = 0;
            String strA = null;
            for (int i7 = 0; i7 < iW2; i7++) {
                int iW3 = ahVar.w() & 127;
                int iC3 = ahVar.C();
                for (int i8 = 0; i8 < iC3; i8++) {
                    int iC4 = ahVar.C();
                    byte[] bArr2 = yf.f65192a;
                    System.arraycopy(bArr2, 0, bArr, i6, bArr2.length);
                    int length = i6 + bArr2.length;
                    System.arraycopy(ahVar.c(), ahVar.d(), bArr, length, iC4);
                    if (iW3 == 33 && i8 == 0) {
                        strA = o3.a(new bh(bArr, length, length + iC4));
                    }
                    i6 = length + iC4;
                    ahVar.g(iC4);
                }
            }
            return new na(i3 == 0 ? null : Collections.singletonList(bArr), iW + 1, strA);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw ch.a("Error parsing HEVC config", e3);
        }
    }
}
