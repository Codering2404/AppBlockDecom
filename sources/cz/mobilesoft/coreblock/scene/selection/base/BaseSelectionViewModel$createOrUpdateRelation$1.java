package cz.mobilesoft.coreblock.scene.selection.base;

import cz.mobilesoft.coreblock.dto.ApplicationDTO;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.scene.selection.WebsiteStateDTO;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$createOrUpdateRelation$1", f = "BaseSelectionViewModel.kt", l = {554, 555, 573, 582}, m = "invokeSuspend", v = 1)
final class BaseSelectionViewModel$createOrUpdateRelation$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f118279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f118280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f118281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f118282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseSelectionViewModel f118283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ApplicationDTO f118284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f118285h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseSelectionViewModel$createOrUpdateRelation$1(BaseSelectionViewModel baseSelectionViewModel, ApplicationDTO applicationDTO, String str, Continuation continuation) {
        super(1, continuation);
        this.f118283f = baseSelectionViewModel;
        this.f118284g = applicationDTO;
        this.f118285h = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState q(Map map, RelationDTO relationDTO, String str, BaseSelectionViewState baseSelectionViewState) {
        BaseSelectionViewState.WebsiteKeywordsViewState websiteKeywordsViewStateP = baseSelectionViewState.p();
        Map mutableMap = MapsKt.toMutableMap(baseSelectionViewState.p().l());
        mutableMap.put(relationDTO.a(), new WebsiteStateDTO(new WebsiteDTO(str, WebsiteProfileRelation.BlockingType.DOMAIN, false, false, 12, null), true, false, false, 12, null));
        Unit unit = Unit.f139807a;
        return BaseSelectionViewState.b(baseSelectionViewState, null, null, null, null, BaseSelectionViewState.WebsiteKeywordsViewState.b(websiteKeywordsViewStateP, map, mutableMap, null, null, null, 28, null), null, null, null, null, null, null, null, false, 8175, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseSelectionViewModel$createOrUpdateRelation$1(this.f118283f, this.f118284g, this.f118285h, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00aa, code lost:
    
        if (r2.P0(r5, r7) == r0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ce, code lost:
    
        if (r1.P0(r3, r7) == r0) goto L28;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel$createOrUpdateRelation$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((BaseSelectionViewModel$createOrUpdateRelation$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
