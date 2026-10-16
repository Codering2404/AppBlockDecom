package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface HighlightableDescriptor<E> {
    @Nullable
    Object getElementToHighlightAtPosition(E e3, int i3, int i4, Rect rect);

    @Nullable
    View getViewAndBoundsForHighlighting(E e3, Rect rect);
}
