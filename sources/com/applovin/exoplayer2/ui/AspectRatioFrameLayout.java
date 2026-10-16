package com.applovin.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.applovin.sdk.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AspectRatioFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f57972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f57973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f57974c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface b {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private float f57975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f57976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f57977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f57978d;

        private c() {
        }

        public void a(float f3, float f4, boolean z2) {
            this.f57975a = f3;
            this.f57976b = f4;
            this.f57977c = z2;
            if (this.f57978d) {
                return;
            }
            this.f57978d = true;
            AspectRatioFrameLayout.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f57978d = false;
            AspectRatioFrameLayout.a(AspectRatioFrameLayout.this);
        }
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    static /* synthetic */ b a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        aspectRatioFrameLayout.getClass();
        return null;
    }

    public int getResizeMode() {
        return this.f57974c;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i4) {
        float f3;
        float f4;
        super.onMeasure(i3, i4);
        if (this.f57973b <= 0.0f) {
            return;
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f5 = measuredWidth;
        float f6 = measuredHeight;
        float f7 = f5 / f6;
        float f8 = (this.f57973b / f7) - 1.0f;
        if (Math.abs(f8) <= 0.01f) {
            this.f57972a.a(this.f57973b, f7, false);
            return;
        }
        int i5 = this.f57974c;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    f3 = this.f57973b;
                } else if (i5 == 4) {
                    if (f8 > 0.0f) {
                        f3 = this.f57973b;
                    } else {
                        f4 = this.f57973b;
                    }
                }
                measuredWidth = (int) (f6 * f3);
            } else {
                f4 = this.f57973b;
            }
            measuredHeight = (int) (f5 / f4);
        } else if (f8 > 0.0f) {
            f4 = this.f57973b;
            measuredHeight = (int) (f5 / f4);
        } else {
            f3 = this.f57973b;
            measuredWidth = (int) (f6 * f3);
        }
        this.f57972a.a(this.f57973b, f7, true);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
    }

    public void setAspectRatio(float f3) {
        if (this.f57973b != f3) {
            this.f57973b = f3;
            requestLayout();
        }
    }

    public void setResizeMode(int i3) {
        if (this.f57974c != i3) {
            this.f57974c = i3;
            requestLayout();
        }
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f57974c = 0;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AppLovinAspectRatioFrameLayout, 0, 0);
            try {
                this.f57974c = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinAspectRatioFrameLayout_al_resize_mode, 0);
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f57972a = new c();
    }

    public void setAspectRatioListener(b bVar) {
    }
}
