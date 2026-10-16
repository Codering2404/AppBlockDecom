package com.applovin.impl;

import android.os.Handler;
import com.applovin.impl.y1;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface y1 {
    xo a();

    void a(Handler handler, a aVar);

    void a(a aVar);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface a {
        void a(int i3, long j3, long j4);

        /* JADX INFO: renamed from: com.applovin.impl.y1$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public static final class C0128a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CopyOnWriteArrayList f65107a = new CopyOnWriteArrayList();

            /* JADX INFO: Access modifiers changed from: private */
            /* JADX INFO: renamed from: com.applovin.impl.y1$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            static final class C0129a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final Handler f65108a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                private final a f65109b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                private boolean f65110c;

                public C0129a(Handler handler, a aVar) {
                    this.f65108a = handler;
                    this.f65109b = aVar;
                }

                public void a() {
                    this.f65110c = true;
                }
            }

            public void a(Handler handler, a aVar) {
                b1.a(handler);
                b1.a(aVar);
                a(aVar);
                this.f65107a.add(new C0129a(handler, aVar));
            }

            public void a(final int i3, final long j3, final long j4) {
                for (final C0129a c0129a : this.f65107a) {
                    if (!c0129a.f65110c) {
                        c0129a.f65108a.post(new Runnable() { // from class: com.applovin.impl.x80
                            @Override // java.lang.Runnable
                            public final void run() {
                                y1.a.C0128a.a(c0129a, i3, j3, j4);
                            }
                        });
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ void a(C0129a c0129a, int i3, long j3, long j4) {
                c0129a.f65109b.a(i3, j3, j4);
            }

            public void a(a aVar) {
                for (C0129a c0129a : this.f65107a) {
                    if (c0129a.f65109b == aVar) {
                        c0129a.a();
                        this.f65107a.remove(c0129a);
                    }
                }
            }
        }
    }
}
