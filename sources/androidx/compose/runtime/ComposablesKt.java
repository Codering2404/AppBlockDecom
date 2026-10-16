package androidx.compose.runtime;

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
public final class ComposablesKt {
    public static final int a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(524444915, i3, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:213)");
        }
        int iV = composer.V();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iV;
    }

    public static final RecomposeScope b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(394957799, i3, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:184)");
        }
        RecomposeScope recomposeScopeD = composer.D();
        if (recomposeScopeD == null) {
            throw new IllegalStateException("no recompose scope found");
        }
        composer.T(recomposeScopeD);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return recomposeScopeD;
    }

    public static final void c() {
        throw new IllegalStateException("Invalid applier");
    }

    public static final CompositionContext d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1165786124, i3, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:461)");
        }
        CompositionContext compositionContextW = composer.W();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return compositionContextW;
    }
}
