package androidx.compose.runtime;

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
public final class KeyInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f23919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f23920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f23921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f23922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23923e;

    public KeyInfo(int i3, Object obj, int i4, int i5, int i6) {
        this.f23919a = i3;
        this.f23920b = obj;
        this.f23921c = i4;
        this.f23922d = i5;
        this.f23923e = i6;
    }

    public final int a() {
        return this.f23919a;
    }

    public final int b() {
        return this.f23921c;
    }

    public final int c() {
        return this.f23922d;
    }

    public final Object d() {
        return this.f23920b;
    }
}
