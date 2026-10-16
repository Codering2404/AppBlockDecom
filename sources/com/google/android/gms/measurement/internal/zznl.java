package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.experimental.kJ.HcgZcEUYo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznl extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zznf f74319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzgb f74320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Boolean f74321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzay f74322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ScheduledExecutorService f74323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzog f74324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final List f74325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzay f74326j;

    protected zznl(zzic zzicVar) {
        super(zzicVar);
        this.f74325i = new ArrayList();
        this.f74324h = new zzog(zzicVar.e());
        this.f74319c = new zznf(this);
        this.f74322f = new zzmm(this, zzicVar);
        this.f74326j = new zzmq(this, zzicVar);
    }

    private final boolean R() {
        this.f73997a.c();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void J() {
        h();
        this.f74324h.a();
        this.f73997a.w();
        this.f74322f.b(((Long) zzfy.Z.b(null)).longValue());
    }

    private final void T(Runnable runnable) {
        h();
        if (W()) {
            runnable.run();
            return;
        }
        List list = this.f74325i;
        long size = list.size();
        zzic zzicVar = this.f73997a;
        zzicVar.w();
        if (size >= 1000) {
            zzicVar.a().o().a("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.f74326j.b(60000L);
        w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void L() {
        h();
        zzgs zzgsVarW = this.f73997a.a().w();
        List list = this.f74325i;
        zzgsVarW.b("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e3) {
                this.f73997a.a().o().b("Task exception while flushing queue", e3);
            }
        }
        this.f74325i.clear();
        this.f74326j.d();
    }

    private final zzr V(boolean z2) {
        Pair pairB;
        zzic zzicVar = this.f73997a;
        zzicVar.c();
        zzgi zzgiVarL = this.f73997a.L();
        String string = null;
        if (z2) {
            zzic zzicVar2 = zzicVar.a().f73997a;
            if (zzicVar2.x().f73811e != null && (pairB = zzicVar2.x().f73811e.b()) != null && pairB != zzhh.A) {
                String strValueOf = String.valueOf(pairB.second);
                String str = (String) pairB.first;
                StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(str).length());
                sb.append(strValueOf);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(str);
                string = sb.toString();
            }
        }
        return zzgiVarL.o(string);
    }

    public final void A() {
        h();
        j();
        zznf zznfVar = this.f74319c;
        zznfVar.b();
        try {
            ConnectionTracker.b().c(this.f73997a.d(), zznfVar);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f74320d = null;
    }

    final boolean C() {
        h();
        j();
        return !y() || this.f73997a.C().W() >= ((Integer) zzfy.K0.b(null)).intValue();
    }

    final boolean D() {
        h();
        j();
        return !y() || this.f73997a.C().W() >= 241200;
    }

    final /* synthetic */ void E() {
        zzgb zzgbVar = this.f74320d;
        if (zzgbVar == null) {
            this.f73997a.a().o().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            zzr zzrVarV = V(false);
            Preconditions.m(zzrVarV);
            zzgbVar.F0(zzrVarV);
            J();
        } catch (RemoteException e3) {
            this.f73997a.a().o().b("Failed to send storage consent settings to the service", e3);
        }
    }

    final /* synthetic */ void F() {
        zzgb zzgbVar = this.f74320d;
        if (zzgbVar == null) {
            this.f73997a.a().o().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            zzr zzrVarV = V(false);
            Preconditions.m(zzrVarV);
            zzgbVar.Z0(zzrVarV);
            J();
        } catch (RemoteException e3) {
            this.f73997a.a().o().b("Failed to send Dma consent settings to the service", e3);
        }
    }

    final /* synthetic */ void G(AtomicReference atomicReference, zzr zzrVar, Bundle bundle) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.f74320d;
            } catch (RemoteException e3) {
                this.f73997a.a().o().b("Failed to request trigger URIs; remote exception", e3);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.f73997a.a().o().a("Failed to request trigger URIs; not connected to service");
                return;
            }
            Preconditions.m(zzrVar);
            zzgbVar.w3(zzrVar, bundle, new zzme(this, atomicReference));
            J();
        }
    }

    final /* synthetic */ void H(AtomicReference atomicReference, zzr zzrVar, zzoo zzooVar) {
        zzgb zzgbVar;
        synchronized (atomicReference) {
            try {
                zzgbVar = this.f74320d;
            } catch (RemoteException e3) {
                this.f73997a.a().o().b("[sgtm] Failed to get upload batches; remote exception", e3);
                atomicReference.notifyAll();
            }
            if (zzgbVar == null) {
                this.f73997a.a().o().a("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            Preconditions.m(zzrVar);
            zzgbVar.F(zzrVar, zzooVar, new zzmf(this, atomicReference));
            J();
        }
    }

    final /* synthetic */ void I(zzr zzrVar, zzaf zzafVar) {
        zzgb zzgbVar = this.f74320d;
        if (zzgbVar == null) {
            this.f73997a.a().o().a("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            zzgbVar.L3(zzrVar, zzafVar);
            J();
        } catch (RemoteException e3) {
            this.f73997a.a().o().c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(zzafVar.f73383a), e3);
        }
    }

    final /* synthetic */ void K(ComponentName componentName) {
        h();
        if (this.f74320d != null) {
            this.f74320d = null;
            this.f73997a.a().w().b("Disconnected from device MeasurementService", componentName);
            h();
            w();
        }
    }

    final /* synthetic */ zznf M() {
        return this.f74319c;
    }

    final /* synthetic */ zzgb N() {
        return this.f74320d;
    }

    final /* synthetic */ void O(zzgb zzgbVar) {
        this.f74320d = null;
    }

    final /* synthetic */ ScheduledExecutorService P() {
        return this.f74323g;
    }

    final /* synthetic */ void Q(ScheduledExecutorService scheduledExecutorService) {
        this.f74323g = scheduledExecutorService;
    }

    public final boolean W() {
        h();
        j();
        return this.f74320d != null;
    }

    protected final void X() {
        h();
        j();
        T(new zzmr(this, V(true)));
    }

    protected final void Y(boolean z2) {
        h();
        j();
        if (C()) {
            T(new zzms(this, V(false)));
        }
    }

    protected final void Z(boolean z2) {
        h();
        j();
        T(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznk
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74318a.E();
            }
        });
    }

    protected final void a0() {
        h();
        j();
        T(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzng
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74306a.F();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final void b0(com.google.android.gms.measurement.internal.zzgb r59, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable r60, com.google.android.gms.measurement.internal.zzr r61) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznl.b0(com.google.android.gms.measurement.internal.zzgb, com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable, com.google.android.gms.measurement.internal.zzr):void");
    }

    protected final void c0(zzbg zzbgVar, String str) {
        Preconditions.m(zzbgVar);
        h();
        j();
        R();
        T(new zzmt(this, true, V(true), this.f73997a.E().p(zzbgVar), zzbgVar, str));
    }

    protected final void d0(zzah zzahVar) {
        Preconditions.m(zzahVar);
        h();
        j();
        this.f73997a.c();
        T(new zzmu(this, true, V(true), this.f73997a.E().r(zzahVar), new zzah(zzahVar), zzahVar));
    }

    protected final void e0(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        j();
        T(new zzmv(this, atomicReference, null, str2, str3, V(false)));
    }

    protected final void f0(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2) {
        h();
        j();
        T(new zzmw(this, str, str2, V(false), zzcuVar));
    }

    protected final void g0(AtomicReference atomicReference, String str, String str2, String str3, boolean z2) {
        h();
        j();
        T(new zzmx(this, atomicReference, null, str2, str3, V(false), z2));
    }

    protected final void h0(com.google.android.gms.internal.measurement.zzcu zzcuVar, String str, String str2, boolean z2) {
        h();
        j();
        T(new zzmc(this, str, str2, V(false), z2, zzcuVar));
    }

    protected final void i0(AtomicReference atomicReference, boolean z2) {
        h();
        j();
        T(new zzmd(this, atomicReference, V(false), z2));
    }

    protected final void j0(final AtomicReference atomicReference, final Bundle bundle) {
        h();
        j();
        final zzr zzrVarV = V(false);
        T(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznh
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74307a.G(atomicReference, zzrVarV, bundle);
            }
        });
    }

    protected final void k0(final AtomicReference atomicReference, final zzoo zzooVar) {
        h();
        j();
        final zzr zzrVarV = V(false);
        T(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzni
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74311a.H(atomicReference, zzrVarV, zzooVar);
            }
        });
    }

    protected final void l0(final zzaf zzafVar) {
        h();
        j();
        final zzr zzrVarV = V(true);
        Preconditions.m(zzrVarV);
        T(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznj
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74315a.I(zzrVarV, zzafVar);
            }
        });
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return false;
    }

    protected final zzao m0() {
        h();
        j();
        zzgb zzgbVar = this.f74320d;
        if (zzgbVar == null) {
            w();
            this.f73997a.a().v().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        zzr zzrVarV = V(false);
        Preconditions.m(zzrVarV);
        try {
            zzao zzaoVarB4 = zzgbVar.b4(zzrVarV);
            J();
            return zzaoVarB4;
        } catch (RemoteException e3) {
            this.f73997a.a().o().b("Failed to get consents; remote exception", e3);
            return null;
        }
    }

    protected final void o(zzpl zzplVar) {
        h();
        j();
        R();
        T(new zzmg(this, V(true), this.f73997a.E().q(zzplVar), zzplVar));
    }

    protected final void p() {
        h();
        j();
        zzr zzrVarV = V(false);
        R();
        this.f73997a.E().o();
        T(new zzmh(this, zzrVarV));
    }

    public final void q(AtomicReference atomicReference) {
        h();
        j();
        T(new zzmi(this, atomicReference, V(false)));
    }

    public final void r(com.google.android.gms.internal.measurement.zzcu zzcuVar) {
        h();
        j();
        T(new zzmj(this, V(false), zzcuVar));
    }

    protected final void s() {
        h();
        j();
        zzr zzrVarV = V(true);
        R();
        this.f73997a.w().H(null, zzfy.f73627c1);
        this.f73997a.E().u();
        T(new zzmk(this, zzrVarV, true));
    }

    protected final void t() {
        h();
        j();
        T(new zzml(this, V(true)));
    }

    protected final void u(zzlu zzluVar) {
        h();
        j();
        T(new zzmn(this, zzluVar));
    }

    public final void v(Bundle bundle) {
        h();
        j();
        zzbe zzbeVar = new zzbe(bundle);
        R();
        T(new zzmo(this, true, V(false), this.f73997a.w().H(null, zzfy.f73627c1) && this.f73997a.E().s(zzbeVar), zzbeVar, bundle));
    }

    final void w() {
        h();
        j();
        if (W()) {
            return;
        }
        if (y()) {
            this.f74319c.c();
            return;
        }
        zzic zzicVar = this.f73997a;
        if (zzicVar.w().m()) {
            return;
        }
        zzicVar.c();
        List<ResolveInfo> listQueryIntentServices = zzicVar.d().getPackageManager().queryIntentServices(new Intent().setClassName(zzicVar.d(), "com.google.android.gms.measurement.AppMeasurementService"), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            zzicVar.a().o().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextD = zzicVar.d();
        zzicVar.c();
        intent.setComponent(new ComponentName(contextD, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f74319c.a(intent);
    }

    final Boolean x() {
        return this.f74321e;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final boolean y() {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznl.y():boolean");
    }

    protected final void z(zzgb zzgbVar) {
        h();
        Preconditions.m(zzgbVar);
        this.f74320d = zzgbVar;
        J();
        L();
    }

    public final void B(com.google.android.gms.internal.measurement.zzcu zzcuVar, zzbg zzbgVar, String str) {
        h();
        j();
        zzic zzicVar = this.f73997a;
        if (zzicVar.C().X(12451000) != 0) {
            zzicVar.a().r().a(HcgZcEUYo.ehCnYcLeruHLWv);
            zzicVar.C().d0(zzcuVar, new byte[0]);
        } else {
            T(new zzmp(this, zzbgVar, str, zzcuVar));
        }
    }
}
