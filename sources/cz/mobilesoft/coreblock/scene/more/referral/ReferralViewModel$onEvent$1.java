package cz.mobilesoft.coreblock.scene.more.referral;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$onEvent$1", f = "ReferralViewModel.kt", l = {60, 60}, m = "invokeSuspend", v = 1)
final class ReferralViewModel$onEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f107984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f107985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f107986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f107987d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ReferralViewModel f107988f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ReferralViewModel$onEvent$1(ReferralViewModel referralViewModel, Continuation continuation) {
        super(2, continuation);
        this.f107988f = referralViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ReferralViewModel$onEvent$1(this.f107988f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r4.P0(r5, r6) != r0) goto L19;
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
            int r1 = r6.f107987d
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L6d
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            int r1 = r6.f107985b
            int r3 = r6.f107984a
            java.lang.Object r4 = r6.f107986c
            cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel r4 = (cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel) r4
            kotlin.ResultKt.b(r7)
            goto L56
        L26:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel r7 = r6.f107988f
            cz.mobilesoft.coreblock.scene.more.referral.ReferralViewState r7 = cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel.R0(r7)
            java.lang.Integer r7 = r7.c()
            if (r7 == 0) goto L6d
            cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel r4 = r6.f107988f
            int r7 = r7.intValue()
            cz.mobilesoft.coreblock.storage.datastore.DiscountDataStore r1 = cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel.S0(r4)
            kotlinx.coroutines.flow.Flow r1 = r1.J0()
            r6.f107986c = r4
            r6.f107984a = r7
            r5 = 0
            r6.f107985b = r5
            r6.f107987d = r3
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.D(r1, r6)
            if (r1 != r0) goto L53
            goto L6c
        L53:
            r3 = r7
            r7 = r1
            r1 = r5
        L56:
            java.lang.String r7 = (java.lang.String) r7
            cz.mobilesoft.coreblock.scene.more.referral.ReferralViewCommand$OpenSharing r5 = new cz.mobilesoft.coreblock.scene.more.referral.ReferralViewCommand$OpenSharing
            r5.<init>(r7, r3)
            r7 = 0
            r6.f107986c = r7
            r6.f107984a = r3
            r6.f107985b = r1
            r6.f107987d = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel.V0(r4, r5, r6)
            if (r7 != r0) goto L6d
        L6c:
            return r0
        L6d:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.referral.ReferralViewModel$onEvent$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ReferralViewModel$onEvent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
