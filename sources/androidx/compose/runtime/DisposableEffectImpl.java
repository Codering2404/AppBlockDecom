package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
final class DisposableEffectImpl implements RememberObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f23875a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DisposableEffectResult f23876b;

    public DisposableEffectImpl(Function1 function1) {
        this.f23875a = function1;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        this.f23876b = (DisposableEffectResult) this.f23875a.invoke(EffectsKt.f23880a);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        DisposableEffectResult disposableEffectResult = this.f23876b;
        if (disposableEffectResult != null) {
            disposableEffectResult.dispose();
        }
        this.f23876b = null;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
    }
}
