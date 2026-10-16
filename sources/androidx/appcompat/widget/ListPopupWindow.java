package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.core.widget.PopupWindowCompat;
import com.google.android.gms.common.api.Api;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ListPopupWindow implements ShowableListMenu {
    private static Method H;
    private static Method I;
    private final ListSelectorHider A;
    private Runnable B;
    final Handler C;
    private final Rect D;
    private Rect E;
    private boolean F;
    PopupWindow G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f2018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ListAdapter f2019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    DropDownListView f2020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f2021d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f2022f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f2023g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f2024h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f2025i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2026j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2027k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f2028l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2029m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f2030n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2031o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    int f2032p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private View f2033q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f2034r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private DataSetObserver f2035s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private View f2036t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private Drawable f2037u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private AdapterView.OnItemClickListener f2038v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private AdapterView.OnItemSelectedListener f2039w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    final ResizePopupRunnable f2040x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final PopupTouchInterceptor f2041y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final PopupScrollListener f2042z;

    /* JADX INFO: renamed from: androidx.appcompat.widget.ListPopupWindow$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends ForwardingListener {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ListPopupWindow f2043k;

        @Override // androidx.appcompat.widget.ForwardingListener
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public ListPopupWindow b() {
            return this.f2043k;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api24Impl {
        static int a(PopupWindow popupWindow, View view, int i3, boolean z2) {
            return popupWindow.getMaxAvailableHeight(view, i3, z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        static void b(PopupWindow popupWindow, boolean z2) {
            popupWindow.setIsClippedToScreen(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ListSelectorHider implements Runnable {
        ListSelectorHider() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ListPopupWindow.this.q();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PopupDataSetObserver extends DataSetObserver {
        PopupDataSetObserver() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (ListPopupWindow.this.b()) {
                ListPopupWindow.this.show();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            ListPopupWindow.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PopupTouchInterceptor implements View.OnTouchListener {
        PopupTouchInterceptor() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = ListPopupWindow.this.G) != null && popupWindow.isShowing() && x2 >= 0 && x2 < ListPopupWindow.this.G.getWidth() && y2 >= 0 && y2 < ListPopupWindow.this.G.getHeight()) {
                ListPopupWindow listPopupWindow = ListPopupWindow.this;
                listPopupWindow.C.postDelayed(listPopupWindow.f2040x, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            ListPopupWindow listPopupWindow2 = ListPopupWindow.this;
            listPopupWindow2.C.removeCallbacks(listPopupWindow2.f2040x);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ResizePopupRunnable implements Runnable {
        ResizePopupRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DropDownListView dropDownListView = ListPopupWindow.this.f2020c;
            if (dropDownListView == null || !dropDownListView.isAttachedToWindow() || ListPopupWindow.this.f2020c.getCount() <= ListPopupWindow.this.f2020c.getChildCount()) {
                return;
            }
            int childCount = ListPopupWindow.this.f2020c.getChildCount();
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            if (childCount <= listPopupWindow.f2032p) {
                listPopupWindow.G.setInputMethodMode(2);
                ListPopupWindow.this.show();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                H = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                I = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public ListPopupWindow(Context context) {
        this(context, null, R.attr.f638d0);
    }

    private void B() {
        View view = this.f2033q;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2033q);
            }
        }
    }

    private void N(boolean z2) {
        if (Build.VERSION.SDK_INT > 28) {
            Api29Impl.b(this.G, z2);
            return;
        }
        Method method = H;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z2));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int p() {
        int measuredHeight;
        int i3;
        int iMakeMeasureSpec;
        View view;
        int i4;
        if (this.f2020c == null) {
            Context context = this.f2018a;
            this.B = new Runnable() { // from class: androidx.appcompat.widget.ListPopupWindow.2
                @Override // java.lang.Runnable
                public void run() {
                    View viewS = ListPopupWindow.this.s();
                    if (viewS == null || viewS.getWindowToken() == null) {
                        return;
                    }
                    ListPopupWindow.this.show();
                }
            };
            DropDownListView dropDownListViewR = r(context, !this.F);
            this.f2020c = dropDownListViewR;
            Drawable drawable = this.f2037u;
            if (drawable != null) {
                dropDownListViewR.setSelector(drawable);
            }
            this.f2020c.setAdapter(this.f2019b);
            this.f2020c.setOnItemClickListener(this.f2038v);
            this.f2020c.setFocusable(true);
            this.f2020c.setFocusableInTouchMode(true);
            this.f2020c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: androidx.appcompat.widget.ListPopupWindow.3
                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onItemSelected(AdapterView adapterView, View view2, int i5, long j3) {
                    DropDownListView dropDownListView;
                    if (i5 == -1 || (dropDownListView = ListPopupWindow.this.f2020c) == null) {
                        return;
                    }
                    dropDownListView.setListSelectionHidden(false);
                }

                @Override // android.widget.AdapterView.OnItemSelectedListener
                public void onNothingSelected(AdapterView adapterView) {
                }
            });
            this.f2020c.setOnScrollListener(this.f2042z);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.f2039w;
            if (onItemSelectedListener != null) {
                this.f2020c.setOnItemSelectedListener(onItemSelectedListener);
            }
            DropDownListView dropDownListView = this.f2020c;
            View view2 = this.f2033q;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i5 = this.f2034r;
                if (i5 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(dropDownListView, layoutParams);
                } else if (i5 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.f2034r);
                } else {
                    linearLayout.addView(dropDownListView, layoutParams);
                    linearLayout.addView(view2);
                }
                int i6 = this.f2022f;
                if (i6 >= 0) {
                    i4 = Integer.MIN_VALUE;
                } else {
                    i6 = 0;
                    i4 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i6, i4), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = dropDownListView;
            }
            this.G.setContentView(view);
        } else {
            View view3 = this.f2033q;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.G.getBackground();
        if (background != null) {
            background.getPadding(this.D);
            Rect rect = this.D;
            int i7 = rect.top;
            i3 = rect.bottom + i7;
            if (!this.f2026j) {
                this.f2024h = -i7;
            }
        } else {
            this.D.setEmpty();
            i3 = 0;
        }
        int iT = t(s(), this.f2024h, this.G.getInputMethodMode() == 2);
        if (this.f2030n || this.f2021d == -1) {
            return iT + i3;
        }
        int i8 = this.f2022f;
        if (i8 == -2) {
            int i9 = this.f2018a.getResources().getDisplayMetrics().widthPixels;
            Rect rect2 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect2.left + rect2.right), Integer.MIN_VALUE);
        } else if (i8 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8, 1073741824);
        } else {
            int i10 = this.f2018a.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.D;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - (rect3.left + rect3.right), 1073741824);
        }
        int iD = this.f2020c.d(iMakeMeasureSpec, 0, -1, iT - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i3 + this.f2020c.getPaddingTop() + this.f2020c.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    private int t(View view, int i3, boolean z2) {
        return Api24Impl.a(this.G, view, i3, z2);
    }

    public boolean A() {
        return this.F;
    }

    public void C(View view) {
        this.f2036t = view;
    }

    public void D(int i3) {
        this.G.setAnimationStyle(i3);
    }

    public void E(int i3) {
        Drawable background = this.G.getBackground();
        if (background == null) {
            Q(i3);
            return;
        }
        background.getPadding(this.D);
        Rect rect = this.D;
        this.f2022f = rect.left + rect.right + i3;
    }

    public void F(int i3) {
        this.f2029m = i3;
    }

    public void G(Rect rect) {
        this.E = rect != null ? new Rect(rect) : null;
    }

    public void H(int i3) {
        this.G.setInputMethodMode(i3);
    }

    public void I(boolean z2) {
        this.F = z2;
        this.G.setFocusable(z2);
    }

    public void J(PopupWindow.OnDismissListener onDismissListener) {
        this.G.setOnDismissListener(onDismissListener);
    }

    public void K(AdapterView.OnItemClickListener onItemClickListener) {
        this.f2038v = onItemClickListener;
    }

    public void L(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.f2039w = onItemSelectedListener;
    }

    public void M(boolean z2) {
        this.f2028l = true;
        this.f2027k = z2;
    }

    public void O(int i3) {
        this.f2034r = i3;
    }

    public void P(int i3) {
        DropDownListView dropDownListView = this.f2020c;
        if (!b() || dropDownListView == null) {
            return;
        }
        dropDownListView.setListSelectionHidden(false);
        dropDownListView.setSelection(i3);
        if (dropDownListView.getChoiceMode() != 0) {
            dropDownListView.setItemChecked(i3, true);
        }
    }

    public void Q(int i3) {
        this.f2022f = i3;
    }

    public void a(Drawable drawable) {
        this.G.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public boolean b() {
        return this.G.isShowing();
    }

    public int c() {
        return this.f2023g;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void dismiss() {
        this.G.dismiss();
        B();
        this.G.setContentView(null);
        this.f2020c = null;
        this.C.removeCallbacks(this.f2040x);
    }

    public void e(int i3) {
        this.f2023g = i3;
    }

    public Drawable g() {
        return this.G.getBackground();
    }

    public void i(int i3) {
        this.f2024h = i3;
        this.f2026j = true;
    }

    public int l() {
        if (this.f2026j) {
            return this.f2024h;
        }
        return 0;
    }

    public void m(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f2035s;
        if (dataSetObserver == null) {
            this.f2035s = new PopupDataSetObserver();
        } else {
            ListAdapter listAdapter2 = this.f2019b;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f2019b = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f2035s);
        }
        DropDownListView dropDownListView = this.f2020c;
        if (dropDownListView != null) {
            dropDownListView.setAdapter(this.f2019b);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public ListView o() {
        return this.f2020c;
    }

    public void q() {
        DropDownListView dropDownListView = this.f2020c;
        if (dropDownListView != null) {
            dropDownListView.setListSelectionHidden(true);
            dropDownListView.requestLayout();
        }
    }

    DropDownListView r(Context context, boolean z2) {
        return new DropDownListView(context, z2);
    }

    public View s() {
        return this.f2036t;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public void show() {
        int iP = p();
        boolean z2 = z();
        PopupWindowCompat.b(this.G, this.f2025i);
        if (this.G.isShowing()) {
            if (s().isAttachedToWindow()) {
                int width = this.f2022f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = s().getWidth();
                }
                int i3 = this.f2021d;
                if (i3 == -1) {
                    if (!z2) {
                        iP = -1;
                    }
                    if (z2) {
                        this.G.setWidth(this.f2022f == -1 ? -1 : 0);
                        this.G.setHeight(0);
                    } else {
                        this.G.setWidth(this.f2022f == -1 ? -1 : 0);
                        this.G.setHeight(-1);
                    }
                } else if (i3 != -2) {
                    iP = i3;
                }
                this.G.setOutsideTouchable((this.f2031o || this.f2030n) ? false : true);
                this.G.update(s(), this.f2023g, this.f2024h, width < 0 ? -1 : width, iP < 0 ? -1 : iP);
                return;
            }
            return;
        }
        int width2 = this.f2022f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = s().getWidth();
        }
        int i4 = this.f2021d;
        if (i4 == -1) {
            iP = -1;
        } else if (i4 != -2) {
            iP = i4;
        }
        this.G.setWidth(width2);
        this.G.setHeight(iP);
        N(true);
        this.G.setOutsideTouchable((this.f2031o || this.f2030n) ? false : true);
        this.G.setTouchInterceptor(this.f2041y);
        if (this.f2028l) {
            PopupWindowCompat.a(this.G, this.f2027k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = I;
            if (method != null) {
                try {
                    method.invoke(this.G, this.E);
                } catch (Exception e3) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e3);
                }
            }
        } else {
            Api29Impl.a(this.G, this.E);
        }
        PopupWindowCompat.c(this.G, s(), this.f2023g, this.f2024h, this.f2029m);
        this.f2020c.setSelection(-1);
        if (!this.F || this.f2020c.isInTouchMode()) {
            q();
        }
        if (this.F) {
            return;
        }
        this.C.post(this.A);
    }

    public Object u() {
        if (b()) {
            return this.f2020c.getSelectedItem();
        }
        return null;
    }

    public long v() {
        if (b()) {
            return this.f2020c.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int w() {
        if (b()) {
            return this.f2020c.getSelectedItemPosition();
        }
        return -1;
    }

    public View x() {
        if (b()) {
            return this.f2020c.getSelectedView();
        }
        return null;
    }

    public int y() {
        return this.f2022f;
    }

    public boolean z() {
        return this.G.getInputMethodMode() == 2;
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public ListPopupWindow(Context context, AttributeSet attributeSet, int i3, int i4) {
        this.f2021d = -2;
        this.f2022f = -2;
        this.f2025i = 1002;
        this.f2029m = 0;
        this.f2030n = false;
        this.f2031o = false;
        this.f2032p = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2034r = 0;
        this.f2040x = new ResizePopupRunnable();
        this.f2041y = new PopupTouchInterceptor();
        this.f2042z = new PopupScrollListener();
        this.A = new ListSelectorHider();
        this.D = new Rect();
        this.f2018a = context;
        this.C = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.f887v1, i3, i4);
        this.f2023g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.f890w1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.f893x1, 0);
        this.f2024h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.f2026j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        AppCompatPopupWindow appCompatPopupWindow = new AppCompatPopupWindow(context, attributeSet, i3, i4);
        this.G = appCompatPopupWindow;
        appCompatPopupWindow.setInputMethodMode(1);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class PopupScrollListener implements AbsListView.OnScrollListener {
        PopupScrollListener() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 1 || ListPopupWindow.this.z() || ListPopupWindow.this.G.getContentView() == null) {
                return;
            }
            ListPopupWindow listPopupWindow = ListPopupWindow.this;
            listPopupWindow.C.removeCallbacks(listPopupWindow.f2040x);
            ListPopupWindow.this.f2040x.run();
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i4, int i5) {
        }
    }
}
