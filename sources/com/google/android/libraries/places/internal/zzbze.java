package com.google.android.libraries.places.internal;

import com.google.common.base.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbze {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f77248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f77249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f77250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicInteger f77251d;

    zzbze(float f3, float f4) {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f77251d = atomicInteger;
        this.f77250c = (int) (f4 * 1000.0f);
        int i3 = (int) (f3 * 1000.0f);
        this.f77248a = i3;
        this.f77249b = i3 / 2;
        atomicInteger.set(i3);
    }

    final boolean a() {
        return this.f77251d.get() > this.f77249b;
    }

    final boolean b() {
        AtomicInteger atomicInteger;
        int i3;
        int i4;
        do {
            atomicInteger = this.f77251d;
            i3 = atomicInteger.get();
            if (i3 == 0) {
                return false;
            }
            i4 = i3 - 1000;
        } while (!atomicInteger.compareAndSet(i3, Math.max(i4, 0)));
        return i4 > this.f77249b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbze)) {
            return false;
        }
        zzbze zzbzeVar = (zzbze) obj;
        return this.f77248a == zzbzeVar.f77248a && this.f77250c == zzbzeVar.f77250c;
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f77248a), Integer.valueOf(this.f77250c));
    }
}
