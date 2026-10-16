package com.applovin.impl;

import com.applovin.impl.yf;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f64527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64530d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f64531e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f64532f;

    private w1(List list, int i3, int i4, int i5, float f3, String str) {
        this.f64527a = list;
        this.f64528b = i3;
        this.f64529c = i4;
        this.f64530d = i5;
        this.f64531e = f3;
        this.f64532f = str;
    }

    private static byte[] a(ah ahVar) {
        int iC = ahVar.C();
        int iD = ahVar.d();
        ahVar.g(iC);
        return o3.a(ahVar.c(), iD, iC);
    }

    public static w1 b(ah ahVar) throws ch {
        float f3;
        String strA;
        int i3;
        int i4;
        try {
            ahVar.g(4);
            int iW = (ahVar.w() & 3) + 1;
            if (iW == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iW2 = ahVar.w() & 31;
            for (int i5 = 0; i5 < iW2; i5++) {
                arrayList.add(a(ahVar));
            }
            int iW3 = ahVar.w();
            for (int i6 = 0; i6 < iW3; i6++) {
                arrayList.add(a(ahVar));
            }
            if (iW2 > 0) {
                yf.b bVarC = yf.c((byte[]) arrayList.get(0), iW, ((byte[]) arrayList.get(0)).length);
                int i7 = bVarC.f65203e;
                int i8 = bVarC.f65204f;
                f3 = bVarC.f65205g;
                strA = o3.a(bVarC.f65199a, bVarC.f65200b, bVarC.f65201c);
                i3 = i7;
                i4 = i8;
            } else {
                f3 = 1.0f;
                strA = null;
                i3 = -1;
                i4 = -1;
            }
            return new w1(arrayList, iW, i3, i4, f3, strA);
        } catch (ArrayIndexOutOfBoundsException e3) {
            throw ch.a("Error parsing AVC config", e3);
        }
    }
}
