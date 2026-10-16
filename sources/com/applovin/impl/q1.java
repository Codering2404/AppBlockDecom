package com.applovin.impl;

import android.os.Handler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface q1 {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f62549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q1 f62550b;

        public a(Handler handler, q1 q1Var) {
            this.f62549a = q1Var != null ? (Handler) b1.a(handler) : null;
            this.f62550b = q1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Exception exc) {
            ((q1) xp.a(this.f62550b)).c(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Exception exc) {
            ((q1) xp.a(this.f62550b)).a(exc);
        }

        public void a(final Exception exc) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.y00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65105a.c(exc);
                    }
                });
            }
        }

        public void b(final Exception exc) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.b10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58536a.d(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(m5 m5Var) {
            m5Var.a();
            ((q1) xp.a(this.f62550b)).c(m5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(m5 m5Var) {
            ((q1) xp.a(this.f62550b)).a(m5Var);
        }

        public void a(final String str, final long j3, final long j4) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.z00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65281a.b(str, j3, j4);
                    }
                });
            }
        }

        public void b(final m5 m5Var) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.v00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64366a.d(m5Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j3, long j4) {
            ((q1) xp.a(this.f62550b)).a(str, j3, j4);
        }

        public void a(final String str) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.c10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58806a.b(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            ((q1) xp.a(this.f62550b)).b(str);
        }

        public void a(final m5 m5Var) {
            m5Var.a();
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.x00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64777a.c(m5Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e9 e9Var, p5 p5Var) {
            ((q1) xp.a(this.f62550b)).b(e9Var);
            ((q1) xp.a(this.f62550b)).b(e9Var, p5Var);
        }

        public void a(final e9 e9Var, final p5 p5Var) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.w00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64524a.b(e9Var, p5Var);
                    }
                });
            }
        }

        public void b(final long j3) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.d10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f59057a.a(j3);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(long j3) {
            ((q1) xp.a(this.f62550b)).a(j3);
        }

        public void b(final boolean z2) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.u00
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64034a.a(z2);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(boolean z2) {
            ((q1) xp.a(this.f62550b)).a(z2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i3, long j3, long j4) {
            ((q1) xp.a(this.f62550b)).b(i3, j3, j4);
        }

        public void b(final int i3, final long j3, final long j4) {
            Handler handler = this.f62549a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.a10
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58144a.a(i3, j3, j4);
                    }
                });
            }
        }
    }

    void a(long j3);

    void a(m5 m5Var);

    void a(Exception exc);

    void a(String str, long j3, long j4);

    void a(boolean z2);

    void b(int i3, long j3, long j4);

    default void b(e9 e9Var) {
    }

    void b(e9 e9Var, p5 p5Var);

    void b(String str);

    void c(m5 m5Var);

    void c(Exception exc);
}
