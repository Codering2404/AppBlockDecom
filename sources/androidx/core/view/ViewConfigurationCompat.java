package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.core.util.Supplier;
import com.google.android.gms.common.api.Api;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ViewConfigurationCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        static float a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float b(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
        static boolean a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api34Impl {
        static int a(ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i3, i4, i5);
        }

        static int b(ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i3, i4, i5);
        }
    }

    private static int a(Resources resources, int i3, Supplier supplier, int i4) {
        int dimensionPixelSize;
        return i3 != -1 ? (i3 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i3)) < 0) ? i4 : dimensionPixelSize : ((Integer) supplier.get()).intValue();
    }

    private static int b(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int c(Resources resources, int i3, int i4) {
        if (i3 == 4194304 && i4 == 26) {
            return b(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int d(Resources resources, int i3, int i4) {
        if (i3 == 4194304 && i4 == 26) {
            return b(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float e(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.a(viewConfiguration);
    }

    public static int f(Context context, final ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.a(viewConfiguration, i3, i4, i5);
        }
        if (!i(i3, i4, i5)) {
            return Integer.MIN_VALUE;
        }
        Resources resources = context.getResources();
        int iC = c(resources, i5, i4);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iC, new Supplier() { // from class: androidx.core.view.v
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, Integer.MIN_VALUE);
    }

    public static int g(Context context, final ViewConfiguration viewConfiguration, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.b(viewConfiguration, i3, i4, i5);
        }
        if (!i(i3, i4, i5)) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Resources resources = context.getResources();
        int iD = d(resources, i5, i4);
        Objects.requireNonNull(viewConfiguration);
        return a(resources, iD, new Supplier() { // from class: androidx.core.view.w
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    public static float h(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.b(viewConfiguration);
    }

    private static boolean i(int i3, int i4, int i5) {
        InputDevice device = InputDevice.getDevice(i3);
        return (device == null || device.getMotionRange(i4, i5) == null) ? false : true;
    }

    public static boolean j(ViewConfiguration viewConfiguration, Context context) {
        return Api28Impl.a(viewConfiguration);
    }
}
