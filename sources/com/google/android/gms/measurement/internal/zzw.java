package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.measurement.zzqp;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzw extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzic f74528a;

    public zzw(zzic zzicVar) {
        this.f74528a = zzicVar;
    }

    final /* synthetic */ void a() {
        this.f74528a.N().o(((Long) zzfy.D.b(null)).longValue());
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.f74528a.a().r().a("App receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            this.f74528a.a().r().a("App receiver called with null action");
            return;
        }
        int iHashCode = action.hashCode();
        if (iHashCode != -1928239649) {
            if (iHashCode == 1279883384 && action.equals("com.google.android.gms.measurement.BATCHES_AVAILABLE")) {
                zzic zzicVar = this.f74528a;
                zzicVar.a().w().a("[sgtm] App Receiver notified batches are available");
                zzicVar.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f74525a.a();
                    }
                });
                return;
            }
        } else if (action.equals("com.google.android.gms.measurement.TRIGGERS_AVAILABLE")) {
            final zzic zzicVar2 = this.f74528a;
            zzqp.zza();
            if (zzicVar2.w().H(null, zzfy.R0)) {
                zzicVar2.a().w().a("App receiver notified triggers are available");
                zzicVar2.b().t(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzic zzicVar3 = zzicVar2;
                        if (!zzicVar3.C().G()) {
                            zzicVar3.a().r().a("registerTrigger called but app not eligible");
                            return;
                        }
                        zzicVar3.B().t0();
                        final zzlj zzljVarB = zzicVar3.B();
                        Objects.requireNonNull(zzljVarB);
                        new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzv
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzljVarB.u0();
                            }
                        }).start();
                    }
                });
                return;
            }
            return;
        }
        this.f74528a.a().r().a("App receiver called with unknown action");
    }
}
