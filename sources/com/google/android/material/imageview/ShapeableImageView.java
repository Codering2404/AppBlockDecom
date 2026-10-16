package com.google.android.material.imageview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ShapeableImageView extends AppCompatImageView implements Shapeable {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final int f81100w = R.style.R;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ShapeAppearancePathProvider f81101d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RectF f81102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final RectF f81103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Paint f81104h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Paint f81105i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Path f81106j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ColorStateList f81107k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaterialShapeDrawable f81108l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ShapeAppearanceModel f81109m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f81110n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private Path f81111o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f81112p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f81113q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f81114r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private int f81115s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f81116t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f81117u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f81118v;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class OutlineProvider extends ViewOutlineProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f81119a = new Rect();

        OutlineProvider() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            if (ShapeableImageView.this.f81109m == null) {
                return;
            }
            if (ShapeableImageView.this.f81108l == null) {
                ShapeableImageView.this.f81108l = new MaterialShapeDrawable(ShapeableImageView.this.f81109m);
            }
            ShapeableImageView.this.f81102f.round(this.f81119a);
            ShapeableImageView.this.f81108l.setBounds(this.f81119a);
            ShapeableImageView.this.f81108l.getOutline(outline);
        }
    }

    public ShapeableImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g(Canvas canvas) {
        if (this.f81107k == null) {
            return;
        }
        this.f81104h.setStrokeWidth(this.f81110n);
        int colorForState = this.f81107k.getColorForState(getDrawableState(), this.f81107k.getDefaultColor());
        if (this.f81110n <= 0.0f || colorForState == 0) {
            return;
        }
        this.f81104h.setColor(colorForState);
        canvas.drawPath(this.f81106j, this.f81104h);
    }

    private boolean h() {
        return (this.f81116t == Integer.MIN_VALUE && this.f81117u == Integer.MIN_VALUE) ? false : true;
    }

    private boolean i() {
        return getLayoutDirection() == 1;
    }

    private void j(int i3, int i4) {
        this.f81102f.set(getPaddingLeft(), getPaddingTop(), i3 - getPaddingRight(), i4 - getPaddingBottom());
        this.f81101d.d(this.f81109m, 1.0f, this.f81102f, this.f81106j);
        this.f81111o.rewind();
        this.f81111o.addPath(this.f81106j);
        this.f81103g.set(0.0f, 0.0f, i3, i4);
        this.f81111o.addRect(this.f81103g, Path.Direction.CCW);
    }

    public int getContentPaddingBottom() {
        return this.f81115s;
    }

    public final int getContentPaddingEnd() {
        int i3 = this.f81117u;
        return i3 != Integer.MIN_VALUE ? i3 : i() ? this.f81112p : this.f81114r;
    }

    public int getContentPaddingLeft() {
        int i3;
        int i4;
        if (h()) {
            if (i() && (i4 = this.f81117u) != Integer.MIN_VALUE) {
                return i4;
            }
            if (!i() && (i3 = this.f81116t) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.f81112p;
    }

    public int getContentPaddingRight() {
        int i3;
        int i4;
        if (h()) {
            if (i() && (i4 = this.f81116t) != Integer.MIN_VALUE) {
                return i4;
            }
            if (!i() && (i3 = this.f81117u) != Integer.MIN_VALUE) {
                return i3;
            }
        }
        return this.f81114r;
    }

    public final int getContentPaddingStart() {
        int i3 = this.f81116t;
        return i3 != Integer.MIN_VALUE ? i3 : i() ? this.f81114r : this.f81112p;
    }

    public int getContentPaddingTop() {
        return this.f81113q;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return super.getPaddingBottom() - getContentPaddingBottom();
    }

    @Override // android.view.View
    public int getPaddingEnd() {
        return super.getPaddingEnd() - getContentPaddingEnd();
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return super.getPaddingLeft() - getContentPaddingLeft();
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return super.getPaddingRight() - getContentPaddingRight();
    }

    @Override // android.view.View
    public int getPaddingStart() {
        return super.getPaddingStart() - getContentPaddingStart();
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return super.getPaddingTop() - getContentPaddingTop();
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.f81109m;
    }

    public ColorStateList getStrokeColor() {
        return this.f81107k;
    }

    public float getStrokeWidth() {
        return this.f81110n;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f81111o, this.f81105i);
        g(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (!this.f81118v && isLayoutDirectionResolved()) {
            this.f81118v = true;
            if (isPaddingRelative() || h()) {
                setPaddingRelative(super.getPaddingStart(), super.getPaddingTop(), super.getPaddingEnd(), super.getPaddingBottom());
            } else {
                setPadding(super.getPaddingLeft(), super.getPaddingTop(), super.getPaddingRight(), super.getPaddingBottom());
            }
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        j(i3, i4);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i4, int i5, int i6) {
        super.setPadding(i3 + getContentPaddingLeft(), i4 + getContentPaddingTop(), i5 + getContentPaddingRight(), i6 + getContentPaddingBottom());
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i4, int i5, int i6) {
        super.setPaddingRelative(i3 + getContentPaddingStart(), i4 + getContentPaddingTop(), i5 + getContentPaddingEnd(), i6 + getContentPaddingBottom());
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.f81109m = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f81108l;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        j(getWidth(), getHeight());
        invalidate();
        invalidateOutline();
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f81107k = colorStateList;
        invalidate();
    }

    public void setStrokeColorResource(int i3) {
        setStrokeColor(AppCompatResources.a(getContext(), i3));
    }

    public void setStrokeWidth(float f3) {
        if (this.f81110n != f3) {
            this.f81110n = f3;
            invalidate();
        }
    }

    public void setStrokeWidthResource(int i3) {
        setStrokeWidth(getResources().getDimensionPixelSize(i3));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ShapeableImageView(Context context, AttributeSet attributeSet, int i3) {
        int i4 = f81100w;
        super(MaterialThemeOverlay.c(context, attributeSet, i3, i4), attributeSet, i3);
        this.f81101d = ShapeAppearancePathProvider.k();
        this.f81106j = new Path();
        this.f81118v = false;
        Context context2 = getContext();
        Paint paint = new Paint();
        this.f81105i = paint;
        paint.setAntiAlias(true);
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f81102f = new RectF();
        this.f81103g = new RectF();
        this.f81111o = new Path();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R.styleable.D6, i3, i4);
        setLayerType(2, null);
        this.f81107k = MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.L6);
        this.f81110n = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.M6, 0);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.E6, 0);
        this.f81112p = dimensionPixelSize;
        this.f81113q = dimensionPixelSize;
        this.f81114r = dimensionPixelSize;
        this.f81115s = dimensionPixelSize;
        this.f81112p = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.H6, dimensionPixelSize);
        this.f81113q = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.K6, dimensionPixelSize);
        this.f81114r = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.I6, dimensionPixelSize);
        this.f81115s = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.F6, dimensionPixelSize);
        this.f81116t = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.J6, Integer.MIN_VALUE);
        this.f81117u = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.G6, Integer.MIN_VALUE);
        typedArrayObtainStyledAttributes.recycle();
        Paint paint2 = new Paint();
        this.f81104h = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setAntiAlias(true);
        this.f81109m = ShapeAppearanceModel.e(context2, attributeSet, i3, i4).m();
        setOutlineProvider(new OutlineProvider());
    }
}
