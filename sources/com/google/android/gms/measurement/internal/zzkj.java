package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkj implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bundle f74077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzlj f74078b;

    zzkj(zzlj zzljVar, Bundle bundle) {
        this.f74077a = bundle;
        Objects.requireNonNull(zzljVar);
        this.f74078b = zzljVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlj zzljVar = this.f74078b;
        zzljVar.h();
        zzljVar.j();
        Bundle bundle = this.f74077a;
        Preconditions.m(bundle);
        String strG = Preconditions.g(bundle.getString("name"));
        if (!zzljVar.f73997a.g()) {
            zzljVar.f73997a.a().w().a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzljVar.f73997a.J().d0(new zzah(bundle.getString("app_id"), "", new zzpl(strG, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzljVar.f73997a.C().R(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }
}
