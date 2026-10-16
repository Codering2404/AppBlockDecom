package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
public final class DashedBorderKt {
    public static final Modifier c(Modifier dashedBorder, float f3, long j3, Shape shape, float f4, float f5) {
        Intrinsics.checkNotNullParameter(dashedBorder, "$this$dashedBorder");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return d(dashedBorder, f3, new SolidColor(j3, null), shape, f4, f5);
    }

    public static final Modifier d(Modifier dashedBorder, final float f3, final Brush brush, final Shape shape, final float f4, final float f5) {
        Intrinsics.checkNotNullParameter(dashedBorder, "$this$dashedBorder");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(shape, "shape");
        return dashedBorder.then(DrawModifierKt.c(Modifier.b8, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.k8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DashedBorderKt.e(shape, f3, f4, f5, brush, (CacheDrawScope) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult e(Shape shape, float f3, float f4, float f5, final Brush brush, CacheDrawScope drawWithCache) {
        Ref.ObjectRef objectRef;
        Path pathB;
        Path pathA;
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(drawWithCache.b(), drawWithCache.getLayoutDirection(), drawWithCache);
        float fM1 = Dp.i(f3, Dp.f29970b.a()) ? 1.0f : drawWithCache.M1(f3);
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
        final Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        Ref.ObjectRef objectRef5 = new Ref.ObjectRef();
        if (fM1 <= 0.0f || Size.h(drawWithCache.b()) <= 0.0f) {
            objectRef = objectRef5;
        } else if (outlineMo29createOutlinePq9zytI instanceof Outline.Rectangle) {
            objectRef3.f140144a = new Stroke(fM1, 0.0f, 0, 0, PathEffect.Companion.b(PathEffect.f25832a, new float[]{drawWithCache.M1(f4), drawWithCache.M1(f5)}, 0.0f, 2, null), 14, null);
            floatRef = floatRef;
            objectRef = objectRef5;
        } else {
            objectRef = objectRef5;
            float f6 = fM1 * 1.2f;
            float f7 = 2;
            floatRef.f140141a = fM1 - (f6 / f7);
            objectRef2.f140144a = shape.mo29createOutlinePq9zytI(Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithCache.b() >> 32)) - (floatRef.f140141a * f7))) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithCache.b() & 4294967295L)) - (floatRef.f140141a * f7))) & 4294967295L)), drawWithCache.getLayoutDirection(), drawWithCache);
            objectRef3.f140144a = new Stroke(f6, 0.0f, 0, 0, PathEffect.Companion.b(PathEffect.f25832a, new float[]{drawWithCache.M1(f4), drawWithCache.M1(f5)}, 0.0f, 2, null), 14, null);
            if (outlineMo29createOutlinePq9zytI instanceof Outline.Rounded) {
                pathB = AndroidPath_androidKt.a();
                Path.s(pathB, ((Outline.Rounded) outlineMo29createOutlinePq9zytI).b(), null, 2, null);
            } else {
                pathB = outlineMo29createOutlinePq9zytI instanceof Outline.Generic ? ((Outline.Generic) outlineMo29createOutlinePq9zytI).b() : null;
            }
            objectRef4.f140144a = pathB;
            Object obj = objectRef2.f140144a;
            if ((obj instanceof Outline.Rounded) && !RoundRectKt.g(((Outline.Rounded) obj).b())) {
                Path pathA2 = AndroidPath_androidKt.a();
                Path.s(pathA2, ((Outline.Rounded) objectRef2.f140144a).b(), null, 2, null);
                float f8 = floatRef.f140141a;
                pathA2.p(Offset.e((((long) Float.floatToRawIntBits(f8)) & 4294967295L) | (((long) Float.floatToRawIntBits(f8)) << 32)));
                pathA = pathA2;
            } else if (objectRef2.f140144a instanceof Outline.Generic) {
                pathA = AndroidPath_androidKt.a();
                Path pathB2 = ((Outline.Generic) objectRef2.f140144a).b();
                float f9 = floatRef.f140141a;
                pathA.y(pathB2, Offset.e((((long) Float.floatToRawIntBits(f9)) & 4294967295L) | (((long) Float.floatToRawIntBits(f9)) << 32)));
            } else {
                pathA = null;
            }
            objectRef.f140144a = pathA;
        }
        final Ref.ObjectRef objectRef6 = objectRef;
        return drawWithCache.x(new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.l8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return DashedBorderKt.f(objectRef3, objectRef2, objectRef4, brush, floatRef, objectRef6, (ContentDrawScope) obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.Ref$ObjectRef] */
    /* JADX WARN: Type inference failed for: r1v10, types: [androidx.compose.ui.graphics.drawscope.DrawContext] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7, types: [androidx.compose.ui.graphics.drawscope.DrawContext] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [long] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v18, types: [long] */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    public static final Unit f(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Ref.ObjectRef objectRef3, Brush brush, Ref.FloatRef floatRef, Ref.ObjectRef objectRef4, ContentDrawScope onDrawWithContent) throws Throwable {
        ?? r12;
        ?? r2;
        ?? r13 = objectRef2;
        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.i2();
        Object obj = objectRef.f140144a;
        if (obj != null) {
            Object obj2 = r13.f140144a;
            if (obj2 == null || objectRef3.f140144a == null) {
                float f3 = ((Stroke) obj).f();
                float f4 = f3 / 2;
                DrawScope.k1(onDrawWithContent, brush, Offset.e((((long) Float.floatToRawIntBits(f4)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (onDrawWithContent.b() >> 32)) - f3)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (onDrawWithContent.b() & 4294967295L)) - f3)) & 4294967295L)), 0.0f, (DrawStyle) objectRef.f140144a, null, 0, 104, null);
            } else {
                boolean z2 = (obj2 instanceof Outline.Rounded) && RoundRectKt.g(((Outline.Rounded) obj2).b());
                DrawContext drawContextQ1 = onDrawWithContent.Q1();
                long jB = drawContextQ1.b();
                drawContextQ1.g().t();
                try {
                    DrawTransform drawTransformE = drawContextQ1.e();
                    Path path = (Path) objectRef3.f140144a;
                    DrawTransform.g(drawTransformE, path, 0, 2, null);
                    ?? r22 = path;
                    if (z2) {
                        float f5 = floatRef.f140141a;
                        drawTransformE.e(f5, f5);
                        r22 = f5;
                    }
                    try {
                        if (z2) {
                            Object obj3 = r13.f140144a;
                            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.ui.graphics.Outline.Rounded");
                            RoundRect roundRectB = ((Outline.Rounded) obj3).b();
                            long jE = Offset.e((((long) Float.floatToRawIntBits(roundRectB.g())) & 4294967295L) | (((long) Float.floatToRawIntBits(roundRectB.e())) << 32));
                            long jD = Size.d((((long) Float.floatToRawIntBits(roundRectB.d())) & 4294967295L) | (((long) Float.floatToRawIntBits(roundRectB.j())) << 32));
                            long jH = roundRectB.h();
                            r22 = jB;
                            r13 = drawContextQ1;
                            DrawScope.g2(onDrawWithContent, brush, jE, jD, jH, 0.0f, (DrawStyle) objectRef.f140144a, null, 0, 208, null);
                        } else {
                            DrawContext drawContext = drawContextQ1;
                            long j3 = jB;
                            Object obj4 = objectRef4.f140144a;
                            r13 = drawContext;
                            r22 = j3;
                            if (obj4 != null) {
                                DrawScope.F1(onDrawWithContent, (Path) obj4, brush, 0.0f, (DrawStyle) objectRef.f140144a, null, 0, 52, null);
                                r13 = drawContext;
                                r22 = j3;
                            }
                        }
                        r13.g().k();
                        r13.h(r22);
                    } catch (Throwable th) {
                        th = th;
                        r12 = r13;
                        r2 = r22;
                        r12.g().k();
                        r12.h(r2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r12 = drawContextQ1;
                    r2 = jB;
                }
            }
        }
        return Unit.f139807a;
    }
}
