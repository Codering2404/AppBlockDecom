package com.appsflyer;

import android.util.Log;
import com.appsflyer.internal.AFa1bSDK;
import com.facebook.internal.AnalyticsEvents;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AFLogger {
    private static final long AFInAppEventType = System.currentTimeMillis();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);

        private int AFKeystoreWrapper;

        LogLevel(int i3) {
            this.AFKeystoreWrapper = i3;
        }

        public final int getLevel() {
            return this.AFKeystoreWrapper;
        }
    }

    private static String AFInAppEventParameterName(String str, boolean z2) {
        if (str == null) {
            str = "null";
        }
        if (!z2 && LogLevel.VERBOSE.getLevel() > AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            return str;
        }
        StringBuilder sb = new StringBuilder("(");
        sb.append(System.currentTimeMillis() - AFInAppEventType);
        sb.append(") [");
        sb.append(Thread.currentThread().getName());
        sb.append("] ");
        sb.append(str);
        return sb.toString();
    }

    public static void AFInAppEventType(String str) {
        if (!AFInAppEventType()) {
            Log.d("AppsFlyer_6.12.3", AFInAppEventParameterName(str, false));
        }
        AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("F", str);
    }

    public static void AFKeystoreWrapper(String str) {
        if (valueOf(LogLevel.WARNING)) {
            Log.w("AppsFlyer_6.12.3", AFInAppEventParameterName(str, false));
        }
        AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("W", AFInAppEventParameterName(str, true));
    }

    public static void afDebugLog(String str) {
        if (valueOf(LogLevel.DEBUG)) {
            Log.d("AppsFlyer_6.12.3", AFInAppEventParameterName(str, false));
        }
        AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("D", AFInAppEventParameterName(str, true));
    }

    public static void afErrorLog(String str, Throwable th, boolean z2, boolean z3, boolean z4) {
        if (str == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(th.getClass().getSimpleName());
            sb.append(" at ");
            sb.append(th.getStackTrace()[0].toString());
            str = sb.toString();
        }
        if (valueOf(LogLevel.ERROR)) {
            String strAFInAppEventParameterName = AFInAppEventParameterName(str, false);
            if (z3) {
                Log.e("AppsFlyer_6.12.3", strAFInAppEventParameterName, th);
            } else if (z2) {
                Log.d("AppsFlyer_6.12.3", strAFInAppEventParameterName);
            }
        }
        AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventType(th);
        if (z4) {
            AFa1bSDK.values().valueOf().onResponseErrorNative().values(th, str);
        }
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th) {
        afErrorLogForExcManagerOnly(str, th, false);
    }

    public static void afInfoLog(String str, boolean z2) {
        if (valueOf(LogLevel.INFO)) {
            Log.i("AppsFlyer_6.12.3", AFInAppEventParameterName(str, false));
        }
        if (z2) {
            AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("I", AFInAppEventParameterName(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (valueOf(LogLevel.VERBOSE)) {
            Log.v("AppsFlyer_6.12.3", AFInAppEventParameterName(str, false));
        }
        AFa1bSDK.values().valueOf().afErrorLogForExcManagerOnly().AFInAppEventParameterName("V", AFInAppEventParameterName(str, true));
    }

    public static void afWarnLog(String str) {
        AFKeystoreWrapper(str);
    }

    private static boolean valueOf(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    public static void afErrorLogForExcManagerOnly(String str, Throwable th, boolean z2) {
        afErrorLog(str, th, false, false, !z2);
    }

    private static boolean AFInAppEventType() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    public static void afErrorLog(String str, Throwable th) {
        afErrorLog(str, th, true, false, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z2) {
        afErrorLog(str, th, true, z2, true);
    }

    public static void afErrorLog(String str, Throwable th, boolean z2, boolean z3) {
        afErrorLog(str, th, true, z2, z3);
    }

    @Deprecated
    public static void afErrorLog(Throwable th) {
        afErrorLogForExcManagerOnly(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, th);
    }
}
