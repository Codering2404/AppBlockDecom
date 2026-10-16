package cz.mobilesoft.coreblock.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.android.material.snackbar.Snackbar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1", f = "DeeplinkRouter.kt", l = {234, 247}, m = "invokeSuspend", v = 1)
final class DeeplinkRouter$handleGuestPass$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f127855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DeeplinkRouter f127856c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f127857d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1$1", f = "DeeplinkRouter.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f127858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f127859b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, Continuation continuation) {
            super(2, continuation);
            this.f127859b = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f127859b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            View viewFindViewById;
            IntrinsicsKt.f();
            if (this.f127858a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Context context = this.f127859b;
            Activity activity = context instanceof Activity ? (Activity) context : null;
            if (activity != null && (viewFindViewById = activity.findViewById(R.id.content)) != null) {
                Snackbar.k0(viewFindViewById, viewFindViewById.getContext().getString(cz.mobilesoft.coreblock.R.string.kf), 0).Y();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeeplinkRouter$handleGuestPass$1(DeeplinkRouter deeplinkRouter, Context context, Continuation continuation) {
        super(2, continuation);
        this.f127856c = deeplinkRouter;
        this.f127857d = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DeeplinkRouter$handleGuestPass$1(this.f127856c, this.f127857d, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r1, r3, r6) == r0) goto L18;
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
            int r1 = r6.f127855b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r6.f127854a
            cz.mobilesoft.coreblock.usecase.GuestPassEligibility r0 = (cz.mobilesoft.coreblock.usecase.GuestPassEligibility) r0
            kotlin.ResultKt.b(r7)
            goto L71
        L16:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1e:
            kotlin.ResultKt.b(r7)
            goto L36
        L22:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.util.DeeplinkRouter r7 = r6.f127856c
            cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase r7 = cz.mobilesoft.coreblock.util.DeeplinkRouter.a(r7)
            cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase$Params r1 = cz.mobilesoft.coreblock.usecase.CheckGuestPassEligibilityUseCase.Params.f127002a
            r6.f127855b = r3
            java.lang.Object r7 = r7.e(r1, r6)
            if (r7 != r0) goto L36
            goto L70
        L36:
            cz.mobilesoft.coreblock.usecase.GuestPassEligibility r7 = (cz.mobilesoft.coreblock.usecase.GuestPassEligibility) r7
            cz.mobilesoft.coreblock.util.analytics.AnswersHelper r1 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
            r1.V1()
            boolean r3 = r7 instanceof cz.mobilesoft.coreblock.usecase.GuestPassEligibility.Eligible
            if (r3 == 0) goto L4f
            android.content.Context r7 = r6.f127857d
            cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity$Companion r0 = cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareActivity.f107428g
            cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario r1 = cz.mobilesoft.coreblock.scene.more.guestpassshare.GuestPassShareFlowScenario.ActivateOnly
            android.content.Intent r0 = r0.a(r7, r1)
            r7.startActivity(r0)
            goto L71
        L4f:
            java.lang.String r3 = r7.a()
            r1.U1(r3)
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1$1 r3 = new cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1$1
            android.content.Context r4 = r6.f127857d
            r5 = 0
            r3.<init>(r4, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r6.f127854a = r7
            r6.f127855b = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r1, r3, r6)
            if (r7 != r0) goto L71
        L70:
            return r0
        L71:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.DeeplinkRouter$handleGuestPass$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DeeplinkRouter$handleGuestPass$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
