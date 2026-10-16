package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

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
public final class VectorConvertersKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TwoWayConverter f4287a = a(new Function1<Float, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        public final AnimationVector1D c(float f3) {
            return new AnimationVector1D(f3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).floatValue());
        }
    }, new Function1<AnimationVector1D, Float>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Float invoke(AnimationVector1D animationVector1D) {
            return Float.valueOf(animationVector1D.f());
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TwoWayConverter f4288b = a(new Function1<Integer, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        public final AnimationVector1D c(int i3) {
            return new AnimationVector1D(i3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).intValue());
        }
    }, new Function1<AnimationVector1D, Integer>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(AnimationVector1D animationVector1D) {
            return Integer.valueOf((int) animationVector1D.f());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TwoWayConverter f4289c = a(new Function1<Dp, AnimationVector1D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        public final AnimationVector1D c(float f3) {
            return new AnimationVector1D(f3);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Dp) obj).l());
        }
    }, new Function1<AnimationVector1D, Dp>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        public final float c(AnimationVector1D animationVector1D) {
            return Dp.g(animationVector1D.f());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Dp.d(c((AnimationVector1D) obj));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final TwoWayConverter f4290d = a(new Function1<DpOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D(DpOffset.f(j3), DpOffset.g(j3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((DpOffset) obj).j());
        }
    }, new Function1<AnimationVector2D, DpOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        public final long c(AnimationVector2D animationVector2D) {
            float fG = Dp.g(animationVector2D.f());
            float fG2 = Dp.g(animationVector2D.g());
            return DpOffset.c((((long) Float.floatToRawIntBits(fG)) << 32) | (((long) Float.floatToRawIntBits(fG2)) & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return DpOffset.b(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TwoWayConverter f4291e = a(new Function1<Size, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Size) obj).m());
        }
    }, new Function1<AnimationVector2D, Size>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        public final long c(AnimationVector2D animationVector2D) {
            float f3 = animationVector2D.f();
            float fG = animationVector2D.g();
            return Size.d((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fG)) & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Size.c(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TwoWayConverter f4292f = a(new Function1<Offset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Offset) obj).u());
        }
    }, new Function1<AnimationVector2D, Offset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        public final long c(AnimationVector2D animationVector2D) {
            float f3 = animationVector2D.f();
            float fG = animationVector2D.g();
            return Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(fG)) & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.d(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TwoWayConverter f4293g = a(new Function1<IntOffset, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D(IntOffset.k(j3), IntOffset.l(j3));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((IntOffset) obj).r());
        }
    }, new Function1<AnimationVector2D, IntOffset>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        public final long c(AnimationVector2D animationVector2D) {
            return IntOffset.f((((long) Math.round(animationVector2D.f())) << 32) | (((long) Math.round(animationVector2D.g())) & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.c(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final TwoWayConverter f4294h = a(new Function1<IntSize, AnimationVector2D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        public final AnimationVector2D c(long j3) {
            return new AnimationVector2D((int) (j3 >> 32), (int) (j3 & 4294967295L));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((IntSize) obj).j());
        }
    }, new Function1<AnimationVector2D, IntSize>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        public final long c(AnimationVector2D animationVector2D) {
            int iRound = Math.round(animationVector2D.f());
            if (iRound < 0) {
                iRound = 0;
            }
            int iRound2 = Math.round(animationVector2D.g());
            return IntSize.c((((long) (iRound2 >= 0 ? iRound2 : 0)) & 4294967295L) | (((long) iRound) << 32));
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.b(c((AnimationVector2D) obj));
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final TwoWayConverter f4295i = a(new Function1<Rect, AnimationVector4D>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final AnimationVector4D invoke(Rect rect) {
            return new AnimationVector4D(rect.o(), rect.r(), rect.p(), rect.i());
        }
    }, new Function1<AnimationVector4D, Rect>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Rect invoke(AnimationVector4D animationVector4D) {
            return new Rect(animationVector4D.f(), animationVector4D.g(), animationVector4D.h(), animationVector4D.i());
        }
    });

    public static final TwoWayConverter a(Function1 function1, Function1 function12) {
        return new TwoWayConverterImpl(function1, function12);
    }

    public static final TwoWayConverter b(Offset.Companion companion) {
        return f4292f;
    }

    public static final TwoWayConverter c(Rect.Companion companion) {
        return f4295i;
    }

    public static final TwoWayConverter d(Size.Companion companion) {
        return f4291e;
    }

    public static final TwoWayConverter e(Dp.Companion companion) {
        return f4289c;
    }

    public static final TwoWayConverter f(DpOffset.Companion companion) {
        return f4290d;
    }

    public static final TwoWayConverter g(IntOffset.Companion companion) {
        return f4293g;
    }

    public static final TwoWayConverter h(IntSize.Companion companion) {
        return f4294h;
    }

    public static final TwoWayConverter i(FloatCompanionObject floatCompanionObject) {
        return f4287a;
    }

    public static final TwoWayConverter j(IntCompanionObject intCompanionObject) {
        return f4288b;
    }
}
