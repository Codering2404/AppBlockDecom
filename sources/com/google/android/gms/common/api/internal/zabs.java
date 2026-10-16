package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ApiKey f71764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Feature f71765b;

    /* synthetic */ zabs(ApiKey apiKey, Feature feature, zabr zabrVar) {
        this.f71764a = apiKey;
        this.f71765b = feature;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zabs)) {
            zabs zabsVar = (zabs) obj;
            if (Objects.b(this.f71764a, zabsVar.f71764a) && Objects.b(this.f71765b, zabsVar.f71765b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.c(this.f71764a, this.f71765b);
    }

    public final String toString() {
        return Objects.d(this).a("key", this.f71764a).a("feature", this.f71765b).toString();
    }
}
