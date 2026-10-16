package com.google.android.material.color;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class ThemeUtils {
    public static void a(Context context, int i3) {
        Resources.Theme themeB;
        context.getTheme().applyStyle(i3, true);
        if (!(context instanceof Activity) || (themeB = b((Activity) context)) == null) {
            return;
        }
        themeB.applyStyle(i3, true);
    }

    private static Resources.Theme b(Activity activity) {
        View viewPeekDecorView;
        Context context;
        Window window = activity.getWindow();
        if (window == null || (viewPeekDecorView = window.peekDecorView()) == null || (context = viewPeekDecorView.getContext()) == null) {
            return null;
        }
        return context.getTheme();
    }
}
