package kotlinx.serialization.json.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;

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
public final class ArrayAsSequence implements CharSequence {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f143054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f143055b;

    public char a(int i3) {
        return this.f143054a[i3];
    }

    public final char[] b() {
        return this.f143054a;
    }

    public int c() {
        return this.f143055b;
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ char charAt(int i3) {
        return a(i3);
    }

    public void d(int i3) {
        this.f143055b = i3;
    }

    public final String e(int i3, int i4) {
        return StringsKt.z(this.f143054a, i3, Math.min(i4, length()));
    }

    public final void f(int i3) {
        d(Math.min(this.f143054a.length, i3));
    }

    @Override // java.lang.CharSequence
    public final /* bridge */ int length() {
        return c();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i3, int i4) {
        return StringsKt.z(this.f143054a, i3, Math.min(i4, length()));
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return e(0, length());
    }
}
