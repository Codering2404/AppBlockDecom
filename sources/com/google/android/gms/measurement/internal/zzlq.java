package com.google.android.gms.measurement.internal;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.PersistableBundle;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlq extends zzg {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JobScheduler f74168c;

    public zzlq(zzic zzicVar) {
        super(zzicVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final boolean m() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    protected final void n() {
        this.f74168c = (JobScheduler) this.f73997a.d().getSystemService("jobscheduler");
    }

    final int p() {
        return "measurement-client".concat(String.valueOf(this.f73997a.d().getPackageName())).hashCode();
    }

    final com.google.android.gms.internal.measurement.zzin q() {
        j();
        h();
        if (this.f74168c == null) {
            return com.google.android.gms.internal.measurement.zzin.MISSING_JOB_SCHEDULER;
        }
        zzic zzicVar = this.f73997a;
        if (!zzicVar.w().P()) {
            return com.google.android.gms.internal.measurement.zzin.NOT_ENABLED_IN_MANIFEST;
        }
        zzic zzicVar2 = this.f73997a;
        return zzicVar2.L().u() >= 119000 ? !zzpp.F(zzicVar.d(), "com.google.android.gms.measurement.AppMeasurementJobService") ? com.google.android.gms.internal.measurement.zzin.MEASUREMENT_SERVICE_NOT_ENABLED : !zzicVar2.J().y() ? com.google.android.gms.internal.measurement.zzin.NON_PLAY_MODE : com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE : com.google.android.gms.internal.measurement.zzin.SDK_TOO_OLD;
    }

    public final void o(long j3) {
        String str;
        j();
        h();
        JobScheduler jobScheduler = this.f74168c;
        if (jobScheduler != null && jobScheduler.getPendingJob(p()) != null) {
            this.f73997a.a().w().a("[sgtm] There's an existing pending job, skip this schedule.");
            return;
        }
        com.google.android.gms.internal.measurement.zzin zzinVarQ = q();
        if (zzinVarQ == com.google.android.gms.internal.measurement.zzin.CLIENT_UPLOAD_ELIGIBLE) {
            zzic zzicVar = this.f73997a;
            zzicVar.a().w().b("[sgtm] Scheduling Scion upload, millis", Long.valueOf(j3));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.measurement.SCION_UPLOAD");
            int iSchedule = ((JobScheduler) Preconditions.m(this.f74168c)).schedule(new JobInfo.Builder(p(), new ComponentName(zzicVar.d(), "com.google.android.gms.measurement.AppMeasurementJobService")).setRequiredNetworkType(1).setMinimumLatency(j3).setOverrideDeadline(j3 + j3).setExtras(persistableBundle).build());
            zzgs zzgsVarW = zzicVar.a().w();
            if (iSchedule == 1) {
                str = "SUCCESS";
            } else {
                str = "FAILURE";
            }
            zzgsVarW.b(jTYhJgqLBN.GTAIeiO, str);
            return;
        }
        this.f73997a.a().w().b("[sgtm] Not eligible for Scion upload", zzinVarQ.name());
    }
}
