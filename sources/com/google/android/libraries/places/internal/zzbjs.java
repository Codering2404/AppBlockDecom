package com.google.android.libraries.places.internal;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f76294a = Logger.getLogger(zzbjs.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final zzbjs f76295b = new zzbjs();

    private zzbjs() {
    }

    public static zzbjs a() {
        zzbjs zzbjsVarC = zzbjq.f76293a.c();
        return zzbjsVarC == null ? f76295b : zzbjsVarC;
    }

    static Object e(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public final zzbjs b() {
        zzbjs zzbjsVarA = zzbjq.f76293a.a(this);
        return zzbjsVarA == null ? f76295b : zzbjsVarA;
    }

    public final void c(zzbjs zzbjsVar) {
        e(zzbjsVar, "toAttach");
        zzbjq.f76293a.b(this, zzbjsVar);
    }

    public final void d(zzbjp zzbjpVar, Executor executor) {
        e(executor, "executor");
    }
}
