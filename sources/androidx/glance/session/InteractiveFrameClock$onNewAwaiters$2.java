package androidx.glance.session;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.glance.session.InteractiveFrameClock$onNewAwaiters$2", f = "InteractiveFrameClock.kt", l = {116, 119}, m = "invokeSuspend")
final class InteractiveFrameClock$onNewAwaiters$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f39565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f39566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f39567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ InteractiveFrameClock f39568d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ long f39569f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InteractiveFrameClock$onNewAwaiters$2(Ref.LongRef longRef, Ref.LongRef longRef2, InteractiveFrameClock interactiveFrameClock, long j3, Continuation continuation) {
        super(2, continuation);
        this.f39566b = longRef;
        this.f39567c = longRef2;
        this.f39568d = interactiveFrameClock;
        this.f39569f = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InteractiveFrameClock$onNewAwaiters$2(this.f39566b, this.f39567c, this.f39568d, this.f39569f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (kotlinx.coroutines.YieldKt.a(r8) == r0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (kotlinx.coroutines.DelayKt.b((r6 - r4) / 1000000, r8) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r8.f39565a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r9)
            goto L4c
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            kotlin.ResultKt.b(r9)
            goto L36
        L1e:
            kotlin.ResultKt.b(r9)
            kotlin.jvm.internal.Ref$LongRef r9 = r8.f39566b
            long r4 = r9.f140143a
            kotlin.jvm.internal.Ref$LongRef r9 = r8.f39567c
            long r6 = r9.f140143a
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 < 0) goto L3e
            r8.f39565a = r3
            java.lang.Object r9 = kotlinx.coroutines.YieldKt.a(r8)
            if (r9 != r0) goto L36
            goto L4b
        L36:
            androidx.glance.session.InteractiveFrameClock r9 = r8.f39568d
            long r0 = r8.f39569f
            androidx.glance.session.InteractiveFrameClock.m(r9, r0)
            goto L5f
        L3e:
            long r6 = r6 - r4
            r3 = 1000000(0xf4240, double:4.940656E-318)
            long r6 = r6 / r3
            r8.f39565a = r2
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.b(r6, r8)
            if (r9 != r0) goto L4c
        L4b:
            return r0
        L4c:
            androidx.glance.session.InteractiveFrameClock r9 = r8.f39568d
            kotlin.jvm.functions.Function0 r0 = androidx.glance.session.InteractiveFrameClock.h(r9)
            java.lang.Object r0 = r0.invoke()
            java.lang.Number r0 = (java.lang.Number) r0
            long r0 = r0.longValue()
            androidx.glance.session.InteractiveFrameClock.m(r9, r0)
        L5f:
            kotlin.Unit r9 = kotlin.Unit.f139807a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.InteractiveFrameClock$onNewAwaiters$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InteractiveFrameClock$onNewAwaiters$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
