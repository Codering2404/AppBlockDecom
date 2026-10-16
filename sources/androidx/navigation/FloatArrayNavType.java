package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.facebook.LegacyTokenHelper;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FloatArrayNavType extends CollectionNavType<float[]> {
    public FloatArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return LegacyTokenHelper.TYPE_FLOAT_ARRAY;
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public float[] k() {
        return new float[0];
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public float[] a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateReader.a(bundle);
        if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
            return null;
        }
        return SavedStateReader.r(bundleA, key);
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public float[] l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new float[]{((Number) NavType.f48964k.l(value)).floatValue()};
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public float[] g(String value, float[] fArr) {
        float[] fArrPlus;
        Intrinsics.checkNotNullParameter(value, "value");
        return (fArr == null || (fArrPlus = ArraysKt.plus(fArr, l(value))) == null) ? l(value) : fArrPlus;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, float[] fArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateWriter.a(bundle);
        if (fArr != null) {
            SavedStateWriter.p(bundleA, key, fArr);
        } else {
            SavedStateWriter.w(bundleA, key);
        }
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List l(float[] fArr) {
        List<Float> list;
        if (fArr == null || (list = ArraysKt.toList(fArr)) == null) {
            return CollectionsKt.emptyList();
        }
        List<Float> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).floatValue()));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(float[] fArr, float[] fArr2) {
        return ArraysKt.contentDeepEquals(fArr != null ? ArraysKt.toTypedArray(fArr) : null, fArr2 != null ? ArraysKt.toTypedArray(fArr2) : null);
    }
}
