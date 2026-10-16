package cz.mobilesoft.widgets;

import cz.mobilesoft.widgets.AppBlockWidgetState;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
public final /* synthetic */ class AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer implements GeneratedSerializer<AppBlockWidgetState.SchedulesWidgetState.Schedule> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer f133928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133929b;
    private static final SerialDescriptor descriptor;

    static {
        AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer appBlockWidgetState$SchedulesWidgetState$Schedule$$serializer = new AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer();
        f133928a = appBlockWidgetState$SchedulesWidgetState$Schedule$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cz.mobilesoft.widgets.AppBlockWidgetState.SchedulesWidgetState.Schedule", appBlockWidgetState$SchedulesWidgetState$Schedule$$serializer, 5);
        pluginGeneratedSerialDescriptor.p("id", false);
        pluginGeneratedSerialDescriptor.p("title", false);
        pluginGeneratedSerialDescriptor.p("subtitle", false);
        pluginGeneratedSerialDescriptor.p("isCurrentlyOn", false);
        pluginGeneratedSerialDescriptor.p("stateIconResId", false);
        descriptor = pluginGeneratedSerialDescriptor;
        f133929b = 8;
    }

    private AppBlockWidgetState$SchedulesWidgetState$Schedule$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AppBlockWidgetState.SchedulesWidgetState.Schedule deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        String str;
        String str2;
        Integer num;
        long j3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            long jF = compositeDecoderB.f(serialDescriptor, 0);
            String strM = compositeDecoderB.m(serialDescriptor, 1);
            String strM2 = compositeDecoderB.m(serialDescriptor, 2);
            str = strM;
            zC = compositeDecoderB.C(serialDescriptor, 3);
            num = (Integer) compositeDecoderB.n(serialDescriptor, 4, IntSerializer.f142823a, null);
            str2 = strM2;
            i3 = 31;
            j3 = jF;
        } else {
            boolean z2 = true;
            boolean zC2 = false;
            Integer num2 = null;
            long jF2 = 0;
            int i4 = 0;
            String strM3 = null;
            String strM4 = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    jF2 = compositeDecoderB.f(serialDescriptor, 0);
                    i4 |= 1;
                } else if (iO == 1) {
                    strM3 = compositeDecoderB.m(serialDescriptor, 1);
                    i4 |= 2;
                } else if (iO == 2) {
                    strM4 = compositeDecoderB.m(serialDescriptor, 2);
                    i4 |= 4;
                } else if (iO == 3) {
                    zC2 = compositeDecoderB.C(serialDescriptor, 3);
                    i4 |= 8;
                } else {
                    if (iO != 4) {
                        throw new UnknownFieldException(iO);
                    }
                    num2 = (Integer) compositeDecoderB.n(serialDescriptor, 4, IntSerializer.f142823a, num2);
                    i4 |= 16;
                }
            }
            zC = zC2;
            i3 = i4;
            str = strM3;
            str2 = strM4;
            num = num2;
            j3 = jF2;
        }
        compositeDecoderB.c(serialDescriptor);
        return new AppBlockWidgetState.SchedulesWidgetState.Schedule(i3, j3, str, str2, zC, num, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, AppBlockWidgetState.SchedulesWidgetState.Schedule value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        AppBlockWidgetState.SchedulesWidgetState.Schedule.f(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        KSerializer kSerializerU = BuiltinSerializersKt.u(IntSerializer.f142823a);
        StringSerializer stringSerializer = StringSerializer.f142891a;
        return new KSerializer[]{LongSerializer.f142836a, stringSerializer, stringSerializer, BooleanSerializer.f142767a, kSerializerU};
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
