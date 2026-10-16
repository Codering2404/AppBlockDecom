package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.utils.serializers.SealedDeserializerWithDefault;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class MaskShapeDeserializer extends SealedDeserializerWithDefault<MaskShape> {
    public static final MaskShapeDeserializer INSTANCE = new MaskShapeDeserializer();

    private MaskShapeDeserializer() {
        super("MaskShape", MapsKt.mapOf(TuplesKt.a("rectangle", new Function0<KSerializer<MaskShape.Rectangle>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<MaskShape.Rectangle> invoke() {
                return MaskShape.Rectangle.Companion.serializer();
            }
        }), TuplesKt.a("concave", new Function0<KSerializer<MaskShape.Concave>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<MaskShape.Concave> invoke() {
                return MaskShape.Concave.INSTANCE.serializer();
            }
        }), TuplesKt.a("convex", new Function0<KSerializer<MaskShape.Convex>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<MaskShape.Convex> invoke() {
                return MaskShape.Convex.INSTANCE.serializer();
            }
        }), TuplesKt.a("circle", new Function0<KSerializer<MaskShape.Circle>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer.4
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<MaskShape.Circle> invoke() {
                return MaskShape.Circle.INSTANCE.serializer();
            }
        })), new Function1<String, MaskShape>() { // from class: com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer.5
            @Override // kotlin.jvm.functions.Function1
            public final MaskShape invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new MaskShape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) null);
            }
        }, null, 8, null);
    }
}
