package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zae extends zai {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final BaseImplementation.ApiMethodImpl f71833b;

    public zae(int i3, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i3);
        this.f71833b = (BaseImplementation.ApiMethodImpl) Preconditions.n(apiMethodImpl, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(Status status) {
        try {
            this.f71833b.setFailedResult(status);
        } catch (IllegalStateException e3) {
            Log.w("ApiCallRunner", "Exception reporting failure", e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(Exception exc) {
        try {
            this.f71833b.setFailedResult(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException e3) {
            Log.w("ApiCallRunner", "Exception reporting failure", e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(zabq zabqVar) throws DeadObjectException {
        try {
            this.f71833b.run(zabqVar.t());
        } catch (RuntimeException e3) {
            b(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void d(zaad zaadVar, boolean z2) {
        zaadVar.c(this.f71833b, z2);
    }
}
