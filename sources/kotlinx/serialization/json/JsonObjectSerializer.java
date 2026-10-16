package kotlinx.serialization.json;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class JsonObjectSerializer implements KSerializer<JsonObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonObjectSerializer f143027a = new JsonObjectSerializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f143028b = JsonObjectDescriptor.f143029b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class JsonObjectDescriptor implements SerialDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final JsonObjectDescriptor f143029b = new JsonObjectDescriptor();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f143030c = "kotlinx.serialization.json.JsonObject";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f143031a = BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), JsonElementSerializer.f143009a).getDescriptor();

        private JsonObjectDescriptor() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f143031a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.f143031a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialKind d() {
            return this.f143031a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int e() {
            return this.f143031a.e();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String f(int i3) {
            return this.f143031a.f(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List g(int i3) {
            return this.f143031a.g(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List getAnnotations() {
            return this.f143031a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i3) {
            return this.f143031a.h(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return f143030c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.f143031a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i3) {
            return this.f143031a.j(i3);
        }
    }

    private JsonObjectSerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonObject deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonObject((Map) BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), JsonElementSerializer.f143009a).deserialize(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonObject value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.k(BuiltinSerializersKt.I(StringCompanionObject.f140150a), JsonElementSerializer.f143009a).serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return f143028b;
    }
}
