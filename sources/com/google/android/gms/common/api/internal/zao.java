package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zao implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zam f71854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zap f71855b;

    zao(zap zapVar, zam zamVar) {
        this.f71855b = zapVar;
        this.f71854a = zamVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f71855b.f71856a) {
            ConnectionResult connectionResultB = this.f71854a.b();
            if (connectionResultB.j0()) {
                zap zapVar = this.f71855b;
                zapVar.mLifecycleFragment.startActivityForResult(GoogleApiActivity.a(zapVar.getActivity(), (PendingIntent) Preconditions.m(connectionResultB.g0()), this.f71854a.a(), false), 1);
                return;
            }
            zap zapVar2 = this.f71855b;
            if (zapVar2.f71859d.d(zapVar2.getActivity(), connectionResultB.N(), null) != null) {
                zap zapVar3 = this.f71855b;
                zapVar3.f71859d.z(zapVar3.getActivity(), zapVar3.mLifecycleFragment, connectionResultB.N(), 2, this.f71855b);
                return;
            }
            if (connectionResultB.N() != 18) {
                this.f71855b.a(connectionResultB, this.f71854a.a());
                return;
            }
            zap zapVar4 = this.f71855b;
            Dialog dialogU = zapVar4.f71859d.u(zapVar4.getActivity(), zapVar4);
            zap zapVar5 = this.f71855b;
            zapVar5.f71859d.v(zapVar5.getActivity().getApplicationContext(), new zan(this, dialogU));
        }
    }
}
