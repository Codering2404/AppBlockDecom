package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.core.graphics.BlendModeUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class BlendModeColorFilterCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static ColorFilter a(int i3, Object obj) {
            return new BlendModeColorFilter(i3, (BlendMode) obj);
        }
    }

    public static ColorFilter a(int i3, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            Object objA = BlendModeUtils.Api29Impl.a(blendModeCompat);
            if (objA != null) {
                return Api29Impl.a(i3, objA);
            }
            return null;
        }
        PorterDuff.Mode modeA = BlendModeUtils.a(blendModeCompat);
        if (modeA != null) {
            return new PorterDuffColorFilter(i3, modeA);
        }
        return null;
    }
}
