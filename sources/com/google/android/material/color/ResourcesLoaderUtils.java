package com.google.android.material.color;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ResourcesLoaderUtils {
    static boolean a(Context context, Map map) {
        ResourcesLoader resourcesLoaderA = ColorResourcesLoaderCreator.a(context, map);
        if (resourcesLoaderA == null) {
            return false;
        }
        context.getResources().addLoaders(resourcesLoaderA);
        return true;
    }
}
