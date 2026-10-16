package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Splitter;
import com.applovin.impl.jk;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class mj {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Splitter f61898d = Splitter.on(':');

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Splitter f61899e = Splitter.on('*');

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f61900a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f61901b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f61902c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f61903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f61904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f61905c;

        public a(int i3, long j3, int i4) {
            this.f61903a = i3;
            this.f61904b = j3;
            this.f61905c = i4;
        }
    }

    private void a(k8 k8Var, th thVar) {
        ah ahVar = new ah(8);
        k8Var.d(ahVar.c(), 0, 8);
        this.f61902c = ahVar.m() + 8;
        if (ahVar.j() != 1397048916) {
            thVar.f63943a = 0L;
        } else {
            thVar.f63943a = k8Var.f() - ((long) (this.f61902c - 12));
            this.f61901b = 2;
        }
    }

    private void b(k8 k8Var, th thVar) {
        long jA = k8Var.a();
        int i3 = this.f61902c - 20;
        ah ahVar = new ah(i3);
        k8Var.d(ahVar.c(), 0, i3);
        for (int i4 = 0; i4 < i3 / 12; i4++) {
            ahVar.g(2);
            short sO = ahVar.o();
            if (sO == 2192 || sO == 2816 || sO == 2817 || sO == 2819 || sO == 2820) {
                this.f61900a.add(new a(sO, (jA - ((long) this.f61902c)) - ((long) ahVar.m()), ahVar.m()));
            } else {
                ahVar.g(8);
            }
        }
        if (this.f61900a.isEmpty()) {
            thVar.f63943a = 0L;
        } else {
            this.f61901b = 3;
            thVar.f63943a = ((a) this.f61900a.get(0)).f61904b;
        }
    }

    private static int a(String str) throws ch {
        str.getClass();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw ch.a("Invalid SEF name", null);
        }
    }

    public int a(k8 k8Var, th thVar, List list) throws ch {
        int i3 = this.f61901b;
        long j3 = 0;
        if (i3 == 0) {
            long jA = k8Var.a();
            if (jA != -1 && jA >= 8) {
                j3 = jA - 8;
            }
            thVar.f63943a = j3;
            this.f61901b = 1;
        } else if (i3 == 1) {
            a(k8Var, thVar);
        } else if (i3 == 2) {
            b(k8Var, thVar);
        } else if (i3 == 3) {
            a(k8Var, list);
            thVar.f63943a = 0L;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    private void a(k8 k8Var, List list) throws ch {
        long jF = k8Var.f();
        int iA = (int) ((k8Var.a() - k8Var.f()) - ((long) this.f61902c));
        ah ahVar = new ah(iA);
        k8Var.d(ahVar.c(), 0, iA);
        for (int i3 = 0; i3 < this.f61900a.size(); i3++) {
            a aVar = (a) this.f61900a.get(i3);
            ahVar.f((int) (aVar.f61904b - jF));
            ahVar.g(4);
            int iM = ahVar.m();
            int iA2 = a(ahVar.c(iM));
            int i4 = aVar.f61905c - (iM + 8);
            if (iA2 == 2192) {
                list.add(a(ahVar, i4));
            } else if (iA2 != 2816 && iA2 != 2817 && iA2 != 2819 && iA2 != 2820) {
                throw new IllegalStateException();
            }
        }
    }

    private static jk a(ah ahVar, int i3) throws ch {
        ArrayList arrayList = new ArrayList();
        List<String> listSplitToList = f61899e.splitToList(ahVar.c(i3));
        for (int i4 = 0; i4 < listSplitToList.size(); i4++) {
            List<String> listSplitToList2 = f61898d.splitToList(listSplitToList.get(i4));
            if (listSplitToList2.size() == 3) {
                try {
                    arrayList.add(new jk.b(Long.parseLong(listSplitToList2.get(0)), Long.parseLong(listSplitToList2.get(1)), 1 << (Integer.parseInt(listSplitToList2.get(2)) - 1)));
                } catch (NumberFormatException e3) {
                    throw ch.a(null, e3);
                }
            } else {
                throw ch.a(null, null);
            }
        }
        return new jk(arrayList);
    }

    public void a() {
        this.f61900a.clear();
        this.f61901b = 0;
    }
}
