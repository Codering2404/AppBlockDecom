package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.internal.gtm.zzfo;
import com.google.android.gms.internal.gtm.zzfp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AnalyticsService extends Service implements zzfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzfp f70860a;

    private final zzfp a() {
        if (this.f70860a == null) {
            this.f70860a = new zzfp(this);
        }
        return this.f70860a;
    }

    @Override // com.google.android.gms.internal.gtm.zzfo
    public boolean callServiceStopSelfResult(int i3) {
        return stopSelfResult(i3);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        a();
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        a().zze();
    }

    @Override // android.app.Service
    public final void onDestroy() {
        a().zzf();
        super.onDestroy();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i3, int i4) {
        a().zza(intent, i3, i4);
        return 2;
    }

    @Override // com.google.android.gms.internal.gtm.zzfo
    public final void zza(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }
}
