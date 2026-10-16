package cz.mobilesoft.coreblock.scene.password;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel;
import cz.mobilesoft.coreblock.scene.password.PassCodeViewEvent;
import cz.mobilesoft.coreblock.util.CodeClickHelper;
import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class BasePassCodeViewModel extends BaseStatefulViewModel<PassCodeViewState, PassCodeViewEvent, PassCodeViewCommand> {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Companion f111630r = new Companion(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f111631s = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f111632o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private Job f111633p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final CodeClickHelper f111634q;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BasePassCodeViewModel(Application application, PassCodeStep initialStep) {
        super(application, new PassCodeViewState(initialStep, null, null, false, 0, 0L, null, 126, null));
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(initialStep, "initialStep");
        this.f111634q = new CodeClickHelper();
    }

    public static final /* synthetic */ PassCodeViewState U0(BasePassCodeViewModel basePassCodeViewModel) {
        return (PassCodeViewState) basePassCodeViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object d1(final boolean r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$failureDelayWithShake$1
            if (r0 == 0) goto L13
            r0 = r6
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$failureDelayWithShake$1 r0 = (cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$failureDelayWithShake$1) r0
            int r1 = r0.f111638d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f111638d = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$failureDelayWithShake$1 r0 = new cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$failureDelayWithShake$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f111636b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f111638d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            boolean r5 = r0.f111635a
            kotlin.ResultKt.b(r6)
            goto L4d
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            kotlin.ResultKt.b(r6)
            r4.f111632o = r3
            cz.mobilesoft.coreblock.scene.password.a r6 = new cz.mobilesoft.coreblock.scene.password.a
            r6.<init>()
            r4.Q0(r6)
            r0.f111635a = r5
            r0.f111638d = r3
            r2 = 800(0x320, double:3.953E-321)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r2, r0)
            if (r6 != r1) goto L4d
            return r1
        L4d:
            cz.mobilesoft.coreblock.scene.password.b r6 = new cz.mobilesoft.coreblock.scene.password.b
            r6.<init>()
            r4.Q0(r6)
            r5 = 0
            r4.f111632o = r5
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.d1(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object e1(BasePassCodeViewModel basePassCodeViewModel, boolean z2, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: failureDelayWithShake");
        }
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        return basePassCodeViewModel.d1(z2, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState f1(PassCodeViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PassCodeViewState.b(updateState, null, null, null, true, 0, 0L, null, 119, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PassCodeViewState g1(boolean z2, PassCodeViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return PassCodeViewState.b(updateState, null, z2 ? "" : updateState.e(), null, false, 0, 0L, null, 117, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BasePassCodeViewModel$handleFailedAttempts$1(this, null), 3, null);
    }

    private final void l1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BasePassCodeViewModel$onBackspaceClicked$1(this, null), 3, null);
    }

    private final void m1() {
        this.f111634q.a(new Function0() { // from class: cz.mobilesoft.coreblock.scene.password.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return BasePassCodeViewModel.n1(this.f111700a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(BasePassCodeViewModel basePassCodeViewModel) {
        BuildersKt__Builders_commonKt.d(basePassCodeViewModel.C0(), null, null, new BasePassCodeViewModel$onCodeClicked$1$1(basePassCodeViewModel, null), 3, null);
        return Unit.f139807a;
    }

    private final void o1() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BasePassCodeViewModel$onContinueClicked$1(this, null), 3, null);
    }

    private final void q1(int i3) {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BasePassCodeViewModel$onNumberClicked$1(this, i3, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v1(long j3) {
        Flow flowA = TimeHelperExt.f128663a.a(j3, 1000L);
        Job job = this.f111633p;
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
        this.f111633p = FlowKt.Q(FlowKt.V(FlowKt.g(flowA), new BasePassCodeViewModel$startCountdownUntil$1(this, null)), B0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object w1(kotlin.coroutines.Continuation r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$successDelay$1
            if (r0 == 0) goto L13
            r0 = r5
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$successDelay$1 r0 = (cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$successDelay$1) r0
            int r1 = r0.f111664c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f111664c = r1
            goto L18
        L13:
            cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$successDelay$1 r0 = new cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel$successDelay$1
            r0.<init>(r4, r5)
        L18:
            java.lang.Object r5 = r0.f111662a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f111664c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r5)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L31:
            kotlin.ResultKt.b(r5)
            r4.f111632o = r3
            r0.f111664c = r3
            r2 = 200(0xc8, double:9.9E-322)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.b(r2, r0)
            if (r5 != r1) goto L41
            return r1
        L41:
            r5 = 0
            r4.f111632o = r5
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.password.BasePassCodeViewModel.w1(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract Flow h1();

    public abstract Flow i1();

    public abstract Object k1(String str, Continuation continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cz.mobilesoft.coreblock.base.viewmodel.BaseStatefulViewModel
    /* JADX INFO: renamed from: p1, reason: merged with bridge method [inline-methods] */
    public void O0(PassCodeViewEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof PassCodeViewEvent.OnNumberClicked) {
            q1(((PassCodeViewEvent.OnNumberClicked) event).a());
            return;
        }
        if (event instanceof PassCodeViewEvent.OnBackspaceClicked) {
            l1();
        } else if (event instanceof PassCodeViewEvent.OnContinueClicked) {
            o1();
        } else {
            if (!(event instanceof PassCodeViewEvent.OnLogoClicked)) {
                throw new NoWhenBranchMatchedException();
            }
            m1();
        }
    }

    protected void r1() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new BasePassCodeViewModel$onViewModelInitialized$1(this, null), 3, null);
    }

    public abstract Object s1(long j3, Continuation continuation);

    public abstract Object t1(int i3, Continuation continuation);

    public abstract Object u1(String str, Continuation continuation);
}
