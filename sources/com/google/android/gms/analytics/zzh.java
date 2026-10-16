package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzk f70897a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Clock f70898b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f70899c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f70900d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f70901e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f70902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f70903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f70904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f70905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map f70906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List f70907k;

    zzh(zzh zzhVar) {
        this.f70897a = zzhVar.f70897a;
        this.f70898b = zzhVar.f70898b;
        this.f70900d = zzhVar.f70900d;
        this.f70901e = zzhVar.f70901e;
        this.f70902f = zzhVar.f70902f;
        this.f70903g = zzhVar.f70903g;
        this.f70904h = zzhVar.f70904h;
        this.f70907k = new ArrayList(zzhVar.f70907k);
        this.f70906j = new HashMap(zzhVar.f70906j.size());
        for (Map.Entry entry : zzhVar.f70906j.entrySet()) {
            zzj zzjVarN = n((Class) entry.getKey());
            ((zzj) entry.getValue()).zzc(zzjVarN);
            this.f70906j.put((Class) entry.getKey(), zzjVarN);
        }
    }

    private static zzj n(Class cls) {
        try {
            return (zzj) cls.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e3) {
            if (e3 instanceof InstantiationException) {
                throw new IllegalArgumentException("dataType doesn't have default constructor", e3);
            }
            if (e3 instanceof IllegalAccessException) {
                throw new IllegalArgumentException("dataType default constructor is not accessible", e3);
            }
            if (e3 instanceof ReflectiveOperationException) {
                throw new IllegalArgumentException("Linkage exception", e3);
            }
            throw new RuntimeException(e3);
        }
    }

    public final long a() {
        return this.f70900d;
    }

    public final zzj b(Class cls) {
        zzj zzjVar = (zzj) this.f70906j.get(cls);
        if (zzjVar != null) {
            return zzjVar;
        }
        zzj zzjVarN = n(cls);
        this.f70906j.put(cls, zzjVarN);
        return zzjVarN;
    }

    public final zzj c(Class cls) {
        return (zzj) this.f70906j.get(cls);
    }

    final zzk d() {
        return this.f70897a;
    }

    public final Collection e() {
        return this.f70906j.values();
    }

    public final List f() {
        return this.f70907k;
    }

    public final void g(zzj zzjVar) {
        Preconditions.m(zzjVar);
        Class<?> cls = zzjVar.getClass();
        if (cls.getSuperclass() != zzj.class) {
            throw new IllegalArgumentException();
        }
        zzjVar.zzc(b(cls));
    }

    final void h() {
        this.f70905i = true;
    }

    final void i() {
        this.f70902f = this.f70898b.a();
        long j3 = this.f70901e;
        if (j3 != 0) {
            this.f70900d = j3;
        } else {
            this.f70900d = this.f70898b.currentTimeMillis();
        }
        this.f70899c = true;
    }

    public final void j(long j3) {
        this.f70901e = j3;
    }

    public final void k() {
        this.f70897a.b().k(this);
    }

    final boolean l() {
        return this.f70905i;
    }

    public final boolean m() {
        return this.f70899c;
    }

    zzh(zzk zzkVar, Clock clock) {
        Preconditions.m(zzkVar);
        Preconditions.m(clock);
        this.f70897a = zzkVar;
        this.f70898b = clock;
        this.f70903g = 1800000L;
        this.f70904h = 3024000000L;
        this.f70906j = new HashMap();
        this.f70907k = new ArrayList();
    }
}
