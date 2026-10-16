package com.applovin.impl;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class x2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x2 f64786g = new x2(-1, -16777216, 0, 0, -1, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f64787a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f64789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f64790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f64791e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Typeface f64792f;

    public x2(int i3, int i4, int i5, int i6, int i7, Typeface typeface) {
        this.f64787a = i3;
        this.f64788b = i4;
        this.f64789c = i5;
        this.f64790d = i6;
        this.f64791e = i7;
        this.f64792f = typeface;
    }

    public static x2 a(CaptioningManager.CaptionStyle captionStyle) {
        return xp.f65027a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static x2 b(CaptioningManager.CaptionStyle captionStyle) {
        return new x2(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static x2 c(CaptioningManager.CaptionStyle captionStyle) {
        return new x2(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f64786g.f64787a, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f64786g.f64788b, captionStyle.hasWindowColor() ? captionStyle.windowColor : f64786g.f64789c, captionStyle.hasEdgeType() ? captionStyle.edgeType : f64786g.f64790d, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f64786g.f64791e, captionStyle.getTypeface());
    }
}
