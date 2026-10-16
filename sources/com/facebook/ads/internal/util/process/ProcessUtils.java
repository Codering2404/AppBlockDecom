package com.facebook.ads.internal.util.process;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.revenuecat.purchases.common.Constants;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ProcessUtils {
    private static String sProcessName;
    private static final AtomicBoolean sRemoteRenderingProcess = new AtomicBoolean();

    private ProcessUtils() {
    }

    public static String getProcessName(Context context) {
        synchronized (ProcessUtils.class) {
            try {
                String str = sProcessName;
                return str != null ? str : getProcessNameAPI28();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static String getProcessNameAPI28() {
        try {
            return (String) Application.class.getMethod("getProcessName", null).invoke(null, null);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String getProcessNameViaReflection(Application application) {
        try {
            Field field = application.getClass().getField("mLoadedApk");
            field.setAccessible(true);
            Object obj = field.get(application);
            Field declaredField = obj.getClass().getDeclaredField("mActivityThread");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            return (String) obj2.getClass().getDeclaredMethod("getProcessName", null).invoke(obj2, null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getProcessSpecificName(String str, Context context) {
        String packageName = context.getPackageName();
        String processName = getProcessName(context);
        if (TextUtils.isEmpty(processName) || packageName.equals(processName)) {
            return str;
        }
        if (processName.contains(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
            processName = processName.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)[1];
        }
        return str + "_" + processName;
    }

    public static boolean isRemoteRenderingProcess() {
        return sRemoteRenderingProcess.get();
    }

    public static void setRemoteRenderingProcess(boolean z2) {
        sRemoteRenderingProcess.set(z2);
    }
}
