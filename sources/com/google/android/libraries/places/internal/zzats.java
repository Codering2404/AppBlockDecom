package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzats {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final zzats f75883c = new zzats(zzatq.PROCEED, null, null, null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzatq f75884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ListenableFuture f75885b;

    static {
        new zzats(zzatq.DELAY_START, null, null, null, null);
    }

    private zzats(zzatq zzatqVar, zzatr zzatrVar, zzatn zzatnVar, ListenableFuture listenableFuture, zzbis zzbisVar) {
        this.f75884a = (zzatq) Preconditions.t(zzatqVar);
        this.f75885b = listenableFuture;
    }

    public static zzats a() {
        return f75883c;
    }

    public static zzats b(ListenableFuture listenableFuture) {
        Preconditions.t(listenableFuture);
        return new zzats(zzatq.CONTINUE_AFTER, null, null, listenableFuture, null);
    }

    public final zzatq c() {
        return this.f75884a;
    }

    public final ListenableFuture d() {
        Preconditions.z(this.f75884a == zzatq.CONTINUE_AFTER);
        return this.f75885b;
    }
}
