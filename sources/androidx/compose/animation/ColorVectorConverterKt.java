package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ColorVectorConverterKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f3436a = new Function1<ColorSpace, TwoWayConverter<Color, AnimationVector4D>>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final TwoWayConverter invoke(final ColorSpace colorSpace) {
            return VectorConvertersKt.a(new Function1<Color, AnimationVector4D>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                public final AnimationVector4D c(long j3) {
                    long jP = Color.p(j3, ColorSpaces.f25979a.D());
                    return new AnimationVector4D(Color.u(jP), Color.y(jP), Color.x(jP), Color.v(jP));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return c(((Color) obj).B());
                }
            }, new Function1<AnimationVector4D, Color>() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                public final long c(AnimationVector4D animationVector4D) {
                    float fG = animationVector4D.g();
                    if (fG < 0.0f) {
                        fG = 0.0f;
                    }
                    if (fG > 1.0f) {
                        fG = 1.0f;
                    }
                    float fH = animationVector4D.h();
                    if (fH < -0.5f) {
                        fH = -0.5f;
                    }
                    if (fH > 0.5f) {
                        fH = 0.5f;
                    }
                    float fI = animationVector4D.i();
                    float f3 = fI >= -0.5f ? fI : -0.5f;
                    float f4 = f3 <= 0.5f ? f3 : 0.5f;
                    float f5 = animationVector4D.f();
                    float f6 = f5 >= 0.0f ? f5 : 0.0f;
                    return Color.p(ColorKt.a(fG, fH, f4, f6 <= 1.0f ? f6 : 1.0f, ColorSpaces.f25979a.D()), colorSpace);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Color.n(c((AnimationVector4D) obj));
                }
            });
        }
    };

    public static final Function1 a(Color.Companion companion) {
        return f3436a;
    }
}
