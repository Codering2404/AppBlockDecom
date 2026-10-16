package kotlinx.serialization.json;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
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
public final class JsonLiteral extends JsonPrimitive {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f143012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialDescriptor f143013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f143014c;

    public /* synthetic */ JsonLiteral(Object obj, boolean z2, SerialDescriptor serialDescriptor, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, z2, (i3 & 4) != 0 ? null : serialDescriptor);
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String a() {
        return this.f143014c;
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public boolean b() {
        return this.f143012a;
    }

    public final SerialDescriptor d() {
        return this.f143013b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonLiteral.class != obj.getClass()) {
            return false;
        }
        JsonLiteral jsonLiteral = (JsonLiteral) obj;
        return b() == jsonLiteral.b() && Intrinsics.areEqual(a(), jsonLiteral.a());
    }

    public int hashCode() {
        return (Boolean.hashCode(b()) * 31) + a().hashCode();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String toString() {
        if (!b()) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        StringOpsKt.c(sb, a());
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonLiteral(Object body, boolean z2, SerialDescriptor serialDescriptor) {
        super(null);
        Intrinsics.checkNotNullParameter(body, "body");
        this.f143012a = z2;
        this.f143013b = serialDescriptor;
        this.f143014c = body.toString();
        if (serialDescriptor != null && !serialDescriptor.isInline()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
    }
}
