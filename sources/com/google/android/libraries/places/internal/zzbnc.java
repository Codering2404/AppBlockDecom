package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbnc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f76452d = Logger.getLogger(zzbnc.class.getName());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static zzbnc f76453e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f76454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashSet f76455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImmutableMap f76456c;

    public zzbnc() {
        new zzbna(this, null);
        this.f76454a = "unknown";
        this.f76455b = new LinkedHashSet();
        this.f76456c = ImmutableMap.n();
    }

    private final synchronized void e(zzbmz zzbmzVar) {
        zzbmzVar.c();
        Preconditions.e(true, "isAvailable() returned false");
        this.f76455b.add(zzbmzVar);
    }

    private final synchronized void f() {
        try {
            HashMap map = new HashMap();
            String strB = "unknown";
            byte b3 = -2147483648;
            for (zzbmz zzbmzVar : this.f76455b) {
                String strB2 = zzbmzVar.b();
                if (((zzbmz) map.get(strB2)) != null) {
                    zzbmzVar.d();
                } else {
                    map.put(strB2, zzbmzVar);
                }
                zzbmzVar.d();
                if (b3 < 5) {
                    zzbmzVar.d();
                    strB = zzbmzVar.b();
                }
                b3 = 5;
            }
            this.f76456c = ImmutableMap.e(map);
            this.f76454a = strB;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized String a() {
        return this.f76454a;
    }

    public final zzbmz b(String str) {
        if (str == null) {
            return null;
        }
        return (zzbmz) d().get(str.toLowerCase(Locale.US));
    }

    final synchronized Map d() {
        return this.f76456c;
    }

    public static synchronized zzbnc c() {
        if (f76453e == null) {
            ArrayList arrayList = new ArrayList();
            try {
                int i3 = zzbsf.f76786b;
                arrayList.add(zzbsf.class);
            } catch (ClassNotFoundException e3) {
                f76452d.logp(Level.FINE, HcgZcEUYo.VFpCgoeEau, "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e3);
            }
            try {
                arrayList.add(Class.forName("io.grpc.binder.internal.IntentNameResolverProvider"));
            } catch (ClassNotFoundException e4) {
                f76452d.logp(Level.FINE, HcgZcEUYo.VFpCgoeEau, "getHardCodedClasses", "Unable to find IntentNameResolverProvider", (Throwable) e4);
            }
            List<zzbmz> listA = zzbnl.a(zzbmz.class, Collections.unmodifiableList(arrayList), zzbmz.class.getClassLoader(), new zzbnb(null));
            if (listA.isEmpty()) {
                f76452d.logp(Level.WARNING, HcgZcEUYo.VFpCgoeEau, "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            f76453e = new zzbnc();
            for (zzbmz zzbmzVar : listA) {
                f76452d.logp(Level.FINE, HcgZcEUYo.VFpCgoeEau, "getDefaultRegistry", "Service loader found ".concat(String.valueOf(zzbmzVar)));
                f76453e.e(zzbmzVar);
            }
            f76453e.f();
        }
        return f76453e;
    }
}
