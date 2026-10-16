package com.applovin.impl;

import android.os.Handler;
import com.applovin.impl.ae;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface be {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f58638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ae.a f58639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f58640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f58641d;

        /* JADX INFO: renamed from: com.applovin.impl.be$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class C0102a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f58642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public be f58643b;

            public C0102a(Handler handler, be beVar) {
                this.f58642a = handler;
                this.f58643b = beVar;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i3, ae.a aVar, long j3) {
            this.f58640c = copyOnWriteArrayList;
            this.f58638a = i3;
            this.f58639b = aVar;
            this.f58641d = j3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(be beVar, mc mcVar, td tdVar) {
            beVar.c(this.f58638a, this.f58639b, mcVar, tdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(be beVar, mc mcVar, td tdVar) {
            beVar.b(this.f58638a, this.f58639b, mcVar, tdVar);
        }

        public void a(Handler handler, be beVar) {
            b1.a(handler);
            b1.a(beVar);
            this.f58640c.add(new C0102a(handler, beVar));
        }

        public void b(mc mcVar, int i3, int i4, e9 e9Var, int i5, Object obj, long j3, long j4) {
            b(mcVar, new td(i3, i4, e9Var, i5, obj, a(j3), a(j4)));
        }

        public void c(mc mcVar, int i3, int i4, e9 e9Var, int i5, Object obj, long j3, long j4) {
            c(mcVar, new td(i3, i4, e9Var, i5, obj, a(j3), a(j4)));
        }

        private long a(long j3) {
            long jB = t2.b(j3);
            if (jB == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.f58641d + jB;
        }

        public void a(int i3, e9 e9Var, int i4, Object obj, long j3) {
            a(new td(1, i3, e9Var, i4, obj, a(j3), -9223372036854775807L));
        }

        public void b(final mc mcVar, final td tdVar) {
            for (C0102a c0102a : this.f58640c) {
                final be beVar = c0102a.f58643b;
                xp.a(c0102a.f58642a, new Runnable() { // from class: com.applovin.impl.ut
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64347a.b(beVar, mcVar, tdVar);
                    }
                });
            }
        }

        public void c(final mc mcVar, final td tdVar) {
            for (C0102a c0102a : this.f58640c) {
                final be beVar = c0102a.f58643b;
                xp.a(c0102a.f58642a, new Runnable() { // from class: com.applovin.impl.xt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65073a.c(beVar, mcVar, tdVar);
                    }
                });
            }
        }

        public void a(final td tdVar) {
            for (C0102a c0102a : this.f58640c) {
                final be beVar = c0102a.f58643b;
                xp.a(c0102a.f58642a, new Runnable() { // from class: com.applovin.impl.tt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63993a.a(beVar, tdVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(be beVar, td tdVar) {
            beVar.a(this.f58638a, this.f58639b, tdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(be beVar, mc mcVar, td tdVar) {
            beVar.a(this.f58638a, this.f58639b, mcVar, tdVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(be beVar, mc mcVar, td tdVar, IOException iOException, boolean z2) {
            beVar.a(this.f58638a, this.f58639b, mcVar, tdVar, iOException, z2);
        }

        public void a(mc mcVar, int i3, int i4, e9 e9Var, int i5, Object obj, long j3, long j4) {
            a(mcVar, new td(i3, i4, e9Var, i5, obj, a(j3), a(j4)));
        }

        public void a(final mc mcVar, final td tdVar) {
            for (C0102a c0102a : this.f58640c) {
                final be beVar = c0102a.f58643b;
                xp.a(c0102a.f58642a, new Runnable() { // from class: com.applovin.impl.wt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64737a.a(beVar, mcVar, tdVar);
                    }
                });
            }
        }

        public void a(mc mcVar, int i3, int i4, e9 e9Var, int i5, Object obj, long j3, long j4, IOException iOException, boolean z2) {
            a(mcVar, new td(i3, i4, e9Var, i5, obj, a(j3), a(j4)), iOException, z2);
        }

        public void a(final mc mcVar, final td tdVar, final IOException iOException, final boolean z2) {
            for (C0102a c0102a : this.f58640c) {
                final be beVar = c0102a.f58643b;
                xp.a(c0102a.f58642a, new Runnable() { // from class: com.applovin.impl.vt
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64504a.a(beVar, mcVar, tdVar, iOException, z2);
                    }
                });
            }
        }

        public void a(be beVar) {
            for (C0102a c0102a : this.f58640c) {
                if (c0102a.f58643b == beVar) {
                    this.f58640c.remove(c0102a);
                }
            }
        }

        public a a(int i3, ae.a aVar, long j3) {
            return new a(this.f58640c, i3, aVar, j3);
        }
    }

    void a(int i3, ae.a aVar, mc mcVar, td tdVar);

    void a(int i3, ae.a aVar, mc mcVar, td tdVar, IOException iOException, boolean z2);

    void a(int i3, ae.a aVar, td tdVar);

    void b(int i3, ae.a aVar, mc mcVar, td tdVar);

    void c(int i3, ae.a aVar, mc mcVar, td tdVar);
}
