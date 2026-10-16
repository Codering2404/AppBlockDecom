package androidx.compose.foundation;

import android.os.Build;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpSize;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class Magnifier_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SemanticsPropertyKey f5024a = new SemanticsPropertyKey("MagnifierPositionInRoot", null, 2, null);

    public static final boolean a(float f3, float f4) {
        return (Float.isNaN(f3) && Float.isNaN(f4)) || f3 == f4;
    }

    public static final SemanticsPropertyKey b() {
        return f5024a;
    }

    public static final boolean c(int i3) {
        return i3 >= 28;
    }

    public static /* synthetic */ boolean d(int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = Build.VERSION.SDK_INT;
        }
        return c(i3);
    }

    public static final Modifier e(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory) {
        if (d(0, 1, null)) {
            return modifier.then(new MagnifierElement(function1, function12, function13, f3, z2, j3, f4, f5, z3, platformMagnifierFactory == null ? PlatformMagnifierFactory.f5107a.a() : platformMagnifierFactory, null));
        }
        return modifier;
    }

    public static /* synthetic */ Modifier f(Modifier modifier, Function1 function1, Function1 function12, Function1 function13, float f3, boolean z2, long j3, float f4, float f5, boolean z3, PlatformMagnifierFactory platformMagnifierFactory, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function12 = null;
        }
        if ((i3 & 4) != 0) {
            function13 = null;
        }
        if ((i3 & 8) != 0) {
            f3 = Float.NaN;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            j3 = DpSize.f29984b.a();
        }
        if ((i3 & 64) != 0) {
            f4 = Dp.f29970b.c();
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            f5 = Dp.f29970b.c();
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z3 = true;
        }
        if ((i3 & 512) != 0) {
            platformMagnifierFactory = null;
        }
        return e(modifier, function1, function12, function13, f3, z2, j3, f4, f5, z3, platformMagnifierFactory);
    }
}
