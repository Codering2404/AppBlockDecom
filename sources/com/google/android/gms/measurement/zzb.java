package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzb extends zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzlk f74544a;

    public zzb(zzlk zzlkVar) {
        super(null);
        Preconditions.m(zzlkVar);
        this.f74544a = zzlkVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void a(String str, String str2, Bundle bundle) {
        this.f74544a.a(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Map b(String str, String str2, boolean z2) {
        return this.f74544a.b(str, str2, z2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void c(String str, String str2, Bundle bundle) {
        this.f74544a.c(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final List d(String str, String str2) {
        return this.f74544a.d(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzh() {
        return this.f74544a.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzi() {
        return this.f74544a.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzj() {
        return this.f74544a.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzk() {
        return this.f74544a.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final long zzl() {
        return this.f74544a.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzm(String str) {
        this.f74544a.zzm(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzn(String str) {
        this.f74544a.zzn(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzo(Bundle bundle) {
        this.f74544a.zzo(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final int zzr(String str) {
        return this.f74544a.zzr(str);
    }
}
