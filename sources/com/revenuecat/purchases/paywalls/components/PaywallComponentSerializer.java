package com.revenuecat.purchases.paywalls.components;

import com.facebook.AuthenticationToken;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.crashlytics.internal.breadcrumbs.PKU.tDEtWsFLJfe;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallLegacyComponentInteraction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;

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
public final class PaywallComponentSerializer implements KSerializer<PaywallComponent> {
    private final SerialDescriptor descriptor = SerialDescriptorsKt.d("PaywallComponent", new SerialDescriptor[0], new Function1<ClassSerialDescriptorBuilder, Unit>() { // from class: com.revenuecat.purchases.paywalls.components.PaywallComponentSerializer$descriptor$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ClassSerialDescriptorBuilder) obj);
            return Unit.f139807a;
        }

        public final void invoke(ClassSerialDescriptorBuilder buildClassSerialDescriptor) {
            Intrinsics.checkNotNullParameter(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
            ClassSerialDescriptorBuilder.b(buildClassSerialDescriptor, "type", BuiltinSerializersKt.I(StringCompanionObject.f140150a).getDescriptor(), null, false, 12, null);
        }
    });

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, PaywallComponent value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public PaywallComponent deserialize(Decoder decoder) {
        String string;
        JsonPrimitive jsonPrimitiveP;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder == null) {
            throw new SerializationException("Can only deserialize PaywallComponent from JSON, got: " + Reflection.b(decoder.getClass()));
        }
        JsonObject jsonObjectO = JsonElementKt.o(jsonDecoder.g());
        JsonElement jsonElement = (JsonElement) jsonObjectO.get("type");
        String strA = (jsonElement == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null) ? null : jsonPrimitiveP.a();
        if (strA != null) {
            switch (strA.hashCode()) {
                case -2076650431:
                    if (strA.equals("timeline")) {
                        Json jsonD = jsonDecoder.d();
                        String string2 = jsonObjectO.toString();
                        jsonD.a();
                        return (PaywallComponent) jsonD.d(TimelineComponent.Companion.serializer(), string2);
                    }
                    break;
                case -1896978765:
                    if (strA.equals("tab_control")) {
                        Json jsonD2 = jsonDecoder.d();
                        String string3 = jsonObjectO.toString();
                        jsonD2.a();
                        return (PaywallComponent) jsonD2.d(TabControlComponent.INSTANCE.serializer(), string3);
                    }
                    break;
                case -1822017359:
                    if (strA.equals("sticky_footer")) {
                        Json jsonD3 = jsonDecoder.d();
                        String string4 = jsonObjectO.toString();
                        jsonD3.a();
                        return (PaywallComponent) jsonD3.d(StickyFooterComponent.Companion.serializer(), string4);
                    }
                    break;
                case -1391809488:
                    if (strA.equals(PaywallLegacyComponentInteraction.PURCHASE_BUTTON_NAME)) {
                        Json jsonD4 = jsonDecoder.d();
                        String string5 = jsonObjectO.toString();
                        jsonD4.a();
                        return (PaywallComponent) jsonD4.d(PurchaseButtonComponent.Companion.serializer(), string5);
                    }
                    break;
                case -1377687758:
                    if (strA.equals("button")) {
                        Json jsonD5 = jsonDecoder.d();
                        String string6 = jsonObjectO.toString();
                        jsonD5.a();
                        return (PaywallComponent) jsonD5.d(ButtonComponent.Companion.serializer(), string6);
                    }
                    break;
                case -1221270899:
                    if (strA.equals(AuthenticationToken.HEADER_KEY)) {
                        Json jsonD6 = jsonDecoder.d();
                        String string7 = jsonObjectO.toString();
                        jsonD6.a();
                        return (PaywallComponent) jsonD6.d(HeaderComponent.Companion.serializer(), string7);
                    }
                    break;
                case -807062458:
                    if (strA.equals("package")) {
                        Json jsonD7 = jsonDecoder.d();
                        String string8 = jsonObjectO.toString();
                        jsonD7.a();
                        return (PaywallComponent) jsonD7.d(PackageComponent.Companion.serializer(), string8);
                    }
                    break;
                case -364374390:
                    if (strA.equals("fallback_header")) {
                        return FallbackHeaderComponent.INSTANCE;
                    }
                    break;
                case 2908512:
                    if (strA.equals("carousel")) {
                        Json jsonD8 = jsonDecoder.d();
                        String string9 = jsonObjectO.toString();
                        jsonD8.a();
                        return (PaywallComponent) jsonD8.d(CarouselComponent.Companion.serializer(), string9);
                    }
                    break;
                case 3226745:
                    if (strA.equals("icon")) {
                        Json jsonD9 = jsonDecoder.d();
                        String string10 = jsonObjectO.toString();
                        jsonD9.a();
                        return (PaywallComponent) jsonD9.d(IconComponent.Companion.serializer(), string10);
                    }
                    break;
                case 3552126:
                    if (strA.equals("tabs")) {
                        Json jsonD10 = jsonDecoder.d();
                        String string11 = jsonObjectO.toString();
                        jsonD10.a();
                        return (PaywallComponent) jsonD10.d(TabsComponent.Companion.serializer(), string11);
                    }
                    break;
                case 3556653:
                    if (strA.equals("text")) {
                        Json jsonD11 = jsonDecoder.d();
                        String string12 = jsonObjectO.toString();
                        jsonD11.a();
                        return (PaywallComponent) jsonD11.d(TextComponent.Companion.serializer(), string12);
                    }
                    break;
                case 100313435:
                    if (strA.equals("image")) {
                        Json jsonD12 = jsonDecoder.d();
                        String string13 = jsonObjectO.toString();
                        jsonD12.a();
                        return (PaywallComponent) jsonD12.d(ImageComponent.Companion.serializer(), string13);
                    }
                    break;
                case 109757064:
                    if (strA.equals("stack")) {
                        Json jsonD13 = jsonDecoder.d();
                        String string14 = jsonObjectO.toString();
                        jsonD13.a();
                        return (PaywallComponent) jsonD13.d(StackComponent.Companion.serializer(), string14);
                    }
                    break;
                case 112202875:
                    if (strA.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO)) {
                        Json jsonD14 = jsonDecoder.d();
                        String string15 = jsonObjectO.toString();
                        jsonD14.a();
                        return (PaywallComponent) jsonD14.d(VideoComponent.Companion.serializer(), string15);
                    }
                    break;
                case 318201406:
                    if (strA.equals("tab_control_button")) {
                        Json jsonD15 = jsonDecoder.d();
                        String string16 = jsonObjectO.toString();
                        jsonD15.a();
                        return (PaywallComponent) jsonD15.d(TabControlButtonComponent.Companion.serializer(), string16);
                    }
                    break;
                case 827585120:
                    if (strA.equals(tDEtWsFLJfe.aJShBv)) {
                        Json jsonD16 = jsonDecoder.d();
                        String string17 = jsonObjectO.toString();
                        jsonD16.a();
                        return (PaywallComponent) jsonD16.d(TabControlToggleComponent.Companion.serializer(), string17);
                    }
                    break;
                case 1352226353:
                    if (strA.equals("countdown")) {
                        Json jsonD17 = jsonDecoder.d();
                        String string18 = jsonObjectO.toString();
                        jsonD17.a();
                        return (PaywallComponent) jsonD17.d(CountdownComponent.Companion.serializer(), string18);
                    }
                    break;
            }
        }
        JsonElement jsonElement2 = (JsonElement) jsonObjectO.get("fallback");
        if (jsonElement2 != null) {
            JsonObject jsonObject = jsonElement2 instanceof JsonObject ? (JsonObject) jsonElement2 : null;
            if (jsonObject != null && (string = jsonObject.toString()) != null) {
                Json jsonD18 = jsonDecoder.d();
                jsonD18.a();
                PaywallComponent paywallComponent = (PaywallComponent) jsonD18.d(PaywallComponent.Companion.serializer(), string);
                if (paywallComponent != null) {
                    return paywallComponent;
                }
            }
        }
        throw new SerializationException("No fallback provided for unknown type: " + strA);
    }
}
