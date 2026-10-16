package com.valentinilk.shimmer;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerEffect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f93800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f93801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f93802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f93803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f93804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f93805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Animatable f93806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Matrix f93807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Shader f93808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Paint f93809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Paint f93810k;

    public /* synthetic */ ShimmerEffect(AnimationSpec animationSpec, int i3, float f3, List list, List list2, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(animationSpec, i3, f3, list, list2, f4);
    }

    public final void a(ContentDrawScope contentDrawScope, ShimmerArea shimmerArea) {
        Intrinsics.checkNotNullParameter(contentDrawScope, "<this>");
        Intrinsics.checkNotNullParameter(shimmerArea, "shimmerArea");
        if (shimmerArea.d().y() || shimmerArea.f().y()) {
            return;
        }
        float fE = ((-shimmerArea.e()) / 2) + (shimmerArea.e() * ((Number) this.f93806g.n()).floatValue()) + Offset.m(shimmerArea.c());
        Matrix matrix = this.f93807h;
        matrix.reset();
        matrix.postTranslate(fE, 0.0f);
        matrix.postRotate(this.f93802c, Offset.m(shimmerArea.c()), Offset.n(shimmerArea.c()));
        this.f93808i.setLocalMatrix(this.f93807h);
        Rect rectC = SizeKt.c(contentDrawScope.b());
        Canvas canvasG = contentDrawScope.Q1().g();
        try {
            canvasG.p(rectC, this.f93810k);
            contentDrawScope.i2();
            canvasG.y(rectC, this.f93809j);
        } finally {
            canvasG.k();
        }
    }

    public final Object b(Continuation continuation) {
        Object objF = Animatable.f(this.f93806g, Boxing.c(1.0f), this.f93800a, null, null, continuation, 12, null);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual(ShimmerEffect.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.valentinilk.shimmer.ShimmerEffect");
        ShimmerEffect shimmerEffect = (ShimmerEffect) obj;
        return Intrinsics.areEqual(this.f93800a, shimmerEffect.f93800a) && BlendMode.F(this.f93801b, shimmerEffect.f93801b) && this.f93802c == shimmerEffect.f93802c && Intrinsics.areEqual(this.f93803d, shimmerEffect.f93803d) && Intrinsics.areEqual(this.f93804e, shimmerEffect.f93804e) && this.f93805f == shimmerEffect.f93805f;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f93800a.hashCode() * 31) + BlendMode.G(this.f93801b)) * 31) + Float.hashCode(this.f93802c)) * 31) + this.f93803d.hashCode()) * 31;
        List list = this.f93804e;
        return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + Float.hashCode(this.f93805f);
    }

    private ShimmerEffect(AnimationSpec animationSpec, int i3, float f3, List list, List list2, float f4) {
        this.f93800a = animationSpec;
        this.f93801b = i3;
        this.f93802c = f3;
        this.f93803d = list;
        this.f93804e = list2;
        this.f93805f = f4;
        this.f93806g = AnimatableKt.b(0.0f, 0.0f, 2, null);
        this.f93807h = new Matrix();
        float f5 = 2;
        Shader shaderB = ShaderKt.b(OffsetKt.a((-f4) / f5, 0.0f), OffsetKt.a(f4 / f5, 0.0f), list, list2, 0, 16, null);
        this.f93808i = shaderB;
        Paint paintA = AndroidPaint_androidKt.a();
        paintA.n(true);
        paintA.E(PaintingStyle.f25822b.a());
        paintA.p(i3);
        paintA.z(shaderB);
        this.f93809j = paintA;
        this.f93810k = AndroidPaint_androidKt.a();
    }
}
