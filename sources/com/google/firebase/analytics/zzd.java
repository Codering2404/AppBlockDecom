package com.google.firebase.analytics;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzfb;
import com.google.android.gms.measurement.internal.zzlk;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzd implements zzlk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzfb f87698a;

    zzd(zzfb zzfbVar) {
        this.f87698a = zzfbVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void a(String str, String str2, Bundle bundle) {
        this.f87698a.zzi(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Map b(String str, String str2, boolean z2) {
        return this.f87698a.zzC(str, str2, z2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void c(String str, String str2, Bundle bundle) {
        this.f87698a.zzm(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final List d(String str, String str2) {
        return this.f87698a.zzn(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzh() {
        return this.f87698a.zzA();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzi() {
        return this.f87698a.zzB();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzj() {
        return this.f87698a.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzk() {
        return this.f87698a.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final long zzl() {
        return this.f87698a.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzm(String str) {
        this.f87698a.zzu(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzn(String str) {
        this.f87698a.zzv(str);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzo(Bundle bundle) {
        this.f87698a.zzl(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final int zzr(String str) {
        return this.f87698a.zzF(str);
    }
}
