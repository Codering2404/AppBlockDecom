package androidx.compose.ui.geometry;

import kotlin.Metadata;

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
public final class RoundRectKt {
    public static final RoundRect a(float f3, float f4, float f5, float f6, float f7, float f8) {
        long jB = CornerRadius.b((((long) Float.floatToRawIntBits(f7)) << 32) | (((long) Float.floatToRawIntBits(f8)) & 4294967295L));
        return new RoundRect(f3, f4, f5, f6, jB, jB, jB, jB, null);
    }

    public static final RoundRect b(Rect rect, float f3, float f4) {
        return a(rect.o(), rect.r(), rect.p(), rect.i(), f3, f4);
    }

    public static final RoundRect c(Rect rect, long j3, long j4, long j5, long j6) {
        return new RoundRect(rect.o(), rect.r(), rect.p(), rect.i(), j3, j4, j5, j6, null);
    }

    public static final RoundRect d(float f3, float f4, float f5, float f6, long j3) {
        return a(f3, f4, f5, f6, Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public static final RoundRect e(Rect rect, long j3) {
        return b(rect, Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public static final Rect f(RoundRect roundRect) {
        return new Rect(roundRect.e(), roundRect.g(), roundRect.f(), roundRect.a());
    }

    public static final boolean g(RoundRect roundRect) {
        long jH = roundRect.h();
        return (jH >>> 32) == (jH & 4294967295L) && roundRect.h() == roundRect.i() && roundRect.h() == roundRect.c() && roundRect.h() == roundRect.b();
    }

    public static final RoundRect h(RoundRect roundRect, long j3) {
        int i3 = (int) (j3 >> 32);
        int i4 = (int) (4294967295L & j3);
        return new RoundRect(roundRect.e() + Float.intBitsToFloat(i3), roundRect.g() + Float.intBitsToFloat(i4), roundRect.f() + Float.intBitsToFloat(i3), Float.intBitsToFloat(i4) + roundRect.a(), roundRect.h(), roundRect.i(), roundRect.c(), roundRect.b(), null);
    }
}
