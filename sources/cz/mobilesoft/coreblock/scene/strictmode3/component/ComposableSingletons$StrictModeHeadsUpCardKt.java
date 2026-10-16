package cz.mobilesoft.coreblock.scene.strictmode3.component;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposableSingletons$StrictModeHeadsUpCardKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$StrictModeHeadsUpCardKt f121834a = new ComposableSingletons$StrictModeHeadsUpCardKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f121835b = ComposableLambdaKt.c(1294260413, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.c
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeHeadsUpCardKt.d((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Function2 f121836c = ComposableLambdaKt.c(-449487208, false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.d
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$StrictModeHeadsUpCardKt.e((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1294260413, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.ComposableSingletons$StrictModeHeadsUpCardKt.lambda$1294260413.<anonymous> (StrictModeHeadsUpCard.kt:35)");
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-449487208, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.ComposableSingletons$StrictModeHeadsUpCardKt.lambda$-449487208.<anonymous> (StrictModeHeadsUpCard.kt:119)");
            }
            StrictModeHeadsUpCardKt.f(CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.w3), Integer.valueOf(R.string.R3), Integer.valueOf(R.string.uf)}), false, null, composer, 0, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    public final Function2 c() {
        return f121835b;
    }
}
