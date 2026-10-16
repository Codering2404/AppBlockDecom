package cz.mobilesoft.coreblock.view.bottomsheet.timeselector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel$startCountingTime$1", f = "BaseTimeSelectorBottomSheetViewModel.kt", l = {36, 37}, m = "invokeSuspend", v = 1)
final class BaseTimeSelectorBottomSheetViewModel$startCountingTime$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f130283a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f130284b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f130285c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseTimeSelectorBottomSheetViewModel f130286d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseTimeSelectorBottomSheetViewModel$startCountingTime$1(BaseTimeSelectorBottomSheetViewModel baseTimeSelectorBottomSheetViewModel, Continuation continuation) {
        super(2, continuation);
        this.f130286d = baseTimeSelectorBottomSheetViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BaseTimeSelectorBottomSheetViewModel$startCountingTime$1 baseTimeSelectorBottomSheetViewModel$startCountingTime$1 = new BaseTimeSelectorBottomSheetViewModel$startCountingTime$1(this.f130286d, continuation);
        baseTimeSelectorBottomSheetViewModel$startCountingTime$1.f130285c = obj;
        return baseTimeSelectorBottomSheetViewModel$startCountingTime$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0058 -> B:11:0x0024). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f130285c
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r9.f130284b
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L21
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L21
        L13:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1b:
            long r5 = r9.f130283a
            kotlin.ResultKt.b(r10)
            goto L4c
        L21:
            kotlin.ResultKt.b(r10)
        L24:
            boolean r10 = kotlinx.coroutines.CoroutineScopeKt.h(r0)
            if (r10 == 0) goto L5b
            long r5 = java.lang.System.currentTimeMillis()
            cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel r10 = r9.f130286d
            long r7 = cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel.J0(r10)
            long r5 = r5 - r7
            cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel r10 = r9.f130286d
            kotlinx.coroutines.flow.MutableStateFlow r10 = r10.L0()
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.e(r5)
            r9.f130285c = r0
            r9.f130283a = r5
            r9.f130284b = r4
            java.lang.Object r10 = r10.emit(r2, r9)
            if (r10 != r1) goto L4c
            goto L5a
        L4c:
            r9.f130285c = r0
            r9.f130283a = r5
            r9.f130284b = r3
            r5 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r5, r9)
            if (r10 != r1) goto L24
        L5a:
            return r1
        L5b:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.BaseTimeSelectorBottomSheetViewModel$startCountingTime$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseTimeSelectorBottomSheetViewModel$startCountingTime$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
