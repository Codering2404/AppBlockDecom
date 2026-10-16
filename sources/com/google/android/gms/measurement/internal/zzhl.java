package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zza f73839a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface zza {
        void a(Context context, Intent intent);
    }

    public zzhl(zza zzaVar) {
        Preconditions.m(zzaVar);
        this.f73839a = zzaVar;
    }

    public final void a(Context context, Intent intent) {
        zzic zzicVarO = zzic.O(context, null, null);
        zzgu zzguVarA = zzicVarO.a();
        if (intent == null) {
            zzguVarA.r().a("Receiver called with null intent");
            return;
        }
        zzicVarO.c();
        String action = intent.getAction();
        zzguVarA.w().b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                zzguVarA.r().a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzguVarA.w().a("Starting wakeful intent.");
            this.f73839a.a(context, className);
        }
    }
}
