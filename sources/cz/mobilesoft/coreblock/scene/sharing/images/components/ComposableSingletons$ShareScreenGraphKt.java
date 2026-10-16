package cz.mobilesoft.coreblock.scene.sharing.images.components;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.scene.sharing.dto.SocialsSharePayload;
import cz.mobilesoft.coreblock.scene.sharing.images.components.ComposableSingletons$ShareScreenGraphKt;
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
public final class ComposableSingletons$ShareScreenGraphKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$ShareScreenGraphKt f119423a = new ComposableSingletons$ShareScreenGraphKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Function2 f119424b = ComposableLambdaKt.c(-530285528, false, new Function2() { // from class: q1.b
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$ShareScreenGraphKt.b((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Composer composer, int i3) {
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(9.0f);
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-530285528, i3, -1, "cz.mobilesoft.coreblock.scene.sharing.images.components.ComposableSingletons$ShareScreenGraphKt.lambda$-530285528.<anonymous> (ShareScreenGraph.kt:134)");
            }
            ShareScreenGraphKt.g(new SocialsSharePayload(SocialsSharePayload.PeriodType.Day, CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(2.0f), Float.valueOf(10.0f), Float.valueOf(7.0f), fValueOf2, Float.valueOf(12.0f), Float.valueOf(11.0f), Float.valueOf(14.0f), Float.valueOf(15.0f), Float.valueOf(13.0f), fValueOf2, fValueOf, fValueOf}), null, null, 0, "4h 32m", 2, 0L, 0L, null, null, null, null, null, null, null, 65436, null), PaddingKt.i(Modifier.b8, Dp.g(16)), 0L, 0L, composer, 48, 12);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }
}
