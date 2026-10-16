package cz.mobilesoft.widgets;

import cz.mobilesoft.widgets.AppBlockWidgetState;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
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
public final /* synthetic */ class AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer implements GeneratedSerializer<AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer f133904a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133905b;
    private static final SerialDescriptor descriptor;

    static {
        AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer = new AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer();
        f133904a = appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession", appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer, 3);
        pluginGeneratedSerialDescriptor.p("isCurrentlyOnBreak", false);
        pluginGeneratedSerialDescriptor.p("sessionNumber", false);
        pluginGeneratedSerialDescriptor.p("currentNodeActiveUntil", false);
        descriptor = pluginGeneratedSerialDescriptor;
        f133905b = 8;
    }

    private AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession deserialize(Decoder decoder) {
        boolean zC;
        int i3;
        int i4;
        long jF;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        if (compositeDecoderB.p()) {
            zC = compositeDecoderB.C(serialDescriptor, 0);
            i3 = 7;
            i4 = compositeDecoderB.i(serialDescriptor, 1);
            jF = compositeDecoderB.f(serialDescriptor, 2);
        } else {
            boolean z2 = true;
            zC = false;
            long jF2 = 0;
            int i5 = 0;
            int i6 = 0;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else if (iO == 0) {
                    zC = compositeDecoderB.C(serialDescriptor, 0);
                    i5 |= 1;
                } else if (iO == 1) {
                    i6 = compositeDecoderB.i(serialDescriptor, 1);
                    i5 |= 2;
                } else {
                    if (iO != 2) {
                        throw new UnknownFieldException(iO);
                    }
                    jF2 = compositeDecoderB.f(serialDescriptor, 2);
                    i5 |= 4;
                }
            }
            i3 = i5;
            i4 = i6;
            jF = jF2;
        }
        boolean z3 = zC;
        compositeDecoderB.c(serialDescriptor);
        return new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession(i3, z3, i4, jF, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession.d(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.f142767a, IntSerializer.f142823a, LongSerializer.f142836a};
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
