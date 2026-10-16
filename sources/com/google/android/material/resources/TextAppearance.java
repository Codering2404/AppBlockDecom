package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class TextAppearance {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ColorStateList f81589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ColorStateList f81590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ColorStateList f81591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f81592d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f81593e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f81594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f81595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f81596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f81597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f81598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f81599k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f81600l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ColorStateList f81601m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f81602n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final int f81603o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f81604p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Typeface f81605q;

    public TextAppearance(Context context, int i3) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(i3, R.styleable.R7);
        l(typedArrayObtainStyledAttributes.getDimension(R.styleable.S7, 0.0f));
        k(MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.V7));
        this.f81589a = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.W7);
        this.f81590b = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.X7);
        this.f81593e = typedArrayObtainStyledAttributes.getInt(R.styleable.U7, 0);
        this.f81594f = typedArrayObtainStyledAttributes.getInt(R.styleable.T7, 1);
        int iG = MaterialResources.g(typedArrayObtainStyledAttributes, R.styleable.d8, R.styleable.c8);
        this.f81603o = typedArrayObtainStyledAttributes.getResourceId(iG, 0);
        this.f81592d = typedArrayObtainStyledAttributes.getString(iG);
        this.f81595g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.e8, false);
        this.f81591c = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.Y7);
        this.f81596h = typedArrayObtainStyledAttributes.getFloat(R.styleable.Z7, 0.0f);
        this.f81597i = typedArrayObtainStyledAttributes.getFloat(R.styleable.a8, 0.0f);
        this.f81598j = typedArrayObtainStyledAttributes.getFloat(R.styleable.b8, 0.0f);
        typedArrayObtainStyledAttributes.recycle();
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(i3, R.styleable.x5);
        int i4 = R.styleable.y5;
        this.f81599k = typedArrayObtainStyledAttributes2.hasValue(i4);
        this.f81600l = typedArrayObtainStyledAttributes2.getFloat(i4, 0.0f);
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void d() {
        String str;
        if (this.f81605q == null && (str = this.f81592d) != null) {
            this.f81605q = Typeface.create(str, this.f81593e);
        }
        if (this.f81605q == null) {
            int i3 = this.f81594f;
            if (i3 == 1) {
                this.f81605q = Typeface.SANS_SERIF;
            } else if (i3 == 2) {
                this.f81605q = Typeface.SERIF;
            } else if (i3 != 3) {
                this.f81605q = Typeface.DEFAULT;
            } else {
                this.f81605q = Typeface.MONOSPACE;
            }
            this.f81605q = Typeface.create(this.f81605q, this.f81593e);
        }
    }

    private boolean m(Context context) {
        if (TextAppearanceConfig.a()) {
            return true;
        }
        int i3 = this.f81603o;
        return (i3 != 0 ? ResourcesCompat.c(context, i3) : null) != null;
    }

    public Typeface e() {
        d();
        return this.f81605q;
    }

    public Typeface f(Context context) {
        if (this.f81604p) {
            return this.f81605q;
        }
        if (!context.isRestricted()) {
            try {
                Typeface typefaceI = ResourcesCompat.i(context, this.f81603o);
                this.f81605q = typefaceI;
                if (typefaceI != null) {
                    this.f81605q = Typeface.create(typefaceI, this.f81593e);
                }
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            } catch (Exception e3) {
                Log.d("TextAppearance", "Error loading font " + this.f81592d, e3);
            }
        }
        d();
        this.f81604p = true;
        return this.f81605q;
    }

    public void g(final Context context, final TextPaint textPaint, final TextAppearanceFontCallback textAppearanceFontCallback) {
        p(context, textPaint, e());
        h(context, new TextAppearanceFontCallback() { // from class: com.google.android.material.resources.TextAppearance.2
            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void a(int i3) {
                textAppearanceFontCallback.a(i3);
            }

            @Override // com.google.android.material.resources.TextAppearanceFontCallback
            public void b(Typeface typeface, boolean z2) {
                TextAppearance.this.p(context, textPaint, typeface);
                textAppearanceFontCallback.b(typeface, z2);
            }
        });
    }

    public void h(Context context, final TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            f(context);
        } else {
            d();
        }
        int i3 = this.f81603o;
        if (i3 == 0) {
            this.f81604p = true;
        }
        if (this.f81604p) {
            textAppearanceFontCallback.b(this.f81605q, true);
            return;
        }
        try {
            ResourcesCompat.k(context, i3, new ResourcesCompat.FontCallback() { // from class: com.google.android.material.resources.TextAppearance.1
                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrievalFailed(int i4) {
                    TextAppearance.this.f81604p = true;
                    textAppearanceFontCallback.a(i4);
                }

                @Override // androidx.core.content.res.ResourcesCompat.FontCallback
                public void onFontRetrieved(Typeface typeface) {
                    TextAppearance textAppearance = TextAppearance.this;
                    textAppearance.f81605q = Typeface.create(typeface, textAppearance.f81593e);
                    TextAppearance.this.f81604p = true;
                    textAppearanceFontCallback.b(TextAppearance.this.f81605q, false);
                }
            }, null);
        } catch (Resources.NotFoundException unused) {
            this.f81604p = true;
            textAppearanceFontCallback.a(1);
        } catch (Exception e3) {
            Log.d("TextAppearance", "Error loading font " + this.f81592d, e3);
            this.f81604p = true;
            textAppearanceFontCallback.a(-3);
        }
    }

    public ColorStateList i() {
        return this.f81601m;
    }

    public float j() {
        return this.f81602n;
    }

    public void k(ColorStateList colorStateList) {
        this.f81601m = colorStateList;
    }

    public void l(float f3) {
        this.f81602n = f3;
    }

    public void n(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        o(context, textPaint, textAppearanceFontCallback);
        ColorStateList colorStateList = this.f81601m;
        textPaint.setColor(colorStateList != null ? colorStateList.getColorForState(textPaint.drawableState, colorStateList.getDefaultColor()) : -16777216);
        float f3 = this.f81598j;
        float f4 = this.f81596h;
        float f5 = this.f81597i;
        ColorStateList colorStateList2 = this.f81591c;
        textPaint.setShadowLayer(f3, f4, f5, colorStateList2 != null ? colorStateList2.getColorForState(textPaint.drawableState, colorStateList2.getDefaultColor()) : 0);
    }

    public void o(Context context, TextPaint textPaint, TextAppearanceFontCallback textAppearanceFontCallback) {
        if (m(context)) {
            p(context, textPaint, f(context));
        } else {
            g(context, textPaint, textAppearanceFontCallback);
        }
    }

    public void p(Context context, TextPaint textPaint, Typeface typeface) {
        Typeface typefaceA = TypefaceUtils.a(context, typeface);
        if (typefaceA != null) {
            typeface = typefaceA;
        }
        textPaint.setTypeface(typeface);
        int i3 = this.f81593e & (~typeface.getStyle());
        textPaint.setFakeBoldText((i3 & 1) != 0);
        textPaint.setTextSkewX((i3 & 2) != 0 ? -0.25f : 0.0f);
        textPaint.setTextSize(this.f81602n);
        if (this.f81599k) {
            textPaint.setLetterSpacing(this.f81600l);
        }
    }
}
