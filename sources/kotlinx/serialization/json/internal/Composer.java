package kotlinx.serialization.json.internal;

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
public class Composer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InternalJsonWriter f143072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f143073b;

    public Composer(InternalJsonWriter writer) {
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.f143072a = writer;
        this.f143073b = true;
    }

    public final boolean a() {
        return this.f143073b;
    }

    public void b() {
        this.f143073b = true;
    }

    public void c() {
        this.f143073b = false;
    }

    public void d() {
        this.f143073b = false;
    }

    public void e(byte b3) {
        this.f143072a.writeLong(b3);
    }

    public final void f(char c3) {
        this.f143072a.a(c3);
    }

    public void g(double d3) {
        this.f143072a.c(String.valueOf(d3));
    }

    public void h(float f3) {
        this.f143072a.c(String.valueOf(f3));
    }

    public void i(int i3) {
        this.f143072a.writeLong(i3);
    }

    public void j(long j3) {
        this.f143072a.writeLong(j3);
    }

    public final void k(String v2) {
        Intrinsics.checkNotNullParameter(v2, "v");
        this.f143072a.c(v2);
    }

    public void l(short s2) {
        this.f143072a.writeLong(s2);
    }

    public void m(boolean z2) {
        this.f143072a.c(String.valueOf(z2));
    }

    public void n(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.f143072a.b(value);
    }

    protected final void o(boolean z2) {
        this.f143073b = z2;
    }

    public void p() {
    }

    public void q() {
    }
}
