package com.google.android.libraries.places.api.net;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzr extends IsOpenResponse {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f75515a;

    zzr(Boolean bool) {
        this.f75515a = bool;
    }

    @Override // com.google.android.libraries.places.api.net.IsOpenResponse
    public final Boolean a() {
        return this.f75515a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IsOpenResponse)) {
            return false;
        }
        IsOpenResponse isOpenResponse = (IsOpenResponse) obj;
        Boolean bool = this.f75515a;
        return bool == null ? isOpenResponse.a() == null : bool.equals(isOpenResponse.a());
    }

    public final int hashCode() {
        Boolean bool = this.f75515a;
        return (bool == null ? 0 : bool.hashCode()) ^ 1000003;
    }

    public final String toString() {
        Boolean bool = this.f75515a;
        StringBuilder sb = new StringBuilder(String.valueOf(bool).length() + 23);
        sb.append("IsOpenResponse{isOpen=");
        sb.append(bool);
        sb.append("}");
        return sb.toString();
    }
}
