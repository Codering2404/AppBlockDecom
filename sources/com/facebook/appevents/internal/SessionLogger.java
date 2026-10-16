package com.facebook.appevents.internal;

import android.content.Context;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.UserSettingsManager;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.superwall.sdk.billing.BillingClientUseCaseKt;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class SessionLogger {
    public static final SessionLogger INSTANCE = new SessionLogger();
    private static final String TAG = SessionLogger.class.getCanonicalName();
    private static final long[] INACTIVE_SECONDS_QUANTA = {300000, BillingClientUseCaseKt.RETRY_TIMER_MAX_TIME_MILLISECONDS, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, UserSettingsManager.TIMEOUT_7D, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    private SessionLogger() {
    }

    @JvmStatic
    public static final int getQuantaIndex(long j3) {
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return 0;
        }
        int i3 = 0;
        while (true) {
            try {
                long[] jArr = INACTIVE_SECONDS_QUANTA;
                if (i3 >= jArr.length || jArr[i3] >= j3) {
                    break;
                }
                i3++;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, SessionLogger.class);
                return 0;
            }
        }
        return i3;
    }

    @JvmStatic
    public static final void logActivateApp(String activityName, SourceApplicationInfo sourceApplicationInfo, String str, Context context) {
        String string;
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            Intrinsics.checkNotNullParameter(context, "context");
            if (sourceApplicationInfo == null || (string = sourceApplicationInfo.toString()) == null) {
                string = "Unclassified";
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, string);
            InternalAppEventsLogger.Companion companion = InternalAppEventsLogger.Companion;
            InternalAppEventsLogger internalAppEventsLoggerCreateInstance = companion.createInstance(activityName, str, null);
            internalAppEventsLoggerCreateInstance.logEvent(AppEventsConstants.EVENT_NAME_ACTIVATED_APP, bundle);
            if (companion.getFlushBehavior() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
                internalAppEventsLoggerCreateInstance.flush();
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SessionLogger.class);
        }
    }

    private final void logClockSkewEvent() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Logger.Companion companion = Logger.Companion;
            LoggingBehavior loggingBehavior = LoggingBehavior.APP_EVENTS;
            String str = TAG;
            Intrinsics.checkNotNull(str);
            companion.log(loggingBehavior, str, "Clock skew detected");
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final void logDeactivateApp(String activityName, SessionInfo sessionInfo, String str) {
        long jLongValue;
        String string;
        if (CrashShieldHandler.isObjectCrashing(SessionLogger.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            if (sessionInfo == null) {
                return;
            }
            Long diskRestoreTime = sessionInfo.getDiskRestoreTime();
            if (diskRestoreTime != null) {
                jLongValue = diskRestoreTime.longValue();
            } else {
                Long sessionLastEventTime = sessionInfo.getSessionLastEventTime();
                jLongValue = 0 - (sessionLastEventTime != null ? sessionLastEventTime.longValue() : 0L);
            }
            if (jLongValue < 0) {
                INSTANCE.logClockSkewEvent();
                jLongValue = 0;
            }
            long sessionLength = sessionInfo.getSessionLength();
            if (sessionLength < 0) {
                INSTANCE.logClockSkewEvent();
                sessionLength = 0;
            }
            Bundle bundle = new Bundle();
            bundle.putInt(AppEventsConstants.EVENT_NAME_SESSION_INTERRUPTIONS, sessionInfo.getInterruptionCount());
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            String str2 = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(getQuantaIndex(jLongValue))}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(locale, format, *args)");
            bundle.putString(AppEventsConstants.EVENT_NAME_TIME_BETWEEN_SESSIONS, str2);
            SourceApplicationInfo sourceApplicationInfo = sessionInfo.getSourceApplicationInfo();
            if (sourceApplicationInfo == null || (string = sourceApplicationInfo.toString()) == null) {
                string = "Unclassified";
            }
            bundle.putString(AppEventsConstants.EVENT_PARAM_SOURCE_APPLICATION, string);
            Long sessionLastEventTime2 = sessionInfo.getSessionLastEventTime();
            bundle.putLong(Constants.LOG_TIME_APP_EVENT_KEY, (sessionLastEventTime2 != null ? sessionLastEventTime2.longValue() : 0L) / ((long) 1000));
            InternalAppEventsLogger.Companion.createInstance(activityName, str, null).logEvent(AppEventsConstants.EVENT_NAME_DEACTIVATED_APP, sessionLength / 1000, bundle);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, SessionLogger.class);
        }
    }
}
