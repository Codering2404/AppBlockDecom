package com.bumptech.glide.manager;

import android.util.Log;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class RequestTracker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f67043a = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f67044b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f67045c;

    public boolean a(Request request) {
        boolean z2 = true;
        if (request == null) {
            return true;
        }
        boolean zRemove = this.f67043a.remove(request);
        if (!this.f67044b.remove(request) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            request.clear();
        }
        return z2;
    }

    public void b() {
        Iterator it = Util.k(this.f67043a).iterator();
        while (it.hasNext()) {
            a((Request) it.next());
        }
        this.f67044b.clear();
    }

    public void c() {
        this.f67045c = true;
        for (Request request : Util.k(this.f67043a)) {
            if (request.isRunning() || request.g()) {
                request.clear();
                this.f67044b.add(request);
            }
        }
    }

    public void d() {
        this.f67045c = true;
        for (Request request : Util.k(this.f67043a)) {
            if (request.isRunning()) {
                request.pause();
                this.f67044b.add(request);
            }
        }
    }

    public void e() {
        for (Request request : Util.k(this.f67043a)) {
            if (!request.g() && !request.e()) {
                request.clear();
                if (this.f67045c) {
                    this.f67044b.add(request);
                } else {
                    request.i();
                }
            }
        }
    }

    public void f() {
        this.f67045c = false;
        for (Request request : Util.k(this.f67043a)) {
            if (!request.g() && !request.isRunning()) {
                request.i();
            }
        }
        this.f67044b.clear();
    }

    public void g(Request request) {
        this.f67043a.add(request);
        if (!this.f67045c) {
            request.i();
            return;
        }
        request.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.f67044b.add(request);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.f67043a.size() + ", isPaused=" + this.f67045c + "}";
    }
}
