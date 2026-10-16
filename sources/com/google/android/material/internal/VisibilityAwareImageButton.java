package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class VisibilityAwareImageButton extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f81317a;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f81317a = getVisibility();
    }

    public final void b(int i3, boolean z2) {
        super.setVisibility(i3);
        if (z2) {
            this.f81317a = i3;
        }
    }

    public final int getUserSetVisibility() {
        return this.f81317a;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        b(i3, true);
    }
}
