package cz.mobilesoft.coreblock.scene.dashboard;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class DashboardViewModel$collectStatisticsEnabledState$1<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ DashboardViewModel f99375a;

    DashboardViewModel$collectStatisticsEnabledState$1(DashboardViewModel dashboardViewModel) {
        this.f99375a = dashboardViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DashboardViewState f(DashboardViewModel dashboardViewModel, boolean z2, DashboardViewState updateState) {
        Intrinsics.checkNotNullParameter(updateState, "$this$updateState");
        return DashboardViewState.b(updateState, null, null, dashboardViewModel.E1(z2), null, null, false, false, false, null, false, false, false, 4091, null);
    }

    public final Object b(final boolean z2, Continuation continuation) {
        final DashboardViewModel dashboardViewModel = this.f99375a;
        dashboardViewModel.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.a4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DashboardViewModel$collectStatisticsEnabledState$1.f(dashboardViewModel, z2, (DashboardViewState) obj);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
        return b(((Boolean) obj).booleanValue(), continuation);
    }
}
