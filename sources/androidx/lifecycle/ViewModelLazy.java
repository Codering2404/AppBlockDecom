package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ViewModelLazy<VM extends ViewModel> implements Lazy<VM> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final KClass f40119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f40120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function0 f40121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Function0 f40122d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ViewModel f40123f;

    public ViewModelLazy(KClass viewModelClass, Function0 storeProducer, Function0 factoryProducer, Function0 extrasProducer) {
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        Intrinsics.checkNotNullParameter(factoryProducer, "factoryProducer");
        Intrinsics.checkNotNullParameter(extrasProducer, "extrasProducer");
        this.f40119a = viewModelClass;
        this.f40120b = storeProducer;
        this.f40121c = factoryProducer;
        this.f40122d = extrasProducer;
    }

    @Override // kotlin.Lazy
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ViewModel getValue() {
        ViewModel viewModel = this.f40123f;
        if (viewModel != null) {
            return viewModel;
        }
        ViewModel viewModelD = ViewModelProvider.f40124b.a((ViewModelStore) this.f40120b.invoke(), (ViewModelProvider.Factory) this.f40121c.invoke(), (CreationExtras) this.f40122d.invoke()).d(this.f40119a);
        this.f40123f = viewModelD;
        return viewModelD;
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        return this.f40123f != null;
    }
}
