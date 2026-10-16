package androidx.navigation;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.navigation.internal.Utils_jvmCommonKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.UStringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavControllerViewModel extends ViewModel implements NavViewModelStoreProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f48812b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f48813a = new LinkedHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NavControllerViewModel a(ViewModelStore viewModelStore) {
            Intrinsics.checkNotNullParameter(viewModelStore, "viewModelStore");
            return (NavControllerViewModel) ViewModelProvider.Companion.c(ViewModelProvider.f40124b, viewModelStore, NavControllerViewModelKt.f48814a, null, 4, null).d(Reflection.b(NavControllerViewModel.class));
        }

        private Companion() {
        }
    }

    @Override // androidx.navigation.NavViewModelStoreProvider
    public ViewModelStore h(String backStackEntryId) {
        Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
        ViewModelStore viewModelStore = (ViewModelStore) this.f48813a.get(backStackEntryId);
        if (viewModelStore != null) {
            return viewModelStore;
        }
        ViewModelStore viewModelStore2 = new ViewModelStore();
        this.f48813a.put(backStackEntryId, viewModelStore2);
        return viewModelStore2;
    }

    @Override // androidx.lifecycle.ViewModel
    protected void onCleared() {
        Iterator it = this.f48813a.values().iterator();
        while (it.hasNext()) {
            ((ViewModelStore) it.next()).a();
        }
        this.f48813a.clear();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NavControllerViewModel{");
        sb.append(UStringsKt.a(UInt.b(Utils_jvmCommonKt.a(this)), 16));
        sb.append("} ViewModelStores (");
        Iterator it = this.f48813a.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void y0(String backStackEntryId) {
        Intrinsics.checkNotNullParameter(backStackEntryId, "backStackEntryId");
        ViewModelStore viewModelStore = (ViewModelStore) this.f48813a.remove(backStackEntryId);
        if (viewModelStore != null) {
            viewModelStore.a();
        }
    }
}
