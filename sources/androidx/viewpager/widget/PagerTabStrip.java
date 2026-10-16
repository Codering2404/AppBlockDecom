package androidx.viewpager.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class PagerTabStrip extends PagerTitleStrip {
    private boolean A;
    private boolean B;
    private int C;
    private boolean D;
    private float E;
    private float F;
    private int G;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f53743r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f53744s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f53745t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f53746u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f53747v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f53748w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Paint f53749x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final Rect f53750y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f53751z;

    /* JADX INFO: renamed from: androidx.viewpager.widget.PagerTabStrip$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PagerTabStrip f53752a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f53752a.f53756a.setCurrentItem(r2.getCurrentItem() - 1);
        }
    }

    /* JADX INFO: renamed from: androidx.viewpager.widget.PagerTabStrip$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ PagerTabStrip f53753a;

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewPager viewPager = this.f53753a.f53756a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    void c(int i3, float f3, boolean z2) {
        Rect rect = this.f53750y;
        int height = getHeight();
        int left = this.f53758c.getLeft() - this.f53748w;
        int right = this.f53758c.getRight() + this.f53748w;
        int i4 = height - this.f53744s;
        rect.set(left, i4, right, height);
        super.c(i3, f3, z2);
        this.f53751z = (int) (Math.abs(f3 - 0.5f) * 2.0f * 255.0f);
        rect.union(this.f53758c.getLeft() - this.f53748w, i4, this.f53758c.getRight() + this.f53748w, height);
        invalidate(rect);
    }

    public boolean getDrawFullUnderline() {
        return this.A;
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    int getMinHeight() {
        return Math.max(super.getMinHeight(), this.f53747v);
    }

    public int getTabIndicatorColor() {
        return this.f53743r;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight();
        int left = this.f53758c.getLeft() - this.f53748w;
        int right = this.f53758c.getRight() + this.f53748w;
        int i3 = height - this.f53744s;
        this.f53749x.setColor((this.f53751z << 24) | (this.f53743r & 16777215));
        float f3 = height;
        canvas.drawRect(left, i3, right, f3, this.f53749x);
        if (this.A) {
            this.f53749x.setColor((this.f53743r & 16777215) | (-16777216));
            canvas.drawRect(getPaddingLeft(), height - this.C, getWidth() - getPaddingRight(), f3, this.f53749x);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0 && this.D) {
            return false;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        if (action == 0) {
            this.E = x2;
            this.F = y2;
            this.D = false;
        } else if (action != 1) {
            if (action == 2 && (Math.abs(x2 - this.E) > this.G || Math.abs(y2 - this.F) > this.G)) {
                this.D = true;
            }
        } else if (x2 < this.f53758c.getLeft() - this.f53748w) {
            ViewPager viewPager = this.f53756a;
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        } else if (x2 > this.f53758c.getRight() + this.f53748w) {
            ViewPager viewPager2 = this.f53756a;
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
        return true;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        super.setBackgroundColor(i3);
        if (this.B) {
            return;
        }
        this.A = (i3 & (-16777216)) == 0;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.B) {
            return;
        }
        this.A = drawable == null;
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        if (this.B) {
            return;
        }
        this.A = i3 == 0;
    }

    public void setDrawFullUnderline(boolean z2) {
        this.A = z2;
        this.B = true;
        invalidate();
    }

    @Override // android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        int i7 = this.f53745t;
        if (i6 < i7) {
            i6 = i7;
        }
        super.setPadding(i3, i4, i5, i6);
    }

    public void setTabIndicatorColor(int i3) {
        this.f53743r = i3;
        this.f53749x.setColor(i3);
        invalidate();
    }

    public void setTabIndicatorColorResource(int i3) {
        setTabIndicatorColor(ContextCompat.getColor(getContext(), i3));
    }

    @Override // androidx.viewpager.widget.PagerTitleStrip
    public void setTextSpacing(int i3) {
        int i4 = this.f53746u;
        if (i3 < i4) {
            i3 = i4;
        }
        super.setTextSpacing(i3);
    }
}
