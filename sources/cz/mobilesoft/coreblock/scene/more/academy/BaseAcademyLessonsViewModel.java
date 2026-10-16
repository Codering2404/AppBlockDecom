package cz.mobilesoft.coreblock.scene.more.academy;

import android.app.Application;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.util.livedata.FreshLiveData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public abstract class BaseAcademyLessonsViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final FreshLiveData f106048i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAcademyLessonsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f106048i = new FreshLiveData();
    }

    public final void I0(long j3, Function1 onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        G0(new BaseAcademyLessonsViewModel$checkAnotherCurrentLesson$1(j3, onResult, null));
    }

    public final FreshLiveData J0() {
        return this.f106048i;
    }

    public final void K0(long j3, Function0 onSuccess) {
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        H0(new BaseAcademyLessonsViewModel$startLesson$1(this, j3, onSuccess, null));
    }
}
