package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbjd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbis f76273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f76274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f76275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f76276d;

    zzbjd(zzbis zzbisVar, int i3, boolean z2, boolean z3) {
        this.f76273a = (zzbis) Preconditions.u(zzbisVar, "callOptions");
        this.f76274b = i3;
        this.f76275c = z2;
        this.f76276d = z3;
    }

    public static zzbjc a() {
        return new zzbjc();
    }

    public final String toString() {
        return MoreObjects.c(this).d("callOptions", this.f76273a).b("previousAttempts", this.f76274b).e("isTransparentRetry", this.f76275c).e("isHedging", this.f76276d).toString();
    }
}
