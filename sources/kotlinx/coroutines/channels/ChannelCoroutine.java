package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause2;

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
public class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Channel f141126d;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel channel, boolean z2, boolean z3) {
        super(coroutineContext, z2, z3);
        this.f141126d = channel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean A() {
        return this.f141126d.A();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void Y(Throwable th) {
        CancellationException cancellationExceptionU0 = JobSupport.U0(this, th, null, 1, null);
        this.f141126d.cancel(cancellationExceptionU0);
        W(cancellationExceptionU0);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b0(), null, this);
        }
        Y(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2 d() {
        return this.f141126d.d();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void g(Function1 function1) {
        this.f141126d.g(function1);
    }

    protected final Channel g1() {
        return this.f141126d;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        return this.f141126d.h(obj);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator iterator() {
        return this.f141126d.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 o() {
        return this.f141126d.o();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1 q() {
        return this.f141126d.q();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object s() {
        return this.f141126d.s();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object t(Continuation continuation) {
        Object objT = this.f141126d.t(continuation);
        IntrinsicsKt.f();
        return objT;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object v(Continuation continuation) {
        return this.f141126d.v(continuation);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        return this.f141126d.w(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return this.f141126d.y(obj, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public /* synthetic */ void cancel() {
        Y(new JobCancellationException(b0(), null, this));
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) {
        Y(new JobCancellationException(b0(), null, this));
        return true;
    }

    public final Channel f1() {
        return this;
    }
}
