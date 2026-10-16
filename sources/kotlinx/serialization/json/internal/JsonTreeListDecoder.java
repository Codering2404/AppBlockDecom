package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonElement;

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
final class JsonTreeListDecoder extends AbstractJsonTreeDecoder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final JsonArray f143116g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f143117h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f143118i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeListDecoder(Json json, JsonArray value) {
        super(json, value, null, 4, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.f143116g = value;
        this.f143117h = C0().size();
        this.f143118i = -1;
    }

    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public JsonArray C0() {
        return this.f143116g;
    }

    @Override // kotlinx.serialization.internal.NamedValueDecoder
    protected String h0(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return String.valueOf(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.AbstractJsonTreeDecoder
    public JsonElement n0(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return C0().get(Integer.parseInt(tag));
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i3 = this.f143118i;
        if (i3 >= this.f143117h - 1) {
            return -1;
        }
        int i4 = i3 + 1;
        this.f143118i = i4;
        return i4;
    }
}
