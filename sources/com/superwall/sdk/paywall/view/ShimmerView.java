package com.superwall.sdk.paywall.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerView extends ImageView implements PaywallShimmerView {
    public static final Companion Companion = new Companion(null);
    private static final float GRADIENT_WIDTH_RATIO = 0.4f;
    private static final long PULSE_DURATION_MS = 3000;
    private static final long SWEEP_DURATION_MS = 1500;
    public static final String TAG = "ShimmerView";
    private ValueAnimator animator;
    private int background;
    private int currentOrientation;
    private float gradientWidth;
    private boolean isLightBackground;
    private final Lazy landscapeDrawable$delegate;
    private final Lazy portraitDrawable$delegate;
    private ValueAnimator pulseAnimator;
    private final Matrix shaderMatrix;
    private final Paint shimmerPaint;
    private float shimmerTranslate;
    private int tintColor;
    private ColorFilter tintColorFilter;
    private VectorDrawable vectorDrawable;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ ShimmerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    private final VectorDrawable getLandscapeDrawable() {
        return (VectorDrawable) this.landscapeDrawable$delegate.getValue();
    }

    private final VectorDrawable getPortraitDrawable() {
        return (VectorDrawable) this.portraitDrawable$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VectorDrawable landscapeDrawable_delegate$lambda$2(ShimmerView shimmerView) {
        Drawable drawable = ContextCompat.getDrawable(shimmerView.getContext(), R.drawable.landscape_shimmer_skeleton);
        if (drawable instanceof VectorDrawable) {
            return (VectorDrawable) drawable;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VectorDrawable portraitDrawable_delegate$lambda$1(ShimmerView shimmerView) {
        Drawable drawable = ContextCompat.getDrawable(shimmerView.getContext(), R.drawable.portrait_shimmer_skeleton);
        if (drawable instanceof VectorDrawable) {
            return (VectorDrawable) drawable;
        }
        return null;
    }

    private final void setDrawableBasedOnOrientation(Configuration configuration) {
        VectorDrawable landscapeDrawable = configuration.orientation == 2 ? getLandscapeDrawable() : getPortraitDrawable();
        this.vectorDrawable = landscapeDrawable;
        if (!Intrinsics.areEqual(landscapeDrawable, getDrawable())) {
            setImageDrawable(this.vectorDrawable);
        }
        setColorFilter(this.tintColorFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$4$lambda$3(ShimmerView shimmerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        shimmerView.shimmerTranslate = ((Float) animatedValue).floatValue();
        shimmerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startShimmer$lambda$6$lambda$5(ShimmerView shimmerView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        shimmerView.setImageAlpha((int) (((Float) animatedValue).floatValue() * 255));
    }

    @Override // com.superwall.sdk.paywall.view.PaywallShimmerView
    public void checkForOrientationChanges() {
        Configuration configuration = getResources().getConfiguration();
        Intrinsics.checkNotNull(configuration);
        setDrawableBasedOnOrientation(configuration);
    }

    @Override // android.view.View
    public final int getBackground() {
        return this.background;
    }

    public final int getTintColor() {
        return this.tintColor;
    }

    public final ColorFilter getTintColorFilter() {
        return this.tintColorFilter;
    }

    @Override // com.superwall.sdk.paywall.view.PaywallShimmerView
    public void hideShimmer() {
        setVisibility(8);
        stopShimmer();
    }

    public final boolean isLightBackground() {
        return this.isLightBackground;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.superwall.sdk.paywall.view.ShimmerView.onAttachedToWindow.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ShimmerView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                ShimmerView.this.startShimmer();
            }
        });
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int i3 = this.currentOrientation;
        int i4 = newConfig.orientation;
        if (i3 == i4) {
            return;
        }
        this.currentOrientation = i4;
        setDrawableBasedOnOrientation(newConfig);
        invalidate();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.animator == null || this.shimmerPaint.getShader() == null) {
            super.onDraw(canvas);
            return;
        }
        int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.onDraw(canvas);
        this.shaderMatrix.setTranslate(this.shimmerTranslate, 0.0f);
        this.shimmerPaint.getShader().setLocalMatrix(this.shaderMatrix);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.shimmerPaint);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i4, int i5, int i6) {
        super.onSizeChanged(i3, i4, i5, i6);
        if (i3 == i5 || this.animator == null) {
            return;
        }
        startShimmer();
    }

    public final void setBackground(int i3) {
        this.background = i3;
    }

    public final void setLightBackground(boolean z2) {
        this.isLightBackground = z2;
    }

    public final void setTintColor(int i3) {
        this.tintColor = i3;
    }

    public final void setTintColorFilter(ColorFilter colorFilter) {
        this.tintColorFilter = colorFilter;
    }

    @Override // com.superwall.sdk.paywall.view.PaywallShimmerView
    public void showShimmer() {
        setVisibility(0);
        startShimmer();
    }

    public final void startShimmer() {
        stopShimmer();
        if (getWidth() == 0) {
            return;
        }
        this.gradientWidth = getWidth() * 0.4f;
        int i3 = this.tintColor;
        if (i3 == 0) {
            i3 = -1;
        }
        this.shimmerPaint.setShader(new LinearGradient(0.0f, 0.0f, this.gradientWidth, 0.0f, new int[]{0, Color.argb(this.isLightBackground ? ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : 96, Color.red(i3), Color.green(i3), Color.blue(i3)), 0}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-this.gradientWidth, getWidth());
        valueAnimatorOfFloat.setDuration(SWEEP_DURATION_MS);
        valueAnimatorOfFloat.setRepeatCount(-1);
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.superwall.sdk.paywall.view.p0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShimmerView.startShimmer$lambda$4$lambda$3(this.f93666a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.start();
        this.animator = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 0.5f, 1.0f);
        valueAnimatorOfFloat2.setDuration(PULSE_DURATION_MS);
        valueAnimatorOfFloat2.setRepeatCount(-1);
        valueAnimatorOfFloat2.setInterpolator(new PathInterpolator(0.4f, 0.0f, 0.6f, 1.0f));
        valueAnimatorOfFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.superwall.sdk.paywall.view.q0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShimmerView.startShimmer$lambda$6$lambda$5(this.f93667a, valueAnimator);
            }
        });
        valueAnimatorOfFloat2.start();
        this.pulseAnimator = valueAnimatorOfFloat2;
    }

    public final void stopShimmer() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animator = null;
        ValueAnimator valueAnimator2 = this.pulseAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        this.pulseAnimator = null;
        setImageAlpha(255);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShimmerView(Context context, AttributeSet attributeSet) {
        super(context.getApplicationContext(), attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.shimmerPaint = paint;
        this.shaderMatrix = new Matrix();
        this.portraitDrawable$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.r0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ShimmerView.portraitDrawable_delegate$lambda$1(this.f93668a);
            }
        });
        this.landscapeDrawable$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.s0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ShimmerView.landscapeDrawable_delegate$lambda$2(this.f93672a);
            }
        });
        setTag(TAG);
        checkForOrientationChanges();
    }
}
