package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.view.Window;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class EdgeToEdgeUtils {
    public static void a(Window window, boolean z2, Integer num, Integer num2) {
        boolean z3 = num == null || num.intValue() == 0;
        boolean z4 = num2 == null || num2.intValue() == 0;
        if (z3 || z4) {
            int iB = MaterialColors.b(window.getContext(), R.attr.colorBackground, -16777216);
            if (z3) {
                num = Integer.valueOf(iB);
            }
            if (z4) {
                num2 = Integer.valueOf(iB);
            }
        }
        WindowCompat.b(window, !z2);
        int iC = c(window.getContext(), z2);
        int iB2 = b(window.getContext(), z2);
        window.setStatusBarColor(iC);
        window.setNavigationBarColor(iB2);
        f(window, d(iC, MaterialColors.i(num.intValue())));
        e(window, d(iB2, MaterialColors.i(num2.intValue())));
    }

    private static int b(Context context, boolean z2) {
        if (z2) {
            return 0;
        }
        return MaterialColors.b(context, R.attr.navigationBarColor, -16777216);
    }

    private static int c(Context context, boolean z2) {
        if (z2) {
            return 0;
        }
        return MaterialColors.b(context, R.attr.statusBarColor, -16777216);
    }

    private static boolean d(int i3, boolean z2) {
        if (MaterialColors.i(i3)) {
            return true;
        }
        return i3 == 0 && z2;
    }

    public static void e(Window window, boolean z2) {
        WindowCompat.a(window, window.getDecorView()).c(z2);
    }

    public static void f(Window window, boolean z2) {
        WindowCompat.a(window, window.getDecorView()).d(z2);
    }
}
