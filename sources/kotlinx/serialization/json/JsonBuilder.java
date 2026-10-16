package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public final class JsonBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f142970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f142971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f142972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f142973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f142974e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f142975f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f142976g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f142977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ClassDiscriminatorMode f142978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f142979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private JsonNamingStrategy f142980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f142981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f142982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f142983n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f142984o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f142985p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f142986q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private SerializersModule f142987r;

    public JsonBuilder(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.f142970a = json.f().i();
        this.f142971b = json.f().j();
        this.f142972c = json.f().k();
        this.f142973d = json.f().q();
        this.f142974e = json.f().m();
        this.f142975f = json.f().n();
        this.f142976g = json.f().g();
        this.f142977h = json.f().e();
        this.f142978i = json.f().f();
        this.f142979j = json.f().o();
        this.f142980k = json.f().l();
        this.f142981l = json.f().h();
        this.f142982m = json.f().d();
        this.f142983n = json.f().a();
        this.f142984o = json.f().b();
        this.f142985p = json.f().c();
        this.f142986q = json.f().p();
        this.f142987r = json.a();
    }

    public final JsonConfiguration a() {
        if (this.f142986q) {
            if (!Intrinsics.areEqual(this.f142977h, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified");
            }
            if (this.f142978i != ClassDiscriminatorMode.f142951c) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.");
            }
        }
        if (this.f142974e) {
            if (!Intrinsics.areEqual(this.f142975f, "    ")) {
                String str = this.f142975f;
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char cCharAt = str.charAt(i3);
                    if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\r' && cCharAt != '\n') {
                        throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f142975f).toString());
                    }
                }
            }
        } else if (!Intrinsics.areEqual(this.f142975f, "    ")) {
            throw new IllegalArgumentException("Indent should not be specified when default printing mode is used");
        }
        return new JsonConfiguration(this.f142970a, this.f142972c, this.f142973d, this.f142985p, this.f142974e, this.f142971b, this.f142975f, this.f142976g, this.f142986q, this.f142977h, this.f142984o, this.f142979j, this.f142980k, this.f142981l, this.f142982m, this.f142983n, this.f142978i);
    }

    public final SerializersModule b() {
        return this.f142987r;
    }

    public final void c(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f142977h = str;
    }

    public final void d(ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "<set-?>");
        this.f142978i = classDiscriminatorMode;
    }

    public final void e(boolean z2) {
        this.f142976g = z2;
    }

    public final void f(boolean z2) {
        this.f142970a = z2;
    }

    public final void g(boolean z2) {
        this.f142971b = z2;
    }

    public final void h(boolean z2) {
        this.f142972c = z2;
    }

    public final void i(boolean z2) {
        this.f142973d = z2;
    }

    public final void j(JsonNamingStrategy jsonNamingStrategy) {
        this.f142980k = jsonNamingStrategy;
    }

    public final void k(SerializersModule serializersModule) {
        Intrinsics.checkNotNullParameter(serializersModule, "<set-?>");
        this.f142987r = serializersModule;
    }
}
