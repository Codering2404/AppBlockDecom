package androidx.compose.foundation.gestures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
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
public final class ScrollableStateKt {
    public static final ScrollableState a(Function1 function1) {
        return new DefaultScrollableState(function1);
    }

    public static final ScrollableState b(Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-180460798, i3, -1, "androidx.compose.foundation.gestures.rememberScrollableState (ScrollableState.kt:159)");
        }
        final State stateP = SnapshotStateKt.p(function1, composer, i3 & 14);
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.gestures.ScrollableStateKt$rememberScrollableState$1$1
                {
                    super(1);
                }

                public final Float c(float f3) {
                    return (Float) ((Function1) stateP.getValue()).invoke(Float.valueOf(f3));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return c(((Number) obj).floatValue());
                }
            });
            composer.w(objG);
        }
        ScrollableState scrollableState = (ScrollableState) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return scrollableState;
    }
}
