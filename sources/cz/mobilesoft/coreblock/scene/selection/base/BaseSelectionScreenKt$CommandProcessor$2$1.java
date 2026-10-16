package cz.mobilesoft.coreblock.scene.selection.base;

import android.content.Context;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.SnackbarDuration;
import androidx.compose.material.SnackbarHostState;
import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ImmutableList;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1", f = "BaseSelectionScreen.kt", l = {244}, m = "invokeSuspend", v = 1)
final class BaseSelectionScreenKt$CommandProcessor$2$1 extends SuspendLambda implements Function2<BaseSelectionViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118121a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f118122b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagerState f118123c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ TabItem[] f118124d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f118125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ boolean f118126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f118127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ Function4 f118128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final /* synthetic */ MutableState f118129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ Function0 f118130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ MutableState f118131l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f118132m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final /* synthetic */ ScaffoldState f118133n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final /* synthetic */ ImmutableList f118134o;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$1", f = "BaseSelectionScreen.kt", l = {257}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f118135a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ModalBottomSheetState f118136b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ModalBottomSheetState modalBottomSheetState, Continuation continuation) {
            super(2, continuation);
            this.f118136b = modalBottomSheetState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f118136b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f118135a;
            if (i3 == 0) {
                ResultKt.b(obj);
                ModalBottomSheetState modalBottomSheetState = this.f118136b;
                this.f118135a = 1;
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$2", f = "BaseSelectionScreen.kt", l = {268}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f118137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ScaffoldState f118138b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f118139c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ BaseSelectionViewCommand f118140d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ScaffoldState scaffoldState, Context context, BaseSelectionViewCommand baseSelectionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f118138b = scaffoldState;
            this.f118139c = context;
            this.f118140d = baseSelectionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass2(this.f118138b, this.f118139c, this.f118140d, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f118137a;
            if (i3 == 0) {
                ResultKt.b(obj);
                SnackbarHostState snackbarHostStateB = this.f118138b.b();
                String string = this.f118139c.getString(((BaseSelectionViewCommand.BlockingSelectViewCommand.ShowStrictModeSnackBar) this.f118140d).a());
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                SnackbarDuration snackbarDuration = SnackbarDuration.Short;
                this.f118137a = 1;
                if (SnackbarHostState.e(snackbarHostStateB, string, null, snackbarDuration, this, 2, null) == objF) {
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

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1$3", f = "BaseSelectionScreen.kt", l = {276, 278}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f118141a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f118142b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f118143c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f118144d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImmutableList f118145f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ TabItem[] f118146g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ BaseSelectionViewCommand f118147h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(ImmutableList immutableList, TabItem[] tabItemArr, BaseSelectionViewCommand baseSelectionViewCommand, Continuation continuation) {
            super(2, continuation);
            this.f118145f = immutableList;
            this.f118146g = tabItemArr;
            this.f118147h = baseSelectionViewCommand;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass3(this.f118145f, this.f118146g, this.f118147h, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0061, code lost:
        
            if (androidx.compose.foundation.lazy.LazyListState.l(r4, 0, 0, r10, 2, null) == r0) goto L15;
         */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
            /*
                r10 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r10.f118144d
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1e
                if (r1 != r2) goto L16
                java.lang.Object r0 = r10.f118142b
                androidx.compose.foundation.lazy.LazyListState r0 = (androidx.compose.foundation.lazy.LazyListState) r0
                kotlin.ResultKt.b(r11)
                goto L64
            L16:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r0)
                throw r11
            L1e:
                kotlin.ResultKt.b(r11)
                goto L30
            L22:
                kotlin.ResultKt.b(r11)
                r10.f118144d = r3
                r3 = 250(0xfa, double:1.235E-321)
                java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r3, r10)
                if (r11 != r0) goto L30
                goto L63
            L30:
                kotlinx.collections.immutable.ImmutableList r11 = r10.f118145f
                cz.mobilesoft.coreblock.scene.selection.components.TabItem[] r1 = r10.f118146g
                cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand r3 = r10.f118147h
                cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ScrollListToTop r3 = (cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand.ScrollListToTop) r3
                cz.mobilesoft.coreblock.scene.selection.components.TabItem r3 = r3.a()
                int r1 = kotlin.collections.ArraysKt.indexOf(r1, r3)
                r3 = 0
                int r1 = kotlin.ranges.RangesKt.f(r1, r3)
                java.lang.Object r11 = r11.get(r1)
                r4 = r11
                androidx.compose.foundation.lazy.LazyListState r4 = (androidx.compose.foundation.lazy.LazyListState) r4
                r10.f118141a = r11
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
                r10.f118142b = r11
                r10.f118143c = r3
                r10.f118144d = r2
                r5 = 0
                r6 = 0
                r8 = 2
                r9 = 0
                r7 = r10
                java.lang.Object r11 = androidx.compose.foundation.lazy.LazyListState.l(r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L64
            L63:
                return r0
            L64:
                kotlin.Unit r11 = kotlin.Unit.f139807a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt$CommandProcessor$2$1.AnonymousClass3.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionScreenKt$CommandProcessor$2$1(PagerState pagerState, TabItem[] tabItemArr, Context context, boolean z2, CoroutineScope coroutineScope, Function4 function4, MutableState mutableState, Function0 function0, MutableState mutableState2, ModalBottomSheetState modalBottomSheetState, ScaffoldState scaffoldState, ImmutableList immutableList, Continuation continuation) {
        super(2, continuation);
        this.f118123c = pagerState;
        this.f118124d = tabItemArr;
        this.f118125f = context;
        this.f118126g = z2;
        this.f118127h = coroutineScope;
        this.f118128i = function4;
        this.f118129j = mutableState;
        this.f118130k = function0;
        this.f118131l = mutableState2;
        this.f118132m = modalBottomSheetState;
        this.f118133n = scaffoldState;
        this.f118134o = immutableList;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BaseSelectionScreenKt$CommandProcessor$2$1 baseSelectionScreenKt$CommandProcessor$2$1 = new BaseSelectionScreenKt$CommandProcessor$2$1(this.f118123c, this.f118124d, this.f118125f, this.f118126g, this.f118127h, this.f118128i, this.f118129j, this.f118130k, this.f118131l, this.f118132m, this.f118133n, this.f118134o, continuation);
        baseSelectionScreenKt$CommandProcessor$2$1.f118122b = obj;
        return baseSelectionScreenKt$CommandProcessor$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(BaseSelectionViewCommand baseSelectionViewCommand, Continuation continuation) {
        return ((BaseSelectionScreenKt$CommandProcessor$2$1) create(baseSelectionViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        BaseSelectionViewCommand baseSelectionViewCommand = (BaseSelectionViewCommand) this.f118122b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f118121a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (baseSelectionViewCommand instanceof BaseSelectionViewCommand.NavigateToTab) {
                PagerState pagerState = this.f118123c;
                int iF = RangesKt.f(ArraysKt.indexOf(this.f118124d, ((BaseSelectionViewCommand.NavigateToTab) baseSelectionViewCommand).a()), 0);
                this.f118122b = SpillingKt.a(baseSelectionViewCommand);
                this.f118121a = 1;
                if (PagerState.n(pagerState, iF, 0.0f, null, this, 6, null) == objF) {
                    return objF;
                }
            } else if (baseSelectionViewCommand instanceof BaseSelectionViewCommand.ShowPremiumFeatureDialog) {
                BaseSelectionViewCommand.ShowPremiumFeatureDialog showPremiumFeatureDialog = (BaseSelectionViewCommand.ShowPremiumFeatureDialog) baseSelectionViewCommand;
                this.f118125f.startActivity(Paywall.c(Paywall.f113165a, this.f118125f, new PaywallTarget.LimitScreen(showPremiumFeatureDialog.b()), this.f118126g ? "schedule_create" : "schedule_edit", showPremiumFeatureDialog.a(), false, false, false, null, 240, null));
            } else if (Intrinsics.areEqual(baseSelectionViewCommand, BaseSelectionViewCommand.BlockingSelectViewCommand.ShowBottomSheet.f118175a)) {
                BuildersKt__Builders_commonKt.d(this.f118127h, null, null, new AnonymousClass1(this.f118132m, null), 3, null);
            } else if (baseSelectionViewCommand instanceof BaseSelectionViewCommand.CloseWithSelectedAppsAndWebsites) {
                BaseSelectionViewCommand.CloseWithSelectedAppsAndWebsites closeWithSelectedAppsAndWebsites = (BaseSelectionViewCommand.CloseWithSelectedAppsAndWebsites) baseSelectionViewCommand;
                this.f118128i.invoke(closeWithSelectedAppsAndWebsites.a(), closeWithSelectedAppsAndWebsites.d(), closeWithSelectedAppsAndWebsites.b(), closeWithSelectedAppsAndWebsites.c());
            } else if (Intrinsics.areEqual(baseSelectionViewCommand, BaseSelectionViewCommand.BlockingSelectViewCommand.ShowContainsAppBlockErrorDialog.f118176a)) {
                this.f118129j.setValue(Boxing.a(true));
            } else if (baseSelectionViewCommand instanceof BaseSelectionViewCommand.BlockingSelectViewCommand.ShowStrictModeSnackBar) {
                BuildersKt__Builders_commonKt.d(this.f118127h, null, null, new AnonymousClass2(this.f118133n, this.f118125f, baseSelectionViewCommand, null), 3, null);
            } else if (baseSelectionViewCommand instanceof BaseSelectionViewCommand.ScrollListToTop) {
                BuildersKt__Builders_commonKt.d(this.f118127h, null, null, new AnonymousClass3(this.f118134o, this.f118124d, baseSelectionViewCommand, null), 3, null);
            } else if (Intrinsics.areEqual(baseSelectionViewCommand, BaseSelectionViewCommand.Close.f118178a)) {
                this.f118130k.invoke();
            } else {
                if (!Intrinsics.areEqual(baseSelectionViewCommand, BaseSelectionViewCommand.ShowExitConfirmationDialog.f118185a)) {
                    throw new NoWhenBranchMatchedException();
                }
                this.f118131l.setValue(Boxing.a(true));
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }
}
