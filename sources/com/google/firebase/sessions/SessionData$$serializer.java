package com.google.firebase.sessions;

import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
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
public /* synthetic */ class SessionData$$serializer implements GeneratedSerializer<SessionData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SessionData$$serializer f90015a;
    private static final SerialDescriptor descriptor;

    static {
        SessionData$$serializer sessionData$$serializer = new SessionData$$serializer();
        f90015a = sessionData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.google.firebase.sessions.SessionData", sessionData$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("sessionDetails", false);
        pluginGeneratedSerialDescriptor.p("backgroundTime", true);
        pluginGeneratedSerialDescriptor.p("processDataMap", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionData$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final SessionData deserialize(Decoder decoder) {
        int i3;
        SessionDetails sessionDetails;
        Time time;
        Map map;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        KSerializer[] kSerializerArr = SessionData.f90011d;
        SessionDetails sessionDetails2 = null;
        if (compositeDecoderB.p()) {
            SessionDetails sessionDetails3 = (SessionDetails) compositeDecoderB.y(serialDescriptor, 0, SessionDetails$$serializer.f90022a, null);
            Time time2 = (Time) compositeDecoderB.n(serialDescriptor, 1, Time$$serializer.f90119a, null);
            map = (Map) compositeDecoderB.n(serialDescriptor, 2, kSerializerArr[2], null);
            sessionDetails = sessionDetails3;
            i3 = 7;
            time = time2;
        } else {
            boolean z2 = true;
            int i4 = 0;
            Time time3 = null;
            Map map2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    sessionDetails2 = (SessionDetails) compositeDecoderB.y(serialDescriptor, 0, SessionDetails$$serializer.f90022a, sessionDetails2);
                    i4 |= 1;
                } else if (iO == 1) {
                    time3 = (Time) compositeDecoderB.n(serialDescriptor, 1, Time$$serializer.f90119a, time3);
                    i4 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    map2 = (Map) compositeDecoderB.n(serialDescriptor, 2, kSerializerArr[2], map2);
                    i4 |= 4;
                }
            }
            i3 = i4;
            sessionDetails = sessionDetails2;
            time = time3;
            map = map2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new SessionData(i3, sessionDetails, time, map, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{SessionDetails$$serializer.f90022a, BuiltinSerializersKt.u(Time$$serializer.f90119a), BuiltinSerializersKt.u(SessionData.f90011d[2])};
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, SessionData value) {
        Intrinsics.checkNotNullParameter(encoder, YznnJpHcAmeoW.XHsgiAd);
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        SessionData.g(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }
}
