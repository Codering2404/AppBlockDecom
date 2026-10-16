package cz.mobilesoft.coreblock.scene.dashboard.profile;

import cz.mobilesoft.coreblock.enums.PremiumState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1", f = "ProfileViewModel.kt", l = {196}, m = "invokeSuspend", v = 1)
final class ProfileViewModel$updateTrialEligibility$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProfileViewModel f101057b;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$1", f = "ProfileViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function3<Boolean, PremiumState, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101058a;

        AnonymousClass1(Continuation continuation) {
            super(3, continuation);
        }

        public final Object h(boolean z2, PremiumState premiumState, Continuation continuation) {
            return new AnonymousClass1(continuation).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h(((Boolean) obj).booleanValue(), (PremiumState) obj2, (Continuation) obj3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f101058a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ProfileViewModel f101059a;

        AnonymousClass2(ProfileViewModel profileViewModel) {
            this.f101059a = profileViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ProfileViewState f(boolean z2, ProfileViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return ProfileViewState.b(updateState, null, null, null, false, false, null, null, null, null, null, false, false, false, null, null, z2, null, null, null, false, 1015807, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(kotlin.Unit r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2$emit$1
                if (r0 == 0) goto L13
                r0 = r6
                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2$emit$1) r0
                int r1 = r0.f101063d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f101063d = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1$2$emit$1
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f101061b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f101063d
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r5 = r0.f101060a
                kotlin.Unit r5 = (kotlin.Unit) r5
                kotlin.ResultKt.b(r6)
                goto L4f
            L2d:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L35:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel r6 = r4.f101059a
                cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase r6 = cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.X0(r6)
                cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase$Params r2 = cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase.Params.f127002a
                java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
                r0.f101060a = r5
                r0.f101063d = r3
                java.lang.Object r6 = r6.e(r2, r0)
                if (r6 != r1) goto L4f
                return r1
            L4f:
                boolean r5 = r6 instanceof cz.mobilesoft.coreblock.usecase.GuestPassEligibility.Eligible
                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel r6 = r4.f101059a
                cz.mobilesoft.coreblock.scene.dashboard.profile.c2 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.c2
                r0.<init>()
                cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel.g1(r6, r0)
                kotlin.Unit r5 = kotlin.Unit.f139807a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileViewModel$updateTrialEligibility$1.AnonymousClass2.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$updateTrialEligibility$1(ProfileViewModel profileViewModel, Continuation continuation) {
        super(2, continuation);
        this.f101057b = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ProfileViewModel$updateTrialEligibility$1(this.f101057b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f101056a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowM = FlowKt.m(this.f101057b.t1().l1(), this.f101057b.v1().K(), new AnonymousClass1(null));
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.f101057b);
            this.f101056a = 1;
            if (flowM.collect(anonymousClass2, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ProfileViewModel$updateTrialEligibility$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
