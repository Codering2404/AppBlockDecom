package com.google.android.gms.measurement.internal;

import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzoy extends zzay {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ zzpg f74411e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzoy(zzpg zzpgVar, zzjg zzjgVar) {
        super(zzjgVar);
        Objects.requireNonNull(zzpgVar);
        this.f74411e = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzay
    public final void a() {
        zzpg zzpgVar = this.f74411e;
        zzpgVar.b().h();
        String str = (String) zzpgVar.y0().pollFirst();
        if (str != null) {
            zzpgVar.z0(zzpgVar.e().a());
            zzpgVar.a().w().b("Sending trigger URI notification to app", str);
            Intent intent = new Intent();
            intent.setAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            intent.setPackage(str);
            zzpg.W(zzpgVar.d(), intent);
        }
        zzpgVar.v0();
    }
}
