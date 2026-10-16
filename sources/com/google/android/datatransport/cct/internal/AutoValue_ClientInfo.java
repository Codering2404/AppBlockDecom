package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_ClientInfo extends ClientInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ClientInfo.ClientType f69158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AndroidClientInfo f69159b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends ClientInfo.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ClientInfo.ClientType f69160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private AndroidClientInfo f69161b;

        Builder() {
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo a() {
            return new AutoValue_ClientInfo(this.f69160a, this.f69161b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder b(AndroidClientInfo androidClientInfo) {
            this.f69161b = androidClientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.Builder
        public ClientInfo.Builder c(ClientInfo.ClientType clientType) {
            this.f69160a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public AndroidClientInfo b() {
        return this.f69159b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f69158a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.f69158a;
            if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
                AndroidClientInfo androidClientInfo = this.f69159b;
                if (androidClientInfo != null ? androidClientInfo.equals(clientInfo.b()) : clientInfo.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f69158a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AndroidClientInfo androidClientInfo = this.f69159b;
        return iHashCode ^ (androidClientInfo != null ? androidClientInfo.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f69158a + ", androidClientInfo=" + this.f69159b + "}";
    }

    private AutoValue_ClientInfo(ClientInfo.ClientType clientType, AndroidClientInfo androidClientInfo) {
        this.f69158a = clientType;
        this.f69159b = androidClientInfo;
    }
}
