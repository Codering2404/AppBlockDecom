package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int[] f33096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f33097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Context f33098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Helper f33099d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f33100f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected String f33101g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected String f33102h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private View[] f33103i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected HashMap f33104j;

    public ConstraintHelper(Context context) {
        super(context);
        this.f33096a = new int[32];
        this.f33100f = false;
        this.f33103i = null;
        this.f33104j = new HashMap();
        this.f33098c = context;
        o(null);
    }

    private void e(String str) {
        if (str == null || str.length() == 0 || this.f33098c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iM = m(strTrim);
        if (iM != 0) {
            this.f33104j.put(Integer.valueOf(iM), strTrim);
            f(iM);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    private void f(int i3) {
        if (i3 == getId()) {
            return;
        }
        int i4 = this.f33097b + 1;
        int[] iArr = this.f33096a;
        if (i4 > iArr.length) {
            this.f33096a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f33096a;
        int i5 = this.f33097b;
        iArr2[i5] = i3;
        this.f33097b = i5 + 1;
    }

    private void g(String str) {
        if (str == null || str.length() == 0 || this.f33098c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).f33111c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    f(childAt.getId());
                }
            }
        }
    }

    private int[] k(View view, String str) {
        String[] strArrSplit = str.split(",");
        view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i3 = 0;
        for (String str2 : strArrSplit) {
            int iM = m(str2.trim());
            if (iM != 0) {
                iArr[i3] = iM;
                i3++;
            }
        }
        return i3 != strArrSplit.length ? Arrays.copyOf(iArr, i3) : iArr;
    }

    private int l(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f33098c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = constraintLayout.getChildAt(i3);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    private int m(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iL = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                iL = ((Integer) designInformation).intValue();
            }
        }
        if (iL == 0 && constraintLayout != null) {
            iL = l(constraintLayout, str);
        }
        if (iL == 0) {
            try {
                iL = R.id.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iL == 0 ? this.f33098c.getResources().getIdentifier(str, "id", this.f33098c.getPackageName()) : iL;
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f33096a, this.f33097b);
    }

    protected void h() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        i((ConstraintLayout) parent);
    }

    protected void i(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            View viewById = constraintLayout.getViewById(this.f33096a[i3]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    protected View[] n(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f33103i;
        if (viewArr == null || viewArr.length != this.f33097b) {
            this.f33103i = new View[this.f33097b];
        }
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            this.f33103i[i3] = constraintLayout.getViewById(this.f33096a[i3]);
        }
        return this.f33103i;
    }

    protected void o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.L1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f33101g = string;
                    setIds(string);
                } else if (index == R.styleable.M1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f33102h = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f33101g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f33102h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f33100f) {
            super.onMeasure(i3, i4);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        ConstraintSet.Layout layout = constraint.f33195e;
        int[] iArr = layout.f33233k0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.f33235l0;
            if (str != null) {
                if (str.length() > 0) {
                    ConstraintSet.Layout layout2 = constraint.f33195e;
                    layout2.f33233k0 = k(this, layout2.f33235l0);
                } else {
                    constraint.f33195e.f33233k0 = null;
                }
            }
        }
        if (helperWidget == null) {
            return;
        }
        helperWidget.b();
        if (constraint.f33195e.f33233k0 == null) {
            return;
        }
        int i3 = 0;
        while (true) {
            int[] iArr2 = constraint.f33195e.f33233k0;
            if (i3 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = (ConstraintWidget) sparseArray.get(iArr2[i3]);
            if (constraintWidget != null) {
                helperWidget.a(constraintWidget);
            }
            i3++;
        }
    }

    protected void setIds(String str) {
        this.f33101g = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f33097b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                e(str.substring(i3));
                return;
            } else {
                e(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    protected void setReferenceTags(String str) {
        this.f33102h = str;
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f33097b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i3);
            if (iIndexOf == -1) {
                g(str.substring(i3));
                return;
            } else {
                g(str.substring(i3, iIndexOf));
                i3 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f33101g = null;
        this.f33097b = 0;
        for (int i3 : iArr) {
            f(i3);
        }
    }

    @Override // android.view.View
    public void setTag(int i3, Object obj) {
        super.setTag(i3, obj);
        if (obj == null && this.f33101g == null) {
            f(i3);
        }
    }

    public void u(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray sparseArray) {
        helper.b();
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            helper.a((ConstraintWidget) sparseArray.get(this.f33096a[i3]));
        }
    }

    public void v(ConstraintLayout constraintLayout) {
        String str;
        int iL;
        if (isInEditMode()) {
            setIds(this.f33101g);
        }
        Helper helper = this.f33099d;
        if (helper == null) {
            return;
        }
        helper.b();
        for (int i3 = 0; i3 < this.f33097b; i3++) {
            int i4 = this.f33096a[i3];
            View viewById = constraintLayout.getViewById(i4);
            if (viewById == null && (iL = l(constraintLayout, (str = (String) this.f33104j.get(Integer.valueOf(i4))))) != 0) {
                this.f33096a[i3] = iL;
                this.f33104j.put(Integer.valueOf(iL), str);
                viewById = constraintLayout.getViewById(iL);
            }
            if (viewById != null) {
                this.f33099d.a(constraintLayout.getViewWidget(viewById));
            }
        }
        this.f33099d.c(constraintLayout.mLayoutWidget);
    }

    public void w() {
        if (this.f33099d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).f33149v0 = (ConstraintWidget) this.f33099d;
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33096a = new int[32];
        this.f33100f = false;
        this.f33103i = null;
        this.f33104j = new HashMap();
        this.f33098c = context;
        o(attributeSet);
    }

    protected void j(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    public void r(ConstraintLayout constraintLayout) {
    }

    public void s(ConstraintLayout constraintLayout) {
    }

    public void t(ConstraintLayout constraintLayout) {
    }

    public void q(ConstraintWidget constraintWidget, boolean z2) {
    }
}
