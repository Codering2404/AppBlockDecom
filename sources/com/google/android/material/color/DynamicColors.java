package com.google.android.material.color;

import android.app.Activity;
import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import androidx.core.os.BuildCompat;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.color.utilities.SchemeContent;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DynamicColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f80572a = {R.attr.f79522x};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final DeviceSupportCondition f80573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final DeviceSupportCondition f80574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f80575d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Map f80576e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f80577f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface DeviceSupportCondition {
        boolean a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnAppliedCallback {
        void a(Activity activity);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Precondition {
        boolean a(Activity activity, int i3);
    }

    static {
        DeviceSupportCondition deviceSupportCondition = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.1
            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean a() {
                return true;
            }
        };
        f80573b = deviceSupportCondition;
        DeviceSupportCondition deviceSupportCondition2 = new DeviceSupportCondition() { // from class: com.google.android.material.color.DynamicColors.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private Long f80578a;

            @Override // com.google.android.material.color.DynamicColors.DeviceSupportCondition
            public boolean a() {
                if (this.f80578a == null) {
                    try {
                        Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                        declaredMethod.setAccessible(true);
                        Long l3 = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                        l3.longValue();
                        this.f80578a = l3;
                    } catch (Exception unused) {
                        this.f80578a = -1L;
                    }
                }
                return this.f80578a.longValue() >= 40100;
            }
        };
        f80574c = deviceSupportCondition2;
        HashMap map = new HashMap();
        map.put("fcnt", deviceSupportCondition);
        map.put("google", deviceSupportCondition);
        map.put("hmd global", deviceSupportCondition);
        map.put("infinix", deviceSupportCondition);
        map.put("infinix mobility limited", deviceSupportCondition);
        map.put("itel", deviceSupportCondition);
        map.put("kyocera", deviceSupportCondition);
        map.put("lenovo", deviceSupportCondition);
        map.put("lge", deviceSupportCondition);
        map.put("meizu", deviceSupportCondition);
        map.put("motorola", deviceSupportCondition);
        map.put("nothing", deviceSupportCondition);
        map.put("oneplus", deviceSupportCondition);
        map.put("oppo", deviceSupportCondition);
        map.put("realme", deviceSupportCondition);
        map.put("robolectric", deviceSupportCondition);
        map.put("samsung", deviceSupportCondition2);
        map.put("sharp", deviceSupportCondition);
        map.put("shift", deviceSupportCondition);
        map.put("sony", deviceSupportCondition);
        map.put("tcl", deviceSupportCondition);
        map.put("tecno", deviceSupportCondition);
        map.put("tecno mobile limited", deviceSupportCondition);
        map.put("vivo", deviceSupportCondition);
        map.put("wingtech", deviceSupportCondition);
        map.put("xiaomi", deviceSupportCondition);
        f80575d = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", deviceSupportCondition);
        map2.put("jio", deviceSupportCondition);
        f80576e = Collections.unmodifiableMap(map2);
        f80577f = DynamicColors.class.getSimpleName();
    }

    public static void a(Activity activity, DynamicColorsOptions dynamicColorsOptions) {
        if (d()) {
            int iB = dynamicColorsOptions.a() == null ? dynamicColorsOptions.d() == 0 ? b(activity, f80572a) : dynamicColorsOptions.d() : 0;
            if (dynamicColorsOptions.c().a(activity, iB)) {
                if (dynamicColorsOptions.a() != null) {
                    SchemeContent schemeContent = new SchemeContent(Hct.b(dynamicColorsOptions.a().intValue()), !MaterialColors.j(activity), c(activity));
                    ColorResourcesOverride colorResourcesOverride = ColorResourcesOverride.getInstance();
                    if (colorResourcesOverride == null || !colorResourcesOverride.a(activity, MaterialColorUtilitiesHelper.a(schemeContent))) {
                        return;
                    }
                } else {
                    ThemeUtils.a(activity, iB);
                }
                dynamicColorsOptions.b().a(activity);
            }
        }
    }

    private static int b(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private static float c(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager == null || Build.VERSION.SDK_INT < 34) {
            return 0.0f;
        }
        return uiModeManager.getContrast();
    }

    public static boolean d() {
        if (Build.VERSION.SDK_INT < 31) {
            return false;
        }
        if (BuildCompat.b()) {
            return true;
        }
        Map map = f80575d;
        String str = Build.MANUFACTURER;
        Locale locale = Locale.ROOT;
        DeviceSupportCondition deviceSupportCondition = (DeviceSupportCondition) map.get(str.toLowerCase(locale));
        if (deviceSupportCondition == null) {
            deviceSupportCondition = (DeviceSupportCondition) f80576e.get(Build.BRAND.toLowerCase(locale));
        }
        return deviceSupportCondition != null && deviceSupportCondition.a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class DynamicColorsActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final DynamicColorsOptions f80579a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            DynamicColors.a(activity, this.f80579a);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }
    }
}
