package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.Context;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1", f = "PaywallHostActivity.kt", l = {}, m = "invokeSuspend", v = 1)
final class PaywallHostActivity$CommandProcessor$1$1 extends SuspendLambda implements Function2<PremiumScreenViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f113203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f113204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f113205c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f113206d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f113207f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Context f113208g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f113209h;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$1", f = "PaywallHostActivity.kt", l = {999, 1000}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113210a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f113211b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f113212c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ PremiumScreenViewCommand f113213d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Context f113214f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, ScaffoldState scaffoldState, PremiumScreenViewCommand premiumScreenViewCommand, Context context, Continuation continuation) {
            super(2, continuation);
            this.f113211b = modalBottomSheetState;
            this.f113212c = scaffoldState;
            this.f113213d = premiumScreenViewCommand;
            this.f113214f = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f113211b, this.f113212c, this.f113213d, this.f113214f, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            if (androidx.compose.material.SnackbarHostState.e(r3, r11, null, r6, r10, 2, null) == r0) goto L18;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f113210a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                kotlin.ResultKt.b(r11)
                goto L59
            L12:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1a:
                kotlin.ResultKt.b(r11)
                goto L2c
            L1e:
                kotlin.ResultKt.b(r11)
                androidx.compose.material.ModalBottomSheetState r11 = r10.f113211b
                r10.f113210a = r3
                java.lang.Object r11 = r11.i(r10)
                if (r11 != r0) goto L2c
                goto L58
            L2c:
                androidx.compose.material.ScaffoldState r11 = r10.f113212c
                androidx.compose.material.SnackbarHostState r3 = r11.b()
                cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand r11 = r10.f113213d
                cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand$ShowPurchaseFailed r11 = (cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewCommand.ShowPurchaseFailed) r11
                java.lang.String r11 = r11.a()
                if (r11 != 0) goto L49
                android.content.Context r11 = r10.f113214f
                int r1 = cz.mobilesoft.coreblock.R.string.Vz
                java.lang.String r11 = r11.getString(r1)
                java.lang.String r1 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r1)
            L49:
                r4 = r11
                androidx.compose.material.SnackbarDuration r6 = androidx.compose.material.SnackbarDuration.Short
                r10.f113210a = r2
                r5 = 0
                r8 = 2
                r9 = 0
                r7 = r10
                java.lang.Object r11 = androidx.compose.material.SnackbarHostState.e(r3, r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L59
            L58:
                return r0
            L59:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$2", f = "PaywallHostActivity.kt", l = {1009}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f113216b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
            super(2, continuation);
            this.f113216b = modalBottomSheetState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f113216b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f113215a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ModalBottomSheetState modalBottomSheetState = this.f113216b;
                this.f113215a = 1;
                if (modalBottomSheetState.l(this) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.host.PaywallHostActivity$CommandProcessor$1$1$3", f = "PaywallHostActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f113217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ MutableState f113218b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(MutableState mutableState, Continuation continuation) {
            super(2, continuation);
            this.f113218b = mutableState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f113218b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f113217a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f113218b.setValue(Boxing.a(true));
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallHostActivity$CommandProcessor$1$1(CoroutineScope coroutineScope, ModalBottomSheetState modalBottomSheetState, ScaffoldState scaffoldState, Context context, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f113205c = coroutineScope;
        this.f113206d = modalBottomSheetState;
        this.f113207f = scaffoldState;
        this.f113208g = context;
        this.f113209h = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PaywallHostActivity$CommandProcessor$1$1 paywallHostActivity$CommandProcessor$1$1 = new PaywallHostActivity$CommandProcessor$1$1(this.f113205c, this.f113206d, this.f113207f, this.f113208g, this.f113209h, continuation);
        paywallHostActivity$CommandProcessor$1$1.f113204b = obj;
        return paywallHostActivity$CommandProcessor$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PremiumScreenViewCommand premiumScreenViewCommand, Continuation continuation) {
        return ((PaywallHostActivity$CommandProcessor$1$1) create(premiumScreenViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PremiumScreenViewCommand premiumScreenViewCommand = (PremiumScreenViewCommand) this.f113204b;
        IntrinsicsKt.f();
        if (this.f113203a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (premiumScreenViewCommand instanceof PremiumScreenViewCommand.ShowPurchaseFailed) {
            BuildersKt__Builders_commonKt.d(this.f113205c, null, null, new AnonymousClass1(this.f113206d, this.f113207f, premiumScreenViewCommand, this.f113208g, null), 3, null);
        } else if (Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.ShowOtherOptionsBottomSheet.f112348a)) {
            BuildersKt__Builders_commonKt.d(this.f113205c, null, null, new AnonymousClass2(this.f113206d, null), 3, null);
        } else if (Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.ShowExitPaywallDiscount.f112347a)) {
            BuildersKt__Builders_commonKt.d(this.f113205c, null, null, new AnonymousClass3(this.f113209h, null), 3, null);
        } else {
            if (!Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.FinishGuestPass.f112345a) && !Intrinsics.areEqual(premiumScreenViewCommand, PremiumScreenViewCommand.OpenShare.f112346a)) {
                throw new NoWhenBranchMatchedException();
            }
            Unit unit = Unit.f139807a;
        }
        return Unit.f139807a;
    }
}
