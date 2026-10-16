package cz.mobilesoft.coreblock.util;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Build;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f127878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f127879b;

    public GlobalExceptionHandler(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uncaughtExceptionHandler, "uncaughtExceptionHandler");
        this.f127878a = context;
        this.f127879b = uncaughtExceptionHandler;
    }

    private final String a(ApplicationExitInfo applicationExitInfo) {
        switch (applicationExitInfo.getReason()) {
            case 0:
                return "UNKNOWN";
            case 1:
                return "EXIT_SELF";
            case 2:
                return "SIGNALED";
            case 3:
                return "LOW_MEMORY";
            case 4:
                return "CRASH";
            case 5:
                return "CRASH_NATIVE";
            case 6:
                return "ANR";
            case 7:
                return "INITIALIZATION_FAILURE";
            case 8:
                return "PERMISSION_CHANGE";
            case 9:
                return "EXCESSIVE_RESOURCE_USAGE";
            case 10:
                return "USER_REQUESTED";
            case 11:
                return "USER_STOPPED";
            case 12:
                return "DEPENDENCY_DIED";
            case 13:
                return "OTHER";
            default:
                return String.valueOf(applicationExitInfo.getReason());
        }
    }

    private final String b(Context context) {
        UsageStatsManager usageStatsManager = (UsageStatsManager) context.getSystemService(UsageStatsManager.class);
        if (usageStatsManager == null) {
            return "";
        }
        int appStandbyBucket = usageStatsManager.getAppStandbyBucket();
        return appStandbyBucket < 10 ? "ACTIVE" : appStandbyBucket < 20 ? "WORKING_SET" : appStandbyBucket < 30 ? "FREQUENT" : appStandbyBucket < 40 ? "RARE" : appStandbyBucket < 45 ? "RESTRICTED" : String.valueOf(appStandbyBucket);
    }

    private final void c(Context context, Throwable th, Thread thread) throws IOException {
        if (Build.VERSION.SDK_INT >= 30) {
            Object systemService = context.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List historicalProcessExitReasons = ((ActivityManager) systemService).getHistoricalProcessExitReasons(context.getPackageName(), 0, 20);
            Intrinsics.checkNotNullExpressionValue(historicalProcessExitReasons, "getHistoricalProcessExitReasons(...)");
            ApplicationExitInfo applicationExitInfoA = androidx.work.impl.utils.b.a(CollectionsKt.firstOrNull(historicalProcessExitReasons));
            if (applicationExitInfoA != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace();
                CrashHelper.f127788a.h("Stacktrace: " + stringWriter + "\nTime: " + new Date(applicationExitInfoA.getTimestamp()) + "\nProcess: " + applicationExitInfoA.getProcessName() + "\nReason: " + a(applicationExitInfoA) + "\nStatus: " + applicationExitInfoA.getStatus() + "\nMemory: " + applicationExitInfoA.getPss() + "/" + applicationExitInfoA.getRss() + "\nImportance: '" + applicationExitInfoA.getImportance() + "\nDesc: " + applicationExitInfoA.getDescription() + "\nTraceInputStream: " + applicationExitInfoA.getTraceInputStream() + "\nBucket: " + b(context), th);
            }
            this.f127879b.uncaughtException(thread, th);
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable throwable) throws IOException {
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        c(this.f127878a, throwable, thread);
    }
}
