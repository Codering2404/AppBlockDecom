package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.LinearLayout;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;
import java.util.function.IntFunction;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1994d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1995f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1996g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f1997h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1998i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f1999j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int[] f2000k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f2001l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2002m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2003n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f2004o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f2005p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface DividerMode {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2010e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2011f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2012g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2013h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2014i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2015j;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(LinearLayoutCompat linearLayoutCompat, PropertyReader propertyReader) {
            if (!this.f2006a) {
                throw c.a();
            }
            propertyReader.readBoolean(this.f2007b, linearLayoutCompat.s());
            propertyReader.readInt(this.f2008c, linearLayoutCompat.getBaselineAlignedChildIndex());
            propertyReader.readGravity(this.f2009d, linearLayoutCompat.getGravity());
            propertyReader.readIntEnum(this.f2010e, linearLayoutCompat.getOrientation());
            propertyReader.readFloat(this.f2011f, linearLayoutCompat.getWeightSum());
            propertyReader.readObject(this.f2012g, linearLayoutCompat.getDividerDrawable());
            propertyReader.readInt(this.f2013h, linearLayoutCompat.getDividerPadding());
            propertyReader.readBoolean(this.f2014i, linearLayoutCompat.t());
            propertyReader.readIntFlag(this.f2015j, linearLayoutCompat.getShowDividers());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f2007b = propertyMapper.mapBoolean("baselineAligned", R.attr.baselineAligned);
            this.f2008c = propertyMapper.mapInt("baselineAlignedChildIndex", R.attr.baselineAlignedChildIndex);
            this.f2009d = propertyMapper.mapGravity("gravity", R.attr.gravity);
            this.f2010e = propertyMapper.mapIntEnum("orientation", R.attr.orientation, new IntFunction<String>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.1
                @Override // java.util.function.IntFunction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public String apply(int i3) {
                    return i3 != 0 ? i3 != 1 ? String.valueOf(i3) : "vertical" : "horizontal";
                }
            });
            this.f2011f = propertyMapper.mapFloat("weightSum", R.attr.weightSum);
            this.f2012g = propertyMapper.mapObject("divider", androidx.appcompat.R.attr.T);
            this.f2013h = propertyMapper.mapInt("dividerPadding", androidx.appcompat.R.attr.U);
            this.f2014i = propertyMapper.mapBoolean("measureWithLargestChild", androidx.appcompat.R.attr.f644g0);
            this.f2015j = propertyMapper.mapIntFlag("showDividers", androidx.appcompat.R.attr.f666r0, new IntFunction<Set<String>>() { // from class: androidx.appcompat.widget.LinearLayoutCompat.InspectionCompanion.2
                @Override // java.util.function.IntFunction
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Set apply(int i3) {
                    HashSet hashSet = new HashSet();
                    if (i3 == 0) {
                        hashSet.add(IntegrityManager.INTEGRITY_TYPE_NONE);
                    }
                    if (i3 == 1) {
                        hashSet.add("beginning");
                    }
                    if (i3 == 2) {
                        hashSet.add("middle");
                    }
                    if (i3 == 4) {
                        hashSet.add("end");
                    }
                    return hashSet;
                }
            });
            this.f2006a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i3, int i4) {
            super(i3, i4);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void A(View view, int i3, int i4, int i5, int i6) {
        view.layout(i3, i4, i5 + i3, i6 + i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredHeight()
            r1 = 1073741824(0x40000000, float:2.0)
            int r6 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.q(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r1 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r1
            int r2 = r1.height
            r4 = -1
            if (r2 != r4) goto L36
            int r8 = r1.width
            int r2 = r3.getMeasuredWidth()
            r1.width = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r4 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.width = r8
            goto L37
        L36:
            r4 = r11
        L37:
            int r0 = r0 + 1
            r11 = r4
            goto Lb
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.i(int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void j(int r10, int r11) {
        /*
            r9 = this;
            int r0 = r9.getMeasuredWidth()
            r1 = 1073741824(0x40000000, float:2.0)
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r1)
            r0 = 0
        Lb:
            if (r0 >= r10) goto L3b
            android.view.View r3 = r9.q(r0)
            int r1 = r3.getVisibility()
            r2 = 8
            if (r1 == r2) goto L36
            android.view.ViewGroup$LayoutParams r1 = r3.getLayoutParams()
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r1 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r1
            int r2 = r1.width
            r5 = -1
            if (r2 != r5) goto L36
            int r8 = r1.height
            int r2 = r3.getMeasuredHeight()
            r1.height = r2
            r5 = 0
            r7 = 0
            r2 = r9
            r6 = r11
            r2.measureChildWithMargins(r3, r4, r5, r6, r7)
            r1.height = r8
            goto L37
        L36:
            r6 = r11
        L37:
            int r0 = r0 + 1
            r11 = r6
            goto Lb
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.j(int, int):void");
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void e(Canvas canvas) {
        int right;
        int left;
        int i3;
        int virtualChildCount = getVirtualChildCount();
        boolean zB = ViewUtils.b(this);
        for (int i4 = 0; i4 < virtualChildCount; i4++) {
            View viewQ = q(i4);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i4)) {
                LayoutParams layoutParams = (LayoutParams) viewQ.getLayoutParams();
                h(canvas, zB ? viewQ.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (viewQ.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.f2002m);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            if (viewQ2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) viewQ2.getLayoutParams();
                if (zB) {
                    left = viewQ2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i3 = this.f2002m;
                    right = left - i3;
                } else {
                    right = viewQ2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (zB) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i3 = this.f2002m;
                right = left - i3;
            }
            h(canvas, right);
        }
    }

    void f(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View viewQ = q(i3);
            if (viewQ != null && viewQ.getVisibility() != 8 && r(i3)) {
                g(canvas, (viewQ.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) viewQ.getLayoutParams())).topMargin) - this.f2003n);
            }
        }
        if (r(virtualChildCount)) {
            View viewQ2 = q(virtualChildCount - 1);
            g(canvas, viewQ2 == null ? (getHeight() - getPaddingBottom()) - this.f2003n : viewQ2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) viewQ2.getLayoutParams())).bottomMargin);
        }
    }

    void g(Canvas canvas, int i3) {
        this.f2001l.setBounds(getPaddingLeft() + this.f2005p, i3, (getWidth() - getPaddingRight()) - this.f2005p, this.f2003n + i3);
        this.f2001l.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i3;
        if (this.f1992b < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i4 = this.f1992b;
        if (childCount <= i4) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i4);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.f1992b == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int bottom = this.f1993c;
        if (this.f1994d == 1 && (i3 = this.f1995f & 112) != 48) {
            if (i3 == 16) {
                bottom += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1996g) / 2;
            } else if (i3 == 80) {
                bottom = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1996g;
            }
        }
        return bottom + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1992b;
    }

    public Drawable getDividerDrawable() {
        return this.f2001l;
    }

    public int getDividerPadding() {
        return this.f2005p;
    }

    public int getDividerWidth() {
        return this.f2002m;
    }

    public int getGravity() {
        return this.f1995f;
    }

    public int getOrientation() {
        return this.f1994d;
    }

    public int getShowDividers() {
        return this.f2004o;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1997h;
    }

    void h(Canvas canvas, int i3) {
        this.f2001l.setBounds(i3, getPaddingTop() + this.f2005p, this.f2002m + i3, (getHeight() - getPaddingBottom()) - this.f2005p);
        this.f2001l.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams k() {
        int i3 = this.f1994d;
        if (i3 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i3 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams l(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    int n(View view, int i3) {
        return 0;
    }

    int o(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f2001l == null) {
            return;
        }
        if (this.f1994d == 1) {
            f(canvas);
        } else {
            e(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.appcompat.widget.LinearLayoutCompat");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (this.f1994d == 1) {
            v(i3, i4, i5, i6);
        } else {
            u(i3, i4, i5, i6);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        if (this.f1994d == 1) {
            z(i3, i4);
        } else {
            x(i3, i4);
        }
    }

    int p(View view) {
        return 0;
    }

    View q(int i3) {
        return getChildAt(i3);
    }

    protected boolean r(int i3) {
        if (i3 == 0) {
            return (this.f2004o & 1) != 0;
        }
        if (i3 == getChildCount()) {
            return (this.f2004o & 4) != 0;
        }
        if ((this.f2004o & 2) != 0) {
            for (int i4 = i3 - 1; i4 >= 0; i4--) {
                if (getChildAt(i4).getVisibility() != 8) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean s() {
        return this.f1991a;
    }

    public void setBaselineAligned(boolean z2) {
        this.f1991a = z2;
    }

    public void setBaselineAlignedChildIndex(int i3) {
        if (i3 >= 0 && i3 < getChildCount()) {
            this.f1992b = i3;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.f2001l) {
            return;
        }
        this.f2001l = drawable;
        if (drawable != null) {
            this.f2002m = drawable.getIntrinsicWidth();
            this.f2003n = drawable.getIntrinsicHeight();
        } else {
            this.f2002m = 0;
            this.f2003n = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i3) {
        this.f2005p = i3;
    }

    public void setGravity(int i3) {
        if (this.f1995f != i3) {
            if ((8388615 & i3) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            this.f1995f = i3;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i3) {
        int i4 = i3 & 8388615;
        int i5 = this.f1995f;
        if ((8388615 & i5) != i4) {
            this.f1995f = i4 | ((-8388616) & i5);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z2) {
        this.f1998i = z2;
    }

    public void setOrientation(int i3) {
        if (this.f1994d != i3) {
            this.f1994d = i3;
            requestLayout();
        }
    }

    public void setShowDividers(int i3) {
        if (i3 != this.f2004o) {
            requestLayout();
        }
        this.f2004o = i3;
    }

    public void setVerticalGravity(int i3) {
        int i4 = i3 & 112;
        int i5 = this.f1995f;
        if ((i5 & 112) != i4) {
            this.f1995f = i4 | (i5 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f3) {
        this.f1997h = Math.max(0.0f, f3);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean t() {
        return this.f1998i;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0105  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void u(int r22, int r23, int r24, int r25) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.u(int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void v(int r12, int r13, int r14, int r15) {
        /*
            r11 = this;
            int r0 = r11.getPaddingLeft()
            int r14 = r14 - r12
            int r12 = r11.getPaddingRight()
            int r12 = r14 - r12
            int r14 = r14 - r0
            int r1 = r11.getPaddingRight()
            int r14 = r14 - r1
            int r1 = r11.getVirtualChildCount()
            int r2 = r11.f1995f
            r3 = r2 & 112(0x70, float:1.57E-43)
            r4 = 8388615(0x800007, float:1.1754953E-38)
            r2 = r2 & r4
            r4 = 16
            if (r3 == r4) goto L35
            r4 = 80
            if (r3 == r4) goto L2a
            int r13 = r11.getPaddingTop()
            goto L41
        L2a:
            int r3 = r11.getPaddingTop()
            int r3 = r3 + r15
            int r3 = r3 - r13
            int r13 = r11.f1996g
            int r13 = r3 - r13
            goto L41
        L35:
            int r3 = r11.getPaddingTop()
            int r15 = r15 - r13
            int r13 = r11.f1996g
            int r15 = r15 - r13
            int r15 = r15 / 2
            int r13 = r3 + r15
        L41:
            r15 = 0
        L42:
            if (r15 >= r1) goto Lb9
            android.view.View r4 = r11.q(r15)
            r9 = 1
            if (r4 != 0) goto L52
            int r3 = r11.y(r15)
            int r13 = r13 + r3
        L50:
            r3 = r11
            goto Lb7
        L52:
            int r3 = r4.getVisibility()
            r5 = 8
            if (r3 == r5) goto L50
            int r7 = r4.getMeasuredWidth()
            int r8 = r4.getMeasuredHeight()
            android.view.ViewGroup$LayoutParams r3 = r4.getLayoutParams()
            r10 = r3
            androidx.appcompat.widget.LinearLayoutCompat$LayoutParams r10 = (androidx.appcompat.widget.LinearLayoutCompat.LayoutParams) r10
            int r3 = r10.gravity
            if (r3 >= 0) goto L6e
            r3 = r2
        L6e:
            int r5 = r11.getLayoutDirection()
            int r3 = androidx.core.view.GravityCompat.b(r3, r5)
            r3 = r3 & 7
            if (r3 == r9) goto L88
            r5 = 5
            if (r3 == r5) goto L82
            int r3 = r10.leftMargin
            int r3 = r3 + r0
        L80:
            r5 = r3
            goto L93
        L82:
            int r3 = r12 - r7
            int r5 = r10.rightMargin
        L86:
            int r3 = r3 - r5
            goto L80
        L88:
            int r3 = r14 - r7
            int r3 = r3 / 2
            int r3 = r3 + r0
            int r5 = r10.leftMargin
            int r3 = r3 + r5
            int r5 = r10.rightMargin
            goto L86
        L93:
            boolean r3 = r11.r(r15)
            if (r3 == 0) goto L9c
            int r3 = r11.f2003n
            int r13 = r13 + r3
        L9c:
            int r3 = r10.topMargin
            int r13 = r13 + r3
            int r3 = r11.o(r4)
            int r6 = r13 + r3
            r3 = r11
            r3.A(r4, r5, r6, r7, r8)
            int r5 = r10.bottomMargin
            int r8 = r8 + r5
            int r5 = r11.p(r4)
            int r8 = r8 + r5
            int r13 = r13 + r8
            int r4 = r11.n(r4, r15)
            int r15 = r15 + r4
        Lb7:
            int r15 = r15 + r9
            goto L42
        Lb9:
            r3 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.v(int, int, int, int):void");
    }

    void w(View view, int i3, int i4, int i5, int i6, int i7) {
        measureChildWithMargins(view, i4, i5, i6, i7);
    }

    /* JADX WARN: Removed duplicated region for block: B:203:0x0461  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void x(int r39, int r40) {
        /*
            Method dump skipped, instruction units count: 1294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.x(int, int):void");
    }

    int y(int i3) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void z(int r28, int r29) {
        /*
            Method dump skipped, instruction units count: 879
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.LinearLayoutCompat.z(int, int):void");
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1991a = true;
        this.f1992b = -1;
        this.f1993c = 0;
        this.f1995f = 8388659;
        int[] iArr = androidx.appcompat.R.styleable.f847k1;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        int iK = tintTypedArrayV.k(androidx.appcompat.R.styleable.f855m1, -1);
        if (iK >= 0) {
            setOrientation(iK);
        }
        int iK2 = tintTypedArrayV.k(androidx.appcompat.R.styleable.f851l1, -1);
        if (iK2 >= 0) {
            setGravity(iK2);
        }
        boolean zA = tintTypedArrayV.a(androidx.appcompat.R.styleable.f859n1, true);
        if (!zA) {
            setBaselineAligned(zA);
        }
        this.f1997h = tintTypedArrayV.i(androidx.appcompat.R.styleable.f867p1, -1.0f);
        this.f1992b = tintTypedArrayV.k(androidx.appcompat.R.styleable.f863o1, -1);
        this.f1998i = tintTypedArrayV.a(androidx.appcompat.R.styleable.f878s1, false);
        setDividerDrawable(tintTypedArrayV.g(androidx.appcompat.R.styleable.f871q1));
        this.f2004o = tintTypedArrayV.k(androidx.appcompat.R.styleable.f881t1, 0);
        this.f2005p = tintTypedArrayV.f(androidx.appcompat.R.styleable.f875r1, 0);
        tintTypedArrayV.x();
    }
}
