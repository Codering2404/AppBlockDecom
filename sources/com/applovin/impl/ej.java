package com.applovin.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ej extends xl {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f59516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long[] f59517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long[] f59518d;

    public ej() {
        super(new h7());
        this.f59516b = -9223372036854775807L;
        this.f59517c = new long[0];
        this.f59518d = new long[0];
    }

    private static Double d(ah ahVar) {
        return Double.valueOf(Double.longBitsToDouble(ahVar.s()));
    }

    private static HashMap e(ah ahVar) {
        int iA = ahVar.A();
        HashMap map = new HashMap(iA);
        for (int i3 = 0; i3 < iA; i3++) {
            String strH = h(ahVar);
            Object objA = a(ahVar, i(ahVar));
            if (objA != null) {
                map.put(strH, objA);
            }
        }
        return map;
    }

    private static HashMap f(ah ahVar) {
        HashMap map = new HashMap();
        while (true) {
            String strH = h(ahVar);
            int i3 = i(ahVar);
            if (i3 == 9) {
                return map;
            }
            Object objA = a(ahVar, i3);
            if (objA != null) {
                map.put(strH, objA);
            }
        }
    }

    private static ArrayList g(ah ahVar) {
        int iA = ahVar.A();
        ArrayList arrayList = new ArrayList(iA);
        for (int i3 = 0; i3 < iA; i3++) {
            Object objA = a(ahVar, i(ahVar));
            if (objA != null) {
                arrayList.add(objA);
            }
        }
        return arrayList;
    }

    private static String h(ah ahVar) {
        int iC = ahVar.C();
        int iD = ahVar.d();
        ahVar.g(iC);
        return new String(ahVar.c(), iD, iC);
    }

    private static int i(ah ahVar) {
        return ahVar.w();
    }

    @Override // com.applovin.impl.xl
    protected boolean a(ah ahVar) {
        return true;
    }

    public long[] b() {
        return this.f59518d;
    }

    public long[] c() {
        return this.f59517c;
    }

    private static Date c(ah ahVar) {
        Date date = new Date((long) d(ahVar).doubleValue());
        ahVar.g(2);
        return date;
    }

    public long a() {
        return this.f59516b;
    }

    @Override // com.applovin.impl.xl
    protected boolean b(ah ahVar, long j3) {
        if (i(ahVar) != 2 || !"onMetaData".equals(h(ahVar)) || i(ahVar) != 8) {
            return false;
        }
        HashMap mapE = e(ahVar);
        Object obj = mapE.get("duration");
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (dDoubleValue > 0.0d) {
                this.f59516b = (long) (dDoubleValue * 1000000.0d);
            }
        }
        Object obj2 = mapE.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f59517c = new long[size];
                this.f59518d = new long[size];
                for (int i3 = 0; i3 < size; i3++) {
                    Object obj5 = list.get(i3);
                    Object obj6 = list2.get(i3);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f59517c = new long[0];
                        this.f59518d = new long[0];
                        break;
                    }
                    this.f59517c[i3] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f59518d[i3] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    private static Object a(ah ahVar, int i3) {
        if (i3 == 8) {
            return e(ahVar);
        }
        if (i3 == 10) {
            return g(ahVar);
        }
        if (i3 == 11) {
            return c(ahVar);
        }
        if (i3 == 0) {
            return d(ahVar);
        }
        if (i3 == 1) {
            return b(ahVar);
        }
        if (i3 == 2) {
            return h(ahVar);
        }
        if (i3 != 3) {
            return null;
        }
        return f(ahVar);
    }

    private static Boolean b(ah ahVar) {
        return Boolean.valueOf(ahVar.w() == 1);
    }
}
