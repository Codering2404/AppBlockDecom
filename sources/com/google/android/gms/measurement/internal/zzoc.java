package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzoc extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f74367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f74368d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final zzob f74369e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final zzoa f74370f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected final zzny f74371g;

    zzoc(zzic zzicVar) {
        super(zzicVar);
        this.f74368d = true;
        this.f74369e = new zzob(this);
        this.f74370f = new zzoa(this);
        this.f74371g = new zzny(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public final void q() {
        h();
        if (this.f74367c == null) {
            this.f74367c = new com.google.android.gms.internal.measurement.zzcn(Looper.getMainLooper());
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return false;
    }

    final void o(boolean z2) {
        h();
        this.f74368d = z2;
    }

    final boolean p() {
        h();
        return this.f74368d;
    }

    final /* synthetic */ void r(long j3) {
        h();
        q();
        zzic zzicVar = this.f73997a;
        zzicVar.a().w().b("Activity resumed, time", Long.valueOf(j3));
        if (zzicVar.w().H(null, zzfy.V0)) {
            if (zzicVar.w().N() || this.f74368d) {
                this.f74370f.a(j3);
            }
        } else if (zzicVar.w().N() || zzicVar.x().f73826t.a()) {
            this.f74370f.a(j3);
        }
        this.f74371g.a();
        zzob zzobVar = this.f74369e;
        zzoc zzocVar = zzobVar.f74366a;
        zzocVar.h();
        if (zzocVar.f73997a.g()) {
            zzobVar.b(zzocVar.f73997a.e().currentTimeMillis(), false);
        }
    }

    final /* synthetic */ void s(long j3) {
        h();
        q();
        zzic zzicVar = this.f73997a;
        zzicVar.a().w().b("Activity paused, time", Long.valueOf(j3));
        this.f74371g.b(j3);
        if (zzicVar.w().N()) {
            this.f74370f.b(j3);
        }
    }

    final /* synthetic */ Handler t() {
        return this.f74367c;
    }
}
