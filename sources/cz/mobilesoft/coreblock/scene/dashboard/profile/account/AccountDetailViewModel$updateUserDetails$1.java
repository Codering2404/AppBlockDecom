package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1;
import cz.mobilesoft.coreblock.util.DataState;
import cz.mobilesoft.coreblock.util.Loading;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1", f = "AccountDetailViewModel.kt", l = {227, 232}, m = "invokeSuspend", v = 1)
final class AccountDetailViewModel$updateUserDetails$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f101150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f101151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AccountDetailViewModel f101152c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AccountDetailViewModel f101153a;

        AnonymousClass1(AccountDetailViewModel accountDetailViewModel) {
            this.f101153a = accountDetailViewModel;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AccountDetailViewState g(AccountDetailViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return AccountDetailViewState.b(updateState, null, null, Loading.f127895a, false, false, null, 59, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final AccountDetailViewState h(DataState dataState, AccountDetailViewState updateState) {
            Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
            return AccountDetailViewState.b(updateState, null, null, ((DataState.Error) dataState).d(), false, false, null, 59, null);
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public final Object emit(final DataState dataState, Continuation continuation) {
            if (dataState instanceof DataState.Loading) {
                this.f101153a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailViewModel$updateUserDetails$1.AnonymousClass1.g((AccountDetailViewState) obj);
                    }
                });
                return Unit.f139807a;
            }
            if (dataState instanceof DataState.Success) {
                Object objP0 = this.f101153a.P0(AccountDetailViewCommand.OnUserUpdated.f101115a, continuation);
                return objP0 == IntrinsicsKt.f() ? objP0 : Unit.f139807a;
            }
            if (!(dataState instanceof DataState.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f101153a.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.j0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailViewModel$updateUserDetails$1.AnonymousClass1.h(dataState, (AccountDetailViewState) obj);
                }
            });
            Object objP02 = this.f101153a.P0(new AccountDetailViewCommand.OnApiError(((DataState.Error) dataState).d().d()), continuation);
            return objP02 == IntrinsicsKt.f() ? objP02 : Unit.f139807a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountDetailViewModel$updateUserDetails$1(AccountDetailViewModel accountDetailViewModel, Continuation continuation) {
        super(1, continuation);
        this.f101152c = accountDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AccountDetailViewModel$updateUserDetails$1(this.f101152c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0076, code lost:
    
        if (r1.collect(r3, r5) == r0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008c, code lost:
    
        if (r1.P0(r2, r5) == r0) goto L27;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f101151b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r0 = r5.f101150a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r6)
            goto L79
        L16:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1e:
            java.lang.Object r0 = r5.f101150a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r6)
            goto L8f
        L26:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r6 = r5.f101152c
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState r6 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.V0(r6)
            java.lang.String r6 = r6.d()
            if (r6 == 0) goto L3e
            java.lang.CharSequence r6 = kotlin.text.StringsKt.t1(r6)
            java.lang.String r6 = r6.toString()
            goto L3f
        L3e:
            r6 = 0
        L3f:
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r1 = r5.f101152c
            java.lang.String r1 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.W0(r1)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r6, r1)
            if (r1 != 0) goto L7c
            if (r6 == 0) goto L7c
            boolean r1 = kotlin.text.StringsKt.p0(r6)
            if (r1 == 0) goto L54
            goto L7c
        L54:
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r1 = r5.f101152c
            cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase r1 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.Y0(r1)
            cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase$Params r3 = new cz.mobilesoft.coreblock.usecase.UpdateUserDetailUseCase$Params
            r3.<init>(r6)
            kotlinx.coroutines.flow.Flow r1 = r1.a(r3)
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1$1 r3 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1$1
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r4 = r5.f101152c
            r3.<init>(r4)
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f101150a = r6
            r5.f101151b = r2
            java.lang.Object r6 = r1.collect(r3, r5)
            if (r6 != r0) goto L79
            goto L8e
        L79:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L7c:
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r1 = r5.f101152c
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnUserUpdated r2 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand.OnUserUpdated.f101115a
            java.lang.Object r6 = kotlin.coroutines.jvm.internal.SpillingKt.a(r6)
            r5.f101150a = r6
            r5.f101151b = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.a1(r1, r2, r5)
            if (r6 != r0) goto L8f
        L8e:
            return r0
        L8f:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$updateUserDetails$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AccountDetailViewModel$updateUserDetails$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
