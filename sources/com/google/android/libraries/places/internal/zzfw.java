package com.google.android.libraries.places.internal;

import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzfw extends JsonObjectRequest {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    final /* synthetic */ Map f77839v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzfw(zzga zzgaVar, int i3, String str, JSONObject jSONObject, Response.Listener listener, Response.ErrorListener errorListener, Map map) {
        super(0, str, null, listener, errorListener);
        this.f77839v = map;
        Objects.requireNonNull(zzgaVar);
    }

    @Override // com.android.volley.Request
    public final Map n() {
        return this.f77839v;
    }
}
