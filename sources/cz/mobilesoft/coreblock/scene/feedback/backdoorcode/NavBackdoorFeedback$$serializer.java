package cz.mobilesoft.coreblock.scene.feedback.backdoorcode;

import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReason;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

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
public final /* synthetic */ class NavBackdoorFeedback$$serializer implements GeneratedSerializer<NavBackdoorFeedback> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NavBackdoorFeedback$$serializer f102208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f102209b;
    private static final SerialDescriptor descriptor;

    static {
        NavBackdoorFeedback$$serializer navBackdoorFeedback$$serializer = new NavBackdoorFeedback$$serializer();
        f102208a = navBackdoorFeedback$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cz.mobilesoft.coreblock.scene.feedback.backdoorcode.NavBackdoorFeedback", navBackdoorFeedback$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("reason", false);
        descriptor = pluginGeneratedSerialDescriptor;
        f102209b = 8;
    }

    private NavBackdoorFeedback$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final NavBackdoorFeedback deserialize(Decoder decoder) {
        BackdoorReason backdoorReason;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        Lazy[] lazyArr = NavBackdoorFeedback.f102206b;
        int i3 = 1;
        if (compositeDecoderB.p()) {
            backdoorReason = (BackdoorReason) compositeDecoderB.y(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            BackdoorReason backdoorReason2 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    backdoorReason2 = (BackdoorReason) compositeDecoderB.y(serialDescriptor, 0, (DeserializationStrategy) lazyArr[0].getValue(), backdoorReason2);
                    i4 = 1;
                }
            }
            backdoorReason = backdoorReason2;
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new NavBackdoorFeedback(i3, backdoorReason, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, NavBackdoorFeedback value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        compositeEncoderB.C(serialDescriptor, 0, (SerializationStrategy) NavBackdoorFeedback.f102206b[0].getValue(), value.f102207a);
        compositeEncoderB.c(serialDescriptor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{NavBackdoorFeedback.f102206b[0].getValue()};
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public /* bridge */ KSerializer[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.a(this);
    }
}
