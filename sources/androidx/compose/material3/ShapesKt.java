package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

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
public final class ShapesKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ProvidableCompositionLocal f19841a = CompositionLocalKt.g(new Function0<Shapes>() { // from class: androidx.compose.material3.ShapesKt$LocalShapes$1
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Shapes invoke() {
            return new Shapes(null, null, null, null, null, 31, null);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f19843a;

        static {
            int[] iArr = new int[ShapeKeyTokens.values().length];
            try {
                iArr[ShapeKeyTokens.CornerExtraLarge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraLargeTop.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraSmall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ShapeKeyTokens.CornerExtraSmallTop.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ShapeKeyTokens.CornerFull.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLarge.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLargeEnd.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[ShapeKeyTokens.CornerLargeTop.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[ShapeKeyTokens.CornerMedium.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[ShapeKeyTokens.CornerNone.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[ShapeKeyTokens.CornerSmall.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            f19843a = iArr;
        }
    }

    public static final CornerBasedShape a(CornerBasedShape cornerBasedShape) {
        float f3 = (float) 0.0d;
        return CornerBasedShape.c(cornerBasedShape, CornerSizeKt.c(Dp.g(f3)), CornerSizeKt.c(Dp.g(f3)), null, null, 12, null);
    }

    public static final CornerBasedShape b(CornerBasedShape cornerBasedShape) {
        float f3 = (float) 0.0d;
        return CornerBasedShape.c(cornerBasedShape, CornerSizeKt.c(Dp.g(f3)), null, null, CornerSizeKt.c(Dp.g(f3)), 6, null);
    }

    public static final Shape c(Shapes shapes, ShapeKeyTokens shapeKeyTokens) {
        switch (WhenMappings.f19843a[shapeKeyTokens.ordinal()]) {
            case 1:
                return shapes.a();
            case 2:
                return g(shapes.a());
            case 3:
                return shapes.b();
            case 4:
                return g(shapes.b());
            case 5:
                return RoundedCornerShapeKt.g();
            case 6:
                return shapes.c();
            case 7:
                return b(shapes.c());
            case 8:
                return g(shapes.c());
            case 9:
                return shapes.d();
            case 10:
                return RectangleShapeKt.a();
            case 11:
                return shapes.e();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final ProvidableCompositionLocal d() {
        return f19841a;
    }

    public static final Shape e(ShapeKeyTokens shapeKeyTokens, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1629172543, i3, -1, "androidx.compose.material3.<get-value> (Shapes.kt:191)");
        }
        Shape shapeC = c(MaterialTheme.f18110a.b(composer, 6), shapeKeyTokens);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeC;
    }

    public static final CornerBasedShape f(CornerBasedShape cornerBasedShape) {
        float f3 = (float) 0.0d;
        return CornerBasedShape.c(cornerBasedShape, null, CornerSizeKt.c(Dp.g(f3)), CornerSizeKt.c(Dp.g(f3)), null, 9, null);
    }

    public static final CornerBasedShape g(CornerBasedShape cornerBasedShape) {
        float f3 = (float) 0.0d;
        return CornerBasedShape.c(cornerBasedShape, null, null, CornerSizeKt.c(Dp.g(f3)), CornerSizeKt.c(Dp.g(f3)), 3, null);
    }
}
