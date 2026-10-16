package kotlinx.serialization.json;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JsonElementSerializersKt {
    public static final JsonDecoder d(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "<this>");
        JsonDecoder jsonDecoder = decoder instanceof JsonDecoder ? (JsonDecoder) decoder : null;
        if (jsonDecoder != null) {
            return jsonDecoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.b(decoder.getClass()));
    }

    public static final JsonEncoder e(Encoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "<this>");
        JsonEncoder jsonEncoder = encoder instanceof JsonEncoder ? (JsonEncoder) encoder : null;
        if (jsonEncoder != null) {
            return jsonEncoder;
        }
        throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.b(encoder.getClass()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor f(final Function0 function0) {
        return new SerialDescriptor(function0) { // from class: kotlinx.serialization.json.JsonElementSerializersKt$defer$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Lazy f143011a;

            {
                this.f143011a = LazyKt.b(function0);
            }

            private final SerialDescriptor a() {
                return (SerialDescriptor) this.f143011a.getValue();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean b() {
                return SerialDescriptor.DefaultImpls.c(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int c(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return a().c(name);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialKind d() {
                return a().d();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public int e() {
                return a().e();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String f(int i3) {
                return a().f(i3);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public List g(int i3) {
                return a().g(i3);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public List getAnnotations() {
                return SerialDescriptor.DefaultImpls.a(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public SerialDescriptor h(int i3) {
                return a().h(i3);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public String i() {
                return a().i();
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean isInline() {
                return SerialDescriptor.DefaultImpls.b(this);
            }

            @Override // kotlinx.serialization.descriptors.SerialDescriptor
            public boolean j(int i3) {
                return a().j(i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(Decoder decoder) {
        d(decoder);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Encoder encoder) {
        e(encoder);
    }
}
