package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.LazyMutable;
import cz.mobilesoft.statistics.util.ExtKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppWebsUsageBar extends View {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f130018i = {Reflection.e(new MutablePropertyReference1Impl(AppWebsUsageBar.class, "startColor", "getStartColor()I", 0)), Reflection.e(new MutablePropertyReference1Impl(AppWebsUsageBar.class, "endColor", "getEndColor()I", 0))};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f130019j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Paint f130020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Paint f130021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f130022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyMutable f130023d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LazyMutable f130024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RectF f130025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private RectF f130026h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AppWebsUsageBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int c(Context context) {
        return ContextCompat.getColor(context, R.color.f95447b);
    }

    private final RectF d(RectF rectF, Float f3, Float f4) {
        if (f3 != null) {
            float fFloatValue = f3.floatValue();
            rectF.left *= fFloatValue;
            rectF.right *= fFloatValue;
        }
        if (f4 != null) {
            float fFloatValue2 = f4.floatValue();
            rectF.top *= fFloatValue2;
            rectF.bottom *= fFloatValue2;
        }
        return rectF;
    }

    static /* synthetic */ RectF e(AppWebsUsageBar appWebsUsageBar, RectF rectF, Float f3, Float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = null;
        }
        if ((i3 & 2) != 0) {
            f4 = null;
        }
        return appWebsUsageBar.d(rectF, f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int f(Context context) {
        return ContextCompat.getColor(context, R.color.f95446a);
    }

    private final RectF g(RectF rectF, Float f3, Float f4) {
        if (f3 != null) {
            float fFloatValue = f3.floatValue();
            rectF.left += fFloatValue;
            rectF.right += fFloatValue;
        }
        if (f4 != null) {
            float fFloatValue2 = f4.floatValue();
            rectF.top += fFloatValue2;
            rectF.bottom += fFloatValue2;
        }
        return rectF;
    }

    static /* synthetic */ RectF h(AppWebsUsageBar appWebsUsageBar, RectF rectF, Float f3, Float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = null;
        }
        if ((i3 & 2) != 0) {
            f4 = null;
        }
        return appWebsUsageBar.g(rectF, f3, f4);
    }

    public final int getEndColor() {
        return ((Number) this.f130024f.a(this, f130018i[1])).intValue();
    }

    public final int getStartColor() {
        return ((Number) this.f130023d.a(this, f130018i[0])).intValue();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        RectF rectF = this.f130025g;
        if (rectF != null) {
            canvas.drawRect(rectF, this.f130020a);
        }
        RectF rectF2 = this.f130026h;
        if (rectF2 != null) {
            canvas.drawRect(rectF2, this.f130021b);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
        RectF rectF;
        super.onLayout(z2, i3, i4, i5, i6);
        float f3 = getResources().getDisplayMetrics().density;
        float f4 = i5;
        float f5 = (2.0f * f3) / f4;
        if (this.f130022c > 1) {
            float f6 = 1 - ((r14 - 1) * f5);
            RectF rectF2 = this.f130025g;
            if (rectF2 != null) {
                e(this, rectF2, Float.valueOf(f6), null, 2, null);
            }
            RectF rectF3 = this.f130026h;
            if (rectF3 != null) {
                e(this, rectF3, Float.valueOf(f6), null, 2, null);
            }
            if (this.f130025g != null && (rectF = this.f130026h) != null) {
                h(this, rectF, Float.valueOf(f5), null, 2, null);
            }
        }
        RectF rectF4 = this.f130026h;
        if (rectF4 != null) {
            d(rectF4, Float.valueOf(f4), Float.valueOf(i4));
        }
        RectF rectF5 = this.f130025g;
        if (rectF5 != null) {
            float f7 = rectF5.right;
            d(rectF5, Float.valueOf(f4), Float.valueOf(i4));
            this.f130020a.setShader(new LinearGradient(0.0f, 0.0f, rectF5.right - rectF5.left, 0.0f, getStartColor(), ExtKt.a(getStartColor(), getEndColor(), f7), Shader.TileMode.MIRROR));
            if (rectF5.width() < f3) {
                rectF5.right += f3;
                RectF rectF6 = this.f130026h;
                if (rectF6 != null) {
                    rectF6.left += f3;
                }
            }
        }
    }

    public final void setEndColor(int i3) {
        this.f130024f.b(this, f130018i[1], Integer.valueOf(i3));
    }

    public final void setStartColor(int i3) {
        this.f130023d.b(this, f130018i[0], Integer.valueOf(i3));
    }

    public final void setWidth(float f3) {
        this.f130022c = 0;
        this.f130025g = null;
        this.f130026h = null;
        if (f3 == 0.0f) {
            return;
        }
        float f4 = 1.0f - f3;
        this.f130022c = 1;
        RectF rectF = new RectF();
        rectF.top = 1.0f;
        rectF.right = f3;
        this.f130025g = rectF;
        if (f4 > 0.0f) {
            this.f130022c++;
            RectF rectF2 = new RectF();
            rectF2.top = 1.0f;
            rectF2.right = f4;
            h(this, rectF2, Float.valueOf(1 - f4), null, 2, null);
            this.f130026h = rectF2;
        }
        requestLayout();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppWebsUsageBar(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f130020a = paint;
        Paint paint2 = new Paint();
        paint2.setColor(ContextCompat.getColor(context, R.color.f95456k));
        paint2.setAlpha(28);
        paint2.setStyle(style);
        this.f130021b = paint2;
        this.f130023d = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.view.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(AppWebsUsageBar.f(context));
            }
        });
        this.f130024f = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.view.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Integer.valueOf(AppWebsUsageBar.c(context));
            }
        });
    }

    public /* synthetic */ AppWebsUsageBar(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }
}
