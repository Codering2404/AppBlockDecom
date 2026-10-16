package com.google.android.gms.measurement;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzlj;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zza extends zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzic f74542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzlj f74543b;

    public zza(zzic zzicVar) {
        super(null);
        Preconditions.m(zzicVar);
        this.f74542a = zzicVar;
        this.f74543b = zzicVar.B();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void a(String str, String str2, Bundle bundle) {
        this.f74543b.p(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final Map b(String str, String str2, boolean z2) {
        return this.f74543b.C(str, str2, z2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void c(String str, String str2, Bundle bundle) {
        this.f74542a.B().O(str, str2, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final List d(String str, String str2) {
        return this.f74543b.P(str, str2);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzh() {
        return this.f74543b.Q();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzi() {
        return this.f74543b.R();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzj() {
        return this.f74543b.D();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final String zzk() {
        return this.f74543b.S();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final long zzl() {
        return this.f74542a.C().p0();
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzm(String str) {
        zzic zzicVar = this.f74542a;
        zzicVar.M().i(str, zzicVar.e().a());
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzn(String str) {
        zzic zzicVar = this.f74542a;
        zzicVar.M().j(str, zzicVar.e().a());
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final void zzo(Bundle bundle) {
        this.f74543b.M(bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzlk
    public final int zzr(String str) {
        this.f74543b.L(str);
        return 25;
    }
}
