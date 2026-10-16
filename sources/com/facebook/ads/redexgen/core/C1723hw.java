package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1723hw implements QD {
    public final /* synthetic */ C7Q A00;
    public final /* synthetic */ Q8 A01;

    public C1723hw(C7Q c7q, Q8 q8) {
        this.A00 = c7q;
        this.A01 = q8;
    }

    @Override // com.facebook.ads.redexgen.core.QD
    public final Object A5G(int i3) {
        Q6 compatInfo = this.A01.A00(i3);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.facebook.ads.redexgen.core.QD
    public final List<Object> A6Y(String str, int i3) {
        List<Q6> listA03 = this.A01.A03(str, i3);
        if (listA03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int infoCount = listA03.size();
        for (int i4 = 0; i4 < infoCount; i4++) {
            arrayList.add(listA03.get(i4).A0M());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.core.QD
    public final Object A6Z(int i3) {
        Q6 compatInfo = this.A01.A01(i3);
        if (compatInfo == null) {
            return null;
        }
        return compatInfo.A0M();
    }

    @Override // com.facebook.ads.redexgen.core.QD
    public final boolean AGv(int i3, int i4, Bundle bundle) {
        return this.A01.A04(i3, i4, bundle);
    }
}
