package com.applovin.impl;

import android.os.Bundle;
import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.impl.a9;
import com.applovin.impl.o2;
import com.applovin.impl.qh;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface qh {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements o2 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f62628b = new a().a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final o2.a f62629c = new o2.a() { // from class: com.applovin.impl.g10
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return qh.b.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f62630a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final int[] f62631b = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final a9.b f62632a = new a9.b();

            public a a(int i3) {
                this.f62632a.a(i3);
                return this;
            }

            public a a(b bVar) {
                this.f62632a.a(bVar.f62630a);
                return this;
            }

            public a a(int... iArr) {
                this.f62632a.a(iArr);
                return this;
            }

            public a a(int i3, boolean z2) {
                this.f62632a.a(i3, z2);
                return this;
            }

            public b a() {
                return new b(this.f62632a.a());
            }
        }

        private b(a9 a9Var) {
            this.f62630a = a9Var;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.f62630a.equals(((b) obj).f62630a);
            }
            return false;
        }

        public int hashCode() {
            return this.f62630a.hashCode();
        }

        private static String b(int i3) {
            return Integer.toString(i3, 36);
        }

        public boolean a(int i3) {
            return this.f62630a.a(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(Bundle bundle) {
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(b(0));
            if (integerArrayList == null) {
                return f62628b;
            }
            a aVar = new a();
            for (int i3 = 0; i3 < integerArrayList.size(); i3++) {
                aVar.a(integerArrayList.get(i3).intValue());
            }
            return aVar.a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface c {
        default void a(int i3) {
        }

        default void b() {
        }

        void b(int i3);

        default void c(int i3) {
        }

        default void e(int i3) {
        }

        default void a(fo foVar, int i3) {
        }

        default void b(nh nhVar) {
        }

        default void c(boolean z2) {
        }

        default void e(boolean z2) {
        }

        default void a(nh nhVar) {
        }

        default void b(boolean z2) {
        }

        default void a(ph phVar) {
        }

        default void b(boolean z2, int i3) {
        }

        default void a(po poVar, to toVar) {
        }

        default void a(b bVar) {
        }

        default void a(f fVar, f fVar2, int i3) {
        }

        default void a(qh qhVar, d dVar) {
        }

        default void a(sd sdVar, int i3) {
        }

        default void a(ud udVar) {
        }

        default void a(boolean z2, int i3) {
        }

        default void d(boolean z2) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a9 f62633a;

        public d(a9 a9Var) {
            this.f62633a = a9Var;
        }

        public boolean a(int i3) {
            return this.f62633a.a(i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.f62633a.equals(((d) obj).f62633a);
            }
            return false;
        }

        public int hashCode() {
            return this.f62633a.hashCode();
        }

        public boolean a(int... iArr) {
            return this.f62633a.a(iArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface e extends c {
        default void a() {
        }

        @Override // com.applovin.impl.qh.c
        default void b(int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void c(int i3) {
        }

        default void a(float f3) {
        }

        default void b(int i3, boolean z2) {
        }

        @Override // com.applovin.impl.qh.c
        default void c(boolean z2) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void b(nh nhVar) {
        }

        default void a(int i3, int i4) {
        }

        @Override // com.applovin.impl.qh.c
        default void b(boolean z2) {
        }

        default void a(af afVar) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(fo foVar, int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(nh nhVar) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(ph phVar) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(po poVar, to toVar) {
        }

        default void a(q6 q6Var) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(b bVar) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(f fVar, f fVar2, int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(qh qhVar, d dVar) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(sd sdVar, int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(ud udVar) {
        }

        default void a(xq xqVar) {
        }

        default void a(List list) {
        }

        default void a(boolean z2) {
        }

        @Override // com.applovin.impl.qh.c
        default void a(boolean z2, int i3) {
        }

        @Override // com.applovin.impl.qh.c
        default void d(boolean z2) {
        }
    }

    to A();

    void B();

    ud C();

    void D();

    int E();

    long F();

    ph a();

    void a(int i3);

    void a(int i3, long j3);

    void a(long j3);

    void a(SurfaceView surfaceView);

    void a(TextureView textureView);

    void a(e eVar);

    void a(boolean z2);

    void b();

    void b(SurfaceView surfaceView);

    void b(TextureView textureView);

    void b(e eVar);

    void b(boolean z2);

    boolean b(int i3);

    nh c();

    boolean d();

    long e();

    int f();

    long g();

    long getCurrentPosition();

    long getDuration();

    long h();

    b i();

    boolean isPlaying();

    int j();

    po k();

    boolean l();

    int m();

    fo n();

    int o();

    Looper p();

    long q();

    boolean r();

    long s();

    int t();

    void u();

    int v();

    void w();

    List x();

    boolean y();

    xq z();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class f implements o2 {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final o2.a f62634k = new o2.a() { // from class: com.applovin.impl.h10
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return qh.f.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f62635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f62636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final sd f62637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f62638d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f62639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f62640g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final long f62641h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f62642i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f62643j;

        public f(Object obj, int i3, sd sdVar, Object obj2, int i4, long j3, long j4, int i5, int i6) {
            this.f62635a = obj;
            this.f62636b = i3;
            this.f62637c = sdVar;
            this.f62638d = obj2;
            this.f62639f = i4;
            this.f62640g = j3;
            this.f62641h = j4;
            this.f62642i = i5;
            this.f62643j = i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static f a(Bundle bundle) {
            return new f(null, bundle.getInt(a(0), -1), (sd) p2.a(sd.f63034h, bundle.getBundle(a(1))), null, bundle.getInt(a(2), -1), bundle.getLong(a(3), -9223372036854775807L), bundle.getLong(a(4), -9223372036854775807L), bundle.getInt(a(5), -1), bundle.getInt(a(6), -1));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && f.class == obj.getClass()) {
                f fVar = (f) obj;
                if (this.f62636b == fVar.f62636b && this.f62639f == fVar.f62639f && this.f62640g == fVar.f62640g && this.f62641h == fVar.f62641h && this.f62642i == fVar.f62642i && this.f62643j == fVar.f62643j && Objects.equal(this.f62635a, fVar.f62635a) && Objects.equal(this.f62638d, fVar.f62638d) && Objects.equal(this.f62637c, fVar.f62637c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(this.f62635a, Integer.valueOf(this.f62636b), this.f62637c, this.f62638d, Integer.valueOf(this.f62639f), Integer.valueOf(this.f62636b), Long.valueOf(this.f62640g), Long.valueOf(this.f62641h), Integer.valueOf(this.f62642i), Integer.valueOf(this.f62643j));
        }

        private static String a(int i3) {
            return Integer.toString(i3, 36);
        }
    }
}
