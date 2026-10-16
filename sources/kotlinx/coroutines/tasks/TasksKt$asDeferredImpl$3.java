package kotlinx.coroutines.tasks;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.ChildHandle;
import kotlinx.coroutines.ChildJob;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.selects.SelectClause0;

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
public final class TasksKt$asDeferredImpl$3 implements Deferred<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ CompletableDeferred f142679a;

    @Override // kotlinx.coroutines.Job
    public ChildHandle attachChild(ChildJob childJob) {
        return this.f142679a.attachChild(childJob);
    }

    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation continuation) {
        return this.f142679a.await(continuation);
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        this.f142679a.cancel();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return this.f142679a.fold(obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return this.f142679a.get(key);
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException getCancellationException() {
        return this.f142679a.getCancellationException();
    }

    @Override // kotlinx.coroutines.Job
    public Sequence getChildren() {
        return this.f142679a.getChildren();
    }

    @Override // kotlinx.coroutines.Deferred
    public Object getCompleted() {
        return this.f142679a.getCompleted();
    }

    @Override // kotlinx.coroutines.Deferred
    public Throwable getCompletionExceptionOrNull() {
        return this.f142679a.getCompletionExceptionOrNull();
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public CoroutineContext.Key getKey() {
        return this.f142679a.getKey();
    }

    @Override // kotlinx.coroutines.Job
    public SelectClause0 getOnJoin() {
        return this.f142679a.getOnJoin();
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        return this.f142679a.getParent();
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(Function1 function1) {
        return this.f142679a.invokeOnCompletion(function1);
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return this.f142679a.isActive();
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return this.f142679a.isCancelled();
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return this.f142679a.isCompleted();
    }

    @Override // kotlinx.coroutines.Job
    public Object join(Continuation continuation) {
        return this.f142679a.join(continuation);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return this.f142679a.minusKey(key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return this.f142679a.plus(coroutineContext);
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return this.f142679a.start();
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
        this.f142679a.cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(boolean z2, boolean z3, Function1 function1) {
        return this.f142679a.invokeOnCompletion(z2, z3, function1);
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job job) {
        return this.f142679a.plus(job);
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable th) {
        return this.f142679a.cancel(th);
    }
}
