package androidx.compose.foundation.selection;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.state.ToggleableState;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

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
public final class ToggleableKt {
    public static final Modifier a(Modifier modifier, final boolean z2, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z3, final Role role, final Function1 function1) {
        return modifier.then(indication instanceof IndicationNodeFactory ? new ToggleableElement(z2, mutableInteractionSource, (IndicationNodeFactory) indication, z3, role, function1, null) : indication == null ? new ToggleableElement(z2, mutableInteractionSource, null, z3, role, function1, null) : mutableInteractionSource != null ? IndicationKt.b(Modifier.b8, mutableInteractionSource, indication).then(new ToggleableElement(z2, mutableInteractionSource, null, z3, role, function1, null)) : ComposedModifierKt.c(Modifier.b8, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.ToggleableKt$toggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-1525724089);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1525724089, i3, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
                }
                Object objG = composer.G();
                if (objG == Composer.f23746a.a()) {
                    objG = InteractionSourceKt.a();
                    composer.w(objG);
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objG;
                Modifier modifierThen = IndicationKt.b(Modifier.b8, mutableInteractionSource2, indication).then(new ToggleableElement(z2, mutableInteractionSource2, null, z3, role, function1, null));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierThen;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null));
    }

    public static /* synthetic */ Modifier b(Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Indication indication, boolean z3, Role role, Function1 function1, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z3 = true;
        }
        boolean z4 = z3;
        if ((i3 & 16) != 0) {
            role = null;
        }
        return a(modifier, z2, mutableInteractionSource, indication, z4, role, function1);
    }

    public static final Modifier c(Modifier modifier, final ToggleableState toggleableState, MutableInteractionSource mutableInteractionSource, final Indication indication, final boolean z2, final Role role, final Function0 function0) {
        return modifier.then(indication instanceof IndicationNodeFactory ? new TriStateToggleableElement(toggleableState, mutableInteractionSource, (IndicationNodeFactory) indication, z2, role, function0, null) : indication == null ? new TriStateToggleableElement(toggleableState, mutableInteractionSource, null, z2, role, function0, null) : mutableInteractionSource != null ? IndicationKt.b(Modifier.b8, mutableInteractionSource, indication).then(new TriStateToggleableElement(toggleableState, mutableInteractionSource, null, z2, role, function0, null)) : ComposedModifierKt.c(Modifier.b8, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.selection.ToggleableKt$triStateToggleable-O2vRcR0$$inlined$clickableWithIndicationIfNeeded$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-1525724089);
                if (ComposerKt.M()) {
                    ComposerKt.U(-1525724089, i3, -1, "androidx.compose.foundation.clickableWithIndicationIfNeeded.<anonymous> (Clickable.kt:473)");
                }
                Object objG = composer.G();
                if (objG == Composer.f23746a.a()) {
                    objG = InteractionSourceKt.a();
                    composer.w(objG);
                }
                MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objG;
                Modifier modifierThen = IndicationKt.b(Modifier.b8, mutableInteractionSource2, indication).then(new TriStateToggleableElement(toggleableState, mutableInteractionSource2, null, z2, role, function0, null));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierThen;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null));
    }
}
