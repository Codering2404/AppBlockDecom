package kotlinx.serialization.json;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class JsonArraySerializer implements KSerializer<JsonArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonArraySerializer f142965a = new JsonArraySerializer();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SerialDescriptor f142966b = JsonArrayDescriptor.f142967b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class JsonArrayDescriptor implements SerialDescriptor {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final JsonArrayDescriptor f142967b = new JsonArrayDescriptor();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String f142968c = "kotlinx.serialization.json.JsonArray";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final /* synthetic */ SerialDescriptor f142969a = BuiltinSerializersKt.h(JsonElementSerializer.f143009a).getDescriptor();

        private JsonArrayDescriptor() {
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean b() {
            return this.f142969a.b();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int c(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return this.f142969a.c(name);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialKind d() {
            return this.f142969a.d();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public int e() {
            return this.f142969a.e();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String f(int i3) {
            return this.f142969a.f(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List g(int i3) {
            return this.f142969a.g(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public List getAnnotations() {
            return this.f142969a.getAnnotations();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public SerialDescriptor h(int i3) {
            return this.f142969a.h(i3);
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public String i() {
            return f142968c;
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean isInline() {
            return this.f142969a.isInline();
        }

        @Override // kotlinx.serialization.descriptors.SerialDescriptor
        public boolean j(int i3) {
            return this.f142969a.j(i3);
        }
    }

    private JsonArraySerializer() {
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public JsonArray deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.g(decoder);
        return new JsonArray((List) BuiltinSerializersKt.h(JsonElementSerializer.f143009a).deserialize(decoder));
    }

    @Override // kotlinx.serialization.SerializationStrategy
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(Encoder encoder, JsonArray value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.h(encoder);
        BuiltinSerializersKt.h(JsonElementSerializer.f143009a).serialize(encoder, value);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return f142966b;
    }
}
