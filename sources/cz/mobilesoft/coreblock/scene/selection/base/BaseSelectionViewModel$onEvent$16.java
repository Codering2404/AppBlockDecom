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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$onEvent$16", f = "BaseSelectionViewModel.kt", l = {466, 468}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$onEvent$16 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f118304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f118305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118306d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewEvent f118307f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$onEvent$16(BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewEvent baseSelectionViewEvent, Continuation continuation) {
        super(1, continuation);
        this.f118306d = baseSelectionViewModel;
        this.f118307f = baseSelectionViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$onEvent$16(this.f118306d, this.f118307f, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x008a, code lost:
    
        if (r3.P0(r4, r9) == r0) goto L15;
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
            int r1 = r9.f118305c
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r9.f118304b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r9.f118303a
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.b(r10)
            goto L8d
        L1a:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L22:
            kotlin.ResultKt.b(r10)
            goto L42
        L26:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r10 = r9.f118306d
            cz.mobilesoft.coreblock.storage.room.dao.blocking.ApplicationDao r10 = r10.T1()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent r1 = r9.f118307f
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent$BlockingSelectViewEvent$OnBrowsersForWebAllowlistClicked r1 = (cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewEvent.BlockingSelectViewEvent.OnBrowsersForWebAllowlistClicked) r1
            java.util.List r1 = r1.a()
            java.util.Collection r1 = (java.util.Collection) r1
            r9.f118305c = r3
            java.lang.Object r10 = r10.a0(r1, r9)
            if (r10 != r0) goto L42
            goto L8c
        L42:
            java.util.List r10 = (java.util.List) r10
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r1 = r9.f118306d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.i1(r1)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$WebsiteKeywordsViewState r1 = r1.p()
            java.util.List r1 = r1.h()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r3 = r9.f118306d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$CloseWithSelectedAppsAndWebsites r4 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$CloseWithSelectedAppsAndWebsites
            java.util.ArrayList r5 = new java.util.ArrayList
            r6 = r10
            java.util.Collection r6 = (java.util.Collection) r6
            r5.<init>(r6)
            java.util.ArrayList r6 = new java.util.ArrayList
            r7 = r1
            java.util.Collection r7 = (java.util.Collection) r7
            r6.<init>(r7)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r9.f118306d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.i1(r7)
            java.util.List r7 = r7.n()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r4.<init>(r5, r6, r7, r8)
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)
            r9.f118303a = r10
            java.lang.Object r10 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r9.f118304b = r10
            r9.f118305c = r2
            java.lang.Object r10 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r3, r4, r9)
            if (r10 != r0) goto L8d
        L8c:
            return r0
        L8d:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$onEvent$16.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$onEvent$16) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
