package androidx.compose.material3.internal;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.material3.TooltipState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
final class BasicTooltipStateImpl implements TooltipState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutatorMutex f21895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f21896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableTransitionState f21897d = new MutableTransitionState(Boolean.FALSE);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CancellableContinuation f21898e;

    public BasicTooltipStateImpl(boolean z2, boolean z3, MutatorMutex mutatorMutex) {
        this.f21894a = z3;
        this.f21895b = mutatorMutex;
        this.f21896c = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(z2), null, 2, null);
    }

    @Override // androidx.compose.material3.TooltipState
    public void a() {
        CancellableContinuation cancellableContinuation = this.f21898e;
        if (cancellableContinuation != null) {
            CancellableContinuation.DefaultImpls.a(cancellableContinuation, null, 1, null);
        }
    }

    @Override // androidx.compose.material3.TooltipState
    public MutableTransitionState b() {
        return this.f21897d;
    }

    @Override // androidx.compose.material3.TooltipState
    public Object c(MutatePriority mutatePriority, Continuation continuation) {
        Object objD = this.f21895b.d(mutatePriority, new BasicTooltipStateImpl$show$2(this, new BasicTooltipStateImpl$show$cancellableShow$1(this, null), null), continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    @Override // androidx.compose.material3.TooltipState
    public void dismiss() {
        g(false);
    }

    public boolean f() {
        return this.f21894a;
    }

    public void g(boolean z2) {
        this.f21896c.setValue(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.material3.TooltipState
    public boolean isVisible() {
        return ((Boolean) this.f21896c.getValue()).booleanValue();
    }
}
