package com.google.android.libraries.places.widget.internal.photoviewer;

import android.content.Context;
import android.content.res.TypedArray;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f79134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f79135b;

    public zzx(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f79134a = context;
        this.f79135b = i3;
    }

    private final float c(int i3, int i4) {
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = this.f79134a.obtainStyledAttributes(this.f79135b, PlacesMaterialThemeAttrs);
        float dimension = typedArrayObtainStyledAttributes.getDimension(i3, r1.getResources().getDimensionPixelSize(i4));
        typedArrayObtainStyledAttributes.recycle();
        return dimension;
    }

    public final float a() {
        return c(R.styleable.f74901m, R.dimen.f74677c);
    }

    public final float b() {
        return c(R.styleable.f74900l, R.dimen.f74676b);
    }
}
