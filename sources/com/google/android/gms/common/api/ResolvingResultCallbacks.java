package com.google.android.gms.common.api;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.common.api.Result;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ResolvingResultCallbacks<R extends Result> extends ResultCallbacks<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f71531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f71532b;

    @Override // com.google.android.gms.common.api.ResultCallbacks
    public final void b(Status status) {
        if (!status.j0()) {
            d(status);
            return;
        }
        try {
            status.z0(this.f71531a, this.f71532b);
        } catch (IntentSender.SendIntentException e3) {
            Log.e("ResolvingResultCallback", "Failed to start resolution", e3);
            d(new Status(8));
        }
    }

    public abstract void d(Status status);
}
