package com.facebook.stetho.inspector.elements.android;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.android.FragmentCompatUtil;
import com.facebook.stetho.inspector.elements.AbstractChainedDescriptor;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class ViewGroupDescriptor extends AbstractChainedDescriptor<ViewGroup> implements HighlightableDescriptor<ViewGroup> {
    private final Map<View, Object> mViewToElementMap = Collections.synchronizedMap(new WeakHashMap());

    private Object getElement(View view, Object obj) {
        return obj == this ? view : ((WeakReference) obj).get();
    }

    private Object getElementForView(ViewGroup viewGroup, View view) {
        Object obj = this.mViewToElementMap.get(view);
        if (obj != null) {
            Object element = getElement(view, obj);
            if (element != null && view.getParent() == viewGroup) {
                return element;
            }
            this.mViewToElementMap.remove(view);
        }
        Object objFindFragmentForView = FragmentCompatUtil.findFragmentForView(view);
        if (objFindFragmentForView == null || FragmentCompatUtil.isDialogFragment(objFindFragmentForView)) {
            this.mViewToElementMap.put(view, this);
            return view;
        }
        this.mViewToElementMap.put(view, new WeakReference(objFindFragmentForView));
        return objFindFragmentForView;
    }

    private boolean isChildVisible(View view) {
        return !(view instanceof DocumentHiddenView);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public View getViewAndBoundsForHighlighting(ViewGroup viewGroup, Rect rect) {
        return viewGroup;
    }

    @Override // com.facebook.stetho.inspector.elements.AbstractChainedDescriptor
    protected /* bridge */ /* synthetic */ void onGetChildren(ViewGroup viewGroup, Accumulator accumulator) {
        onGetChildren2(viewGroup, (Accumulator<Object>) accumulator);
    }

    @Override // com.facebook.stetho.inspector.elements.android.HighlightableDescriptor
    @Nullable
    public Object getElementToHighlightAtPosition(ViewGroup viewGroup, int i3, int i4, Rect rect) {
        View childAt;
        int childCount = viewGroup.getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                childAt = null;
                break;
            }
            childAt = viewGroup.getChildAt(childCount);
            if (isChildVisible(childAt) && childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i3, i4)) {
                    break;
                }
            }
            childCount--;
        }
        if (childAt != null) {
            return childAt;
        }
        rect.set(0, 0, viewGroup.getWidth(), viewGroup.getHeight());
        return viewGroup;
    }

    /* JADX INFO: renamed from: onGetChildren, reason: avoid collision after fix types in other method */
    protected void onGetChildren2(ViewGroup viewGroup, Accumulator<Object> accumulator) {
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (isChildVisible(childAt)) {
                accumulator.store(getElementForView(viewGroup, childAt));
            }
        }
    }
}
