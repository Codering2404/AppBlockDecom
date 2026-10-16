package kotlinx.serialization.internal;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorKt;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
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
public final class EnumDescriptor extends PluginGeneratedSerialDescriptor {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final SerialKind f142806m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Lazy f142807n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnumDescriptor(final String name, final int i3) {
        super(name, null, i3, 2, null);
        Intrinsics.checkNotNullParameter(name, "name");
        this.f142806m = SerialKind.ENUM.f142752a;
        this.f142807n = LazyKt.b(new Function0() { // from class: kotlinx.serialization.internal.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EnumDescriptor.B(i3, name, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SerialDescriptor[] B(int i3, String str, EnumDescriptor enumDescriptor) {
        SerialDescriptor[] serialDescriptorArr = new SerialDescriptor[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            serialDescriptorArr[i4] = SerialDescriptorsKt.h(str + '.' + enumDescriptor.f(i4), StructureKind.OBJECT.f142756a, new SerialDescriptor[0], null, 8, null);
        }
        return serialDescriptorArr;
    }

    private final SerialDescriptor[] C() {
        return (SerialDescriptor[]) this.f142807n.getValue();
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f142806m;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SerialDescriptor)) {
            return false;
        }
        SerialDescriptor serialDescriptor = (SerialDescriptor) obj;
        return serialDescriptor.d() == SerialKind.ENUM.f142752a && Intrinsics.areEqual(i(), serialDescriptor.i()) && Intrinsics.areEqual(Platform_commonKt.a(this), Platform_commonKt.a(serialDescriptor));
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor, kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return C()[i3];
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public int hashCode() {
        int iHashCode = i().hashCode();
        int iHashCode2 = 1;
        for (String str : SerialDescriptorKt.b(this)) {
            int i3 = iHashCode2 * 31;
            iHashCode2 = i3 + (str != null ? str.hashCode() : 0);
        }
        return (iHashCode * 31) + iHashCode2;
    }

    @Override // kotlinx.serialization.internal.PluginGeneratedSerialDescriptor
    public String toString() {
        return CollectionsKt.joinToString$default(SerialDescriptorKt.b(this), ", ", i() + '(', ")", 0, null, null, 56, null);
    }
}
