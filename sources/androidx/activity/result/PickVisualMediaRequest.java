package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PickVisualMediaRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ActivityResultContracts.PickVisualMedia.VisualMediaType f574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ActivityResultContracts.PickVisualMedia.DefaultTab f577d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f578e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f579f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    public final long a() {
        return this.f579f;
    }

    public final ActivityResultContracts.PickVisualMedia.DefaultTab b() {
        return this.f577d;
    }

    public final int c() {
        return this.f575b;
    }

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType d() {
        return this.f574a;
    }

    public final boolean e() {
        return this.f578e;
    }

    public final boolean f() {
        return this.f576c;
    }
}
