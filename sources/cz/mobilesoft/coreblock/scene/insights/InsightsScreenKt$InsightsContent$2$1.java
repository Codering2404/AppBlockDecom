package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenKt$InsightsContent$2$1", f = "InsightsScreen.kt", l = {313}, m = "invokeSuspend", v = 1)
final class InsightsScreenKt$InsightsContent$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f102656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f102657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LazyListState f102658d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsScreenKt$InsightsContent$2$1(MutableState mutableState, LazyListState lazyListState, Continuation continuation) {
        super(2, continuation);
        this.f102657c = mutableState;
        this.f102658d = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InsightsScreenKt$InsightsContent$2$1(this.f102657c, this.f102658d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        InsightsScreenKt$InsightsContent$2$1 insightsScreenKt$InsightsContent$2$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102656b;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!((Boolean) this.f102657c.getValue()).booleanValue()) {
                return Unit.f139807a;
            }
            int iE = this.f102658d.y().e();
            if (iE > 0) {
                this.f102655a = iE;
                this.f102656b = 1;
                insightsScreenKt$InsightsContent$2$1 = this;
                if (LazyListState.l(this.f102658d, iE - 1, 0, insightsScreenKt$InsightsContent$2$1, 2, null) == objF) {
                    return objF;
                }
            }
            insightsScreenKt$InsightsContent$2$1.f102657c.setValue(Boxing.a(false));
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        insightsScreenKt$InsightsContent$2$1 = this;
        insightsScreenKt$InsightsContent$2$1.f102657c.setValue(Boxing.a(false));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InsightsScreenKt$InsightsContent$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
