package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzki implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f74075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74076b;

    zzki(zzlj zzljVar, Bundle bundle) {
        this.f74075a = bundle;
        Objects.requireNonNull(zzljVar);
        this.f74076b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74076b;
        zzljVar.h();
        zzljVar.j();
        Bundle bundle = this.f74075a;
        Preconditions.m(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.g(string);
        Preconditions.g(string2);
        Preconditions.m(bundle.get("value"));
        if (!zzljVar.f73997a.g()) {
            zzljVar.f73997a.a().w().a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpl zzplVar = new zzpl(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzic zzicVar = zzljVar.f73997a;
            zzbg zzbgVarR = zzicVar.C().R(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            zzljVar.f73997a.J().d0(new zzah(bundle.getString("app_id"), string2, zzplVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzicVar.C().R(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), zzbgVarR, bundle.getLong("time_to_live"), zzicVar.C().R(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
