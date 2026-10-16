package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import android.net.Uri;
import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState;
import cz.mobilesoft.coreblock.usecase.UpdateUserPhotoUseCase;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1", f = "AccountDetailViewModel.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN}, m = "invokeSuspend", v = 1)
final class AccountDetailViewModel$updateUserProfilePicture$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f101154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f101155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f101156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AccountDetailViewState f101157d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AccountDetailViewModel f101158f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountDetailViewModel f101159a;

        AnonymousClass1(AccountDetailViewModel accountDetailViewModel) {
            this.f101159a = accountDetailViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AccountDetailViewState g(AccountDetailViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return AccountDetailViewState.b(updateState, null, null, Loading.f127895a, false, false, null, 59, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AccountDetailViewState h(AccountDetailViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return AccountDetailViewState.b(updateState, null, null, Success.f128020a, false, false, null, 59, null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
        
            if (r8.P0(r2, r0) != r1) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00b2, code lost:
        
            if (r8.P0(r2, r0) == r1) goto L33;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object emit(cz.mobilesoft.coreblock.util.DataState r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r8
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1$emit$1 r0 = (cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1$emit$1) r0
                int r1 = r0.f101163d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f101163d = r1
                goto L18
            L13:
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1$emit$1 r0 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1$1$emit$1
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f101161b
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f101163d
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L4c
                if (r2 == r5) goto L44
                if (r2 == r4) goto L3c
                if (r2 != r3) goto L34
                java.lang.Object r7 = r0.f101160a
                cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
                kotlin.ResultKt.b(r8)
                goto Lb5
            L34:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3c:
                java.lang.Object r7 = r0.f101160a
                cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
                kotlin.ResultKt.b(r8)
                goto L7c
            L44:
                java.lang.Object r7 = r0.f101160a
                cz.mobilesoft.coreblock.util.DataState r7 = (cz.mobilesoft.coreblock.util.DataState) r7
                kotlin.ResultKt.b(r8)
                goto L69
            L4c:
                kotlin.ResultKt.b(r8)
                boolean r8 = r7 instanceof cz.mobilesoft.coreblock.util.DataState.Success
                if (r8 == 0) goto L7f
                cz.mobilesoft.coreblock.util.analytics.AnswersHelper r8 = cz.mobilesoft.coreblock.util.analytics.AnswersHelper.f128199a
                r8.C8()
                cz.mobilesoft.coreblock.util.SessionManager r8 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
                java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                r0.f101160a = r2
                r0.f101163d = r5
                java.lang.Object r8 = r8.D(r0)
                if (r8 != r1) goto L69
                goto Lb4
            L69:
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r8 = r6.f101159a
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnUserUpdated r2 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand.OnUserUpdated.f101115a
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                r0.f101160a = r7
                r0.f101163d = r4
                java.lang.Object r7 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.a1(r8, r2, r0)
                if (r7 != r1) goto L7c
                goto Lb4
            L7c:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            L7f:
                boolean r8 = r7 instanceof cz.mobilesoft.coreblock.util.DataState.Loading
                if (r8 == 0) goto L8e
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r7 = r6.f101159a
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.k0 r8 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.k0
                r8.<init>()
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.d1(r7, r8)
                goto Lbf
            L8e:
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r8 = r6.f101159a
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnUserProfilePictureUploadedCommand r2 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnUserProfilePictureUploadedCommand
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r4 = r6.f101159a
                android.content.Context r4 = r4.A0()
                int r5 = cz.mobilesoft.coreblock.R.string.IC
                java.lang.String r4 = r4.getString(r5)
                java.lang.String r5 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                r2.<init>(r4)
                java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
                r0.f101160a = r7
                r0.f101163d = r3
                java.lang.Object r7 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.a1(r8, r2, r0)
                if (r7 != r1) goto Lb5
            Lb4:
                return r1
            Lb5:
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r7 = r6.f101159a
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.l0 r8 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.l0
                r8.<init>()
                cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.d1(r7, r8)
            Lbf:
                kotlin.Unit r7 = kotlin.Unit.f139807a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserProfilePicture$1.AnonymousClass1.emit(cz.mobilesoft.coreblock.util.DataState, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountDetailViewModel$updateUserProfilePicture$1(AccountDetailViewState accountDetailViewState, AccountDetailViewModel accountDetailViewModel, Continuation continuation) {
        super(1, continuation);
        this.f101157d = accountDetailViewState;
        this.f101158f = accountDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AccountDetailViewModel$updateUserProfilePicture$1(this.f101157d, this.f101158f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f101156c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Uri uriB = this.f101157d.e() instanceof AccountDetailViewState.ProfileImageState.Local ? ((AccountDetailViewState.ProfileImageState.Local) this.f101157d.e()).b() : null;
            String strD = this.f101157d.d();
            String string = strD != null ? StringsKt.t1(strD).toString() : null;
            Flow flowC = this.f101158f.g1().c(new UpdateUserPhotoUseCase.Params(uriB, string == null ? "" : string));
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f101158f);
            this.f101154a = SpillingKt.a(uriB);
            this.f101155b = SpillingKt.a(string);
            this.f101156c = 1;
            if (flowC.collect(anonymousClass1, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AccountDetailViewModel$updateUserProfilePicture$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
