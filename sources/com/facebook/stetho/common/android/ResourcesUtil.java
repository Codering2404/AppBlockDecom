package com.facebook.stetho.common.android;

import android.content.res.Resources;
import com.facebook.stetho.common.LogUtil;
import com.revenuecat.purchases.common.Constants;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourcesUtil {
    private ResourcesUtil() {
    }

    private static String getFallbackIdString(int i3) {
        return "#" + Integer.toHexString(i3);
    }

    public static String getIdString(@Nullable Resources resources, int i3) throws Resources.NotFoundException {
        String resourcePackageName;
        String str;
        if (resources == null) {
            return getFallbackIdString(i3);
        }
        if (getResourcePackageId(i3) != 127) {
            resourcePackageName = resources.getResourcePackageName(i3);
            str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR;
        } else {
            resourcePackageName = "";
            str = "";
        }
        String resourceTypeName = resources.getResourceTypeName(i3);
        String resourceEntryName = resources.getResourceEntryName(i3);
        StringBuilder sb = new StringBuilder(resourcePackageName.length() + 1 + str.length() + resourceTypeName.length() + 1 + resourceEntryName.length());
        sb.append("@");
        sb.append(resourcePackageName);
        sb.append(str);
        sb.append(resourceTypeName);
        sb.append("/");
        sb.append(resourceEntryName);
        return sb.toString();
    }

    @Nonnull
    public static String getIdStringQuietly(Object obj, @Nullable Resources resources, int i3) {
        try {
            return getIdString(resources, i3);
        } catch (Resources.NotFoundException unused) {
            String fallbackIdString = getFallbackIdString(i3);
            LogUtil.w("Unknown identifier encountered on " + obj + ": " + fallbackIdString);
            return fallbackIdString;
        }
    }

    private static int getResourcePackageId(int i3) {
        return (i3 >>> 24) & 255;
    }
}
