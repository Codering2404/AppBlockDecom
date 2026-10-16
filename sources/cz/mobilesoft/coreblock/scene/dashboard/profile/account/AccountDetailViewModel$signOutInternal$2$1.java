package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$signOutInternal$2$1", f = "AccountDetailViewModel.kt", l = {151, 158}, m = "invokeSuspend", v = 1)
final class AccountDetailViewModel$signOutInternal$2$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f101137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AccountDetailViewModel f101138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f101139d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f101140f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountDetailViewModel$signOutInternal$2$1(boolean z2, AccountDetailViewModel accountDetailViewModel, boolean z3, String str, Continuation continuation) {
        super(1, continuation);
        this.f101137b = z2;
        this.f101138c = accountDetailViewModel;
        this.f101139d = z3;
        this.f101140f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AccountDetailViewState q(AccountDetailViewState accountDetailViewState) {
        return AccountDetailViewState.b(accountDetailViewState, null, null, null, false, false, null, 47, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new AccountDetailViewModel$signOutInternal$2$1(this.f101137b, this.f101138c, this.f101139d, this.f101140f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        if (r6.P0(r1, r5) == r0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0065, code lost:
    
        return r0;
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
            int r1 = r5.f101136a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L17:
            kotlin.ResultKt.b(r6)
            goto L66
        L1b:
            kotlin.ResultKt.b(r6)
            boolean r6 = r5.f101137b
            if (r6 == 0) goto L2f
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r6 = r5.f101138c
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnSignedOut r1 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand.OnSignedOut.f101113a
            r5.f101136a = r3
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.a1(r6, r1, r5)
            if (r6 != r0) goto L66
            goto L65
        L2f:
            boolean r6 = r5.f101139d
            if (r6 == 0) goto L3d
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r6 = r5.f101138c
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.h0 r1 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.h0
            r1.<init>()
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.d1(r6, r1)
        L3d:
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r6 = r5.f101138c
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnApiError r1 = new cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand$OnApiError
            java.lang.String r3 = r5.f101140f
            if (r3 != 0) goto L5a
            cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel r3 = r5.f101138c
            android.content.Context r3 = r3.A0()
            android.content.res.Resources r3 = r3.getResources()
            int r4 = cz.mobilesoft.coreblock.R.string.Fe
            java.lang.String r3 = r3.getString(r4)
            java.lang.String r4 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
        L5a:
            r1.<init>(r3)
            r5.f101136a = r2
            java.lang.Object r6 = cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel.a1(r6, r1, r5)
            if (r6 != r0) goto L66
        L65:
            return r0
        L66:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewModel$signOutInternal$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((AccountDetailViewModel$signOutInternal$2$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
