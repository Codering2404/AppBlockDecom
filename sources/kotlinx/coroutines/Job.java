package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.selects.SelectClause0;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public interface Job extends CoroutineContext.Element {
    public static final Key v8 = Key.f140967a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Key implements CoroutineContext.Key<Job> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Key f140967a = new Key();

        private Key() {
        }
    }

    ChildHandle attachChild(ChildJob childJob);

    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    /* synthetic */ boolean cancel(Throwable th);

    CancellationException getCancellationException();

    Sequence getChildren();

    SelectClause0 getOnJoin();

    Job getParent();

    DisposableHandle invokeOnCompletion(Function1 function1);

    DisposableHandle invokeOnCompletion(boolean z2, boolean z3, Function1 function1);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    Object join(Continuation continuation);

    Job plus(Job job);

    boolean start();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
        public static /* synthetic */ void b(Job job, CancellationException cancellationException, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i3 & 1) != 0) {
                cancellationException = null;
            }
            job.cancel(cancellationException);
        }

        public static Object c(Job job, Object obj, Function2 function2) {
            return CoroutineContext.Element.DefaultImpls.a(job, obj, function2);
        }

        public static CoroutineContext.Element d(Job job, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.b(job, key);
        }

        public static CoroutineContext e(Job job, CoroutineContext.Key key) {
            return CoroutineContext.Element.DefaultImpls.c(job, key);
        }

        public static CoroutineContext f(Job job, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(job, coroutineContext);
        }

        public static Job g(Job job, Job job2) {
            return job2;
        }
    }
}
