package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbnw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbnv f76513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledFuture f76514b;

    /* synthetic */ zzbnw(zzbnv zzbnvVar, ScheduledFuture scheduledFuture, byte[] bArr) {
        this.f76513a = (zzbnv) Preconditions.u(zzbnvVar, "runnable");
        this.f76514b = (ScheduledFuture) Preconditions.u(scheduledFuture, "future");
    }

    public final void a() {
        this.f76513a.f76511b = true;
        this.f76514b.cancel(false);
    }

    public final boolean b() {
        zzbnv zzbnvVar = this.f76513a;
        return (zzbnvVar.f76512c || zzbnvVar.f76511b) ? false : true;
    }
}
