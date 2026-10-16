package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.descriptors.SerialDescriptor;

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
public final class JsonExceptionsKt {
    public static final JsonDecodingException a(Number value, String key, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(output, "output");
        return e(-1, m(value, key, output));
    }

    public static final JsonEncodingException b(Number value, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(output, "output");
        return new JsonEncodingException("Unexpected special floating-point value " + value + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(output, 0, 1, null)));
    }

    public static final JsonEncodingException c(Number value, String key, String output) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(output, "output");
        return new JsonEncodingException(m(value, key, output));
    }

    public static final JsonEncodingException d(SerialDescriptor keyDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        return new JsonEncodingException("Value of type '" + keyDescriptor.i() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + keyDescriptor.d() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final JsonDecodingException e(int i3, String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        if (i3 >= 0) {
            message = "Unexpected JSON token at offset " + i3 + ": " + message;
        }
        return new JsonDecodingException(message);
    }

    public static final JsonDecodingException f(int i3, String message, CharSequence input) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(input, "input");
        return e(i3, message + "\nJSON input: " + ((Object) j(input, i3)));
    }

    public static final JsonDecodingException g(String key, String input) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(input, "input");
        return e(-1, "Encountered an unknown key '" + key + "'.\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.\nCurrent input: " + ((Object) k(input, 0, 1, null)));
    }

    public static final Void h(AbstractJsonLexer abstractJsonLexer, String entity) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(entity, "entity");
        abstractJsonLexer.w("Trailing comma before the end of JSON " + entity, abstractJsonLexer.f143035a - 1, "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ Void i(AbstractJsonLexer abstractJsonLexer, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "object";
        }
        return h(abstractJsonLexer, str);
    }

    public static final CharSequence j(CharSequence charSequence, int i3) {
        Intrinsics.checkNotNullParameter(charSequence, "<this>");
        if (charSequence.length() >= 200) {
            if (i3 != -1) {
                int i4 = i3 - 30;
                int i5 = i3 + 30;
                return (i4 <= 0 ? "" : ".....") + charSequence.subSequence(RangesKt.f(i4, 0), RangesKt.k(i5, charSequence.length())).toString() + (i5 >= charSequence.length() ? "" : ".....");
            }
            int length = charSequence.length() - 60;
            if (length > 0) {
                return "....." + charSequence.subSequence(length, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static /* synthetic */ CharSequence k(CharSequence charSequence, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = -1;
        }
        return j(charSequence, i3);
    }

    public static final Void l(AbstractJsonLexer abstractJsonLexer, Number result) {
        Intrinsics.checkNotNullParameter(abstractJsonLexer, "<this>");
        Intrinsics.checkNotNullParameter(result, "result");
        AbstractJsonLexer.x(abstractJsonLexer, "Unexpected special floating-point value " + result + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2, null);
        throw new KotlinNothingValueException();
    }

    private static final String m(Number number, String str, String str2) {
        return "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(str2, 0, 1, null));
    }
}
