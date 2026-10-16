package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zax implements zabz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zaaa f71865a;

    /* synthetic */ zax(zaaa zaaaVar, zaw zawVar) {
        this.f71865a = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void a(Bundle bundle) {
        this.f71865a.f71636n.lock();
        try {
            zaaa.x(this.f71865a, bundle);
            this.f71865a.f71633k = ConnectionResult.f71433g;
            zaaa.y(this.f71865a);
        } finally {
            this.f71865a.f71636n.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void b(int i3, boolean z2) {
        this.f71865a.f71636n.lock();
        try {
            zaaa zaaaVar = this.f71865a;
            if (zaaaVar.f71635m || zaaaVar.f71634l == null || !zaaaVar.f71634l.w0()) {
                this.f71865a.f71635m = false;
                zaaa.w(this.f71865a, i3, z2);
            } else {
                this.f71865a.f71635m = true;
                this.f71865a.f71628f.onConnectionSuspended(i3);
            }
            this.f71865a.f71636n.unlock();
        } catch (Throwable th) {
            this.f71865a.f71636n.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void c(ConnectionResult connectionResult) {
        this.f71865a.f71636n.lock();
        try {
            this.f71865a.f71633k = connectionResult;
            zaaa.y(this.f71865a);
        } finally {
            this.f71865a.f71636n.unlock();
        }
    }
}
