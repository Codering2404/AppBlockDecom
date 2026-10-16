package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.provider.MediaStore;
import com.applovin.sdk.AppLovinEventTypes;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class MediaStoreUtil {
    public static boolean a(Uri uri) {
        return d(uri) && uri.getPathSegments().contains("picker");
    }

    public static boolean b(Uri uri) {
        return d(uri) && !g(uri);
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(30) >= 17;
    }

    public static boolean d(Uri uri) {
        return uri != null && AppLovinEventTypes.USER_VIEWED_CONTENT.equals(uri.getScheme()) && ShareConstants.WEB_DIALOG_PARAM_MEDIA.equals(uri.getAuthority());
    }

    public static boolean e(Uri uri) {
        return d(uri) && g(uri);
    }

    public static boolean f(int i3, int i4) {
        return i3 != Integer.MIN_VALUE && i4 != Integer.MIN_VALUE && i3 <= 512 && i4 <= 384;
    }

    private static boolean g(Uri uri) {
        return uri.getPathSegments().contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO);
    }

    public static AssetFileDescriptor h(Uri uri, ContentResolver contentResolver) {
        return MediaStore.openAssetFileDescriptor(contentResolver, uri, "r", null);
    }
}
