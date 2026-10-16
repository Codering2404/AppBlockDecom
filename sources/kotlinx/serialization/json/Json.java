package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.internal.DescriptorSchemaCache;
import kotlinx.serialization.json.internal.JsonStreamsKt;
import kotlinx.serialization.json.internal.JsonToStringWriter;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringJsonLexerKt;
import kotlinx.serialization.json.internal.TreeJsonDecoderKt;
import kotlinx.serialization.json.internal.TreeJsonEncoderKt;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

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
public abstract class Json implements StringFormat {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Default f142959d = new Default(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsonConfiguration f142960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerializersModule f142961b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DescriptorSchemaCache f142962c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Default extends Json {
        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Default() {
            super(new JsonConfiguration(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, 131071, null), SerializersModuleBuildersKt.a(), null);
        }
    }

    public /* synthetic */ Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule, DefaultConstructorMarker defaultConstructorMarker) {
        this(jsonConfiguration, serializersModule);
    }

    @Override // kotlinx.serialization.SerialFormat
    public SerializersModule a() {
        return this.f142961b;
    }

    @Override // kotlinx.serialization.StringFormat
    public final String b(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        JsonToStringWriter jsonToStringWriter = new JsonToStringWriter();
        try {
            JsonStreamsKt.a(this, jsonToStringWriter, serializer, obj);
            return jsonToStringWriter.toString();
        } finally {
            jsonToStringWriter.g();
        }
    }

    public final Object c(DeserializationStrategy deserializer, JsonElement element) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(element, "element");
        return TreeJsonDecoderKt.a(this, element, deserializer);
    }

    public final Object d(DeserializationStrategy deserializer, String string) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(string, "string");
        StringJsonLexer stringJsonLexerA = StringJsonLexerKt.a(this, string);
        Object objG = new StreamingJsonDecoder(this, WriteMode.f143170c, stringJsonLexerA, deserializer.getDescriptor(), null).G(deserializer);
        stringJsonLexerA.v();
        return objG;
    }

    public final JsonElement e(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        return TreeJsonEncoderKt.d(this, obj, serializer);
    }

    public final JsonConfiguration f() {
        return this.f142960a;
    }

    public final DescriptorSchemaCache g() {
        return this.f142962c;
    }

    public final JsonElement h(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        return (JsonElement) d(JsonElementSerializer.f143009a, string);
    }

    private Json(JsonConfiguration jsonConfiguration, SerializersModule serializersModule) {
        this.f142960a = jsonConfiguration;
        this.f142961b = serializersModule;
        this.f142962c = new DescriptorSchemaCache();
    }
}
