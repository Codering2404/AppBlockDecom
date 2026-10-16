package cz.mobilesoft.coreblock.service.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.receiver.OnBootReceiver$onReceive$1$1", f = "OnBootReceiver.kt", l = {27, 29, 30}, m = "invokeSuspend", v = 1)
final class OnBootReceiver$onReceive$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f123712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f123713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnBootReceiver f123714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f123715d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BroadcastReceiver.PendingResult f123716f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnBootReceiver$onReceive$1$1(OnBootReceiver onBootReceiver, Context context, BroadcastReceiver.PendingResult pendingResult, Continuation continuation) {
        super(1, continuation);
        this.f123714c = onBootReceiver;
        this.f123715d = context;
        this.f123716f = pendingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OnBootReceiver$onReceive$1$1(this.f123714c, this.f123715d, this.f123716f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x009c, code lost:
    
        if (r8.b(r3, r7) != r0) goto L38;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f123713b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L35
            if (r1 == r4) goto L2d
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r0 = r7.f123712a
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r0 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L1a
            goto L9f
        L1a:
            r8 = move-exception
            goto La7
        L1d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L25:
            java.lang.Object r1 = r7.f123712a
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r1 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx) r1
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L1a
            goto L8c
        L2d:
            java.lang.Object r1 = r7.f123712a
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r1 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx) r1
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L1a
            goto L74
        L35:
            kotlin.ResultKt.b(r8)
            r8 = 0
            cz.mobilesoft.coreblock.util.runnability.JobHelper.M(r8)     // Catch: java.lang.Throwable -> L1a
            cz.mobilesoft.coreblock.service.receiver.OnBootReceiver r8 = r7.f123714c     // Catch: java.lang.Throwable -> L1a
            boolean r1 = r8 instanceof org.koin.core.component.KoinScopeComponent     // Catch: java.lang.Throwable -> L1a
            java.lang.Class<cz.mobilesoft.coreblock.util.runnability.JobHelperKtx> r5 = cz.mobilesoft.coreblock.util.runnability.JobHelperKtx.class
            r6 = 0
            if (r1 == 0) goto L51
            org.koin.core.component.KoinScopeComponent r8 = (org.koin.core.component.KoinScopeComponent) r8     // Catch: java.lang.Throwable -> L1a
            org.koin.core.scope.Scope r8 = r8.getScope()     // Catch: java.lang.Throwable -> L1a
            goto L5d
        L4c:
            java.lang.Object r8 = r8.e(r1, r6, r6)     // Catch: java.lang.Throwable -> L1a
            goto L62
        L51:
            org.koin.core.Koin r8 = r8.r0()     // Catch: java.lang.Throwable -> L1a
            org.koin.core.registry.ScopeRegistry r8 = r8.j()     // Catch: java.lang.Throwable -> L1a
            org.koin.core.scope.Scope r8 = r8.d()     // Catch: java.lang.Throwable -> L1a
        L5d:
            kotlin.reflect.KClass r1 = kotlin.jvm.internal.Reflection.b(r5)     // Catch: java.lang.Throwable -> L1a
            goto L4c
        L62:
            cz.mobilesoft.coreblock.util.runnability.JobHelperKtx r8 = (cz.mobilesoft.coreblock.util.runnability.JobHelperKtx) r8     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r8)     // Catch: java.lang.Throwable -> L1a
            r7.f123712a = r1     // Catch: java.lang.Throwable -> L1a
            r7.f123713b = r4     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = r8.p(r7)     // Catch: java.lang.Throwable -> L1a
            if (r1 != r0) goto L73
            goto L9e
        L73:
            r1 = r8
        L74:
            cz.mobilesoft.coreblock.util.location.GeofenceHelper r8 = cz.mobilesoft.coreblock.util.location.GeofenceHelper.f128735a     // Catch: java.lang.Throwable -> L1a
            android.content.Context r4 = r7.f123715d     // Catch: java.lang.Throwable -> L1a
            cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback r5 = new cz.mobilesoft.coreblock.util.location.GeofencesRecreationResultCallback     // Catch: java.lang.Throwable -> L1a
            r5.<init>()     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)     // Catch: java.lang.Throwable -> L1a
            r7.f123712a = r6     // Catch: java.lang.Throwable -> L1a
            r7.f123713b = r3     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = r8.t(r4, r5, r7)     // Catch: java.lang.Throwable -> L1a
            if (r8 != r0) goto L8c
            goto L9e
        L8c:
            cz.mobilesoft.coreblock.service.receiver.OnBootReceiver r8 = r7.f123714c     // Catch: java.lang.Throwable -> L1a
            android.content.Context r3 = r7.f123715d     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)     // Catch: java.lang.Throwable -> L1a
            r7.f123712a = r1     // Catch: java.lang.Throwable -> L1a
            r7.f123713b = r2     // Catch: java.lang.Throwable -> L1a
            java.lang.Object r8 = r8.b(r3, r7)     // Catch: java.lang.Throwable -> L1a
            if (r8 != r0) goto L9f
        L9e:
            return r0
        L9f:
            android.content.BroadcastReceiver$PendingResult r8 = r7.f123716f
            r8.finish()
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        La7:
            android.content.BroadcastReceiver$PendingResult r0 = r7.f123716f
            r0.finish()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.receiver.OnBootReceiver$onReceive$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((OnBootReceiver$onReceive$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
