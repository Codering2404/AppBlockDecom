package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@Deprecated
public final /* synthetic */ class NavCustomConfigDetail$$serializer implements GeneratedSerializer<NavCustomConfigDetail> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NavCustomConfigDetail$$serializer f107136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f107137b;
    private static final SerialDescriptor descriptor;

    static {
        NavCustomConfigDetail$$serializer navCustomConfigDetail$$serializer = new NavCustomConfigDetail$$serializer();
        f107136a = navCustomConfigDetail$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cz.mobilesoft.coreblock.scene.more.customBlockScreen.NavCustomConfigDetail", navCustomConfigDetail$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("configId", false);
        descriptor = pluginGeneratedSerialDescriptor;
        f107137b = 8;
    }

    private NavCustomConfigDetail$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final NavCustomConfigDetail deserialize(Decoder decoder) {
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i3 = 1;
        if (compositeDecoderB.p()) {
            str = (String) compositeDecoderB.n(serialDescriptor, 0, StringSerializer.f142891a, null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            str = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    str = (String) compositeDecoderB.n(serialDescriptor, 0, StringSerializer.f142891a, str);
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new NavCustomConfigDetail(i3, str, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, NavCustomConfigDetail value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        compositeEncoderB.i(serialDescriptor, 0, StringSerializer.f142891a, value.f107135a);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.u(StringSerializer.f142891a)};
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
