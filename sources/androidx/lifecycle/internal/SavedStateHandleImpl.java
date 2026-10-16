package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.lifecycle.internal.SavedStateHandleImpl;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;

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
public final class SavedStateHandleImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f40206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f40207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f40208c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f40209d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final SavedStateRegistry.SavedStateProvider f40210e;

    public SavedStateHandleImpl(Map initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        this.f40206a = MapsKt.toMutableMap(initialState);
        this.f40207b = new LinkedHashMap();
        this.f40208c = new LinkedHashMap();
        this.f40209d = new LinkedHashMap();
        this.f40210e = new SavedStateRegistry.SavedStateProvider() { // from class: e.a
            @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
            public final Bundle a() {
                return SavedStateHandleImpl.f(this.f134476a);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle f(SavedStateHandleImpl savedStateHandleImpl) {
        Pair[] pairArr;
        for (Map.Entry entry : MapsKt.toMap(savedStateHandleImpl.f40209d).entrySet()) {
            savedStateHandleImpl.g((String) entry.getKey(), ((MutableStateFlow) entry.getValue()).getValue());
        }
        for (Map.Entry entry2 : MapsKt.toMap(savedStateHandleImpl.f40207b).entrySet()) {
            savedStateHandleImpl.g((String) entry2.getKey(), ((SavedStateRegistry.SavedStateProvider) entry2.getValue()).a());
        }
        Map map = savedStateHandleImpl.f40206a;
        if (map.isEmpty()) {
            pairArr = new Pair[0];
        } else {
            ArrayList arrayList = new ArrayList(map.size());
            for (Map.Entry entry3 : map.entrySet()) {
                arrayList.add(TuplesKt.a((String) entry3.getKey(), entry3.getValue()));
            }
            pairArr = (Pair[]) arrayList.toArray(new Pair[0]);
        }
        Bundle bundleB = BundleKt.b((Pair[]) Arrays.copyOf(pairArr, pairArr.length));
        SavedStateWriter.a(bundleB);
        return bundleB;
    }

    public final boolean b(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.f40206a.containsKey(key);
    }

    public final Object c(String key) {
        Object value;
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            MutableStateFlow mutableStateFlow = (MutableStateFlow) this.f40209d.get(key);
            if (mutableStateFlow != null && (value = mutableStateFlow.getValue()) != null) {
                return value;
            }
            return this.f40206a.get(key);
        } catch (ClassCastException unused) {
            e(key);
            return null;
        }
    }

    public final SavedStateRegistry.SavedStateProvider d() {
        return this.f40210e;
    }

    public final Object e(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Object objRemove = this.f40206a.remove(key);
        this.f40208c.remove(key);
        return objRemove;
    }

    public final void g(String key, Object obj) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.f40206a.put(key, obj);
        MutableStateFlow mutableStateFlow = (MutableStateFlow) this.f40208c.get(key);
        if (mutableStateFlow != null) {
            mutableStateFlow.setValue(obj);
        }
        MutableStateFlow mutableStateFlow2 = (MutableStateFlow) this.f40209d.get(key);
        if (mutableStateFlow2 != null) {
            mutableStateFlow2.setValue(obj);
        }
    }

    public final void h(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.f40207b.put(key, provider);
    }

    public /* synthetic */ SavedStateHandleImpl(Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? MapsKt.emptyMap() : map);
    }
}
