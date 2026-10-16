package com.revenuecat.purchases.paywalls.components.common.serializers;

import com.revenuecat.purchases.models.StoreReplacementMode;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class DowngradeReplacementModeDeserializer extends StoreReplacementModeDeserializer {
    public static final DowngradeReplacementModeDeserializer INSTANCE = new DowngradeReplacementModeDeserializer();

    private DowngradeReplacementModeDeserializer() {
        super(StoreReplacementMode.DEFERRED, new Function1<StoreReplacementMode, String>() { // from class: com.revenuecat.purchases.paywalls.components.common.serializers.DowngradeReplacementModeDeserializer.1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(StoreReplacementMode value) {
                Intrinsics.checkNotNullParameter(value, "value");
                String lowerCase = value.getName().toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                return lowerCase;
            }
        });
    }
}
