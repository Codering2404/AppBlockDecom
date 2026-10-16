package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.res.TypedArray;
import com.google.android.libraries.places.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzos {
    public static final int a(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        zzot zzotVar = zzot.f78364c;
        int[] PlacesMaterialThemeAttrs = R.styleable.f74889a;
        Intrinsics.checkNotNullExpressionValue(PlacesMaterialThemeAttrs, "PlacesMaterialThemeAttrs");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, PlacesMaterialThemeAttrs);
        int i4 = typedArrayObtainStyledAttributes.getInt((typedArrayObtainStyledAttributes.getResources().getConfiguration().uiMode & 48) == 32 ? R.styleable.f74890b : R.styleable.f74891c, -1);
        zzot zzotVar2 = zzot.f78364c;
        if (i4 != zzotVar2.zza()) {
            zzotVar2 = zzot.f78365d;
            if (i4 != zzotVar2.zza()) {
                zzot zzotVar3 = zzot.f78366f;
                if (i4 == zzotVar3.zza()) {
                    zzotVar2 = zzotVar3;
                }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return context.getColor(zzotVar2.a());
    }
}
