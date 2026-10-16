package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.api.Api;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.4";
    private static SharedValues sSharedValues;
    SparseArray<View> mChildrenByIds;
    private ArrayList<ConstraintHelper> mConstraintHelpers;
    protected ConstraintLayoutStates mConstraintLayoutSpec;
    private ConstraintSet mConstraintSet;
    private int mConstraintSetId;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds;
    protected boolean mDirtyHierarchy;
    private int mLastMeasureHeight;
    int mLastMeasureHeightMode;
    int mLastMeasureHeightSize;
    private int mLastMeasureWidth;
    int mLastMeasureWidthMode;
    int mLastMeasureWidthSize;
    protected ConstraintWidgetContainer mLayoutWidget;
    private int mMaxHeight;
    private int mMaxWidth;
    Measurer mMeasurer;
    private Metrics mMetrics;
    private int mMinHeight;
    private int mMinWidth;
    private int mOnMeasureHeightMeasureSpec;
    private int mOnMeasureWidthMeasureSpec;
    private int mOptimizationLevel;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget;

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f33105a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f33105a = iArr;
            try {
                iArr[ConstraintWidget.DimensionBehaviour.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33105a[ConstraintWidget.DimensionBehaviour.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33105a[ConstraintWidget.DimensionBehaviour.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33105a[ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Measurer implements BasicMeasure.Measurer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        ConstraintLayout f33156a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f33157b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f33158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f33159d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f33160e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f33161f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f33162g;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f33156a = constraintLayout;
        }

        private boolean d(int i3, int i4, int i5) {
            if (i3 == i4) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i3);
            View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i4);
            int size = View.MeasureSpec.getSize(i4);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i5 == size;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void a() {
            int childCount = this.f33156a.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = this.f33156a.getChildAt(i3);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).a(this.f33156a);
                }
            }
            int size = this.f33156a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i4 = 0; i4 < size; i4++) {
                    ((ConstraintHelper) this.f33156a.mConstraintHelpers.get(i4)).s(this.f33156a);
                }
            }
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void b(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int i3;
            if (constraintWidget == null) {
                return;
            }
            if (constraintWidget.Z() == 8 && !constraintWidget.n0()) {
                measure.f32414e = 0;
                measure.f32415f = 0;
                measure.f32416g = 0;
                return;
            }
            if (constraintWidget.N() == null) {
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure.f32410a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.f32411b;
            int i4 = measure.f32412c;
            int i5 = measure.f32413d;
            int i6 = this.f33157b + this.f33158c;
            int i7 = this.f33159d;
            View view = (View) constraintWidget.u();
            int[] iArr = AnonymousClass1.f33105a;
            int i8 = iArr[dimensionBehaviour.ordinal()];
            if (i8 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else if (i8 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f33161f, i7, -2);
            } else if (i8 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f33161f, i7 + constraintWidget.D(), -1);
            } else if (i8 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f33161f, i7, -2);
                boolean z2 = constraintWidget.f32315w == 1;
                int i9 = measure.f32419j;
                if (i9 == BasicMeasure.Measure.f32408l || i9 == BasicMeasure.Measure.f32409m) {
                    boolean z3 = view.getMeasuredHeight() == constraintWidget.z();
                    if (measure.f32419j == BasicMeasure.Measure.f32409m || !z2 || ((z2 && z3) || (view instanceof Placeholder) || constraintWidget.r0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(constraintWidget.a0(), 1073741824);
                    }
                }
            }
            int i10 = iArr[dimensionBehaviour2.ordinal()];
            if (i10 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else if (i10 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f33162g, i6, -2);
            } else if (i10 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f33162g, i6 + constraintWidget.Y(), -1);
            } else if (i10 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f33162g, i6, -2);
                boolean z4 = constraintWidget.f32317x == 1;
                int i11 = measure.f32419j;
                if (i11 == BasicMeasure.Measure.f32408l || i11 == BasicMeasure.Measure.f32409m) {
                    boolean z5 = view.getMeasuredWidth() == constraintWidget.a0();
                    if (measure.f32419j == BasicMeasure.Measure.f32409m || !z4 || ((z4 && z5) || (view instanceof Placeholder) || constraintWidget.s0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(constraintWidget.z(), 1073741824);
                    }
                }
            }
            ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.N();
            if (constraintWidgetContainer != null && Optimizer.b(ConstraintLayout.this.mOptimizationLevel, Function.MAX_NARGS) && view.getMeasuredWidth() == constraintWidget.a0() && view.getMeasuredWidth() < constraintWidgetContainer.a0() && view.getMeasuredHeight() == constraintWidget.z() && view.getMeasuredHeight() < constraintWidgetContainer.z() && view.getBaseline() == constraintWidget.r() && !constraintWidget.q0() && d(constraintWidget.E(), iMakeMeasureSpec, constraintWidget.a0()) && d(constraintWidget.F(), iMakeMeasureSpec2, constraintWidget.z())) {
                measure.f32414e = constraintWidget.a0();
                measure.f32415f = constraintWidget.z();
                measure.f32416g = constraintWidget.r();
                return;
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            boolean z6 = dimensionBehaviour == dimensionBehaviour3;
            boolean z7 = dimensionBehaviour2 == dimensionBehaviour3;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            boolean z8 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z9 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
            boolean z10 = z6 && constraintWidget.f32282f0 > 0.0f;
            boolean z11 = z7 && constraintWidget.f32282f0 > 0.0f;
            if (view == null) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            int i12 = measure.f32419j;
            if (i12 != BasicMeasure.Measure.f32408l && i12 != BasicMeasure.Measure.f32409m && z6 && constraintWidget.f32315w == 0 && z7 && constraintWidget.f32317x == 0) {
                i3 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                if ((view instanceof VirtualLayout) && (constraintWidget instanceof androidx.constraintlayout.core.widgets.VirtualLayout)) {
                    ((VirtualLayout) view).x((androidx.constraintlayout.core.widgets.VirtualLayout) constraintWidget, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                constraintWidget.c1(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i13 = constraintWidget.f32321z;
                iMax = i13 > 0 ? Math.max(i13, measuredWidth) : measuredWidth;
                int i14 = constraintWidget.A;
                if (i14 > 0) {
                    iMax = Math.min(i14, iMax);
                }
                int i15 = constraintWidget.C;
                iMax2 = i15 > 0 ? Math.max(i15, measuredHeight) : measuredHeight;
                boolean z12 = z9;
                int i16 = constraintWidget.D;
                if (i16 > 0) {
                    iMax2 = Math.min(i16, iMax2);
                }
                if (!Optimizer.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                    if (z10 && z8) {
                        iMax = (int) ((iMax2 * constraintWidget.f32282f0) + 0.5f);
                    } else if (z11 && z12) {
                        iMax2 = (int) ((iMax / constraintWidget.f32282f0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    constraintWidget.c1(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i3 = -1;
            }
            boolean z13 = baseline != i3;
            measure.f32418i = (iMax == measure.f32412c && iMax2 == measure.f32413d) ? false : true;
            if (layoutParams.f33119g0) {
                z13 = true;
            }
            if (z13 && baseline != -1 && constraintWidget.r() != baseline) {
                measure.f32418i = true;
            }
            measure.f32414e = iMax;
            measure.f32415f = iMax2;
            measure.f32417h = z13;
            measure.f32416g = baseline;
        }

        public void c(int i3, int i4, int i5, int i6, int i7, int i8) {
            this.f33157b = i5;
            this.f33158c = i6;
            this.f33159d = i7;
            this.f33160e = i8;
            this.f33161f = i3;
            this.f33162g = i4;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mMaxHeight = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(null, 0, 0);
    }

    private final ConstraintWidget a(int i3) {
        if (i3 == 0) {
            return this.mLayoutWidget;
        }
        View viewFindViewById = this.mChildrenByIds.get(i3);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i3)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.mLayoutWidget;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((LayoutParams) viewFindViewById.getLayoutParams()).f33149v0;
    }

    private void b(AttributeSet attributeSet, int i3, int i4) {
        this.mLayoutWidget.I0(this);
        this.mLayoutWidget.e2(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.f33354n1, i3, i4);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == R.styleable.f33388x1) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R.styleable.f33391y1) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R.styleable.f33382v1) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R.styleable.f33385w1) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R.styleable.l3) {
                    this.mOptimizationLevel = typedArrayObtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R.styleable.f33327g2) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R.styleable.K1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.F(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.f2(this.mOptimizationLevel);
    }

    private void c() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void d() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i3));
            if (viewWidget != null) {
                viewWidget.x0();
            }
        }
        if (zIsInEditMode) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    a(childAt.getId()).J0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.k(this, true);
        }
        this.mLayoutWidget.C1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i6 = 0; i6 < size; i6++) {
                this.mConstraintHelpers.get(i6).v(this);
            }
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt3 = getChildAt(i7);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).b(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt4 = getChildAt(i8);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt5 = getChildAt(i9);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                LayoutParams layoutParams = (LayoutParams) childAt5.getLayoutParams();
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(zIsInEditMode, childAt5, viewWidget2, layoutParams, this.mTempMapIdToWidget);
            }
        }
    }

    private void f(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray sparseArray, int i3, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i3);
        ConstraintWidget constraintWidget2 = (ConstraintWidget) sparseArray.get(i3);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.f33119g0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
        if (type == type2) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.f33119g0 = true;
            layoutParams2.f33149v0.R0(true);
        }
        constraintWidget.q(type2).b(constraintWidget2.q(type), layoutParams.D, layoutParams.C, true);
        constraintWidget.R0(true);
        constraintWidget.q(ConstraintAnchor.Type.TOP).q();
        constraintWidget.q(ConstraintAnchor.Type.BOTTOM).q();
    }

    private boolean g() {
        int childCount = getChildCount();
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (getChildAt(i3).isLayoutRequested()) {
                z2 = true;
                break;
            }
            i3++;
        }
        if (z2) {
            d();
        }
        return z2;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void applyConstraintsFromLayoutParams(boolean r15, android.view.View r16, androidx.constraintlayout.core.widgets.ConstraintWidget r17, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r18, android.util.SparseArray<androidx.constraintlayout.core.widgets.ConstraintWidget> r19) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.applyConstraintsFromLayoutParams(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i3 = 0; i3 < size; i3++) {
                this.mConstraintHelpers.get(i3).t(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i5 = Integer.parseInt(strArrSplit[0]);
                        int i6 = Integer.parseInt(strArrSplit[1]);
                        int i7 = Integer.parseInt(strArrSplit[2]);
                        int i8 = (int) ((i5 / 1080.0f) * width);
                        int i9 = (int) ((i6 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f3 = i8;
                        float f4 = i9;
                        float f5 = i8 + ((int) ((i7 / 1080.0f) * width));
                        canvas.drawLine(f3, f4, f5, f4, paint);
                        float f6 = i9 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f5, f4, f5, f6, paint);
                        canvas.drawLine(f5, f6, f3, f6, paint);
                        canvas.drawLine(f3, f6, f3, f4, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f3, f4, f5, f6, paint);
                        canvas.drawLine(f3, f6, f5, f4, paint);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.Q1(metrics);
    }

    @Override // android.view.View
    public void forceLayout() {
        c();
        super.forceLayout();
    }

    public Object getDesignInformation(int i3, Object obj) {
        if (i3 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> map = this.mDesignIds;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.S1();
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        if (this.mLayoutWidget.f32299o == null) {
            int id2 = getId();
            if (id2 != -1) {
                this.mLayoutWidget.f32299o = getContext().getResources().getResourceEntryName(id2);
            } else {
                this.mLayoutWidget.f32299o = "parent";
            }
        }
        if (this.mLayoutWidget.v() == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.mLayoutWidget;
            constraintWidgetContainer.J0(constraintWidgetContainer.f32299o);
            Log.v(TAG, " setDebugName " + this.mLayoutWidget.v());
        }
        ArrayList arrayListZ1 = this.mLayoutWidget.z1();
        int size = arrayListZ1.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayListZ1.get(i3);
            i3++;
            ConstraintWidget constraintWidget = (ConstraintWidget) obj;
            View view = (View) constraintWidget.u();
            if (view != null) {
                if (constraintWidget.f32299o == null && (id = view.getId()) != -1) {
                    constraintWidget.f32299o = getContext().getResources().getResourceEntryName(id);
                }
                if (constraintWidget.v() == null) {
                    constraintWidget.J0(constraintWidget.f32299o);
                    Log.v(TAG, " setDebugName " + constraintWidget.v());
                }
            }
        }
        this.mLayoutWidget.R(sb);
        return sb.toString();
    }

    public View getViewById(int i3) {
        return this.mChildrenByIds.get(i3);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f33149v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f33149v0;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isRtl() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void loadLayoutDescription(int i3) {
        if (i3 == 0) {
            this.mConstraintLayoutSpec = null;
            return;
        }
        try {
            this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i3);
        } catch (Resources.NotFoundException unused) {
            this.mConstraintLayoutSpec = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f33149v0;
            if ((childAt.getVisibility() != 8 || layoutParams.f33121h0 || layoutParams.f33123i0 || layoutParams.f33127k0 || zIsInEditMode) && !layoutParams.f33125j0) {
                int iB0 = constraintWidget.b0();
                int iC0 = constraintWidget.c0();
                int iA0 = constraintWidget.a0() + iB0;
                int iZ = constraintWidget.z() + iC0;
                childAt.layout(iB0, iC0, iA0, iZ);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iB0, iC0, iA0, iZ);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i8 = 0; i8 < size; i8++) {
                this.mConstraintHelpers.get(i8).r(this);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.mOnMeasureWidthMeasureSpec == i3) {
            int i5 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i6 = 0;
            while (true) {
                if (i6 >= childCount) {
                    break;
                }
                if (getChildAt(i6).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                }
                i6++;
            }
        }
        this.mOnMeasureWidthMeasureSpec = i3;
        this.mOnMeasureHeightMeasureSpec = i4;
        this.mLayoutWidget.h2(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (g()) {
                this.mLayoutWidget.j2();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i3, i4);
        resolveMeasuredDimension(i3, i4, this.mLayoutWidget.a0(), this.mLayoutWidget.z(), this.mLayoutWidget.Z1(), this.mLayoutWidget.X1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.Guideline guideline = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.f33149v0 = guideline;
            layoutParams.f33121h0 = true;
            guideline.H1(layoutParams.Z);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.w();
            ((LayoutParams) view.getLayoutParams()).f33123i0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.B1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    protected void parseLayoutDescription(int i3) {
        this.mConstraintLayoutSpec = new ConstraintLayoutStates(getContext(), this, i3);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        c();
        super.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveMeasuredDimension(int i3, int i4, int i5, int i6, boolean z2, boolean z3) {
        Measurer measurer = this.mMeasurer;
        int i7 = measurer.f33160e;
        int iResolveSizeAndState = View.resolveSizeAndState(i5 + measurer.f33159d, i3, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i6 + i7, i4, 0) & 16777215;
        int iMin = Math.min(this.mMaxWidth, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.mMaxHeight, iResolveSizeAndState2);
        if (z2) {
            iMin |= 16777216;
        }
        if (z3) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.mLastMeasureWidth = iMin;
        this.mLastMeasureHeight = iMin2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i3, int i4, int i5) {
        int i6;
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i7 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i4, i5, iMax, iMax2, paddingWidth, i7);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 > 0 || iMax4 > 0) {
            if (isRtl()) {
                i6 = iMax4;
            }
            int i8 = size - paddingWidth;
            int i9 = size2 - i7;
            setSelfDimensionBehaviour(constraintWidgetContainer, mode, i8, mode2, i9);
            constraintWidgetContainer.a2(i3, mode, i8, mode2, i9, this.mLastMeasureWidth, this.mLastMeasureHeight, i6, iMax);
        }
        iMax3 = Math.max(0, getPaddingLeft());
        i6 = iMax3;
        int i82 = size - paddingWidth;
        int i92 = size2 - i7;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i82, mode2, i92);
        constraintWidgetContainer.a2(i3, mode, i82, mode2, i92, this.mLastMeasureWidth, this.mLastMeasureHeight, i6, iMax);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i3, Object obj, Object obj2) {
        if (i3 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.mDesignIds.put(strSubstring, (Integer) obj2);
        }
    }

    @Override // android.view.View
    public void setId(int i3) {
        this.mChildrenByIds.remove(getId());
        super.setId(i3);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i3) {
        if (i3 == this.mMaxHeight) {
            return;
        }
        this.mMaxHeight = i3;
        requestLayout();
    }

    public void setMaxWidth(int i3) {
        if (i3 == this.mMaxWidth) {
            return;
        }
        this.mMaxWidth = i3;
        requestLayout();
    }

    public void setMinHeight(int i3) {
        if (i3 == this.mMinHeight) {
            return;
        }
        this.mMinHeight = i3;
        requestLayout();
    }

    public void setMinWidth(int i3) {
        if (i3 == this.mMinWidth) {
            return;
        }
        this.mMinWidth = i3;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.c(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i3) {
        this.mOptimizationLevel = i3;
        this.mLayoutWidget.f2(i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour) = 
      (r2v3 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
      (r2v0 androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour)
     binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$Measurer r0 = r7.mMeasurer
            int r1 = r0.f33160e
            int r0 = r0.f33159d
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r6) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r5
            goto L38
        L1a:
            int r9 = r7.mMaxWidth
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r5, r10)
            goto L38
        L2e:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r9 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.mMinWidth
            int r10 = java.lang.Math.max(r5, r10)
        L38:
            if (r11 == r6) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r5
            goto L5d
        L40:
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r5, r11)
            goto L5d
        L53:
            androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r2 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.mMinHeight
            int r12 = java.lang.Math.max(r5, r11)
        L5d:
            int r11 = r8.a0()
            if (r10 != r11) goto L69
            int r11 = r8.z()
            if (r12 == r11) goto L6c
        L69:
            r8.W1()
        L6c:
            r8.t1(r5)
            r8.u1(r5)
            int r11 = r7.mMaxWidth
            int r11 = r11 - r0
            r8.e1(r11)
            int r11 = r7.mMaxHeight
            int r11 = r11 - r1
            r8.d1(r11)
            r8.h1(r5)
            r8.g1(r5)
            r8.W0(r9)
            r8.r1(r10)
            r8.n1(r2)
            r8.S0(r12)
            int r9 = r7.mMinWidth
            int r9 = r9 - r0
            r8.h1(r9)
            int r9 = r7.mMinHeight
            int r9 = r9 - r1
            r8.g1(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.setSelfDimensionBehaviour(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int, int):void");
    }

    public void setState(int i3, int i4, int i5) {
        ConstraintLayoutStates constraintLayoutStates = this.mConstraintLayoutSpec;
        if (constraintLayoutStates != null) {
            constraintLayoutStates.d(i3, i4, i5);
        }
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mMaxHeight = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mChildrenByIds = new SparseArray<>();
        this.mConstraintHelpers = new ArrayList<>(4);
        this.mLayoutWidget = new ConstraintWidgetContainer();
        this.mMinWidth = 0;
        this.mMinHeight = 0;
        this.mMaxWidth = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mMaxHeight = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.mDirtyHierarchy = true;
        this.mOptimizationLevel = 257;
        this.mConstraintSet = null;
        this.mConstraintLayoutSpec = null;
        this.mConstraintSetId = -1;
        this.mDesignIds = new HashMap<>();
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
        this.mTempMapIdToWidget = new SparseArray<>();
        this.mMeasurer = new Measurer(this);
        this.mOnMeasureWidthMeasureSpec = 0;
        this.mOnMeasureHeightMeasureSpec = 0;
        b(attributeSet, i3, 0);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        boolean E;
        boolean F;
        public float G;
        public float H;
        public String I;
        float J;
        int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f33106a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f33107a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f33108b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f33109b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f33110c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f33111c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f33112d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f33113d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f33114e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        boolean f33115e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f33116f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        boolean f33117f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f33118g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        boolean f33119g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f33120h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        boolean f33121h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f33122i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        boolean f33123i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f33124j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        boolean f33125j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f33126k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        boolean f33127k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f33128l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        int f33129l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f33130m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        int f33131m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f33132n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        int f33133n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f33134o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        int f33135o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f33136p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        int f33137p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f33138q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        int f33139q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f33140r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        float f33141r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f33142s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        int f33143s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f33144t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        int f33145t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f33146u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        float f33147u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f33148v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        ConstraintWidget f33149v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f33150w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f33151w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f33152x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f33153y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f33154z;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Table {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f33155a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f33155a = sparseIntArray;
                sparseIntArray.append(R.styleable.W2, 64);
                sparseIntArray.append(R.styleable.z2, 65);
                sparseIntArray.append(R.styleable.I2, 8);
                sparseIntArray.append(R.styleable.J2, 9);
                sparseIntArray.append(R.styleable.L2, 10);
                sparseIntArray.append(R.styleable.M2, 11);
                sparseIntArray.append(R.styleable.S2, 12);
                sparseIntArray.append(R.styleable.R2, 13);
                sparseIntArray.append(R.styleable.f33363p2, 14);
                sparseIntArray.append(R.styleable.f33359o2, 15);
                sparseIntArray.append(R.styleable.f33343k2, 16);
                sparseIntArray.append(R.styleable.f33351m2, 52);
                sparseIntArray.append(R.styleable.f33347l2, 53);
                sparseIntArray.append(R.styleable.f33367q2, 2);
                sparseIntArray.append(R.styleable.s2, 3);
                sparseIntArray.append(R.styleable.r2, 4);
                sparseIntArray.append(R.styleable.b3, 49);
                sparseIntArray.append(R.styleable.c3, 50);
                sparseIntArray.append(R.styleable.w2, 5);
                sparseIntArray.append(R.styleable.x2, 6);
                sparseIntArray.append(R.styleable.y2, 7);
                sparseIntArray.append(R.styleable.f33323f2, 67);
                sparseIntArray.append(R.styleable.f33358o1, 1);
                sparseIntArray.append(R.styleable.N2, 17);
                sparseIntArray.append(R.styleable.O2, 18);
                sparseIntArray.append(R.styleable.v2, 19);
                sparseIntArray.append(R.styleable.u2, 20);
                sparseIntArray.append(R.styleable.g3, 21);
                sparseIntArray.append(R.styleable.j3, 22);
                sparseIntArray.append(R.styleable.h3, 23);
                sparseIntArray.append(R.styleable.e3, 24);
                sparseIntArray.append(R.styleable.i3, 25);
                sparseIntArray.append(R.styleable.f3, 26);
                sparseIntArray.append(R.styleable.d3, 55);
                sparseIntArray.append(R.styleable.k3, 54);
                sparseIntArray.append(R.styleable.E2, 29);
                sparseIntArray.append(R.styleable.T2, 30);
                sparseIntArray.append(R.styleable.t2, 44);
                sparseIntArray.append(R.styleable.G2, 45);
                sparseIntArray.append(R.styleable.V2, 46);
                sparseIntArray.append(R.styleable.F2, 47);
                sparseIntArray.append(R.styleable.U2, 48);
                sparseIntArray.append(R.styleable.f33335i2, 27);
                sparseIntArray.append(R.styleable.f33331h2, 28);
                sparseIntArray.append(R.styleable.X2, 31);
                sparseIntArray.append(R.styleable.A2, 32);
                sparseIntArray.append(R.styleable.Z2, 33);
                sparseIntArray.append(R.styleable.Y2, 34);
                sparseIntArray.append(R.styleable.a3, 35);
                sparseIntArray.append(R.styleable.C2, 36);
                sparseIntArray.append(R.styleable.B2, 37);
                sparseIntArray.append(R.styleable.D2, 38);
                sparseIntArray.append(R.styleable.H2, 39);
                sparseIntArray.append(R.styleable.Q2, 40);
                sparseIntArray.append(R.styleable.K2, 41);
                sparseIntArray.append(R.styleable.f33355n2, 42);
                sparseIntArray.append(R.styleable.f33339j2, 43);
                sparseIntArray.append(R.styleable.P2, 51);
                sparseIntArray.append(R.styleable.m3, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f33106a = -1;
            this.f33108b = -1;
            this.f33110c = -1.0f;
            this.f33112d = true;
            this.f33114e = -1;
            this.f33116f = -1;
            this.f33118g = -1;
            this.f33120h = -1;
            this.f33122i = -1;
            this.f33124j = -1;
            this.f33126k = -1;
            this.f33128l = -1;
            this.f33130m = -1;
            this.f33132n = -1;
            this.f33134o = -1;
            this.f33136p = -1;
            this.f33138q = 0;
            this.f33140r = 0.0f;
            this.f33142s = -1;
            this.f33144t = -1;
            this.f33146u = -1;
            this.f33148v = -1;
            this.f33150w = Integer.MIN_VALUE;
            this.f33152x = Integer.MIN_VALUE;
            this.f33153y = Integer.MIN_VALUE;
            this.f33154z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f33107a0 = false;
            this.f33109b0 = false;
            this.f33111c0 = null;
            this.f33113d0 = 0;
            this.f33115e0 = true;
            this.f33117f0 = true;
            this.f33119g0 = false;
            this.f33121h0 = false;
            this.f33123i0 = false;
            this.f33125j0 = false;
            this.f33127k0 = false;
            this.f33129l0 = -1;
            this.f33131m0 = -1;
            this.f33133n0 = -1;
            this.f33135o0 = -1;
            this.f33137p0 = Integer.MIN_VALUE;
            this.f33139q0 = Integer.MIN_VALUE;
            this.f33141r0 = 0.5f;
            this.f33149v0 = new ConstraintWidget();
            this.f33151w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f33354n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                int i4 = Table.f33155a.get(index);
                switch (i4) {
                    case 1:
                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f33136p);
                        this.f33136p = resourceId;
                        if (resourceId == -1) {
                            this.f33136p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f33138q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33138q);
                        break;
                    case 4:
                        float f3 = typedArrayObtainStyledAttributes.getFloat(index, this.f33140r) % 360.0f;
                        this.f33140r = f3;
                        if (f3 < 0.0f) {
                            this.f33140r = (360.0f - f3) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f33106a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f33106a);
                        break;
                    case 6:
                        this.f33108b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f33108b);
                        break;
                    case 7:
                        this.f33110c = typedArrayObtainStyledAttributes.getFloat(index, this.f33110c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33114e);
                        this.f33114e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f33114e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33116f);
                        this.f33116f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f33116f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33118g);
                        this.f33118g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f33118g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33120h);
                        this.f33120h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f33120h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33122i);
                        this.f33122i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f33122i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33124j);
                        this.f33124j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f33124j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33126k);
                        this.f33126k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f33126k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33128l);
                        this.f33128l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f33128l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33130m);
                        this.f33130m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f33130m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33142s);
                        this.f33142s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f33142s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33144t);
                        this.f33144t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f33144t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33146u);
                        this.f33146u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f33146u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33148v);
                        this.f33148v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f33148v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f33150w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33150w);
                        break;
                    case 22:
                        this.f33152x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33152x);
                        break;
                    case 23:
                        this.f33153y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33153y);
                        break;
                    case 24:
                        this.f33154z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f33154z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.f33107a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f33107a0);
                        break;
                    case 28:
                        this.f33109b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f33109b0);
                        break;
                    case 29:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 30:
                        this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case 31:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.P = i5;
                        if (i5 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i6 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.Q = i6;
                        if (i6 == 1) {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                            }
                        }
                        break;
                    case 35:
                        this.V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case 36:
                        try {
                            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i4) {
                            case 44:
                                ConstraintSet.K(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 50:
                                this.Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case 51:
                                this.f33111c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33132n);
                                this.f33132n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f33132n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f33134o);
                                this.f33134o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f33134o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i4) {
                                    case 64:
                                        ConstraintSet.I(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        ConstraintSet.I(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f33113d0 = typedArrayObtainStyledAttributes.getInt(index, this.f33113d0);
                                        break;
                                    case 67:
                                        this.f33112d = typedArrayObtainStyledAttributes.getBoolean(index, this.f33112d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            c();
        }

        public String a() {
            return this.f33111c0;
        }

        public ConstraintWidget b() {
            return this.f33149v0;
        }

        public void c() {
            this.f33121h0 = false;
            this.f33115e0 = true;
            this.f33117f0 = true;
            int i3 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i3 == -2 && this.f33107a0) {
                this.f33115e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i4 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i4 == -2 && this.f33109b0) {
                this.f33117f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.f33115e0 = false;
                if (i3 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f33107a0 = true;
                }
            }
            if (i4 == 0 || i4 == -1) {
                this.f33117f0 = false;
                if (i4 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f33109b0 = true;
                }
            }
            if (this.f33110c == -1.0f && this.f33106a == -1 && this.f33108b == -1) {
                return;
            }
            this.f33121h0 = true;
            this.f33115e0 = true;
            this.f33117f0 = true;
            if (!(this.f33149v0 instanceof androidx.constraintlayout.core.widgets.Guideline)) {
                this.f33149v0 = new androidx.constraintlayout.core.widgets.Guideline();
            }
            ((androidx.constraintlayout.core.widgets.Guideline) this.f33149v0).H1(this.Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instruction units count: 259
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
            this.f33106a = -1;
            this.f33108b = -1;
            this.f33110c = -1.0f;
            this.f33112d = true;
            this.f33114e = -1;
            this.f33116f = -1;
            this.f33118g = -1;
            this.f33120h = -1;
            this.f33122i = -1;
            this.f33124j = -1;
            this.f33126k = -1;
            this.f33128l = -1;
            this.f33130m = -1;
            this.f33132n = -1;
            this.f33134o = -1;
            this.f33136p = -1;
            this.f33138q = 0;
            this.f33140r = 0.0f;
            this.f33142s = -1;
            this.f33144t = -1;
            this.f33146u = -1;
            this.f33148v = -1;
            this.f33150w = Integer.MIN_VALUE;
            this.f33152x = Integer.MIN_VALUE;
            this.f33153y = Integer.MIN_VALUE;
            this.f33154z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f33107a0 = false;
            this.f33109b0 = false;
            this.f33111c0 = null;
            this.f33113d0 = 0;
            this.f33115e0 = true;
            this.f33117f0 = true;
            this.f33119g0 = false;
            this.f33121h0 = false;
            this.f33123i0 = false;
            this.f33125j0 = false;
            this.f33127k0 = false;
            this.f33129l0 = -1;
            this.f33131m0 = -1;
            this.f33133n0 = -1;
            this.f33135o0 = -1;
            this.f33137p0 = Integer.MIN_VALUE;
            this.f33139q0 = Integer.MIN_VALUE;
            this.f33141r0 = 0.5f;
            this.f33149v0 = new ConstraintWidget();
            this.f33151w0 = false;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f33106a = -1;
            this.f33108b = -1;
            this.f33110c = -1.0f;
            this.f33112d = true;
            this.f33114e = -1;
            this.f33116f = -1;
            this.f33118g = -1;
            this.f33120h = -1;
            this.f33122i = -1;
            this.f33124j = -1;
            this.f33126k = -1;
            this.f33128l = -1;
            this.f33130m = -1;
            this.f33132n = -1;
            this.f33134o = -1;
            this.f33136p = -1;
            this.f33138q = 0;
            this.f33140r = 0.0f;
            this.f33142s = -1;
            this.f33144t = -1;
            this.f33146u = -1;
            this.f33148v = -1;
            this.f33150w = Integer.MIN_VALUE;
            this.f33152x = Integer.MIN_VALUE;
            this.f33153y = Integer.MIN_VALUE;
            this.f33154z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f33107a0 = false;
            this.f33109b0 = false;
            this.f33111c0 = null;
            this.f33113d0 = 0;
            this.f33115e0 = true;
            this.f33117f0 = true;
            this.f33119g0 = false;
            this.f33121h0 = false;
            this.f33123i0 = false;
            this.f33125j0 = false;
            this.f33127k0 = false;
            this.f33129l0 = -1;
            this.f33131m0 = -1;
            this.f33133n0 = -1;
            this.f33135o0 = -1;
            this.f33137p0 = Integer.MIN_VALUE;
            this.f33139q0 = Integer.MIN_VALUE;
            this.f33141r0 = 0.5f;
            this.f33149v0 = new ConstraintWidget();
            this.f33151w0 = false;
        }
    }
}
