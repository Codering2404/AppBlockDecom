package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class InstallReferrerUtil {
    public static final InstallReferrerUtil INSTANCE = new InstallReferrerUtil();
    private static final String IS_REFERRER_UPDATED = "is_referrer_updated";
    private static final long REFERRER_FETCH_TIMEOUT = 5;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        void onReceiveReferrerUrl(String str);
    }

    private InstallReferrerUtil() {
    }

    private final boolean isUpdated() {
        return FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).getBoolean(IS_REFERRER_UPDATED, false);
    }

    private final void tryConnectReferrerInfo(final Callback callback, final CountDownLatch countDownLatch) {
        final InstallReferrerClient installReferrerClientBuild = InstallReferrerClient.newBuilder(FacebookSdk.getApplicationContext()).build();
        try {
            installReferrerClientBuild.startConnection(new InstallReferrerStateListener() { // from class: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerServiceDisconnected() {
                    CountDownLatch countDownLatch2 = countDownLatch;
                    if (countDownLatch2 != null) {
                        countDownLatch2.countDown();
                    }
                }

                /* JADX WARN: Finally extract failed */
                @Override // com.android.installreferrer.api.InstallReferrerStateListener
                public void onInstallReferrerSetupFinished(int i3) {
                    CountDownLatch countDownLatch2;
                    if (CrashShieldHandler.isObjectCrashing(this)) {
                        return;
                    }
                    try {
                        try {
                            if (i3 == 0) {
                                try {
                                    ReferrerDetails installReferrer = installReferrerClientBuild.getInstallReferrer();
                                    Intrinsics.checkNotNullExpressionValue(installReferrer, "{\n                      …r\n                      }");
                                    String installReferrer2 = installReferrer.getInstallReferrer();
                                    if (installReferrer2 != null && (StringsKt.a0(installReferrer2, "fb", false, 2, null) || StringsKt.a0(installReferrer2, AccessToken.DEFAULT_GRAPH_DOMAIN, false, 2, null))) {
                                        callback.onReceiveReferrerUrl(installReferrer2);
                                    }
                                    InstallReferrerUtil.INSTANCE.updateReferrer();
                                } catch (RemoteException unused) {
                                    countDownLatch2 = countDownLatch;
                                    if (countDownLatch2 == null) {
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                InstallReferrerUtil.INSTANCE.updateReferrer();
                            }
                            try {
                                installReferrerClientBuild.endConnection();
                            } catch (Exception unused2) {
                            }
                            countDownLatch2 = countDownLatch;
                            if (countDownLatch2 == null) {
                                return;
                            }
                            countDownLatch2.countDown();
                        } catch (Throwable th) {
                            CountDownLatch countDownLatch3 = countDownLatch;
                            if (countDownLatch3 != null) {
                                countDownLatch3.countDown();
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        CrashShieldHandler.handleThrowable(th2, this);
                    }
                }
            });
        } catch (Exception unused) {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }

    static /* synthetic */ void tryConnectReferrerInfo$default(InstallReferrerUtil installReferrerUtil, Callback callback, CountDownLatch countDownLatch, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            countDownLatch = null;
        }
        installReferrerUtil.tryConnectReferrerInfo(callback, countDownLatch);
    }

    @JvmStatic
    public static final void tryUpdateReferrerInfo(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (installReferrerUtil.isUpdated()) {
            return;
        }
        tryConnectReferrerInfo$default(installReferrerUtil, callback, null, 2, null);
    }

    @JvmStatic
    public static final void tryUpdateReferrerInfoBlocking(Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        InstallReferrerUtil installReferrerUtil = INSTANCE;
        if (installReferrerUtil.isUpdated()) {
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        installReferrerUtil.tryConnectReferrerInfo(callback, countDownLatch);
        try {
            countDownLatch.await(REFERRER_FETCH_TIMEOUT, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateReferrer() {
        FacebookSdk.getApplicationContext().getSharedPreferences(FacebookSdk.APP_EVENT_PREFERENCES, 0).edit().putBoolean(IS_REFERRER_UPDATED, true).apply();
    }
}
