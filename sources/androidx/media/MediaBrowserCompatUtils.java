package androidx.media;

import android.os.Bundle;
import com.google.android.gms.common.api.Api;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class MediaBrowserCompatUtils {
    public static boolean a(Bundle bundle, Bundle bundle2) {
        if (bundle == bundle2) {
            return true;
        }
        return bundle == null ? bundle2.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle2 == null ? bundle.getInt("android.media.browse.extra.PAGE", -1) == -1 && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == -1 : bundle.getInt("android.media.browse.extra.PAGE", -1) == bundle2.getInt("android.media.browse.extra.PAGE", -1) && bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1) == bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
    }

    public static boolean b(Bundle bundle, Bundle bundle2) {
        int i3;
        int i4;
        int i5;
        int i6 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE", -1);
        int i7 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE", -1);
        int i8 = bundle == null ? -1 : bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i9 = bundle2 == null ? -1 : bundle2.getInt("android.media.browse.extra.PAGE_SIZE", -1);
        int i10 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (i6 == -1 || i8 == -1) {
            i3 = Integer.MAX_VALUE;
            i4 = 0;
        } else {
            i4 = i6 * i8;
            i3 = (i8 + i4) - 1;
        }
        if (i7 == -1 || i9 == -1) {
            i5 = 0;
        } else {
            i5 = i7 * i9;
            i10 = (i9 + i5) - 1;
        }
        return i3 >= i5 && i10 >= i4;
    }
}
