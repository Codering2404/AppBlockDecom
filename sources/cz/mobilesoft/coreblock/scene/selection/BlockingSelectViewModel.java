package cz.mobilesoft.coreblock.scene.selection;

import android.app.Application;
import cz.mobilesoft.coreblock.dto.RelationDTO;
import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.enums.Limit;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.usecase.InitApplicationsUseCase;
import cz.mobilesoft.coreblock.util.ProductHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableList;

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
public final class BlockingSelectViewModel extends BaseSelectionViewModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlockingSelectViewModel(Application application, BaseSelectionViewModel.ApplicationWebsiteSelectDTO appsWebsSelectDTO, InitApplicationsUseCase initApplicationsUseCase) {
        super(application, appsWebsSelectDTO, initApplicationsUseCase);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(appsWebsSelectDTO, "appsWebsSelectDTO");
        Intrinsics.checkNotNullParameter(initApplicationsUseCase, "initApplicationsUseCase");
    }

    public static final /* synthetic */ BaseSelectionViewState Q2(BlockingSelectViewModel blockingSelectViewModel) {
        return (BaseSelectionViewState) blockingSelectViewModel.I0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ImmutableList Y2() {
        RelationDTO relationDTO;
        ArrayList arrayListG;
        BaseSelectionViewState baseSelectionViewState = (BaseSelectionViewState) I0();
        BaseSelectionViewState.ApplicationViewState applicationViewStateC = baseSelectionViewState.c();
        Collection collectionValues = applicationViewStateC.d().values();
        ArrayList arrayList = new ArrayList();
        Iterator it = collectionValues.iterator();
        while (true) {
            String strA = null;
            if (!it.hasNext()) {
                break;
            }
            ApplicationStateDTO applicationStateDTO = (ApplicationStateDTO) it.next();
            boolean z2 = true;
            if (applicationViewStateC.f().contains(applicationStateDTO.c().f()) && ((arrayListG = applicationViewStateC.g()) == null || !arrayListG.contains(applicationStateDTO.c().f()))) {
                z2 = false;
            }
            if (applicationStateDTO.c().h() && z2 && (relationDTO = (RelationDTO) baseSelectionViewState.p().g().get(applicationStateDTO.c().f())) != null) {
                strA = relationDTO.a();
            }
            if (strA != null) {
                arrayList.add(strA);
            }
        }
        Collection<WebsiteStateDTO> collectionValues2 = baseSelectionViewState.p().l().values();
        ArrayList arrayList2 = new ArrayList();
        for (WebsiteStateDTO websiteStateDTO : collectionValues2) {
            WebsiteDTO websiteDTOC = (websiteStateDTO.e() || !arrayList.contains(websiteStateDTO.c().a())) ? null : websiteStateDTO.c();
            if (websiteDTOC != null) {
                arrayList2.add(websiteDTOC);
            }
        }
        return ExtensionsKt.h(arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        if (P0(r5, r0) == r1) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        if (P0(r4, r0) == r1) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object Z2(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 207
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel.Z2(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0120 -> B:32:0x0123). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a3(java.util.List r19, kotlin.coroutines.Continuation r20) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.selection.BlockingSelectViewModel.a3(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState b3(List list, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, null, ExtensionsKt.h(list), null, null, null, BaseSelectionViewState.BottomSheetType.BrowsersForWebAllowlist, null, null, null, null, false, 8055, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c3(final ImmutableList immutableList, List list, boolean z2) {
        Product productF2 = f2();
        if (productF2 == Product.APPLICATIONS) {
            productF2 = null;
        }
        if (productF2 == null) {
            productF2 = Product.WEBSITES;
        }
        Limit limit = d2().getLimit();
        int limitValue = limit != null ? limit.getLimitValue() : ProductHelper.a(productF2);
        boolean zF = ((BaseSelectionViewState) I0()).k().f(productF2);
        if (immutableList.isEmpty() || z2) {
            return false;
        }
        if (immutableList.size() + list.size() > limitValue && !zF) {
            return false;
        }
        Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.selection.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BlockingSelectViewModel.d3(immutableList, (BaseSelectionViewState) obj);
            }
        });
        G0(new BlockingSelectViewModel$tryShowWebsitesForSelectedAppsBottomSheet$2(this, null));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaseSelectionViewState d3(ImmutableList immutableList, BaseSelectionViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return BaseSelectionViewState.b(updateState, null, null, immutableList, null, null, null, null, BaseSelectionViewState.BottomSheetType.WebsitesForSelectedApps, null, null, null, null, false, 8059, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel
    public void B2(boolean z2) {
        G0(new BlockingSelectViewModel$onSave$1(this, z2, null));
    }
}
