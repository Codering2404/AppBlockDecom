package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
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
public final class StringArrayNavType extends CollectionNavType<String[]> {
    public StringArrayNavType() {
        super(true);
    }

    @Override // androidx.navigation.NavType
    public String b() {
        return "string[]";
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public String[] k() {
        return new String[0];
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public String[] a(Bundle bundle, String key) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateReader.a(bundle);
        if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
            return null;
        }
        return SavedStateReader.K(bundleA, key);
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public String[] l(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return new String[]{value};
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public String[] g(String value, String[] strArr) {
        String[] strArr2;
        Intrinsics.checkNotNullParameter(value, "value");
        return (strArr == null || (strArr2 = (String[]) ArraysKt.plus((Object[]) strArr, (Object[]) l(value))) == null) ? l(value) : strArr2;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public void h(Bundle bundle, String key, String[] strArr) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Intrinsics.checkNotNullParameter(key, "key");
        Bundle bundleA = SavedStateWriter.a(bundle);
        if (strArr != null) {
            SavedStateWriter.G(bundleA, key, strArr);
        } else {
            SavedStateWriter.w(bundleA, key);
        }
    }

    @Override // androidx.navigation.CollectionNavType
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List l(String[] strArr) {
        if (strArr == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(NavUriUtils.c(NavUriUtils.f48980a, str, null, 2, null));
        }
        return arrayList;
    }

    @Override // androidx.navigation.NavType
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public boolean j(String[] strArr, String[] strArr2) {
        return ArraysKt.contentDeepEquals(strArr, strArr2);
    }
}
