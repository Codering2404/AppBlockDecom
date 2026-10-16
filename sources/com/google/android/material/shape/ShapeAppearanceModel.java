package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ShapeAppearanceModel {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CornerSize f81821m = new RelativeCornerSize(0.5f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CornerTreatment f81822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CornerTreatment f81823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    CornerTreatment f81824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    CornerTreatment f81825d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    CornerSize f81826e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    CornerSize f81827f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    CornerSize f81828g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    CornerSize f81829h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    EdgeTreatment f81830i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    EdgeTreatment f81831j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    EdgeTreatment f81832k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    EdgeTreatment f81833l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface CornerSizeUnaryOperator {
        CornerSize a(CornerSize cornerSize);
    }

    public static Builder a() {
        return new Builder();
    }

    public static Builder b(Context context, int i3, int i4) {
        return c(context, i3, i4, 0);
    }

    private static Builder c(Context context, int i3, int i4, int i5) {
        return d(context, i3, i4, new AbsoluteCornerSize(i5));
    }

    private static Builder d(Context context, int i3, int i4, CornerSize cornerSize) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
        if (i4 != 0) {
            contextThemeWrapper = new ContextThemeWrapper(contextThemeWrapper, i4);
        }
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(R.styleable.s6);
        try {
            int i5 = typedArrayObtainStyledAttributes.getInt(R.styleable.t6, 0);
            int i6 = typedArrayObtainStyledAttributes.getInt(R.styleable.w6, i5);
            int i7 = typedArrayObtainStyledAttributes.getInt(R.styleable.x6, i5);
            int i8 = typedArrayObtainStyledAttributes.getInt(R.styleable.v6, i5);
            int i9 = typedArrayObtainStyledAttributes.getInt(R.styleable.u6, i5);
            CornerSize cornerSizeM = m(typedArrayObtainStyledAttributes, R.styleable.y6, cornerSize);
            CornerSize cornerSizeM2 = m(typedArrayObtainStyledAttributes, R.styleable.B6, cornerSizeM);
            CornerSize cornerSizeM3 = m(typedArrayObtainStyledAttributes, R.styleable.C6, cornerSizeM);
            CornerSize cornerSizeM4 = m(typedArrayObtainStyledAttributes, R.styleable.A6, cornerSizeM);
            return new Builder().B(i6, cornerSizeM2).F(i7, cornerSizeM3).x(i8, cornerSizeM4).t(i9, m(typedArrayObtainStyledAttributes, R.styleable.z6, cornerSizeM));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static Builder e(Context context, AttributeSet attributeSet, int i3, int i4) {
        return f(context, attributeSet, i3, i4, 0);
    }

    public static Builder f(Context context, AttributeSet attributeSet, int i3, int i4, int i5) {
        return g(context, attributeSet, i3, i4, new AbsoluteCornerSize(i5));
    }

    public static Builder g(Context context, AttributeSet attributeSet, int i3, int i4, CornerSize cornerSize) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.t5, i3, i4);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.u5, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(R.styleable.v5, 0);
        typedArrayObtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cornerSize);
    }

    private static CornerSize m(TypedArray typedArray, int i3, CornerSize cornerSize) {
        TypedValue typedValuePeekValue = typedArray.peekValue(i3);
        if (typedValuePeekValue != null) {
            int i4 = typedValuePeekValue.type;
            if (i4 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i4 == 6) {
                return new RelativeCornerSize(typedValuePeekValue.getFraction(1.0f, 1.0f));
            }
        }
        return cornerSize;
    }

    public EdgeTreatment h() {
        return this.f81832k;
    }

    public CornerTreatment i() {
        return this.f81825d;
    }

    public CornerSize j() {
        return this.f81829h;
    }

    public CornerTreatment k() {
        return this.f81824c;
    }

    public CornerSize l() {
        return this.f81828g;
    }

    public EdgeTreatment n() {
        return this.f81833l;
    }

    public EdgeTreatment o() {
        return this.f81831j;
    }

    public EdgeTreatment p() {
        return this.f81830i;
    }

    public CornerTreatment q() {
        return this.f81822a;
    }

    public CornerSize r() {
        return this.f81826e;
    }

    public CornerTreatment s() {
        return this.f81823b;
    }

    public CornerSize t() {
        return this.f81827f;
    }

    public boolean u(RectF rectF) {
        boolean z2 = this.f81833l.getClass().equals(EdgeTreatment.class) && this.f81831j.getClass().equals(EdgeTreatment.class) && this.f81830i.getClass().equals(EdgeTreatment.class) && this.f81832k.getClass().equals(EdgeTreatment.class);
        float fA = this.f81826e.a(rectF);
        return z2 && ((this.f81827f.a(rectF) > fA ? 1 : (this.f81827f.a(rectF) == fA ? 0 : -1)) == 0 && (this.f81829h.a(rectF) > fA ? 1 : (this.f81829h.a(rectF) == fA ? 0 : -1)) == 0 && (this.f81828g.a(rectF) > fA ? 1 : (this.f81828g.a(rectF) == fA ? 0 : -1)) == 0) && ((this.f81823b instanceof RoundedCornerTreatment) && (this.f81822a instanceof RoundedCornerTreatment) && (this.f81824c instanceof RoundedCornerTreatment) && (this.f81825d instanceof RoundedCornerTreatment));
    }

    public Builder v() {
        return new Builder(this);
    }

    public ShapeAppearanceModel w(float f3) {
        return v().o(f3).m();
    }

    public ShapeAppearanceModel x(CornerSize cornerSize) {
        return v().p(cornerSize).m();
    }

    public ShapeAppearanceModel y(CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        return v().E(cornerSizeUnaryOperator.a(r())).I(cornerSizeUnaryOperator.a(t())).w(cornerSizeUnaryOperator.a(j())).A(cornerSizeUnaryOperator.a(l())).m();
    }

    private ShapeAppearanceModel(Builder builder) {
        this.f81822a = builder.f81834a;
        this.f81823b = builder.f81835b;
        this.f81824c = builder.f81836c;
        this.f81825d = builder.f81837d;
        this.f81826e = builder.f81838e;
        this.f81827f = builder.f81839f;
        this.f81828g = builder.f81840g;
        this.f81829h = builder.f81841h;
        this.f81830i = builder.f81842i;
        this.f81831j = builder.f81843j;
        this.f81832k = builder.f81844k;
        this.f81833l = builder.f81845l;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private CornerTreatment f81834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CornerTreatment f81835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CornerTreatment f81836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CornerTreatment f81837d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CornerSize f81838e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private CornerSize f81839f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CornerSize f81840g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CornerSize f81841h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private EdgeTreatment f81842i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private EdgeTreatment f81843j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private EdgeTreatment f81844k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private EdgeTreatment f81845l;

        public Builder() {
            this.f81834a = MaterialShapeUtils.b();
            this.f81835b = MaterialShapeUtils.b();
            this.f81836c = MaterialShapeUtils.b();
            this.f81837d = MaterialShapeUtils.b();
            this.f81838e = new AbsoluteCornerSize(0.0f);
            this.f81839f = new AbsoluteCornerSize(0.0f);
            this.f81840g = new AbsoluteCornerSize(0.0f);
            this.f81841h = new AbsoluteCornerSize(0.0f);
            this.f81842i = MaterialShapeUtils.c();
            this.f81843j = MaterialShapeUtils.c();
            this.f81844k = MaterialShapeUtils.c();
            this.f81845l = MaterialShapeUtils.c();
        }

        private static float n(CornerTreatment cornerTreatment) {
            if (cornerTreatment instanceof RoundedCornerTreatment) {
                return ((RoundedCornerTreatment) cornerTreatment).f81820a;
            }
            if (cornerTreatment instanceof CutCornerTreatment) {
                return ((CutCornerTreatment) cornerTreatment).f81759a;
            }
            return -1.0f;
        }

        public Builder A(CornerSize cornerSize) {
            this.f81840g = cornerSize;
            return this;
        }

        public Builder B(int i3, CornerSize cornerSize) {
            return C(MaterialShapeUtils.a(i3)).E(cornerSize);
        }

        public Builder C(CornerTreatment cornerTreatment) {
            this.f81834a = cornerTreatment;
            float fN = n(cornerTreatment);
            if (fN != -1.0f) {
                D(fN);
            }
            return this;
        }

        public Builder D(float f3) {
            this.f81838e = new AbsoluteCornerSize(f3);
            return this;
        }

        public Builder E(CornerSize cornerSize) {
            this.f81838e = cornerSize;
            return this;
        }

        public Builder F(int i3, CornerSize cornerSize) {
            return G(MaterialShapeUtils.a(i3)).I(cornerSize);
        }

        public Builder G(CornerTreatment cornerTreatment) {
            this.f81835b = cornerTreatment;
            float fN = n(cornerTreatment);
            if (fN != -1.0f) {
                H(fN);
            }
            return this;
        }

        public Builder H(float f3) {
            this.f81839f = new AbsoluteCornerSize(f3);
            return this;
        }

        public Builder I(CornerSize cornerSize) {
            this.f81839f = cornerSize;
            return this;
        }

        public ShapeAppearanceModel m() {
            return new ShapeAppearanceModel(this);
        }

        public Builder o(float f3) {
            return D(f3).H(f3).z(f3).v(f3);
        }

        public Builder p(CornerSize cornerSize) {
            return E(cornerSize).I(cornerSize).A(cornerSize).w(cornerSize);
        }

        public Builder q(int i3, float f3) {
            return r(MaterialShapeUtils.a(i3)).o(f3);
        }

        public Builder r(CornerTreatment cornerTreatment) {
            return C(cornerTreatment).G(cornerTreatment).y(cornerTreatment).u(cornerTreatment);
        }

        public Builder s(EdgeTreatment edgeTreatment) {
            this.f81844k = edgeTreatment;
            return this;
        }

        public Builder t(int i3, CornerSize cornerSize) {
            return u(MaterialShapeUtils.a(i3)).w(cornerSize);
        }

        public Builder u(CornerTreatment cornerTreatment) {
            this.f81837d = cornerTreatment;
            float fN = n(cornerTreatment);
            if (fN != -1.0f) {
                v(fN);
            }
            return this;
        }

        public Builder v(float f3) {
            this.f81841h = new AbsoluteCornerSize(f3);
            return this;
        }

        public Builder w(CornerSize cornerSize) {
            this.f81841h = cornerSize;
            return this;
        }

        public Builder x(int i3, CornerSize cornerSize) {
            return y(MaterialShapeUtils.a(i3)).A(cornerSize);
        }

        public Builder y(CornerTreatment cornerTreatment) {
            this.f81836c = cornerTreatment;
            float fN = n(cornerTreatment);
            if (fN != -1.0f) {
                z(fN);
            }
            return this;
        }

        public Builder z(float f3) {
            this.f81840g = new AbsoluteCornerSize(f3);
            return this;
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            this.f81834a = MaterialShapeUtils.b();
            this.f81835b = MaterialShapeUtils.b();
            this.f81836c = MaterialShapeUtils.b();
            this.f81837d = MaterialShapeUtils.b();
            this.f81838e = new AbsoluteCornerSize(0.0f);
            this.f81839f = new AbsoluteCornerSize(0.0f);
            this.f81840g = new AbsoluteCornerSize(0.0f);
            this.f81841h = new AbsoluteCornerSize(0.0f);
            this.f81842i = MaterialShapeUtils.c();
            this.f81843j = MaterialShapeUtils.c();
            this.f81844k = MaterialShapeUtils.c();
            this.f81845l = MaterialShapeUtils.c();
            this.f81834a = shapeAppearanceModel.f81822a;
            this.f81835b = shapeAppearanceModel.f81823b;
            this.f81836c = shapeAppearanceModel.f81824c;
            this.f81837d = shapeAppearanceModel.f81825d;
            this.f81838e = shapeAppearanceModel.f81826e;
            this.f81839f = shapeAppearanceModel.f81827f;
            this.f81840g = shapeAppearanceModel.f81828g;
            this.f81841h = shapeAppearanceModel.f81829h;
            this.f81842i = shapeAppearanceModel.f81830i;
            this.f81843j = shapeAppearanceModel.f81831j;
            this.f81844k = shapeAppearanceModel.f81832k;
            this.f81845l = shapeAppearanceModel.f81833l;
        }
    }

    public ShapeAppearanceModel() {
        this.f81822a = MaterialShapeUtils.b();
        this.f81823b = MaterialShapeUtils.b();
        this.f81824c = MaterialShapeUtils.b();
        this.f81825d = MaterialShapeUtils.b();
        this.f81826e = new AbsoluteCornerSize(0.0f);
        this.f81827f = new AbsoluteCornerSize(0.0f);
        this.f81828g = new AbsoluteCornerSize(0.0f);
        this.f81829h = new AbsoluteCornerSize(0.0f);
        this.f81830i = MaterialShapeUtils.c();
        this.f81831j = MaterialShapeUtils.c();
        this.f81832k = MaterialShapeUtils.c();
        this.f81833l = MaterialShapeUtils.c();
    }
}
