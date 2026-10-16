package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f77299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f77300b;

    public zzbzr(String str, Map map) {
        this.f77299a = (String) Preconditions.u(str, "policyName");
        this.f77300b = (Map) Preconditions.u(map, "rawConfigValue");
    }

    public final String a() {
        return this.f77299a;
    }

    public final Map b() {
        return this.f77300b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbzr) {
            zzbzr zzbzrVar = (zzbzr) obj;
            if (this.f77299a.equals(zzbzrVar.f77299a) && this.f77300b.equals(zzbzrVar.f77300b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f77299a, this.f77300b);
    }

    public final String toString() {
        return MoreObjects.c(this).d("policyName", this.f77299a).d("rawConfigValue", this.f77300b).toString();
    }
}
