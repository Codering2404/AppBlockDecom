package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.graphics.Rect;
import android.media.AudioManager;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzbiq;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@ParametersAreNonnullByDefault
public class zzx extends zzv {
    static final /* synthetic */ WindowInsets m(Activity activity, View view, WindowInsets windowInsets) {
        if (com.google.android.gms.ads.internal.zzt.l().zzo().zzu() == null) {
            DisplayCutout displayCutout = windowInsets.getDisplayCutout();
            String strConcat = "";
            if (displayCutout != null) {
                zzg zzgVarZzo = com.google.android.gms.ads.internal.zzt.l().zzo();
                for (Rect rect : displayCutout.getBoundingRects()) {
                    String str = String.format(Locale.US, "%d,%d,%d,%d", Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
                    if (!TextUtils.isEmpty(strConcat)) {
                        strConcat = strConcat.concat("|");
                    }
                    strConcat = strConcat.concat(str);
                }
                zzgVarZzo.zzv(strConcat);
            } else {
                com.google.android.gms.ads.internal.zzt.l().zzo().zzv("");
            }
        }
        n(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void n(boolean z2, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i3 = attributes.layoutInDisplayCutoutMode;
        int i4 = true != z2 ? 2 : 1;
        if (i4 != i3) {
            attributes.layoutInDisplayCutoutMode = i4;
            window.setAttributes(attributes);
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final void i(final Activity activity) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzbR)).booleanValue() && com.google.android.gms.ads.internal.zzt.l().zzo().zzu() == null && !activity.isInMultiWindowMode()) {
            n(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener(this) { // from class: com.google.android.gms.ads.internal.util.zzw
                @Override // android.view.View.OnApplyWindowInsetsListener
                public final /* synthetic */ WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return zzx.m(activity, view, windowInsets);
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.util.zzz
    public final int j(AudioManager audioManager) {
        return audioManager.getStreamMinVolume(3);
    }
}
