package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.DateRangePickerKt$DateRangePickerContent$1$1", f = "DateRangePicker.kt", l = {730}, m = "invokeSuspend")
final class DateRangePickerKt$DateRangePickerContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f17319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f17320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f17321c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DateRangePickerKt$DateRangePickerContent$1$1(LazyListState lazyListState, int i3, Continuation continuation) {
        super(2, continuation);
        this.f17320b = lazyListState;
        this.f17321c = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DateRangePickerKt$DateRangePickerContent$1$1(this.f17320b, this.f17321c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f17319a;
        if (i3 == 0) {
            ResultKt.b(obj);
            int iS = this.f17320b.s();
            int i4 = this.f17321c;
            if (iS != i4) {
                LazyListState lazyListState = this.f17320b;
                this.f17319a = 1;
                if (LazyListState.K(lazyListState, i4, 0, this, 2, null) == objF) {
                    return objF;
                }
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
        return ((DateRangePickerKt$DateRangePickerContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
