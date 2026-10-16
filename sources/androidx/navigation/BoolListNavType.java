package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
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
public final class BoolListNavType extends CollectionNavType<List<? extends Boolean>> {
    public BoolListNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return "List<Boolean>";
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public List k() {
        return CollectionsKt.emptyList();
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public List a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateReader.a(bundle);
        if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
            return null;
        }
        return ArraysKt.toList(SavedStateReader.h(bundleA, key));
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public List l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return CollectionsKt.listOf(NavType.f48967n.l(value));
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public List g(String value, List list) {
        List listPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (list == null || (listPlus = CollectionsKt.plus((Collection) list, (Iterable) l(value))) == null) ? l(value) : listPlus;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, List list) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateWriter.a(bundle);
        if (list != null) {
            SavedStateWriter.g(bundleA, key, CollectionsKt.toBooleanArray(list));
        } else {
            SavedStateWriter.w(bundleA, key);
        }
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List l(List list) {
        if (list == null) {
            return CollectionsKt.emptyList();
        }
        List list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Boolean) it.next()).booleanValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(List list, List list2) {
        return ArraysKt.contentDeepEquals(list != null ? (Boolean[]) list.toArray(new Boolean[0]) : null, list2 != null ? (Boolean[]) list2.toArray(new Boolean[0]) : null);
    }
}
