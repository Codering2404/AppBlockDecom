package androidx.compose.material3.internal;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class BasicTooltipKt {
    public static final TooltipState a(boolean z2, boolean z3, MutatorMutex mutatorMutex, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            z2 = false;
        }
        if ((i4 & 2) != 0) {
            z3 = true;
        }
        if ((i4 & 4) != 0) {
            mutatorMutex = BasicTooltipDefaults.f21892a.a();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1483057531, i3, -1, "androidx.compose.material3.internal.rememberBasicTooltipState (BasicTooltip.kt:88)");
        }
        boolean z4 = ((((i3 & 112) ^ 48) > 32 && composer.b(z3)) || (i3 & 48) == 32) | ((((i3 & 896) ^ 384) > 256 && composer.Z(mutatorMutex)) || (i3 & 384) == 256);
        Object objG = composer.G();
        if (z4 || objG == Composer.f23746a.a()) {
            objG = new BasicTooltipStateImpl(z2, z3, mutatorMutex);
            composer.w(objG);
        }
        BasicTooltipStateImpl basicTooltipStateImpl = (BasicTooltipStateImpl) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return basicTooltipStateImpl;
    }
}
