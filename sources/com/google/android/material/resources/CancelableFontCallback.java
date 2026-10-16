package com.google.android.material.resources;

import android.graphics.Typeface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class CancelableFontCallback extends TextAppearanceFontCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Typeface f81586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ApplyFont f81587b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f81588c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ApplyFont {
        void a(Typeface typeface);
    }

    public CancelableFontCallback(ApplyFont applyFont, Typeface typeface) {
        this.f81586a = typeface;
        this.f81587b = applyFont;
    }

    private void d(Typeface typeface) {
        if (this.f81588c) {
            return;
        }
        this.f81587b.a(typeface);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void a(int i3) {
        d(this.f81586a);
    }

    @Override // com.google.android.material.resources.TextAppearanceFontCallback
    public void b(Typeface typeface, boolean z2) {
        d(typeface);
    }

    public void c() {
        this.f81588c = true;
    }
}
