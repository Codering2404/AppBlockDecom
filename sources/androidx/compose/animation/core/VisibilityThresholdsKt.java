package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
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
public final class VisibilityThresholdsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Rect f4376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map f4377b;

    static {
        Float fValueOf = Float.valueOf(0.5f);
        f4376a = new Rect(0.5f, 0.5f, 0.5f, 0.5f);
        TwoWayConverter twoWayConverterJ = VectorConvertersKt.j(IntCompanionObject.f140132a);
        Float fValueOf2 = Float.valueOf(1.0f);
        Pair pairA = TuplesKt.a(twoWayConverterJ, fValueOf2);
        Pair pairA2 = TuplesKt.a(VectorConvertersKt.h(IntSize.f29998b), fValueOf2);
        Pair pairA3 = TuplesKt.a(VectorConvertersKt.g(IntOffset.f29988b), fValueOf2);
        Pair pairA4 = TuplesKt.a(VectorConvertersKt.i(FloatCompanionObject.f140130a), Float.valueOf(0.01f));
        Pair pairA5 = TuplesKt.a(VectorConvertersKt.c(Rect.f25601e), fValueOf);
        Pair pairA6 = TuplesKt.a(VectorConvertersKt.d(Size.f25617b), fValueOf);
        Pair pairA7 = TuplesKt.a(VectorConvertersKt.b(Offset.f25596b), fValueOf);
        TwoWayConverter twoWayConverterE = VectorConvertersKt.e(Dp.f29970b);
        Float fValueOf3 = Float.valueOf(0.1f);
        f4377b = MapsKt.mapOf(pairA, pairA2, pairA3, pairA4, pairA5, pairA6, pairA7, TuplesKt.a(twoWayConverterE, fValueOf3), TuplesKt.a(VectorConvertersKt.f(DpOffset.f29975b), fValueOf3));
    }

    public static final float a(Dp.Companion companion) {
        return Dp.g(0.1f);
    }

    public static final int b(IntCompanionObject intCompanionObject) {
        return 1;
    }

    public static final long c(Offset.Companion companion) {
        return Offset.e((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L));
    }

    public static final long d(Size.Companion companion) {
        return Size.d((((long) Float.floatToRawIntBits(0.5f)) << 32) | (((long) Float.floatToRawIntBits(0.5f)) & 4294967295L));
    }

    public static final long e(IntOffset.Companion companion) {
        long j3 = 1;
        return IntOffset.f((j3 & 4294967295L) | (j3 << 32));
    }

    public static final long f(IntSize.Companion companion) {
        long j3 = 1;
        return IntSize.c((j3 & 4294967295L) | (j3 << 32));
    }

    public static final Rect g(Rect.Companion companion) {
        return f4376a;
    }

    public static final Map h() {
        return f4377b;
    }
}
