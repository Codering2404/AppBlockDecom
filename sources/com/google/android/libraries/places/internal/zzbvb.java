package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbvb extends zzbmu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final zzbuz f76937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final zzbmy f76938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbvr f76939c;

    zzbvb(zzbvr zzbvrVar, zzbuz zzbuzVar, zzbmy zzbmyVar) {
        Objects.requireNonNull(zzbvrVar);
        this.f76939c = zzbvrVar;
        this.f76937a = (zzbuz) Preconditions.u(zzbuzVar, "helperImpl");
        this.f76938b = (zzbmy) Preconditions.u(zzbmyVar, "resolver");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void b(zzbnp zzbnpVar) {
        Logger logger = zzbvr.f76976e0;
        Level level = Level.WARNING;
        zzbvr zzbvrVar = this.f76939c;
        logger.logp(level, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "handleErrorInSyncContext", "[{0}] Failed to resolve name. status={1}", new Object[]{zzbvrVar.zzc(), zzbnpVar});
        zzbvrVar.F().h();
        if (zzbvrVar.S() != 3) {
            zzbvrVar.D().b(3, "Failed to resolve name: {0}", zzbnpVar);
            zzbvrVar.T(3);
        }
        zzbuz zzbuzVar = this.f76937a;
        if (zzbuzVar != zzbvrVar.m()) {
            return;
        }
        zzbuzVar.f76933a.c().b(zzbnpVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbmu
    public final zzbnp a(zzbmw zzbmwVar) {
        zzbwb zzbwbVar;
        zzbvr zzbvrVar = this.f76939c;
        zzbnx zzbnxVar = zzbvrVar.f77001n;
        zzbnxVar.b();
        if (zzbvrVar.l() != this.f76938b) {
            return zzbnp.f76488e;
        }
        zzbnr zzbnrVarB = zzbmwVar.b();
        if (!zzbnrVarB.c()) {
            b(zzbnrVarB.e());
            return zzbnrVarB.e();
        }
        List list = (List) zzbnrVarB.d();
        zzbvrVar.D().b(1, "Resolved address: {0}, config={1}", list, zzbmwVar.c());
        if (zzbvrVar.S() != 2) {
            zzbvrVar.D().b(2, "Address resolved: {0}", list);
            zzbvrVar.T(2);
        }
        zzbms zzbmsVarD = zzbmwVar.d();
        zzbkq zzbkqVar = (zzbkq) zzbmwVar.c().a(zzbkq.f76351a);
        zzbwb zzbwbVarG = (zzbmsVarD == null || zzbmsVarD.c() == null) ? null : (zzbwb) zzbmsVarD.c();
        zzbnp zzbnpVarD = zzbmsVarD != null ? zzbmsVarD.d() : null;
        if (zzbvrVar.K()) {
            if (zzbwbVarG != null) {
                if (zzbkqVar != null) {
                    zzbvrVar.F().g(zzbkqVar);
                    if (zzbwbVarG.b() != null) {
                        zzbvrVar.D().a(1, "Method configs in service config will be discarded due to presence ofconfig-selector");
                    }
                } else {
                    zzbvrVar.F().g(zzbwbVarG.b());
                }
            } else if (zzbnpVarD == null) {
                zzbvrVar.F().g(null);
                zzbwbVarG = zzbvr.f76980i0;
            } else {
                if (!zzbvrVar.I()) {
                    zzbvrVar.D().a(2, "Fallback to error due to invalid first service config without default config");
                    zzbnp zzbnpVarD2 = zzbmsVarD.d();
                    Preconditions.e(!zzbnpVarD2.j(), "the error status must not be OK");
                    zzbnxVar.a(new zzbva(this, zzbnpVarD2));
                    zzbnxVar.zza();
                    return zzbmsVarD.d();
                }
                zzbwbVarG = zzbvrVar.G();
            }
            if (!zzbwbVarG.equals(zzbvrVar.G())) {
                zzbvrVar.D().b(2, "Service config changed{0}", zzbwbVarG == zzbvr.f76980i0 ? " to empty" : "");
                zzbvrVar.H(zzbwbVarG);
                zzbvrVar.P().f76916a = zzbwbVarG.d();
            }
            try {
                zzbvrVar.J(true);
            } catch (RuntimeException e3) {
                zzbvr zzbvrVar2 = this.f76939c;
                Logger logger = zzbvr.f76976e0;
                Level level = Level.WARNING;
                String strValueOf = String.valueOf(zzbvrVar2.zzc());
                StringBuilder sb = new StringBuilder(strValueOf.length() + 51);
                sb.append("[");
                sb.append(strValueOf);
                sb.append("] Unexpected exception from parsing service config");
                logger.logp(level, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "onResult2", sb.toString(), (Throwable) e3);
            }
            zzbwbVar = zzbwbVarG;
        } else {
            if (zzbwbVarG != null) {
                zzbvrVar.D().a(2, "Service config from name resolver discarded by channel settings");
            }
            if (zzbkqVar != null) {
                zzbvrVar.D().a(2, "Config selector from name resolver discarded by channel settings");
            }
            zzbvl zzbvlVarF = zzbvrVar.F();
            zzbwbVar = zzbvr.f76980i0;
            zzbvlVarF.g(zzbwbVar.b());
        }
        zzbio zzbioVarC = zzbmwVar.c();
        zzbuz zzbuzVar = this.f76937a;
        if (zzbuzVar != this.f76939c.m()) {
            return zzbnp.f76488e;
        }
        zzbim zzbimVarC = zzbioVarC.c();
        zzbimVarC.b(zzbkq.f76351a);
        Map mapA = zzbwbVar.a();
        if (mapA != null) {
            zzbimVarC.a(zzblp.f76381a, mapA);
            zzbimVarC.c();
        }
        zzbio zzbioVarC2 = zzbimVarC.c();
        zzblk zzblkVarA = zzbll.a();
        zzblkVarA.a((List) zzbnrVarB.d());
        zzblkVarA.b(zzbioVarC2);
        zzblkVarA.c(zzbwbVar.c());
        return zzbuzVar.f76933a.a(zzblkVarA.d());
    }
}
