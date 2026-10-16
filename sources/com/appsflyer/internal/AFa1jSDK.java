package com.appsflyer.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AFa1jSDK implements AFa1kSDK {
    private Map<String, String> AFInAppEventParameterName = new LinkedHashMap();

    @Override // com.appsflyer.internal.AFa1kSDK
    public final Map<String, String> AFInAppEventType(Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        if (this.AFInAppEventParameterName.isEmpty()) {
            Resources resources = context.getResources();
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            int i3 = resources.getConfiguration().screenLayout & 15;
            this.AFInAppEventParameterName.put("xdp", String.valueOf(displayMetrics.xdpi));
            this.AFInAppEventParameterName.put("ydp", String.valueOf(displayMetrics.ydpi));
            this.AFInAppEventParameterName.put("x_px", String.valueOf(displayMetrics.widthPixels));
            this.AFInAppEventParameterName.put("y_px", String.valueOf(displayMetrics.heightPixels));
            this.AFInAppEventParameterName.put("d_dpi", String.valueOf(displayMetrics.densityDpi));
            this.AFInAppEventParameterName.put("size", String.valueOf(i3));
        }
        return this.AFInAppEventParameterName;
    }
}
