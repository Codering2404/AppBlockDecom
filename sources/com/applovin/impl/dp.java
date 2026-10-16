package com.applovin.impl;

import android.util.SparseArray;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface dp {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f59278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f59280c;

        public a(String str, int i3, byte[] bArr) {
            this.f59278a = str;
            this.f59279b = i3;
            this.f59280c = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f59281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f59282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f59283c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f59284d;

        public b(int i3, String str, List list, byte[] bArr) {
            this.f59281a = i3;
            this.f59282b = str;
            this.f59283c = list == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list);
            this.f59284d = bArr;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        SparseArray a();

        dp a(int i3, b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f59285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f59286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f59287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f59288d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f59289e;

        public d(int i3, int i4) {
            this(Integer.MIN_VALUE, i3, i4);
        }

        private void d() {
            if (this.f59288d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i3 = this.f59288d;
            this.f59288d = i3 == Integer.MIN_VALUE ? this.f59286b : i3 + this.f59287c;
            this.f59289e = this.f59285a + this.f59288d;
        }

        public String b() {
            d();
            return this.f59289e;
        }

        public int c() {
            d();
            return this.f59288d;
        }

        public d(int i3, int i4, int i5) {
            String str;
            if (i3 != Integer.MIN_VALUE) {
                str = i3 + "/";
            } else {
                str = "";
            }
            this.f59285a = str;
            this.f59286b = i4;
            this.f59287c = i5;
            this.f59288d = Integer.MIN_VALUE;
            this.f59289e = "";
        }
    }

    void a();

    void a(ah ahVar, int i3);

    void a(ho hoVar, l8 l8Var, d dVar);
}
