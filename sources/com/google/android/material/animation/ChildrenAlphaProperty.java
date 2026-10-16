package com.google.android.material.animation;

import android.util.Property;
import android.view.ViewGroup;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ChildrenAlphaProperty extends Property<ViewGroup, Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Property f79855a = new ChildrenAlphaProperty("childrenAlpha");

    private ChildrenAlphaProperty(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(ViewGroup viewGroup) {
        Float f3 = (Float) viewGroup.getTag(R.id.S);
        return f3 != null ? f3 : Float.valueOf(1.0f);
    }

    @Override // android.util.Property
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(ViewGroup viewGroup, Float f3) {
        float fFloatValue = f3.floatValue();
        viewGroup.setTag(R.id.S, f3);
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            viewGroup.getChildAt(i3).setAlpha(fFloatValue);
        }
    }
}
