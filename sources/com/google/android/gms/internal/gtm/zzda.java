package com.google.android.gms.internal.gtm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;
import d.qFm.sECyKyO;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzda extends zzbu {
    private boolean zza;
    private boolean zzb;
    private final AlarmManager zzc;
    private Integer zzd;

    protected zzda(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzc = (AlarmManager) zzo().getSystemService("alarm");
    }

    private final int zzf() {
        if (this.zzd == null) {
            this.zzd = Integer.valueOf("analytics".concat(String.valueOf(zzo().getPackageName())).hashCode());
        }
        return this.zzd.intValue();
    }

    public final void zza() {
        this.zzb = false;
        try {
            this.zzc.cancel(zzg());
        } catch (NullPointerException unused) {
        }
        JobScheduler jobScheduler = (JobScheduler) zzo().getSystemService("jobscheduler");
        int iZzf = zzf();
        zzO("Cancelling job. JobID", Integer.valueOf(iZzf));
        jobScheduler.cancel(iZzf);
    }

    public final void zzb() {
        zzV();
        Preconditions.r(this.zza, "Receiver not registered");
        zzw();
        long jZzd = zzcv.zzd();
        if (jZzd > 0) {
            zza();
            zzC().a();
            this.zzb = true;
            ((Boolean) zzew.zzR.zzb()).getClass();
            zzN("Scheduling upload with JobScheduler");
            Context contextZzo = zzo();
            ComponentName componentName = new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsJobService");
            int iZzf = zzf();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            JobInfo jobInfoBuild = new JobInfo.Builder(iZzf, componentName).setMinimumLatency(jZzd).setOverrideDeadline(jZzd + jZzd).setExtras(persistableBundle).build();
            zzO("Scheduling job. JobID", Integer.valueOf(iZzf));
            zzfx.zza(contextZzo, jobInfoBuild, "com.google.android.gms", "DispatchAlarm");
        }
    }

    public final boolean zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        try {
            zza();
            zzw();
            if (zzcv.zzd() > 0) {
                Context contextZzo = zzo();
                ActivityInfo receiverInfo = contextZzo.getPackageManager().getReceiverInfo(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                zzN("Receiver registered for local dispatch.");
                this.zza = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public final boolean zze() {
        return this.zzb;
    }

    private final PendingIntent zzg() {
        Context contextZzo = zzo();
        return PendingIntent.getBroadcast(contextZzo, 0, new Intent(sECyKyO.KSu).setComponent(new ComponentName(contextZzo, "com.google.android.gms.analytics.AnalyticsReceiver")), zzfw.zza);
    }
}
