package kotlinx.coroutines.flow;

import androidx.compose.animation.core.h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.internal.Concurrent_commonKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f142242a = new AtomicReference(null);

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl stateFlowImpl) {
        if (Concurrent_commonKt.a(this.f142242a) != null) {
            return false;
        }
        Concurrent_commonKt.b(this.f142242a, StateFlowKt.f142240a);
        return true;
    }

    public final Object e(Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        if (!h.a(this.f142242a, StateFlowKt.f142240a, cancellableContinuationImpl)) {
            Result.Companion companion = Result.f139772b;
            cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
        }
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Continuation[] b(StateFlowImpl stateFlowImpl) {
        Concurrent_commonKt.b(this.f142242a, null);
        return AbstractSharedFlowKt.f142261a;
    }

    public final void g() {
        AtomicReference atomicReference = this.f142242a;
        while (true) {
            Object objA = Concurrent_commonKt.a(atomicReference);
            if (objA == null || objA == StateFlowKt.f142241b) {
                return;
            }
            if (objA == StateFlowKt.f142240a) {
                if (h.a(this.f142242a, objA, StateFlowKt.f142241b)) {
                    return;
                }
            } else if (h.a(this.f142242a, objA, StateFlowKt.f142240a)) {
                Result.Companion companion = Result.f139772b;
                ((CancellableContinuationImpl) objA).resumeWith(Result.b(Unit.f139807a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = this.f142242a.getAndSet(StateFlowKt.f142240a);
        Intrinsics.checkNotNull(andSet);
        return andSet == StateFlowKt.f142241b;
    }
}
