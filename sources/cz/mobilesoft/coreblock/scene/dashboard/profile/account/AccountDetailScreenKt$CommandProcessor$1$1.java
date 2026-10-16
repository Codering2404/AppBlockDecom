package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarHostState;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt$CommandProcessor$1$1", f = "AccountDetailScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class AccountDetailScreenKt$CommandProcessor$1$1 extends SuspendLambda implements Function2<AccountDetailViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f101092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f101093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function0 f101094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f101095d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f101096f;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt$CommandProcessor$1$1$1", f = "AccountDetailScreen.kt", l = {200}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101097a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f101098b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AccountDetailViewCommand f101099c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ScaffoldState scaffoldState, AccountDetailViewCommand accountDetailViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f101098b = scaffoldState;
            this.f101099c = accountDetailViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f101098b, this.f101099c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101097a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f101098b.b();
                String strA = ((AccountDetailViewCommand.OnApiError) this.f101099c).a();
                this.f101097a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt$CommandProcessor$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt$CommandProcessor$1$1$2", f = "AccountDetailScreen.kt", l = {207}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f101100a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f101101b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AccountDetailViewCommand f101102c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScaffoldState scaffoldState, AccountDetailViewCommand accountDetailViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f101101b = scaffoldState;
            this.f101102c = accountDetailViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f101101b, this.f101102c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f101100a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f101101b.b();
                String strA = ((AccountDetailViewCommand.OnUserProfilePictureUploadedCommand) this.f101102c).a();
                this.f101100a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, strA, null, null, this, 6, null) == objF) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AccountDetailScreenKt$CommandProcessor$1$1(Function0 function0, CoroutineScope coroutineScope, ScaffoldState scaffoldState, Continuation continuation) {
        super(2, continuation);
        this.f101094c = function0;
        this.f101095d = coroutineScope;
        this.f101096f = scaffoldState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        AccountDetailScreenKt$CommandProcessor$1$1 accountDetailScreenKt$CommandProcessor$1$1 = new AccountDetailScreenKt$CommandProcessor$1$1(this.f101094c, this.f101095d, this.f101096f, continuation);
        accountDetailScreenKt$CommandProcessor$1$1.f101093b = obj;
        return accountDetailScreenKt$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(AccountDetailViewCommand accountDetailViewCommand, Continuation continuation) {
        return ((AccountDetailScreenKt$CommandProcessor$1$1) create(accountDetailViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        AccountDetailViewCommand accountDetailViewCommand = (AccountDetailViewCommand) this.f101093b;
        IntrinsicsKt.f();
        if (this.f101092a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (accountDetailViewCommand instanceof AccountDetailViewCommand.OnSignedOut) {
            this.f101094c.invoke();
        } else if (accountDetailViewCommand instanceof AccountDetailViewCommand.OnApiError) {
            BuildersKt__Builders_commonKt.d(this.f101095d, null, null, new AnonymousClass1(this.f101096f, accountDetailViewCommand, null), 3, null);
        } else if (accountDetailViewCommand instanceof AccountDetailViewCommand.OnUserProfilePictureUploadedCommand) {
            BuildersKt__Builders_commonKt.d(this.f101095d, null, null, new AnonymousClass2(this.f101096f, accountDetailViewCommand, null), 3, null);
        } else {
            if (!(accountDetailViewCommand instanceof AccountDetailViewCommand.OnUserUpdated)) {
                throw new NoWhenBranchMatchedException();
            }
            this.f101094c.invoke();
        }
        return Unit.f139807a;
    }
}
