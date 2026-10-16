package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f74348a;

    public zznt(Context context) {
        Preconditions.m(context);
        this.f74348a = context;
    }

    public static final void i(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onRebind called with null intent");
        } else {
            Log.v("FA", "onRebind called. action: ".concat(String.valueOf(intent.getAction())));
        }
    }

    public static final boolean j(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onUnbind called with null intent");
            return true;
        }
        Log.v("FA", "onUnbind called for intent. action: ".concat(String.valueOf(intent.getAction())));
        return true;
    }

    private final void k(zzpg zzpgVar, Runnable runnable) {
        zzpgVar.b().t(new zzno(this, zzpgVar, runnable));
    }

    public final void a() {
        Log.v("FA", this.f74348a.getClass().getSimpleName().concat(" is starting up."));
    }

    public final void b() {
        Log.v("FA", this.f74348a.getClass().getSimpleName().concat(" is shutting down."));
    }

    public final int c(final Intent intent, int i3, final int i4) {
        if (intent == null) {
            Log.w("FA", "AppMeasurementService started with null intent");
            return 2;
        }
        Context context = this.f74348a;
        zzic zzicVarO = zzic.O(context, null, null);
        final zzgu zzguVarA = zzicVarO.a();
        String action = intent.getAction();
        zzicVarO.c();
        zzguVarA.w().c("Local AppMeasurementService called. startId, action", Integer.valueOf(i4), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            k(zzpg.F(context), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzns
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f74344a.f(i4, zzguVarA, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder d(Intent intent) {
        if (intent == null) {
            Log.e("FA", "onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzjd(zzpg.F(this.f74348a), null);
        }
        Log.w("FA", "onBind received unknown action: ".concat(String.valueOf(action)));
        return null;
    }

    public final boolean e(final JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("action");
        Log.v("FA", "onStartJob received action: ".concat(String.valueOf(string)));
        if (Objects.equals(string, "com.google.android.gms.measurement.UPLOAD")) {
            String str = (String) Preconditions.m(string);
            zzpg zzpgVarF = zzpg.F(this.f74348a);
            final zzgu zzguVarA = zzpgVarF.a();
            zzpgVarF.c();
            zzguVarA.w().b("Local AppMeasurementJobService called. action", str);
            k(zzpgVarF, new Runnable() { // from class: com.google.android.gms.measurement.internal.zznq
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.f74339a.g(zzguVarA, jobParameters);
                }
            });
        }
        if (!Objects.equals(string, "com.google.android.gms.measurement.SCION_UPLOAD")) {
            return true;
        }
        com.google.android.gms.internal.measurement.zzfb.zza(this.f74348a, null).zzw(new Runnable() { // from class: com.google.android.gms.measurement.internal.zznr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f74342a.h(jobParameters);
            }
        });
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void f(int i3, zzgu zzguVar, Intent intent) {
        Context context = this.f74348a;
        zznp zznpVar = (zznp) context;
        if (zznpVar.zza(i3)) {
            zzguVar.w().b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i3));
            zzic.O(context, null, null).a().w().a("Completed wakeful intent.");
            zznpVar.a(intent);
        }
    }

    final /* synthetic */ void g(zzgu zzguVar, JobParameters jobParameters) {
        zzguVar.w().a("AppMeasurementJobService processed last upload request.");
        ((zznp) this.f74348a).b(jobParameters, false);
    }

    final /* synthetic */ void h(JobParameters jobParameters) {
        Log.v("FA", "[sgtm] AppMeasurementJobService processed last Scion upload request.");
        ((zznp) this.f74348a).b(jobParameters, false);
    }
}
