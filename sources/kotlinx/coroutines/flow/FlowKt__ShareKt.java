package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

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
final /* synthetic */ class FlowKt__ShareKt {
    public static final SharedFlow a(MutableSharedFlow mutableSharedFlow) {
        return new ReadonlySharedFlow(mutableSharedFlow, null);
    }

    public static final StateFlow b(MutableStateFlow mutableStateFlow) {
        return new ReadonlyStateFlow(mutableStateFlow, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final kotlinx.coroutines.flow.SharingConfig c(kotlinx.coroutines.flow.Flow r7, int r8) {
        /*
            kotlinx.coroutines.channels.Channel$Factory r0 = kotlinx.coroutines.channels.Channel.w8
            int r0 = r0.a()
            int r0 = kotlin.ranges.RangesKt.f(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof kotlinx.coroutines.flow.internal.ChannelFlow
            if (r1 == 0) goto L3c
            r1 = r7
            kotlinx.coroutines.flow.internal.ChannelFlow r1 = (kotlinx.coroutines.flow.internal.ChannelFlow) r1
            kotlinx.coroutines.flow.Flow r2 = r1.j()
            if (r2 == 0) goto L3c
            kotlinx.coroutines.flow.SharingConfig r7 = new kotlinx.coroutines.flow.SharingConfig
            int r3 = r1.f142263b
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L34
        L26:
            kotlinx.coroutines.channels.BufferOverflow r4 = r1.f142264c
            kotlinx.coroutines.channels.BufferOverflow r5 = kotlinx.coroutines.channels.BufferOverflow.f141062a
            r6 = 0
            if (r4 != r5) goto L31
            if (r3 != 0) goto L34
        L2f:
            r0 = r6
            goto L34
        L31:
            if (r8 != 0) goto L2f
            r0 = 1
        L34:
            kotlinx.coroutines.channels.BufferOverflow r8 = r1.f142264c
            kotlin.coroutines.CoroutineContext r1 = r1.f142262a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3c:
            kotlinx.coroutines.flow.SharingConfig r8 = new kotlinx.coroutines.flow.SharingConfig
            kotlinx.coroutines.channels.BufferOverflow r1 = kotlinx.coroutines.channels.BufferOverflow.f141062a
            kotlin.coroutines.EmptyCoroutineContext r2 = kotlin.coroutines.EmptyCoroutineContext.f139889a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ShareKt.c(kotlinx.coroutines.flow.Flow, int):kotlinx.coroutines.flow.SharingConfig");
    }

    private static final Job d(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow flow, MutableSharedFlow mutableSharedFlow, SharingStarted sharingStarted, Object obj) {
        return BuildersKt.c(coroutineScope, coroutineContext, Intrinsics.areEqual(sharingStarted, SharingStarted.f142210a.c()) ? CoroutineStart.f140916a : CoroutineStart.f140919d, new FlowKt__ShareKt$launchSharing$1(sharingStarted, flow, mutableSharedFlow, obj, null));
    }

    private static final void e(CoroutineScope coroutineScope, CoroutineContext coroutineContext, Flow flow, CompletableDeferred completableDeferred) {
        BuildersKt__Builders_commonKt.d(coroutineScope, coroutineContext, null, new FlowKt__ShareKt$launchSharingDeferred$1(flow, completableDeferred, null), 2, null);
    }

    public static final SharedFlow f(SharedFlow sharedFlow, Function2 function2) {
        return new SubscribedSharedFlow(sharedFlow, function2);
    }

    public static final SharedFlow g(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i3) {
        SharingConfig sharingConfigC = c(flow, i3);
        MutableSharedFlow mutableSharedFlowA = SharedFlowKt.a(i3, sharingConfigC.f142207b, sharingConfigC.f142208c);
        return new ReadonlySharedFlow(mutableSharedFlowA, d(coroutineScope, sharingConfigC.f142209d, sharingConfigC.f142206a, mutableSharedFlowA, sharingStarted, SharedFlowKt.f142198a));
    }

    public static final Object h(Flow flow, CoroutineScope coroutineScope, Continuation continuation) {
        SharingConfig sharingConfigC = c(flow, 1);
        CompletableDeferred completableDeferredB = CompletableDeferredKt.b(null, 1, null);
        e(coroutineScope, sharingConfigC.f142209d, sharingConfigC.f142206a, completableDeferredB);
        return completableDeferredB.await(continuation);
    }

    public static final StateFlow i(Flow flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, Object obj) {
        SharingConfig sharingConfigC = c(flow, 1);
        MutableStateFlow mutableStateFlowA = StateFlowKt.a(obj);
        return new ReadonlyStateFlow(mutableStateFlowA, d(coroutineScope, sharingConfigC.f142209d, sharingConfigC.f142206a, mutableStateFlowA, sharingStarted, obj));
    }
}
