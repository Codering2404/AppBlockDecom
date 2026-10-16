package kotlinx.serialization.json;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.internal.InlineClassDescriptorKt;
import kotlinx.serialization.json.internal.JsonDecodingException;
import kotlinx.serialization.json.internal.StringJsonLexer;
import kotlinx.serialization.json.internal.StringOpsKt;

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
public final class JsonElementKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SerialDescriptor f143008a = InlineClassDescriptorKt.a("kotlinx.serialization.json.JsonUnquotedLiteral", BuiltinSerializersKt.I(StringCompanionObject.f140150a));

    public static final JsonPrimitive a(Boolean bool) {
        return bool == null ? JsonNull.INSTANCE : new JsonLiteral(bool, false, null, 4, null);
    }

    public static final JsonPrimitive b(Number number) {
        return number == null ? JsonNull.INSTANCE : new JsonLiteral(number, false, null, 4, null);
    }

    public static final JsonPrimitive c(String str) {
        return str == null ? JsonNull.INSTANCE : new JsonLiteral(str, true, null, 4, null);
    }

    private static final Void d(JsonElement jsonElement, String str) {
        throw new IllegalArgumentException("Element " + Reflection.b(jsonElement.getClass()) + " is not a " + str);
    }

    public static final boolean e(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        Boolean boolD = StringOpsKt.d(jsonPrimitive.a());
        if (boolD != null) {
            return boolD.booleanValue();
        }
        throw new IllegalStateException(jsonPrimitive + " does not represent a Boolean");
    }

    public static final Boolean f(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringOpsKt.d(jsonPrimitive.a());
    }

    public static final String g(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        if (jsonPrimitive instanceof JsonNull) {
            return null;
        }
        return jsonPrimitive.a();
    }

    public static final double h(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Double.parseDouble(jsonPrimitive.a());
    }

    public static final Double i(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringsKt.r(jsonPrimitive.a());
    }

    public static final float j(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return Float.parseFloat(jsonPrimitive.a());
    }

    public static final Float k(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        return StringsKt.s(jsonPrimitive.a());
    }

    public static final int l(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            long jM = new StringJsonLexer(jsonPrimitive.a()).m();
            if (-2147483648L <= jM && jM <= 2147483647L) {
                return (int) jM;
            }
            throw new NumberFormatException(jsonPrimitive.a() + " is not an Int");
        } catch (JsonDecodingException e3) {
            throw new NumberFormatException(e3.getMessage());
        }
    }

    public static final Integer m(JsonPrimitive jsonPrimitive) {
        Long lValueOf;
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            lValueOf = Long.valueOf(new StringJsonLexer(jsonPrimitive.a()).m());
        } catch (JsonDecodingException unused) {
            lValueOf = null;
        }
        if (lValueOf != null) {
            long jLongValue = lValueOf.longValue();
            if (-2147483648L <= jLongValue && jLongValue <= 2147483647L) {
                return Integer.valueOf((int) jLongValue);
            }
        }
        return null;
    }

    public static final JsonArray n(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonArray jsonArray = jsonElement instanceof JsonArray ? (JsonArray) jsonElement : null;
        if (jsonArray != null) {
            return jsonArray;
        }
        d(jsonElement, "JsonArray");
        throw new KotlinNothingValueException();
    }

    public static final JsonObject o(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonObject jsonObject = jsonElement instanceof JsonObject ? (JsonObject) jsonElement : null;
        if (jsonObject != null) {
            return jsonObject;
        }
        d(jsonElement, "JsonObject");
        throw new KotlinNothingValueException();
    }

    public static final JsonPrimitive p(JsonElement jsonElement) {
        Intrinsics.checkNotNullParameter(jsonElement, "<this>");
        JsonPrimitive jsonPrimitive = jsonElement instanceof JsonPrimitive ? (JsonPrimitive) jsonElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        d(jsonElement, "JsonPrimitive");
        throw new KotlinNothingValueException();
    }

    public static final SerialDescriptor q() {
        return f143008a;
    }

    public static final long r(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return new StringJsonLexer(jsonPrimitive.a()).m();
        } catch (JsonDecodingException e3) {
            throw new NumberFormatException(e3.getMessage());
        }
    }

    public static final Long s(JsonPrimitive jsonPrimitive) {
        Intrinsics.checkNotNullParameter(jsonPrimitive, "<this>");
        try {
            return Long.valueOf(new StringJsonLexer(jsonPrimitive.a()).m());
        } catch (JsonDecodingException unused) {
            return null;
        }
    }
}
