package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonEncoder;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class StreamingJsonEncoder extends AbstractEncoder implements JsonEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Composer f143156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Json f143157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WriteMode f143158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final JsonEncoder[] f143159d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SerializersModule f143160e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final JsonConfiguration f143161f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f143162g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f143163h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f143164i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f143165a;

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
            f143165a = iArr;
        }
    }

    public StreamingJsonEncoder(Composer composer, Json json, WriteMode mode, JsonEncoder[] jsonEncoderArr) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        this.f143156a = composer;
        this.f143157b = json;
        this.f143158c = mode;
        this.f143159d = jsonEncoderArr;
        this.f143160e = d().a();
        this.f143161f = d().f();
        int iOrdinal = mode.ordinal();
        if (jsonEncoderArr != null) {
            JsonEncoder jsonEncoder = jsonEncoderArr[iOrdinal];
            if (jsonEncoder == null && jsonEncoder == this) {
                return;
            }
            jsonEncoderArr[iOrdinal] = this;
        }
    }

    private final void K(String str, String str2) {
        this.f143156a.c();
        G(str);
        this.f143156a.f(':');
        this.f143156a.p();
        G(str2);
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public void A(JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        if (this.f143163h == null || (element instanceof JsonObject)) {
            e(JsonElementSerializer.f143009a, element);
        } else {
            PolymorphicKt.d(this.f143164i, element);
            throw new KotlinNothingValueException();
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void B(int i3) {
        if (this.f143162g) {
            G(String.valueOf(i3));
        } else {
            this.f143156a.i(i3);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void G(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f143156a.n(value);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean H(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i4 = WhenMappings.f143165a[this.f143158c.ordinal()];
        if (i4 != 1) {
            boolean z2 = false;
            if (i4 != 2) {
                if (i4 != 3) {
                    if (!this.f143156a.a()) {
                        this.f143156a.f(',');
                    }
                    this.f143156a.c();
                    G(JsonNamesMapKt.i(descriptor, d(), i3));
                    this.f143156a.f(':');
                    this.f143156a.p();
                } else {
                    if (i3 == 0) {
                        this.f143162g = true;
                    }
                    if (i3 == 1) {
                        this.f143156a.f(',');
                        this.f143156a.p();
                        this.f143162g = false;
                    }
                }
            } else if (this.f143156a.a()) {
                this.f143162g = true;
                this.f143156a.c();
            } else {
                if (i3 % 2 == 0) {
                    this.f143156a.f(',');
                    this.f143156a.c();
                    z2 = true;
                } else {
                    this.f143156a.f(':');
                    this.f143156a.p();
                }
                this.f143162g = z2;
            }
        } else {
            if (!this.f143156a.a()) {
                this.f143156a.f(',');
            }
            this.f143156a.c();
        }
        return true;
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return this.f143160e;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public CompositeEncoder b(SerialDescriptor descriptor) {
        JsonEncoder jsonEncoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode writeModeB = WriteModeKt.b(d(), descriptor);
        char c3 = writeModeB.f143176a;
        if (c3 != 0) {
            this.f143156a.f(c3);
            this.f143156a.b();
        }
        String str = this.f143163h;
        if (str != null) {
            String strI = this.f143164i;
            if (strI == null) {
                strI = descriptor.i();
            }
            K(str, strI);
            this.f143163h = null;
            this.f143164i = null;
        }
        if (this.f143158c == writeModeB) {
            return this;
        }
        JsonEncoder[] jsonEncoderArr = this.f143159d;
        return (jsonEncoderArr == null || (jsonEncoder = jsonEncoderArr[writeModeB.ordinal()]) == null) ? new StreamingJsonEncoder(this.f143156a, d(), writeModeB, this.f143159d) : jsonEncoder;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void c(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.f143158c.f143177b != 0) {
            this.f143156a.q();
            this.f143156a.d();
            this.f143156a.f(this.f143158c.f143177b);
        }
    }

    @Override // kotlinx.serialization.json.JsonEncoder
    public Json d() {
        return this.f143157b;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(kotlinx.serialization.SerializationStrategy r4, java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.StreamingJsonEncoder.e(kotlinx.serialization.SerializationStrategy, java.lang.Object):void");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void g(double d3) {
        if (this.f143162g) {
            G(String.valueOf(d3));
        } else {
            this.f143156a.g(d3);
        }
        if (this.f143161f.b()) {
            return;
        }
        if (Double.isInfinite(d3) || Double.isNaN(d3)) {
            throw JsonExceptionsKt.b(Double.valueOf(d3), this.f143156a.f143072a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void h(byte b3) {
        if (this.f143162g) {
            G(String.valueOf((int) b3));
        } else {
            this.f143156a.e(b3);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public void i(SerialDescriptor descriptor, int i3, SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (obj != null || this.f143161f.j()) {
            super.i(descriptor, i3, serializer, obj);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void k(SerialDescriptor enumDescriptor, int i3) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        G(enumDescriptor.f(i3));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (StreamingJsonEncoderKt.b(descriptor)) {
            Composer composerForUnsignedNumbers = this.f143156a;
            if (!(composerForUnsignedNumbers instanceof ComposerForUnsignedNumbers)) {
                composerForUnsignedNumbers = new ComposerForUnsignedNumbers(composerForUnsignedNumbers.f143072a, this.f143162g);
            }
            return new StreamingJsonEncoder(composerForUnsignedNumbers, d(), this.f143158c, (JsonEncoder[]) null);
        }
        if (StreamingJsonEncoderKt.a(descriptor)) {
            Composer composerForUnquotedLiterals = this.f143156a;
            if (!(composerForUnquotedLiterals instanceof ComposerForUnquotedLiterals)) {
                composerForUnquotedLiterals = new ComposerForUnquotedLiterals(composerForUnquotedLiterals.f143072a, this.f143162g);
            }
            return new StreamingJsonEncoder(composerForUnquotedLiterals, d(), this.f143158c, (JsonEncoder[]) null);
        }
        if (this.f143163h == null) {
            return super.l(descriptor);
        }
        this.f143164i = descriptor.i();
        return this;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void m(long j3) {
        if (this.f143162g) {
            G(String.valueOf(j3));
        } else {
            this.f143156a.j(j3);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void o() {
        this.f143156a.k("null");
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void q(short s2) {
        if (this.f143162g) {
            G(String.valueOf((int) s2));
        } else {
            this.f143156a.l(s2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void r(boolean z2) {
        if (this.f143162g) {
            G(String.valueOf(z2));
        } else {
            this.f143156a.m(z2);
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void t(float f3) {
        if (this.f143162g) {
            G(String.valueOf(f3));
        } else {
            this.f143156a.h(f3);
        }
        if (this.f143161f.b()) {
            return;
        }
        if (Float.isInfinite(f3) || Float.isNaN(f3)) {
            throw JsonExceptionsKt.b(Float.valueOf(f3), this.f143156a.f143072a.toString());
        }
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void u(char c3) {
        G(String.valueOf(c3));
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.CompositeEncoder
    public boolean z(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this.f143161f.i();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StreamingJsonEncoder(InternalJsonWriter output, Json json, WriteMode mode, JsonEncoder[] modeReuseCache) {
        this(ComposersKt.a(output, json), json, mode, modeReuseCache);
        Intrinsics.checkNotNullParameter(output, "output");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(modeReuseCache, "modeReuseCache");
    }
}
