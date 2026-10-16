package cz.mobilesoft.coreblock.scene.strictmode3;

import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeState;
import cz.mobilesoft.coreblock.scene.strictmode3.approval.ApprovalEvent;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.Success;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onAccessMethodConfirmed$1", f = "StrictMode3ViewModel.kt", l = {749, 750, 768}, m = "invokeSuspend", v = 1)
final class StrictMode3ViewModel$onAccessMethodConfirmed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f121287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f121288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f121289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f121290d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ StrictMode3ViewModel f121291f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ StrictModeAccessMethod f121292g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ List f121293h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictMode3ViewModel$onAccessMethodConfirmed$1(StrictMode3ViewModel strictMode3ViewModel, StrictModeAccessMethod strictModeAccessMethod, List list, Continuation continuation) {
        super(2, continuation);
        this.f121291f = strictMode3ViewModel;
        this.f121292g = strictModeAccessMethod;
        this.f121293h = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(StrictMode3ViewModel strictMode3ViewModel, StrictModeAccessMethod strictModeAccessMethod, List list, List list2, StrictModeState strictModeState, final ApprovalEvent approvalEvent) {
        if ((approvalEvent instanceof ApprovalEvent.Success) || (approvalEvent instanceof ApprovalEvent.ReadyToActivate)) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.t3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onAccessMethodConfirmed$1.G((StrictMode3ViewState) obj);
                }
            });
            BuildersKt__Builders_commonKt.d(strictMode3ViewModel.C0(), null, null, new StrictMode3ViewModel$onAccessMethodConfirmed$1$1$2(strictMode3ViewModel, strictModeAccessMethod, list, list2, strictModeState, null), 3, null);
        } else if (Intrinsics.areEqual(approvalEvent, ApprovalEvent.Loading.f121707a)) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.u3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onAccessMethodConfirmed$1.J((StrictMode3ViewState) obj);
                }
            });
        } else if (approvalEvent instanceof ApprovalEvent.Error) {
            strictMode3ViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.v3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ViewModel$onAccessMethodConfirmed$1.K(approvalEvent, (StrictMode3ViewState) obj);
                }
            });
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState G(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Success.f128020a, null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState J(StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, Loading.f127895a, null, null, 0L, 1966079, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StrictMode3ViewState K(ApprovalEvent approvalEvent, StrictMode3ViewState strictMode3ViewState) {
        return StrictMode3ViewState.b(strictMode3ViewState, null, null, null, null, null, null, null, null, null, null, null, null, 0L, false, false, false, null, ((ApprovalEvent.Error) approvalEvent).a(), null, null, 0L, 1966079, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictMode3ViewModel$onAccessMethodConfirmed$1(this.f121291f, this.f121292g, this.f121293h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
    
        if (r1.m(r12, r4, r11) == r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fb, code lost:
    
        if (r5.S1(r6, r7, r8, r9, r11) == r0) goto L43;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel$onAccessMethodConfirmed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictMode3ViewModel$onAccessMethodConfirmed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
