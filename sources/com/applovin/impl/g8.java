package com.applovin.impl;

import com.applovin.impl.ae;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface g8 extends so {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final oo f59888a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f59889b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f59890c;

        public a(oo ooVar, int... iArr) {
            this(ooVar, iArr, 0);
        }

        public a(oo ooVar, int[] iArr, int i3) {
            this.f59888a = ooVar;
            this.f59889b = iArr;
            this.f59890c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        g8[] a(a[] aVarArr, y1 y1Var, ae.a aVar, fo foVar);
    }

    void a(float f3);

    default void a(boolean z2) {
    }

    void f();

    e9 g();

    int h();

    void i();

    default void j() {
    }

    default void k() {
    }
}
