package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1", f = "ComposeSwipeableTimePicker.kt", l = {380, 384}, m = "invokeSuspend", v = 1)
final class ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f132978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f132979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f132980d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f132981f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1(LazyListState lazyListState, int i3, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f132978b = lazyListState;
        this.f132979c = i3;
        this.f132980d = mutableState;
        this.f132981f = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1(this.f132978b, this.f132979c, this.f132980d, this.f132981f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(10, r10) != r0) goto L21;
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
            int r1 = r10.f132977a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            r7 = r10
            goto L55
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.b(r11)
            goto L49
        L1f:
            kotlin.ResultKt.b(r11)
            androidx.compose.runtime.MutableState r11 = r10.f132980d
            boolean r11 = cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt.g0(r11)
            if (r11 == 0) goto L5b
            androidx.compose.runtime.MutableState r11 = r10.f132981f
            r1 = 0
            cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt.f0(r11, r1)
            androidx.compose.foundation.lazy.LazyListState r11 = r10.f132978b
            boolean r11 = r11.c()
            if (r11 != 0) goto L49
            androidx.compose.foundation.lazy.LazyListState r4 = r10.f132978b
            int r5 = r10.f132979c
            r10.f132977a = r3
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r10
            java.lang.Object r11 = androidx.compose.foundation.lazy.LazyListState.K(r4, r5, r6, r7, r8, r9)
            if (r11 != r0) goto L4a
            goto L54
        L49:
            r7 = r10
        L4a:
            r7.f132977a = r2
            r1 = 10
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.b(r1, r10)
            if (r11 != r0) goto L55
        L54:
            return r0
        L55:
            androidx.compose.runtime.MutableState r11 = r7.f132981f
            cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt.f0(r11, r3)
            goto L5c
        L5b:
            r7 = r10
        L5c:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeSwipeableTimePickerKt$SwipeLazyColumn$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
