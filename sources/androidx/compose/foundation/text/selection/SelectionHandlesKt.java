package androidx.compose.foundation.text.selection;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.Dp;
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
public final class SelectionHandlesKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f11384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f11385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SemanticsPropertyKey f11386c = new SemanticsPropertyKey("SelectionHandleInfo", null, 2, null);

    static {
        float f3 = 25;
        f11384a = Dp.g(f3);
        f11385b = Dp.g(f3);
    }

    public static final long a(long j3) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        return Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L)) - 1.0f)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32));
    }

    public static final float b() {
        return f11385b;
    }

    public static final float c() {
        return f11384a;
    }

    public static final SemanticsPropertyKey d() {
        return f11386c;
    }

    public static final boolean e(ResolvedTextDirection resolvedTextDirection, boolean z2) {
        if (resolvedTextDirection != ResolvedTextDirection.f29612a || z2) {
            return resolvedTextDirection == ResolvedTextDirection.f29613b && z2;
        }
        return true;
    }

    public static final boolean f(boolean z2, ResolvedTextDirection resolvedTextDirection, boolean z3) {
        return z2 ? e(resolvedTextDirection, z3) : !e(resolvedTextDirection, z3);
    }
}
