package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Log;
import android.view.View;
import com.revenuecat.purchases.common.Constants;
import java.nio.CharBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class Debug {
    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String b() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + stackTraceElement.getLineNumber() + ")";
    }

    public static String c(Context context, int i3) {
        if (i3 == -1) {
            return "UNKNOWN";
        }
        try {
            return context.getResources().getResourceEntryName(i3);
        } catch (Exception unused) {
            return "?" + i3;
        }
    }

    public static String d(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static String e(MotionLayout motionLayout, int i3) {
        return f(motionLayout, i3, -1);
    }

    public static String f(MotionLayout motionLayout, int i3, int i4) {
        int length;
        if (i3 == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = motionLayout.getContext().getResources().getResourceEntryName(i3);
        if (i4 == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > i4) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= i4 || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - i4) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    public static void g(String str, String str2, int i3) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(i3, stackTrace.length - 1);
        String str3 = " ";
        for (int i4 = 1; i4 <= iMin; i4++) {
            StackTraceElement stackTraceElement = stackTrace[i4];
            str3 = str3 + " ";
            Log.v(str, str2 + str3 + (".(" + stackTrace[i4].getFileName() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + stackTrace[i4].getLineNumber() + ") " + stackTrace[i4].getMethodName()) + str3);
        }
    }
}
