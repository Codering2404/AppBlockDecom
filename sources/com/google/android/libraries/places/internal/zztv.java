package com.google.android.libraries.places.internal;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class zztv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78603a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class f78604b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f78605c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f78606d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f78607e;

    protected zztv(String str, Class cls, boolean z2) {
        this(str, cls, z2, true);
    }

    public static zztv c(String str, Class cls) {
        return new zztv(str, cls, false, false);
    }

    protected void a(Iterator it, zztu zztuVar) {
        while (it.hasNext()) {
            b(it.next(), zztuVar);
        }
    }

    protected void b(Object obj, zztu zztuVar) {
        zztuVar.a(this.f78603a, obj);
    }

    public final String d() {
        return this.f78603a;
    }

    public final Object e(Object obj) {
        return this.f78604b.cast(obj);
    }

    public final boolean f() {
        return this.f78605c;
    }

    public final void g(Object obj, zztu zztuVar) {
        if (!this.f78606d || zzvn.a() <= 20) {
            b(obj, zztuVar);
        } else {
            zztuVar.a(this.f78603a, obj);
        }
    }

    public final void h(Iterator it, zztu zztuVar) {
        zzxb.c(this.f78605c, "non repeating key");
        if (!this.f78606d || zzvn.a() <= 20) {
            a(it, zztuVar);
        } else {
            while (it.hasNext()) {
                zztuVar.a(this.f78603a, it.next());
            }
        }
    }

    public final long i() {
        return this.f78607e;
    }

    public final String toString() {
        Class cls = this.f78604b;
        String name = getClass().getName();
        String name2 = cls.getName();
        int length = name.length();
        int length2 = name2.length();
        String str = this.f78603a;
        StringBuilder sb = new StringBuilder(length + 1 + str.length() + 1 + length2 + 1);
        sb.append(name);
        sb.append("/");
        sb.append(str);
        sb.append("[");
        sb.append(name2);
        sb.append("]");
        return sb.toString();
    }

    private zztv(String str, Class cls, boolean z2, boolean z3) {
        zzxb.d(str);
        this.f78603a = str;
        this.f78604b = cls;
        this.f78605c = z2;
        this.f78606d = z3;
        int iIdentityHashCode = System.identityHashCode(this);
        long j3 = 0;
        for (int i3 = 0; i3 < 5; i3++) {
            j3 |= 1 << (iIdentityHashCode & 63);
            iIdentityHashCode >>>= 6;
        }
        this.f78607e = j3;
    }
}
