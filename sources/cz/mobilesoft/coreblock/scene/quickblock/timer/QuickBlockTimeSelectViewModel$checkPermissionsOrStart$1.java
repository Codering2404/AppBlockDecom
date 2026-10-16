package cz.mobilesoft.coreblock.scene.quickblock.timer;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1", f = "QuickBlockTimeSelectViewModel.kt", l = {84, 88}, m = "invokeSuspend", v = 1)
final class QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f114280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockTimeSelectViewModel f114282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f114283d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1(QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel, long j3, Continuation continuation) {
        super(1, continuation);
        this.f114282c = quickBlockTimeSelectViewModel;
        this.f114283d = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1(this.f114282c, this.f114283d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0055, code lost:
    
        if (r1.P0(r3, r6) == r0) goto L18;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f114281b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.f114280a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r7)
            goto L58
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L30
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel r7 = r6.f114282c
            r6.f114281b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.T0(r7, r6)
            if (r7 != r0) goto L30
            goto L57
        L30:
            java.util.List r7 = (java.util.List) r7
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L40
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel r7 = r6.f114282c
            long r0 = r6.f114283d
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.Y0(r7, r0)
            goto L58
        L40:
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel r1 = r6.f114282c
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewCommand$ShowPermissionsBeforeStart r3 = new cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewCommand$ShowPermissionsBeforeStart
            long r4 = r6.f114283d
            r3.<init>(r4, r7)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f114280a = r7
            r6.f114281b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.X0(r1, r3, r6)
            if (r7 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((QuickBlockTimeSelectViewModel$checkPermissionsOrStart$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
