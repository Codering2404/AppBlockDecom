package androidx.compose.ui.platform;

import android.os.Binder;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import android.view.View;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.saveable.SaveableStateRegistry;
import androidx.compose.runtime.saveable.SaveableStateRegistryKt;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import androidx.compose.ui.R;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryOwner;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DisposableSaveableStateRegistry_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class[] f28044a = {Serializable.class, Parcelable.class, String.class, SparseArray.class, Binder.class, Size.class, SizeF.class};

    public static final DisposableSaveableStateRegistry b(View view, SavedStateRegistryOwner savedStateRegistryOwner) {
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) parent;
        Object tag = view2.getTag(R.id.H);
        String strValueOf = tag instanceof String ? (String) tag : null;
        if (strValueOf == null) {
            strValueOf = String.valueOf(view2.getId());
        }
        return c(strValueOf, savedStateRegistryOwner);
    }

    public static final DisposableSaveableStateRegistry c(String str, SavedStateRegistryOwner savedStateRegistryOwner) {
        final boolean z2;
        final String str2 = SaveableStateRegistry.class.getSimpleName() + ':' + str;
        final SavedStateRegistry savedStateRegistry = savedStateRegistryOwner.getSavedStateRegistry();
        Bundle bundleA = savedStateRegistry.a(str2);
        final SaveableStateRegistry saveableStateRegistryA = SaveableStateRegistryKt.a(bundleA != null ? h(bundleA) : null, new Function1<Object, Boolean>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$saveableStateRegistry$1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(DisposableSaveableStateRegistry_androidKt.f(obj));
            }
        });
        try {
            savedStateRegistry.c(str2, new SavedStateRegistry.SavedStateProvider() { // from class: androidx.compose.ui.platform.s
                @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
                public final Bundle a() {
                    return DisposableSaveableStateRegistry_androidKt.d(saveableStateRegistryA);
                }
            });
            z2 = true;
        } catch (IllegalArgumentException unused) {
            z2 = false;
        }
        return new DisposableSaveableStateRegistry(saveableStateRegistryA, new Function0<Unit>() { // from class: androidx.compose.ui.platform.DisposableSaveableStateRegistry_androidKt$DisposableSaveableStateRegistry$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m252invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m252invoke() {
                if (z2) {
                    savedStateRegistry.e(str2);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bundle d(SaveableStateRegistry saveableStateRegistry) {
        return g(saveableStateRegistry.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(Object obj) {
        if (obj instanceof SnapshotMutableState) {
            SnapshotMutableState snapshotMutableState = (SnapshotMutableState) obj;
            if (snapshotMutableState.f() != SnapshotStateKt.k() && snapshotMutableState.f() != SnapshotStateKt.r() && snapshotMutableState.f() != SnapshotStateKt.o()) {
                return false;
            }
            Object value = snapshotMutableState.getValue();
            if (value == null) {
                return true;
            }
            return f(value);
        }
        if ((obj instanceof Function) && (obj instanceof Serializable)) {
            return false;
        }
        for (Class cls : f28044a) {
            if (cls.isInstance(obj)) {
                return true;
            }
        }
        return false;
    }

    private static final Bundle g(Map map) {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            bundle.putParcelableArrayList(str, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
        }
        return bundle;
    }

    private static final Map h(Bundle bundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (String str : bundle.keySet()) {
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(str);
            Intrinsics.checkNotNull(parcelableArrayList, "null cannot be cast to non-null type java.util.ArrayList<kotlin.Any?>{ kotlin.collections.TypeAliasesKt.ArrayList<kotlin.Any?> }");
            linkedHashMap.put(str, parcelableArrayList);
        }
        return linkedHashMap;
    }
}
