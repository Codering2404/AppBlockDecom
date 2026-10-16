package com.google.android.libraries.places.internal;

import android.os.Bundle;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzpz extends AccessibilityDelegateCompat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ View f78443d;

    zzpz(View view) {
        this.f78443d = view;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public final boolean j(View host, int i3, Bundle bundle) {
        Intrinsics.checkNotNullParameter(host, "host");
        if (i3 != 16) {
            return super.j(host, i3, bundle);
        }
        this.f78443d.performClick();
        return true;
    }
}
