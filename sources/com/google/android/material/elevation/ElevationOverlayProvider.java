package com.google.android.material.elevation;

import android.content.Context;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.MaterialAttributes;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ElevationOverlayProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f80953f = (int) Math.round(5.1000000000000005d);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f80954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f80955b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f80956c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f80957d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f80958e;

    public ElevationOverlayProvider(Context context) {
        this(MaterialAttributes.b(context, R.attr.B, false), MaterialColors.b(context, R.attr.A, 0), MaterialColors.b(context, R.attr.f79526z, 0), MaterialColors.b(context, R.attr.f79518v, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean f(int i3) {
        return ColorUtils.k(i3, 255) == this.f80957d;
    }

    public float a(float f3) {
        if (this.f80958e <= 0.0f || f3 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f3 / r0)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i3, float f3) {
        int i4;
        float fA = a(f3);
        int iAlpha = Color.alpha(i3);
        int iL = MaterialColors.l(ColorUtils.k(i3, 255), this.f80955b, fA);
        if (fA > 0.0f && (i4 = this.f80956c) != 0) {
            iL = MaterialColors.k(iL, ColorUtils.k(i4, f80953f));
        }
        return ColorUtils.k(iL, iAlpha);
    }

    public int c(int i3, float f3) {
        return (this.f80954a && f(i3)) ? b(i3, f3) : i3;
    }

    public int d(float f3) {
        return c(this.f80957d, f3);
    }

    public boolean e() {
        return this.f80954a;
    }

    public ElevationOverlayProvider(boolean z2, int i3, int i4, int i5, float f3) {
        this.f80954a = z2;
        this.f80955b = i3;
        this.f80956c = i4;
        this.f80957d = i5;
        this.f80958e = f3;
    }
}
