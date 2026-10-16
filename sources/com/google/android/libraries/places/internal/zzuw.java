package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzuw {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final zzuz f78665e = new zzuu();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzuy f78666f = new zzuv();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzuz f78669c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f78667a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f78668b = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzuy f78670d = null;

    public final zzuw a(zzuy zzuyVar) {
        this.f78670d = zzuyVar;
        return this;
    }

    final void b(zztv zztvVar) {
        zzxb.a(zztvVar, "key");
        if (!zztvVar.f()) {
            zzuz zzuzVar = f78665e;
            zzxb.a(zztvVar, "key");
            this.f78668b.remove(zztvVar);
            this.f78667a.put(zztvVar, zzuzVar);
            return;
        }
        zzuy zzuyVar = f78666f;
        zzxb.a(zztvVar, "key");
        zzxb.b(zztvVar.f(), "key must be repeating");
        this.f78667a.remove(zztvVar);
        this.f78668b.put(zztvVar, zzuyVar);
    }

    public final zzva c() {
        return new zzux(this, null);
    }

    final /* synthetic */ Map d() {
        return this.f78667a;
    }

    final /* synthetic */ Map e() {
        return this.f78668b;
    }

    final /* synthetic */ zzuz f() {
        return this.f78669c;
    }

    final /* synthetic */ zzuy g() {
        return this.f78670d;
    }
}
