package com.google.android.libraries.places.internal;

import android.content.Context;
import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzop {
    public static final void a(final View view, final View widget, final Context context, int i3, final int i4) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(widget, "widget");
        Intrinsics.checkNotNullParameter(context, "context");
        final int i5 = 48;
        widget.post(new Runnable(context, view, i5, i4, widget) { // from class: com.google.android.libraries.places.internal.zzon

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final /* synthetic */ Context f78357a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final /* synthetic */ View f78358b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final /* synthetic */ int f78359c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final /* synthetic */ View f78360d;

            {
                this.f78359c = i4;
                this.f78360d = widget;
            }

            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                float f3 = this.f78357a.getResources().getDisplayMetrics().density;
                Rect rect = new Rect();
                View view2 = this.f78358b;
                view2.getHitRect(rect);
                float fHeight = rect.height() / f3;
                float fWidth = rect.width() / f3;
                int i6 = fWidth < 48.0f ? (int) (((48.0f - fWidth) * f3) / 2.0f) : 0;
                float f4 = this.f78359c;
                int i7 = fHeight < f4 ? (int) (((f4 - fHeight) * f3) / 2.0f) : 0;
                View view3 = this.f78360d;
                rect.set(rect.left - i6, rect.top - i7, rect.right + i6, rect.bottom + i7);
                view3.setTouchDelegate(new TouchDelegate(rect, view2));
            }
        });
    }

    public static final void b(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setAccessibilityDelegate(new zzoo());
    }
}
