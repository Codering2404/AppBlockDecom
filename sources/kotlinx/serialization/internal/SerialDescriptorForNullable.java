package kotlinx.serialization.internal;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;

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
public final class SerialDescriptorForNullable implements SerialDescriptor, CachedNames {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SerialDescriptor f142883a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f142884b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f142885c;

    public SerialDescriptorForNullable(SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(original, "original");
        this.f142883a = original;
        this.f142884b = original.i() + '?';
        this.f142885c = Platform_commonKt.a(original);
    }

    @Override // kotlinx.serialization.internal.CachedNames
    public Set a() {
        return this.f142885c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return true;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f142883a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f142883a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f142883a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SerialDescriptorForNullable) && Intrinsics.areEqual(this.f142883a, ((SerialDescriptorForNullable) obj).f142883a);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i3) {
        return this.f142883a.f(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        return this.f142883a.g(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.f142883a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return this.f142883a.h(i3);
    }

    public int hashCode() {
        return this.f142883a.hashCode() * 31;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142884b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f142883a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        return this.f142883a.j(i3);
    }

    public final SerialDescriptor k() {
        return this.f142883a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f142883a);
        sb.append('?');
        return sb.toString();
    }
}
