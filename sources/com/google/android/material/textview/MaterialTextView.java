package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class MaterialTextView extends AppCompatTextView {
    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    private void f(Resources.Theme theme, int i3) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i3, com.google.android.material.R.styleable.x5);
        int iJ = j(getContext(), typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.z5, com.google.android.material.R.styleable.A5);
        typedArrayObtainStyledAttributes.recycle();
        if (iJ >= 0) {
            setLineHeight(iJ);
        }
    }

    private static boolean g(Context context) {
        return MaterialAttributes.b(context, com.google.android.material.R.attr.B0, true);
    }

    private static int h(Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.B5, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(com.google.android.material.R.styleable.C5, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    private void i(AttributeSet attributeSet, int i3, int i4) {
        int iH;
        Context context = getContext();
        if (g(context)) {
            Resources.Theme theme = context.getTheme();
            if (k(context, theme, attributeSet, i3, i4) || (iH = h(theme, attributeSet, i3, i4)) == -1) {
                return;
            }
            f(theme, iH);
        }
    }

    private static int j(Context context, TypedArray typedArray, int... iArr) {
        int iD = -1;
        for (int i3 = 0; i3 < iArr.length && iD < 0; i3++) {
            iD = MaterialResources.d(context, typedArray, iArr[i3], -1);
        }
        return iD;
    }

    private static boolean k(Context context, Resources.Theme theme, AttributeSet attributeSet, int i3, int i4) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.B5, i3, i4);
        int iJ = j(context, typedArrayObtainStyledAttributes, com.google.android.material.R.styleable.D5, com.google.android.material.R.styleable.E5);
        typedArrayObtainStyledAttributes.recycle();
        return iJ != -1;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        if (g(context)) {
            f(context.getTheme(), i3);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i3) {
        super(MaterialThemeOverlay.c(context, attributeSet, i3, 0), attributeSet, i3);
        i(attributeSet, i3, 0);
    }
}
