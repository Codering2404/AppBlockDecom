package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
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
public final class Latch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f23924a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f23925b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f23926c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f23927d = true;

    public final Object c(Continuation continuation) {
        if (e()) {
            return Unit.f139807a;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        synchronized (this.f23924a) {
            this.f23925b.add(cancellableContinuationImpl);
        }
        cancellableContinuationImpl.m(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Latch$await$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable th) {
                Object obj = this.f23928a.f23924a;
                Latch latch = this.f23928a;
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                synchronized (obj) {
                    latch.f23925b.remove(cancellableContinuation);
                    Unit unit = Unit.f139807a;
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV == IntrinsicsKt.f() ? objV : Unit.f139807a;
    }

    public final void d() {
        synchronized (this.f23924a) {
            this.f23927d = false;
            Unit unit = Unit.f139807a;
        }
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f23924a) {
            z2 = this.f23927d;
        }
        return z2;
    }

    public final void f() {
        synchronized (this.f23924a) {
            try {
                if (e()) {
                    return;
                }
                List list = this.f23925b;
                this.f23925b = this.f23926c;
                this.f23926c = list;
                this.f23927d = true;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Continuation continuation = (Continuation) list.get(i3);
                    Result.Companion companion = Result.f139772b;
                    continuation.resumeWith(Result.b(Unit.f139807a));
                }
                list.clear();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
