package androidx.appcompat.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton implements EmojiCompatConfigurationView {
    private static final Property T = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: androidx.appcompat.widget.SwitchCompat.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.A);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f3) {
            switchCompat.setThumbPosition(f3.floatValue());
        }
    };
    private static final int[] U = {R.attr.state_checked};
    float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private boolean I;
    private final TextPaint J;
    private ColorStateList K;
    private Layout L;
    private Layout M;
    private TransformationMethod N;
    ObjectAnimator O;
    private final AppCompatTextHelper P;
    private AppCompatEmojiTextHelper Q;
    private EmojiCompatInitCallback R;
    private final Rect S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f2187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ColorStateList f2188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f2189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f2190d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Drawable f2192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ColorStateList f2193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private PorterDuff.Mode f2194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f2195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f2196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f2197l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f2198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f2199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f2200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private CharSequence f2201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CharSequence f2202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private CharSequence f2203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private CharSequence f2204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f2205t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f2206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f2207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private float f2208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private float f2209x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private VelocityTracker f2210y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f2211z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class EmojiCompatInitCallback extends EmojiCompat.InitCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Reference f2212a;

        EmojiCompatInitCallback(SwitchCompat switchCompat) {
            this.f2212a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void a(Throwable th) {
            SwitchCompat switchCompat = (SwitchCompat) this.f2212a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void b() {
            SwitchCompat switchCompat = (SwitchCompat) this.f2212a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f2213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2215c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2216d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f2217e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f2218f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f2219g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f2220h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f2221i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f2222j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f2223k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f2224l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f2225m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f2226n;

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void readProperties(SwitchCompat switchCompat, PropertyReader propertyReader) {
            if (!this.f2213a) {
                throw c.a();
            }
            propertyReader.readObject(this.f2214b, switchCompat.getTextOff());
            propertyReader.readObject(this.f2215c, switchCompat.getTextOn());
            propertyReader.readObject(this.f2216d, switchCompat.getThumbDrawable());
            propertyReader.readBoolean(this.f2217e, switchCompat.getShowText());
            propertyReader.readBoolean(this.f2218f, switchCompat.getSplitTrack());
            propertyReader.readInt(this.f2219g, switchCompat.getSwitchMinWidth());
            propertyReader.readInt(this.f2220h, switchCompat.getSwitchPadding());
            propertyReader.readInt(this.f2221i, switchCompat.getThumbTextPadding());
            propertyReader.readObject(this.f2222j, switchCompat.getThumbTintList());
            propertyReader.readObject(this.f2223k, switchCompat.getThumbTintMode());
            propertyReader.readObject(this.f2224l, switchCompat.getTrackDrawable());
            propertyReader.readObject(this.f2225m, switchCompat.getTrackTintList());
            propertyReader.readObject(this.f2226n, switchCompat.getTrackTintMode());
        }

        public void mapProperties(PropertyMapper propertyMapper) {
            this.f2214b = propertyMapper.mapObject("textOff", R.attr.textOff);
            this.f2215c = propertyMapper.mapObject("textOn", R.attr.textOn);
            this.f2216d = propertyMapper.mapObject("thumb", R.attr.thumb);
            this.f2217e = propertyMapper.mapBoolean("showText", androidx.appcompat.R.attr.f668s0);
            this.f2218f = propertyMapper.mapBoolean("splitTrack", androidx.appcompat.R.attr.f672u0);
            this.f2219g = propertyMapper.mapInt("switchMinWidth", androidx.appcompat.R.attr.f676w0);
            this.f2220h = propertyMapper.mapInt("switchPadding", androidx.appcompat.R.attr.f678x0);
            this.f2221i = propertyMapper.mapInt("thumbTextPadding", androidx.appcompat.R.attr.A0);
            this.f2222j = propertyMapper.mapObject("thumbTint", androidx.appcompat.R.attr.B0);
            this.f2223k = propertyMapper.mapObject("thumbTintMode", androidx.appcompat.R.attr.C0);
            this.f2224l = propertyMapper.mapObject("track", androidx.appcompat.R.attr.M0);
            this.f2225m = propertyMapper.mapObject("trackTint", androidx.appcompat.R.attr.N0);
            this.f2226n = propertyMapper.mapObject("trackTintMode", androidx.appcompat.R.attr.O0);
            this.f2213a = true;
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.appcompat.R.attr.f680y0);
    }

    private void a(boolean z2) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<SwitchCompat, Float>) T, z2 ? 1.0f : 0.0f);
        this.O = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(250L);
        this.O.setAutoCancel(true);
        this.O.start();
    }

    private void b() {
        Drawable drawable = this.f2187a;
        if (drawable != null) {
            if (this.f2190d || this.f2191f) {
                Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
                this.f2187a = drawableMutate;
                if (this.f2190d) {
                    DrawableCompat.o(drawableMutate, this.f2188b);
                }
                if (this.f2191f) {
                    DrawableCompat.p(this.f2187a, this.f2189c);
                }
                if (this.f2187a.isStateful()) {
                    this.f2187a.setState(getDrawableState());
                }
            }
        }
    }

    private void c() {
        Drawable drawable = this.f2192g;
        if (drawable != null) {
            if (this.f2195j || this.f2196k) {
                Drawable drawableMutate = DrawableCompat.r(drawable).mutate();
                this.f2192g = drawableMutate;
                if (this.f2195j) {
                    DrawableCompat.o(drawableMutate, this.f2193h);
                }
                if (this.f2196k) {
                    DrawableCompat.p(this.f2192g, this.f2194i);
                }
                if (this.f2192g.isStateful()) {
                    this.f2192g.setState(getDrawableState());
                }
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    private static float f(float f3, float f4, float f5) {
        return f3 < f4 ? f4 : f3 > f5 ? f5 : f3;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod transformationMethodF = getEmojiTextViewHelper().f(this.N);
        return transformationMethodF != null ? transformationMethodF.getTransformation(charSequence, this) : charSequence;
    }

    private AppCompatEmojiTextHelper getEmojiTextViewHelper() {
        if (this.Q == null) {
            this.Q = new AppCompatEmojiTextHelper(this);
        }
        return this.Q;
    }

    private boolean getTargetCheckedState() {
        return this.A > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((ViewUtils.b(this) ? 1.0f - this.A : this.A) * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable = this.f2192g;
        if (drawable == null) {
            return 0;
        }
        Rect rect = this.S;
        drawable.getPadding(rect);
        Drawable drawable2 = this.f2187a;
        Rect rectD = drawable2 != null ? DrawableUtils.d(drawable2) : DrawableUtils.f1951c;
        return ((((this.B - this.D) - rect.left) - rect.right) - rectD.left) - rectD.right;
    }

    private boolean h(float f3, float f4) {
        if (this.f2187a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2187a.getPadding(this.S);
        int i3 = this.F;
        int i4 = this.f2207v;
        int i5 = i3 - i4;
        int i6 = (this.E + thumbOffset) - i4;
        int i7 = this.D + i6;
        Rect rect = this.S;
        return f3 > ((float) i6) && f3 < ((float) (((i7 + rect.left) + rect.right) + i4)) && f4 > ((float) i5) && f4 < ((float) (this.H + i4));
    }

    private Layout i(CharSequence charSequence) {
        return new StaticLayout(charSequence, this.J, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, r2)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2203r;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.f784d);
            }
            ViewCompat.H0(this, string);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence string = this.f2201p;
            if (string == null) {
                string = getResources().getString(androidx.appcompat.R.string.f785e);
            }
            ViewCompat.H0(this, string);
        }
    }

    private void o(int i3, int i4) {
        n(i3 != 1 ? i3 != 2 ? i3 != 3 ? null : Typeface.MONOSPACE : Typeface.SERIF : Typeface.SANS_SERIF, i4);
    }

    private void p() {
        if (this.R == null && this.Q.b() && EmojiCompat.k()) {
            EmojiCompat emojiCompatC = EmojiCompat.c();
            int iG = emojiCompatC.g();
            if (iG == 3 || iG == 0) {
                EmojiCompatInitCallback emojiCompatInitCallback = new EmojiCompatInitCallback(this);
                this.R = emojiCompatInitCallback;
                emojiCompatC.v(emojiCompatInitCallback);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        this.f2206u = 0;
        boolean targetCheckedState = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.f2210y.computeCurrentVelocity(1000);
            float xVelocity = this.f2210y.getXVelocity();
            if (Math.abs(xVelocity) <= this.f2211z) {
                targetCheckedState = getTargetCheckedState();
            } else if (!ViewUtils.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                targetCheckedState = false;
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f2203r = charSequence;
        this.f2204s = g(charSequence);
        this.M = null;
        if (this.f2205t) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f2201p = charSequence;
        this.f2202q = g(charSequence);
        this.L = null;
        if (this.f2205t) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i3;
        int i4;
        Rect rect = this.S;
        int i5 = this.E;
        int i6 = this.F;
        int i7 = this.G;
        int i8 = this.H;
        int thumbOffset = getThumbOffset() + i5;
        Drawable drawable = this.f2187a;
        Rect rectD = drawable != null ? DrawableUtils.d(drawable) : DrawableUtils.f1951c;
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            int i9 = rect.left;
            thumbOffset += i9;
            if (rectD != null) {
                int i10 = rectD.left;
                if (i10 > i9) {
                    i5 += i10 - i9;
                }
                int i11 = rectD.top;
                int i12 = rect.top;
                i3 = i11 > i12 ? (i11 - i12) + i6 : i6;
                int i13 = rectD.right;
                int i14 = rect.right;
                if (i13 > i14) {
                    i7 -= i13 - i14;
                }
                int i15 = rectD.bottom;
                int i16 = rect.bottom;
                if (i15 > i16) {
                    i4 = i8 - (i15 - i16);
                }
                this.f2192g.setBounds(i5, i3, i7, i4);
            } else {
                i3 = i6;
            }
            i4 = i8;
            this.f2192g.setBounds(i5, i3, i7, i4);
        }
        Drawable drawable3 = this.f2187a;
        if (drawable3 != null) {
            drawable3.getPadding(rect);
            int i17 = thumbOffset - rect.left;
            int i18 = thumbOffset + this.D + rect.right;
            this.f2187a.setBounds(i17, i6, i18, i8);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.l(background, i17, i6, i18, i8);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f3, float f4) {
        super.drawableHotspotChanged(f3, f4);
        Drawable drawable = this.f2187a;
        if (drawable != null) {
            DrawableCompat.k(drawable, f3, f4);
        }
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null) {
            DrawableCompat.k(drawable2, f3, f4);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f2187a;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!ViewUtils.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2199n : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (ViewUtils.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.B;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2199n : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return TextViewCompat.q(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f2205t;
    }

    public boolean getSplitTrack() {
        return this.f2200o;
    }

    public int getSwitchMinWidth() {
        return this.f2198m;
    }

    public int getSwitchPadding() {
        return this.f2199n;
    }

    public CharSequence getTextOff() {
        return this.f2203r;
    }

    public CharSequence getTextOn() {
        return this.f2201p;
    }

    public Drawable getThumbDrawable() {
        return this.f2187a;
    }

    protected final float getThumbPosition() {
        return this.A;
    }

    public int getThumbTextPadding() {
        return this.f2197l;
    }

    public ColorStateList getThumbTintList() {
        return this.f2188b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f2189c;
    }

    public Drawable getTrackDrawable() {
        return this.f2192g;
    }

    public ColorStateList getTrackTintList() {
        return this.f2193h;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f2194i;
    }

    void j() {
        setTextOnInternal(this.f2201p);
        setTextOffInternal(this.f2203r);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f2187a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.O;
        if (objectAnimator == null || !objectAnimator.isStarted()) {
            return;
        }
        this.O.end();
        this.O = null;
    }

    public void m(Context context, int i3) {
        TintTypedArray tintTypedArrayT = TintTypedArray.t(context, i3, androidx.appcompat.R.styleable.c3);
        ColorStateList colorStateListC = tintTypedArrayT.c(androidx.appcompat.R.styleable.g3);
        if (colorStateListC != null) {
            this.K = colorStateListC;
        } else {
            this.K = getTextColors();
        }
        int iF = tintTypedArrayT.f(androidx.appcompat.R.styleable.d3, 0);
        if (iF != 0) {
            float f3 = iF;
            if (f3 != this.J.getTextSize()) {
                this.J.setTextSize(f3);
                requestLayout();
            }
        }
        o(tintTypedArrayT.k(androidx.appcompat.R.styleable.e3, -1), tintTypedArrayT.k(androidx.appcompat.R.styleable.f3, -1));
        if (tintTypedArrayT.a(androidx.appcompat.R.styleable.l3, false)) {
            this.N = new AllCapsTransformationMethod(getContext());
        } else {
            this.N = null;
        }
        setTextOnInternal(this.f2201p);
        setTextOffInternal(this.f2203r);
        tintTypedArrayT.x();
    }

    public void n(Typeface typeface, int i3) {
        if (i3 <= 0) {
            this.J.setFakeBoldText(false);
            this.J.setTextSkewX(0.0f);
            setSwitchTypeface(typeface);
        } else {
            Typeface typefaceDefaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i3) : Typeface.create(typeface, i3);
            setSwitchTypeface(typefaceDefaultFromStyle);
            int i4 = (~(typefaceDefaultFromStyle != null ? typefaceDefaultFromStyle.getStyle() : 0)) & i3;
            this.J.setFakeBoldText((i4 & 1) != 0);
            this.J.setTextSkewX((i4 & 2) != 0 ? -0.25f : 0.0f);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i3) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, U);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.S;
        Drawable drawable = this.f2192g;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i3 = this.F;
        int i4 = this.H;
        int i5 = i3 + rect.top;
        int i6 = i4 - rect.bottom;
        Drawable drawable2 = this.f2187a;
        if (drawable != null) {
            if (!this.f2200o || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect rectD = DrawableUtils.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectD.left;
                rect.right -= rectD.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.L : this.M;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.K;
            if (colorStateList != null) {
                this.J.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.J.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i5 + i6) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f2201p : this.f2203r;
            if (TextUtils.isEmpty(charSequence)) {
                return;
            }
            CharSequence text = accessibilityNodeInfo.getText();
            if (TextUtils.isEmpty(text)) {
                accessibilityNodeInfo.setText(charSequence);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(text);
            sb.append(' ');
            sb.append(charSequence);
            accessibilityNodeInfo.setText(sb);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        int iMax;
        int width;
        int paddingLeft;
        int i7;
        int paddingTop;
        int height;
        super.onLayout(z2, i3, i4, i5, i6);
        int iMax2 = 0;
        if (this.f2187a != null) {
            Rect rect = this.S;
            Drawable drawable = this.f2192g;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectD = DrawableUtils.d(this.f2187a);
            iMax = Math.max(0, rectD.left - rect.left);
            iMax2 = Math.max(0, rectD.right - rect.right);
        } else {
            iMax = 0;
        }
        if (ViewUtils.b(this)) {
            paddingLeft = getPaddingLeft() + iMax;
            width = ((this.B + paddingLeft) - iMax) - iMax2;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax2;
            paddingLeft = (width - this.B) + iMax + iMax2;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            int paddingTop2 = ((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2;
            i7 = this.C;
            paddingTop = paddingTop2 - (i7 / 2);
        } else {
            if (gravity == 80) {
                height = getHeight() - getPaddingBottom();
                paddingTop = height - this.C;
                this.E = paddingLeft;
                this.F = paddingTop;
                this.H = height;
                this.G = width;
            }
            paddingTop = getPaddingTop();
            i7 = this.C;
        }
        height = i7 + paddingTop;
        this.E = paddingLeft;
        this.F = paddingTop;
        this.H = height;
        this.G = width;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i4) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f2205t) {
            if (this.L == null) {
                this.L = i(this.f2202q);
            }
            if (this.M == null) {
                this.M = i(this.f2204s);
            }
        }
        Rect rect = this.S;
        Drawable drawable = this.f2187a;
        int intrinsicHeight2 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            intrinsicWidth = (this.f2187a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2187a.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.D = Math.max(this.f2205t ? Math.max(this.L.getWidth(), this.M.getWidth()) + (this.f2197l * 2) : 0, intrinsicWidth);
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            intrinsicHeight2 = this.f2192g.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        Drawable drawable3 = this.f2187a;
        if (drawable3 != null) {
            Rect rectD = DrawableUtils.d(drawable3);
            iMax = Math.max(iMax, rectD.left);
            iMax2 = Math.max(iMax2, rectD.right);
        }
        int iMax3 = this.I ? Math.max(this.f2198m, (this.D * 2) + iMax + iMax2) : this.f2198m;
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.B = iMax3;
        this.C = iMax4;
        super.onMeasure(i3, i4);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f2201p : this.f2203r;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0089  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.VelocityTracker r0 = r6.f2210y
            r0.addMovement(r7)
            int r0 = r7.getActionMasked()
            r1 = 1
            if (r0 == 0) goto L9d
            r2 = 2
            if (r0 == r1) goto L89
            if (r0 == r2) goto L16
            r3 = 3
            if (r0 == r3) goto L89
            goto Lb7
        L16:
            int r0 = r6.f2206u
            if (r0 == r1) goto L55
            if (r0 == r2) goto L1e
            goto Lb7
        L1e:
            float r7 = r7.getX()
            int r0 = r6.getThumbScrollRange()
            float r2 = r6.f2208w
            float r2 = r7 - r2
            r3 = 1065353216(0x3f800000, float:1.0)
            r4 = 0
            if (r0 == 0) goto L32
            float r0 = (float) r0
            float r2 = r2 / r0
            goto L3b
        L32:
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L38
            r2 = r3
            goto L3b
        L38:
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r2 = r0
        L3b:
            boolean r0 = androidx.appcompat.widget.ViewUtils.b(r6)
            if (r0 == 0) goto L42
            float r2 = -r2
        L42:
            float r0 = r6.A
            float r0 = r0 + r2
            float r0 = f(r0, r4, r3)
            float r2 = r6.A
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L54
            r6.f2208w = r7
            r6.setThumbPosition(r0)
        L54:
            return r1
        L55:
            float r0 = r7.getX()
            float r3 = r7.getY()
            float r4 = r6.f2208w
            float r4 = r0 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2207v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L7b
            float r4 = r6.f2209x
            float r4 = r3 - r4
            float r4 = java.lang.Math.abs(r4)
            int r5 = r6.f2207v
            float r5 = (float) r5
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto Lb7
        L7b:
            r6.f2206u = r2
            android.view.ViewParent r7 = r6.getParent()
            r7.requestDisallowInterceptTouchEvent(r1)
            r6.f2208w = r0
            r6.f2209x = r3
            return r1
        L89:
            int r0 = r6.f2206u
            if (r0 != r2) goto L94
            r6.q(r7)
            super.onTouchEvent(r7)
            return r1
        L94:
            r0 = 0
            r6.f2206u = r0
            android.view.VelocityTracker r0 = r6.f2210y
            r0.clear()
            goto Lb7
        L9d:
            float r0 = r7.getX()
            float r2 = r7.getY()
            boolean r3 = r6.isEnabled()
            if (r3 == 0) goto Lb7
            boolean r3 = r6.h(r0, r2)
            if (r3 == 0) goto Lb7
            r6.f2206u = r1
            r6.f2208w = r0
            r6.f2209x = r2
        Lb7:
            boolean r7 = super.onTouchEvent(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SwitchCompat.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z2) {
        super.setAllCaps(z2);
        getEmojiTextViewHelper().d(z2);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        super.setChecked(z2);
        boolean zIsChecked = isChecked();
        if (zIsChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() != null && isLaidOut()) {
            a(zIsChecked);
        } else {
            d();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.r(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z2) {
        getEmojiTextViewHelper().e(z2);
        setTextOnInternal(this.f2201p);
        setTextOffInternal(this.f2203r);
        requestLayout();
    }

    protected final void setEnforceSwitchWidth(boolean z2) {
        this.I = z2;
        invalidate();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z2) {
        if (this.f2205t != z2) {
            this.f2205t = z2;
            requestLayout();
            if (z2) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z2) {
        this.f2200o = z2;
        invalidate();
    }

    public void setSwitchMinWidth(int i3) {
        this.f2198m = i3;
        requestLayout();
    }

    public void setSwitchPadding(int i3) {
        this.f2199n = i3;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.J.getTypeface() == null || this.J.getTypeface().equals(typeface)) && (this.J.getTypeface() != null || typeface == null)) {
            return;
        }
        this.J.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            return;
        }
        k();
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2187a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2187a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f3) {
        this.A = f3;
        invalidate();
    }

    public void setThumbResource(int i3) {
        setThumbDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setThumbTextPadding(int i3) {
        this.f2197l = i3;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2188b = colorStateList;
        this.f2190d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f2189c = mode;
        this.f2191f = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f2192g;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f2192g = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i3) {
        setTrackDrawable(AppCompatResources.b(getContext(), i3));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2193h = colorStateList;
        this.f2195j = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f2194i = mode;
        this.f2196k = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2187a || drawable == this.f2192g;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f2188b = null;
        this.f2189c = null;
        this.f2190d = false;
        this.f2191f = false;
        this.f2193h = null;
        this.f2194i = null;
        this.f2195j = false;
        this.f2196k = false;
        this.f2210y = VelocityTracker.obtain();
        this.I = true;
        this.S = new Rect();
        ThemeUtils.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.J = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = androidx.appcompat.R.styleable.N2;
        TintTypedArray tintTypedArrayV = TintTypedArray.v(context, attributeSet, iArr, i3, 0);
        ViewCompat.k0(this, context, iArr, attributeSet, tintTypedArrayV.r(), i3, 0);
        Drawable drawableG = tintTypedArrayV.g(androidx.appcompat.R.styleable.Q2);
        this.f2187a = drawableG;
        if (drawableG != null) {
            drawableG.setCallback(this);
        }
        Drawable drawableG2 = tintTypedArrayV.g(androidx.appcompat.R.styleable.Z2);
        this.f2192g = drawableG2;
        if (drawableG2 != null) {
            drawableG2.setCallback(this);
        }
        setTextOnInternal(tintTypedArrayV.p(androidx.appcompat.R.styleable.O2));
        setTextOffInternal(tintTypedArrayV.p(androidx.appcompat.R.styleable.P2));
        this.f2205t = tintTypedArrayV.a(androidx.appcompat.R.styleable.R2, true);
        this.f2197l = tintTypedArrayV.f(androidx.appcompat.R.styleable.W2, 0);
        this.f2198m = tintTypedArrayV.f(androidx.appcompat.R.styleable.T2, 0);
        this.f2199n = tintTypedArrayV.f(androidx.appcompat.R.styleable.U2, 0);
        this.f2200o = tintTypedArrayV.a(androidx.appcompat.R.styleable.S2, false);
        ColorStateList colorStateListC = tintTypedArrayV.c(androidx.appcompat.R.styleable.X2);
        if (colorStateListC != null) {
            this.f2188b = colorStateListC;
            this.f2190d = true;
        }
        PorterDuff.Mode modeE = DrawableUtils.e(tintTypedArrayV.k(androidx.appcompat.R.styleable.Y2, -1), null);
        if (this.f2189c != modeE) {
            this.f2189c = modeE;
            this.f2191f = true;
        }
        if (this.f2190d || this.f2191f) {
            b();
        }
        ColorStateList colorStateListC2 = tintTypedArrayV.c(androidx.appcompat.R.styleable.a3);
        if (colorStateListC2 != null) {
            this.f2193h = colorStateListC2;
            this.f2195j = true;
        }
        PorterDuff.Mode modeE2 = DrawableUtils.e(tintTypedArrayV.k(androidx.appcompat.R.styleable.b3, -1), null);
        if (this.f2194i != modeE2) {
            this.f2194i = modeE2;
            this.f2196k = true;
        }
        if (this.f2195j || this.f2196k) {
            c();
        }
        int iN = tintTypedArrayV.n(androidx.appcompat.R.styleable.V2, 0);
        if (iN != 0) {
            m(context, iN);
        }
        AppCompatTextHelper appCompatTextHelper = new AppCompatTextHelper(this);
        this.P = appCompatTextHelper;
        appCompatTextHelper.m(attributeSet, i3);
        tintTypedArrayV.x();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2207v = viewConfiguration.getScaledTouchSlop();
        this.f2211z = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i3);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
