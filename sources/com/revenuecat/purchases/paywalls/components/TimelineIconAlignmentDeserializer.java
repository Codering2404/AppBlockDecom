package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.TimelineComponent;
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
public final class TimelineIconAlignmentDeserializer extends EnumDeserializerWithDefault<TimelineComponent.IconAlignment> {
    public static final TimelineIconAlignmentDeserializer INSTANCE = new TimelineIconAlignmentDeserializer();

    private TimelineIconAlignmentDeserializer() {
        super(TimelineComponent.IconAlignment.Title, new Function1<TimelineComponent.IconAlignment, String>() { // from class: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer.1

            /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.TimelineIconAlignmentDeserializer$1$WhenMappings */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TimelineComponent.IconAlignment.values().length];
                    try {
                        iArr[TimelineComponent.IconAlignment.Title.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[TimelineComponent.IconAlignment.TitleAndDescription.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(TimelineComponent.IconAlignment value) {
                Intrinsics.checkNotNullParameter(value, "value");
                int i3 = WhenMappings.$EnumSwitchMapping$0[value.ordinal()];
                if (i3 == 1) {
                    return "title";
                }
                if (i3 == 2) {
                    return "title_and_description";
                }
                throw new NoWhenBranchMatchedException();
            }
        });
    }
}
