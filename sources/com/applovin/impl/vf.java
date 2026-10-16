package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class vf {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Comparator f64424a;

        a(Comparator comparator) {
            this.f64424a = comparator;
        }

        @Override // com.applovin.impl.vf.d
        Map b() {
            return new TreeMap(this.f64424a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class b implements Supplier, Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f64425a;

        b(int i3) {
            this.f64425a = p3.a(i3, "expectedValuesPerKey");
        }

        @Override // com.applovin.exoplayer2.common.base.Supplier
        public List get() {
            return new ArrayList(this.f64425a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class c extends vf {
        c() {
            super(null);
        }

        public abstract ec b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class d {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f64426a;

            a(int i3) {
                this.f64426a = i3;
            }

            @Override // com.applovin.impl.vf.c
            public ec b() {
                return wf.a(d.this.b(), new b(this.f64426a));
            }
        }

        d() {
        }

        public c a() {
            return a(2);
        }

        abstract Map b();

        public c a(int i3) {
            p3.a(i3, "expectedValuesPerKey");
            return new a(i3);
        }
    }

    private vf() {
    }

    public static d a(Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        return new a(comparator);
    }

    /* synthetic */ vf(uf ufVar) {
        this();
    }

    public static d a() {
        return a(vg.a());
    }
}
