package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;
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
public final class FontWeightDeserializer extends EnumDeserializerWithDefault<FontWeight> {
    public static final FontWeightDeserializer INSTANCE = new FontWeightDeserializer();

    private FontWeightDeserializer() {
        super(FontWeight.REGULAR, new Function1<FontWeight, String>() { // from class: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[FontWeight.values().length];
                    try {
                        iArr[FontWeight.EXTRA_LIGHT.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[FontWeight.THIN.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[FontWeight.LIGHT.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[FontWeight.REGULAR.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    try {
                        iArr[FontWeight.MEDIUM.ordinal()] = 5;
                    } catch (NoSuchFieldError unused5) {
                    }
                    try {
                        iArr[FontWeight.SEMI_BOLD.ordinal()] = 6;
                    } catch (NoSuchFieldError unused6) {
                    }
                    try {
                        iArr[FontWeight.BOLD.ordinal()] = 7;
                    } catch (NoSuchFieldError unused7) {
                    }
                    try {
                        iArr[FontWeight.EXTRA_BOLD.ordinal()] = 8;
                    } catch (NoSuchFieldError unused8) {
                    }
                    try {
                        iArr[FontWeight.BLACK.ordinal()] = 9;
                    } catch (NoSuchFieldError unused9) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(FontWeight value) {
                Intrinsics.checkNotNullParameter(value, "value");
                switch (WhenMappings.$EnumSwitchMapping$0[value.ordinal()]) {
                    case 1:
                        return "extra_light";
                    case 2:
                        return "thin";
                    case 3:
                        return "light";
                    case 4:
                        return "regular";
                    case 5:
                        return "medium";
                    case 6:
                        return "semibold";
                    case 7:
                        return "bold";
                    case 8:
                        return "extra_bold";
                    case 9:
                        return "black";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
        });
    }
}
