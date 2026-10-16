package androidx.compose.foundation;

import android.view.View;
import android.widget.Magnifier;
import androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
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
public final class PlatformMagnifierFactoryApi29Impl implements PlatformMagnifierFactory {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PlatformMagnifierFactoryApi29Impl f5112b = new PlatformMagnifierFactoryApi29Impl();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final boolean f5113c = true;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlatformMagnifierImpl extends PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl {
        public PlatformMagnifierImpl(Magnifier magnifier) {
            super(magnifier);
        }

        @Override // androidx.compose.foundation.PlatformMagnifierFactoryApi28Impl.PlatformMagnifierImpl, androidx.compose.foundation.PlatformMagnifier
        public void b(long j3, long j4, float f3) {
            if (!Float.isNaN(f3)) {
                d().setZoom(f3);
            }
            if ((9223372034707292159L & j4) != 9205357640488583168L) {
                d().show(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)), Float.intBitsToFloat((int) (j4 >> 32)), Float.intBitsToFloat((int) (j4 & 4294967295L)));
            } else {
                d().show(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
            }
        }
    }

    private PlatformMagnifierFactoryApi29Impl() {
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    public boolean b() {
        return f5113c;
    }

    @Override // androidx.compose.foundation.PlatformMagnifierFactory
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public PlatformMagnifierImpl a(View view, boolean z2, long j3, float f3, float f4, boolean z3, Density density, float f5) {
        if (z2) {
            return new PlatformMagnifierImpl(new Magnifier(view));
        }
        long jM = density.M(j3);
        float fM1 = density.M1(f3);
        float fM12 = density.M1(f4);
        Magnifier.Builder builder = new Magnifier.Builder(view);
        if (jM != 9205357640488583168L) {
            builder.setSize(MathKt.d(Float.intBitsToFloat((int) (jM >> 32))), MathKt.d(Float.intBitsToFloat((int) (jM & 4294967295L))));
        }
        if (!Float.isNaN(fM1)) {
            builder.setCornerRadius(fM1);
        }
        if (!Float.isNaN(fM12)) {
            builder.setElevation(fM12);
        }
        if (!Float.isNaN(f5)) {
            builder.setInitialZoom(f5);
        }
        builder.setClippingEnabled(z3);
        return new PlatformMagnifierImpl(builder.build());
    }
}
