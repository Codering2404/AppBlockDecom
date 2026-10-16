package com.google.android.gms.common.api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class BooleanResult implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Status f71495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f71496b;

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f71495a.equals(booleanResult.f71495a) && this.f71496b == booleanResult.f71496b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f71495a;
    }

    public final int hashCode() {
        return ((this.f71495a.hashCode() + 527) * 31) + (this.f71496b ? 1 : 0);
    }
}
