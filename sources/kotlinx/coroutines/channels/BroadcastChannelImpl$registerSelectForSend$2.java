package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

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
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastChannelImpl$registerSelectForSend$2", f = "BroadcastChannel.kt", l = {240}, m = "invokeSuspend")
final class BroadcastChannelImpl$registerSelectForSend$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f141046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BroadcastChannelImpl f141047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Object f141048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ SelectInstance f141049d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BroadcastChannelImpl$registerSelectForSend$2(BroadcastChannelImpl broadcastChannelImpl, Object obj, SelectInstance selectInstance, Continuation continuation) {
        super(2, continuation);
        this.f141047b = broadcastChannelImpl;
        this.f141048c = obj;
        this.f141049d = selectInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BroadcastChannelImpl$registerSelectForSend$2(this.f141047b, this.f141048c, this.f141049d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f141046a;
        boolean z2 = true;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                BroadcastChannelImpl broadcastChannelImpl = this.f141047b;
                Object obj2 = this.f141048c;
                this.f141046a = 1;
                if (broadcastChannelImpl.y(obj2, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
        } catch (Throwable th) {
            if (!this.f141047b.A() || (!(th instanceof ClosedSendChannelException) && this.f141047b.s0() != th)) {
                throw th;
            }
            z2 = false;
        }
        ReentrantLock reentrantLock = this.f141047b.f141040o;
        BroadcastChannelImpl broadcastChannelImpl2 = this.f141047b;
        SelectInstance selectInstance = this.f141049d;
        reentrantLock.lock();
        try {
            broadcastChannelImpl2.f141043r.put(selectInstance, z2 ? Unit.f139807a : BufferedChannelKt.z());
            Intrinsics.checkNotNull(selectInstance, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            Unit unit = Unit.f139807a;
            if (((SelectImplementation) selectInstance).z(broadcastChannelImpl2, unit) != TrySelectDetailedResult.f142613b) {
                broadcastChannelImpl2.f141043r.remove(selectInstance);
            }
            reentrantLock.unlock();
            return unit;
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BroadcastChannelImpl$registerSelectForSend$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
