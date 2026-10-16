package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zznp;
import com.google.android.gms.measurement.internal.zznt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class AppMeasurementService extends Service implements zznp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zznt f73361a;

    private final zznt c() {
        if (this.f73361a == null) {
            this.f73361a = new zznt(this);
        }
        return this.f73361a;
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final void a(Intent intent) {
        WakefulBroadcastReceiver.b(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final void b(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return c().d(intent);
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

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i3, int i4) {
        c().c(intent, i3, i4);
        return 2;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        c();
        zznt.j(intent);
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zznp
    public final boolean zza(int i3) {
        return stopSelfResult(i3);
    }
}
