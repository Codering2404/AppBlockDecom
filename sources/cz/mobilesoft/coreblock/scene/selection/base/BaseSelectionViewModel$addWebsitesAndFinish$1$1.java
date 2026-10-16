package cz.mobilesoft.coreblock.scene.selection.base;

import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$addWebsitesAndFinish$1$1", f = "BaseSelectionViewModel.kt", l = {965, 973}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$addWebsitesAndFinish$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f118274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewState f118276d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ List f118277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f118278g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$addWebsitesAndFinish$1$1(BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewState baseSelectionViewState, List list, List list2, Continuation continuation) {
        super(1, continuation);
        this.f118275c = baseSelectionViewModel;
        this.f118276d = baseSelectionViewState;
        this.f118277f = list;
        this.f118278g = list2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$addWebsitesAndFinish$1$1(this.f118275c, this.f118276d, this.f118277f, this.f118278g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a9, code lost:
    
        if (r1.P0(r3, r9) == r0) goto L24;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f118274b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L23
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r9.f118273a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r10)
            goto Lac
        L17:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1f:
            kotlin.ResultKt.b(r10)
            goto L74
        L23:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r10 = r9.f118275c
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r10 = r10.T1()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r1 = r9.f118276d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r1 = r1.c()
            java.util.Map r1 = r1.d()
            java.util.Collection r1 = r1.values()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r1 = r1.iterator()
        L45:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L6b
            java.lang.Object r5 = r1.next()
            cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO r5 = (cz.mobilesoft.coreblock.scene.selection.ApplicationStateDTO) r5
            cz.mobilesoft.coreblock.dto.ApplicationDTO r6 = r5.c()
            boolean r6 = r6.h()
            if (r6 == 0) goto L64
            cz.mobilesoft.coreblock.dto.ApplicationDTO r5 = r5.c()
            java.lang.String r5 = r5.f()
            goto L65
        L64:
            r5 = 0
        L65:
            if (r5 == 0) goto L45
            r4.add(r5)
            goto L45
        L6b:
            r9.f118274b = r3
            java.lang.Object r10 = r10.a0(r4, r9)
            if (r10 != r0) goto L74
            goto Lab
        L74:
            java.util.List r10 = (java.util.List) r10
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r1 = r9.f118275c
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$CloseWithSelectedAppsAndWebsites r3 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$CloseWithSelectedAppsAndWebsites
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = r10
            java.util.Collection r5 = (java.util.Collection) r5
            r4.<init>(r5)
            java.util.ArrayList r5 = new java.util.ArrayList
            java.util.List r6 = r9.f118277f
            java.util.Collection r6 = (java.util.Collection) r6
            r5.<init>(r6)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r6 = r9.f118276d
            java.util.List r6 = r6.n()
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.List r8 = r9.f118278g
            java.util.Collection r8 = (java.util.Collection) r8
            r7.<init>(r8)
            r3.<init>(r4, r5, r6, r7)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r9.f118273a = r10
            r9.f118274b = r2
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r1, r3, r9)
            if (r10 != r0) goto Lac
        Lab:
            return r0
        Lac:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$addWebsitesAndFinish$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$addWebsitesAndFinish$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
