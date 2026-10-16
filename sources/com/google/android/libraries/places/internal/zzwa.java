package com.google.android.libraries.places.internal;

import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzwa implements zzvs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f78716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Level f78717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f78718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzva f78719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f78720e;

    private zzwa(String str, boolean z2, int i3, Level level, boolean z3, Set set, zzva zzvaVar) {
        this.f78716a = "";
        this.f78720e = 2;
        this.f78717b = level;
        this.f78718c = set;
        this.f78719d = zzvaVar;
    }

    public final zzwa a(boolean z2) {
        Set set = this.f78718c;
        zzva zzvaVar = this.f78719d;
        return new zzwa(this.f78716a, true, 2, Level.OFF, false, set, zzvaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzvs
    public final zzup zza(String str) {
        return new zzwc(this.f78716a, str, true, 2, this.f78717b, this.f78718c, this.f78719d, null);
    }

    private zzwa() {
        this("", true, 2, Level.ALL, false, zzwc.f78726g, zzwc.f78727h);
    }

    /* synthetic */ zzwa(byte[] bArr) {
        this("", true, 2, Level.ALL, false, zzwc.f78726g, zzwc.f78727h);
    }
}
