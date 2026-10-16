package com.applovin.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ye {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f65191a = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(fe feVar);
    }

    public void a(a aVar) {
        this.f65191a.add(aVar);
    }

    public void b(a aVar) {
        this.f65191a.remove(aVar);
    }

    public void a(fe feVar) {
        ArrayList arrayList = new ArrayList(this.f65191a);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((a) obj).a(feVar);
        }
    }
}
