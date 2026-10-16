package androidx.compose.material.ripple;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RippleHostView extends View {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f15392g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f15393h = 8;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int[] f15394i = {android.R.attr.state_pressed, android.R.attr.state_enabled};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int[] f15395j = new int[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnprojectedRipple f15396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Boolean f15397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Long f15398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f15399d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function0 f15400f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RippleHostView(Context context) {
        super(context);
    }

    private final void c(boolean z2) {
        UnprojectedRipple unprojectedRipple = new UnprojectedRipple(z2);
        setBackground(unprojectedRipple);
        this.f15396a = unprojectedRipple;
    }

    private final void setRippleState(boolean z2) {
        long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Runnable runnable = this.f15399d;
        if (runnable != null) {
            removeCallbacks(runnable);
            runnable.run();
        }
        Long l3 = this.f15398c;
        long jLongValue = jCurrentAnimationTimeMillis - (l3 != null ? l3.longValue() : 0L);
        if (z2 || jLongValue >= 5) {
            int[] iArr = z2 ? f15394i : f15395j;
            UnprojectedRipple unprojectedRipple = this.f15396a;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(iArr);
            }
        } else {
            Runnable runnable2 = new Runnable() { // from class: androidx.compose.material.ripple.a
                @Override // java.lang.Runnable
                public final void run() {
                    RippleHostView.setRippleState$lambda$2(this.f15447a);
                }
            };
            this.f15399d = runnable2;
            postDelayed(runnable2, 50L);
        }
        this.f15398c = Long.valueOf(jCurrentAnimationTimeMillis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setRippleState$lambda$2(RippleHostView rippleHostView) {
        UnprojectedRipple unprojectedRipple = rippleHostView.f15396a;
        if (unprojectedRipple != null) {
            unprojectedRipple.setState(f15395j);
        }
        rippleHostView.f15399d = null;
    }

    public final void b(PressInteraction.Press press, boolean z2, long j3, int i3, long j4, float f3, Function0 function0) {
        if (this.f15396a == null || !Intrinsics.areEqual(Boolean.valueOf(z2), this.f15397b)) {
            c(z2);
            this.f15397b = Boolean.valueOf(z2);
        }
        UnprojectedRipple unprojectedRipple = this.f15396a;
        Intrinsics.checkNotNull(unprojectedRipple);
        this.f15400f = function0;
        unprojectedRipple.c(i3);
        f(j3, j4, f3);
        if (z2) {
            unprojectedRipple.setHotspot(Offset.m(press.a()), Offset.n(press.a()));
        } else {
            unprojectedRipple.setHotspot(unprojectedRipple.getBounds().centerX(), unprojectedRipple.getBounds().centerY());
        }
        setRippleState(true);
    }

    public final void d() {
        this.f15400f = null;
        Runnable runnable = this.f15399d;
        if (runnable != null) {
            removeCallbacks(runnable);
            Runnable runnable2 = this.f15399d;
            Intrinsics.checkNotNull(runnable2);
            runnable2.run();
        } else {
            UnprojectedRipple unprojectedRipple = this.f15396a;
            if (unprojectedRipple != null) {
                unprojectedRipple.setState(f15395j);
            }
        }
        UnprojectedRipple unprojectedRipple2 = this.f15396a;
        if (unprojectedRipple2 == null) {
            return;
        }
        unprojectedRipple2.setVisible(false, false);
        unscheduleDrawable(unprojectedRipple2);
    }

    public final void e() {
        setRippleState(false);
    }

    public final void f(long j3, long j4, float f3) {
        UnprojectedRipple unprojectedRipple = this.f15396a;
        if (unprojectedRipple == null) {
            return;
        }
        unprojectedRipple.b(j4, f3);
        Rect rect = new Rect(0, 0, MathKt.d(Size.i(j3)), MathKt.d(Size.g(j3)));
        setLeft(rect.left);
        setTop(rect.top);
        setRight(rect.right);
        setBottom(rect.bottom);
        unprojectedRipple.setBounds(rect);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Function0 function0 = this.f15400f;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i4) {
        setMeasuredDimension(0, 0);
    }

    @Override // android.view.View
    public void refreshDrawableState() {
    }

    @Override // android.view.View
    protected void onLayout(boolean z2, int i3, int i4, int i5, int i6) {
    }
}
