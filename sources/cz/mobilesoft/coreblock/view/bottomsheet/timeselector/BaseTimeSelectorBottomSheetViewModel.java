package cz.mobilesoft.coreblock.view.bottomsheet.timeselector;

import android.app.Application;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.dto.Pair;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public class BaseTimeSelectorBottomSheetViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Long f130276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Lazy f130277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableStateFlow f130278k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f130279l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f130280m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f130281n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f130282o;

    /* JADX INFO: Access modifiers changed from: private */
    public final long P0() {
        return ((Number) this.f130277j.getValue()).longValue();
    }

    private final void V0() {
        BuildersKt__Builders_commonKt.d(B0(), null, null, new BaseTimeSelectorBottomSheetViewModel$startCountingTime$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long W0() {
        return System.currentTimeMillis();
    }

    public final int K0() {
        return this.f130280m;
    }

    public final MutableStateFlow L0() {
        return this.f130278k;
    }

    public final int M0() {
        return this.f130281n;
    }

    public final Long N0() {
        return this.f130276i;
    }

    public final int O0() {
        return this.f130279l;
    }

    public final boolean Q0() {
        return this.f130282o;
    }

    public final void R0(int i3) {
        this.f130280m = i3;
    }

    public final void S0(boolean z2) {
        this.f130282o = z2;
    }

    public final void T0(int i3) {
        this.f130281n = i3;
    }

    public final void U0(int i3) {
        this.f130279l = i3;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseTimeSelectorBottomSheetViewModel(Application application, Pair initialHoursAndMinutes, boolean z2, Long l3) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(initialHoursAndMinutes, "initialHoursAndMinutes");
        this.f130276i = l3;
        this.f130277j = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.view.bottomsheet.timeselector.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(BaseTimeSelectorBottomSheetViewModel.W0());
            }
        });
        this.f130278k = StateFlowKt.a(0L);
        this.f130282o = z2;
        Object first = initialHoursAndMinutes.f96933a;
        Intrinsics.checkNotNullExpressionValue(first, "first");
        this.f130280m = ((Number) first).intValue();
        Object obj = initialHoursAndMinutes.f96934b;
        Intrinsics.checkNotNullExpressionValue(obj, jTYhJgqLBN.BEtyIAuFCk);
        this.f130281n = ((Number) obj).intValue();
        this.f130279l = 2;
        V0();
    }
}
