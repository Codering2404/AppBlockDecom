package com.squareup.okhttp;

import androidx.compose.material.icons.twotone.Phg.QaXmqxvjHhxVy;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.StreamAllocation;
import com.squareup.okhttp.internal.io.RealConnection;
import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class ConnectionPool {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final ConnectionPool f92889g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f92890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f92891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f92892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f92893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque f92894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final RouteDatabase f92895f;

    public ConnectionPool(int i3, long j3) {
        this(i3, j3, TimeUnit.MILLISECONDS);
    }

    private int d(RealConnection realConnection, long j3) {
        List list = realConnection.f93437j;
        int i3 = 0;
        while (i3 < list.size()) {
            if (((Reference) list.get(i3)).get() != null) {
                i3++;
            } else {
                Internal.f93097a.warning("A connection to " + realConnection.a().a().m() + " was leaked. Did you forget to close a response body?");
                list.remove(i3);
                realConnection.f93438k = true;
                if (list.isEmpty()) {
                    realConnection.f93439l = j3 - this.f92892c;
                    return 0;
                }
            }
        }
        return list.size();
    }

    long a(long j3) {
        synchronized (this) {
            try {
                int i3 = 0;
                long j4 = Long.MIN_VALUE;
                RealConnection realConnection = null;
                int i4 = 0;
                for (RealConnection realConnection2 : this.f92894e) {
                    if (d(realConnection2, j3) > 0) {
                        i4++;
                    } else {
                        i3++;
                        long j5 = j3 - realConnection2.f93439l;
                        if (j5 > j4) {
                            realConnection = realConnection2;
                            j4 = j5;
                        }
                    }
                }
                long j6 = this.f92892c;
                if (j4 < j6 && i3 <= this.f92891b) {
                    if (i3 > 0) {
                        return j6 - j4;
                    }
                    if (i4 > 0) {
                        return j6;
                    }
                    return -1L;
                }
                this.f92894e.remove(realConnection);
                Util.d(realConnection.i());
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    boolean b(RealConnection realConnection) {
        if (realConnection.f93438k || this.f92891b == 0) {
            this.f92894e.remove(realConnection);
            return true;
        }
        notifyAll();
        return false;
    }

    RealConnection c(Address address, StreamAllocation streamAllocation) {
        for (RealConnection realConnection : this.f92894e) {
            if (realConnection.f93437j.size() < realConnection.b() && address.equals(realConnection.a().f93038a) && !realConnection.f93438k) {
                streamAllocation.a(realConnection);
                return realConnection;
            }
        }
        return null;
    }

    void e(RealConnection realConnection) {
        if (this.f92894e.isEmpty()) {
            this.f92890a.execute(this.f92893d);
        }
        this.f92894e.add(realConnection);
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty(QaXmqxvjHhxVy.SEISoAFX);
        long j3 = property2 != null ? Long.parseLong(property2) : 300000L;
        if (property != null && !Boolean.parseBoolean(property)) {
            f92889g = new ConnectionPool(0, j3);
        } else if (property3 != null) {
            f92889g = new ConnectionPool(Integer.parseInt(property3), j3);
        } else {
            f92889g = new ConnectionPool(5, j3);
        }
    }

    public ConnectionPool(int i3, long j3, TimeUnit timeUnit) {
        this.f92890a = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.s("OkHttp ConnectionPool", true));
        this.f92893d = new Runnable() { // from class: com.squareup.okhttp.ConnectionPool.1
            @Override // java.lang.Runnable
            public void run() {
                while (true) {
                    long jA = ConnectionPool.this.a(System.nanoTime());
                    if (jA == -1) {
                        return;
                    }
                    if (jA > 0) {
                        long j4 = jA / 1000000;
                        long j5 = jA - (1000000 * j4);
                        synchronized (ConnectionPool.this) {
                            try {
                                ConnectionPool.this.wait(j4, (int) j5);
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                }
            }
        };
        this.f92894e = new ArrayDeque();
        this.f92895f = new RouteDatabase();
        this.f92891b = i3;
        this.f92892c = timeUnit.toNanos(j3);
        if (j3 > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j3);
    }
}
