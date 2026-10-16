package com.google.android.libraries.places.internal;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzwm extends AbstractMap {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Comparator f78740g = new zzwj();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f78741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f78742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f78743c = new zzwl(this, -1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Integer f78744d = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f78745f = null;

    zzwm(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            throw null;
        }
        int size = list.size();
        Object[] objArr = new Object[size];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            throw null;
        }
        int[] iArr = {0};
        this.f78741a = d(size, 0) ? Arrays.copyOf(objArr, 0) : objArr;
        this.f78742b = iArr;
    }

    private static boolean d(int i3, int i4) {
        return i3 > 16 && i3 * 9 > i4 * 10;
    }

    final /* synthetic */ Object[] b() {
        return this.f78741a;
    }

    final /* synthetic */ int[] c() {
        return this.f78742b;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.f78743c;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.f78744d == null) {
            this.f78744d = Integer.valueOf(super.hashCode());
        }
        return this.f78744d.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.f78745f == null) {
            this.f78745f = super.toString();
        }
        return this.f78745f;
    }
}
