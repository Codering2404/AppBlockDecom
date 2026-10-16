package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zaz implements zabz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zaaa f71866a;

    /* synthetic */ zaz(zaaa zaaaVar, zay zayVar) {
        this.f71866a = zaaaVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void a(Bundle bundle) {
        this.f71866a.f71636n.lock();
        try {
            this.f71866a.f71634l = ConnectionResult.f71433g;
            zaaa.y(this.f71866a);
        } finally {
            this.f71866a.f71636n.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void b(int i3, boolean z2) {
        this.f71866a.f71636n.lock();
        try {
            zaaa zaaaVar = this.f71866a;
            if (zaaaVar.f71635m) {
                zaaaVar.f71635m = false;
                zaaa.w(this.f71866a, i3, z2);
            } else {
                zaaaVar.f71635m = true;
                this.f71866a.f71627d.onConnectionSuspended(i3);
            }
            this.f71866a.f71636n.unlock();
        } catch (Throwable th) {
            this.f71866a.f71636n.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void c(ConnectionResult connectionResult) {
        this.f71866a.f71636n.lock();
        try {
            this.f71866a.f71634l = connectionResult;
            zaaa.y(this.f71866a);
        } finally {
            this.f71866a.f71636n.unlock();
        }
    }
}
