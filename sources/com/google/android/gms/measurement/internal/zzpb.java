package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpb implements zzpo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzpg f74420a;

    zzpb(zzpg zzpgVar) {
        Objects.requireNonNull(zzpgVar);
        this.f74420a = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzpo
    public final void a(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f74420a.b().t(new zzpa(this, str, str2, bundle));
            return;
        }
        zzpg zzpgVar = this.f74420a;
        if (zzpgVar.x0() != null) {
            zzpgVar.x0().a().o().b("AppId not known when logging event", str2);
        }
    }
}
