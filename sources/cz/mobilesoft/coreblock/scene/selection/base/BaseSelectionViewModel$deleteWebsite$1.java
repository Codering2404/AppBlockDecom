package cz.mobilesoft.coreblock.scene.selection.base;

import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$deleteWebsite$1", f = "BaseSelectionViewModel.kt", l = {652, 653}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$deleteWebsite$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118286a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebsiteDTO f118288c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$deleteWebsite$1(BaseSelectionViewModel baseSelectionViewModel, WebsiteDTO websiteDTO, Continuation continuation) {
        super(1, continuation);
        this.f118287b = baseSelectionViewModel;
        this.f118288c = websiteDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState q(Map map, WebsiteDTO websiteDTO, BaseSelectionViewState baseSelectionViewState) {
        BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = baseSelectionViewState.p();
        Map mutableMap = MapsKt.toMutableMap(baseSelectionViewState.p().l());
        mutableMap.remove(websiteDTO.a());
        Unit unit = Unit.f139807a;
        return BaseSelectionViewState.b(baseSelectionViewState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, map, mutableMap, null, null, null, 28, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$deleteWebsite$1(this.f118287b, this.f118288c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004a, code lost:
    
        if (r5 == r0) goto L15;
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
            int r1 = r4.f118286a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r5)
            goto L4d
        L12:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L1a:
            kotlin.ResultKt.b(r5)
            goto L32
        L1e:
            kotlin.ResultKt.b(r5)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118287b
            cz.mobilesoft.coreblock.dto.WebsiteDTO r1 = r4.f118288c
            java.lang.String r1 = r1.a()
            r4.f118286a = r3
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.B1(r5, r1, r4)
            if (r5 != r0) goto L32
            goto L4c
        L32:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r5 = r4.f118287b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.i1(r5)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r1 = r1.c()
            java.util.Map r1 = r1.d()
            java.util.Collection r1 = r1.values()
            r4.f118286a = r2
            java.lang.Object r5 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.x1(r5, r1, r4)
            if (r5 != r0) goto L4d
        L4c:
            return r0
        L4d:
            java.util.Map r5 = (java.util.Map) r5
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r0 = r4.f118287b
            cz.mobilesoft.coreblock.dto.WebsiteDTO r1 = r4.f118288c
            cz.mobilesoft.coreblock.scene.selection.base.r3 r2 = new cz.mobilesoft.coreblock.scene.selection.base.r3
            r2.<init>()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.F1(r0, r2)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$deleteWebsite$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$deleteWebsite$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
