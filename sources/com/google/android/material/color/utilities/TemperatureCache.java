package com.google.android.material.color.utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class TemperatureCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Hct f80677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f80678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f80679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map f80680d;

    public TemperatureCache(Hct hct) {
        this.f80677a = hct;
    }

    public static /* synthetic */ Double a(TemperatureCache temperatureCache, Hct hct) {
        return (Double) temperatureCache.g().get(hct);
    }

    private Hct c() {
        return (Hct) e().get(0);
    }

    private List d() {
        List list = this.f80679c;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (double d3 = 0.0d; d3 <= 360.0d; d3 += 1.0d) {
            arrayList.add(Hct.a(d3, this.f80677a.c(), this.f80677a.e()));
        }
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f80679c = listUnmodifiableList;
        return listUnmodifiableList;
    }

    private List e() {
        List list = this.f80678b;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(d());
        arrayList.add(this.f80677a);
        Collections.sort(arrayList, Comparator.comparing(new Function() { // from class: com.google.android.material.color.utilities.b3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return TemperatureCache.a(this.f80718a, (Hct) obj);
            }
        }, new Comparator() { // from class: com.google.android.material.color.utilities.c3
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((Double) obj).compareTo((Double) obj2);
            }
        }));
        this.f80678b = arrayList;
        return arrayList;
    }

    private Map g() {
        Map map = this.f80680d;
        if (map != null) {
            return map;
        }
        ArrayList arrayList = new ArrayList(d());
        arrayList.add(this.f80677a);
        HashMap map2 = new HashMap();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            Hct hct = (Hct) obj;
            map2.put(hct, Double.valueOf(i(hct)));
        }
        this.f80680d = map2;
        return map2;
    }

    private Hct h() {
        return (Hct) e().get(e().size() - 1);
    }

    public static double i(Hct hct) {
        double[] dArrH = ColorUtils.h(hct.h());
        return ((Math.pow(Math.hypot(dArrH[1], dArrH[2]), 1.07d) * 0.02d) * Math.cos(Math.toRadians(MathUtils.e(MathUtils.e(Math.toDegrees(Math.atan2(dArrH[2], dArrH[1]))) - 50.0d)))) - 0.5d;
    }

    public List b(int i3, int i4) {
        int iRound = (int) Math.round(this.f80677a.d());
        Hct hct = (Hct) d().get(iRound);
        double dF = f(hct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hct);
        double dAbs = 0.0d;
        double dAbs2 = 0.0d;
        int i5 = 0;
        while (i5 < 360) {
            double dF2 = f((Hct) d().get(MathUtils.f(iRound + i5)));
            dAbs2 += Math.abs(dF2 - dF);
            i5++;
            dF = dF2;
        }
        double d3 = dAbs2 / ((double) i4);
        double dF3 = f(hct);
        int i6 = 1;
        while (true) {
            if (arrayList.size() >= i4) {
                break;
            }
            Hct hct2 = (Hct) d().get(MathUtils.f(iRound + i6));
            double dF4 = f(hct2);
            dAbs += Math.abs(dF4 - dF3);
            boolean z2 = dAbs >= ((double) arrayList.size()) * d3;
            int i7 = 1;
            while (z2 && arrayList.size() < i4) {
                arrayList.add(hct2);
                int i8 = i6;
                z2 = dAbs >= ((double) (arrayList.size() + i7)) * d3;
                i7++;
                i6 = i8;
            }
            i6++;
            if (i6 > 360) {
                while (arrayList.size() < i4) {
                    arrayList.add(hct2);
                }
            } else {
                dF3 = dF4;
            }
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(this.f80677a);
        int iFloor = (int) Math.floor((((double) i3) - 1.0d) / 2.0d);
        for (int i9 = 1; i9 < iFloor + 1; i9++) {
            int size = 0 - i9;
            while (size < 0) {
                size += arrayList.size();
            }
            if (size >= arrayList.size()) {
                size %= arrayList.size();
            }
            arrayList2.add(0, (Hct) arrayList.get(size));
        }
        int i10 = i3 - iFloor;
        for (int i11 = 1; i11 < i10; i11++) {
            int size2 = i11;
            while (size2 < 0) {
                size2 += arrayList.size();
            }
            if (size2 >= arrayList.size()) {
                size2 %= arrayList.size();
            }
            arrayList2.add((Hct) arrayList.get(size2));
        }
        return arrayList2;
    }

    public double f(Hct hct) {
        double dDoubleValue = ((Double) g().get(h())).doubleValue() - ((Double) g().get(c())).doubleValue();
        double dDoubleValue2 = ((Double) g().get(hct)).doubleValue() - ((Double) g().get(c())).doubleValue();
        if (dDoubleValue == 0.0d) {
            return 0.5d;
        }
        return dDoubleValue2 / dDoubleValue;
    }
}
