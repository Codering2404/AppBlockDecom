package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.channels.SendChannel;

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
class BroadcastCoroutine<E> extends AbstractCoroutine<Unit> implements ProducerScope<E>, BroadcastChannel<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BroadcastChannel f141057d;

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean A() {
        return this.f141057d.A();
    }

    @Override // kotlinx.coroutines.JobSupport
    public void Y(Throwable th) {
        CancellationException cancellationExceptionU0 = JobSupport.U0(this, th, null, 1, null);
        this.f141057d.cancel(cancellationExceptionU0);
        W(cancellationExceptionU0);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine
    protected void c1(Throwable th, boolean z2) {
        if (this.f141057d.w(th) || z2) {
            return;
        }
        CoroutineExceptionHandlerKt.a(getContext(), th);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final /* synthetic */ boolean cancel(Throwable th) {
        if (th == null) {
            th = new JobCancellationException(b0(), null, this);
        }
        Y(th);
        return true;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel e() {
        return this.f141057d.e();
    }

    protected final BroadcastChannel f1() {
        return this.f141057d;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void g(Function1 function1) {
        this.f141057d.g(function1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.AbstractCoroutine
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void d1(Unit unit) {
        SendChannel.DefaultImpls.a(this.f141057d, null, 1, null);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object h(Object obj) {
        return this.f141057d.h(obj);
    }

    @Override // kotlinx.coroutines.AbstractCoroutine, kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public boolean isActive() {
        return super.isActive();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean w(Throwable th) {
        boolean zW = this.f141057d.w(th);
        start();
        return zW;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object y(Object obj, Continuation continuation) {
        return this.f141057d.y(obj, continuation);
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new JobCancellationException(b0(), null, this);
        }
        Y(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ProducerScope
    public SendChannel n() {
        return this;
    }
}
