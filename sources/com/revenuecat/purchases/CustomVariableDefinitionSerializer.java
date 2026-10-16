package com.revenuecat.purchases;

import com.revenuecat.purchases.UiConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.StringSerializer;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CustomVariableDefinitionSerializer implements KSerializer<UiConfig.CustomVariableDefinition> {
    public static final CustomVariableDefinitionSerializer INSTANCE = new CustomVariableDefinitionSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("CustomVariableDefinition", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.CustomVariableDefinitionSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            List listEmptyList = CollectionsKt.emptyList();
            StringSerializer stringSerializer = StringSerializer.f142891a;
            buildClassSerialDescriptor.a("type", stringSerializer.getDescriptor(), listEmptyList, false);
            buildClassSerialDescriptor.a("default_value", stringSerializer.getDescriptor(), CollectionsKt.emptyList(), false);
        }
    });

    private CustomVariableDefinitionSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    @Override // kotlinx.serialization.DeserializationStrategy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.revenuecat.purchases.UiConfig.CustomVariableDefinition deserialize(kotlinx.serialization.encoding.Decoder r5) {
        /*
            r4 = this;
            java.lang.String r0 = "decoder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r5 instanceof kotlinx.serialization.json.JsonDecoder
            if (r0 == 0) goto La8
            kotlinx.serialization.json.JsonDecoder r5 = (kotlinx.serialization.json.JsonDecoder) r5
            kotlinx.serialization.json.JsonElement r5 = r5.g()
            kotlinx.serialization.json.JsonObject r5 = kotlinx.serialization.json.JsonElementKt.o(r5)
            java.lang.String r0 = "type"
            java.lang.Object r0 = r5.get(r0)
            kotlinx.serialization.json.JsonElement r0 = (kotlinx.serialization.json.JsonElement) r0
            java.lang.String r1 = "string"
            if (r0 == 0) goto L2b
            kotlinx.serialization.json.JsonPrimitive r0 = kotlinx.serialization.json.JsonElementKt.p(r0)
            if (r0 == 0) goto L2b
            java.lang.String r0 = r0.a()
            if (r0 != 0) goto L2c
        L2b:
            r0 = r1
        L2c:
            java.lang.String r2 = "default_value"
            java.lang.Object r5 = r5.get(r2)
            boolean r2 = r5 instanceof kotlinx.serialization.json.JsonPrimitive
            if (r2 == 0) goto L39
            kotlinx.serialization.json.JsonPrimitive r5 = (kotlinx.serialization.json.JsonPrimitive) r5
            goto L3a
        L39:
            r5 = 0
        L3a:
            if (r5 != 0) goto L44
            com.revenuecat.purchases.UiConfig$CustomVariableDefinition r5 = new com.revenuecat.purchases.UiConfig$CustomVariableDefinition
            java.lang.String r1 = ""
            r5.<init>(r0, r1)
            return r5
        L44:
            int r2 = r0.hashCode()
            r3 = -1034364087(0xffffffffc258db49, float:-54.214146)
            if (r2 == r3) goto L81
            r3 = -891985903(0xffffffffcad56011, float:-6991880.5)
            if (r2 == r3) goto L76
            r1 = 64711720(0x3db6c28, float:1.2896495E-36)
            if (r2 == r1) goto L58
            goto L89
        L58:
            java.lang.String r1 = "boolean"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L61
            goto L89
        L61:
            java.lang.Boolean r1 = kotlinx.serialization.json.JsonElementKt.f(r5)
            if (r1 != 0) goto La2
            java.lang.String r1 = r5.a()
            java.lang.Boolean r1 = kotlin.text.StringsKt.s1(r1)
            if (r1 != 0) goto La2
            java.lang.String r1 = r5.a()
            goto La2
        L76:
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L89
            java.lang.String r1 = r5.a()
            goto La2
        L81:
            java.lang.String r1 = "number"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L8e
        L89:
            java.lang.String r1 = r5.a()
            goto La2
        L8e:
            java.lang.Double r1 = kotlinx.serialization.json.JsonElementKt.i(r5)
            if (r1 != 0) goto La2
            java.lang.String r1 = r5.a()
            java.lang.Double r1 = kotlin.text.StringsKt.r(r1)
            if (r1 != 0) goto La2
            java.lang.String r1 = r5.a()
        La2:
            com.revenuecat.purchases.UiConfig$CustomVariableDefinition r5 = new com.revenuecat.purchases.UiConfig$CustomVariableDefinition
            r5.<init>(r0, r1)
            return r5
        La8:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "CustomVariableDefinition can only be deserialized from JSON"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.CustomVariableDefinitionSerializer.deserialize(kotlinx.serialization.encoding.Decoder):com.revenuecat.purchases.UiConfig$CustomVariableDefinition");
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, UiConfig.CustomVariableDefinition value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        throw new IllegalStateException("Serialization of CustomVariableDefinition is not implemented as it is not needed.");
    }
}
