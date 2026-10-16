package com.google.android.libraries.places.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbkn {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f76342d = Logger.getLogger(zzbkn.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzbkn f76343e = new zzbkn();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f76344f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentNavigableMap f76345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap f76346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ConcurrentMap f76347c;

    public zzbkn() {
        new ConcurrentSkipListMap();
        this.f76345a = new ConcurrentSkipListMap();
        this.f76346b = new ConcurrentHashMap();
        this.f76347c = new ConcurrentHashMap();
        new ConcurrentHashMap();
    }

    public static zzbkn a() {
        return f76343e;
    }

    private static void i(Map map, zzbkt zzbktVar) {
    }

    private static void j(Map map, zzbkt zzbktVar) {
    }

    public final void b(zzbkt zzbktVar) {
        i(this.f76346b, zzbktVar);
    }

    public final void c(zzbkt zzbktVar) {
        i(this.f76345a, zzbktVar);
    }

    public final void d(zzbkt zzbktVar) {
        i(this.f76347c, zzbktVar);
    }

    public final void e(zzbkt zzbktVar) {
        j(this.f76346b, zzbktVar);
    }

    public final void f(zzbkt zzbktVar) {
        j(this.f76345a, zzbktVar);
    }

    public final void g(zzbkt zzbktVar) {
        j(this.f76347c, zzbktVar);
    }
}
