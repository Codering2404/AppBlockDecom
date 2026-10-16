package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzblt {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Logger f76386c = Logger.getLogger(zzblt.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static zzblt f76387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Iterable f76388e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LinkedHashSet f76389a = new LinkedHashSet();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap f76390b = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        try {
            boolean z2 = zzbxj.f77153a;
            arrayList.add(zzbxj.class);
        } catch (ClassNotFoundException e3) {
            f76386c.logp(Level.WARNING, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find pick-first LoadBalancer", (Throwable) e3);
        }
        try {
            int i3 = zzcet.f77732a;
            arrayList.add(zzcet.class);
        } catch (ClassNotFoundException e4) {
            f76386c.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find round-robin LoadBalancer", (Throwable) e4);
        }
        f76388e = Collections.unmodifiableList(arrayList);
    }

    public static synchronized zzblt a() {
        try {
            if (f76387d == null) {
                List<zzblr> listA = zzbnl.a(zzblr.class, f76388e, zzblr.class.getClassLoader(), new zzbls());
                f76387d = new zzblt();
                for (zzblr zzblrVar : listA) {
                    f76386c.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(zzblrVar)));
                    f76387d.c(zzblrVar);
                }
                f76387d.d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f76387d;
    }

    private final synchronized void c(zzblr zzblrVar) {
        zzblrVar.b();
        Preconditions.e(true, "isAvailable() returned false");
        this.f76389a.add(zzblrVar);
    }

    private final synchronized void d() {
        try {
            LinkedHashMap linkedHashMap = this.f76390b;
            linkedHashMap.clear();
            for (zzblr zzblrVar : this.f76389a) {
                String strD = zzblrVar.d();
                if (((zzblr) linkedHashMap.get(strD)) != null) {
                    zzblrVar.c();
                } else {
                    linkedHashMap.put(strD, zzblrVar);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized zzblr b(String str) {
        return (zzblr) this.f76390b.get(Preconditions.u(str, "policy"));
    }
}
