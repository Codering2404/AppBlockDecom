package com.google.firebase.platforminfo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class GlobalLibraryVersionRegistrar {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile GlobalLibraryVersionRegistrar f89618b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set f89619a = new HashSet();

    GlobalLibraryVersionRegistrar() {
    }

    public static GlobalLibraryVersionRegistrar a() {
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar;
        GlobalLibraryVersionRegistrar globalLibraryVersionRegistrar2 = f89618b;
        if (globalLibraryVersionRegistrar2 != null) {
            return globalLibraryVersionRegistrar2;
        }
        synchronized (GlobalLibraryVersionRegistrar.class) {
            try {
                globalLibraryVersionRegistrar = f89618b;
                if (globalLibraryVersionRegistrar == null) {
                    globalLibraryVersionRegistrar = new GlobalLibraryVersionRegistrar();
                    f89618b = globalLibraryVersionRegistrar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return globalLibraryVersionRegistrar;
    }

    Set b() {
        Set setUnmodifiableSet;
        synchronized (this.f89619a) {
            setUnmodifiableSet = Collections.unmodifiableSet(this.f89619a);
        }
        return setUnmodifiableSet;
    }
}
