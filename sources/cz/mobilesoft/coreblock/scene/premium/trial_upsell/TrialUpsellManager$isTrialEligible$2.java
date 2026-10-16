package cz.mobilesoft.coreblock.scene.premium.trial_upsell;

import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager$isTrialEligible$2", f = "TrialUpsellManager.kt", l = {55, 57, 58}, m = "invokeSuspend", v = 1)
final class TrialUpsellManager$isTrialEligible$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    boolean f113968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f113969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f113970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f113971d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ TrialUpsellManager f113972f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager$isTrialEligible$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager$isTrialEligible$2$1", f = "TrialUpsellManager.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, PremiumState, Continuation<? super Pair<? extends Boolean, ? extends PremiumState>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ boolean f113974b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        /* synthetic */ Object f113975c;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        public final Object h(boolean z2, PremiumState premiumState, Continuation continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.f113974b = z2;
            anonymousClass1.f113975c = premiumState;
            return anonymousClass1.invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h(((Boolean) obj).booleanValue(), (PremiumState) obj2, (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            boolean z2 = this.f113974b;
            PremiumState premiumState = (PremiumState) this.f113975c;
            IntrinsicsKt.f();
            if (this.f113973a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return TuplesKt.a(Boxing.a(z2), premiumState);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TrialUpsellManager$isTrialEligible$2(TrialUpsellManager trialUpsellManager, Continuation continuation) {
        super(2, continuation);
        this.f113972f = trialUpsellManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new TrialUpsellManager$isTrialEligible$2(this.f113972f, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b9  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.trial_upsell.TrialUpsellManager$isTrialEligible$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((TrialUpsellManager$isTrialEligible$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
