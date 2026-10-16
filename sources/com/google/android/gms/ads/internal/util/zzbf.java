package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String[] f70273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f70274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double[] f70275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f70276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f70277e;

    /* synthetic */ zzbf(zzbe zzbeVar, byte[] bArr) {
        int size = zzbeVar.d().size();
        this.f70273a = (String[]) zzbeVar.c().toArray(new String[size]);
        this.f70274b = c(zzbeVar.d());
        this.f70275c = c(zzbeVar.e());
        this.f70276d = new int[size];
        this.f70277e = 0;
    }

    private static final double[] c(List list) {
        int size = list.size();
        double[] dArr = new double[size];
        for (int i3 = 0; i3 < size; i3++) {
            dArr[i3] = ((Double) list.get(i3)).doubleValue();
        }
        return dArr;
    }

    public final void a(double d3) {
        this.f70277e++;
        int i3 = 0;
        while (true) {
            double[] dArr = this.f70275c;
            if (i3 >= dArr.length) {
                return;
            }
            double d4 = dArr[i3];
            if (d4 <= d3 && d3 < this.f70274b[i3]) {
                int[] iArr = this.f70276d;
                iArr[i3] = iArr[i3] + 1;
            }
            if (d3 < d4) {
                return;
            } else {
                i3++;
            }
        }
    }

    public final List b() {
        String[] strArr = this.f70273a;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (int i3 = 0; i3 < strArr.length; i3++) {
            String str = strArr[i3];
            double[] dArr = this.f70275c;
            double[] dArr2 = this.f70274b;
            int[] iArr = this.f70276d;
            double d3 = dArr[i3];
            double d4 = dArr2[i3];
            int i4 = iArr[i3];
            arrayList.add(new zzbd(str, d3, d4, ((double) i4) / ((double) this.f70277e), i4));
        }
        return arrayList;
    }
}
