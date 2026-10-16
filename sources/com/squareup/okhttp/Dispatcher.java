package com.squareup.okhttp;

import com.google.android.gms.common.api.Api;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.internal.Util;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class Dispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f92909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f92910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ExecutorService f92911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Deque f92912d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Deque f92913e;

    private void c() {
        if (this.f92913e.size() < this.f92909a && !this.f92912d.isEmpty()) {
            Iterator it = this.f92912d.iterator();
            while (it.hasNext()) {
                Call.AsyncCall asyncCall = (Call.AsyncCall) it.next();
                if (d(asyncCall) < this.f92910b) {
                    it.remove();
                    this.f92913e.add(asyncCall);
                    b().execute(asyncCall);
                }
                if (this.f92913e.size() >= this.f92909a) {
                    return;
                }
            }
        }
    }

    private int d(Call.AsyncCall asyncCall) {
        Iterator it = this.f92913e.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((Call.AsyncCall) it.next()).b().equals(asyncCall.b())) {
                i3++;
            }
        }
        return i3;
    }

    synchronized void a(Call.AsyncCall asyncCall) {
        if (!this.f92913e.remove(asyncCall)) {
            throw new AssertionError("AsyncCall wasn't running!");
        }
        c();
    }

    public synchronized ExecutorService b() {
        try {
            if (this.f92911c == null) {
                this.f92911c = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.s("OkHttp Dispatcher", false));
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f92911c;
    }
}
