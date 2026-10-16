package androidx.lifecycle;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
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
public final class SavedStateHandlesProvider implements SavedStateRegistry.SavedStateProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SavedStateRegistry f40091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f40092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f40093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Lazy f40094d;

    public SavedStateHandlesProvider(SavedStateRegistry savedStateRegistry, final ViewModelStoreOwner viewModelStoreOwner) {
        Intrinsics.checkNotNullParameter(savedStateRegistry, "savedStateRegistry");
        Intrinsics.checkNotNullParameter(viewModelStoreOwner, "viewModelStoreOwner");
        this.f40091a = savedStateRegistry;
        this.f40094d = LazyKt.b(new Function0() { // from class: androidx.lifecycle.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SavedStateHandlesProvider.f(viewModelStoreOwner);
            }
        });
    }

    private final SavedStateHandlesVM d() {
        return (SavedStateHandlesVM) this.f40094d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SavedStateHandlesVM f(ViewModelStoreOwner viewModelStoreOwner) {
        return SavedStateHandleSupport.e(viewModelStoreOwner);
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public Bundle a() {
        Pair[] pairArr;
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA = SavedStateWriter.a(bundleB);
        Bundle bundle = this.f40093c;
        if (bundle != null) {
            SavedStateWriter.d(bundleA, bundle);
        }
        for (Map.Entry entry2 : d().y0().entrySet()) {
            String str = (String) entry2.getKey();
            Bundle bundleA2 = ((SavedStateHandle) entry2.getValue()).d().a();
            if (!SavedStateReader.O(SavedStateReader.a(bundleA2))) {
                SavedStateWriter.A(bundleA, str, bundleA2);
            }
        }
        this.f40092b = false;
        return bundleB;
    }

    public final Bundle c(String key) {
        Pair[] pairArr;
        Intrinsics.checkNotNullParameter(key, "key");
        e();
        Bundle bundle = this.f40093c;
        if (bundle == null || !SavedStateReader.b(SavedStateReader.a(bundle), key)) {
            return null;
        }
        Bundle bundleE = SavedStateReader.E(SavedStateReader.a(bundle), key);
        if (bundleE == null) {
            Map mapEmptyMap = MapsKt.emptyMap();
            if (mapEmptyMap.isEmpty()) {
                pairArr = new Pair[0];
            } else {
                ArrayList arrayList = new ArrayList(mapEmptyMap.size());
                for (Map.Entry entry : mapEmptyMap.entrySet()) {
                    arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
                }
                pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
            }
            bundleE = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
            SavedStateWriter.a(bundleE);
        }
        SavedStateWriter.I(SavedStateWriter.a(bundle), key);
        if (SavedStateReader.O(SavedStateReader.a(bundle))) {
            this.f40093c = null;
        }
        return bundleE;
    }

    public final void e() {
        Pair[] pairArr;
        if (this.f40092b) {
            return;
        }
        Bundle bundleA = this.f40091a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Map mapEmptyMap = MapsKt.emptyMap();
        if (mapEmptyMap.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(mapEmptyMap.size());
            for (Map.Entry entry : mapEmptyMap.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry.getKey(), entry.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        Bundle bundleA2 = SavedStateWriter.a(bundleB);
        Bundle bundle = this.f40093c;
        if (bundle != null) {
            SavedStateWriter.d(bundleA2, bundle);
        }
        if (bundleA != null) {
            SavedStateWriter.d(bundleA2, bundleA);
        }
        this.f40093c = bundleB;
        this.f40092b = true;
        d();
    }
}
