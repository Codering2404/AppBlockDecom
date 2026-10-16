package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zznp;
import com.google.android.gms.measurement.internal.zznt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class AppMeasurementJobService extends JobService implements zznp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zznt f73359a;

    private final zznt c() {
        if (this.f73359a == null) {
            this.f73359a = new zznt(this);
        }
        return this.f73359a;
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final void b(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        c().a();
    }

    @Override // android.app.Service
    public void onDestroy() {
        c().b();
        super.onDestroy();
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        c();
        zznt.i(intent);
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        c().e(jobParameters);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c();
        zznt.j(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final boolean zza(int i3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final void a(Intent intent) {
    }
}
