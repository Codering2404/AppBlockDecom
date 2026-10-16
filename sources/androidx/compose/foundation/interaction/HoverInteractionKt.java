package androidx.compose.foundation.interaction;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
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
public final class HoverInteractionKt {
    public static final State a(InteractionSource interactionSource, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1206586544, i3, -1, "androidx.compose.foundation.interaction.collectIsHoveredAsState (HoverInteraction.kt:63)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
            composer.w(objG);
        }
        MutableState mutableState = (MutableState) objG;
        int i4 = i3 & 14;
        boolean z2 = ((i4 ^ 6) > 4 && composer.Z(interactionSource)) || (i3 & 6) == 4;
        Object objG2 = composer.G();
        if (z2 || objG2 == companion.a()) {
            objG2 = new HoverInteractionKt$collectIsHoveredAsState$1$1(interactionSource, mutableState, null);
            composer.w(objG2);
        }
        EffectsKt.g(interactionSource, (Function2) objG2, composer, i4);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return mutableState;
    }
}
