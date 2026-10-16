package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.widget.ListViewAutoScrollHelper;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class DropDownListView extends ListView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f1958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1961d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1962f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1963g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private GateKeeperDrawable f1964h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f1965i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f1966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f1967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ViewPropertyAnimatorCompat f1968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ListViewAutoScrollHelper f1969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    ResolveHoverRunnable f1970n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api21Impl {
        static void a(View view, float f3, float f4) {
            view.drawableHotspotChanged(f3, f4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static Method f1971a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Method f1972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static Method f1973c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static boolean f1974d;

        static {
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Boolean.TYPE;
                Class cls3 = Float.TYPE;
                Method declaredMethod = AbsListView.class.getDeclaredMethod("positionSelector", cls, View.class, cls2, cls3, cls3);
                f1971a = declaredMethod;
                declaredMethod.setAccessible(true);
                Method declaredMethod2 = AdapterView.class.getDeclaredMethod("setSelectedPositionInt", cls);
                f1972b = declaredMethod2;
                declaredMethod2.setAccessible(true);
                Method declaredMethod3 = AdapterView.class.getDeclaredMethod("setNextSelectedPositionInt", cls);
                f1973c = declaredMethod3;
                declaredMethod3.setAccessible(true);
                f1974d = true;
            } catch (NoSuchMethodException e3) {
                e3.printStackTrace();
            }
        }

        static boolean a() {
            return f1974d;
        }

        static void b(DropDownListView dropDownListView, int i3, View view) {
            try {
                f1971a.invoke(dropDownListView, Integer.valueOf(i3), view, Boolean.FALSE, -1, -1);
                f1972b.invoke(dropDownListView, Integer.valueOf(i3));
                f1973c.invoke(dropDownListView, Integer.valueOf(i3));
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
            } catch (InvocationTargetException e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api33Impl {
        static boolean a(AbsListView absListView) {
            return absListView.isSelectedChildViewEnabled();
        }

        static void b(AbsListView absListView, boolean z2) {
            absListView.setSelectedChildViewEnabled(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class GateKeeperDrawable extends DrawableWrapperCompat {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f1975b;

        GateKeeperDrawable(Drawable drawable) {
            super(drawable);
            this.f1975b = true;
        }

        void c(boolean z2) {
            this.f1975b = z2;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1975b) {
                super.draw(canvas);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspot(float f3, float f4) {
            if (this.f1975b) {
                super.setHotspot(f3, f4);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i3, int i4, int i5, int i6) {
            if (this.f1975b) {
                super.setHotspotBounds(i3, i4, i5, i6);
            }
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1975b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // androidx.appcompat.graphics.drawable.DrawableWrapperCompat, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z2, boolean z3) {
            if (this.f1975b) {
                return super.setVisible(z2, z3);
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PreApi33Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Field f1976a;

        static {
            Field declaredField = null;
            try {
                declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                e3.printStackTrace();
            }
            f1976a = declaredField;
        }

        static boolean a(AbsListView absListView) {
            Field field = f1976a;
            if (field == null) {
                return false;
            }
            try {
                return field.getBoolean(absListView);
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return false;
            }
        }

        static void b(AbsListView absListView, boolean z2) {
            Field field = f1976a;
            if (field != null) {
                try {
                    field.set(absListView, Boolean.valueOf(z2));
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResolveHoverRunnable implements Runnable {
        ResolveHoverRunnable() {
        }

        public void a() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1970n = null;
            dropDownListView.removeCallbacks(this);
        }

        public void b() {
            DropDownListView.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = DropDownListView.this;
            dropDownListView.f1970n = null;
            dropDownListView.drawableStateChanged();
        }
    }

    DropDownListView(Context context, boolean z2) {
        super(context, null, R.attr.Y);
        this.f1958a = new Rect();
        this.f1959b = 0;
        this.f1960c = 0;
        this.f1961d = 0;
        this.f1962f = 0;
        this.f1966j = z2;
        setCacheColorHint(0);
    }

    private void a() {
        this.f1967k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1963g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f1968l;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.c();
            this.f1968l = null;
        }
    }

    private void b(View view, int i3) {
        performItemClick(view, i3, getItemIdAtPosition(i3));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (this.f1958a.isEmpty() || (selector = getSelector()) == null) {
            return;
        }
        selector.setBounds(this.f1958a);
        selector.draw(canvas);
    }

    private void f(int i3, View view) {
        Rect rect = this.f1958a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1959b;
        rect.top -= this.f1960c;
        rect.right += this.f1961d;
        rect.bottom += this.f1962f;
        boolean zK = k();
        if (view.isEnabled() != zK) {
            l(!zK);
            if (i3 != -1) {
                refreshDrawableState();
            }
        }
    }

    private void g(int i3, View view) {
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i3 == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        f(i3, view);
        if (z2) {
            Rect rect = this.f1958a;
            float fExactCenterX = rect.exactCenterX();
            float fExactCenterY = rect.exactCenterY();
            selector.setVisible(getVisibility() == 0, false);
            DrawableCompat.k(selector, fExactCenterX, fExactCenterY);
        }
    }

    private void h(int i3, View view, float f3, float f4) {
        g(i3, view);
        Drawable selector = getSelector();
        if (selector == null || i3 == -1) {
            return;
        }
        DrawableCompat.k(selector, f3, f4);
    }

    private void i(View view, int i3, float f3, float f4) {
        View childAt;
        this.f1967k = true;
        Api21Impl.a(this, f3, f4);
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i4 = this.f1963g;
        if (i4 != -1 && (childAt = getChildAt(i4 - getFirstVisiblePosition())) != null && childAt != view && childAt.isPressed()) {
            childAt.setPressed(false);
        }
        this.f1963g = i3;
        Api21Impl.a(view, f3 - view.getLeft(), f4 - view.getTop());
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i3, view, f3, f4);
        j(false);
        refreshDrawableState();
    }

    private void j(boolean z2) {
        GateKeeperDrawable gateKeeperDrawable = this.f1964h;
        if (gateKeeperDrawable != null) {
            gateKeeperDrawable.c(z2);
        }
    }

    private boolean k() {
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(this) : PreApi33Impl.a(this);
    }

    private void l(boolean z2) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.b(this, z2);
        } else {
            PreApi33Impl.b(this, z2);
        }
    }

    private boolean m() {
        return this.f1967k;
    }

    private void n() {
        Drawable selector = getSelector();
        if (selector != null && m() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    public int d(int i3, int i4, int i5, int i6, int i7) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        View view = null;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i11 = layoutParams.height;
            view.measure(i3, i11 > 0 ? View.MeasureSpec.makeMeasureSpec(i11, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i6) {
                return (i7 < 0 || i8 <= i7 || i10 <= 0 || measuredHeight == i6) ? i6 : i10;
            }
            if (i7 >= 0 && i8 >= i7) {
                i10 = measuredHeight;
            }
            i8++;
        }
        return measuredHeight;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1970n != null) {
            return;
        }
        super.drawableStateChanged();
        j(true);
        n();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean e(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L16
            r3 = 2
            if (r0 == r3) goto L14
            r9 = 3
            if (r0 == r9) goto L11
        Le:
            r3 = r1
            r9 = r2
            goto L46
        L11:
            r9 = r2
            r3 = r9
            goto L46
        L14:
            r3 = r1
            goto L17
        L16:
            r3 = r2
        L17:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L1e
            goto L11
        L1e:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L31
            r9 = r1
            goto L46
        L31:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.i(r3, r5, r4, r9)
            if (r0 != r1) goto Le
            r7.b(r3, r5)
            goto Le
        L46:
            if (r3 == 0) goto L4a
            if (r9 == 0) goto L4d
        L4a:
            r7.a()
        L4d:
            if (r3 == 0) goto L65
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1969m
            if (r9 != 0) goto L5a
            androidx.core.widget.ListViewAutoScrollHelper r9 = new androidx.core.widget.ListViewAutoScrollHelper
            r9.<init>(r7)
            r7.f1969m = r9
        L5a:
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1969m
            r9.m(r1)
            androidx.core.widget.ListViewAutoScrollHelper r9 = r7.f1969m
            r9.onTouch(r7, r8)
            return r3
        L65:
            androidx.core.widget.ListViewAutoScrollHelper r8 = r7.f1969m
            if (r8 == 0) goto L6c
            r8.m(r2)
        L6c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.DropDownListView.e(android.view.MotionEvent, int):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1966j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1966j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1966j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1966j && this.f1965i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1970n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int i3 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1970n == null) {
            ResolveHoverRunnable resolveHoverRunnable = new ResolveHoverRunnable();
            this.f1970n = resolveHoverRunnable;
            resolveHoverRunnable.b();
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked != 9 && actionMasked != 7) {
            setSelection(-1);
            return zOnHoverEvent;
        }
        int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
            View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
            if (childAt.isEnabled()) {
                requestFocus();
                if (i3 < 30 || !Api30Impl.a()) {
                    setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                } else {
                    Api30Impl.b(this, iPointToPosition, childAt);
                }
            }
            n();
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1963g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        ResolveHoverRunnable resolveHoverRunnable = this.f1970n;
        if (resolveHoverRunnable != null) {
            resolveHoverRunnable.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    void setListSelectionHidden(boolean z2) {
        this.f1965i = z2;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        GateKeeperDrawable gateKeeperDrawable = drawable != null ? new GateKeeperDrawable(drawable) : null;
        this.f1964h = gateKeeperDrawable;
        super.setSelector(gateKeeperDrawable);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1959b = rect.left;
        this.f1960c = rect.top;
        this.f1961d = rect.right;
        this.f1962f = rect.bottom;
    }
}
