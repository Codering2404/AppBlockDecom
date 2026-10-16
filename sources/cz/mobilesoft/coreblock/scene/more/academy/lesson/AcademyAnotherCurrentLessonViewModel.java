package cz.mobilesoft.coreblock.scene.more.academy.lesson;

import android.app.Application;
import androidx.lifecycle.LiveData;
import cz.mobilesoft.coreblock.base.viewmodel.BaseViewModel;
import cz.mobilesoft.coreblock.repository.AcademyRepository;
import kotlin.Metadata;
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
public final class AcademyAnotherCurrentLessonViewModel extends BaseViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f106204i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f106205j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LiveData f106206k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final LiveData f106207l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcademyAnotherCurrentLessonViewModel(Application application, long j3, long j4) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f106204i = j3;
        this.f106205j = j4;
        AcademyRepository academyRepository = AcademyRepository.f97249a;
        this.f106206k = academyRepository.j().c(j3);
        this.f106207l = academyRepository.j().c(j4);
    }

    public final LiveData I0() {
        return this.f106206k;
    }

    public final long J0() {
        return this.f106204i;
    }

    public final LiveData K0() {
        return this.f106207l;
    }

    public final long L0() {
        return this.f106205j;
    }
}
