package com.applovin.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.ImageViewUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.yp;
import com.applovin.impl.z3;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinSdkUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Handler f65620a = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Size {
        public static final Size ZERO = new Size(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f65621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f65622b;

        public Size(int i3, int i4) {
            this.f65621a = i3;
            this.f65622b = i4;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Size)) {
                return false;
            }
            Size size = (Size) obj;
            return this.f65621a == size.getWidth() && this.f65622b == size.getHeight();
        }

        public int getHeight() {
            return this.f65622b;
        }

        public int getWidth() {
            return this.f65621a;
        }

        public int hashCode() {
            int i3 = this.f65622b;
            int i4 = this.f65621a;
            return i3 ^ ((i4 >>> 16) | (i4 << 16));
        }

        public String toString() {
            return this.f65621a + "x" + this.f65622b;
        }
    }

    private static boolean a(String str, String str2) {
        return StringUtils.startsWithAtLeastOnePrefix(str, CollectionUtils.explode(str2));
    }

    public static int dpToPx(Context context, int i3) {
        return (int) TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static int getOrientation(Context context) {
        Resources resources;
        Configuration configuration;
        if (context == null || (resources = context.getResources()) == null || (configuration = resources.getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static boolean isEmulator() {
        return a(Build.DEVICE, "goldfish,vbox") || a(Build.HARDWARE, "ranchu,generic,vbox") || a(Build.MANUFACTURER, "Genymotion") || a(Build.MODEL, "Android SDK built for x86");
    }

    public static boolean isFireOS(Context context) {
        return "amazon".equalsIgnoreCase(Build.MANUFACTURER) || isFireTv(context);
    }

    public static boolean isFireTv(Context context) {
        return context.getPackageManager().hasSystemFeature("amazon.hardware.fire_tv");
    }

    public static boolean isInclusiveVersion(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int iF = yp.f(str);
        if (str2 == null || iF >= yp.f(str2)) {
            return str3 == null || iF <= yp.f(str3);
        }
        return false;
    }

    public static boolean isSdkVersionGreaterThanOrEqualTo(String str) {
        return AppLovinSdk.VERSION_CODE >= yp.f(str);
    }

    public static boolean isTablet(Context context) {
        Point pointB = z3.b(context);
        return Math.min(pointB.x, pointB.y) >= dpToPx(context, 600);
    }

    public static boolean isTv(Context context) {
        if (isFireTv(context)) {
            return true;
        }
        PackageManager packageManager = context.getPackageManager();
        return z3.f() ? packageManager.hasSystemFeature("android.software.leanback") : packageManager.hasSystemFeature("android.hardware.type.television");
    }

    public static boolean isValidString(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static int pxToDp(Context context, int i3) {
        return (int) Math.ceil(i3 / context.getResources().getDisplayMetrics().density);
    }

    public static void runOnUiThread(Runnable runnable) {
        runOnUiThread(false, runnable);
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j3) {
        runOnUiThreadDelayed(runnable, j3, f65620a);
    }

    public static void setImageUrl(String str, ImageView imageView, AppLovinSdk appLovinSdk) {
        ImageViewUtils.setImageUri(imageView, Uri.parse(str), appLovinSdk.a());
    }

    public static Map<String, String> toMap(JSONObject jSONObject) throws JSONException {
        return JsonUtils.toStringMap(jSONObject);
    }

    public static void runOnUiThread(boolean z2, Runnable runnable) {
        if (z2 || !yp.h()) {
            f65620a.post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void runOnUiThreadDelayed(Runnable runnable, long j3, Handler handler) {
        if (j3 > 0) {
            handler.postDelayed(runnable, j3);
        } else if (yp.h()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }
}
