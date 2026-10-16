package com.facebook.internal.instrument.anrreport;

import android.app.ActivityManager;
import android.os.Looper;
import android.os.Process;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.InstrumentData;
import com.facebook.internal.instrument.InstrumentUtility;
import com.facebook.internal.instrument.anrreport.ANRDetector;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ANRDetector {
    private static final int DETECTION_INTERVAL_IN_MS = 500;
    public static final ANRDetector INSTANCE = new ANRDetector();
    private static final int myUid = Process.myUid();
    private static final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private static String previousStackTrace = "";
    private static final Runnable anrDetectorRunnable = new Runnable() { // from class: p.a
        @Override // java.lang.Runnable
        public final void run() {
            ANRDetector.anrDetectorRunnable$lambda$0();
        }
    };

    private ANRDetector() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void anrDetectorRunnable$lambda$0() {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
            return;
        }
        try {
            Object systemService = FacebookSdk.getApplicationContext().getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            checkProcessError((ActivityManager) systemService);
        } catch (Exception unused) {
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRDetector.class);
        }
    }

    @JvmStatic
    public static final void checkProcessError(ActivityManager activityManager) {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class) || activityManager == null) {
            return;
        }
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
            if (processesInErrorState != null) {
                for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                    if (processErrorStateInfo.condition == 2 && processErrorStateInfo.uid == myUid) {
                        Thread thread = Looper.getMainLooper().getThread();
                        Intrinsics.checkNotNullExpressionValue(thread, "getMainLooper().thread");
                        String stackTrace = InstrumentUtility.getStackTrace(thread);
                        if (!Intrinsics.areEqual(stackTrace, previousStackTrace) && InstrumentUtility.isSDKRelatedThread(thread)) {
                            previousStackTrace = stackTrace;
                            InstrumentData.Builder.build(processErrorStateInfo.shortMsg, stackTrace).save();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRDetector.class);
        }
    }

    @JvmStatic
    public static final void start() {
        if (CrashShieldHandler.isObjectCrashing(ANRDetector.class)) {
            return;
        }
        try {
            scheduledExecutorService.scheduleWithFixedDelay(anrDetectorRunnable, 0L, 500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, ANRDetector.class);
        }
    }
}
