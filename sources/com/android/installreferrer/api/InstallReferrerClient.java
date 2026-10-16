package com.android.installreferrer.api;

import android.content.Context;
import android.os.RemoteException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class InstallReferrerClient {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {
        private final Context mContext;

        private Builder(Context context) {
            this.mContext = context;
        }

        public InstallReferrerClient build() {
            Context context = this.mContext;
            if (context != null) {
                return new InstallReferrerClientImpl(context);
            }
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallReferrerResponse {
        public static final int DEVELOPER_ERROR = 3;
        public static final int FEATURE_NOT_SUPPORTED = 2;
        public static final int OK = 0;
        public static final int PERMISSION_ERROR = 4;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_UNAVAILABLE = 1;
    }

    public static Builder newBuilder(Context context) {
        return new Builder(context);
    }

    public abstract void endConnection();

    public abstract ReferrerDetails getInstallReferrer() throws RemoteException;

    public abstract boolean isReady();

    public abstract void startConnection(InstallReferrerStateListener installReferrerStateListener);
}
