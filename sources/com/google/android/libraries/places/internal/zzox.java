package com.google.android.libraries.places.internal;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzox {
    public static final zzapa a(Context context, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        zzaoz zzaozVarL = zzapa.L();
        zzaozVarL.y(zzoy.b(context, i3));
        zzaozVarL.z(zzoy.f(context, i3));
        boolean z2 = true;
        if (!zzoy.c(context, i3) && !zzoy.e(context, i3)) {
            z2 = false;
        }
        zzaozVarL.A(z2);
        zzaozVarL.B(zzoy.d(context, i3));
        zzaozVarL.D(zzoy.a(context, i3));
        zzbdq zzbdqVarZzG = zzaozVarL.zzG();
        Intrinsics.checkNotNullExpressionValue(zzbdqVarZzG, "build(...)");
        return (zzapa) zzbdqVarZzG;
    }
}
