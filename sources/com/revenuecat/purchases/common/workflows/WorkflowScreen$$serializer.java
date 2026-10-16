package com.revenuecat.purchases.common.workflows;

import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig;
import com.revenuecat.purchases.paywalls.components.common.ComponentsConfig$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocaleId;
import com.revenuecat.purchases.paywalls.components.common.LocaleId$$serializer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import com.sun.jna.Function;
import java.net.URL;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
@Deprecated
public final class WorkflowScreen$$serializer implements GeneratedSerializer<WorkflowScreen> {
    public static final WorkflowScreen$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        WorkflowScreen$$serializer workflowScreen$$serializer = new WorkflowScreen$$serializer();
        INSTANCE = workflowScreen$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.common.workflows.WorkflowScreen", workflowScreen$$serializer, 9);
        pluginGeneratedSerialDescriptor.p("name", true);
        pluginGeneratedSerialDescriptor.p("template_name", false);
        pluginGeneratedSerialDescriptor.p("revision", true);
        pluginGeneratedSerialDescriptor.p("asset_base_url", false);
        pluginGeneratedSerialDescriptor.p("components_config", false);
        pluginGeneratedSerialDescriptor.p("components_localizations", false);
        pluginGeneratedSerialDescriptor.p("default_locale", false);
        pluginGeneratedSerialDescriptor.p("config", true);
        pluginGeneratedSerialDescriptor.p("offering_identifier", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private WorkflowScreen$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = WorkflowScreen.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{BuiltinSerializersKt.u(stringSerializer), stringSerializer, IntSerializer.f142823a, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, kSerializerArr[5], LocaleId$$serializer.INSTANCE, JsonObjectSerializer.f143027a, BuiltinSerializersKt.u(stringSerializer)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public WorkflowScreen deserialize(Decoder decoder) {
        Map map;
        String str;
        ComponentsConfig componentsConfig;
        int i3;
        URL url;
        String str2;
        JsonObject jsonObject;
        String str3;
        int i4;
        String str4;
        char c3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        KSerializer[] kSerializerArr = WorkflowScreen.$childSerializers;
        int i5 = 7;
        int i6 = 6;
        int i7 = 3;
        int i8 = 0;
        URL url2 = null;
        if (compositeDecoderB.p()) {
            StringSerializer stringSerializer = StringSerializer.f142891a;
            String str5 = (String) compositeDecoderB.n(descriptor2, 0, stringSerializer, null);
            String strM = compositeDecoderB.m(descriptor2, 1);
            int i9 = compositeDecoderB.i(descriptor2, 2);
            URL url3 = (URL) compositeDecoderB.y(descriptor2, 3, URLSerializer.INSTANCE, null);
            ComponentsConfig componentsConfig2 = (ComponentsConfig) compositeDecoderB.y(descriptor2, 4, ComponentsConfig$$serializer.INSTANCE, null);
            Map map2 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], null);
            LocaleId localeId = (LocaleId) compositeDecoderB.y(descriptor2, 6, LocaleId$$serializer.INSTANCE, null);
            String strM618unboximpl = localeId != null ? localeId.m618unboximpl() : null;
            JsonObject jsonObject2 = (JsonObject) compositeDecoderB.y(descriptor2, 7, JsonObjectSerializer.f143027a, null);
            map = map2;
            str2 = (String) compositeDecoderB.n(descriptor2, 8, stringSerializer, null);
            jsonObject = jsonObject2;
            str3 = strM618unboximpl;
            url = url3;
            i3 = 511;
            componentsConfig = componentsConfig2;
            i4 = i9;
            str4 = strM;
            str = str5;
        } else {
            boolean z2 = true;
            int i10 = 0;
            Map map3 = null;
            ComponentsConfig componentsConfig3 = null;
            String str6 = null;
            JsonObject jsonObject3 = null;
            String strM618unboximpl2 = null;
            String strM2 = null;
            String str7 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                switch (iO) {
                    case -1:
                        z2 = false;
                        i6 = 6;
                        i7 = 3;
                        break;
                    case 0:
                        str7 = (String) compositeDecoderB.n(descriptor2, 0, StringSerializer.f142891a, str7);
                        i8 |= 1;
                        i5 = 7;
                        i6 = 6;
                        i7 = 3;
                        break;
                    case 1:
                        c3 = 2;
                        strM2 = compositeDecoderB.m(descriptor2, 1);
                        i8 |= 2;
                        i5 = 7;
                        break;
                    case 2:
                        c3 = 2;
                        i10 = compositeDecoderB.i(descriptor2, 2);
                        i8 |= 4;
                        i5 = 7;
                        break;
                    case 3:
                        url2 = (URL) compositeDecoderB.y(descriptor2, i7, URLSerializer.INSTANCE, url2);
                        i8 |= 8;
                        i5 = 7;
                        break;
                    case 4:
                        componentsConfig3 = (ComponentsConfig) compositeDecoderB.y(descriptor2, 4, ComponentsConfig$$serializer.INSTANCE, componentsConfig3);
                        i8 |= 16;
                        i5 = 7;
                        break;
                    case 5:
                        map3 = (Map) compositeDecoderB.y(descriptor2, 5, kSerializerArr[5], map3);
                        i8 |= 32;
                        i5 = 7;
                        break;
                    case 6:
                        LocaleId localeId2 = (LocaleId) compositeDecoderB.y(descriptor2, i6, LocaleId$$serializer.INSTANCE, strM618unboximpl2 != null ? LocaleId.m612boximpl(strM618unboximpl2) : null);
                        strM618unboximpl2 = localeId2 != null ? localeId2.m618unboximpl() : null;
                        i8 |= 64;
                        i5 = 7;
                        break;
                    case 7:
                        jsonObject3 = (JsonObject) compositeDecoderB.y(descriptor2, i5, JsonObjectSerializer.f143027a, jsonObject3);
                        i8 |= ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
                        break;
                    case 8:
                        str6 = (String) compositeDecoderB.n(descriptor2, 8, StringSerializer.f142891a, str6);
                        i8 |= Function.MAX_NARGS;
                        break;
                    default:
                        throw new UnknownFieldException(iO);
                }
            }
            map = map3;
            str = str7;
            componentsConfig = componentsConfig3;
            i3 = i8;
            url = url2;
            str2 = str6;
            jsonObject = jsonObject3;
            str3 = strM618unboximpl2;
            i4 = i10;
            str4 = strM2;
        }
        compositeDecoderB.c(descriptor2);
        return new WorkflowScreen(i3, str, str4, i4, url, componentsConfig, map, str3, jsonObject, str2, null, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, WorkflowScreen value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        WorkflowScreen.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
