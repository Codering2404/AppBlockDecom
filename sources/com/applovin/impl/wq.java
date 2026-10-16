package com.applovin.impl;

import android.os.Handler;
import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface wq {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f64731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final wq f64732b;

        public a(Handler handler, wq wqVar) {
            this.f64731a = wqVar != null ? (Handler) b1.a(handler) : null;
            this.f64732b = wqVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(m5 m5Var) {
            m5Var.a();
            ((wq) xp.a(this.f64732b)).b(m5Var);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(m5 m5Var) {
            ((wq) xp.a(this.f64732b)).d(m5Var);
        }

        public void a(final String str, final long j3, final long j4) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.t70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f63886a.b(str, j3, j4);
                    }
                });
            }
        }

        public void b(final m5 m5Var) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.a80
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f58218a.d(m5Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str, long j3, long j4) {
            ((wq) xp.a(this.f64732b)).b(str, j3, j4);
        }

        public void a(final String str) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.y70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65166a.b(str);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(String str) {
            ((wq) xp.a(this.f64732b)).a(str);
        }

        public void a(final m5 m5Var) {
            m5Var.a();
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.s70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62999a.c(m5Var);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i3, long j3) {
            ((wq) xp.a(this.f64732b)).a(i3, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(e9 e9Var, p5 p5Var) {
            ((wq) xp.a(this.f64732b)).a(e9Var);
            ((wq) xp.a(this.f64732b)).a(e9Var, p5Var);
        }

        public void a(final int i3, final long j3) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.x70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64871a.b(i3, j3);
                    }
                });
            }
        }

        public void b(final long j3, final int i3) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.z70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f65385a.a(j3, i3);
                    }
                });
            }
        }

        public void a(final e9 e9Var, final p5 p5Var) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.w70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64611a.b(e9Var, p5Var);
                    }
                });
            }
        }

        public void b(final Exception exc) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.u70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64117a.a(exc);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Object obj, long j3) {
            ((wq) xp.a(this.f64732b)).a(obj, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(long j3, int i3) {
            ((wq) xp.a(this.f64732b)).a(j3, i3);
        }

        public void b(final xq xqVar) {
            Handler handler = this.f64731a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.applovin.impl.r70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f62799a.a(xqVar);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Exception exc) {
            ((wq) xp.a(this.f64732b)).b(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(xq xqVar) {
            ((wq) xp.a(this.f64732b)).a(xqVar);
        }

        public void a(final Object obj) {
            if (this.f64731a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f64731a.post(new Runnable() { // from class: com.applovin.impl.v70
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f64406a.a(obj, jElapsedRealtime);
                    }
                });
            }
        }
    }

    void a(int i3, long j3);

    void a(long j3, int i3);

    default void a(e9 e9Var) {
    }

    void a(e9 e9Var, p5 p5Var);

    void a(xq xqVar);

    void a(Object obj, long j3);

    void a(String str);

    void b(m5 m5Var);

    void b(Exception exc);

    void b(String str, long j3, long j4);

    void d(m5 m5Var);
}
