package androidx.compose.animation;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

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
public final class AnimationModifierKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final long f3393a;

    static {
        long j3 = Integer.MIN_VALUE;
        f3393a = IntSize.c((j3 & 4294967295L) | (j3 << 32));
    }

    public static final Modifier a(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function2 function2) {
        return ClipKt.b(modifier).then(new SizeAnimationModifierElement(finiteAnimationSpec, Alignment.f25072a.o(), function2));
    }

    public static /* synthetic */ Modifier b(Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            finiteAnimationSpec = AnimationSpecKt.l(0.0f, 400.0f, IntSize.b(VisibilityThresholdsKt.f(IntSize.f29998b)), 1, null);
        }
        if ((i3 & 2) != 0) {
            function2 = null;
        }
        return a(modifier, finiteAnimationSpec, function2);
    }

    public static final long c() {
        return f3393a;
    }

    public static final boolean d(long j3) {
        return !IntSize.e(j3, f3393a);
    }
}
