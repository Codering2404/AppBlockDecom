package com.applovin.impl;

import android.os.Handler;
import com.applovin.impl.ae;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface z6 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f65371a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ae.a f65372b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final CopyOnWriteArrayList f65373c;

        /* JADX INFO: renamed from: com.applovin.impl.z6$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class C0132a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Handler f65374a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public z6 f65375b;

            public C0132a(Handler handler, z6 z6Var) {
                this.f65374a = handler;
                this.f65375b = z6Var;
            }
        }

        public a() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        private a(CopyOnWriteArrayList copyOnWriteArrayList, int i3, ae.a aVar) {
            this.f65373c = copyOnWriteArrayList;
            this.f65371a = i3;
            this.f65372b = aVar;
        }

        public void a(Handler handler, z6 z6Var) {
            b1.a(handler);
            b1.a(z6Var);
            this.f65373c.add(new C0132a(handler, z6Var));
        }

        public void b() {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.i90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f60413a.b(z6Var);
                    }
                });
            }
        }

        public void c() {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.j90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f60685a.c(z6Var);
                    }
                });
            }
        }

        public void d() {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.g90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f59893a.d(z6Var);
                    }
                });
            }
        }

        public void e(z6 z6Var) {
            for (C0132a c0132a : this.f65373c) {
                if (c0132a.f65375b == z6Var) {
                    this.f65373c.remove(c0132a);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(z6 z6Var) {
            z6Var.a(this.f65371a, this.f65372b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(z6 z6Var) {
            z6Var.c(this.f65371a, this.f65372b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(z6 z6Var) {
            z6Var.b(this.f65371a, this.f65372b);
        }

        public void a() {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.f90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f59642a.a(z6Var);
                    }
                });
            }
        }

        public void a(final int i3) {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.h90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f60154a.a(z6Var, i3);
                    }
                });
            }
        }

        public void a(final Exception exc) {
            for (C0132a c0132a : this.f65373c) {
                final z6 z6Var = c0132a.f65375b;
                xp.a(c0132a.f65374a, new Runnable() { // from class: com.applovin.impl.e90
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f59434a.a(z6Var, exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(z6 z6Var) {
            z6Var.d(this.f65371a, this.f65372b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(z6 z6Var, int i3) {
            z6Var.e(this.f65371a, this.f65372b);
            z6Var.a(this.f65371a, this.f65372b, i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(z6 z6Var, Exception exc) {
            z6Var.a(this.f65371a, this.f65372b, exc);
        }

        public a a(int i3, ae.a aVar) {
            return new a(this.f65373c, i3, aVar);
        }
    }

    void a(int i3, ae.a aVar);

    void a(int i3, ae.a aVar, int i4);

    void a(int i3, ae.a aVar, Exception exc);

    void b(int i3, ae.a aVar);

    void c(int i3, ae.a aVar);

    void d(int i3, ae.a aVar);

    default void e(int i3, ae.a aVar) {
    }
}
