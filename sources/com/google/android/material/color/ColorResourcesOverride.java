package com.google.android.material.color;

import android.content.Context;
import android.os.Build;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface ColorResourcesOverride {
    static ColorResourcesOverride getInstance() {
        int i3 = Build.VERSION.SDK_INT;
        if (30 <= i3 && i3 <= 33) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        if (i3 >= 34) {
            return ResourcesLoaderColorResourcesOverride.getInstance();
        }
        return null;
    }

    boolean a(Context context, Map map);
}
