package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
final class ContextDescriptor implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SerialDescriptor f142719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final KClass f142720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f142721c;

    public ContextDescriptor(SerialDescriptor original, KClass kClass) {
        Intrinsics.checkNotNullParameter(original, "original");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        this.f142719a = original;
        this.f142720b = kClass;
        this.f142721c = original.i() + '<' + kClass.m() + '>';
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return this.f142719a.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f142719a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f142719a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f142719a.e();
    }

    public boolean equals(Object obj) {
        ContextDescriptor contextDescriptor = obj instanceof ContextDescriptor ? (ContextDescriptor) obj : null;
        return contextDescriptor != null && Intrinsics.areEqual(this.f142719a, contextDescriptor.f142719a) && Intrinsics.areEqual(contextDescriptor.f142720b, this.f142720b);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i3) {
        return this.f142719a.f(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        return this.f142719a.g(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.f142719a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return this.f142719a.h(i3);
    }

    public int hashCode() {
        return (this.f142720b.hashCode() * 31) + i().hashCode();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142721c;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f142719a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        return this.f142719a.j(i3);
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f142720b + ", original: " + this.f142719a + ')';
    }
}
