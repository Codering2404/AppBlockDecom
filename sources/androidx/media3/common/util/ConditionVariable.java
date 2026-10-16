package androidx.media3.common.util;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConditionVariable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Clock f41493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f41494b;

    public ConditionVariable() {
        this(Clock.f41485a);
    }

    public synchronized void a() {
        while (!this.f41494b) {
            wait();
        }
    }

    public synchronized boolean b(long j3) {
        if (j3 <= 0) {
            return this.f41494b;
        }
        long jA = this.f41493a.a();
        long j4 = j3 + jA;
        if (j4 < jA) {
            a();
        } else {
            while (!this.f41494b && jA < j4) {
                wait(j4 - jA);
                jA = this.f41493a.a();
            }
        }
        return this.f41494b;
    }

    public synchronized void c() {
        boolean z2 = false;
        while (!this.f41494b) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z2 = true;
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z2;
        z2 = this.f41494b;
        this.f41494b = false;
        return z2;
    }

    public synchronized boolean e() {
        return this.f41494b;
    }

    public synchronized boolean f() {
        if (this.f41494b) {
            return false;
        }
        this.f41494b = true;
        notifyAll();
        return true;
    }

    public ConditionVariable(Clock clock) {
        this.f41493a = clock;
    }
}
