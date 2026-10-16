package cz.mobilesoft.coreblock.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;
import com.google.android.material.button.MaterialButton;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.LazyMutable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class MaterialProgressButton extends MaterialButton {
    static final /* synthetic */ KProperty[] B = {Reflection.e(new MutablePropertyReference1Impl(MaterialProgressButton.class, "cachedText", "getCachedText()Ljava/lang/CharSequence;", 0)), Reflection.e(new MutablePropertyReference1Impl(MaterialProgressButton.class, "cachedIcon", "getCachedIcon()Landroid/graphics/drawable/Drawable;", 0)), Reflection.e(new MutablePropertyReference1Impl(MaterialProgressButton.class, "cachedIconGravity", "getCachedIconGravity()Ljava/lang/Integer;", 0))};
    public static final int C = 8;
    private boolean A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final Lazy f130046v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final Lazy f130047w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final LazyMutable f130048x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final LazyMutable f130049y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final LazyMutable f130050z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public final class AnimationCallback implements Drawable.Callback {
        public AnimationCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable who) {
            Intrinsics.checkNotNullParameter(who, "who");
            MaterialProgressButton.this.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable who, Runnable what, long j3) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable who, Runnable what) {
            Intrinsics.checkNotNullParameter(who, "who");
            Intrinsics.checkNotNullParameter(what, "what");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MaterialProgressButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final Drawable getCachedIcon() {
        return (Drawable) this.f130049y.a(this, B[1]);
    }

    private final Integer getCachedIconGravity() {
        return (Integer) this.f130050z.a(this, B[2]);
    }

    private final CharSequence getCachedText() {
        return (CharSequence) this.f130048x.a(this, B[0]);
    }

    private final LottieValueCallback<ColorFilter> getColorCallback() {
        return (LottieValueCallback) this.f130046v.getValue();
    }

    private final LottieDrawable getProgressAnimation() {
        return (LottieDrawable) this.f130047w.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Integer p(MaterialProgressButton materialProgressButton) {
        return Integer.valueOf(materialProgressButton.getIconGravity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Drawable q(MaterialProgressButton materialProgressButton) {
        return materialProgressButton.getIcon();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence r(MaterialProgressButton materialProgressButton) {
        return materialProgressButton.getText();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieValueCallback s() {
        return new LottieValueCallback();
    }

    private final void setCachedIcon(Drawable drawable) {
        this.f130049y.b(this, B[1], drawable);
    }

    private final void setCachedIconGravity(Integer num) {
        this.f130050z.b(this, B[2], num);
    }

    private final void setCachedText(CharSequence charSequence) {
        this.f130048x.b(this, B[0], charSequence);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LottieDrawable t(Context context, final MaterialProgressButton materialProgressButton) {
        final LottieDrawable lottieDrawable = new LottieDrawable();
        LottieCompositionFactory.s(context, R.raw.f95765b).d(new LottieListener() { // from class: cz.mobilesoft.coreblock.view.j
            @Override // com.airbnb.lottie.LottieListener
            public final void onResult(Object obj) {
                MaterialProgressButton.u(lottieDrawable, materialProgressButton, (LottieComposition) obj);
            }
        });
        return lottieDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(LottieDrawable lottieDrawable, MaterialProgressButton materialProgressButton, LottieComposition lottieComposition) {
        lottieDrawable.h0(lottieComposition);
        lottieDrawable.C0(-1);
        lottieDrawable.D0(1);
        lottieDrawable.setCallback(materialProgressButton.new AnimationCallback());
        lottieDrawable.p(new KeyPath("**"), LottieProperty.K, materialProgressButton.getColorCallback());
        lottieDrawable.a0();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.A) {
            canvas.save();
            canvas.translate((getWidth() - getProgressAnimation().getIntrinsicWidth()) / 2.0f, (getHeight() - getProgressAnimation().getIntrinsicHeight()) / 2.0f);
            getProgressAnimation().draw(canvas);
            canvas.restore();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i4) {
        super.onMeasure(i3, i4);
        if (this.A) {
            setMeasuredDimension(getMeasuredWidth(), RangesKt.f(getMeasuredHeight(), getProgressAnimation().getIntrinsicHeight() + getPaddingTop() + getPaddingBottom()));
        }
    }

    public final void setInProgress(boolean z2) {
        if (this.A != z2) {
            this.A = z2;
            setEnabled(!z2);
            if (!z2) {
                setText(getCachedText());
                setIcon(getCachedIcon());
                Integer cachedIconGravity = getCachedIconGravity();
                if (cachedIconGravity != null) {
                    setIconGravity(cachedIconGravity.intValue());
                    return;
                }
                return;
            }
            setCachedText(getText());
            setCachedIcon(getIcon());
            setCachedIconGravity(Integer.valueOf(getIconGravity()));
            getColorCallback().d(new PorterDuffColorFilter(getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
            setText((CharSequence) null);
            setIconGravity(2);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaterialProgressButton(final Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f130046v = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MaterialProgressButton.s();
            }
        });
        this.f130047w = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MaterialProgressButton.t(context, this);
            }
        });
        this.f130048x = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.view.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MaterialProgressButton.r(this.f132733a);
            }
        });
        this.f130049y = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.view.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MaterialProgressButton.q(this.f132904a);
            }
        });
        this.f130050z = new LazyMutable(new Function0() { // from class: cz.mobilesoft.coreblock.view.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return MaterialProgressButton.p(this.f132905a);
            }
        });
    }

    public /* synthetic */ MaterialProgressButton(Context context, AttributeSet attributeSet, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i3);
    }
}
