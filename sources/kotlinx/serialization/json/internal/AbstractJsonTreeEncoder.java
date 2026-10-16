package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.NamedValueEncoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
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
@ExperimentalSerializationApi
abstract class AbstractJsonTreeEncoder extends NamedValueEncoder implements JsonEncoder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Json f143043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f143044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final JsonConfiguration f143045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f143046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f143047f;

    public /* synthetic */ AbstractJsonTreeEncoder(Json json, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(AbstractJsonTreeEncoder abstractJsonTreeEncoder, JsonElement node) {
        Intrinsics.checkNotNullParameter(node, "node");
        abstractJsonTreeEncoder.A0((String) abstractJsonTreeEncoder.Y(), node);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1 y0(final String str, final SerialDescriptor serialDescriptor) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnquotedLiteralEncoder$1
            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void G(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                this.f143048a.A0(str, new JsonLiteral(value, false, serialDescriptor));
            }

            @Override // kotlinx.serialization.encoding.Encoder
            public SerializersModule a() {
                return this.f143048a.d().a();
            }
        };
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1] */
    private final AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1 z0(final String str) {
        return new AbstractEncoder() { // from class: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder$inlineUnsignedNumberEncoder$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final SerializersModule f143051a;

            {
                this.f143051a = this.f143052b.d().a();
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void B(int i3) {
                K(Integer.toUnsignedString(UInt.b(i3)));
            }

            public final void K(String s2) {
                Intrinsics.checkNotNullParameter(s2, "s");
                this.f143052b.A0(str, new JsonLiteral(s2, false, null, 4, null));
            }

            @Override // kotlinx.serialization.encoding.Encoder
            public SerializersModule a() {
                return this.f143051a;
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void h(byte b3) {
                K(UByte.e(UByte.b(b3)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void m(long j3) {
                K(Long.toUnsignedString(ULong.b(j3)));
            }

            @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
            public void q(short s2) {
                K(UShort.e(UShort.b(s2)));
            }
        };
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public void A(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.f143046e == null || (element instanceof JsonObject)) {
            e(JsonElementSerializer.f143009a, element);
        } else {
            PolymorphicKt.d(this.f143047f, element);
            throw new KotlinNothingValueException();
        }
    }

    public abstract void A0(String str, JsonElement jsonElement);

    @Override // kotlinx.serialization.internal.TaggedEncoder
    protected void X(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f143044c.invoke(w0());
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public final SerializersModule a() {
        return this.f143043b.a();
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        AbstractJsonTreeEncoder jsonTreeListEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Function1 function1 = Z() == null ? this.f143044c : new Function1() { // from class: kotlinx.serialization.json.internal.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AbstractJsonTreeEncoder.i0(this.f143178a, (JsonElement) obj);
            }
        };
        SerialKind serialKindD = descriptor.d();
        if (Intrinsics.areEqual(serialKindD, StructureKind.LIST.f142754a) || (serialKindD instanceof PolymorphicKind)) {
            jsonTreeListEncoder = new JsonTreeListEncoder(this.f143043b, function1);
        } else if (Intrinsics.areEqual(serialKindD, StructureKind.MAP.f142755a)) {
            Json json = this.f143043b;
            SerialDescriptor serialDescriptorA = WriteModeKt.a(descriptor.h(0), json.a());
            SerialKind serialKindD2 = serialDescriptorA.d();
            if ((serialKindD2 instanceof PrimitiveKind) || Intrinsics.areEqual(serialKindD2, SerialKind.ENUM.f142752a)) {
                jsonTreeListEncoder = new JsonTreeMapEncoder(this.f143043b, function1);
            } else {
                if (!json.f().c()) {
                    throw JsonExceptionsKt.d(serialDescriptorA);
                }
                jsonTreeListEncoder = new JsonTreeListEncoder(this.f143043b, function1);
            }
        } else {
            jsonTreeListEncoder = new JsonTreeEncoder(this.f143043b, function1);
        }
        String str = this.f143046e;
        if (str != null) {
            if (jsonTreeListEncoder instanceof JsonTreeMapEncoder) {
                JsonTreeMapEncoder jsonTreeMapEncoder = (JsonTreeMapEncoder) jsonTreeListEncoder;
                jsonTreeMapEncoder.A0("key", JsonElementKt.c(str));
                String strI = this.f143047f;
                if (strI == null) {
                    strI = descriptor.i();
                }
                jsonTreeMapEncoder.A0("value", JsonElementKt.c(strI));
            } else {
                String strI2 = this.f143047f;
                if (strI2 == null) {
                    strI2 = descriptor.i();
                }
                jsonTreeListEncoder.A0(str, JsonElementKt.c(strI2));
            }
            this.f143046e = null;
            this.f143047f = null;
        }
        return jsonTreeListEncoder;
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public final Json d() {
        return this.f143043b;
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String d0(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(kotlinx.serialization.SerializationStrategy r4, java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.internal.NamedValueEncoder
    protected String e0(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return JsonNamesMapKt.i(descriptor, this.f143043b, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void J(String tag, boolean z2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.a(Boolean.valueOf(z2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void K(String tag, byte b3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Byte.valueOf(b3)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (Z() == null) {
            return new JsonPrimitiveEncoder(this.f143043b, this.f143044c).l(descriptor);
        }
        if (this.f143046e != null) {
            this.f143047f = descriptor.i();
        }
        return super.l(descriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void L(String tag, char c3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.c(String.valueOf(c3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void M(String tag, double d3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Double.valueOf(d3)));
        if (this.f143045d.b()) {
            return;
        }
        if (Double.isInfinite(d3) || Double.isNaN(d3)) {
            throw JsonExceptionsKt.c(Double.valueOf(d3), tag, w0().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void N(String tag, SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        A0(tag, JsonElementKt.c(enumDescriptor.f(i3)));
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void o() {
        String str = (String) Z();
        if (str == null) {
            this.f143044c.invoke(JsonNull.INSTANCE);
        } else {
            T(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void O(String tag, float f3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Float.valueOf(f3)));
        if (this.f143045d.b()) {
            return;
        }
        if (Float.isInfinite(f3) || Float.isNaN(f3)) {
            throw JsonExceptionsKt.c(Float.valueOf(f3), tag, w0().toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public Encoder P(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return StreamingJsonEncoderKt.b(inlineDescriptor) ? z0(tag) : StreamingJsonEncoderKt.a(inlineDescriptor) ? y0(tag, inlineDescriptor) : super.P(tag, inlineDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void Q(String tag, int i3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Integer.valueOf(i3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public void R(String tag, long j3) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Long.valueOf(j3)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public void T(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonNull.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public void U(String tag, short s2) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        A0(tag, JsonElementKt.b(Short.valueOf(s2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public void V(String tag, String value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        A0(tag, JsonElementKt.c(value));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.TaggedEncoder
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public void W(String tag, Object value) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(value, "value");
        A0(tag, JsonElementKt.c(value.toString()));
    }

    public abstract JsonElement w0();

    protected final Function1 x0() {
        return this.f143044c;
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.f143045d.i();
    }

    private AbstractJsonTreeEncoder(Json json, Function1 function1) {
        this.f143043b = json;
        this.f143044c = function1;
        this.f143045d = json.f();
    }

    @Override // kotlinx.serialization.internal.TaggedEncoder, kotlinx.serialization.encoding.Encoder
    public void v() {
    }
}
