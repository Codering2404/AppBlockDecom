package androidx.navigation.compose;

import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.navigation.compose.internal.NavComposeUtils_androidKt;
import androidx.navigation.compose.internal.WeakReference;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class BackStackEntryIdViewModel extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f49036a = "SaveableStateHolder_BackStackEntryKey";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f49037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f49038c;

    public BackStackEntryIdViewModel(SavedStateHandle savedStateHandle) {
        String strD = (String) savedStateHandle.c("SaveableStateHolder_BackStackEntryKey");
        if (strD == null) {
            strD = NavComposeUtils_androidKt.d();
            savedStateHandle.e("SaveableStateHolder_BackStackEntryKey", strD);
        }
        this.f49037b = strD;
    }

    public final void A0(WeakReference weakReference) {
        this.f49038c = weakReference;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        super.onCleared();
        SaveableStateHolder saveableStateHolder = (SaveableStateHolder) z0().b();
        if (saveableStateHolder != null) {
            saveableStateHolder.c(this.f49037b);
        }
        z0().a();
    }

    public final String y0() {
        return this.f49037b;
    }

    public final WeakReference z0() {
        WeakReference weakReference = this.f49038c;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("saveableStateHolderRef");
        return null;
    }
}
