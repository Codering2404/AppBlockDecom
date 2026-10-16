package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzux extends zzva {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f78671a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f78672b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzuz f78673c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzuy f78674d;

    /* synthetic */ zzux(zzuw zzuwVar, byte[] bArr) {
        HashMap map = new HashMap();
        this.f78671a = map;
        HashMap map2 = new HashMap();
        this.f78672b = map2;
        map.putAll(zzuwVar.d());
        map2.putAll(zzuwVar.e());
        this.f78673c = zzuwVar.f();
        this.f78674d = zzuwVar.g();
    }

    @Override // com.google.android.libraries.places.internal.zzva
    protected final void a(zztv zztvVar, Object obj, Object obj2) {
        zzuz zzuzVar = (zzuz) this.f78671a.get(zztvVar);
        if (zzuzVar != null) {
            zzuzVar.a(zztvVar, obj, obj2);
        } else {
            this.f78673c.a(zztvVar, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzva
    protected final void b(zztv zztvVar, Iterator it, Object obj) {
        zzuy zzuyVar = (zzuy) this.f78672b.get(zztvVar);
        if (zzuyVar != null) {
            zzuyVar.a(zztvVar, it, obj);
            return;
        }
        zzuy zzuyVar2 = this.f78674d;
        if (zzuyVar2 != null && !this.f78671a.containsKey(zztvVar)) {
            zzuyVar2.a(zztvVar, it, obj);
        } else {
            while (it.hasNext()) {
                a(zztvVar, it.next(), obj);
            }
        }
    }
}
