package androidx.compose.ui.semantics;

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
public final class CollectionItemInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f28438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f28439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f28441d;

    public final int a() {
        return this.f28440c;
    }

    public final int b() {
        return this.f28441d;
    }

    public final int c() {
        return this.f28438a;
    }

    public final int d() {
        return this.f28439b;
    }
}
