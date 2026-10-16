package com.revenuecat.purchases.paywalls.components.common;

import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;

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
public final class BackgroundDeserializer extends SealedDeserializerWithDefault<Background> {
    public static final BackgroundDeserializer INSTANCE = new BackgroundDeserializer();

    private BackgroundDeserializer() {
        super("Background", MapsKt.mapOf(TuplesKt.a("color", new Function0<KSerializer<Background.Color>>() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Background.Color> invoke() {
                return Background.Color.Companion.serializer();
            }
        }), TuplesKt.a("image", new Function0<KSerializer<Background.Image>>() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Background.Image> invoke() {
                return Background.Image.Companion.serializer();
            }
        }), TuplesKt.a(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, new Function0<KSerializer<Background.Video>>() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Background.Video> invoke() {
                return Background.Video.Companion.serializer();
            }
        })), new Function1<String, Background>() { // from class: com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer.4
            @Override // kotlin.jvm.functions.Function1
            public final Background invoke(String type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return new Background.Unknown(type);
            }
        }, null, 8, null);
    }
}
