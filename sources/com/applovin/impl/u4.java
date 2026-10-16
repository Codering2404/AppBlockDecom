package com.applovin.impl;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class u4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f64084a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f64085b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f64086c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicInteger f64087d = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
        void a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f64088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f64089b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f64090c;

        private c(String str, long j3, b bVar) {
            this.f64088a = str;
            this.f64090c = j3;
            this.f64089b = bVar;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            String str = this.f64088a;
            String str2 = ((c) obj).f64088a;
            return str != null ? str.equalsIgnoreCase(str2) : str2 == null;
        }

        public int hashCode() {
            String str = this.f64088a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "CountdownProxy{identifier='" + this.f64088a + "', countdownStepMillis=" + this.f64090c + '}';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b a() {
            return this.f64089b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long b() {
            return this.f64090c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String c() {
            return this.f64088a;
        }
    }

    public u4(Handler handler, com.applovin.impl.sdk.j jVar) {
        if (handler == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.f64085b = handler;
        this.f64084a = jVar.I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(c cVar, int i3) {
        b bVarA = cVar.a();
        if (!bVarA.b()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f64084a.a("CountdownManager", "Ending countdown for " + cVar.c());
                return;
            }
            return;
        }
        if (this.f64087d.get() != i3) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f64084a.k("CountdownManager", "Killing duplicate countdown from previous generation: " + cVar.c());
                return;
            }
            return;
        }
        try {
            bVarA.a();
            a(cVar, i3);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f64084a.a("CountdownManager", "Encountered error on countdown step for: " + cVar.c(), th);
            }
            a();
        }
    }

    public void c() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f64084a.a("CountdownManager", "Stopping countdowns...");
        }
        this.f64087d.incrementAndGet();
        this.f64085b.removeCallbacksAndMessages(null);
    }

    public void a(String str, long j3, b bVar) {
        if (j3 <= 0) {
            throw new IllegalArgumentException("Invalid step specified.");
        }
        if (this.f64085b == null) {
            throw new IllegalArgumentException("No handler specified.");
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f64084a.a("CountdownManager", "Adding countdown: " + str);
        }
        this.f64086c.add(new c(str, j3, bVar));
    }

    private void a(final c cVar, final int i3) {
        this.f64085b.postDelayed(new Runnable() { // from class: com.applovin.impl.c60
            @Override // java.lang.Runnable
            public final void run() {
                this.f58850a.b(cVar, i3);
            }
        }, cVar.b());
    }

    public void b() {
        HashSet<c> hashSet = new HashSet(this.f64086c);
        if (com.applovin.impl.sdk.n.a()) {
            this.f64084a.a("CountdownManager", "Starting " + hashSet.size() + " countdowns...");
        }
        int iIncrementAndGet = this.f64087d.incrementAndGet();
        for (c cVar : hashSet) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f64084a.a("CountdownManager", "Starting countdown: " + cVar.c() + " for generation " + iIncrementAndGet + "...");
            }
            a(cVar, iIncrementAndGet);
        }
    }

    public void a() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f64084a.a("CountdownManager", "Removing all countdowns...");
        }
        c();
        this.f64086c.clear();
    }
}
