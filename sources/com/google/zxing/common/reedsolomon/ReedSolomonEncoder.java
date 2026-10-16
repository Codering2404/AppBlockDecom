package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ReedSolomonEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final GenericGF f91838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f91839b;

    public ReedSolomonEncoder(GenericGF genericGF) {
        this.f91838a = genericGF;
        ArrayList arrayList = new ArrayList();
        this.f91839b = arrayList;
        arrayList.add(new GenericGFPoly(genericGF, new int[]{1}));
    }

    private GenericGFPoly a(int i3) {
        if (i3 >= this.f91839b.size()) {
            List list = this.f91839b;
            GenericGFPoly genericGFPolyG = (GenericGFPoly) list.get(list.size() - 1);
            for (int size = this.f91839b.size(); size <= i3; size++) {
                GenericGF genericGF = this.f91838a;
                genericGFPolyG = genericGFPolyG.g(new GenericGFPoly(genericGF, new int[]{1, genericGF.c((size - 1) + genericGF.d())}));
                this.f91839b.add(genericGFPolyG);
            }
        }
        return (GenericGFPoly) this.f91839b.get(i3);
    }

    public void b(int[] iArr, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i3;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        GenericGFPoly genericGFPolyA = a(i3);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrD = new GenericGFPoly(this.f91838a, iArr2).h(i3, 1).b(genericGFPolyA)[1].d();
        int length2 = i3 - iArrD.length;
        for (int i4 = 0; i4 < length2; i4++) {
            iArr[length + i4] = 0;
        }
        System.arraycopy(iArrD, 0, iArr, length + length2, iArrD.length);
    }
}
