package cz.mobilesoft.coreblock.scene.onboarding;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$setupPreferences$1", f = "OnboardingViewModelV2.kt", l = {287, 287, 287}, m = "invokeSuspend", v = 1)
final class OnboardingViewModelV2$setupPreferences$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f111003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f111004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ OnboardingViewModelV2 f111005c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OnboardingViewModelV2$setupPreferences$1(OnboardingViewModelV2 onboardingViewModelV2, Continuation continuation) {
        super(1, continuation);
        this.f111005c = onboardingViewModelV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new OnboardingViewModelV2$setupPreferences$1(this.f111005c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x005e, code lost:
    
        if (r7 == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0079, code lost:
    
        if (r1.P0(r7, r6) != r0) goto L28;
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
            int r1 = r6.f111004b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2d
            if (r1 == r4) goto L25
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r7)
            goto L7c
        L15:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1d:
            java.lang.Object r1 = r6.f111003a
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r1 = (cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2) r1
            kotlin.ResultKt.b(r7)
            goto L61
        L25:
            java.lang.Object r1 = r6.f111003a
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r1 = (cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2) r1
            kotlin.ResultKt.b(r7)
            goto L44
        L2d:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r7 = r6.f111005c
            cz.mobilesoft.coreblock.scene.email_consent.ConsentHelper r1 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.V0(r7)
            r6.f111003a = r7
            r6.f111004b = r4
            java.lang.Object r1 = r1.f(r6)
            if (r1 != r0) goto L41
            goto L7b
        L41:
            r5 = r1
            r1 = r7
            r7 = r5
        L44:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L6a
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2 r7 = r6.f111005c
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r7 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.W0(r7)
            kotlinx.coroutines.flow.Flow r7 = r7.h3()
            r6.f111003a = r1
            r6.f111004b = r3
            java.lang.Object r7 = kotlinx.coroutines.flow.FlowKt.D(r7, r6)
            if (r7 != r0) goto L61
            goto L7b
        L61:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L6a
            goto L6b
        L6a:
            r4 = 0
        L6b:
            cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewCommandV2$OnOnboardingSkipped r7 = new cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewCommandV2$OnOnboardingSkipped
            r7.<init>(r4)
            r3 = 0
            r6.f111003a = r3
            r6.f111004b = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2.e1(r1, r7, r6)
            if (r7 != r0) goto L7c
        L7b:
            return r0
        L7c:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.OnboardingViewModelV2$setupPreferences$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((OnboardingViewModelV2$setupPreferences$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
