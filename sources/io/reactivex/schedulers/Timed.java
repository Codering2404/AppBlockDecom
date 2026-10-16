package io.reactivex.schedulers;

import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public final class Timed<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f139411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f139412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f139413c;

    public Timed(Object obj, long j3, TimeUnit timeUnit) {
        this.f139411a = obj;
        this.f139412b = j3;
        this.f139413c = (TimeUnit) ObjectHelper.d(timeUnit, "unit is null");
    }

    public long a() {
        return this.f139412b;
    }

    public Object b() {
        return this.f139411a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Timed) {
            Timed timed = (Timed) obj;
            if (ObjectHelper.c(this.f139411a, timed.f139411a) && this.f139412b == timed.f139412b && ObjectHelper.c(this.f139413c, timed.f139413c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object obj = this.f139411a;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        long j3 = this.f139412b;
        return (((iHashCode * 31) + ((int) (j3 ^ (j3 >>> 31)))) * 31) + this.f139413c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f139412b + ", unit=" + this.f139413c + ", value=" + this.f139411a + "]";
    }
}
