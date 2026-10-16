package cz.mobilesoft.coreblock.scene.selection.base;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$onEvent$9", f = "BaseSelectionViewModel.kt", l = {411, 413}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$onEvent$9 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118311b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$onEvent$9(BaseSelectionViewModel baseSelectionViewModel, Continuation continuation) {
        super(1, continuation);
        this.f118311b = baseSelectionViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$onEvent$9(this.f118311b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0045, code lost:
    
        if (r5.P0(r1, r4) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f118310a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1b
            if (r1 == r3) goto L17
            if (r1 != r2) goto Lf
            goto L17
        Lf:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L17:
            kotlin.ResultKt.b(r5)
            goto L48
        L1b:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118311b
            boolean r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.z1(r5)
            if (r5 != 0) goto L3b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118311b
            boolean r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.u1(r5)
            if (r5 == 0) goto L3b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118311b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ShowExitConfirmationDialog r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand.ShowExitConfirmationDialog.f118185a
            r4.f118310a = r3
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r5, r1, r4)
            if (r5 != r0) goto L48
            goto L47
        L3b:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118311b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$Close r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand.Close.f118178a
            r4.f118310a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r5, r1, r4)
            if (r5 != r0) goto L48
        L47:
            return r0
        L48:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$onEvent$9.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$onEvent$9) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
