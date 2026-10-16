package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.AutoValue_ClientInfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class ClientInfo {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static abstract class Builder {
        public abstract ClientInfo a();

        public abstract Builder b(AndroidClientInfo androidClientInfo);

        public abstract Builder c(ClientType clientType);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ClientType {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f69214a;

        ClientType(int i3) {
            this.f69214a = i3;
        }
    }

    public static Builder a() {
        return new AutoValue_ClientInfo.Builder();
    }

    public abstract AndroidClientInfo b();

    public abstract ClientType c();
}
