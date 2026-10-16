package androidx.compose.material3.internal;

import androidx.compose.animation.core.h;
import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
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
public final class InternalMutatorMutex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f22049a = new AtomicReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Mutex f22050b = MutexKt.b(false, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Mutator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutatePriority f22051a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Job f22052b;

        public Mutator(MutatePriority mutatePriority, Job job) {
            this.f22051a = mutatePriority;
            this.f22052b = job;
        }

        public final boolean a(Mutator mutator) {
            return this.f22051a.compareTo(mutator.f22051a) >= 0;
        }

        public final void b() {
            Job.DefaultImpls.b(this.f22052b, null, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Mutator mutator) {
        Mutator mutator2;
        do {
            mutator2 = (Mutator) this.f22049a.get();
            if (mutator2 != null && !mutator.a(mutator2)) {
                throw new CancellationException("Current mutation had a higher priority");
            }
        } while (!h.a(this.f22049a, mutator2, mutator));
        if (mutator2 != null) {
            mutator2.b();
        }
    }

    public final Object d(MutatePriority mutatePriority, Function1 function1, Continuation continuation) {
        return CoroutineScopeKt.f(new InternalMutatorMutex$mutate$2(mutatePriority, this, function1, null), continuation);
    }

    public final boolean e(Function0 function0) {
        boolean zB = Mutex.DefaultImpls.b(this.f22050b, null, 1, null);
        if (!zB) {
            return zB;
        }
        try {
            function0.invoke();
            return zB;
        } finally {
            Mutex.DefaultImpls.c(this.f22050b, null, 1, null);
        }
    }
}
