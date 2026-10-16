package com.applovin.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class as implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f58510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f58511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long[] f58512c;

    public as(List list) {
        this.f58510a = Collections.unmodifiableList(new ArrayList(list));
        this.f58511b = new long[list.size() * 2];
        for (int i3 = 0; i3 < list.size(); i3++) {
            wr wrVar = (wr) list.get(i3);
            int i4 = i3 * 2;
            long[] jArr = this.f58511b;
            jArr[i4] = wrVar.f64734b;
            jArr[i4 + 1] = wrVar.f64735c;
        }
        long[] jArr2 = this.f58511b;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f58512c = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.applovin.impl.nl
    public long a(int i3) {
        b1.a(i3 >= 0);
        b1.a(i3 < this.f58512c.length);
        return this.f58512c[i3];
    }

    @Override // com.applovin.impl.nl
    public List b(long j3) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < this.f58510a.size(); i3++) {
            long[] jArr = this.f58511b;
            int i4 = i3 * 2;
            if (jArr[i4] <= j3 && j3 < jArr[i4 + 1]) {
                wr wrVar = (wr) this.f58510a.get(i3);
                a5 a5Var = wrVar.f64733a;
                if (a5Var.f58177f == -3.4028235E38f) {
                    arrayList2.add(wrVar);
                } else {
                    arrayList.add(a5Var);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.applovin.impl.qs
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return as.a((wr) obj, (wr) obj2);
            }
        });
        for (int i5 = 0; i5 < arrayList2.size(); i5++) {
            arrayList.add(((wr) arrayList2.get(i5)).f64733a.a().a((-1) - i5, 1).a());
        }
        return arrayList;
    }

    @Override // com.applovin.impl.nl
    public int a() {
        return this.f58512c.length;
    }

    @Override // com.applovin.impl.nl
    public int a(long j3) {
        int iA = xp.a(this.f58512c, j3, false, false);
        if (iA < this.f58512c.length) {
            return iA;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int a(wr wrVar, wr wrVar2) {
        return Long.compare(wrVar.f64734b, wrVar2.f64734b);
    }
}
