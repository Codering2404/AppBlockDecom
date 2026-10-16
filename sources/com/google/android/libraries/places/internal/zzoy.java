package com.google.android.libraries.places.internal;

import android.content.Context;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzoy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f78374a = R.style.f74888c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f78375b = {R.attr.f74659v, R.attr.f74653p, R.attr.f74656s, R.attr.f74651n, R.attr.f74652o, R.attr.f74657t, R.attr.f74650m, R.attr.f74646i, R.attr.f74647j, R.attr.f74648k, R.attr.f74655r, R.attr.f74649l, R.attr.f74654q, R.attr.f74645h, R.attr.f74644g, R.attr.f74642e, R.attr.f74658u, R.attr.f74643f};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f78376c = {R.attr.J, R.attr.I, R.attr.N, R.attr.M, R.attr.L, R.attr.K, R.attr.Q, R.attr.P, R.attr.O};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f78377d = {R.attr.D, R.attr.G, R.attr.F, R.attr.E, R.attr.C, R.attr.H};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f78378e = {R.attr.f74638a, R.attr.f74639b};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f78379f = {R.attr.f74660w, R.attr.f74661x, R.attr.B, R.attr.f74663z, R.attr.f74662y, R.attr.A};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int[] f78380g = {R.attr.f74641d, R.attr.f74640c};

    public static final boolean a(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78380g);
    }

    public static final boolean b(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78375b);
    }

    public static final boolean c(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78378e);
    }

    public static final boolean d(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78379f);
    }

    public static final boolean e(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78377d);
    }

    public static final boolean f(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        return g(context, i3, f78376c);
    }

    private static final boolean g(Context context, int i3, int[] iArr) {
        int i4 = f78374a;
        if (i3 == i4) {
            return false;
        }
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i4);
        ContextThemeWrapper contextThemeWrapper2 = new ContextThemeWrapper(context, i3);
        TypedValue typedValue = new TypedValue();
        TypedValue typedValue2 = new TypedValue();
        for (int i5 : iArr) {
            contextThemeWrapper.getTheme().resolveAttribute(i5, typedValue, true);
            if (!contextThemeWrapper2.getTheme().resolveAttribute(i5, typedValue2, true)) {
                return false;
            }
            if (typedValue.data != typedValue2.data) {
                return true;
            }
        }
        return false;
    }
}
