package cz.mobilesoft.coreblock.scene.statistics.ignorelist;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public final class IgnoreListDefaultFragmentViewModel extends BaseIgnoreListFragmentViewModel {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final MutableLiveData f119991k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IgnoreListDefaultFragmentViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f119991k = new MutableLiveData(S0());
    }

    private final List S0() {
        return (List) BuildersKt__BuildersKt.b(null, new IgnoreListDefaultFragmentViewModel$getIgnoredStatisticsItems$1(this, null), 1, null);
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel
    public LiveData L0() {
        return this.f119991k;
    }

    @Override // cz.mobilesoft.coreblock.scene.statistics.ignorelist.BaseIgnoreListFragmentViewModel
    public void R0() {
        this.f119991k.n(S0());
    }

    public final void T0() {
        BuildersKt__Builders_commonKt.d(C0(), null, null, new IgnoreListDefaultFragmentViewModel$restoreAllDefaultStatisticsItems$1(this, null), 3, null);
    }
}
