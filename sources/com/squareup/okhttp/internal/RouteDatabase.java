package com.squareup.okhttp.internal;

import com.squareup.okhttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public final class RouteDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f93118a = new LinkedHashSet();

    public synchronized void a(Route route) {
        this.f93118a.remove(route);
    }

    public synchronized void b(Route route) {
        this.f93118a.add(route);
    }

    public synchronized boolean c(Route route) {
        return this.f93118a.contains(route);
    }
}
