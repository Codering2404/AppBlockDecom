package cz.mobilesoft.coreblock.scene.selection.base;

import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$updateWebsiteOrKeyword$1$1", f = "BaseSelectionViewModel.kt", l = {615, 616, 617}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$updateWebsiteOrKeyword$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f118361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RelationDTO f118362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118363d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewState f118364f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ WebsiteDTO f118365g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f118366h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ boolean f118367i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$updateWebsiteOrKeyword$1$1(RelationDTO relationDTO, BaseSelectionViewModel baseSelectionViewModel, BaseSelectionViewState baseSelectionViewState, WebsiteDTO websiteDTO, String str, boolean z2, Continuation continuation) {
        super(1, continuation);
        this.f118362c = relationDTO;
        this.f118363d = baseSelectionViewModel;
        this.f118364f = baseSelectionViewState;
        this.f118365g = websiteDTO;
        this.f118366h = str;
        this.f118367i = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable A(WebsiteStateDTO websiteStateDTO) {
        return Boolean.valueOf(!websiteStateDTO.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable G(WebsiteStateDTO websiteStateDTO) {
        return websiteStateDTO.c().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState z(Map map, WebsiteDTO websiteDTO, String str, boolean z2, BaseSelectionViewState baseSelectionViewState) {
        BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = baseSelectionViewState.p();
        Map mutableMap = MapsKt.toMutableMap(baseSelectionViewState.p().l());
        mutableMap.remove(websiteDTO.a());
        mutableMap.put(str, new WebsiteStateDTO(new WebsiteDTO(str, websiteDTO.c(), z2, false, 8, null), true, false, false, 12, null));
        Unit unit = Unit.f139807a;
        List listSortedWith = CollectionsKt.sortedWith(mutableMap.values(), ComparisonsKt.b(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.v3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseSelectionViewModel$updateWebsiteOrKeyword$1$1.A((WebsiteStateDTO) obj);
            }
        }, new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.base.w3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BaseSelectionViewModel$updateWebsiteOrKeyword$1$1.G((WebsiteStateDTO) obj);
            }
        }));
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10)), 16));
        for (Object obj : listSortedWith) {
            linkedHashMap.put(((WebsiteStateDTO) obj).c().a(), obj);
        }
        return BaseSelectionViewState.b(baseSelectionViewState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, map, linkedHashMap, null, null, null, 28, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$updateWebsiteOrKeyword$1$1(this.f118362c, this.f118363d, this.f118364f, this.f118365g, this.f118366h, this.f118367i, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067 A[PHI: r7
      0x0067: PHI (r7v9 java.lang.Object) = (r7v8 java.lang.Object), (r7v0 java.lang.Object) binds: [B:18:0x0064, B:10:0x0022] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f118361b
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L2a
            if (r1 == r4) goto L26
            if (r1 == r3) goto L22
            if (r1 != r2) goto L1a
            java.lang.Object r0 = r6.f118360a
            java.util.Map r0 = (java.util.Map) r0
            kotlin.ResultKt.b(r7)
            goto L89
        L1a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L22:
            kotlin.ResultKt.b(r7)
            goto L67
        L26:
            kotlin.ResultKt.b(r7)
            goto L4c
        L2a:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.dto.RelationDTO r7 = r6.f118362c
            if (r7 == 0) goto L7f
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118363d
            cz.mobilesoft.coreblock.storage.room.dao.blocking.AppWebsiteCategoryDao r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.j1(r7)
            cz.mobilesoft.coreblock.dto.RelationDTO r1 = r6.f118362c
            java.lang.String r1 = r1.b()
            cz.mobilesoft.coreblock.dto.RelationDTO r5 = r6.f118362c
            java.lang.String r5 = r5.a()
            r6.f118361b = r4
            java.lang.Object r7 = r7.J(r1, r5, r6)
            if (r7 != r0) goto L4c
            goto L7c
        L4c:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118363d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.i1(r7)
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$ApplicationViewState r1 = r1.c()
            java.util.Map r1 = r1.d()
            java.util.Collection r1 = r1.values()
            r6.f118361b = r3
            java.lang.Object r7 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.x1(r7, r1, r6)
            if (r7 != r0) goto L67
            goto L7c
        L67:
            java.util.Map r7 = (java.util.Map) r7
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r1 = r6.f118363d
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$NavigateToTab r3 = new cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewCommand$NavigateToTab
            cz.mobilesoft.coreblock.scene.selection.components.TabItem r4 = cz.mobilesoft.coreblock.scene.selection.components.TabItem.Webs
            r3.<init>(r4)
            r6.f118360a = r7
            r6.f118361b = r2
            java.lang.Object r1 = cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.C1(r1, r3, r6)
            if (r1 != r0) goto L7d
        L7c:
            return r0
        L7d:
            r0 = r7
            goto L89
        L7f:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState r7 = r6.f118364f
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState$WebsiteKeywordsViewState r7 = r7.p()
            java.util.Map r0 = r7.g()
        L89:
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel r7 = r6.f118363d
            cz.mobilesoft.coreblock.dto.WebsiteDTO r1 = r6.f118365g
            java.lang.String r2 = r6.f118366h
            boolean r3 = r6.f118367i
            cz.mobilesoft.coreblock.scene.selection.base.u3 r4 = new cz.mobilesoft.coreblock.scene.selection.base.u3
            r4.<init>()
            cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel.F1(r7, r4)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$updateWebsiteOrKeyword$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$updateWebsiteOrKeyword$1$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
