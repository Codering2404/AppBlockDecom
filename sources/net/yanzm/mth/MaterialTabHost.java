package net.yanzm.mth;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class MaterialTabHost extends TabHost implements ViewPager.OnPageChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutInflater f143652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final TabWidget f143653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ShapeDrawable f143654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f143655d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f143656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f143657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Type f143658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OnTabChangeListener f143659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f143660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f143661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f143662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private float f143663m;

    /* JADX INFO: renamed from: net.yanzm.mth.MaterialTabHost$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f143665a;

        static {
            int[] iArr = new int[Type.values().length];
            f143665a = iArr;
            try {
                iArr[Type.FullScreenWidth.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f143665a[Type.Centered.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f143665a[Type.LeftOffset.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnTabChangeListener {
        void a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum Type {
        FullScreenWidth,
        Centered,
        LeftOffset
    }

    public MaterialTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f143658h = Type.FullScreenWidth;
        this.f143660j = Integer.MIN_VALUE;
        this.f143661k = 0;
        this.f143662l = 0;
        this.f143663m = 0.0f;
        this.f143652a = LayoutInflater.from(context);
        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = context.getTheme();
        theme.resolveAttribute(R.attr.f143671b, typedValue, true);
        setBackgroundColor(typedValue.data);
        theme.resolveAttribute(R.attr.f143670a, typedValue, true);
        int i3 = typedValue.data;
        this.f143657g = i3;
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.f143685k, 0, 0);
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.f143686l, i3);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable();
        this.f143654c = shapeDrawable;
        shapeDrawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        Resources resources = context.getResources();
        this.f143655d = resources.getDimensionPixelSize(R.dimen.f143673b);
        this.f143656f = resources.getDimensionPixelSize(R.dimen.f143674c);
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f143672a);
        TabWidget tabWidget = new TabWidget(context);
        this.f143653b = tabWidget;
        tabWidget.setLayoutParams(new FrameLayout.LayoutParams(-1, dimensionPixelSize));
        tabWidget.setId(android.R.id.tabs);
        tabWidget.setStripEnabled(false);
        tabWidget.setShowDividers(0);
        addView(tabWidget);
        View frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(0, 0));
        frameLayout.setId(android.R.id.tabcontent);
        addView(frameLayout);
        setup();
        setOnTabChangedListener(new TabHost.OnTabChangeListener() { // from class: net.yanzm.mth.MaterialTabHost.1
            @Override // android.widget.TabHost.OnTabChangeListener
            public void onTabChanged(String str) {
                if (MaterialTabHost.this.f143659i != null) {
                    MaterialTabHost.this.f143659i.a(Integer.valueOf(str).intValue());
                }
            }
        });
        ViewCompat.u0(this, getResources().getDisplayMetrics().density * 4.0f);
    }

    private void b(int i3, float f3) {
        this.f143662l = i3;
        this.f143663m = f3;
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getChildCount() == 0) {
            return;
        }
        ShapeDrawable shapeDrawable = this.f143654c;
        View childTabViewAt = this.f143653b.getChildTabViewAt(this.f143662l);
        if (childTabViewAt == null) {
            return;
        }
        View childTabViewAt2 = this.f143662l + 1 < this.f143653b.getTabCount() ? this.f143653b.getChildTabViewAt(this.f143662l + 1) : null;
        int width = childTabViewAt.getWidth();
        int width2 = childTabViewAt2 == null ? width : childTabViewAt2.getWidth();
        float f3 = this.f143663m;
        float f4 = width;
        int i3 = (int) ((width2 * f3) + ((1.0f - f3) * f4));
        int paddingLeft = (int) (getPaddingLeft() + childTabViewAt.getLeft() + (this.f143663m * f4));
        int height = getHeight();
        shapeDrawable.setBounds(paddingLeft, height - this.f143655d, i3 + paddingLeft, height);
        shapeDrawable.draw(canvas);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        if (this.f143658h == Type.Centered && this.f143660j == Integer.MIN_VALUE) {
            for (int i7 = 0; i7 < this.f143653b.getTabCount(); i7++) {
                View childTabViewAt = this.f143653b.getChildTabViewAt(i7);
                if (childTabViewAt.getMeasuredWidth() > this.f143660j) {
                    this.f143660j = childTabViewAt.getMeasuredWidth();
                }
            }
            if (this.f143660j > 0) {
                for (int i8 = 0; i8 < this.f143653b.getTabCount(); i8++) {
                    View childTabViewAt2 = this.f143653b.getChildTabViewAt(i8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childTabViewAt2.getLayoutParams();
                    layoutParams.width = this.f143660j;
                    childTabViewAt2.setLayoutParams(layoutParams);
                }
            }
        }
        super.onLayout(z2, i3, i4, i5, i6);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
        this.f143661k = i3;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f3, int i4) {
        b(i3, f3);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        if (this.f143661k == 0) {
            b(i3, 0.0f);
        }
        setCurrentTab(i3);
    }

    public void setOnTabChangeListener(OnTabChangeListener onTabChangeListener) {
        this.f143659i = onTabChangeListener;
    }

    public void setType(Type type) {
        this.f143658h = type;
        int i3 = AnonymousClass2.f143665a[type.ordinal()];
        if (i3 == 1) {
            this.f143653b.setGravity(3);
            setPadding(0, 0, 0, 0);
        } else if (i3 == 2) {
            this.f143653b.setGravity(1);
            setPadding(0, 0, 0, 0);
        } else if (i3 != 3) {
            this.f143653b.setGravity(3);
            setPadding(0, 0, 0, 0);
        } else {
            this.f143653b.setGravity(3);
            setPadding(this.f143656f, 0, 0, 0);
        }
    }
}
