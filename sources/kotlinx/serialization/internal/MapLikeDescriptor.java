package kotlinx.serialization.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;

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
public abstract class MapLikeDescriptor implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f142841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SerialDescriptor f142842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SerialDescriptor f142843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f142844d;

    public /* synthetic */ MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, serialDescriptor, serialDescriptor2);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return SerialDescriptor.DefaultImpls.c(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer numU = StringsKt.u(name);
        if (numU != null) {
            return numU.intValue();
        }
        throw new IllegalArgumentException(name + " is not a valid map index");
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return StructureKind.MAP.f142755a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f142844d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapLikeDescriptor)) {
            return false;
        }
        MapLikeDescriptor mapLikeDescriptor = (MapLikeDescriptor) obj;
        return Intrinsics.areEqual(i(), mapLikeDescriptor.i()) && Intrinsics.areEqual(this.f142842b, mapLikeDescriptor.f142842b) && Intrinsics.areEqual(this.f142843c, mapLikeDescriptor.f142843c);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i3) {
        return String.valueOf(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        if (i3 >= 0) {
            return CollectionsKt.emptyList();
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + i() + " expects only non-negative indices").toString());
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return SerialDescriptor.DefaultImpls.a(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        if (i3 >= 0) {
            int i4 = i3 % 2;
            if (i4 == 0) {
                return this.f142842b;
            }
            if (i4 == 1) {
                return this.f142843c;
            }
            throw new IllegalStateException("Unreached");
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + i() + " expects only non-negative indices").toString());
    }

    public int hashCode() {
        return (((i().hashCode() * 31) + this.f142842b.hashCode()) * 31) + this.f142843c.hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142841a;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return SerialDescriptor.DefaultImpls.b(this);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        if (i3 >= 0) {
            return false;
        }
        throw new IllegalArgumentException(("Illegal index " + i3 + ", " + i() + " expects only non-negative indices").toString());
    }

    public String toString() {
        return i() + '(' + this.f142842b + ", " + this.f142843c + ')';
    }

    private MapLikeDescriptor(String str, SerialDescriptor serialDescriptor, SerialDescriptor serialDescriptor2) {
        this.f142841a = str;
        this.f142842b = serialDescriptor;
        this.f142843c = serialDescriptor2;
        this.f142844d = 2;
    }
}
