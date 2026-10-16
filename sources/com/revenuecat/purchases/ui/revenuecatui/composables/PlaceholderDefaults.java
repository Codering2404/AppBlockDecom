package com.revenuecat.purchases.ui.revenuecatui.composables;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.RepeatMode;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PlaceholderDefaults {
    public static final PlaceholderDefaults INSTANCE = new PlaceholderDefaults();
    private static final Lazy fadeAnimationSpec$delegate = LazyKt.b(new Function0<InfiniteRepeatableSpec<Float>>() { // from class: com.revenuecat.purchases.ui.revenuecatui.composables.PlaceholderDefaults$fadeAnimationSpec$2
        @Override // kotlin.jvm.functions.Function0
        public final InfiniteRepeatableSpec<Float> invoke() {
            return AnimationSpecKt.e(AnimationSpecKt.n(600, 200, null, 4, null), RepeatMode.f4053b, 0L, 4, null);
        }
    });
    public static final int $stable = 8;

    private PlaceholderDefaults() {
    }

    public final InfiniteRepeatableSpec<Float> getFadeAnimationSpec() {
        return (InfiniteRepeatableSpec) fadeAnimationSpec$delegate.getValue();
    }
}
