package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class MutatorMutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f4028a = new AtomicReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mutex f4029b = MutexKt.b(false, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Mutator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutatePriority f4030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Job f4031b;

        public Mutator(MutatePriority mutatePriority, Job job) {
            this.f4030a = mutatePriority;
            this.f4031b = job;
        }

        public final boolean a(Mutator mutator) {
            return this.f4030a.compareTo(mutator.f4030a) >= 0;
        }

        public final void b() {
            this.f4031b.cancel((CancellationException) new MutationInterruptedException());
        }
    }

    public static /* synthetic */ Object e(MutatorMutex mutatorMutex, MutatePriority mutatePriority, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            mutatePriority = MutatePriority.f4023a;
        }
        return mutatorMutex.d(mutatePriority, function1, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = (Mutator) this.f4028a.get();
            if (mutator2 != null && !mutator.a(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!h.a(this.f4028a, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.b();
        }
    }

    public final Object d(MutatePriority mutatePriority, Function1 function1, Continuation continuation) {
        return CoroutineScopeKt.f(new MutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }
}
