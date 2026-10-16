package com.google.android.gms.measurement.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzok extends zzos {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AlarmManager f74385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zzay f74386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Integer f74387f;

    protected zzok(zzpg zzpgVar) {
        super(zzpgVar);
        this.f74385d = (AlarmManager) this.f73997a.d().getSystemService("alarm");
    }

    private final zzay o() {
        if (this.f74386e == null) {
            this.f74386e = new zzoj(this, this.f74388b.g0());
        }
        return this.f74386e;
    }

    private final void p() {
        JobScheduler jobScheduler = (JobScheduler) this.f73997a.d().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(q());
        }
    }

    private final int q() {
        if (this.f74387f == null) {
            this.f74387f = Integer.valueOf("measurement".concat(String.valueOf(this.f73997a.d().getPackageName())).hashCode());
        }
        return this.f74387f.intValue();
    }

    private final PendingIntent r() {
        Context contextD = this.f73997a.d();
        return PendingIntent.getBroadcast(contextD, 0, new Intent().setClassName(contextD, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), com.google.android.gms.internal.measurement.zzcg.zza);
    }

    @Override // com.google.android.gms.measurement.internal.zzos
    protected final boolean l() {
        AlarmManager alarmManager = this.f74385d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        p();
        return false;
    }

    public final void m(long j3) {
        j();
        zzic zzicVar = this.f73997a;
        zzicVar.c();
        Context contextD = zzicVar.d();
        if (!zzpp.j0(contextD)) {
            zzicVar.a().v().a("Receiver not registered/enabled");
        }
        if (!zzpp.E(contextD, false)) {
            zzicVar.a().v().a("Service not registered/enabled");
        }
        n();
        zzicVar.a().w().b("Scheduling upload, millis", Long.valueOf(j3));
        zzicVar.e().a();
        zzicVar.w();
        if (j3 < Math.max(0L, ((Long) zzfy.M.b(null)).longValue()) && !o().c()) {
            o().b(j3);
        }
        zzicVar.c();
        Context contextD2 = zzicVar.d();
        ComponentName componentName = new ComponentName(contextD2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iQ = q();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        com.google.android.gms.internal.measurement.zzch.zza(contextD2, new JobInfo.Builder(iQ, componentName).setMinimumLatency(j3).setOverrideDeadline(j3 + j3).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void n() {
        j();
        this.f73997a.a().w().a("Unscheduling upload");
        AlarmManager alarmManager = this.f74385d;
        if (alarmManager != null) {
            alarmManager.cancel(r());
        }
        o().d();
        p();
    }
}
