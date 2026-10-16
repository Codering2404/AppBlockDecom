package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwo {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator f78751b = new zzwh();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzwo f78752c = new zzwo(new zzwm(Collections.EMPTY_LIST));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzwm f78753a;

    private zzwo(zzwm zzwmVar) {
        this.f78753a = zzwmVar;
    }

    public final Map a() {
        return this.f78753a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzwo) && ((zzwo) obj).f78753a.equals(this.f78753a);
    }

    public final int hashCode() {
        return ~this.f78753a.hashCode();
    }

    public final String toString() {
        return this.f78753a.toString();
    }
}
