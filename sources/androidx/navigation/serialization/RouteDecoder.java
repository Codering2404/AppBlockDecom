package androidx.navigation.serialization;

import android.os.Bundle;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class RouteDecoder extends AbstractDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ArgStore f49465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f49466b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f49467c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SerializersModule f49468d;

    public RouteDecoder(Bundle bundle, Map typeMap) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.f49466b = -1;
        this.f49467c = "";
        this.f49468d = SerializersModuleKt.a();
        this.f49465a = new SavedStateArgStore(bundle, typeMap);
    }

    private final Object L() {
        Object objB = this.f49465a.b(this.f49467c);
        if (objB != null) {
            return objB;
        }
        throw new IllegalStateException(("Unexpected null value for non-nullable argument " + this.f49467c).toString());
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public boolean D() {
        return this.f49465a.b(this.f49467c) != null;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Object G(DeserializationStrategy deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return L();
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder
    public Object J() {
        return L();
    }

    public final Object K(DeserializationStrategy deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return super.G(deserializer);
    }

    @Override // kotlinx.serialization.encoding.Decoder, kotlinx.serialization.encoding.CompositeDecoder
    public SerializersModule a() {
        return this.f49468d;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Void j() {
        return null;
    }

    @Override // kotlinx.serialization.encoding.CompositeDecoder
    public int o(SerialDescriptor descriptor) {
        String strF;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        int i3 = this.f49466b;
        do {
            i3++;
            if (i3 >= descriptor.e()) {
                return -1;
            }
            strF = descriptor.f(i3);
        } while (!this.f49465a.a(strF));
        this.f49466b = i3;
        this.f49467c = strF;
        return i3;
    }

    @Override // kotlinx.serialization.encoding.AbstractDecoder, kotlinx.serialization.encoding.Decoder
    public Decoder q(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (RouteSerializerKt.t(descriptor)) {
            this.f49467c = descriptor.f(0);
            this.f49466b = 0;
        }
        return super.q(descriptor);
    }
}
