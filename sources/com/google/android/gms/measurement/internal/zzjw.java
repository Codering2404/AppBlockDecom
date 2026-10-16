package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.util.SparseArray;
import com.google.common.util.concurrent.FutureCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzjw implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzoh f74039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74040b;

    zzjw(zzlj zzljVar, zzoh zzohVar) {
        this.f74039a = zzohVar;
        Objects.requireNonNull(zzljVar);
        this.f74040b = zzljVar;
    }

    private final void a() {
        zzic zzicVar = this.f74040b.f73997a;
        SparseArray sparseArrayR = zzicVar.x().r();
        zzoh zzohVar = this.f74039a;
        sparseArrayR.put(zzohVar.f74383c, Long.valueOf(zzohVar.f74382b));
        zzhh zzhhVarX = zzicVar.x();
        int[] iArr = new int[sparseArrayR.size()];
        long[] jArr = new long[sparseArrayR.size()];
        for (int i3 = 0; i3 < sparseArrayR.size(); i3++) {
            iArr[i3] = sparseArrayR.keyAt(i3);
            jArr[i3] = ((Long) sparseArrayR.valueAt(i3)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        zzhhVarX.f73821o.b(bundle);
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzlj zzljVar = this.f74040b;
        zzljVar.h();
        zzljVar.Z(false);
        zzic zzicVar = zzljVar.f73997a;
        int iD0 = (zzicVar.w().H(null, zzfy.U0) ? zzljVar.d0(th) : 2) - 1;
        if (iD0 == 0) {
            zzicVar.a().r().c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", zzgu.x(zzljVar.f73997a.L().q()), zzgu.x(th.toString()));
            zzljVar.b0(1);
            zzljVar.w0().add(this.f74039a);
            return;
        }
        if (iD0 != 1) {
            zzicVar.a().o().c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", zzgu.x(zzljVar.f73997a.L().q()), th);
            a();
            zzljVar.b0(1);
            zzljVar.x0();
            return;
        }
        zzljVar.w0().add(this.f74039a);
        if (zzljVar.a0() > ((Integer) zzfy.f73678x0.b(null)).intValue()) {
            zzljVar.b0(1);
            zzicVar.a().r().c("registerTriggerAsync failed. May try later. App ID, throwable", zzgu.x(zzljVar.f73997a.L().q()), zzgu.x(th.toString()));
        } else {
            zzicVar.a().r().d("registerTriggerAsync failed. App ID, delay in seconds, throwable", zzgu.x(zzljVar.f73997a.L().q()), zzgu.x(String.valueOf(zzljVar.a0())), zzgu.x(th.toString()));
            zzljVar.V(zzljVar.a0());
            int iA0 = zzljVar.a0();
            zzljVar.b0(iA0 + iA0);
        }
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        zzlj zzljVar = this.f74040b;
        zzljVar.h();
        a();
        zzljVar.Z(false);
        zzljVar.b0(1);
        zzljVar.f73997a.a().v().b("Successfully registered trigger URI", this.f74039a.f74381a);
        zzljVar.x0();
    }
}
