package androidx.window.embedding;

import android.os.Build;
import androidx.window.embedding.ExtensionEmbeddingBackend;
import androidx.window.embedding.SplitController;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
final class ExtensionEmbeddingBackend$splitSupportStatus$2 extends Lambda implements Function0<SplitController.SplitSupportStatus> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExtensionEmbeddingBackend f54220a;

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final SplitController.SplitSupportStatus invoke() {
        return !this.f54220a.e() ? SplitController.SplitSupportStatus.f54272d : Build.VERSION.SDK_INT >= 31 ? ExtensionEmbeddingBackend.Api31Impl.f54213a.a(this.f54220a.f54209a) : SplitController.SplitSupportStatus.f54271c;
    }
}
