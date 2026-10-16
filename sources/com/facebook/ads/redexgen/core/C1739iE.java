package com.facebook.ads.redexgen.core;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1739iE {
    public static byte[] A03;
    public final C0937Of A00;
    public final InterfaceC1533er A01;
    public final List<C1738iD> A02;

    static {
        A01();
    }

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 36);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-11, -10, -29, -10, -21, -11, -10, -21, -27, -11, -60, -75, -61, -60, -61};
    }

    public C1739iE(List<AbstractC0935Od> list, Bundle bundle, InterfaceC1533er interfaceC1533er) {
        this.A02 = new ArrayList(list.size());
        this.A01 = interfaceC1533er;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A00(10, 5, 76));
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.A02.add(new C1738iD(list.get(i3), (Bundle) parcelableArrayList.get(i3)));
        }
        this.A00 = (C0937Of) AbstractC1170Xo.A00(bundle.getByteArray(A00(0, 10, 126)));
    }

    public C1739iE(List<AbstractC0935Od> list, InterfaceC1533er interfaceC1533er) {
        this.A02 = new ArrayList(list.size());
        this.A01 = interfaceC1533er;
        Iterator<AbstractC0935Od> it = list.iterator();
        while (it.hasNext()) {
            this.A02.add(new C1738iD(it.next()));
        }
        this.A00 = new C0937Of();
    }

    public final Bundle A02() {
        Bundle bundle = new Bundle();
        bundle.putByteArray(A00(0, 10, 126), AbstractC1170Xo.A01(this.A00));
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.A02.size());
        Iterator<C1738iD> it = this.A02.iterator();
        while (it.hasNext()) {
            Bundle bundle2 = it.next().A05();
            arrayList.add(bundle2);
        }
        bundle.putParcelableArrayList(A00(10, 5, 76), arrayList);
        return bundle;
    }

    public final C0937Of A03() {
        return this.A00;
    }

    public final void A04() {
        this.A00.A03();
        Iterator<C1738iD> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A06();
        }
    }

    public final void A05() {
        this.A00.A02();
    }

    public final void A06(double d3, double d4) {
        if (d4 >= 0.0d) {
            this.A00.A05(d3, d4);
        }
        double dA9V = this.A01.A9V();
        this.A00.A04(d3, dA9V);
        Iterator<C1738iD> it = this.A02.iterator();
        while (it.hasNext()) {
            it.next().A07(d3, dA9V);
        }
    }
}
