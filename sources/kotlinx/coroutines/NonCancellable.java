package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
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
public final class NonCancellable extends AbstractCoroutineContextElement implements Job {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NonCancellable f141003a = new NonCancellable();

    private NonCancellable() {
        super(Job.v8);
    }

    @Override // kotlinx.coroutines.Job
    public ChildHandle attachChild(ChildJob childJob) {
        return NonDisposableHandle.f141004a;
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cancellationException) {
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException getCancellationException() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Sequence getChildren() {
        return SequencesKt.g();
    }

    @Override // kotlinx.coroutines.Job
    public SelectClause0 getOnJoin() {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Job getParent() {
        return null;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(Function1 function1) {
        return NonDisposableHandle.f141004a;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        return true;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCancelled() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isCompleted() {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public Object join(Continuation continuation) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // kotlinx.coroutines.Job
    public Job plus(Job job) {
        return Job.DefaultImpls.g(this, job);
    }

    @Override // kotlinx.coroutines.Job
    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ boolean cancel(Throwable th) {
        return false;
    }

    @Override // kotlinx.coroutines.Job
    public DisposableHandle invokeOnCompletion(boolean z2, boolean z3, Function1 function1) {
        return NonDisposableHandle.f141004a;
    }

    @Override // kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }
}
