package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import com.facebook.stetho.inspector.elements.Descriptor;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class WindowDescriptor extends AbstractChainedDescriptor<Window> implements HighlightableDescriptor<Window> {
    WindowDescriptor() {
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(Window window, Accumulator accumulator) {
        onGetChildren2(window, (Accumulator<Object>) accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public Object getElementToHighlightAtPosition(Window window, int i3, int i4, Rect rect) {
        View viewPeekDecorView;
        HighlightableDescriptor highlightableDescriptor;
        Descriptor.Host host = getHost();
        if (host instanceof AndroidDescriptorHost) {
            viewPeekDecorView = window.peekDecorView();
            highlightableDescriptor = ((AndroidDescriptorHost) host).getHighlightableDescriptor(viewPeekDecorView);
        } else {
            viewPeekDecorView = null;
            highlightableDescriptor = null;
        }
        if (highlightableDescriptor == null) {
            return null;
        }
        return highlightableDescriptor.getElementToHighlightAtPosition(viewPeekDecorView, i3, i4, rect);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewAndBoundsForHighlighting(Window window, Rect rect) {
        return window.peekDecorView();
    }

    /* JADX INFO: renamed from: onGetChildren, reason: avoid collision after fix types in other method */
    protected void onGetChildren2(Window window, Accumulator<Object> accumulator) {
        View viewPeekDecorView = window.peekDecorView();
        if (viewPeekDecorView != null) {
            accumulator.store(viewPeekDecorView);
        }
    }
}
