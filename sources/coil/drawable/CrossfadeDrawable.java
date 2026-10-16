package coil.drawable;

import android.content.res.ColorStateList;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import coil.decode.DecodeUtils;
import coil.size.Scale;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CrossfadeDrawable extends Drawable implements Drawable.Callback, Animatable2Compat {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Companion f55804n = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Scale f55805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f55806b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f55807c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f55808d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f55809f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f55810g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f55811h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f55812i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f55813j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f55814k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Drawable f55815l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Drawable f55816m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public CrossfadeDrawable(Drawable drawable, Drawable drawable2, Scale scale, int i3, boolean z2, boolean z3) {
        this.f55805a = scale;
        this.f55806b = i3;
        this.f55807c = z2;
        this.f55808d = z3;
        this.f55810g = a(drawable != null ? Integer.valueOf(drawable.getIntrinsicWidth()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicWidth()) : null);
        this.f55811h = a(drawable != null ? Integer.valueOf(drawable.getIntrinsicHeight()) : null, drawable2 != null ? Integer.valueOf(drawable2.getIntrinsicHeight()) : null);
        this.f55813j = 255;
        this.f55815l = drawable != null ? drawable.mutate() : null;
        Drawable drawableMutate = drawable2 != null ? drawable2.mutate() : null;
        this.f55816m = drawableMutate;
        if (i3 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
        Drawable drawable3 = this.f55815l;
        if (drawable3 != null) {
            drawable3.setCallback(this);
        }
        if (drawableMutate == null) {
            return;
        }
        drawableMutate.setCallback(this);
    }

    private final int a(Integer num, Integer num2) {
        if (this.f55808d || ((num == null || num.intValue() != -1) && (num2 == null || num2.intValue() != -1))) {
            return Math.max(num != null ? num.intValue() : -1, num2 != null ? num2.intValue() : -1);
        }
        return -1;
    }

    private final void b() {
        this.f55814k = 2;
        this.f55815l = null;
        List list = this.f55809f;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Animatable2Compat.AnimationCallback) list.get(i3)).b(this);
        }
    }

    public final void c(Drawable drawable, Rect rect) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            drawable.setBounds(rect);
            return;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        double dC = DecodeUtils.c(intrinsicWidth, intrinsicHeight, iWidth, iHeight, this.f55805a);
        double d3 = 2;
        int iC = MathKt.c((((double) iWidth) - (((double) intrinsicWidth) * dC)) / d3);
        int iC2 = MathKt.c((((double) iHeight) - (dC * ((double) intrinsicHeight))) / d3);
        drawable.setBounds(rect.left + iC, rect.top + iC2, rect.right - iC, rect.bottom - iC2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int iSave;
        Drawable drawable;
        int i3 = this.f55814k;
        if (i3 == 0) {
            Drawable drawable2 = this.f55815l;
            if (drawable2 != null) {
                drawable2.setAlpha(this.f55813j);
                iSave = canvas.save();
                try {
                    drawable2.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        if (i3 == 2) {
            Drawable drawable3 = this.f55816m;
            if (drawable3 != null) {
                drawable3.setAlpha(this.f55813j);
                iSave = canvas.save();
                try {
                    drawable3.draw(canvas);
                    return;
                } finally {
                }
            }
            return;
        }
        double dUptimeMillis = (SystemClock.uptimeMillis() - this.f55812i) / ((double) this.f55806b);
        double dN = RangesKt.n(dUptimeMillis, 0.0d, 1.0d);
        int i4 = this.f55813j;
        int i5 = (int) (dN * ((double) i4));
        if (this.f55807c) {
            i4 -= i5;
        }
        boolean z2 = dUptimeMillis >= 1.0d;
        if (!z2 && (drawable = this.f55815l) != null) {
            drawable.setAlpha(i4);
            iSave = canvas.save();
            try {
                drawable.draw(canvas);
            } finally {
            }
        }
        Drawable drawable4 = this.f55816m;
        if (drawable4 != null) {
            drawable4.setAlpha(i5);
            iSave = canvas.save();
            try {
                drawable4.draw(canvas);
            } finally {
            }
        }
        if (z2) {
            b();
        } else {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f55813j;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        ColorFilter colorFilter;
        Drawable drawable;
        int i3 = this.f55814k;
        if (i3 == 0) {
            Drawable drawable2 = this.f55815l;
            if (drawable2 != null) {
                return drawable2.getColorFilter();
            }
            return null;
        }
        if (i3 != 1) {
            if (i3 == 2 && (drawable = this.f55816m) != null) {
                return drawable.getColorFilter();
            }
            return null;
        }
        Drawable drawable3 = this.f55816m;
        if (drawable3 != null && (colorFilter = drawable3.getColorFilter()) != null) {
            return colorFilter;
        }
        Drawable drawable4 = this.f55815l;
        if (drawable4 != null) {
            return drawable4.getColorFilter();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f55811h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f55810g;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f55815l;
        Drawable drawable2 = this.f55816m;
        int i3 = this.f55814k;
        if (i3 == 0) {
            if (drawable != null) {
                return drawable.getOpacity();
            }
            return -2;
        }
        if (i3 == 2) {
            if (drawable2 != null) {
                return drawable2.getOpacity();
            }
            return -2;
        }
        if (drawable != null && drawable2 != null) {
            return Drawable.resolveOpacity(drawable.getOpacity(), drawable2.getOpacity());
        }
        if (drawable != null) {
            return drawable.getOpacity();
        }
        if (drawable2 != null) {
            return drawable2.getOpacity();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f55814k == 1;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            c(drawable, rect);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 != null) {
            c(drawable2, rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        Drawable drawable = this.f55815l;
        boolean level = drawable != null ? drawable.setLevel(i3) : false;
        Drawable drawable2 = this.f55816m;
        return level || (drawable2 != null ? drawable2.setLevel(i3) : false);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f55815l;
        boolean state = drawable != null ? drawable.setState(iArr) : false;
        Drawable drawable2 = this.f55816m;
        return state || (drawable2 != null ? drawable2.setState(iArr) : false);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        scheduleSelf(runnable, j3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 >= 0 && i3 < 256) {
            this.f55813j = i3;
            return;
        }
        throw new IllegalArgumentException(("Invalid alpha: " + i3).toString());
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 == null) {
            return;
        }
        drawable2.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i3) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            drawable.setTint(i3);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 != null) {
            drawable2.setTint(i3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintBlendMode(BlendMode blendMode) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            drawable.setTintBlendMode(blendMode);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 != null) {
            drawable2.setTintBlendMode(blendMode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            drawable.setTintList(colorStateList);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 != null) {
            drawable2.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f55815l;
        if (drawable != null) {
            drawable.setTintMode(mode);
        }
        Drawable drawable2 = this.f55816m;
        if (drawable2 != null) {
            drawable2.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Object obj = this.f55815l;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.start();
        }
        Object obj2 = this.f55816m;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.start();
        }
        if (this.f55814k != 0) {
            return;
        }
        this.f55814k = 1;
        this.f55812i = SystemClock.uptimeMillis();
        List list = this.f55809f;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((Animatable2Compat.AnimationCallback) list.get(i3)).c(this);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Object obj = this.f55815l;
        Animatable animatable = obj instanceof Animatable ? (Animatable) obj : null;
        if (animatable != null) {
            animatable.stop();
        }
        Object obj2 = this.f55816m;
        Animatable animatable2 = obj2 instanceof Animatable ? (Animatable) obj2 : null;
        if (animatable2 != null) {
            animatable2.stop();
        }
        if (this.f55814k != 2) {
            b();
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
