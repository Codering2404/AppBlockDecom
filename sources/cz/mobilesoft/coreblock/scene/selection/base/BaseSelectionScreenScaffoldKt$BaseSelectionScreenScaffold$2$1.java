package cz.mobilesoft.coreblock.scene.selection.base;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1", f = "BaseSelectionScreenScaffold.kt", l = {113}, m = "invokeSuspend", v = 1)
final class BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagerState f118157b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f118158c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f118159d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f118160f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1(PagerState pagerState, Function1 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f118157b = pagerState;
        this.f118158c = function1;
        this.f118159d = mutableState;
        this.f118160f = mutableState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(PagerState pagerState) {
        return pagerState.v();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1(this.f118157b, this.f118158c, this.f118159d, this.f118160f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f118156a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final PagerState pagerState = this.f118157b;
            Flow flowQ = SnapshotStateKt.q(new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.base.u2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Integer.valueOf(BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1.q(pagerState));
                }
            });
            final Function1 function1 = this.f118158c;
            final MutableState mutableState = this.f118159d;
            final MutableState mutableState2 = this.f118160f;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1.2
                public final Object a(int i4, Continuation continuation) {
                    function1.invoke(new BaseSelectionViewEvent.OnAppSearchStateChanged(false));
                    BaseSelectionScreenScaffoldKt.f0(mutableState, "");
                    BaseSelectionScreenScaffoldKt.h0(mutableState2, "");
                    return Unit.f139807a;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return a(((Number) obj2).intValue(), continuation);
                }
            };
            this.f118156a = 1;
            if (flowQ.collect(flowCollector, this) == objF) {
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
        return ((BaseSelectionScreenScaffoldKt$BaseSelectionScreenScaffold$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
