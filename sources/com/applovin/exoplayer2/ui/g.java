package com.applovin.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.applovin.impl.a5;
import com.applovin.impl.b1;
import com.applovin.impl.x2;
import com.applovin.impl.xp;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class g {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f58092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f58093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f58094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f58095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f58096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextPaint f58097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Paint f58098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f58099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f58100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Layout.Alignment f58101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bitmap f58102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f58103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f58104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f58105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f58106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f58107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private float f58108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private float f58109r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f58110s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f58111t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f58112u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f58113v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f58114w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f58115x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private float f58116y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private float f58117z;

    public g(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f58096e = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f58095d = typedArrayObtainStyledAttributes.getFloat(1, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
        float fRound = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f58092a = fRound;
        this.f58093b = fRound;
        this.f58094c = fRound;
        TextPaint textPaint = new TextPaint();
        this.f58097f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f58098g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f58099h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() {
        /*
            Method dump skipped, instruction units count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.g.b():void");
    }

    public void a(a5 a5Var, x2 x2Var, float f3, float f4, float f5, Canvas canvas, int i3, int i4, int i5, int i6) {
        int i7;
        boolean z2 = a5Var.f58176d == null;
        if (!z2) {
            i7 = -16777216;
        } else if (TextUtils.isEmpty(a5Var.f58173a)) {
            return;
        } else {
            i7 = a5Var.f58184m ? a5Var.f58185n : x2Var.f64789c;
        }
        if (a(this.f58100i, a5Var.f58173a) && xp.a(this.f58101j, a5Var.f58174b) && this.f58102k == a5Var.f58176d && this.f58103l == a5Var.f58177f && this.f58104m == a5Var.f58178g && xp.a(Integer.valueOf(this.f58105n), Integer.valueOf(a5Var.f58179h)) && this.f58106o == a5Var.f58180i && xp.a(Integer.valueOf(this.f58107p), Integer.valueOf(a5Var.f58181j)) && this.f58108q == a5Var.f58182k && this.f58109r == a5Var.f58183l && this.f58110s == x2Var.f64787a && this.f58111t == x2Var.f64788b && this.f58112u == i7 && this.f58114w == x2Var.f64790d && this.f58113v == x2Var.f64791e && xp.a(this.f58097f.getTypeface(), x2Var.f64792f) && this.f58115x == f3 && this.f58116y == f4 && this.f58117z == f5 && this.A == i3 && this.B == i4 && this.C == i5 && this.D == i6) {
            a(canvas, z2);
            return;
        }
        this.f58100i = a5Var.f58173a;
        this.f58101j = a5Var.f58174b;
        this.f58102k = a5Var.f58176d;
        this.f58103l = a5Var.f58177f;
        this.f58104m = a5Var.f58178g;
        this.f58105n = a5Var.f58179h;
        this.f58106o = a5Var.f58180i;
        this.f58107p = a5Var.f58181j;
        this.f58108q = a5Var.f58182k;
        this.f58109r = a5Var.f58183l;
        this.f58110s = x2Var.f64787a;
        this.f58111t = x2Var.f64788b;
        this.f58112u = i7;
        this.f58114w = x2Var.f64790d;
        this.f58113v = x2Var.f64791e;
        this.f58097f.setTypeface(x2Var.f64792f);
        this.f58115x = f3;
        this.f58116y = f4;
        this.f58117z = f5;
        this.A = i3;
        this.B = i4;
        this.C = i5;
        this.D = i6;
        if (z2) {
            b1.a(this.f58100i);
            b();
        } else {
            b1.a(this.f58102k);
            a();
        }
        a(canvas, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f58102k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f58106o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f58103l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f58108q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f58109r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L3f
        L2e:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L3f:
            int r3 = r7.f58107p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L48
            float r3 = (float) r1
        L46:
            float r2 = r2 - r3
            goto L4e
        L48:
            if (r3 != r5) goto L4e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L46
        L4e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f58105n
            if (r3 != r6) goto L59
            float r3 = (float) r0
        L57:
            float r4 = r4 - r3
            goto L5f
        L59:
            if (r3 != r5) goto L5f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L57
        L5f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.ui.g.a():void");
    }

    private void a(Canvas canvas, boolean z2) {
        if (z2) {
            b(canvas);
            return;
        }
        b1.a(this.J);
        b1.a(this.f58102k);
        a(canvas);
    }

    private void a(Canvas canvas) {
        canvas.drawBitmap(this.f58102k, (Rect) null, this.J, this.f58099h);
    }

    private void b(Canvas canvas) {
        Canvas canvas2;
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f58112u) > 0) {
            this.f58098g.setColor(this.f58112u);
            canvas2 = canvas;
            canvas2.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f58098g);
        } else {
            canvas2 = canvas;
        }
        int i3 = this.f58114w;
        if (i3 == 1) {
            this.f58097f.setStrokeJoin(Paint.Join.ROUND);
            this.f58097f.setStrokeWidth(this.f58092a);
            this.f58097f.setColor(this.f58113v);
            this.f58097f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas2);
        } else if (i3 == 2) {
            TextPaint textPaint = this.f58097f;
            float f3 = this.f58093b;
            float f4 = this.f58094c;
            textPaint.setShadowLayer(f3, f4, f4, this.f58113v);
        } else if (i3 == 3 || i3 == 4) {
            boolean z2 = i3 == 3;
            int i4 = z2 ? -1 : this.f58113v;
            int i5 = z2 ? this.f58113v : -1;
            float f5 = this.f58093b / 2.0f;
            this.f58097f.setColor(this.f58110s);
            this.f58097f.setStyle(Paint.Style.FILL);
            float f6 = -f5;
            this.f58097f.setShadowLayer(this.f58093b, f6, f6, i4);
            staticLayout2.draw(canvas2);
            this.f58097f.setShadowLayer(this.f58093b, f5, f5, i5);
        }
        this.f58097f.setColor(this.f58110s);
        this.f58097f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas2);
        this.f58097f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas2.restoreToCount(iSave);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        if (charSequence != charSequence2) {
            return charSequence != null && charSequence.equals(charSequence2);
        }
        return true;
    }
}
