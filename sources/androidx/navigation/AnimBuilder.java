package androidx.navigation;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@NavOptionsDsl
public final class AnimBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f48758a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f48759b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48760c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48761d = -1;

    public final int a() {
        return this.f48758a;
    }

    public final int b() {
        return this.f48759b;
    }

    public final int c() {
        return this.f48760c;
    }

    public final int d() {
        return this.f48761d;
    }

    public final void e(int i3) {
        this.f48758a = i3;
    }

    public final void f(int i3) {
        this.f48759b = i3;
    }
}
