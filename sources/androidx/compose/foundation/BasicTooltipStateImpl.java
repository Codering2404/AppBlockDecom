package androidx.compose.foundation;

import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CancellableContinuation;

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
final class BasicTooltipStateImpl implements BasicTooltipState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f4712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutatorMutex f4713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f4714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellableContinuation f4715d;

    @Override // androidx.compose.foundation.BasicTooltipState
    public void a() {
        CancellableContinuation cancellableContinuation = this.f4715d;
        if (cancellableContinuation != null) {
            CancellableContinuation.DefaultImpls.a(cancellableContinuation, null, 1, null);
        }
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public Object c(MutatePriority mutatePriority, Continuation continuation) {
        Object objD = this.f4713b.d(mutatePriority, new BasicTooltipStateImpl$show$2(this, new BasicTooltipStateImpl$show$cancellableShow$1(this, null), null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public void dismiss() {
        f(false);
    }

    public boolean e() {
        return this.f4712a;
    }

    public void f(boolean z2) {
        this.f4714c.setValue(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.foundation.BasicTooltipState
    public boolean isVisible() {
        return ((Boolean) this.f4714c.getValue()).booleanValue();
    }
}
