package com.singular.sdk.internal.InstallReferrer;

import android.content.Context;
import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class SLGoogleReferrer implements SLInstallReferrerService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92577a = SingularLog.f(SLGoogleReferrer.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Map f92578b;

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(String str, String str2, long j3, long j4, String str3, long j5, long j6) {
        HashMap map = new HashMap();
        f92578b = map;
        map.put("referrer", str);
        f92578b.put("referrer_source", str2);
        f92578b.put("clickTimestampSeconds", Long.valueOf(j3));
        f92578b.put("installBeginTimestampSeconds", Long.valueOf(j4));
        f92578b.put("current_device_time", Long.valueOf(Utils.y()));
        f92578b.put("installVersion", str3);
        f92578b.put("clickTimestampServerSeconds", Long.valueOf(j5));
        f92578b.put("installBeginTimestampServerSeconds", Long.valueOf(j6));
    }

    public void d(final Context context, final SLInstallReferrerCompletionHandler sLInstallReferrerCompletionHandler) {
        try {
            final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(context).build();
            installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer.1
                /* JADX INFO: Access modifiers changed from: private */
                public void c(Context context2) {
                    String strW = Utils.w(context2);
                    if (strW != null) {
                        SLGoogleReferrer.e(strW, SDKConstants.PARAM_INTENT, -1L, -1L, null, -1L, -1L);
                    }
                }

                /* JADX INFO: Access modifiers changed from: private */
                public void d(InstallReferrerClient installReferrerClient) throws RemoteException {
                    String installVersion;
                    long referrerClickTimestampServerSeconds;
                    long installBeginTimestampServerSeconds;
                    ReferrerDetails installReferrer = installReferrerClient.getInstallReferrer();
                    if (e(installReferrer)) {
                        installVersion = installReferrer.getInstallVersion();
                        referrerClickTimestampServerSeconds = installReferrer.getReferrerClickTimestampServerSeconds();
                        installBeginTimestampServerSeconds = installReferrer.getInstallBeginTimestampServerSeconds();
                    } else {
                        installVersion = null;
                        referrerClickTimestampServerSeconds = -1;
                        installBeginTimestampServerSeconds = -1;
                    }
                    SLGoogleReferrer.e(installReferrer.getInstallReferrer(), "service", installReferrer.getReferrerClickTimestampSeconds(), installReferrer.getInstallBeginTimestampSeconds(), installVersion, referrerClickTimestampServerSeconds, installBeginTimestampServerSeconds);
                }

                private boolean e(ReferrerDetails referrerDetails) {
                    try {
                        return referrerDetails.getClass().getMethod("getInstallVersion", null) != null;
                    } catch (Throwable th) {
                        SLGoogleReferrer.f92577a.a("Google Play Install Referrer V2 not supported: " + Utils.l(th));
                        return false;
                    }
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    installReferrerClientBuild.endConnection();
                }

                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(final int i3) {
                    SLGoogleReferrer.f92577a.a("google onInstallReferrerSetupFinished: responseCode=" + i3);
                    Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i4 = i3;
                            if (i4 == 0) {
                                try {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    anonymousClass1.d(installReferrerClientBuild);
                                } catch (Throwable th) {
                                    SLGoogleReferrer.f92577a.c("google onInstallReferrerSetupFinished: failed to get referrer value - " + Utils.l(th));
                                }
                                sLInstallReferrerCompletionHandler.a(SLGoogleReferrer.f92578b);
                            } else if (i4 == 1) {
                                SLGoogleReferrer.f92577a.a("google onInstallReferrerSetupFinished: SERVICE_UNAVAILABLE");
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                anonymousClass12.c(context);
                                sLInstallReferrerCompletionHandler.a(SLGoogleReferrer.f92578b);
                            } else if (i4 == 2) {
                                SLGoogleReferrer.f92577a.a("google onInstallReferrerSetupFinished: FEATURE_NOT_SUPPORTED");
                                AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                                anonymousClass13.c(context);
                                sLInstallReferrerCompletionHandler.a(SLGoogleReferrer.f92578b);
                            } else if (i4 != 3) {
                                SLGoogleReferrer.f92577a.b("Unexpected response code of install referrer response %d", Integer.valueOf(i3));
                                AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                                anonymousClass14.c(context);
                                sLInstallReferrerCompletionHandler.a(SLGoogleReferrer.f92578b);
                            } else {
                                SLGoogleReferrer.f92577a.c("google onInstallReferrerSetupFinished: DEVELOPER_ERROR");
                                AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                                anonymousClass15.c(context);
                                sLInstallReferrerCompletionHandler.a(SLGoogleReferrer.f92578b);
                            }
                            if (installReferrerClientBuild.isReady()) {
                                installReferrerClientBuild.endConnection();
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            f92577a.c("google: failed to get referrer value - " + Utils.l(th));
        }
    }
}
