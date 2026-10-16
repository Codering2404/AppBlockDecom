package cz.mobilesoft.statistics.di;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;

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
public abstract class BaseViewModel extends AndroidViewModel implements CoroutineScope {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineScope f133601b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CoroutineScope f133602c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CompletableJob f133603d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.f133601b = CoroutineScopeKt.a(Dispatchers.c());
        this.f133602c = CoroutineScopeKt.a(Dispatchers.a());
        this.f133603d = JobKt__JobKt.b(null, 1, null);
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.f133603d.plus(Dispatchers.c());
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        Job.DefaultImpls.b(this.f133603d, null, 1, null);
        CoroutineScopeKt.e(this.f133602c, null, 1, null);
        CoroutineScopeKt.e(this.f133601b, null, 1, null);
    }

    protected final CoroutineScope z0() {
        return this.f133602c;
    }
}
