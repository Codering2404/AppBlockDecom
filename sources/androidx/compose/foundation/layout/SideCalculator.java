package androidx.compose.foundation.layout;

import android.graphics.Insets;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
interface SideCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f7104a = Companion.f7105a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f7105a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final SideCalculator$Companion$LeftSideCalculator$1 f7106b = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$LeftSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets c(Insets insets, int i3) {
                return Insets.of(i3, insets.top, insets.right, insets.bottom);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int e(Insets insets) {
                return insets.left;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long f(long j3) {
                return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long g(long j3, float f3) {
                return VelocityKt.a(Velocity.h(j3) - f3, 0.0f);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float b(float f3, float f4) {
                return f3;
            }
        };

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final SideCalculator$Companion$TopSideCalculator$1 f7107c = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$TopSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets c(Insets insets, int i3) {
                return Insets.of(insets.left, i3, insets.right, insets.bottom);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int e(Insets insets) {
                return insets.top;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long f(long j3) {
                return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long g(long j3, float f3) {
                return VelocityKt.a(0.0f, Velocity.i(j3) - f3);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public float b(float f3, float f4) {
                return f4;
            }
        };

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final SideCalculator$Companion$RightSideCalculator$1 f7108d = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$RightSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float b(float f3, float f4) {
                return -f3;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets c(Insets insets, int i3) {
                return Insets.of(insets.left, insets.top, i3, insets.bottom);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int e(Insets insets) {
                return insets.right;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long f(long j3) {
                return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 >> 32)))) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long g(long j3, float f3) {
                return VelocityKt.a(Velocity.h(j3) + f3, 0.0f);
            }
        };

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final SideCalculator$Companion$BottomSideCalculator$1 f7109e = new SideCalculator() { // from class: androidx.compose.foundation.layout.SideCalculator$Companion$BottomSideCalculator$1
            @Override // androidx.compose.foundation.layout.SideCalculator
            public float b(float f3, float f4) {
                return -f4;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public Insets c(Insets insets, int i3) {
                return Insets.of(insets.left, insets.top, insets.right, i3);
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public int e(Insets insets) {
                return insets.bottom;
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long f(long j3) {
                return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)))) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
            }

            @Override // androidx.compose.foundation.layout.SideCalculator
            public long g(long j3, float f3) {
                return VelocityKt.a(0.0f, Velocity.i(j3) + f3);
            }
        };

        private Companion() {
        }

        public final SideCalculator a(int i3, LayoutDirection layoutDirection) {
            WindowInsetsSides.Companion companion = WindowInsetsSides.f7284b;
            if (WindowInsetsSides.o(i3, companion.h())) {
                return f7106b;
            }
            if (WindowInsetsSides.o(i3, companion.k())) {
                return f7107c;
            }
            if (WindowInsetsSides.o(i3, companion.i())) {
                return f7108d;
            }
            if (WindowInsetsSides.o(i3, companion.e())) {
                return f7109e;
            }
            if (WindowInsetsSides.o(i3, companion.j())) {
                return layoutDirection == LayoutDirection.f30001a ? f7106b : f7108d;
            }
            if (WindowInsetsSides.o(i3, companion.f())) {
                return layoutDirection == LayoutDirection.f30001a ? f7108d : f7106b;
            }
            throw new IllegalStateException("Only Left, Top, Right, Bottom, Start and End are allowed");
        }
    }

    default float a(float f3, float f4) {
        return RangesKt.e(b(f3, f4), 0.0f);
    }

    float b(float f3, float f4);

    Insets c(Insets insets, int i3);

    default float d(float f3, float f4) {
        return RangesKt.j(b(f3, f4), 0.0f);
    }

    int e(Insets insets);

    long f(long j3);

    long g(long j3, float f3);
}
