package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzrd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final WeakHashMap f78503a = new WeakHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final WeakHashMap f78504b = new WeakHashMap();

    public static void a(Throwable th) {
        Throwable cause;
        zzsf zzsfVar;
        zzrv zzrvVar;
        WeakHashMap weakHashMap = f78504b;
        synchronized (weakHashMap) {
            cause = th;
            while (cause != null) {
                try {
                    if (weakHashMap.containsKey(cause)) {
                        break;
                    } else {
                        cause = cause.getCause();
                    }
                } finally {
                }
            }
            weakHashMap.put(th, Boolean.valueOf(cause != null));
        }
        if (cause != null) {
            return;
        }
        Preconditions.A(true, "Trace uncaught exception is disabled.");
        WeakHashMap weakHashMap2 = f78503a;
        synchronized (weakHashMap2) {
            Throwable cause2 = th;
            while (cause2 != null) {
                try {
                    if (weakHashMap2.containsKey(cause2)) {
                        break;
                    } else {
                        cause2 = cause2.getCause();
                    }
                } finally {
                }
            }
            if (cause2 == null) {
                zzsfVar = null;
            } else {
                zzrz zzrzVar = (zzrz) weakHashMap2.get(cause2);
                weakHashMap2.put(th, zzrzVar);
                zzsfVar = new zzsf(cause2, zzrzVar);
            }
        }
        if (zzsfVar != null || (zzrvVar = zzrh.d().f78537b) == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzrvVar = zzrh.d().f78537b; zzrvVar != null; zzrvVar = null) {
            arrayList.add(zzrvVar);
        }
        zzqy zzqyVar = new zzqy();
        zzqyVar.c(((zzrv) arrayList.get(0)).zzc());
        ((zzrv) arrayList.get(0)).zzi();
        zzqyVar.d(-1L);
        ImmutableList.Builder builderP = ImmutableList.p(arrayList.size());
        ImmutableList.Builder builderP2 = ImmutableList.p(arrayList.size());
        for (zzrv zzrvVar2 : Lists.o(arrayList)) {
            builderP2.a(zzrvVar2.zze());
            builderP.a(zzrvVar2.zzg());
        }
        synchronized (weakHashMap2) {
            zzqyVar.a(builderP2.m());
            zzqyVar.b(builderP.m());
            weakHashMap2.put(th, zzqyVar.e());
        }
    }
}
