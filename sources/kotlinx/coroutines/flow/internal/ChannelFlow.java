package kotlinx.coroutines.flow.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
public abstract class ChannelFlow<T> implements FusibleFlow<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineContext f142262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f142263b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BufferOverflow f142264c;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.ChannelFlow$collect$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlow$collect$2", f = "ChannelFlow.kt", l = {119}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f142265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private /* synthetic */ Object f142266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FlowCollector f142267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ ChannelFlow f142268d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(FlowCollector flowCollector, ChannelFlow channelFlow, Continuation continuation) {
            super(2, continuation);
            this.f142267c = flowCollector;
            this.f142268d = channelFlow;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f142267c, this.f142268d, continuation);
            anonymousClass2.f142266b = obj;
            return anonymousClass2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f142265a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.f142266b;
                FlowCollector flowCollector = this.f142267c;
                ReceiveChannel receiveChannelM = this.f142268d.m(coroutineScope);
                this.f142265a = 1;
                if (FlowKt.z(flowCollector, receiveChannelM, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public ChannelFlow(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow) {
        this.f142262a = coroutineContext;
        this.f142263b = i3;
        this.f142264c = bufferOverflow;
    }

    static /* synthetic */ Object g(ChannelFlow channelFlow, FlowCollector flowCollector, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new AnonymousClass2(flowCollector, channelFlow, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // kotlinx.coroutines.flow.internal.FusibleFlow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public kotlinx.coroutines.flow.Flow a(kotlin.coroutines.CoroutineContext r2, int r3, kotlinx.coroutines.channels.BufferOverflow r4) {
        /*
            r1 = this;
            kotlin.coroutines.CoroutineContext r0 = r1.f142262a
            kotlin.coroutines.CoroutineContext r2 = r2.plus(r0)
            kotlinx.coroutines.channels.BufferOverflow r0 = kotlinx.coroutines.channels.BufferOverflow.f141062a
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f142263b
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r3 = r3 + r4
            if (r3 < 0) goto L20
            goto L23
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f142264c
        L25:
            kotlin.coroutines.CoroutineContext r0 = r1.f142262a
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f142263b
            if (r3 != r0) goto L36
            kotlinx.coroutines.channels.BufferOverflow r0 = r1.f142264c
            if (r4 != r0) goto L36
            return r1
        L36:
            kotlinx.coroutines.flow.internal.ChannelFlow r2 = r1.i(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChannelFlow.a(kotlin.coroutines.CoroutineContext, int, kotlinx.coroutines.channels.BufferOverflow):kotlinx.coroutines.flow.Flow");
    }

    @Override // kotlinx.coroutines.flow.Flow
    public Object collect(FlowCollector flowCollector, Continuation continuation) {
        return g(this, flowCollector, continuation);
    }

    protected String f() {
        return null;
    }

    protected abstract Object h(ProducerScope producerScope, Continuation continuation);

    protected abstract ChannelFlow i(CoroutineContext coroutineContext, int i3, BufferOverflow bufferOverflow);

    public Flow j() {
        return null;
    }

    public final Function2 k() {
        return new ChannelFlow$collectToFun$1(this, null);
    }

    public final int l() {
        int i3 = this.f142263b;
        if (i3 == -3) {
            return -2;
        }
        return i3;
    }

    public ReceiveChannel m(CoroutineScope coroutineScope) {
        return ProduceKt.e(coroutineScope, this.f142262a, l(), this.f142264c, CoroutineStart.f140918c, null, k(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strF = f();
        if (strF != null) {
            arrayList.add(strF);
        }
        if (this.f142262a != EmptyCoroutineContext.f139889a) {
            arrayList.add("context=" + this.f142262a);
        }
        if (this.f142263b != -3) {
            arrayList.add("capacity=" + this.f142263b);
        }
        if (this.f142264c != BufferOverflow.f141062a) {
            arrayList.add("onBufferOverflow=" + this.f142264c);
        }
        return DebugStringsKt.a(this) + '[' + CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
