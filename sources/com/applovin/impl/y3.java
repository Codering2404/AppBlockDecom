package com.applovin.impl;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final y3 f65148a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final y3 f65149b = new b(-1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final y3 f65150c = new b(1);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends y3 {
        a() {
            super(null);
        }

        y3 a(int i3) {
            return i3 < 0 ? y3.f65149b : i3 > 0 ? y3.f65150c : y3.f65148a;
        }

        @Override // com.applovin.impl.y3
        public y3 b(boolean z2, boolean z3) {
            return a(k2.a(z3, z2));
        }

        @Override // com.applovin.impl.y3
        public int d() {
            return 0;
        }

        @Override // com.applovin.impl.y3
        public y3 a(int i3, int i4) {
            return a(tb.a(i3, i4));
        }

        @Override // com.applovin.impl.y3
        public y3 a(long j3, long j4) {
            return a(rc.a(j3, j4));
        }

        @Override // com.applovin.impl.y3
        public y3 a(Object obj, Object obj2, Comparator comparator) {
            return a(comparator.compare(obj, obj2));
        }

        @Override // com.applovin.impl.y3
        public y3 a(boolean z2, boolean z3) {
            return a(k2.a(z2, z3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b extends y3 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f65151d;

        b(int i3) {
            super(null);
            this.f65151d = i3;
        }

        @Override // com.applovin.impl.y3
        public y3 a(int i3, int i4) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public int d() {
            return this.f65151d;
        }

        @Override // com.applovin.impl.y3
        public y3 a(long j3, long j4) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 a(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 a(boolean z2, boolean z3) {
            return this;
        }

        @Override // com.applovin.impl.y3
        public y3 b(boolean z2, boolean z3) {
            return this;
        }
    }

    private y3() {
    }

    public static y3 e() {
        return f65148a;
    }

    public abstract y3 a(int i3, int i4);

    public abstract y3 a(long j3, long j4);

    public abstract y3 a(Object obj, Object obj2, Comparator comparator);

    public abstract y3 a(boolean z2, boolean z3);

    public abstract y3 b(boolean z2, boolean z3);

    public abstract int d();

    /* synthetic */ y3(a aVar) {
        this();
    }
}
