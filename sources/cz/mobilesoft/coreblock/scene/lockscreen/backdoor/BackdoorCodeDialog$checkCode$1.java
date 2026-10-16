package cz.mobilesoft.coreblock.scene.lockscreen.backdoor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1", f = "BackdoorCodeDialog.kt", l = {264, 272, 273, 277}, m = "invokeSuspend", v = 1)
final class BackdoorCodeDialog$checkCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f105587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f105588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BackdoorCodeDialog f105589c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f105590d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1$1", f = "BackdoorCodeDialog.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f105591a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ BackdoorCodeDialog f105592b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(BackdoorCodeDialog backdoorCodeDialog, Continuation continuation) {
            super(2, continuation);
            this.f105592b = backdoorCodeDialog;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f105592b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f105591a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f105592b.T();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackdoorCodeDialog$checkCode$1(BackdoorCodeDialog backdoorCodeDialog, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f105589c = backdoorCodeDialog;
        this.f105590d = function0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invokeSuspend$lambda$1(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BackdoorCodeDialog$checkCode$1(this.f105589c, this.f105590d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        if (r10.z(r2, r9) == r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
    
        if (r10.y(r3, r9) == r0) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008f  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f105588b
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L2c
            if (r1 == r5) goto L28
            if (r1 == r4) goto L22
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            goto L1d
        L15:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1d:
            kotlin.ResultKt.b(r10)
            goto La3
        L22:
            long r4 = r9.f105587a
            kotlin.ResultKt.b(r10)
            goto L73
        L28:
            kotlin.ResultKt.b(r10)
            goto L3a
        L2c:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            r9.f105588b = r5
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.n(r10, r9)
            if (r10 != r0) goto L3a
            goto La2
        L3a:
            java.lang.Number r10 = (java.lang.Number) r10
            long r5 = r10.longValue()
            r7 = 0
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L5d
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            kotlinx.coroutines.CoroutineScope r0 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.q(r10)
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1$1 r3 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1$1
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            r1 = 0
            r3.<init>(r10, r1)
            r4 = 3
            r5 = 0
            r2 = 0
            kotlinx.coroutines.BuildersKt.d(r0, r1, r2, r3, r4, r5)
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L5d:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore r10 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.l(r10)
            kotlinx.coroutines.flow.Flow r10 = r10.A0()
            r9.f105587a = r5
            r9.f105588b = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt.D(r10, r9)
            if (r10 != r0) goto L72
            goto La2
        L72:
            r4 = r5
        L73:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L8f
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            kotlin.jvm.functions.Function0 r1 = r9.f105590d
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.g r2 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.g
            r2.<init>()
            r9.f105587a = r4
            r9.f105588b = r3
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.h(r10, r2, r9)
            if (r10 != r0) goto La3
            goto La2
        L8f:
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog r10 = r9.f105589c
            kotlin.jvm.functions.Function0 r1 = r9.f105590d
            cz.mobilesoft.coreblock.scene.lockscreen.backdoor.h r3 = new cz.mobilesoft.coreblock.scene.lockscreen.backdoor.h
            r3.<init>()
            r9.f105587a = r4
            r9.f105588b = r2
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog.g(r10, r3, r9)
            if (r10 != r0) goto La3
        La2:
            return r0
        La3:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.backdoor.BackdoorCodeDialog$checkCode$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BackdoorCodeDialog$checkCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
