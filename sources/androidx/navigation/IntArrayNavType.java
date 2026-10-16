package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.ArrayList;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class IntArrayNavType extends CollectionNavType<int[]> {
    public IntArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return "integer[]";
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public int[] k() {
        return new int[0];
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public int[] l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new int[]{((Number) NavType.f48957d.l(value)).intValue()};
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public int[] g(String value, int[] iArr) {
        int[] iArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (iArr == null || (iArrPlus = ArraysKt.plus(iArr, l(value))) == null) ? l(value) : iArrPlus;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, int[] iArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateWriter.a(bundle);
        if (iArr != null) {
            SavedStateWriter.r(bundleA, key, iArr);
        } else {
            SavedStateWriter.w(bundleA, key);
        }
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List l(int[] iArr) {
        List<Integer> list;
        if (iArr == null || (list = ArraysKt.toList(iArr)) == null) {
            return CollectionsKt.emptyList();
        }
        List<Integer> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(int[] iArr, int[] iArr2) {
        return ArraysKt.contentDeepEquals(iArr != null ? ArraysKt.toTypedArray(iArr) : null, iArr2 != null ? ArraysKt.toTypedArray(iArr2) : null);
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int[] a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, KrzujOtzIk.ZffbeMvLQHqNo);
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateReader.a(bundle);
        if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
            return null;
        }
        return SavedStateReader.t(bundleA, key);
    }
}
