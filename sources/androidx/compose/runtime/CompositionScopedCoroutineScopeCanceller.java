package androidx.compose.runtime;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

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
public final class CompositionScopedCoroutineScopeCanceller implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f23846a;

    public CompositionScopedCoroutineScopeCanceller(CoroutineScope coroutineScope) {
        this.f23846a = coroutineScope;
    }

    public final CoroutineScope a() {
        return this.f23846a;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        CoroutineScope coroutineScope = this.f23846a;
        if (coroutineScope instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) coroutineScope).a();
        } else {
            CoroutineScopeKt.d(coroutineScope, new LeftCompositionCancellationException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        CoroutineScope coroutineScope = this.f23846a;
        if (coroutineScope instanceof RememberedCoroutineScope) {
            ((RememberedCoroutineScope) coroutineScope).a();
        } else {
            CoroutineScopeKt.d(coroutineScope, new LeftCompositionCancellationException());
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
    }
}
