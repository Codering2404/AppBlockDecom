package androidx.media3.common;

import androidx.media3.common.util.Util;
import java.io.IOException;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class PriorityTaskManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f40979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PriorityQueue f40980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f40981c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PriorityTooLowException extends IOException {
        public PriorityTooLowException(int i3, int i4) {
            super("Priority too low [priority=" + i3 + ", highest=" + i4 + "]");
        }
    }

    public void a(int i3) {
        synchronized (this.f40979a) {
            this.f40980b.add(Integer.valueOf(i3));
            this.f40981c = Math.max(this.f40981c, i3);
        }
    }

    public void b(int i3) {
        synchronized (this.f40979a) {
            while (this.f40981c != i3) {
                try {
                    this.f40979a.wait();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void c(int i3) {
        synchronized (this.f40979a) {
            try {
                if (this.f40981c != i3) {
                    throw new PriorityTooLowException(i3, this.f40981c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d(int i3) {
        synchronized (this.f40979a) {
            this.f40980b.remove(Integer.valueOf(i3));
            this.f40981c = this.f40980b.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.k((Integer) this.f40980b.peek())).intValue();
            this.f40979a.notifyAll();
        }
    }
}
