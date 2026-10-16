package com.google.android.material.color;

import android.content.Context;
import com.google.android.material.R;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class ResourcesLoaderColorResourcesOverride implements ColorResourcesOverride {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ResourcesLoaderColorResourcesOverrideSingleton {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final ResourcesLoaderColorResourcesOverride f80589a = new ResourcesLoaderColorResourcesOverride();
    }

    static ColorResourcesOverride getInstance() {
        return ResourcesLoaderColorResourcesOverrideSingleton.f80589a;
    }

    @Override // com.google.android.material.color.ColorResourcesOverride
    public boolean a(Context context, Map map) {
        if (!ResourcesLoaderUtils.a(context, map)) {
            return false;
        }
        ThemeUtils.a(context, R.style.f79738k);
        return true;
    }

    private ResourcesLoaderColorResourcesOverride() {
    }
}
