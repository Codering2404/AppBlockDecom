package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.experimental.kJ.HcgZcEUYo;
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
public final class TransitionTypeSerializer extends EnumDeserializerWithDefault<PaywallTransition.TransitionType> {
    public static final TransitionTypeSerializer INSTANCE = new TransitionTypeSerializer();

    private TransitionTypeSerializer() {
        super(PaywallTransition.TransitionType.FADE, new Function1<PaywallTransition.TransitionType, String>() { // from class: com.revenuecat.purchases.paywalls.components.TransitionTypeSerializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TransitionTypeSerializer$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[PaywallTransition.TransitionType.values().length];
                    try {
                        iArr[PaywallTransition.TransitionType.FADE.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[PaywallTransition.TransitionType.FADE_AND_SCALE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[PaywallTransition.TransitionType.SCALE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[PaywallTransition.TransitionType.SLIDE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(PaywallTransition.TransitionType value) {
                Intrinsics.checkNotNullParameter(value, "value");
                int i3 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
                if (i3 == 1) {
                    return "fade";
                }
                if (i3 == 2) {
                    return HcgZcEUYo.XkZwRHYWFfhK;
                }
                if (i3 == 3) {
                    return "scale";
                }
                if (i3 == 4) {
                    return "slide";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
