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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@Deprecated
public final /* synthetic */ class AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer implements GeneratedSerializer<AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer f133899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f133900b;
    private static final SerialDescriptor descriptor;

    static {
        AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer = new AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer();
        f133899a = appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("cz.mobilesoft.widgets.AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro", appBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer, 1);
        pluginGeneratedSerialDescriptor.p("session", false);
        descriptor = pluginGeneratedSerialDescriptor;
        f133900b = 8;
    }

    private AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$$serializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro deserialize(Decoder decoder) {
        AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession pomodoroSession;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder compositeDecoderB = decoder.b(serialDescriptor);
        int i3 = 1;
        if (compositeDecoderB.p()) {
            pomodoroSession = (AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession) compositeDecoderB.y(serialDescriptor, 0, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a, null);
        } else {
            boolean z2 = true;
            int i4 = 0;
            pomodoroSession = null;
            while (z2) {
                int iO = compositeDecoderB.o(serialDescriptor);
                if (iO == -1) {
                    z2 = false;
                } else {
                    if (iO != 0) {
                        throw new UnknownFieldException(iO);
                    }
                    pomodoroSession = (AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.PomodoroSession) compositeDecoderB.y(serialDescriptor, 0, AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a, pomodoroSession);
                    i4 = 1;
                }
            }
            i3 = i4;
        }
        compositeDecoderB.c(serialDescriptor);
        return new AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro(i3, pomodoroSession, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final void serialize(Encoder encoder, AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder compositeEncoderB = encoder.b(serialDescriptor);
        AppBlockWidgetState.QuickBlockWidgetState.Blocking.Pomodoro.k(value, compositeEncoderB, serialDescriptor);
        compositeEncoderB.c(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer[] childSerializers() {
        return new KSerializer[]{AppBlockWidgetState$QuickBlockWidgetState$Blocking$Pomodoro$PomodoroSession$$serializer.f133904a};
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
