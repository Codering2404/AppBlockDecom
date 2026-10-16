package cz.mobilesoft.coreblock.scene.selection.base;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$addWebsiteOrKeyword$1$3", f = "BaseSelectionViewModel.kt", l = {740, 744}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$addWebsiteOrKeyword$1$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f118270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebsiteProfileRelation.BlockingType f118272c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$addWebsiteOrKeyword$1$3(BaseSelectionViewModel baseSelectionViewModel, WebsiteProfileRelation.BlockingType blockingType, Continuation continuation) {
        super(1, continuation);
        this.f118271b = baseSelectionViewModel;
        this.f118272c = blockingType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$addWebsiteOrKeyword$1$3(this.f118271b, this.f118272c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0062, code lost:
    
        if (r7.P0(r1, r6) == r0) goto L25;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f118270a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L65
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L3c
        L1e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118271b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ScrollListToTop r1 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ScrollListToTop
            cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation$BlockingType r4 = r6.f118272c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation$BlockingType r5 = cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation.BlockingType.DOMAIN
            if (r4 != r5) goto L2e
            cz.mobilesoft.coreblock.scene.selection.components.TabItem r4 = cz.mobilesoft.coreblock.scene.selection.components.TabItem.Webs
            goto L30
        L2e:
            cz.mobilesoft.coreblock.scene.selection.components.TabItem r4 = cz.mobilesoft.coreblock.scene.selection.components.TabItem.Keywords
        L30:
            r1.<init>(r4)
            r6.f118270a = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r7, r1, r6)
            if (r7 != r0) goto L3c
            goto L64
        L3c:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118271b
            boolean r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.k1(r7)
            if (r7 != 0) goto L65
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118271b
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ShowPremiumFeatureDialog r1 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$ShowPremiumFeatureDialog
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r3 = r6.f118271b
            cz.mobilesoft.coreblock.enums.PremiumFeature r3 = r3.d2()
            cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation$BlockingType r4 = r6.f118272c
            cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation$BlockingType r5 = cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation.BlockingType.DOMAIN
            if (r4 != r5) goto L57
            java.lang.String r4 = "unlimited_websites"
            goto L59
        L57:
            java.lang.String r4 = "unlimited_keywords"
        L59:
            r1.<init>(r3, r4)
            r6.f118270a = r2
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r7, r1, r6)
            if (r7 != r0) goto L65
        L64:
            return r0
        L65:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$addWebsiteOrKeyword$1$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$addWebsiteOrKeyword$1$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
