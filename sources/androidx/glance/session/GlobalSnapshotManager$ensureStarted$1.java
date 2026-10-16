package androidx.glance.session;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.glance.session.GlobalSnapshotManager$ensureStarted$1", f = "GlobalSnapshotManager.kt", l = {80}, m = "invokeSuspend")
final class GlobalSnapshotManager$ensureStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f39528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f39529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f39530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Channel f39531d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GlobalSnapshotManager$ensureStarted$1(Channel channel, Continuation continuation) {
        super(2, continuation);
        this.f39531d = channel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GlobalSnapshotManager$ensureStarted$1(this.f39531d, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0037 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040 A[Catch: all -> 0x0017, TRY_LEAVE, TryCatch #1 {all -> 0x0017, blocks: (B:6:0x0013, B:17:0x0038, B:19:0x0040, B:14:0x002b, B:13:0x0026), top: B:29:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0035 -> B:17:0x0038). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f39530c
            r2 = 1
            if (r1 == 0) goto L21
            if (r1 != r2) goto L19
            java.lang.Object r1 = r4.f39529b
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r3 = r4.f39528a
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            kotlin.ResultKt.b(r5)     // Catch: java.lang.Throwable -> L17
            goto L38
        L17:
            r5 = move-exception
            goto L53
        L19:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L21:
            kotlin.ResultKt.b(r5)
            kotlinx.coroutines.channels.Channel r3 = r4.f39531d
            kotlinx.coroutines.channels.ChannelIterator r5 = r3.iterator()     // Catch: java.lang.Throwable -> L17
            r1 = r5
        L2b:
            r4.f39528a = r3     // Catch: java.lang.Throwable -> L17
            r4.f39529b = r1     // Catch: java.lang.Throwable -> L17
            r4.f39530c = r2     // Catch: java.lang.Throwable -> L17
            java.lang.Object r5 = r1.a(r4)     // Catch: java.lang.Throwable -> L17
            if (r5 != r0) goto L38
            return r0
        L38:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L17
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L17
            if (r5 == 0) goto L4c
            java.lang.Object r5 = r1.next()     // Catch: java.lang.Throwable -> L17
            kotlin.Unit r5 = (kotlin.Unit) r5     // Catch: java.lang.Throwable -> L17
            androidx.compose.runtime.snapshots.Snapshot$Companion r5 = androidx.compose.runtime.snapshots.Snapshot.f24914e     // Catch: java.lang.Throwable -> L17
            r5.n()     // Catch: java.lang.Throwable -> L17
            goto L2b
        L4c:
            r5 = 0
            kotlinx.coroutines.channels.ChannelsKt.b(r3, r5)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L53:
            throw r5     // Catch: java.lang.Throwable -> L54
        L54:
            r0 = move-exception
            kotlinx.coroutines.channels.ChannelsKt.b(r3, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.GlobalSnapshotManager$ensureStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GlobalSnapshotManager$ensureStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
