package kotlinx.serialization.json.internal;

import com.facebook.LegacyTokenHelper;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.PolymorphicSerializerKt;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
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
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Json f143039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonElement f143040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f143041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected final JsonConfiguration f143042f;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement, str);
    }

    private final Void E0(JsonPrimitive jsonPrimitive, String str, String str2) {
        StringBuilder sb;
        String str3;
        if (StringsKt.U(str, "i", false, 2, null)) {
            sb = new StringBuilder();
            str3 = "an ";
        } else {
            sb = new StringBuilder();
            str3 = "a ";
        }
        sb.append(str3);
        sb.append(str);
        throw JsonExceptionsKt.f(-1, "Failed to parse literal '" + jsonPrimitive + "' as " + sb.toString() + " value at element: " + D0(str2), o0().toString());
    }

    protected final String B0() {
        return this.f143041e;
    }

    public JsonElement C0() {
        return this.f143040d;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return !(o0() instanceof JsonNull);
    }

    public final String D0(String currentTag) {
        Intrinsics.checkNotNullParameter(currentTag, "currentTag");
        return k0() + '.' + currentTag;
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Object G(DeserializationStrategy deserializer) {
        JsonPrimitive jsonPrimitiveP;
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        if (!(deserializer instanceof AbstractPolymorphicSerializer) || d().f().p()) {
            return deserializer.deserialize(this);
        }
        AbstractPolymorphicSerializer abstractPolymorphicSerializer = (AbstractPolymorphicSerializer) deserializer;
        String strC = PolymorphicKt.c(abstractPolymorphicSerializer.getDescriptor(), d());
        JsonElement jsonElementG = g();
        String strI = abstractPolymorphicSerializer.getDescriptor().i();
        if (jsonElementG instanceof JsonObject) {
            JsonObject jsonObject = (JsonObject) jsonElementG;
            JsonElement jsonElement = (JsonElement) jsonObject.get(strC);
            try {
                DeserializationStrategy deserializationStrategyA = PolymorphicSerializerKt.a((AbstractPolymorphicSerializer) deserializer, this, (jsonElement == null || (jsonPrimitiveP = JsonElementKt.p(jsonElement)) == null) ? null : JsonElementKt.g(jsonPrimitiveP));
                Intrinsics.checkNotNull(deserializationStrategyA, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return TreeJsonDecoderKt.b(d(), strC, jsonObject, deserializationStrategyA);
            } catch (SerializationException e3) {
                String message = e3.getMessage();
                Intrinsics.checkNotNull(message);
                throw JsonExceptionsKt.f(-1, message, jsonObject.toString());
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonObject.class).m() + ", but had " + Reflection.b(jsonElementG.getClass()).m() + " as the serialized body of " + strI + " at element: " + k0(), jsonElementG.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return d().a();
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonElement jsonElementO0 = o0();
        SerialKind serialKindD = descriptor.d();
        if (Intrinsics.areEqual(serialKindD, StructureKind.LIST.f142754a) || (serialKindD instanceof PolymorphicKind)) {
            Json jsonD = d();
            String strI = descriptor.i();
            if (jsonElementO0 instanceof JsonArray) {
                return new JsonTreeListDecoder(jsonD, (JsonArray) jsonElementO0);
            }
            throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonArray.class).m() + ", but had " + Reflection.b(jsonElementO0.getClass()).m() + " as the serialized body of " + strI + " at element: " + k0(), jsonElementO0.toString());
        }
        if (!Intrinsics.areEqual(serialKindD, StructureKind.MAP.f142755a)) {
            Json jsonD2 = d();
            String strI2 = descriptor.i();
            if (jsonElementO0 instanceof JsonObject) {
                return new JsonTreeDecoder(jsonD2, (JsonObject) jsonElementO0, this.f143041e, null, 8, null);
            }
            throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonObject.class).m() + ", but had " + Reflection.b(jsonElementO0.getClass()).m() + " as the serialized body of " + strI2 + " at element: " + k0(), jsonElementO0.toString());
        }
        Json jsonD3 = d();
        SerialDescriptor serialDescriptorA = WriteModeKt.a(descriptor.h(0), jsonD3.a());
        SerialKind serialKindD2 = serialDescriptorA.d();
        if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.areEqual(serialKindD2, SerialKind.ENUM.f142752a)) {
            Json jsonD4 = d();
            String strI3 = descriptor.i();
            if (jsonElementO0 instanceof JsonObject) {
                return new JsonTreeMapDecoder(jsonD4, (JsonObject) jsonElementO0);
            }
            throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonObject.class).m() + ", but had " + Reflection.b(jsonElementO0.getClass()).m() + " as the serialized body of " + strI3 + " at element: " + k0(), jsonElementO0.toString());
        }
        if (!jsonD3.f().c()) {
            throw JsonExceptionsKt.d(serialDescriptorA);
        }
        Json jsonD5 = d();
        String strI4 = descriptor.i();
        if (jsonElementO0 instanceof JsonArray) {
            return new JsonTreeListDecoder(jsonD5, (JsonArray) jsonElementO0);
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonArray.class).m() + ", but had " + Reflection.b(jsonElementO0.getClass()).m() + " as the serialized body of " + strI4 + " at element: " + k0(), jsonElementO0.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public Json d() {
        return this.f143039c;
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement g() {
        return o0();
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String g0(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract JsonElement n0(String str);

    protected final JsonElement o0() {
        JsonElement jsonElementN0;
        String str = (String) a0();
        return (str == null || (jsonElementN0 = n0(str)) == null) ? C0() : jsonElementN0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public boolean N(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                Boolean boolF = JsonElementKt.f(jsonPrimitive);
                if (boolF != null) {
                    return boolF.booleanValue();
                }
                E0(jsonPrimitive, "boolean", tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, "boolean", tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of boolean at element: " + D0(tag), jsonElementN0.toString());
    }

    @Override // kotlinx.serialization.internal.TaggedDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return a0() != null ? super.q(descriptor) : new JsonPrimitiveDecoder(d(), C0(), this.f143041e).q(descriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public byte O(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                int iL = JsonElementKt.l(jsonPrimitive);
                Byte bValueOf = (-128 > iL || iL > 127) ? null : Byte.valueOf((byte) iL);
                if (bValueOf != null) {
                    return bValueOf.byteValue();
                }
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_BYTE, tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_BYTE, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_BYTE + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public char P(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                return StringsKt.A1(jsonPrimitive.a());
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_CHAR, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_CHAR + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public double Q(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                double dH = JsonElementKt.h(jsonPrimitive);
                if (d().f().b()) {
                    return dH;
                }
                if (Double.isInfinite(dH) || Double.isNaN(dH)) {
                    throw JsonExceptionsKt.a(Double.valueOf(dH), tag, o0().toString());
                }
                return dH;
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_DOUBLE, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_DOUBLE + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public int R(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        Json jsonD = d();
        JsonElement jsonElementN0 = n0(tag);
        String strI = enumDescriptor.i();
        if (jsonElementN0 instanceof JsonPrimitive) {
            return JsonNamesMapKt.l(enumDescriptor, jsonD, ((JsonPrimitive) jsonElementN0).a(), null, 4, null);
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + strI + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public float S(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                float fJ = JsonElementKt.j(jsonPrimitive);
                if (d().f().b()) {
                    return fJ;
                }
                if (Float.isInfinite(fJ) || Float.isNaN(fJ)) {
                    throw JsonExceptionsKt.a(Float.valueOf(fJ), tag, o0().toString());
                }
                return fJ;
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_FLOAT, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_FLOAT + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public Decoder T(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (!StreamingJsonEncoderKt.b(inlineDescriptor)) {
            return super.T(tag, inlineDescriptor);
        }
        Json jsonD = d();
        JsonElement jsonElementN0 = n0(tag);
        String strI = inlineDescriptor.i();
        if (jsonElementN0 instanceof JsonPrimitive) {
            return new JsonDecoderForUnsignedTypes(StringJsonLexerKt.a(jsonD, ((JsonPrimitive) jsonElementN0).a()), d());
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + strI + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public int U(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                return JsonElementKt.l(jsonPrimitive);
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_INTEGER, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_INTEGER + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public long V(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                return JsonElementKt.r(jsonPrimitive);
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_LONG, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_LONG + " at element: " + D0(tag), jsonElementN0.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: y0, reason: merged with bridge method [inline-methods] */
    public boolean W(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return n0(tag) != JsonNull.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public short X(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (jsonElementN0 instanceof JsonPrimitive) {
            JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
            try {
                int iL = JsonElementKt.l(jsonPrimitive);
                Short shValueOf = (-32768 > iL || iL > 32767) ? null : Short.valueOf((short) iL);
                if (shValueOf != null) {
                    return shValueOf.shortValue();
                }
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_SHORT, tag);
                throw new KotlinNothingValueException();
            } catch (IllegalArgumentException unused) {
                E0(jsonPrimitive, LegacyTokenHelper.TYPE_SHORT, tag);
                throw new KotlinNothingValueException();
            }
        }
        throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_SHORT + " at element: " + D0(tag), jsonElementN0.toString());
    }

    public /* synthetic */ AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonElement, (i3 & 4) != 0 ? null : str, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedDecoder
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public String Y(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement jsonElementN0 = n0(tag);
        if (!(jsonElementN0 instanceof JsonPrimitive)) {
            throw JsonExceptionsKt.f(-1, "Expected " + Reflection.b(JsonPrimitive.class).m() + ", but had " + Reflection.b(jsonElementN0.getClass()).m() + " as the serialized body of " + LegacyTokenHelper.TYPE_STRING + pMpIcGE.YGsewHbHgPFIlFI + D0(tag), jsonElementN0.toString());
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) jsonElementN0;
        if (!(jsonPrimitive instanceof JsonLiteral)) {
            throw JsonExceptionsKt.f(-1, "Expected string value for a non-null key '" + tag + "', got null literal instead at element: " + D0(tag), o0().toString());
        }
        JsonLiteral jsonLiteral = (JsonLiteral) jsonPrimitive;
        if (jsonLiteral.b() || d().f().q()) {
            return jsonLiteral.a();
        }
        throw JsonExceptionsKt.f(-1, "String literal for key '" + tag + "' should be quoted at element: " + D0(tag) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", o0().toString());
    }

    private AbstractJsonTreeDecoder(Json json, JsonElement jsonElement, String str) {
        this.f143039c = json;
        this.f143040d = jsonElement;
        this.f143041e = str;
        this.f143042f = d().f();
    }
}
