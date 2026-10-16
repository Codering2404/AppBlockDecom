package io.reactivex.internal.util;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkedArrayList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f139207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f139208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    volatile int f139209c;

    public Object[] a() {
        return this.f139208b;
    }

    public String toString() {
        int i3 = this.f139207a;
        int i4 = this.f139209c;
        ArrayList arrayList = new ArrayList(i4 + 1);
        Object[] objArrA = a();
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            arrayList.add(objArrA[i6]);
            i5++;
            i6++;
            if (i6 == i3) {
                objArrA = (Object[]) objArrA[i3];
                i6 = 0;
            }
        }
        return arrayList.toString();
    }
}
