package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
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
public final class SizeConstraintDeserializer extends SealedDeserializerWithDefault<SizeConstraint> {
    public static final SizeConstraintDeserializer INSTANCE = new SizeConstraintDeserializer();

    private SizeConstraintDeserializer() {
        super("SizeConstraint", MapsKt.mapOf(TuplesKt.a("fit", new Function0<KSerializer<SizeConstraint.Fit>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fit> invoke() {
                return SizeConstraint.Fit.INSTANCE.serializer();
            }
        }), TuplesKt.a("fill", new Function0<KSerializer<SizeConstraint.Fill>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.2
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fill> invoke() {
                return SizeConstraint.Fill.INSTANCE.serializer();
            }
        }), TuplesKt.a("fixed", new Function0<KSerializer<SizeConstraint.Fixed>>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.3
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer<SizeConstraint.Fixed> invoke() {
                return SizeConstraint.Fixed.Companion.serializer();
            }
        })), new Function1<String, SizeConstraint>() { // from class: com.revenuecat.purchases.paywalls.components.properties.SizeConstraintDeserializer.4
            @Override // kotlin.jvm.functions.Function1
            public final SizeConstraint invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return SizeConstraint.Fit.INSTANCE;
            }
        }, null, 8, null);
    }
}
