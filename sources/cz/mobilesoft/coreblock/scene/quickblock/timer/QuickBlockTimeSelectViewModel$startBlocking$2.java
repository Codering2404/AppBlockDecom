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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$startBlocking$2", f = "QuickBlockTimeSelectViewModel.kt", l = {116, 117}, m = "invokeSuspend", v = 1)
final class QuickBlockTimeSelectViewModel$startBlocking$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f114308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ QuickBlockTimeSelectViewModel f114310c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    QuickBlockTimeSelectViewModel$startBlocking$2(QuickBlockTimeSelectViewModel quickBlockTimeSelectViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114310c = quickBlockTimeSelectViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new QuickBlockTimeSelectViewModel$startBlocking$2(this.f114310c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r1.P0(r3, r4) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f114309b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L48
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L30
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel r5 = r4.f114310c
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r5 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.V0(r5)
            r4.f114309b = r3
            java.lang.Object r5 = r5.f(r4)
            if (r5 != r0) goto L30
            goto L47
        L30:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel r1 = r4.f114310c
            cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewCommand$OnQuickBlockStarted r3 = new cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewCommand$OnQuickBlockStarted
            r3.<init>(r5)
            r4.f114308a = r5
            r4.f114309b = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel.X0(r1, r3, r4)
            if (r5 != r0) goto L48
        L47:
            return r0
        L48:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.quickblock.timer.QuickBlockTimeSelectViewModel$startBlocking$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((QuickBlockTimeSelectViewModel$startBlocking$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
