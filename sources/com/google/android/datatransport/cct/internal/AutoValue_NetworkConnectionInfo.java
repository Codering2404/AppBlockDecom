package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_NetworkConnectionInfo extends NetworkConnectionInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NetworkConnectionInfo.NetworkType f69207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final NetworkConnectionInfo.MobileSubtype f69208b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends NetworkConnectionInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private NetworkConnectionInfo.NetworkType f69209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private NetworkConnectionInfo.MobileSubtype f69210b;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public NetworkConnectionInfo a() {
            return new AutoValue_NetworkConnectionInfo(this.f69209a, this.f69210b);
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public NetworkConnectionInfo.Builder b(NetworkConnectionInfo.MobileSubtype mobileSubtype) {
            this.f69210b = mobileSubtype;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo.Builder
        public NetworkConnectionInfo.Builder c(NetworkConnectionInfo.NetworkType networkType) {
            this.f69209a = networkType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.MobileSubtype b() {
        return this.f69208b;
    }

    @Override // com.google.android.datatransport.cct.internal.NetworkConnectionInfo
    public NetworkConnectionInfo.NetworkType c() {
        return this.f69207a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NetworkConnectionInfo) {
            NetworkConnectionInfo networkConnectionInfo = (NetworkConnectionInfo) obj;
            NetworkConnectionInfo.NetworkType networkType = this.f69207a;
            if (networkType != null ? networkType.equals(networkConnectionInfo.c()) : networkConnectionInfo.c() == null) {
                NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f69208b;
                if (mobileSubtype != null ? mobileSubtype.equals(networkConnectionInfo.b()) : networkConnectionInfo.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        NetworkConnectionInfo.NetworkType networkType = this.f69207a;
        int iHashCode = ((networkType == null ? 0 : networkType.hashCode()) ^ 1000003) * 1000003;
        NetworkConnectionInfo.MobileSubtype mobileSubtype = this.f69208b;
        return iHashCode ^ (mobileSubtype != null ? mobileSubtype.hashCode() : 0);
    }

    public String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f69207a + ", mobileSubtype=" + this.f69208b + "}";
    }

    private AutoValue_NetworkConnectionInfo(NetworkConnectionInfo.NetworkType networkType, NetworkConnectionInfo.MobileSubtype mobileSubtype) {
        this.f69207a = networkType;
        this.f69208b = mobileSubtype;
    }
}
