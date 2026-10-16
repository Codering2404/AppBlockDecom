package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
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
public final class TextFieldDefaultsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final State b(boolean z2, boolean z3, InteractionSource interactionSource, TextFieldColors textFieldColors, float f3, float f4, Composer composer, int i3) {
        State stateP;
        if (ComposerKt.M()) {
            ComposerKt.U(1097899920, i3, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:982)");
        }
        State stateA = FocusInteractionKt.a(interactionSource, composer, (i3 >> 6) & 14);
        State stateE = textFieldColors.e(z2, z3, interactionSource, composer, i3 & 8190);
        float f5 = c(stateA) ? f3 : f4;
        if (z2) {
            composer.a0(772641254);
            stateP = AnimateAsStateKt.c(f5, AnimationSpecKt.n(150, 0, null, 6, null), null, null, composer, 48, 12);
            composer.U();
        } else {
            composer.a0(772737540);
            stateP = SnapshotStateKt.p(Dp.d(f4), composer, (i3 >> 15) & 14);
            composer.U();
        }
        State stateP2 = SnapshotStateKt.p(new BorderStroke(((Dp) stateP.getValue()).l(), new SolidColor(((Color) stateE.getValue()).B(), null), null), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateP2;
    }

    private static final boolean c(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }
}
