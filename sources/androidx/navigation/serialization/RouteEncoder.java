package androidx.navigation.serialization;

import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.AbstractEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleBuildersKt;

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
public final class RouteEncoder<T> extends AbstractEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KSerializer f49469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f49470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SerializersModule f49471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f49472d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f49473e;

    public RouteEncoder(KSerializer serializer, Map typeMap) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(typeMap, "typeMap");
        this.f49469a = serializer;
        this.f49470b = typeMap;
        this.f49471c = SerializersModuleBuildersKt.a();
        this.f49472d = new LinkedHashMap();
        this.f49473e = -1;
    }

    private final void L(Object obj) {
        String strF = this.f49469a.getDescriptor().f(this.f49473e);
        NavType navType = (NavType) this.f49470b.get(strF);
        if (navType != null) {
            this.f49472d.put(strF, navType instanceof CollectionNavType ? ((CollectionNavType) navType).l(obj) : CollectionsKt.listOf(navType.i(obj)));
            return;
        }
        throw new IllegalStateException(("Cannot find NavType for argument " + strF + ". Please provide NavType through typeMap.").toString());
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public boolean H(SerialDescriptor descriptor, int i3) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.f49473e = i3;
        return true;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder
    public void J(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        L(value);
    }

    public final Map K(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        super.e(this.f49469a, value);
        return MapsKt.toMap(this.f49472d);
    }

    @Override // kotlinx.serialization.encoding.Encoder
    public SerializersModule a() {
        return this.f49471c;
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void e(SerializationStrategy serializer, Object obj) {
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        L(obj);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public Encoder l(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (RouteSerializerKt.t(descriptor)) {
            this.f49473e = 0;
        }
        return super.l(descriptor);
    }

    @Override // kotlinx.serialization.encoding.AbstractEncoder, kotlinx.serialization.encoding.Encoder
    public void o() {
        L(null);
    }
}
