package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DrawableDecoderCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f66953a = true;

    public static Drawable a(Context context, int i3, Resources.Theme theme) {
        return c(context, context, i3, theme);
    }

    public static Drawable b(Context context, Context context2, int i3) {
        return c(context, context2, i3, null);
    }

    private static Drawable c(Context context, Context context2, int i3, Resources.Theme theme) {
        try {
            if (f66953a) {
                return e(context2, i3, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e3) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e3;
            }
            return ContextCompat.getDrawable(context2, i3);
        } catch (NoClassDefFoundError unused2) {
            f66953a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i3, theme);
    }

    private static Drawable d(Context context, int i3, Resources.Theme theme) {
        return ResourcesCompat.f(context.getResources(), i3, theme);
    }

    private static Drawable e(Context context, int i3, Resources.Theme theme) {
        if (theme != null) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, theme);
            contextThemeWrapper.a(theme.getResources().getConfiguration());
            context = contextThemeWrapper;
        }
        return AppCompatResources.b(context, i3);
    }
}
