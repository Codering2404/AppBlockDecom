package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class BadgeState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final State f80005a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final State f80006b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final float f80007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final float f80008d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final float f80009e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final float f80010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final float f80011g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final float f80012h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final int f80013i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final int f80014j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f80015k;

    BadgeState(Context context, int i3, int i4, int i5, State state) {
        State state2 = new State();
        this.f80006b = state2;
        state = state == null ? new State() : state;
        if (i3 != 0) {
            state.f80016a = i3;
        }
        TypedArray typedArrayA = a(context, state.f80016a, i4, i5);
        Resources resources = context.getResources();
        this.f80007c = typedArrayA.getDimensionPixelSize(R.styleable.K, -1);
        this.f80013i = context.getResources().getDimensionPixelSize(R.dimen.f79565f0);
        this.f80014j = context.getResources().getDimensionPixelSize(R.dimen.f79569h0);
        this.f80008d = typedArrayA.getDimensionPixelSize(R.styleable.U, -1);
        int i6 = R.styleable.S;
        int i7 = R.dimen.f79590s;
        this.f80009e = typedArrayA.getDimension(i6, resources.getDimension(i7));
        int i8 = R.styleable.X;
        int i9 = R.dimen.f79592t;
        this.f80011g = typedArrayA.getDimension(i8, resources.getDimension(i9));
        this.f80010f = typedArrayA.getDimension(R.styleable.J, resources.getDimension(i7));
        this.f80012h = typedArrayA.getDimension(R.styleable.T, resources.getDimension(i9));
        boolean z2 = true;
        this.f80015k = typedArrayA.getInt(R.styleable.f79771e0, 1);
        state2.f80024j = state.f80024j == -2 ? 255 : state.f80024j;
        if (state.f80026l != -2) {
            state2.f80026l = state.f80026l;
        } else {
            int i10 = R.styleable.f79767d0;
            if (typedArrayA.hasValue(i10)) {
                state2.f80026l = typedArrayA.getInt(i10, 0);
            } else {
                state2.f80026l = -1;
            }
        }
        if (state.f80025k != null) {
            state2.f80025k = state.f80025k;
        } else {
            int i11 = R.styleable.N;
            if (typedArrayA.hasValue(i11)) {
                state2.f80025k = typedArrayA.getString(i11);
            }
        }
        state2.f80030p = state.f80030p;
        state2.f80031q = state.f80031q == null ? context.getString(R.string.f79723v) : state.f80031q;
        state2.f80032r = state.f80032r == 0 ? R.plurals.f79696a : state.f80032r;
        state2.f80033s = state.f80033s == 0 ? R.string.A : state.f80033s;
        if (state.f80035u != null && !state.f80035u.booleanValue()) {
            z2 = false;
        }
        state2.f80035u = Boolean.valueOf(z2);
        state2.f80027m = state.f80027m == -2 ? typedArrayA.getInt(R.styleable.f79759b0, -2) : state.f80027m;
        state2.f80028n = state.f80028n == -2 ? typedArrayA.getInt(R.styleable.f79763c0, -2) : state.f80028n;
        state2.f80020f = Integer.valueOf(state.f80020f == null ? typedArrayA.getResourceId(R.styleable.L, R.style.f79733f) : state.f80020f.intValue());
        state2.f80021g = Integer.valueOf(state.f80021g == null ? typedArrayA.getResourceId(R.styleable.M, 0) : state.f80021g.intValue());
        state2.f80022h = Integer.valueOf(state.f80022h == null ? typedArrayA.getResourceId(R.styleable.V, R.style.f79733f) : state.f80022h.intValue());
        state2.f80023i = Integer.valueOf(state.f80023i == null ? typedArrayA.getResourceId(R.styleable.W, 0) : state.f80023i.intValue());
        state2.f80017b = Integer.valueOf(state.f80017b == null ? H(context, typedArrayA, R.styleable.H) : state.f80017b.intValue());
        state2.f80019d = Integer.valueOf(state.f80019d == null ? typedArrayA.getResourceId(R.styleable.O, R.style.f79737j) : state.f80019d.intValue());
        if (state.f80018c != null) {
            state2.f80018c = state.f80018c;
        } else {
            int i12 = R.styleable.P;
            if (typedArrayA.hasValue(i12)) {
                state2.f80018c = Integer.valueOf(H(context, typedArrayA, i12));
            } else {
                state2.f80018c = Integer.valueOf(new TextAppearance(context, state2.f80019d.intValue()).i().getDefaultColor());
            }
        }
        state2.f80034t = Integer.valueOf(state.f80034t == null ? typedArrayA.getInt(R.styleable.I, 8388661) : state.f80034t.intValue());
        state2.f80036v = Integer.valueOf(state.f80036v == null ? typedArrayA.getDimensionPixelSize(R.styleable.R, resources.getDimensionPixelSize(R.dimen.f79567g0)) : state.f80036v.intValue());
        state2.f80037w = Integer.valueOf(state.f80037w == null ? typedArrayA.getDimensionPixelSize(R.styleable.Q, resources.getDimensionPixelSize(R.dimen.f79594u)) : state.f80037w.intValue());
        state2.f80038x = Integer.valueOf(state.f80038x == null ? typedArrayA.getDimensionPixelOffset(R.styleable.Y, 0) : state.f80038x.intValue());
        state2.f80039y = Integer.valueOf(state.f80039y == null ? typedArrayA.getDimensionPixelOffset(R.styleable.f79775f0, 0) : state.f80039y.intValue());
        state2.f80040z = Integer.valueOf(state.f80040z == null ? typedArrayA.getDimensionPixelOffset(R.styleable.Z, state2.f80038x.intValue()) : state.f80040z.intValue());
        state2.A = Integer.valueOf(state.A == null ? typedArrayA.getDimensionPixelOffset(R.styleable.f79779g0, state2.f80039y.intValue()) : state.A.intValue());
        state2.D = Integer.valueOf(state.D == null ? typedArrayA.getDimensionPixelOffset(R.styleable.f79755a0, 0) : state.D.intValue());
        state2.B = Integer.valueOf(state.B == null ? 0 : state.B.intValue());
        state2.C = Integer.valueOf(state.C == null ? 0 : state.C.intValue());
        state2.E = Boolean.valueOf(state.E == null ? typedArrayA.getBoolean(R.styleable.G, false) : state.E.booleanValue());
        typedArrayA.recycle();
        if (state.f80029o == null) {
            state2.f80029o = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.f80029o = state.f80029o;
        }
        this.f80005a = state;
    }

    private static int H(Context context, TypedArray typedArray, int i3) {
        return MaterialResources.a(context, typedArray, i3).getDefaultColor();
    }

    private TypedArray a(Context context, int i3, int i4, int i5) {
        AttributeSet attributeSetK;
        int styleAttribute;
        if (i3 != 0) {
            attributeSetK = DrawableUtils.k(context, i3, "badge");
            styleAttribute = attributeSetK.getStyleAttribute();
        } else {
            attributeSetK = null;
            styleAttribute = 0;
        }
        return ThemeEnforcement.i(context, attributeSetK, R.styleable.F, i4, styleAttribute == 0 ? i5 : styleAttribute, new int[0]);
    }

    int A() {
        return this.f80006b.f80019d.intValue();
    }

    int B() {
        return this.f80006b.A.intValue();
    }

    int C() {
        return this.f80006b.f80039y.intValue();
    }

    boolean D() {
        return this.f80006b.f80026l != -1;
    }

    boolean E() {
        return this.f80006b.f80025k != null;
    }

    boolean F() {
        return this.f80006b.E.booleanValue();
    }

    boolean G() {
        return this.f80006b.f80035u.booleanValue();
    }

    void I(int i3) {
        this.f80005a.B = Integer.valueOf(i3);
        this.f80006b.B = Integer.valueOf(i3);
    }

    void J(int i3) {
        this.f80005a.C = Integer.valueOf(i3);
        this.f80006b.C = Integer.valueOf(i3);
    }

    void K(int i3) {
        this.f80005a.f80024j = i3;
        this.f80006b.f80024j = i3;
    }

    int b() {
        return this.f80006b.B.intValue();
    }

    int c() {
        return this.f80006b.C.intValue();
    }

    int d() {
        return this.f80006b.f80024j;
    }

    int e() {
        return this.f80006b.f80017b.intValue();
    }

    int f() {
        return this.f80006b.f80034t.intValue();
    }

    int g() {
        return this.f80006b.f80036v.intValue();
    }

    int h() {
        return this.f80006b.f80021g.intValue();
    }

    int i() {
        return this.f80006b.f80020f.intValue();
    }

    int j() {
        return this.f80006b.f80018c.intValue();
    }

    int k() {
        return this.f80006b.f80037w.intValue();
    }

    int l() {
        return this.f80006b.f80023i.intValue();
    }

    int m() {
        return this.f80006b.f80022h.intValue();
    }

    int n() {
        return this.f80006b.f80033s;
    }

    CharSequence o() {
        return this.f80006b.f80030p;
    }

    CharSequence p() {
        return this.f80006b.f80031q;
    }

    int q() {
        return this.f80006b.f80032r;
    }

    int r() {
        return this.f80006b.f80040z.intValue();
    }

    int s() {
        return this.f80006b.f80038x.intValue();
    }

    int t() {
        return this.f80006b.D.intValue();
    }

    int u() {
        return this.f80006b.f80027m;
    }

    int v() {
        return this.f80006b.f80028n;
    }

    int w() {
        return this.f80006b.f80026l;
    }

    Locale x() {
        return this.f80006b.f80029o;
    }

    State y() {
        return this.f80005a;
    }

    String z() {
        return this.f80006b.f80025k;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator<State>() { // from class: com.google.android.material.badge.BadgeState.State.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i3) {
                return new State[i3];
            }
        };
        private Integer A;
        private Integer B;
        private Integer C;
        private Integer D;
        private Boolean E;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f80016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f80017b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f80018c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Integer f80019d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Integer f80020f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Integer f80021g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Integer f80022h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Integer f80023i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f80024j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f80025k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f80026l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f80027m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f80028n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private Locale f80029o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private CharSequence f80030p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private CharSequence f80031q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private int f80032r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f80033s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private Integer f80034t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private Boolean f80035u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private Integer f80036v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private Integer f80037w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private Integer f80038x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private Integer f80039y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private Integer f80040z;

        public State() {
            this.f80024j = 255;
            this.f80026l = -2;
            this.f80027m = -2;
            this.f80028n = -2;
            this.f80035u = Boolean.TRUE;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f80016a);
            parcel.writeSerializable(this.f80017b);
            parcel.writeSerializable(this.f80018c);
            parcel.writeSerializable(this.f80019d);
            parcel.writeSerializable(this.f80020f);
            parcel.writeSerializable(this.f80021g);
            parcel.writeSerializable(this.f80022h);
            parcel.writeSerializable(this.f80023i);
            parcel.writeInt(this.f80024j);
            parcel.writeString(this.f80025k);
            parcel.writeInt(this.f80026l);
            parcel.writeInt(this.f80027m);
            parcel.writeInt(this.f80028n);
            CharSequence charSequence = this.f80030p;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            CharSequence charSequence2 = this.f80031q;
            parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
            parcel.writeInt(this.f80032r);
            parcel.writeSerializable(this.f80034t);
            parcel.writeSerializable(this.f80036v);
            parcel.writeSerializable(this.f80037w);
            parcel.writeSerializable(this.f80038x);
            parcel.writeSerializable(this.f80039y);
            parcel.writeSerializable(this.f80040z);
            parcel.writeSerializable(this.A);
            parcel.writeSerializable(this.D);
            parcel.writeSerializable(this.B);
            parcel.writeSerializable(this.C);
            parcel.writeSerializable(this.f80035u);
            parcel.writeSerializable(this.f80029o);
            parcel.writeSerializable(this.E);
        }

        State(Parcel parcel) {
            this.f80024j = 255;
            this.f80026l = -2;
            this.f80027m = -2;
            this.f80028n = -2;
            this.f80035u = Boolean.TRUE;
            this.f80016a = parcel.readInt();
            this.f80017b = (Integer) parcel.readSerializable();
            this.f80018c = (Integer) parcel.readSerializable();
            this.f80019d = (Integer) parcel.readSerializable();
            this.f80020f = (Integer) parcel.readSerializable();
            this.f80021g = (Integer) parcel.readSerializable();
            this.f80022h = (Integer) parcel.readSerializable();
            this.f80023i = (Integer) parcel.readSerializable();
            this.f80024j = parcel.readInt();
            this.f80025k = parcel.readString();
            this.f80026l = parcel.readInt();
            this.f80027m = parcel.readInt();
            this.f80028n = parcel.readInt();
            this.f80030p = parcel.readString();
            this.f80031q = parcel.readString();
            this.f80032r = parcel.readInt();
            this.f80034t = (Integer) parcel.readSerializable();
            this.f80036v = (Integer) parcel.readSerializable();
            this.f80037w = (Integer) parcel.readSerializable();
            this.f80038x = (Integer) parcel.readSerializable();
            this.f80039y = (Integer) parcel.readSerializable();
            this.f80040z = (Integer) parcel.readSerializable();
            this.A = (Integer) parcel.readSerializable();
            this.D = (Integer) parcel.readSerializable();
            this.B = (Integer) parcel.readSerializable();
            this.C = (Integer) parcel.readSerializable();
            this.f80035u = (Boolean) parcel.readSerializable();
            this.f80029o = (Locale) parcel.readSerializable();
            this.E = (Boolean) parcel.readSerializable();
        }
    }
}
