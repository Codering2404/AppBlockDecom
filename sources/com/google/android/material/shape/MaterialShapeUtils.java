package com.google.android.material.shape;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialShapeUtils {
    static CornerTreatment a(int i3) {
        return i3 != 0 ? i3 != 1 ? b() : new CutCornerTreatment() : new RoundedCornerTreatment();
    }

    static CornerTreatment b() {
        return new RoundedCornerTreatment();
    }

    static EdgeTreatment c() {
        return new EdgeTreatment();
    }

    public static void d(View view, float f3) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            ((MaterialShapeDrawable) background).Z(f3);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof MaterialShapeDrawable) {
            f(view, (MaterialShapeDrawable) background);
        }
    }

    public static void f(View view, MaterialShapeDrawable materialShapeDrawable) {
        if (materialShapeDrawable.R()) {
            materialShapeDrawable.d0(ViewUtils.m(view));
        }
    }
}
