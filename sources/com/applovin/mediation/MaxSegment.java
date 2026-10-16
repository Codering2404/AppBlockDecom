package com.applovin.mediation;

import com.applovin.impl.sdk.n;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MaxSegment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f65502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f65503b;

    public MaxSegment(int i3, List<Integer> list) {
        this.f65502a = i3;
        this.f65503b = list;
        a(i3);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            a(it.next().intValue());
        }
    }

    private void a(int i3) {
        if (i3 >= 0) {
            return;
        }
        n.h("MaxSegment", "Please ensure that the segment value entered is a non-negative number in the range of [0, 2147483647]: " + i3);
    }

    public int getKey() {
        return this.f65502a;
    }

    public List<Integer> getValues() {
        return this.f65503b;
    }

    public String toString() {
        return "MaxSegment{key=" + this.f65502a + ", values=" + this.f65503b + '}';
    }
}
