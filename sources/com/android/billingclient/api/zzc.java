package com.android.billingclient.api;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f57500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f57501b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f57502c;

    /* synthetic */ zzc(JSONObject jSONObject, zzd zzdVar) {
        this.f57500a = jSONObject.optString("productId");
        this.f57501b = jSONObject.optString("productType");
        String strOptString = jSONObject.optString("offerToken");
        this.f57502c = true == strOptString.isEmpty() ? null : strOptString;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzcVar = (zzc) obj;
        return this.f57500a.equals(zzcVar.f57500a) && this.f57501b.equals(zzcVar.f57501b) && Objects.equals(this.f57502c, zzcVar.f57502c);
    }

    public final int hashCode() {
        return Objects.hash(this.f57500a, this.f57501b, this.f57502c);
    }

    public final String toString() {
        return String.format("{id: %s, type: %s, offer token: %s}", this.f57500a, this.f57501b, this.f57502c);
    }
}
