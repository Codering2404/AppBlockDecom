package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.Shape;
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
public final class ShapeDeserializer extends SealedDeserializerWithDefault<Shape> {
    public static final ShapeDeserializer INSTANCE = new ShapeDeserializer();

    private ShapeDeserializer() {
        super("Shape", MapsKt.mapOf(TuplesKt.a("rectangle", new Function0<KSerializer<Shape.Rectangle>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Shape.Rectangle> invoke() {
                return Shape.Rectangle.Companion.serializer();
            }
        }), TuplesKt.a("pill", new Function0<KSerializer<Shape.Pill>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<Shape.Pill> invoke() {
                return Shape.Pill.INSTANCE.serializer();
            }
        })), new Function1<String, Shape>() { // from class: com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Shape invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return new Shape.Rectangle((CornerRadiuses) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
            }
        }, null, 8, null);
    }
}
