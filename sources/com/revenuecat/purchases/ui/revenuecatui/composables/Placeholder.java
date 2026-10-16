package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.unit.LayoutDirection;
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
public final class Placeholder {
    public static final int $stable = 0;
    private final long color;
    private final Animatable<Float, AnimationVector1D> contentAlpha;
    private final Function0<FiniteAnimationSpec<Float>> contentFadeTransitionSpec;
    private final PlaceholderHighlight highlight;
    private final Animatable<Float, AnimationVector1D> highlightProgress;
    private LayoutDirection lastLayoutDirection;
    private Outline lastOutline;
    private Size lastSize;
    private final Paint paint;
    private final Animatable<Float, AnimationVector1D> placeholderAlpha;
    private final Function0<FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec;
    private final Shape shape;
    private final boolean visible;

    public /* synthetic */ Placeholder(boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, j3, shape, placeholderHighlight, function0, function02);
    }

    private final boolean component1() {
        return this.visible;
    }

    /* JADX INFO: renamed from: component2-0d7_KjU, reason: not valid java name */
    private final long m915component20d7_KjU() {
        return this.color;
    }

    private final Shape component3() {
        return this.shape;
    }

    private final PlaceholderHighlight component4() {
        return this.highlight;
    }

    private final Function0<FiniteAnimationSpec<Float>> component5() {
        return this.placeholderFadeTransitionSpec;
    }

    private final Function0<FiniteAnimationSpec<Float>> component6() {
        return this.contentFadeTransitionSpec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: copy-3IgeMak$default, reason: not valid java name */
    public static /* synthetic */ Placeholder m916copy3IgeMak$default(Placeholder placeholder, boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = placeholder.visible;
        }
        if ((i3 & 2) != 0) {
            j3 = placeholder.color;
        }
        if ((i3 & 4) != 0) {
            shape = placeholder.shape;
        }
        if ((i3 & 8) != 0) {
            placeholderHighlight = placeholder.highlight;
        }
        if ((i3 & 16) != 0) {
            function0 = placeholder.placeholderFadeTransitionSpec;
        }
        if ((i3 & 32) != 0) {
            function02 = placeholder.contentFadeTransitionSpec;
        }
        return placeholder.m917copy3IgeMak(z2, j3, shape, placeholderHighlight, function0, function02);
    }

    /* JADX INFO: renamed from: copy-3IgeMak, reason: not valid java name */
    public final Placeholder m917copy3IgeMak(boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec, Function0<? extends FiniteAnimationSpec<Float>> contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        return new Placeholder(z2, j3, shape, placeholderHighlight, placeholderFadeTransitionSpec, contentFadeTransitionSpec, null);
    }

    public final void draw$revenuecatui_defaultsBc8Release(ContentDrawScope contentDrawScope) {
        ContentDrawScope contentDrawScope2;
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        float fFloatValue = ((Number) this.placeholderAlpha.n()).floatValue();
        float fFloatValue2 = ((Number) this.contentAlpha.n()).floatValue();
        if (fFloatValue2 > 0.01f) {
            this.paint.c(fFloatValue2);
            Paint paint = this.paint;
            Canvas canvasG = contentDrawScope.Q1().g();
            canvasG.p(SizeKt.c(contentDrawScope.b()), paint);
            contentDrawScope.i2();
            canvasG.k();
        }
        if (fFloatValue > 0.01f) {
            this.paint.c(fFloatValue);
            Paint paint2 = this.paint;
            Canvas canvasG2 = contentDrawScope.Q1().g();
            canvasG2.p(SizeKt.c(contentDrawScope.b()), paint2);
            contentDrawScope2 = contentDrawScope;
            this.lastOutline = PlaceholderKt.m919drawPlaceholderhpmOzss(contentDrawScope2, this.shape, this.color, this.highlight, ((Number) this.highlightProgress.n()).floatValue(), this.lastOutline, this.lastLayoutDirection, this.lastSize);
            canvasG2.k();
        } else {
            contentDrawScope2 = contentDrawScope;
        }
        this.lastSize = Size.c(contentDrawScope2.b());
        this.lastLayoutDirection = contentDrawScope2.getLayoutDirection();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return this.visible == placeholder.visible && Color.t(this.color, placeholder.color) && Intrinsics.areEqual(this.shape, placeholder.shape) && Intrinsics.areEqual(this.highlight, placeholder.highlight) && Intrinsics.areEqual(this.placeholderFadeTransitionSpec, placeholder.placeholderFadeTransitionSpec) && Intrinsics.areEqual(this.contentFadeTransitionSpec, placeholder.contentFadeTransitionSpec);
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.visible) * 31) + Color.z(this.color)) * 31) + this.shape.hashCode()) * 31;
        PlaceholderHighlight placeholderHighlight = this.highlight;
        return ((((iHashCode + (placeholderHighlight == null ? 0 : placeholderHighlight.hashCode())) * 31) + this.placeholderFadeTransitionSpec.hashCode()) * 31) + this.contentFadeTransitionSpec.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0111, code lost:
    
        if (androidx.compose.animation.core.Animatable.f(r3, r1, r5, null, null, r8, 12, null) == r2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0125, code lost:
    
        if (r1.u(r3, r8) == r2) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object startAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation<? super kotlin.Unit> r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.startAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0070, code lost:
    
        if (r7.v(r0) != r1) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object stopAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1
            if (r0 == 0) goto L13
            r0 = r7
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder$stopAnimation$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L47
            if (r2 == r5) goto L3f
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            kotlin.ResultKt.b(r7)
            goto L73
        L2f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L37:
            java.lang.Object r2 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r2 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder) r2
            kotlin.ResultKt.b(r7)
            goto L65
        L3f:
            java.lang.Object r2 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder r2 = (com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder) r2
            kotlin.ResultKt.b(r7)
            goto L58
        L47:
            kotlin.ResultKt.b(r7)
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7 = r6.placeholderAlpha
            r0.L$0 = r6
            r0.label = r5
            java.lang.Object r7 = r7.v(r0)
            if (r7 != r1) goto L57
            goto L72
        L57:
            r2 = r6
        L58:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7 = r2.contentAlpha
            r0.L$0 = r2
            r0.label = r4
            java.lang.Object r7 = r7.v(r0)
            if (r7 != r1) goto L65
            goto L72
        L65:
            androidx.compose.animation.core.Animatable<java.lang.Float, androidx.compose.animation.core.AnimationVector1D> r7 = r2.highlightProgress
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.v(r0)
            if (r7 != r1) goto L73
        L72:
            return r1
        L73:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.stopAnimation$revenuecatui_defaultsBc8Release(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public String toString() {
        return "Placeholder(visible=" + this.visible + ", color=" + ((Object) Color.A(this.color)) + ", shape=" + this.shape + ", highlight=" + this.highlight + ", placeholderFadeTransitionSpec=" + this.placeholderFadeTransitionSpec + ", contentFadeTransitionSpec=" + this.contentFadeTransitionSpec + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Placeholder(boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0<? extends FiniteAnimationSpec<Float>> placeholderFadeTransitionSpec, Function0<? extends FiniteAnimationSpec<Float>> contentFadeTransitionSpec) {
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(placeholderFadeTransitionSpec, "placeholderFadeTransitionSpec");
        Intrinsics.checkNotNullParameter(contentFadeTransitionSpec, "contentFadeTransitionSpec");
        this.visible = z2;
        this.color = j3;
        this.shape = shape;
        this.highlight = placeholderHighlight;
        this.placeholderFadeTransitionSpec = placeholderFadeTransitionSpec;
        this.contentFadeTransitionSpec = contentFadeTransitionSpec;
        this.placeholderAlpha = AnimatableKt.b(z2 ? 1.0f : 0.0f, 0.0f, 2, null);
        this.contentAlpha = AnimatableKt.b(z2 ? 0.0f : 1.0f, 0.0f, 2, null);
        this.highlightProgress = AnimatableKt.b(0.0f, 0.0f, 2, null);
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.n(true);
        paintA.E(PaintingStyle.f25822b.a());
        paintA.p(paintA.m());
        this.paint = paintA;
    }

    public /* synthetic */ Placeholder(boolean z2, long j3, Shape shape, PlaceholderHighlight placeholderHighlight, Function0 function0, Function0 function02, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, j3, (i3 & 4) != 0 ? RectangleShapeKt.a() : shape, (i3 & 8) != 0 ? null : placeholderHighlight, (i3 & 16) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.1
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function0, (i3 & 32) != 0 ? new Function0<SpringSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.Placeholder.2
            @Override // kotlin.jvm.functions.Function0
            public final SpringSpec<Float> invoke() {
                return AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
            }
        } : function02, null);
    }
}
