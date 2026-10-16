package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbjm {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static zzbjm f76282c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f76283a = Collections.EMPTY_LIST;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f76284b = 0;

    zzbjm() {
    }

    public static synchronized zzbjm a() {
        try {
            if (f76282c == null) {
                f76282c = new zzbjm();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f76282c;
    }

    public final synchronized List b() {
        this.f76284b++;
        return this.f76283a;
    }

    public final synchronized boolean c() {
        return false;
    }
}
