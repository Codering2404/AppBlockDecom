package com.applovin.impl;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.ae;
import com.applovin.impl.qh;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface s0 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f62937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fo f62938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f62939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ae.a f62940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f62941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final fo f62942f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f62943g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ae.a f62944h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f62945i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final long f62946j;

        public a(long j3, fo foVar, int i3, ae.a aVar, long j4, fo foVar2, int i4, ae.a aVar2, long j5, long j6) {
            this.f62937a = j3;
            this.f62938b = foVar;
            this.f62939c = i3;
            this.f62940d = aVar;
            this.f62941e = j4;
            this.f62942f = foVar2;
            this.f62943g = i4;
            this.f62944h = aVar2;
            this.f62945i = j5;
            this.f62946j = j6;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                a aVar = (a) obj;
                if (this.f62937a == aVar.f62937a && this.f62939c == aVar.f62939c && this.f62941e == aVar.f62941e && this.f62943g == aVar.f62943g && this.f62945i == aVar.f62945i && this.f62946j == aVar.f62946j && Objects.equal(this.f62938b, aVar.f62938b) && Objects.equal(this.f62940d, aVar.f62940d) && Objects.equal(this.f62942f, aVar.f62942f) && Objects.equal(this.f62944h, aVar.f62944h)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f62937a), this.f62938b, Integer.valueOf(this.f62939c), this.f62940d, Long.valueOf(this.f62941e), this.f62942f, Integer.valueOf(this.f62943g), this.f62944h, Long.valueOf(this.f62945i), Long.valueOf(this.f62946j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f62947a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SparseArray f62948b;

        public b(a9 a9Var, SparseArray sparseArray) {
            this.f62947a = a9Var;
            SparseArray sparseArray2 = new SparseArray(a9Var.a());
            for (int i3 = 0; i3 < a9Var.a(); i3++) {
                int iB = a9Var.b(i3);
                sparseArray2.append(iB, (a) b1.a((a) sparseArray.get(iB)));
            }
            this.f62948b = sparseArray2;
        }
    }

    void a(qh qhVar, b bVar);

    void a(a aVar);

    void a(a aVar, float f3);

    void a(a aVar, int i3);

    void a(a aVar, int i3, int i4);

    void a(a aVar, int i3, int i4, int i5, float f3);

    void a(a aVar, int i3, long j3);

    void a(a aVar, int i3, long j3, long j4);

    void a(a aVar, int i3, e9 e9Var);

    void a(a aVar, int i3, m5 m5Var);

    void a(a aVar, int i3, String str, long j3);

    void a(a aVar, long j3);

    void a(a aVar, long j3, int i3);

    void a(a aVar, af afVar);

    void a(a aVar, e9 e9Var);

    void a(a aVar, e9 e9Var, p5 p5Var);

    void a(a aVar, m5 m5Var);

    void a(a aVar, mc mcVar, td tdVar);

    void a(a aVar, mc mcVar, td tdVar, IOException iOException, boolean z2);

    void a(a aVar, nh nhVar);

    void a(a aVar, ph phVar);

    void a(a aVar, po poVar, to toVar);

    void a(a aVar, qh.b bVar);

    void a(a aVar, qh.f fVar, qh.f fVar2, int i3);

    void a(a aVar, sd sdVar, int i3);

    void a(a aVar, td tdVar);

    void a(a aVar, ud udVar);

    void a(a aVar, xq xqVar);

    void a(a aVar, Exception exc);

    void a(a aVar, Object obj, long j3);

    void a(a aVar, String str);

    void a(a aVar, String str, long j3);

    void a(a aVar, String str, long j3, long j4);

    void a(a aVar, boolean z2);

    void a(a aVar, boolean z2, int i3);

    void b(a aVar);

    void b(a aVar, int i3);

    void b(a aVar, int i3, long j3, long j4);

    void b(a aVar, int i3, m5 m5Var);

    void b(a aVar, e9 e9Var);

    void b(a aVar, e9 e9Var, p5 p5Var);

    void b(a aVar, m5 m5Var);

    void b(a aVar, mc mcVar, td tdVar);

    void b(a aVar, Exception exc);

    void b(a aVar, String str);

    void b(a aVar, String str, long j3);

    void b(a aVar, String str, long j3, long j4);

    void b(a aVar, boolean z2);

    void b(a aVar, boolean z2, int i3);

    void c(a aVar);

    void c(a aVar, int i3);

    void c(a aVar, m5 m5Var);

    void c(a aVar, mc mcVar, td tdVar);

    void c(a aVar, Exception exc);

    void c(a aVar, boolean z2);

    void d(a aVar);

    void d(a aVar, int i3);

    void d(a aVar, m5 m5Var);

    void d(a aVar, Exception exc);

    void d(a aVar, boolean z2);

    void e(a aVar);

    void e(a aVar, int i3);

    void e(a aVar, boolean z2);

    void f(a aVar);

    void f(a aVar, int i3);

    void g(a aVar);

    void h(a aVar);
}
