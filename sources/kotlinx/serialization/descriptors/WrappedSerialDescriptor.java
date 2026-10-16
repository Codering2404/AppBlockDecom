package kotlinx.serialization.descriptors;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class WrappedSerialDescriptor implements SerialDescriptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ SerialDescriptor f142757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f142758b;

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean b() {
        return this.f142757a.b();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int c(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.f142757a.c(name);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialKind d() {
        return this.f142757a.d();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public int e() {
        return this.f142757a.e();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String f(int i3) {
        return this.f142757a.f(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List g(int i3) {
        return this.f142757a.g(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public List getAnnotations() {
        return this.f142757a.getAnnotations();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public SerialDescriptor h(int i3) {
        return this.f142757a.h(i3);
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public String i() {
        return this.f142758b;
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean isInline() {
        return this.f142757a.isInline();
    }

    @Override // kotlinx.serialization.descriptors.SerialDescriptor
    public boolean j(int i3) {
        return this.f142757a.j(i3);
    }
}
