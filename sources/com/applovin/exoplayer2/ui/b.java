package com.applovin.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.applovin.exoplayer2.ui.i;
import com.applovin.impl.b1;
import com.applovin.impl.xp;
import com.applovin.sdk.R;
import com.facebook.internal.Utility;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class b extends View implements i {
    private final float A;
    private int B;
    private long C;
    private int D;
    private Rect E;
    private ValueAnimator F;
    private float G;
    private boolean H;
    private boolean I;
    private long J;
    private long K;
    private long L;
    private long M;
    private int N;
    private long[] O;
    private boolean[] P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Rect f57996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rect f57997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Rect f57998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Rect f57999d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Paint f58000f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f58001g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f58002h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f58003i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f58004j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint f58005k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final Drawable f58006l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f58007m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f58008n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f58009o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final int f58010p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f58011q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final int f58012r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final int f58013s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f58014t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final int f58015u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final StringBuilder f58016v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Formatter f58017w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final Runnable f58018x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final CopyOnWriteArraySet f58019y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final Point f58020z;

    public b(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2) {
        this(context, attributeSet, i3, attributeSet2, 0);
    }

    private void c(long j3) {
        if (this.J == j3) {
            return;
        }
        this.J = j3;
        Iterator it = this.f58019y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).b(this, j3);
        }
    }

    private long getPositionIncrement() {
        long j3 = this.C;
        if (j3 != -9223372036854775807L) {
            return j3;
        }
        long j4 = this.K;
        if (j4 == -9223372036854775807L) {
            return 0L;
        }
        return j4 / ((long) this.B);
    }

    private String getProgressText() {
        return xp.a(this.f58016v, this.f58017w, this.L);
    }

    private long getScrubberPosition() {
        if (this.f57997b.width() <= 0 || this.K == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.f57999d.width()) * this.K) / ((long) this.f57997b.width());
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        c();
    }

    @Override // com.applovin.exoplayer2.ui.i
    public long getPreferredUpdateDelay() {
        int iB = b(this.A, this.f57997b.width());
        if (iB == 0) {
            return Long.MAX_VALUE;
        }
        long j3 = this.K;
        if (j3 == 0 || j3 == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j3 / ((long) iB);
    }

    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f58006l;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        b(canvas);
        a(canvas);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z2, int i3, Rect rect) {
        super.onFocusChanged(z2, i3, rect);
        if (!this.I || z2) {
            return;
        }
        a(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.K <= 0) {
            return;
        }
        if (xp.f65027a >= 21) {
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
        } else {
            accessibilityNodeInfo.addAction(4096);
            accessibilityNodeInfo.addAction(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(int r5, android.view.KeyEvent r6) {
        /*
            r4 = this;
            boolean r0 = r4.isEnabled()
            if (r0 == 0) goto L30
            long r0 = r4.getPositionIncrement()
            r2 = 66
            r3 = 1
            if (r5 == r2) goto L27
            switch(r5) {
                case 21: goto L13;
                case 22: goto L14;
                case 23: goto L27;
                default: goto L12;
            }
        L12:
            goto L30
        L13:
            long r0 = -r0
        L14:
            boolean r0 = r4.a(r0)
            if (r0 == 0) goto L30
            java.lang.Runnable r5 = r4.f58018x
            r4.removeCallbacks(r5)
            java.lang.Runnable r5 = r4.f58018x
            r0 = 1000(0x3e8, double:4.94E-321)
            r4.postDelayed(r5, r0)
            return r3
        L27:
            boolean r0 = r4.I
            if (r0 == 0) goto L30
            r5 = 0
            r4.a(r5)
            return r3
        L30:
            boolean r5 = super.onKeyDown(r5, r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.b.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int paddingBottom;
        int iMax;
        int i7 = i5 - i3;
        int i8 = i6 - i4;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i7 - getPaddingRight();
        int i9 = this.H ? 0 : this.f58014t;
        if (this.f58009o == 1) {
            paddingBottom = (i8 - getPaddingBottom()) - this.f58008n;
            int paddingBottom2 = i8 - getPaddingBottom();
            int i10 = this.f58007m;
            iMax = (paddingBottom2 - i10) - Math.max(i9 - (i10 / 2), 0);
        } else {
            paddingBottom = (i8 - this.f58008n) / 2;
            iMax = (i8 - this.f58007m) / 2;
        }
        this.f57996a.set(paddingLeft, paddingBottom, paddingRight, this.f58008n + paddingBottom);
        Rect rect = this.f57997b;
        Rect rect2 = this.f57996a;
        rect.set(rect2.left + i9, iMax, rect2.right - i9, this.f58007m + iMax);
        if (xp.f65027a >= 29) {
            a(i7, i8);
        }
        b();
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 0) {
            size = this.f58008n;
        } else if (mode != 1073741824) {
            size = Math.min(this.f58008n, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i3), size);
        c();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i3) {
        Drawable drawable = this.f58006l;
        if (drawable == null || !a(drawable, i3)) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            boolean r0 = r7.isEnabled()
            r1 = 0
            if (r0 == 0) goto L76
            long r2 = r7.K
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 > 0) goto L10
            goto L76
        L10:
            android.graphics.Point r0 = r7.a(r8)
            int r2 = r0.x
            int r0 = r0.y
            int r3 = r8.getAction()
            r4 = 1
            if (r3 == 0) goto L5d
            r5 = 3
            if (r3 == r4) goto L4e
            r6 = 2
            if (r3 == r6) goto L28
            if (r3 == r5) goto L4e
            goto L76
        L28:
            boolean r8 = r7.I
            if (r8 == 0) goto L76
            int r8 = r7.f58015u
            if (r0 >= r8) goto L3a
            int r8 = r7.D
            int r2 = r2 - r8
            int r2 = r2 / r5
            int r8 = r8 + r2
            float r8 = (float) r8
            r7.a(r8)
            goto L40
        L3a:
            r7.D = r2
            float r8 = (float) r2
            r7.a(r8)
        L40:
            long r0 = r7.getScrubberPosition()
            r7.c(r0)
            r7.b()
            r7.invalidate()
            return r4
        L4e:
            boolean r0 = r7.I
            if (r0 == 0) goto L76
            int r8 = r8.getAction()
            if (r8 != r5) goto L59
            r1 = r4
        L59:
            r7.a(r1)
            return r4
        L5d:
            float r8 = (float) r2
            float r0 = (float) r0
            boolean r0 = r7.a(r8, r0)
            if (r0 == 0) goto L76
            r7.a(r8)
            long r0 = r7.getScrubberPosition()
            r7.b(r0)
            r7.b()
            r7.invalidate()
            return r4
        L76:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.b.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean performAccessibilityAction(int i3, Bundle bundle) {
        if (super.performAccessibilityAction(i3, bundle)) {
            return true;
        }
        if (this.K <= 0) {
            return false;
        }
        if (i3 == 8192) {
            if (a(-getPositionIncrement())) {
                a(false);
            }
        } else {
            if (i3 != 4096) {
                return false;
            }
            if (a(getPositionIncrement())) {
                a(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    public void setAdMarkerColor(int i3) {
        this.f58003i.setColor(i3);
        invalidate(this.f57996a);
    }

    public void setBufferedColor(int i3) {
        this.f58001g.setColor(i3);
        invalidate(this.f57996a);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setBufferedPosition(long j3) {
        if (this.M == j3) {
            return;
        }
        this.M = j3;
        b();
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setDuration(long j3) {
        if (this.K == j3) {
            return;
        }
        this.K = j3;
        if (this.I && j3 == -9223372036854775807L) {
            a(true);
        }
        b();
    }

    @Override // android.view.View, com.applovin.exoplayer2.ui.i
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (!this.I || z2) {
            return;
        }
        a(true);
    }

    public void setKeyCountIncrement(int i3) {
        b1.a(i3 > 0);
        this.B = i3;
        this.C = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long j3) {
        b1.a(j3 > 0);
        this.B = -1;
        this.C = j3;
    }

    public void setPlayedAdMarkerColor(int i3) {
        this.f58004j.setColor(i3);
        invalidate(this.f57996a);
    }

    public void setPlayedColor(int i3) {
        this.f58000f.setColor(i3);
        invalidate(this.f57996a);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void setPosition(long j3) {
        if (this.L == j3) {
            return;
        }
        this.L = j3;
        setContentDescription(getProgressText());
        b();
    }

    public void setScrubberColor(int i3) {
        this.f58005k.setColor(i3);
        invalidate(this.f57996a);
    }

    public void setUnplayedColor(int i3) {
        this.f58002h.setColor(i3);
        invalidate(this.f57996a);
    }

    public b(Context context, AttributeSet attributeSet, int i3, AttributeSet attributeSet2, int i4) {
        super(context, attributeSet, i3);
        this.f57996a = new Rect();
        this.f57997b = new Rect();
        this.f57998c = new Rect();
        this.f57999d = new Rect();
        Paint paint = new Paint();
        this.f58000f = paint;
        Paint paint2 = new Paint();
        this.f58001g = paint2;
        Paint paint3 = new Paint();
        this.f58002h = paint3;
        Paint paint4 = new Paint();
        this.f58003i = paint4;
        Paint paint5 = new Paint();
        this.f58004j = paint5;
        Paint paint6 = new Paint();
        this.f58005k = paint6;
        paint6.setAntiAlias(true);
        this.f58019y = new CopyOnWriteArraySet();
        this.f58020z = new Point();
        float f3 = context.getResources().getDisplayMetrics().density;
        this.A = f3;
        this.f58015u = a(f3, -50);
        int iA = a(f3, 4);
        int iA2 = a(f3, 26);
        int iA3 = a(f3, 4);
        int iA4 = a(f3, 12);
        int iA5 = a(f3, 0);
        int iA6 = a(f3, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, R.styleable.AppLovinDefaultTimeBar, i3, i4);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(R.styleable.AppLovinDefaultTimeBar_al_scrubber_drawable);
                this.f58006l = drawable;
                if (drawable != null) {
                    a(drawable);
                    iA2 = Math.max(drawable.getMinimumHeight(), iA2);
                }
                this.f58007m = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_bar_height, iA);
                this.f58008n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_touch_target_height, iA2);
                this.f58009o = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_bar_gravity, 0);
                this.f58010p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_width, iA3);
                this.f58011q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_enabled_size, iA4);
                this.f58012r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_disabled_size, iA5);
                this.f58013s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AppLovinDefaultTimeBar_al_scrubber_dragged_size, iA6);
                int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_color, -1);
                int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_scrubber_color, -1);
                int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_buffered_color, -855638017);
                int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_unplayed_color, 872415231);
                int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_ad_marker_color, -1291845888);
                int i10 = typedArrayObtainStyledAttributes.getInt(R.styleable.AppLovinDefaultTimeBar_al_played_ad_marker_color, 872414976);
                paint.setColor(i5);
                paint6.setColor(i6);
                paint2.setColor(i7);
                paint3.setColor(i8);
                paint4.setColor(i9);
                paint5.setColor(i10);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.f58007m = iA;
            this.f58008n = iA2;
            this.f58009o = 0;
            this.f58010p = iA3;
            this.f58011q = iA4;
            this.f58012r = iA5;
            this.f58013s = iA6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.f58006l = null;
        }
        StringBuilder sb = new StringBuilder();
        this.f58016v = sb;
        this.f58017w = new Formatter(sb, Locale.getDefault());
        this.f58018x = new Runnable() { // from class: com.applovin.exoplayer2.ui.k
            @Override // java.lang.Runnable
            public final void run() {
                this.f58127a.a();
            }
        };
        Drawable drawable2 = this.f58006l;
        if (drawable2 != null) {
            this.f58014t = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.f58014t = (Math.max(this.f58012r, Math.max(this.f58011q, this.f58013s)) + 1) / 2;
        }
        this.G = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.F = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.applovin.exoplayer2.ui.l
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                this.f58128a.a(valueAnimator2);
            }
        });
        this.K = -9223372036854775807L;
        this.C = -9223372036854775807L;
        this.B = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    private static int a(float f3, int i3) {
        return (int) ((i3 * f3) + 0.5f);
    }

    private static int b(float f3, int i3) {
        return (int) (i3 / f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a() {
        a(false);
    }

    private void b(long j3) {
        this.J = j3;
        this.I = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.f58019y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).a(this, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ValueAnimator valueAnimator) {
        this.G = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate(this.f57996a);
    }

    private void c() {
        Drawable drawable = this.f58006l;
        if (drawable != null && drawable.isStateful() && this.f58006l.setState(getDrawableState())) {
            invalidate();
        }
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void a(i.a aVar) {
        b1.a(aVar);
        this.f58019y.add(aVar);
    }

    @Override // com.applovin.exoplayer2.ui.i
    public void a(long[] jArr, boolean[] zArr, int i3) {
        b1.a(i3 == 0 || !(jArr == null || zArr == null));
        this.N = i3;
        this.O = jArr;
        this.P = zArr;
        b();
    }

    private void b() {
        this.f57998c.set(this.f57997b);
        this.f57999d.set(this.f57997b);
        long j3 = this.I ? this.J : this.L;
        if (this.K > 0) {
            int iWidth = (int) ((((long) this.f57997b.width()) * this.M) / this.K);
            Rect rect = this.f57998c;
            Rect rect2 = this.f57997b;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.f57997b.width()) * j3) / this.K);
            Rect rect3 = this.f57999d;
            Rect rect4 = this.f57997b;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.f57998c;
            int i3 = this.f57997b.left;
            rect5.right = i3;
            this.f57999d.right = i3;
        }
        invalidate(this.f57996a);
    }

    private void a(boolean z2) {
        removeCallbacks(this.f58018x);
        this.I = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.f58019y.iterator();
        while (it.hasNext()) {
            ((i.a) it.next()).a(this, this.J, z2);
        }
    }

    private boolean a(long j3) {
        long j4 = this.K;
        if (j4 <= 0) {
            return false;
        }
        long j5 = this.I ? this.J : this.L;
        long jB = xp.b(j5 + j3, 0L, j4);
        if (jB == j5) {
            return false;
        }
        if (!this.I) {
            b(jB);
        } else {
            c(jB);
        }
        b();
        return true;
    }

    private void b(Canvas canvas) {
        int iHeight = this.f57997b.height();
        int iCenterY = this.f57997b.centerY() - (iHeight / 2);
        int i3 = iHeight + iCenterY;
        if (this.K <= 0) {
            Rect rect = this.f57997b;
            canvas.drawRect(rect.left, iCenterY, rect.right, i3, this.f58002h);
            return;
        }
        Rect rect2 = this.f57998c;
        int i4 = rect2.left;
        int i5 = rect2.right;
        int iMax = Math.max(Math.max(this.f57997b.left, i5), this.f57999d.right);
        int i6 = this.f57997b.right;
        if (iMax < i6) {
            canvas.drawRect(iMax, iCenterY, i6, i3, this.f58002h);
        }
        int iMax2 = Math.max(i4, this.f57999d.right);
        if (i5 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i5, i3, this.f58001g);
        }
        if (this.f57999d.width() > 0) {
            Rect rect3 = this.f57999d;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i3, this.f58000f);
        }
        if (this.N == 0) {
            return;
        }
        long[] jArr = (long[]) b1.a(this.O);
        boolean[] zArr = (boolean[]) b1.a(this.P);
        int i7 = this.f58010p / 2;
        for (int i8 = 0; i8 < this.N; i8++) {
            int iWidth = ((int) ((((long) this.f57997b.width()) * xp.b(jArr[i8], 0L, this.K)) / this.K)) - i7;
            Rect rect4 = this.f57997b;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.f58010p, Math.max(0, iWidth)), iCenterY, r10 + this.f58010p, i3, zArr[i8] ? this.f58004j : this.f58003i);
        }
    }

    private void a(float f3) {
        Rect rect = this.f57999d;
        Rect rect2 = this.f57997b;
        rect.right = xp.a((int) f3, rect2.left, rect2.right);
    }

    private Point a(MotionEvent motionEvent) {
        this.f58020z.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.f58020z;
    }

    private boolean a(float f3, float f4) {
        return this.f57996a.contains((int) f3, (int) f4);
    }

    private void a(Canvas canvas) {
        int i3;
        if (this.K <= 0) {
            return;
        }
        Rect rect = this.f57999d;
        int iA = xp.a(rect.right, rect.left, this.f57997b.right);
        int iCenterY = this.f57999d.centerY();
        if (this.f58006l == null) {
            if (!this.I && !isFocused()) {
                i3 = isEnabled() ? this.f58011q : this.f58012r;
            } else {
                i3 = this.f58013s;
            }
            canvas.drawCircle(iA, iCenterY, (int) ((i3 * this.G) / 2.0f), this.f58005k);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.G)) / 2;
        int intrinsicHeight = ((int) (this.f58006l.getIntrinsicHeight() * this.G)) / 2;
        this.f58006l.setBounds(iA - intrinsicWidth, iCenterY - intrinsicHeight, iA + intrinsicWidth, iCenterY + intrinsicHeight);
        this.f58006l.draw(canvas);
    }

    private void a(int i3, int i4) {
        Rect rect = this.E;
        if (rect != null && rect.width() == i3 && this.E.height() == i4) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i3, i4);
        this.E = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    private boolean a(Drawable drawable) {
        return xp.f65027a >= 23 && a(drawable, getLayoutDirection());
    }

    private static boolean a(Drawable drawable, int i3) {
        return xp.f65027a >= 23 && drawable.setLayoutDirection(i3);
    }
}
