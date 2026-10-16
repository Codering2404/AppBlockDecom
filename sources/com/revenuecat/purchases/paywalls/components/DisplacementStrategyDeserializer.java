package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public final class DisplacementStrategyDeserializer extends EnumDeserializerWithDefault<PaywallTransition.DisplacementStrategy> {
    public static final DisplacementStrategyDeserializer INSTANCE = new DisplacementStrategyDeserializer();

    private DisplacementStrategyDeserializer() {
        super(PaywallTransition.DisplacementStrategy.GREEDY, new Function1<PaywallTransition.DisplacementStrategy, String>() { // from class: com.revenuecat.purchases.paywalls.components.DisplacementStrategyDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.DisplacementStrategyDeserializer$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PaywallTransition.DisplacementStrategy.values().length];
                    try {
                        iArr[PaywallTransition.DisplacementStrategy.GREEDY.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PaywallTransition.DisplacementStrategy.LAZY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(PaywallTransition.DisplacementStrategy displacementStrategy) {
                Intrinsics.checkNotNullParameter(displacementStrategy, YgVrd.Wbd);
                int i3 = WhenMappings.$EnumSwitchMapping$0[displacementStrategy.ordinal()];
                if (i3 == 1) {
                    return "greedy";
                }
                if (i3 == 2) {
                    return "lazy";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
