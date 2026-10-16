package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
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
final class TooltipStateImpl implements TooltipState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutatorMutex f21486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableTransitionState f21487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CancellableContinuation f21488d;

    public TooltipStateImpl(boolean z2, boolean z3, MutatorMutex mutatorMutex) {
        this.f21485a = z3;
        this.f21486b = mutatorMutex;
        this.f21487c = new MutableTransitionState(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.material3.TooltipState
    public void a() {
        CancellableContinuation cancellableContinuation = this.f21488d;
        if (cancellableContinuation != null) {
            CancellableContinuation.DefaultImpls.a(cancellableContinuation, null, 1, null);
        }
    }

    @Override // androidx.compose.material3.TooltipState
    public MutableTransitionState b() {
        return this.f21487c;
    }

    @Override // androidx.compose.material3.TooltipState
    public Object c(MutatePriority mutatePriority, Continuation continuation) {
        Object objD = this.f21486b.d(mutatePriority, new TooltipStateImpl$show$2(this, new TooltipStateImpl$show$cancellableShow$1(this, null), mutatePriority, null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
        b().h(Boolean.FALSE);
    }

    public boolean f() {
        return this.f21485a;
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isVisible() {
        return ((Boolean) b().a()).booleanValue() || ((Boolean) b().b()).booleanValue();
    }
}
