package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvp extends zzbol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbld f76962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbku f76963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final zzbpc f76964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final zzbpd f76965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    List f76966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    zzbua f76967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    boolean f76968g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f76969h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    zzbnw f76970i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ zzbvr f76971j;

    zzbvp(zzbvr zzbvrVar, zzbld zzbldVar) {
        Objects.requireNonNull(zzbvrVar);
        this.f76971j = zzbvrVar;
        Preconditions.u(zzbldVar, "args");
        this.f76966e = zzbldVar.a();
        this.f76962a = zzbldVar;
        zzbku zzbkuVarB = zzbku.b("Subchannel", zzbvrVar.f());
        this.f76963b = zzbkuVarB;
        zzbpd zzbpdVar = new zzbpd(zzbkuVarB, 0, zzbvrVar.r0().zza(), "Subchannel for ".concat(String.valueOf(zzbldVar.a())));
        this.f76965d = zzbpdVar;
        this.f76964c = new zzbpc(zzbpdVar, zzbvrVar.r0());
    }

    @Override // com.google.android.libraries.places.internal.zzblm
    public final void a(zzblo zzbloVar) {
        zzbvr zzbvrVar = this.f76971j;
        zzbnx zzbnxVar = zzbvrVar.f77001n;
        zzbnxVar.b();
        Preconditions.A(!this.f76968g, "already started");
        Preconditions.A(!this.f76969h, "already shutdown");
        Preconditions.A(!zzbvrVar.x(), "Channel is being terminated");
        this.f76968g = true;
        String strF = zzbvrVar.f();
        ScheduledExecutorService scheduledExecutorServiceZzb = zzbvrVar.o0().zzb();
        zzbvn zzbvnVar = new zzbvn(this, zzbloVar);
        zzbmo zzbmoVarQ = zzbvrVar.m().f76934b.Q();
        zzbkn zzbknVarE = zzbvrVar.E();
        zzbpb zzbpbVarZza = zzbvrVar.A().zza();
        zzbpd zzbpdVar = this.f76965d;
        zzbku zzbkuVar = this.f76963b;
        zzbua zzbuaVar = new zzbua(this.f76962a, strF, zzbvrVar.k(), zzbvrVar.U(), zzbvrVar.o0(), scheduledExecutorServiceZzb, zzbvrVar.h(), zzbnxVar, zzbvnVar, zzbknVarE, zzbpbVarZza, zzbpdVar, zzbkuVar, this.f76964c, zzbvrVar.j(), zzbvrVar.n0(), zzbmoVarQ);
        zzbkj zzbkjVar = new zzbkj();
        zzbkjVar.a("Child Subchannel started");
        zzbkjVar.c(zzbkk.CT_INFO);
        zzbkjVar.b(zzbvrVar.r0().zza());
        zzbkjVar.d(zzbuaVar);
        zzbvrVar.C().a(zzbkjVar.e());
        this.f76967f = zzbuaVar;
        zzbvrVar.E().b(zzbuaVar);
        zzbvrVar.o().add(zzbuaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzblm
    public final void b() {
        zzbnw zzbnwVar;
        zzbvr zzbvrVar = this.f76971j;
        zzbnx zzbnxVar = zzbvrVar.f77001n;
        zzbnxVar.b();
        if (this.f76967f == null) {
            this.f76969h = true;
            return;
        }
        if (!this.f76969h) {
            this.f76969h = true;
        } else {
            if (!zzbvrVar.x() || (zzbnwVar = this.f76970i) == null) {
                return;
            }
            zzbnwVar.a();
            this.f76970i = null;
        }
        if (zzbvrVar.x()) {
            this.f76967f.a(zzbvr.f76978g0);
        } else {
            this.f76970i = zzbnxVar.c(new zzbuf(new zzbvo(this)), 5L, TimeUnit.SECONDS, zzbvrVar.o0().zzb());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzblm
    public final void c() {
        this.f76971j.f77001n.b();
        Preconditions.A(this.f76968g, "not started");
        if (this.f76969h) {
            return;
        }
        this.f76967f.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzblm
    public final void d(List list) {
        this.f76971j.f77001n.b();
        this.f76966e = list;
        this.f76967f.t(list);
    }

    @Override // com.google.android.libraries.places.internal.zzblm
    public final Object e() {
        Preconditions.A(this.f76968g, "Subchannel is not started");
        return this.f76967f;
    }

    public final String toString() {
        return this.f76963b.toString();
    }
}
