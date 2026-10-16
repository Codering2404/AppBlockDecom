package com.revenuecat.purchases.paywalls.events;

import androidx.glance.session.ecY.lisODU;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PresentedOfferingContextSerializer;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PaywallEventDataSerializer implements KSerializer<PaywallEvent.Data> {
    private static final int DARK_MODE_INDEX = 6;
    private static final int DISPLAY_MODE_INDEX = 4;
    private static final int ERROR_CODE_INDEX = 11;
    private static final int ERROR_MESSAGE_INDEX = 12;
    private static final int EXIT_OFFERING_IDENTIFIER_INDEX = 8;
    private static final int EXIT_OFFER_TYPE_INDEX = 7;
    private static final int LOCALE_IDENTIFIER_INDEX = 5;
    private static final int PACKAGE_IDENTIFIER_INDEX = 9;
    private static final int PAYWALL_IDENTIFIER_INDEX = 0;
    private static final int PAYWALL_REVISION_INDEX = 2;
    private static final int PRESENTED_OFFERING_CONTEXT_INDEX = 1;
    private static final int PRODUCT_IDENTIFIER_INDEX = 10;
    private static final int SESSION_IDENTIFIER_INDEX = 3;
    public static final PaywallEventDataSerializer INSTANCE = new PaywallEventDataSerializer();
    private static final KSerializer<String> nullableStringSerializer = BuiltinSerializersKt.u(BuiltinSerializersKt.I(StringCompanionObject.f140150a));
    private static final KSerializer<Integer> nullableIntSerializer = BuiltinSerializersKt.u(BuiltinSerializersKt.F(IntCompanionObject.f140132a));
    private static final KSerializer<ExitOfferType> nullableExitOfferTypeSerializer = BuiltinSerializersKt.u(ExitOfferType.Companion.serializer());
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.d("PaywallEvent.Data", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.paywalls.events.PaywallEventDataSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "paywallIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "presentedOfferingContext", PresentedOfferingContextSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "paywallRevision", BuiltinSerializersKt.F(IntCompanionObject.f140132a).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "sessionIdentifier", UUIDSerializer.INSTANCE.getDescriptor(), null, false, 12, null);
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "displayMode", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "localeIdentifier", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "darkMode", BuiltinSerializersKt.A(BooleanCompanionObject.f140120a).getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "exitOfferType", PaywallEventDataSerializer.nullableExitOfferTypeSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "exitOfferingIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "packageIdentifier", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, lisODU.EUIFL, PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "errorCode", PaywallEventDataSerializer.nullableIntSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "errorMessage", PaywallEventDataSerializer.nullableStringSerializer.getDescriptor(), null, false, 12, null);
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "offeringIdentifier", BuiltinSerializersKt.I(stringCompanionObject).getDescriptor(), null, false, 12, null);
        }
    });

    private PaywallEventDataSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallEvent.Data deserialize(Decoder decoder) {
        PresentedOfferingContext presentedOfferingContext;
        JsonDecoder jsonDecoder;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        if (!(decoder instanceof JsonDecoder)) {
            throw new SerializationException("PaywallEvent.Data only supports JSON deserialization");
        }
        JsonDecoder jsonDecoder2 = (JsonDecoder) decoder;
        JsonObject jsonObjectO = JsonElementKt.o(jsonDecoder2.g());
        if (jsonObjectO.containsKey("presentedOfferingContext")) {
            Json jsonD = jsonDecoder2.d();
            PresentedOfferingContextSerializer presentedOfferingContextSerializer = PresentedOfferingContextSerializer.INSTANCE;
            Object obj = jsonObjectO.get("presentedOfferingContext");
            Intrinsics.checkNotNull(obj);
            presentedOfferingContext = (PresentedOfferingContext) jsonD.c(presentedOfferingContextSerializer, (JsonElement) obj);
        } else {
            if (!jsonObjectO.containsKey("offeringIdentifier")) {
                throw new SerializationException("Missing offering context information");
            }
            Object obj2 = jsonObjectO.get("offeringIdentifier");
            Intrinsics.checkNotNull(obj2);
            presentedOfferingContext = new PresentedOfferingContext(JsonElementKt.p((JsonElement) obj2).a());
        }
        JsonElement jsonElement = (JsonElement) jsonObjectO.get("paywallIdentifier");
        String str2 = jsonElement != null ? (String) jsonDecoder2.d().c(BuiltinSerializersKt.I(StringCompanionObject.f140150a), jsonElement) : null;
        Json jsonD2 = jsonDecoder2.d();
        IntCompanionObject intCompanionObject = IntCompanionObject.f140132a;
        KSerializer kSerializerF = BuiltinSerializersKt.F(intCompanionObject);
        Object obj3 = jsonObjectO.get("paywallRevision");
        Intrinsics.checkNotNull(obj3);
        int iIntValue = ((Number) jsonD2.c(kSerializerF, (JsonElement) obj3)).intValue();
        Json jsonD3 = jsonDecoder2.d();
        UUIDSerializer uUIDSerializer = UUIDSerializer.INSTANCE;
        Object obj4 = jsonObjectO.get("sessionIdentifier");
        Intrinsics.checkNotNull(obj4);
        UUID uuid = (UUID) jsonD3.c(uUIDSerializer, (JsonElement) obj4);
        Json jsonD4 = jsonDecoder2.d();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        KSerializer kSerializerI = BuiltinSerializersKt.I(stringCompanionObject);
        Object obj5 = jsonObjectO.get("displayMode");
        Intrinsics.checkNotNull(obj5);
        String str3 = (String) jsonD4.c(kSerializerI, (JsonElement) obj5);
        Json jsonD5 = jsonDecoder2.d();
        KSerializer kSerializerI2 = BuiltinSerializersKt.I(stringCompanionObject);
        Object obj6 = jsonObjectO.get("localeIdentifier");
        Intrinsics.checkNotNull(obj6);
        String str4 = (String) jsonD5.c(kSerializerI2, (JsonElement) obj6);
        Json jsonD6 = jsonDecoder2.d();
        KSerializer kSerializerA = BuiltinSerializersKt.A(BooleanCompanionObject.f140120a);
        Object obj7 = jsonObjectO.get("darkMode");
        Intrinsics.checkNotNull(obj7);
        boolean zBooleanValue = ((Boolean) jsonD6.c(kSerializerA, (JsonElement) obj7)).booleanValue();
        JsonElement jsonElement2 = (JsonElement) jsonObjectO.get("exitOfferType");
        ExitOfferType exitOfferType = jsonElement2 != null ? (ExitOfferType) jsonDecoder2.d().c(ExitOfferType.Companion.serializer(), jsonElement2) : null;
        JsonElement jsonElement3 = (JsonElement) jsonObjectO.get("exitOfferingIdentifier");
        String str5 = jsonElement3 != null ? (String) jsonDecoder2.d().c(BuiltinSerializersKt.I(stringCompanionObject), jsonElement3) : null;
        JsonElement jsonElement4 = (JsonElement) jsonObjectO.get("packageIdentifier");
        String str6 = jsonElement4 != null ? (String) jsonDecoder2.d().c(BuiltinSerializersKt.I(stringCompanionObject), jsonElement4) : null;
        JsonElement jsonElement5 = (JsonElement) jsonObjectO.get("productIdentifier");
        if (jsonElement5 != null) {
            jsonDecoder = jsonDecoder2;
            str = (String) jsonDecoder2.d().c(BuiltinSerializersKt.I(stringCompanionObject), jsonElement5);
        } else {
            jsonDecoder = jsonDecoder2;
            str = null;
        }
        JsonElement jsonElement6 = (JsonElement) jsonObjectO.get("errorCode");
        Integer numValueOf = jsonElement6 != null ? Integer.valueOf(((Number) jsonDecoder.d().c(BuiltinSerializersKt.F(intCompanionObject), jsonElement6)).intValue()) : null;
        JsonElement jsonElement7 = (JsonElement) jsonObjectO.get("errorMessage");
        return new PaywallEvent.Data(str2, presentedOfferingContext, iIntValue, uuid, str3, str4, zBooleanValue, exitOfferType, str5, str6, str, numValueOf, jsonElement7 != null ? (String) jsonDecoder.d().c(BuiltinSerializersKt.I(stringCompanionObject), jsonElement7) : null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallEvent.Data value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        String paywallIdentifier = value.getPaywallIdentifier();
        if (paywallIdentifier != null) {
            compositeEncoderB.y(INSTANCE.getDescriptor(), 0, paywallIdentifier);
        }
        PaywallEventDataSerializer paywallEventDataSerializer = INSTANCE;
        compositeEncoderB.C(paywallEventDataSerializer.getDescriptor(), 1, PresentedOfferingContextSerializer.INSTANCE, value.getPresentedOfferingContext());
        compositeEncoderB.w(paywallEventDataSerializer.getDescriptor(), 2, value.getPaywallRevision());
        compositeEncoderB.C(paywallEventDataSerializer.getDescriptor(), 3, UUIDSerializer.INSTANCE, value.getSessionIdentifier());
        compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 4, value.getDisplayMode());
        compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 5, value.getLocaleIdentifier());
        compositeEncoderB.x(paywallEventDataSerializer.getDescriptor(), 6, value.getDarkMode());
        ExitOfferType exitOfferType = value.getExitOfferType();
        if (exitOfferType != null) {
            compositeEncoderB.C(paywallEventDataSerializer.getDescriptor(), 7, ExitOfferType.Companion.serializer(), exitOfferType);
        }
        String exitOfferingIdentifier = value.getExitOfferingIdentifier();
        if (exitOfferingIdentifier != null) {
            compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 8, exitOfferingIdentifier);
        }
        String packageIdentifier = value.getPackageIdentifier();
        if (packageIdentifier != null) {
            compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 9, packageIdentifier);
        }
        String productIdentifier = value.getProductIdentifier();
        if (productIdentifier != null) {
            compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 10, productIdentifier);
        }
        Integer errorCode = value.getErrorCode();
        if (errorCode != null) {
            compositeEncoderB.w(paywallEventDataSerializer.getDescriptor(), 11, errorCode.intValue());
        }
        String errorMessage = value.getErrorMessage();
        if (errorMessage != null) {
            compositeEncoderB.y(paywallEventDataSerializer.getDescriptor(), 12, errorMessage);
        }
        compositeEncoderB.c(descriptor2);
    }
}
