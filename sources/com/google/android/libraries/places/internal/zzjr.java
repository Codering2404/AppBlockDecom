package com.google.android.libraries.places.internal;

import android.util.Base64;
import com.facebook.AuthenticationTokenClaims;
import com.google.common.base.Splitter;
import com.google.common.util.concurrent.FutureCallback;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzjr implements FutureCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbgs f78037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzjw f78038b;

    zzjr(zzjw zzjwVar, zzbgs zzbgsVar) {
        this.f78037a = zzbgsVar;
        Objects.requireNonNull(zzjwVar);
        this.f78038b = zzjwVar;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        zzjw zzjwVar = this.f78038b;
        zzjwVar.f(false);
        zzjwVar.f78049e = null;
        zzjwVar.f78050f = null;
        zzjwVar.f78051g = this.f78037a;
    }

    @Override // com.google.common.util.concurrent.FutureCallback
    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
        zzjw zzjwVar = this.f78038b;
        zzjwVar.f(false);
        String strG = ((zzbhc) obj).G();
        zzbgs zzbgsVar = this.f78037a;
        try {
            zzjwVar.f78049e = strG;
            List listL = Splitter.f('.').l(strG);
            if (listL.size() < 2) {
                throw new IllegalStateException("Invalid JWT format");
            }
            zzjwVar.f78050f = Long.valueOf(Long.parseLong(new JSONObject(new String(Base64.decode((String) listL.get(1), 8), StandardCharsets.UTF_8)).get(AuthenticationTokenClaims.JSON_KEY_EXP).toString()));
            zzjwVar.f78051g = zzbgsVar;
        } catch (Exception e3) {
            throw new IllegalStateException("Couldn't decode JWT payload", e3);
        }
    }
}
