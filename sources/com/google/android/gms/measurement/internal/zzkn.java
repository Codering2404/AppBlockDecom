package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzkn implements zzpo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzlj f74090a;

    zzkn(zzlj zzljVar) {
        Objects.requireNonNull(zzljVar);
        this.f74090a = zzljVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpo
    public final void a(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f74090a.p("auto", "_err", bundle);
        } else {
            this.f74090a.w("auto", "_err", bundle, str);
        }
    }
}
