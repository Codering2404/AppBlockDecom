package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

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
final class ProduceFrameSignal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f24005a;

    public final Object c(Object obj, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        synchronized (obj) {
            if (this.f24005a == RecomposerKt.f24141a) {
                this.f24005a = RecomposerKt.f24142b;
                return Unit.f139807a;
            }
            Unit unit = Unit.f139807a;
            CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
            cancellableContinuationImpl2.C();
            synchronized (obj) {
                try {
                    if (this.f24005a == RecomposerKt.f24141a) {
                        this.f24005a = RecomposerKt.f24142b;
                        cancellableContinuationImpl = cancellableContinuationImpl2;
                    } else {
                        this.f24005a = cancellableContinuationImpl2;
                        cancellableContinuationImpl = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (cancellableContinuationImpl != null) {
                Result.Companion companion = Result.f139772b;
                cancellableContinuationImpl.resumeWith(Result.b(Unit.f139807a));
            }
            Object objV = cancellableContinuationImpl2.v();
            if (objV == IntrinsicsKt.f()) {
                DebugProbesKt.c(continuation);
            }
            return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
        }
    }

    public final Continuation d() {
        Object obj = this.f24005a;
        if (obj instanceof Continuation) {
            this.f24005a = RecomposerKt.f24142b;
            return (Continuation) obj;
        }
        if (Intrinsics.areEqual(obj, RecomposerKt.f24141a) ? true : Intrinsics.areEqual(obj, RecomposerKt.f24142b)) {
            return null;
        }
        if (obj == null) {
            this.f24005a = RecomposerKt.f24141a;
            return null;
        }
        throw new IllegalStateException(("invalid pendingFrameContinuation " + obj).toString());
    }

    public final void e() {
        if (!(this.f24005a == RecomposerKt.f24142b)) {
            PreconditionsKt.b("frame not pending");
        }
        this.f24005a = null;
    }
}
