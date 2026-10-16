package androidx.compose.ui.geometry;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MutableRect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f25592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f25593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f25594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f25595d;

    public MutableRect(float f3, float f4, float f5, float f6) {
        this.f25592a = f3;
        this.f25593b = f4;
        this.f25594c = f5;
        this.f25595d = f6;
    }

    public final float a() {
        return this.f25595d;
    }

    public final float b() {
        return this.f25592a;
    }

    public final float c() {
        return this.f25594c;
    }

    public final float d() {
        return this.f25593b;
    }

    public final void e(float f3, float f4, float f5, float f6) {
        this.f25592a = Math.max(f3, this.f25592a);
        this.f25593b = Math.max(f4, this.f25593b);
        this.f25594c = Math.min(f5, this.f25594c);
        this.f25595d = Math.min(f6, this.f25595d);
    }

    public final boolean f() {
        return (this.f25592a >= this.f25594c) | (this.f25593b >= this.f25595d);
    }

    public final void g(float f3, float f4, float f5, float f6) {
        this.f25592a = f3;
        this.f25593b = f4;
        this.f25594c = f5;
        this.f25595d = f6;
    }

    public final void h(float f3) {
        this.f25595d = f3;
    }

    public final void i(float f3) {
        this.f25592a = f3;
    }

    public final void j(float f3) {
        this.f25594c = f3;
    }

    public final void k(float f3) {
        this.f25593b = f3;
    }

    public final void l(float f3, float f4) {
        this.f25592a += f3;
        this.f25593b += f4;
        this.f25594c += f3;
        this.f25595d += f4;
    }

    public final void m(long j3) {
        l(Float.intBitsToFloat((int) (j3 >> 32)), Float.intBitsToFloat((int) (j3 & 4294967295L)));
    }

    public String toString() {
        return "MutableRect(" + GeometryUtilsKt.a(this.f25592a, 1) + ", " + GeometryUtilsKt.a(this.f25593b, 1) + ", " + GeometryUtilsKt.a(this.f25594c, 1) + ", " + GeometryUtilsKt.a(this.f25595d, 1) + ')';
    }
}
