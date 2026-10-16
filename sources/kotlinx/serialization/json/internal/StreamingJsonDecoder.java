package kotlinx.serialization.json.internal;

import com.facebook.LegacyTokenHelper;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.ChunkedDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

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
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder, ChunkedDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Json f143146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WriteMode f143147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractJsonLexer f143148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SerializersModule f143149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f143150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DiscriminatorHolder f143151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JsonConfiguration f143152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final JsonElementMarker f143153h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DiscriminatorHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f143154a;

        public DiscriminatorHolder(String str) {
            this.f143154a = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f143155a;

        static {
            int[] iArr = new int[WriteMode.values().length];
            try {
                iArr[WriteMode.f143171d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WriteMode.f143172f.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WriteMode.f143173g.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WriteMode.f143170c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f143155a = iArr;
        }
    }

    public StreamingJsonDecoder(Json json, WriteMode mode, AbstractJsonLexer lexer, SerialDescriptor descriptor, DiscriminatorHolder discriminatorHolder) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(lexer, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f143146a = json;
        this.f143147b = mode;
        this.f143148c = lexer;
        this.f143149d = json.a();
        this.f143150e = -1;
        this.f143151f = discriminatorHolder;
        JsonConfiguration jsonConfigurationF = json.f();
        this.f143152g = jsonConfigurationF;
        this.f143153h = jsonConfigurationF.j() ? null : new JsonElementMarker(descriptor);
    }

    private final void K() {
        if (this.f143148c.H() != 4) {
            return;
        }
        AbstractJsonLexer.x(this.f143148c, "Unexpected leading comma", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean L(SerialDescriptor serialDescriptor, int i3) {
        String strI;
        Json json = this.f143146a;
        boolean zJ = serialDescriptor.j(i3);
        SerialDescriptor serialDescriptorH = serialDescriptor.h(i3);
        if (zJ && !serialDescriptorH.b() && this.f143148c.P(true)) {
            return true;
        }
        if (!Intrinsics.areEqual(serialDescriptorH.d(), SerialKind.ENUM.f142752a) || ((serialDescriptorH.b() && this.f143148c.P(false)) || (strI = this.f143148c.I(this.f143152g.q())) == null)) {
            return false;
        }
        int iJ = JsonNamesMapKt.j(serialDescriptorH, json, strI);
        boolean z2 = !json.f().j() && serialDescriptorH.b();
        if (iJ == -3 && (zJ || z2)) {
            this.f143148c.o();
            return true;
        }
        return false;
    }

    private final int M() {
        boolean zO = this.f143148c.O();
        if (!this.f143148c.e()) {
            if (!zO || this.f143146a.f().d()) {
                return -1;
            }
            JsonExceptionsKt.h(this.f143148c, "array");
            throw new KotlinNothingValueException();
        }
        int i3 = this.f143150e;
        if (i3 != -1 && !zO) {
            AbstractJsonLexer.x(this.f143148c, "Expected end of the array or comma", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i4 = i3 + 1;
        this.f143150e = i4;
        return i4;
    }

    private final int N() {
        int i3 = this.f143150e;
        boolean zO = false;
        boolean z2 = i3 % 2 != 0;
        if (!z2) {
            this.f143148c.l(':');
        } else if (i3 != -1) {
            zO = this.f143148c.O();
        }
        if (!this.f143148c.e()) {
            if (!zO || this.f143146a.f().d()) {
                return -1;
            }
            JsonExceptionsKt.i(this.f143148c, null, 1, null);
            throw new KotlinNothingValueException();
        }
        if (z2) {
            if (this.f143150e == -1) {
                AbstractJsonLexer abstractJsonLexer = this.f143148c;
                int i4 = abstractJsonLexer.f143035a;
                if (zO) {
                    AbstractJsonLexer.x(abstractJsonLexer, "Unexpected leading comma", i4, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                AbstractJsonLexer abstractJsonLexer2 = this.f143148c;
                boolean z3 = zO;
                int i5 = abstractJsonLexer2.f143035a;
                if (!z3) {
                    AbstractJsonLexer.x(abstractJsonLexer2, "Expected comma after the key-value pair", i5, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            }
        }
        int i6 = this.f143150e + 1;
        this.f143150e = i6;
        return i6;
    }

    private final int O(SerialDescriptor serialDescriptor) {
        int iJ;
        boolean zO;
        boolean zO2 = this.f143148c.O();
        while (true) {
            boolean z2 = true;
            if (!this.f143148c.e()) {
                if (zO2 && !this.f143146a.f().d()) {
                    JsonExceptionsKt.i(this.f143148c, null, 1, null);
                    throw new KotlinNothingValueException();
                }
                JsonElementMarker jsonElementMarker = this.f143153h;
                if (jsonElementMarker != null) {
                    return jsonElementMarker.d();
                }
                return -1;
            }
            String strP = P();
            this.f143148c.l(':');
            iJ = JsonNamesMapKt.j(serialDescriptor, this.f143146a, strP);
            if (iJ == -3) {
                zO = false;
            } else {
                if (!this.f143152g.g() || !L(serialDescriptor, iJ)) {
                    break;
                }
                zO = this.f143148c.O();
                z2 = false;
            }
            zO2 = z2 ? Q(strP) : zO;
        }
        JsonElementMarker jsonElementMarker2 = this.f143153h;
        if (jsonElementMarker2 != null) {
            jsonElementMarker2.c(iJ);
        }
        return iJ;
    }

    private final String P() {
        return this.f143152g.q() ? this.f143148c.r() : this.f143148c.i();
    }

    private final boolean Q(String str) {
        if (this.f143152g.k() || S(this.f143151f, str)) {
            this.f143148c.K(this.f143152g.q());
        } else {
            this.f143148c.A(str);
        }
        return this.f143148c.O();
    }

    private final void R(SerialDescriptor serialDescriptor) {
        while (o(serialDescriptor) != -1) {
        }
    }

    private final boolean S(DiscriminatorHolder discriminatorHolder, String str) {
        if (discriminatorHolder == null || !Intrinsics.areEqual(discriminatorHolder.f143154a, str)) {
            return false;
        }
        discriminatorHolder.f143154a = null;
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        JsonElementMarker jsonElementMarker = this.f143153h;
        return ((jsonElementMarker != null ? jsonElementMarker.b() : false) || AbstractJsonLexer.Q(this.f143148c, false, 1, null)) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0157  */
    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object G(kotlinx.serialization.DeserializationStrategy r12) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonDecoder.G(kotlinx.serialization.DeserializationStrategy):java.lang.Object");
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public byte H() {
        long jM = this.f143148c.m();
        byte b3 = (byte) jM;
        if (jM == b3) {
            return b3;
        }
        AbstractJsonLexer.x(this.f143148c, "Failed to parse byte for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f143149d;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public CompositeDecoder b(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode writeModeB = WriteModeKt.b(this.f143146a, descriptor);
        this.f143148c.f143036b.c(descriptor);
        this.f143148c.l(writeModeB.f143176a);
        K();
        int i3 = WhenMappings.f143155a[writeModeB.ordinal()];
        return (i3 == 1 || i3 == 2 || i3 == 3) ? new StreamingJsonDecoder(this.f143146a, writeModeB, this.f143148c, descriptor, this.f143151f) : (this.f143147b == writeModeB && this.f143146a.f().j()) ? this : new StreamingJsonDecoder(this.f143146a, writeModeB, this.f143148c, descriptor, this.f143151f);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.f143146a.f().k() && descriptor.e() == 0) {
            R(descriptor);
        }
        if (this.f143148c.O() && !this.f143146a.f().d()) {
            JsonExceptionsKt.h(this.f143148c, "");
            throw new KotlinNothingValueException();
        }
        this.f143148c.l(this.f143147b.f143177b);
        this.f143148c.f143036b.b();
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public final Json d() {
        return this.f143146a;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int e(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.k(enumDescriptor, this.f143146a, z(), " at path " + this.f143148c.f143036b.a());
    }

    @Override // kotlinx.serialization.json.JsonDecoder
    public JsonElement g() {
        return new JsonTreeReader(this.f143146a.f(), this.f143148c).e();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public int h() {
        long jM = this.f143148c.m();
        int i3 = (int) jM;
        if (jM == i3) {
            return i3;
        }
        AbstractJsonLexer.x(this.f143148c, "Failed to parse int for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public long l() {
        return this.f143148c.m();
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i3 = WhenMappings.f143155a[this.f143147b.ordinal()];
        int iM = i3 != 2 ? i3 != 4 ? M() : O(descriptor) : N();
        if (this.f143147b != WriteMode.f143172f) {
            this.f143148c.f143036b.g(iM);
        }
        return iM;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return StreamingJsonEncoderKt.b(descriptor) ? new JsonDecoderForUnsignedTypes(this.f143148c, this.f143146a) : super.q(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public short s() {
        long jM = this.f143148c.m();
        short s2 = (short) jM;
        if (jM == s2) {
            return s2;
        }
        AbstractJsonLexer.x(this.f143148c, "Failed to parse short for input '" + jM + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public float t() {
        AbstractJsonLexer abstractJsonLexer = this.f143148c;
        String strQ = abstractJsonLexer.q();
        try {
            float f3 = Float.parseFloat(strQ);
            if (this.f143146a.f().b()) {
                return f3;
            }
            if (!Float.isInfinite(f3) && !Float.isNaN(f3)) {
                return f3;
            }
            JsonExceptionsKt.l(this.f143148c, Float.valueOf(f3));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + LegacyTokenHelper.TYPE_FLOAT + "' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public double v() {
        AbstractJsonLexer abstractJsonLexer = this.f143148c;
        String strQ = abstractJsonLexer.q();
        try {
            double d3 = Double.parseDouble(strQ);
            if (this.f143146a.f().b()) {
                return d3;
            }
            if (!Double.isInfinite(d3) && !Double.isNaN(d3)) {
                return d3;
            }
            JsonExceptionsKt.l(this.f143148c, Double.valueOf(d3));
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException unused) {
            AbstractJsonLexer.x(abstractJsonLexer, "Failed to parse type '" + LegacyTokenHelper.TYPE_DOUBLE + "' for input '" + strQ + '\'', 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean w() {
        return this.f143148c.g();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public char x() {
        String strQ = this.f143148c.q();
        if (strQ.length() == 1) {
            return strQ.charAt(0);
        }
        AbstractJsonLexer.x(this.f143148c, "Expected single char, but got '" + strQ + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.CompositeDecoder
    public Object y(SerialDescriptor descriptor, int i3, DeserializationStrategy deserializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        boolean z2 = this.f143147b == WriteMode.f143172f && (i3 & 1) == 0;
        if (z2) {
            this.f143148c.f143036b.d();
        }
        Object objY = super.y(descriptor, i3, deserializer, obj);
        if (z2) {
            this.f143148c.f143036b.f(objY);
        }
        return objY;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public String z() {
        return this.f143152g.q() ? this.f143148c.r() : this.f143148c.o();
    }
}
