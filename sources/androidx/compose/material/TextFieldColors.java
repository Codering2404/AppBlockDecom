package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
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
public interface TextFieldColors {
    State a(boolean z2, Composer composer, int i3);

    State b(boolean z2, boolean z3, Composer composer, int i3);

    State c(boolean z2, Composer composer, int i3);

    default State d(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(-1036335134);
        if (ComposerKt.M()) {
            ComposerKt.U(-1036335134, i3, -1, "androidx.compose.material.TextFieldColors.leadingIconColor (TextFieldDefaults.kt:128)");
        }
        State stateB = b(z2, z3, composer, (i3 & 126) | ((i3 >> 3) & 896));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateB;
    }

    State e(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3);

    State f(boolean z2, boolean z3, Composer composer, int i3);

    State g(boolean z2, Composer composer, int i3);

    State h(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3);

    State i(boolean z2, Composer composer, int i3);

    default State j(boolean z2, boolean z3, InteractionSource interactionSource, Composer composer, int i3) {
        composer.a0(454310320);
        if (ComposerKt.M()) {
            ComposerKt.U(454310320, i3, -1, "androidx.compose.material.TextFieldColors.trailingIconColor (TextFieldDefaults.kt:161)");
        }
        State stateF = f(z2, z3, composer, (i3 & 126) | ((i3 >> 3) & 896));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return stateF;
    }
}
