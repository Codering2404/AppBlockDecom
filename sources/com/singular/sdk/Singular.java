package com.singular.sdk;

import android.content.Context;
import com.singular.sdk.internal.SLPushNotificationsManager;
import com.singular.sdk.internal.SingularInstance;
import com.singular.sdk.internal.SingularLog;
import com.singular.sdk.internal.Utils;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public class Singular {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SingularInstance f92413b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SingularLog f92412a = SingularLog.f(Singular.class.getSimpleName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f92414c = false;

    public static boolean a(String str, String str2, double d3) {
        return c(str, "pcc", str2, "r", Double.valueOf(d3), "is_revenue_event", Boolean.TRUE);
    }

    public static boolean b(String str) {
        try {
            if (!f()) {
                return false;
            }
            if (!Utils.U(str)) {
                return f92413b.O(str);
            }
            f92412a.c("Event name can not be null or empty");
            return false;
        } catch (Throwable th) {
            f92412a.c(Utils.l(th));
            return false;
        }
    }

    public static boolean c(String str, Object... objArr) {
        try {
            if (!f()) {
                return false;
            }
            if (Utils.U(str)) {
                f92412a.c("Event name can not be null or empty");
                return false;
            }
            if (objArr.length % 2 != 0) {
                f92412a.c("Extra arguments must be in even numbers.");
                return false;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                for (int i3 = 0; i3 < objArr.length; i3 += 2) {
                    jSONObject.put((String) objArr[i3], objArr[i3 + 1]);
                }
                return d(str, jSONObject);
            } catch (JSONException e3) {
                f92412a.d("error in serializing extra args", e3);
            }
        } catch (Throwable th) {
            f92412a.d("Exception", th);
        }
        return false;
    }

    public static boolean d(String str, JSONObject jSONObject) {
        try {
            if (!f()) {
                return false;
            }
            if (!Utils.U(str)) {
                return f92413b.P(str, jSONObject != null ? jSONObject.toString() : null);
            }
            f92412a.c("Event name can not be null or empty");
            return false;
        } catch (Throwable th) {
            f92412a.d("Exception", th);
            return false;
        }
    }

    public static boolean e(Context context, SingularConfig singularConfig) {
        try {
        } catch (IOException e3) {
            SingularLog singularLog = f92412a;
            singularLog.a("Failed to init() Singular SDK");
            singularLog.c(Utils.l(e3));
            f92413b = null;
        } catch (Throwable th) {
            f92412a.c(Utils.l(th));
        }
        if (context == null || singularConfig == null) {
            SingularLog singularLog2 = f92412a;
            StringBuilder sb = new StringBuilder();
            sb.append("SDK initialization failed: ");
            sb.append(context == null ? "context == null " : "");
            sb.append(singularConfig == null ? "config == null" : "");
            sb.append(". Please provide a valid Context, SingularConfig.");
            singularLog2.c(sb.toString());
            return false;
        }
        f92414c = f92413b != null;
        if (singularConfig.f92416a.endsWith("_sl")) {
            Utils.n0(singularConfig.f92416a);
        }
        f92413b = SingularInstance.v(context, SingularConfig.a(singularConfig));
        if (!f92414c) {
            f92412a.a("singular instance is not initialized. start will be sent from session manager.");
        } else if (SLPushNotificationsManager.e().h(singularConfig.f92441z, singularConfig.A).booleanValue()) {
            SLPushNotificationsManager.e().b();
            f92413b.c0();
        } else {
            f92413b.b0();
        }
        return f();
    }

    private static boolean f() {
        if (f92413b != null) {
            return true;
        }
        f92412a.c("Singular not initialized. You must call Singular.init() ");
        return false;
    }

    public static boolean g(String str, double d3) {
        return a("__iap__", str, d3);
    }

    public static void h(String str) {
        try {
            if (f()) {
                f92413b.W(str);
            }
        } catch (Throwable th) {
            f92412a.c(Utils.l(th));
        }
    }

    public static void i() {
        try {
            if (f()) {
                f92413b.W("");
            }
        } catch (Throwable th) {
            f92412a.c(Utils.l(th));
        }
    }
}
