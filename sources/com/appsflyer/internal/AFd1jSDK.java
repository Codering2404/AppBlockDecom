package com.appsflyer.internal;

import com.appsflyer.deeplink.DeepLinkResult;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFd1jSDK extends AFd1uSDK<DeepLinkResult> {
    private DeepLinkResult AFLogger;
    private final AFb1oSDK afErrorLog;

    /* JADX INFO: renamed from: com.appsflyer.internal.AFd1jSDK$5, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] AFKeystoreWrapper;

        static {
            int[] iArr = new int[DeepLinkResult.Status.values().length];
            AFKeystoreWrapper = iArr;
            try {
                iArr[DeepLinkResult.Status.FOUND.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                AFKeystoreWrapper[DeepLinkResult.Status.NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                AFKeystoreWrapper[DeepLinkResult.Status.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public AFd1jSDK(AFb1oSDK aFb1oSDK) {
        super(AFd1tSDK.DLSDK, new AFd1tSDK[]{AFd1tSDK.RC_CDN}, "DdlSdk");
        this.afErrorLog = aFb1oSDK;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final long AFInAppEventType() {
        return 90000L;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final AFc1bSDK AFKeystoreWrapper() throws Exception {
        DeepLinkResult deepLinkResultAfDebugLog = this.afErrorLog.afDebugLog();
        this.AFLogger = deepLinkResultAfDebugLog;
        return AnonymousClass5.AFKeystoreWrapper[deepLinkResultAfDebugLog.getStatus().ordinal()] != 1 ? this.AFLogger.getError() == DeepLinkResult.Error.TIMEOUT ? AFc1bSDK.TIMEOUT : AFc1bSDK.FAILURE : AFc1bSDK.SUCCESS;
    }

    @Override // com.appsflyer.internal.AFd1uSDK
    public final boolean valueOf() {
        return false;
    }
}
