package com.superwall.sdk.models.internal;

import com.facebook.AuthenticationTokenClaims;
import com.superwall.sdk.identity.Keys;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@Deprecated
public /* synthetic */ class PurchaserInfo$$serializer implements GeneratedSerializer<PurchaserInfo> {
    public static final PurchaserInfo$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    static {
        PurchaserInfo$$serializer purchaserInfo$$serializer = new PurchaserInfo$$serializer();
        INSTANCE = purchaserInfo$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.superwall.sdk.models.internal.PurchaserInfo", purchaserInfo$$serializer, 3);
        pluginGeneratedSerialDescriptor.p(Keys.APP_USER_ID, false);
        pluginGeneratedSerialDescriptor.p(AuthenticationTokenClaims.JSON_KEY_EMAIL, true);
        pluginGeneratedSerialDescriptor.p("storeIdentifiers", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private PurchaserInfo$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr = PurchaserInfo.$childSerializers;
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{stringSerializer, BuiltinSerializersKt.u(stringSerializer), kSerializerArr[2]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final PurchaserInfo deserialize(Decoder decoder) {
        int i3;
        String str;
        String str2;
        StoreIdentifiers storeIdentifiers;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = PurchaserInfo.$childSerializers;
        String strM = null;
        if (compositeDecoderB.p()) {
            String strM2 = compositeDecoderB.m(serialDescriptor, 0);
            String str3 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, null);
            storeIdentifiers = (StoreIdentifiers) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], null);
            str = strM2;
            i3 = 7;
            str2 = str3;
        } else {
            boolean z2 = true;
            int i4 = 0;
            String str4 = null;
            StoreIdentifiers storeIdentifiers2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    strM = compositeDecoderB.m(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    str4 = (String) compositeDecoderB.n(serialDescriptor, 1, StringSerializer.f142891a, str4);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    storeIdentifiers2 = (StoreIdentifiers) compositeDecoderB.y(serialDescriptor, 2, kSerializerArr[2], storeIdentifiers2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            str = strM;
            str2 = str4;
            storeIdentifiers = storeIdentifiers2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new PurchaserInfo(i3, str, str2, storeIdentifiers, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, PurchaserInfo value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        PurchaserInfo.write$Self$superwall_release(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
