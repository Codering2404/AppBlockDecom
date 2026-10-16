package com.revenuecat.purchases.paywalls.components;

import com.facebook.share.internal.ShareConstants;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Deprecated
public final class ActionSurrogate$$serializer implements GeneratedSerializer<ActionSurrogate> {
    public static final ActionSurrogate$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ActionSurrogate$$serializer actionSurrogate$$serializer = new ActionSurrogate$$serializer();
        INSTANCE = actionSurrogate$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.revenuecat.purchases.paywalls.components.ActionSurrogate", actionSurrogate$$serializer, 4);
        pluginGeneratedSerialDescriptor.p("type", false);
        pluginGeneratedSerialDescriptor.p(ShareConstants.DESTINATION, true);
        pluginGeneratedSerialDescriptor.p("url", true);
        pluginGeneratedSerialDescriptor.p("sheet", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ActionSurrogate$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ActionTypeSurrogateDeserializer.INSTANCE, BuiltinSerializersKt.u(DestinationSurrogateDeserializer.INSTANCE), BuiltinSerializersKt.u(UrlSurrogate$$serializer.INSTANCE), BuiltinSerializersKt.u(ButtonComponent$Destination$Sheet$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ActionSurrogate deserialize(Decoder decoder) {
        int i3;
        ActionTypeSurrogate actionTypeSurrogate;
        DestinationSurrogate destinationSurrogate;
        UrlSurrogate urlSurrogate;
        ButtonComponent.Destination.Sheet sheet;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder compositeDecoderB = decoder.b(descriptor2);
        ActionTypeSurrogate actionTypeSurrogate2 = null;
        if (compositeDecoderB.p()) {
            ActionTypeSurrogate actionTypeSurrogate3 = (ActionTypeSurrogate) compositeDecoderB.y(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, null);
            DestinationSurrogate destinationSurrogate2 = (DestinationSurrogate) compositeDecoderB.n(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, null);
            UrlSurrogate urlSurrogate2 = (UrlSurrogate) compositeDecoderB.n(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, null);
            actionTypeSurrogate = actionTypeSurrogate3;
            sheet = (ButtonComponent.Destination.Sheet) compositeDecoderB.n(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, null);
            urlSurrogate = urlSurrogate2;
            destinationSurrogate = destinationSurrogate2;
            i3 = 15;
        } else {
            boolean z2 = true;
            int i4 = 0;
            DestinationSurrogate destinationSurrogate3 = null;
            UrlSurrogate urlSurrogate3 = null;
            ButtonComponent.Destination.Sheet sheet2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(descriptor2);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    actionTypeSurrogate2 = (ActionTypeSurrogate) compositeDecoderB.y(descriptor2, 0, ActionTypeSurrogateDeserializer.INSTANCE, actionTypeSurrogate2);
                    i4 |= 1;
                } else if (iO == 1) {
                    destinationSurrogate3 = (DestinationSurrogate) compositeDecoderB.n(descriptor2, 1, DestinationSurrogateDeserializer.INSTANCE, destinationSurrogate3);
                    i4 |= 2;
                } else if (iO == 2) {
                    urlSurrogate3 = (UrlSurrogate) compositeDecoderB.n(descriptor2, 2, UrlSurrogate$$serializer.INSTANCE, urlSurrogate3);
                    i4 |= 4;
                } else {
                    if (iO != 3) {
                        throw new UnknownFieldException(iO);
                    }
                    sheet2 = (ButtonComponent.Destination.Sheet) compositeDecoderB.n(descriptor2, 3, ButtonComponent$Destination$Sheet$$serializer.INSTANCE, sheet2);
                    i4 |= 8;
                }
            }
            i3 = i4;
            actionTypeSurrogate = actionTypeSurrogate2;
            destinationSurrogate = destinationSurrogate3;
            urlSurrogate = urlSurrogate3;
            sheet = sheet2;
        }
        compositeDecoderB.c(descriptor2);
        return new ActionSurrogate(i3, actionTypeSurrogate, destinationSurrogate, urlSurrogate, sheet, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ActionSurrogate value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder compositeEncoderB = encoder.b(descriptor2);
        ActionSurrogate.write$Self$purchases_defaultsBc8Release(value, compositeEncoderB, descriptor2);
        compositeEncoderB.c(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
