package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final PorterDuff.Mode f53642l = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private VectorDrawableCompatState f53643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f53644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ColorFilter f53645d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f53646f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f53647g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Drawable.ConstantState f53648h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float[] f53649i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Matrix f53650j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Rect f53651k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VClipPath extends VPath {
        VClipPath() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f53678b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f53677a = PathParser.d(string2);
            }
            this.f53679c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.p(xmlPullParser, "pathData")) {
                TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f53611d);
                f(typedArrayQ, xmlPullParser);
                typedArrayQ.recycle();
            }
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class VObject {
        private VObject() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f53698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        VPathRenderer f53699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        ColorStateList f53700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f53701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f53702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Bitmap f53703f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ColorStateList f53704g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f53705h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f53706i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f53707j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f53708k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Paint f53709l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f53700c = null;
            this.f53701d = VectorDrawableCompat.f53642l;
            if (vectorDrawableCompatState != null) {
                this.f53698a = vectorDrawableCompatState.f53698a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f53699b);
                this.f53699b = vPathRenderer;
                if (vectorDrawableCompatState.f53699b.f53686e != null) {
                    vPathRenderer.f53686e = new Paint(vectorDrawableCompatState.f53699b.f53686e);
                }
                if (vectorDrawableCompatState.f53699b.f53685d != null) {
                    this.f53699b.f53685d = new Paint(vectorDrawableCompatState.f53699b.f53685d);
                }
                this.f53700c = vectorDrawableCompatState.f53700c;
                this.f53701d = vectorDrawableCompatState.f53701d;
                this.f53702e = vectorDrawableCompatState.f53702e;
            }
        }

        public boolean a(int i3, int i4) {
            return i3 == this.f53703f.getWidth() && i4 == this.f53703f.getHeight();
        }

        public boolean b() {
            return !this.f53708k && this.f53704g == this.f53700c && this.f53705h == this.f53701d && this.f53707j == this.f53702e && this.f53706i == this.f53699b.getRootAlpha();
        }

        public void c(int i3, int i4) {
            if (this.f53703f == null || !a(i3, i4)) {
                this.f53703f = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
                this.f53708k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f53703f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f53709l == null) {
                Paint paint = new Paint();
                this.f53709l = paint;
                paint.setFilterBitmap(true);
            }
            this.f53709l.setAlpha(this.f53699b.getRootAlpha());
            this.f53709l.setColorFilter(colorFilter);
            return this.f53709l;
        }

        public boolean f() {
            return this.f53699b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f53699b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f53698a;
        }

        public boolean h(int[] iArr) {
            boolean zG = this.f53699b.g(iArr);
            this.f53708k |= zG;
            return zG;
        }

        public void i() {
            this.f53704g = this.f53700c;
            this.f53705h = this.f53701d;
            this.f53706i = this.f53699b.getRootAlpha();
            this.f53707j = this.f53702e;
            this.f53708k = false;
        }

        public void j(int i3, int i4) {
            this.f53703f.eraseColor(0);
            this.f53699b.b(new Canvas(this.f53703f), i3, i4, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f53700c = null;
            this.f53701d = VectorDrawableCompat.f53642l;
            this.f53699b = new VPathRenderer();
        }
    }

    VectorDrawableCompat() {
        this.f53647g = true;
        this.f53649i = new float[9];
        this.f53650j = new Matrix();
        this.f53651k = new Rect();
        this.f53643b = new VectorDrawableCompatState();
    }

    static int a(int i3, float f3) {
        return (i3 & 16777215) | (((int) (Color.alpha(i3) * f3)) << 24);
    }

    public static VectorDrawableCompat b(Resources resources, int i3, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.f53641a = ResourcesCompat.f(resources, i3, theme);
        vectorDrawableCompat.f53648h = new VectorDrawableDelegateState(vectorDrawableCompat.f53641a.getConstantState());
        return vectorDrawableCompat;
    }

    public static VectorDrawableCompat c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f53699b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f53689h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z2 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.g(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f53665b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f53697p.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f53698a = vFullPath.f53680d | vectorDrawableCompatState.f53698a;
                    z2 = false;
                } else if ("clip-path".equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.e(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f53665b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f53697p.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f53698a = vClipPath.f53680d | vectorDrawableCompatState.f53698a;
                } else if ("group".equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.c(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f53665b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f53697p.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f53698a = vGroup2.f53674k | vectorDrawableCompatState.f53698a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z2) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && DrawableCompat.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f53699b;
        vectorDrawableCompatState.f53701d = g(TypedArrayUtils.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateListG = TypedArrayUtils.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (colorStateListG != null) {
            vectorDrawableCompatState.f53700c = colorStateListG;
        }
        vectorDrawableCompatState.f53702e = TypedArrayUtils.e(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f53702e);
        vPathRenderer.f53692k = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f53692k);
        float fJ = TypedArrayUtils.j(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f53693l);
        vPathRenderer.f53693l = fJ;
        if (vPathRenderer.f53692k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (fJ <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        vPathRenderer.f53690i = typedArray.getDimension(3, vPathRenderer.f53690i);
        float dimension = typedArray.getDimension(2, vPathRenderer.f53691j);
        vPathRenderer.f53691j = dimension;
        if (vPathRenderer.f53690i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        vPathRenderer.setAlpha(TypedArrayUtils.j(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            vPathRenderer.f53695n = string;
            vPathRenderer.f53697p.put(string, vPathRenderer);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f53641a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    Object d(String str) {
        return this.f53643b.f53699b.f53697p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f53651k);
        if (this.f53651k.width() <= 0 || this.f53651k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f53645d;
        if (colorFilter == null) {
            colorFilter = this.f53644c;
        }
        canvas.getMatrix(this.f53650j);
        this.f53650j.getValues(this.f53649i);
        float fAbs = Math.abs(this.f53649i[0]);
        float fAbs2 = Math.abs(this.f53649i[4]);
        float fAbs3 = Math.abs(this.f53649i[1]);
        float fAbs4 = Math.abs(this.f53649i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f53651k.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f53651k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        Rect rect = this.f53651k;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f53651k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f53651k.offsetTo(0, 0);
        this.f53643b.c(iMin, iMin2);
        if (!this.f53647g) {
            this.f53643b.j(iMin, iMin2);
        } else if (!this.f53643b.b()) {
            this.f53643b.j(iMin, iMin2);
            this.f53643b.i();
        }
        this.f53643b.d(canvas, colorFilter, this.f53651k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.d(drawable) : this.f53643b.f53699b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f53643b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.e(drawable) : this.f53645d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f53641a != null) {
            return new VectorDrawableDelegateState(this.f53641a.getConstantState());
        }
        this.f53643b.f53698a = getChangingConfigurations();
        return this.f53643b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f53643b.f53699b.f53691j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f53643b.f53699b.f53690i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    void h(boolean z2) {
        this.f53647g = z2;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f53641a;
        return drawable != null ? DrawableCompat.h(drawable) : this.f53643b.f53702e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful()) {
            return true;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        if (vectorDrawableCompatState == null) {
            return false;
        }
        if (vectorDrawableCompatState.g()) {
            return true;
        }
        ColorStateList colorStateList = this.f53643b.f53700c;
        return colorStateList != null && colorStateList.isStateful();
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f53646f && super.mutate() == this) {
            this.f53643b = new VectorDrawableCompatState(this.f53643b);
            this.f53646f = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z2;
        PorterDuff.Mode mode;
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        ColorStateList colorStateList = vectorDrawableCompatState.f53700c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.f53701d) == null) {
            z2 = false;
        } else {
            this.f53644c = j(this.f53644c, colorStateList, mode);
            invalidateSelf();
            z2 = true;
        }
        if (!vectorDrawableCompatState.g() || !vectorDrawableCompatState.h(iArr)) {
            return z2;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j3);
        } else {
            super.scheduleSelf(runnable, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setAlpha(i3);
        } else if (this.f53643b.f53699b.getRootAlpha() != i3) {
            this.f53643b.f53699b.setRootAlpha(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z2) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.j(drawable, z2);
        } else {
            this.f53643b.f53702e = z2;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i3) {
        super.setChangingConfigurations(i3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i3, PorterDuff.Mode mode) {
        super.setColorFilter(i3, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z2) {
        super.setFilterBitmap(z2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f3, float f4) {
        super.setHotspot(f3, f4);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i3, int i4, int i5, int i6) {
        super.setHotspotBounds(i3, i4, i5, i6);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.n(drawable, i3);
        } else {
            setTintList(ColorStateList.valueOf(i3));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.o(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        if (vectorDrawableCompatState.f53700c != colorStateList) {
            vectorDrawableCompatState.f53700c = colorStateList;
            this.f53644c = j(this.f53644c, colorStateList, vectorDrawableCompatState.f53701d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.p(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        if (vectorDrawableCompatState.f53701d != mode) {
            vectorDrawableCompatState.f53701d = mode;
            this.f53644c = j(this.f53644c, vectorDrawableCompatState.f53700c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z2, boolean z3) {
        Drawable drawable = this.f53641a;
        return drawable != null ? drawable.setVisible(z2, z3) : super.setVisible(z2, z3);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f53710a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f53710a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f53710a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f53710a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f53641a = (VectorDrawable) this.f53710a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f53641a = (VectorDrawable) this.f53710a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f53641a = (VectorDrawable) this.f53710a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f53645d = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class VPath extends VObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected PathParser.PathDataNode[] f53677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f53678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f53679c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f53680d;

        public VPath() {
            super();
            this.f53677a = null;
            this.f53679c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f53677a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.i(pathDataNodeArr, path);
            }
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f53677a;
        }

        public String getPathName() {
            return this.f53678b;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (PathParser.b(this.f53677a, pathDataNodeArr)) {
                PathParser.k(this.f53677a, pathDataNodeArr);
            } else {
                this.f53677a = PathParser.f(pathDataNodeArr);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f53677a = null;
            this.f53679c = 0;
            this.f53678b = vPath.f53678b;
            this.f53680d = vPath.f53680d;
            this.f53677a = PathParser.f(vPath.f53677a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f53641a;
        if (drawable != null) {
            DrawableCompat.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.f53643b;
        vectorDrawableCompatState.f53699b = new VPathRenderer();
        TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f53608a);
        i(typedArrayQ, xmlPullParser, theme);
        typedArrayQ.recycle();
        vectorDrawableCompatState.f53698a = getChangingConfigurations();
        vectorDrawableCompatState.f53708k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f53644c = j(this.f53644c, vectorDrawableCompatState.f53700c, vectorDrawableCompatState.f53701d);
    }

    VectorDrawableCompat(VectorDrawableCompatState vectorDrawableCompatState) {
        this.f53647g = true;
        this.f53649i = new float[9];
        this.f53650j = new Matrix();
        this.f53651k = new Rect();
        this.f53643b = vectorDrawableCompatState;
        this.f53644c = j(this.f53644c, vectorDrawableCompatState.f53700c, vectorDrawableCompatState.f53701d);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VFullPath extends VPath {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int[] f53652e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ComplexColorCompat f53653f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        float f53654g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ComplexColorCompat f53655h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f53656i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f53657j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f53658k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f53659l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        float f53660m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        Paint.Cap f53661n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Paint.Join f53662o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float f53663p;

        VFullPath() {
            this.f53654g = 0.0f;
            this.f53656i = 1.0f;
            this.f53657j = 1.0f;
            this.f53658k = 0.0f;
            this.f53659l = 1.0f;
            this.f53660m = 0.0f;
            this.f53661n = Paint.Cap.BUTT;
            this.f53662o = Paint.Join.MITER;
            this.f53663p = 4.0f;
        }

        private Paint.Cap e(int i3, Paint.Cap cap) {
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i3, Paint.Join join) {
            return i3 != 0 ? i3 != 1 ? i3 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f53652e = null;
            if (TypedArrayUtils.p(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f53678b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f53677a = PathParser.d(string2);
                }
                this.f53655h = TypedArrayUtils.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f53657j = TypedArrayUtils.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f53657j);
                this.f53661n = e(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f53661n);
                this.f53662o = f(TypedArrayUtils.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f53662o);
                this.f53663p = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f53663p);
                this.f53653f = TypedArrayUtils.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f53656i = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f53656i);
                this.f53654g = TypedArrayUtils.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f53654g);
                this.f53659l = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f53659l);
                this.f53660m = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f53660m);
                this.f53658k = TypedArrayUtils.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f53658k);
                this.f53679c = TypedArrayUtils.k(typedArray, xmlPullParser, "fillType", 13, this.f53679c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean a() {
            return this.f53655h.i() || this.f53653f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean b(int[] iArr) {
            return this.f53653f.j(iArr) | this.f53655h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f53610c);
            h(typedArrayQ, xmlPullParser, theme);
            typedArrayQ.recycle();
        }

        float getFillAlpha() {
            return this.f53657j;
        }

        int getFillColor() {
            return this.f53655h.e();
        }

        float getStrokeAlpha() {
            return this.f53656i;
        }

        int getStrokeColor() {
            return this.f53653f.e();
        }

        float getStrokeWidth() {
            return this.f53654g;
        }

        float getTrimPathEnd() {
            return this.f53659l;
        }

        float getTrimPathOffset() {
            return this.f53660m;
        }

        float getTrimPathStart() {
            return this.f53658k;
        }

        void setFillAlpha(float f3) {
            this.f53657j = f3;
        }

        void setFillColor(int i3) {
            this.f53655h.k(i3);
        }

        void setStrokeAlpha(float f3) {
            this.f53656i = f3;
        }

        void setStrokeColor(int i3) {
            this.f53653f.k(i3);
        }

        void setStrokeWidth(float f3) {
            this.f53654g = f3;
        }

        void setTrimPathEnd(float f3) {
            this.f53659l = f3;
        }

        void setTrimPathOffset(float f3) {
            this.f53660m = f3;
        }

        void setTrimPathStart(float f3) {
            this.f53658k = f3;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f53654g = 0.0f;
            this.f53656i = 1.0f;
            this.f53657j = 1.0f;
            this.f53658k = 0.0f;
            this.f53659l = 1.0f;
            this.f53660m = 0.0f;
            this.f53661n = Paint.Cap.BUTT;
            this.f53662o = Paint.Join.MITER;
            this.f53663p = 4.0f;
            this.f53652e = vFullPath.f53652e;
            this.f53653f = vFullPath.f53653f;
            this.f53654g = vFullPath.f53654g;
            this.f53656i = vFullPath.f53656i;
            this.f53655h = vFullPath.f53655h;
            this.f53679c = vFullPath.f53679c;
            this.f53657j = vFullPath.f53657j;
            this.f53658k = vFullPath.f53658k;
            this.f53659l = vFullPath.f53659l;
            this.f53660m = vFullPath.f53660m;
            this.f53661n = vFullPath.f53661n;
            this.f53662o = vFullPath.f53662o;
            this.f53663p = vFullPath.f53663p;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VPathRenderer {

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final Matrix f53681q = new Matrix();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f53682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f53683b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Matrix f53684c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Paint f53685d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Paint f53686e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private PathMeasure f53687f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f53688g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final VGroup f53689h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        float f53690i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        float f53691j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        float f53692k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        float f53693l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f53694m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        String f53695n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        Boolean f53696o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final ArrayMap f53697p;

        public VPathRenderer() {
            this.f53684c = new Matrix();
            this.f53690i = 0.0f;
            this.f53691j = 0.0f;
            this.f53692k = 0.0f;
            this.f53693l = 0.0f;
            this.f53694m = 255;
            this.f53695n = null;
            this.f53696o = null;
            this.f53697p = new ArrayMap();
            this.f53689h = new VGroup();
            this.f53682a = new Path();
            this.f53683b = new Path();
        }

        private static float a(float f3, float f4, float f5, float f6) {
            return (f3 * f6) - (f4 * f5);
        }

        private void c(VGroup vGroup, Matrix matrix, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            VGroup vGroup2 = vGroup;
            vGroup2.f53664a.set(matrix);
            vGroup2.f53664a.preConcat(vGroup2.f53673j);
            canvas.save();
            int i5 = 0;
            while (i5 < vGroup2.f53665b.size()) {
                VObject vObject = (VObject) vGroup2.f53665b.get(i5);
                if (vObject instanceof VGroup) {
                    c((VGroup) vObject, vGroup2.f53664a, canvas, i3, i4, colorFilter);
                } else if (vObject instanceof VPath) {
                    d(vGroup2, (VPath) vObject, canvas, i3, i4, colorFilter);
                }
                i5++;
                vGroup2 = vGroup;
            }
            canvas.restore();
        }

        private void d(VGroup vGroup, VPath vPath, Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            float f3 = i3 / this.f53692k;
            float f4 = i4 / this.f53693l;
            float fMin = Math.min(f3, f4);
            Matrix matrix = vGroup.f53664a;
            this.f53684c.set(matrix);
            this.f53684c.postScale(f3, f4);
            float fE = e(matrix);
            if (fE == 0.0f) {
                return;
            }
            vPath.d(this.f53682a);
            Path path = this.f53682a;
            this.f53683b.reset();
            if (vPath.c()) {
                this.f53683b.setFillType(vPath.f53679c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f53683b.addPath(path, this.f53684c);
                canvas.clipPath(this.f53683b);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            float f5 = vFullPath.f53658k;
            if (f5 != 0.0f || vFullPath.f53659l != 1.0f) {
                float f6 = vFullPath.f53660m;
                float f7 = (f5 + f6) % 1.0f;
                float f8 = (vFullPath.f53659l + f6) % 1.0f;
                if (this.f53687f == null) {
                    this.f53687f = new PathMeasure();
                }
                this.f53687f.setPath(this.f53682a, false);
                float length = this.f53687f.getLength();
                float f9 = f7 * length;
                float f10 = f8 * length;
                path.reset();
                if (f9 > f10) {
                    this.f53687f.getSegment(f9, length, path, true);
                    this.f53687f.getSegment(0.0f, f10, path, true);
                } else {
                    this.f53687f.getSegment(f9, f10, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f53683b.addPath(path, this.f53684c);
            if (vFullPath.f53655h.l()) {
                ComplexColorCompat complexColorCompat = vFullPath.f53655h;
                if (this.f53686e == null) {
                    Paint paint = new Paint(1);
                    this.f53686e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f53686e;
                if (complexColorCompat.h()) {
                    Shader shaderF = complexColorCompat.f();
                    shaderF.setLocalMatrix(this.f53684c);
                    paint2.setShader(shaderF);
                    paint2.setAlpha(Math.round(vFullPath.f53657j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.a(complexColorCompat.e(), vFullPath.f53657j));
                }
                paint2.setColorFilter(colorFilter);
                this.f53683b.setFillType(vFullPath.f53679c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f53683b, paint2);
            }
            if (vFullPath.f53653f.l()) {
                ComplexColorCompat complexColorCompat2 = vFullPath.f53653f;
                if (this.f53685d == null) {
                    Paint paint3 = new Paint(1);
                    this.f53685d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f53685d;
                Paint.Join join = vFullPath.f53662o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = vFullPath.f53661n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.f53663p);
                if (complexColorCompat2.h()) {
                    Shader shaderF2 = complexColorCompat2.f();
                    shaderF2.setLocalMatrix(this.f53684c);
                    paint4.setShader(shaderF2);
                    paint4.setAlpha(Math.round(vFullPath.f53656i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.e(), vFullPath.f53656i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.f53654g * fMin * fE);
                canvas.drawPath(this.f53683b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fA = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fA) / fMax;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i3, int i4, ColorFilter colorFilter) {
            c(this.f53689h, f53681q, canvas, i3, i4, colorFilter);
        }

        public boolean f() {
            if (this.f53696o == null) {
                this.f53696o = Boolean.valueOf(this.f53689h.a());
            }
            return this.f53696o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f53689h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f53694m;
        }

        public void setAlpha(float f3) {
            setRootAlpha((int) (f3 * 255.0f));
        }

        public void setRootAlpha(int i3) {
            this.f53694m = i3;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f53684c = new Matrix();
            this.f53690i = 0.0f;
            this.f53691j = 0.0f;
            this.f53692k = 0.0f;
            this.f53693l = 0.0f;
            this.f53694m = 255;
            this.f53695n = null;
            this.f53696o = null;
            ArrayMap arrayMap = new ArrayMap();
            this.f53697p = arrayMap;
            this.f53689h = new VGroup(vPathRenderer.f53689h, arrayMap);
            this.f53682a = new Path(vPathRenderer.f53682a);
            this.f53683b = new Path(vPathRenderer.f53683b);
            this.f53690i = vPathRenderer.f53690i;
            this.f53691j = vPathRenderer.f53691j;
            this.f53692k = vPathRenderer.f53692k;
            this.f53693l = vPathRenderer.f53693l;
            this.f53688g = vPathRenderer.f53688g;
            this.f53694m = vPathRenderer.f53694m;
            this.f53695n = vPathRenderer.f53695n;
            String str = vPathRenderer.f53695n;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f53696o = vPathRenderer.f53696o;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class VGroup extends VObject {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Matrix f53664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ArrayList f53665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        float f53666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private float f53667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private float f53668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private float f53669f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private float f53670g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private float f53671h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private float f53672i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final Matrix f53673j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f53674k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int[] f53675l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private String f53676m;

        public VGroup(VGroup vGroup, ArrayMap arrayMap) {
            VPath vClipPath;
            super();
            this.f53664a = new Matrix();
            this.f53665b = new ArrayList();
            this.f53666c = 0.0f;
            this.f53667d = 0.0f;
            this.f53668e = 0.0f;
            this.f53669f = 1.0f;
            this.f53670g = 1.0f;
            this.f53671h = 0.0f;
            this.f53672i = 0.0f;
            Matrix matrix = new Matrix();
            this.f53673j = matrix;
            this.f53676m = null;
            this.f53666c = vGroup.f53666c;
            this.f53667d = vGroup.f53667d;
            this.f53668e = vGroup.f53668e;
            this.f53669f = vGroup.f53669f;
            this.f53670g = vGroup.f53670g;
            this.f53671h = vGroup.f53671h;
            this.f53672i = vGroup.f53672i;
            this.f53675l = vGroup.f53675l;
            String str = vGroup.f53676m;
            this.f53676m = str;
            this.f53674k = vGroup.f53674k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f53673j);
            ArrayList arrayList = vGroup.f53665b;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                Object obj = arrayList.get(i3);
                if (obj instanceof VGroup) {
                    this.f53665b.add(new VGroup((VGroup) obj, arrayMap));
                } else {
                    if (obj instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) obj);
                    } else {
                        if (!(obj instanceof VClipPath)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        vClipPath = new VClipPath((VClipPath) obj);
                    }
                    this.f53665b.add(vClipPath);
                    Object obj2 = vClipPath.f53678b;
                    if (obj2 != null) {
                        arrayMap.put(obj2, vClipPath);
                    }
                }
            }
        }

        private void d() {
            this.f53673j.reset();
            this.f53673j.postTranslate(-this.f53667d, -this.f53668e);
            this.f53673j.postScale(this.f53669f, this.f53670g);
            this.f53673j.postRotate(this.f53666c, 0.0f, 0.0f);
            this.f53673j.postTranslate(this.f53671h + this.f53667d, this.f53672i + this.f53668e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f53675l = null;
            this.f53666c = TypedArrayUtils.j(typedArray, xmlPullParser, "rotation", 5, this.f53666c);
            this.f53667d = typedArray.getFloat(1, this.f53667d);
            this.f53668e = typedArray.getFloat(2, this.f53668e);
            this.f53669f = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleX", 3, this.f53669f);
            this.f53670g = TypedArrayUtils.j(typedArray, xmlPullParser, "scaleY", 4, this.f53670g);
            this.f53671h = TypedArrayUtils.j(typedArray, xmlPullParser, "translateX", 6, this.f53671h);
            this.f53672i = TypedArrayUtils.j(typedArray, xmlPullParser, "translateY", 7, this.f53672i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f53676m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean a() {
            for (int i3 = 0; i3 < this.f53665b.size(); i3++) {
                if (((VObject) this.f53665b.get(i3)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean b(int[] iArr) {
            boolean zB = false;
            for (int i3 = 0; i3 < this.f53665b.size(); i3++) {
                zB |= ((VObject) this.f53665b.get(i3)).b(iArr);
            }
            return zB;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayQ = TypedArrayUtils.q(resources, theme, attributeSet, AndroidResources.f53609b);
            e(typedArrayQ, xmlPullParser);
            typedArrayQ.recycle();
        }

        public String getGroupName() {
            return this.f53676m;
        }

        public Matrix getLocalMatrix() {
            return this.f53673j;
        }

        public float getPivotX() {
            return this.f53667d;
        }

        public float getPivotY() {
            return this.f53668e;
        }

        public float getRotation() {
            return this.f53666c;
        }

        public float getScaleX() {
            return this.f53669f;
        }

        public float getScaleY() {
            return this.f53670g;
        }

        public float getTranslateX() {
            return this.f53671h;
        }

        public float getTranslateY() {
            return this.f53672i;
        }

        public void setPivotX(float f3) {
            if (f3 != this.f53667d) {
                this.f53667d = f3;
                d();
            }
        }

        public void setPivotY(float f3) {
            if (f3 != this.f53668e) {
                this.f53668e = f3;
                d();
            }
        }

        public void setRotation(float f3) {
            if (f3 != this.f53666c) {
                this.f53666c = f3;
                d();
            }
        }

        public void setScaleX(float f3) {
            if (f3 != this.f53669f) {
                this.f53669f = f3;
                d();
            }
        }

        public void setScaleY(float f3) {
            if (f3 != this.f53670g) {
                this.f53670g = f3;
                d();
            }
        }

        public void setTranslateX(float f3) {
            if (f3 != this.f53671h) {
                this.f53671h = f3;
                d();
            }
        }

        public void setTranslateY(float f3) {
            if (f3 != this.f53672i) {
                this.f53672i = f3;
                d();
            }
        }

        public VGroup() {
            super();
            this.f53664a = new Matrix();
            this.f53665b = new ArrayList();
            this.f53666c = 0.0f;
            this.f53667d = 0.0f;
            this.f53668e = 0.0f;
            this.f53669f = 1.0f;
            this.f53670g = 1.0f;
            this.f53671h = 0.0f;
            this.f53672i = 0.0f;
            this.f53673j = new Matrix();
            this.f53676m = null;
        }
    }
}
