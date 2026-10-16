package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.UStringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.modules.SerializersModule;

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
public final class JsonDecoderForUnsignedTypes extends AbstractDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AbstractJsonLexer f143082a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerializersModule f143083b;

    public JsonDecoderForUnsignedTypes(AbstractJsonLexer lexer, Json json) {
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(json, "json");
        this.f143082a = lexer;
        this.f143083b = json.a();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte H() {
        AbstractJsonLexer abstractJsonLexer = this.f143082a;
        String strQ = abstractJsonLexer.q();
        try {
            return UStringsKt.b(strQ);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type 'UByte' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f143083b;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int h() {
        AbstractJsonLexer abstractJsonLexer = this.f143082a;
        String strQ = abstractJsonLexer.q();
        try {
            return UStringsKt.e(strQ);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type 'UInt' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long l() {
        AbstractJsonLexer abstractJsonLexer = this.f143082a;
        String strQ = abstractJsonLexer.q();
        try {
            return UStringsKt.h(strQ);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type 'ULong' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short s() {
        AbstractJsonLexer abstractJsonLexer = this.f143082a;
        String strQ = abstractJsonLexer.q();
        try {
            return UStringsKt.k(strQ);
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type 'UShort' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }
}
