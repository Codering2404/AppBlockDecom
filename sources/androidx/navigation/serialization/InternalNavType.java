package androidx.navigation.serialization;

import android.os.Bundle;
import androidx.navigation.CollectionNavType;
import androidx.navigation.NavType;
import androidx.navigation.NavUriUtils;
import androidx.savedstate.SavedStateReader;
import androidx.savedstate.SavedStateWriter;
import com.facebook.LegacyTokenHelper;
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
public final class InternalNavType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InternalNavType f49419a = new InternalNavType();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final NavType f49420b = new NavType<Integer>() { // from class: androidx.navigation.serialization.InternalNavType$IntNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "integer_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Integer a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return Integer.valueOf(SavedStateReader.s(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        public Integer l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            return (Integer) NavType.f48957d.l(value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Integer num) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (num == null) {
                SavedStateWriter.w(SavedStateWriter.a(bundle), key);
            } else {
                NavType.f48957d.h(bundle, key, num);
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NavType f49421c = new NavType<Boolean>() { // from class: androidx.navigation.serialization.InternalNavType$BoolNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "boolean_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Boolean a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return Boolean.valueOf(SavedStateReader.g(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        public Boolean l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            return (Boolean) NavType.f48967n.l(value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Boolean bool) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (bool == null) {
                SavedStateWriter.w(SavedStateWriter.a(bundle), key);
            } else {
                NavType.f48967n.h(bundle, key, bool);
            }
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final NavType f49422d = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return LegacyTokenHelper.TYPE_DOUBLE;
        }

        @Override // androidx.navigation.NavType
        public /* bridge */ /* synthetic */ void h(Bundle bundle, String str, Object obj) {
            m(bundle, str, ((Number) obj).doubleValue());
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Double a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            return Double.valueOf(SavedStateReader.o(SavedStateReader.a(bundle), key));
        }

        @Override // androidx.navigation.NavType
        public Double l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return Double.valueOf(Double.parseDouble(value));
        }

        public void m(Bundle bundle, String key, double d3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            SavedStateWriter.m(SavedStateWriter.a(bundle), key, d3);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final NavType f49423e = new NavType<Double>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "double_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Double a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return Double.valueOf(SavedStateReader.o(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        public Double l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            return (Double) InternalNavType.f49419a.e().l(value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Double d3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (d3 == null) {
                SavedStateWriter.w(SavedStateWriter.a(bundle), key);
            } else {
                InternalNavType.f49419a.e().h(bundle, key, d3);
            }
        }
    };

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final NavType f49424f = new NavType<Float>() { // from class: androidx.navigation.serialization.InternalNavType$FloatNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "float_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Float a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return Float.valueOf(SavedStateReader.q(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        public Float l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            return (Float) NavType.f48964k.l(value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Float f3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (f3 == null) {
                SavedStateWriter.w(SavedStateWriter.a(bundle), key);
            } else {
                NavType.f48964k.h(bundle, key, f3);
            }
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final NavType f49425g = new NavType<Long>() { // from class: androidx.navigation.serialization.InternalNavType$LongNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "long_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public Long a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return Long.valueOf(SavedStateReader.w(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        public Long l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (Intrinsics.areEqual(value, "null")) {
                return null;
            }
            return (Long) NavType.f48961h.l(value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, Long l3) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            if (l3 == null) {
                SavedStateWriter.w(SavedStateWriter.a(bundle), key);
            } else {
                NavType.f48961h.h(bundle, key, l3);
            }
        }
    };

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final NavType f49426h = new NavType<String>() { // from class: androidx.navigation.serialization.InternalNavType$StringNonNullableType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "string_non_nullable";
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public String a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            return (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) ? "null" : SavedStateReader.J(bundleA, key);
        }

        @Override // androidx.navigation.NavType
        public String l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, String value) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            SavedStateWriter.F(SavedStateWriter.a(bundle), key, value);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public String i(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return NavUriUtils.c(NavUriUtils.f48980a, value, null, 2, null);
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final NavType f49427i = new CollectionNavType<String[]>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableArrayType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "string_nullable[]";
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
            String[] strArrK = SavedStateReader.K(bundleA, key);
            ArrayList arrayList = new ArrayList(strArrK.length);
            for (String str : strArrK) {
                arrayList.add((String) NavType.f48970q.l(str));
            }
            return (String[]) arrayList.toArray(new String[0]);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public String[] l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new String[]{NavType.f48970q.l(value)};
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
            if (strArr == null) {
                SavedStateWriter.w(bundleA, key);
                return;
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (str == null) {
                    str = "null";
                }
                arrayList.add(str);
            }
            SavedStateWriter.G(bundleA, key, (String[]) arrayList.toArray(new String[0]));
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public List l(String[] strArr) {
            String strC;
            if (strArr == null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str : strArr) {
                if (str == null || (strC = NavUriUtils.c(NavUriUtils.f48980a, str, null, 2, null)) == null) {
                    strC = "null";
                }
                arrayList.add(strC);
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean j(String[] strArr, String[] strArr2) {
            return ArraysKt.contentDeepEquals(strArr, strArr2);
        }
    };

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final NavType f49428j = new CollectionNavType<List<? extends String>>() { // from class: androidx.navigation.serialization.InternalNavType$StringNullableListType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "List<String?>";
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
            List list = ArraysKt.toList(SavedStateReader.K(bundleA, key));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add((String) NavType.f48970q.l((String) it.next()));
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public List l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CollectionsKt.listOf(NavType.f48970q.l(value));
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
            if (list == null) {
                SavedStateWriter.w(bundleA, key);
                return;
            }
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str : list2) {
                if (str == null) {
                    str = "null";
                }
                arrayList.add(str);
            }
            SavedStateWriter.G(bundleA, key, (String[]) arrayList.toArray(new String[0]));
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public List l(List list) {
            String strC;
            if (list == null) {
                return CollectionsKt.emptyList();
            }
            List<String> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (String str : list2) {
                if (str == null || (strC = NavUriUtils.c(NavUriUtils.f48980a, str, null, 2, null)) == null) {
                    strC = "null";
                }
                arrayList.add(strC);
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean j(List list, List list2) {
            return ArraysKt.contentDeepEquals(list != null ? (String[]) list.toArray(new String[0]) : null, list2 != null ? (String[]) list2.toArray(new String[0]) : null);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final NavType f49429k = new CollectionNavType<double[]>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleArrayType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return LegacyTokenHelper.TYPE_DOUBLE_ARRAY;
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public double[] k() {
            return new double[0];
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public double[] a(Bundle bundle, String key) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateReader.a(bundle);
            if (!SavedStateReader.b(bundleA, key) || SavedStateReader.P(bundleA, key)) {
                return null;
            }
            return SavedStateReader.p(bundleA, key);
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public double[] l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new double[]{((Number) InternalNavType.f49419a.e().l(value)).doubleValue()};
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public double[] g(String value, double[] dArr) {
            double[] dArrPlus;
            Intrinsics.checkNotNullParameter(value, "value");
            return (dArr == null || (dArrPlus = ArraysKt.plus(dArr, l(value))) == null) ? l(value) : dArrPlus;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void h(Bundle bundle, String key, double[] dArr) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(key, "key");
            Bundle bundleA = SavedStateWriter.a(bundle);
            if (dArr == null) {
                SavedStateWriter.w(bundleA, key);
            } else {
                SavedStateWriter.n(bundleA, key, dArr);
            }
        }

        @Override // androidx.navigation.CollectionNavType
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public List l(double[] dArr) {
            List<Double> list;
            if (dArr == null || (list = ArraysKt.toList(dArr)) == null) {
                return CollectionsKt.emptyList();
            }
            List<Double> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Number) it.next()).doubleValue()));
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean j(double[] dArr, double[] dArr2) {
            return ArraysKt.contentDeepEquals(dArr != null ? ArraysKt.toTypedArray(dArr) : null, dArr2 != null ? ArraysKt.toTypedArray(dArr2) : null);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final NavType f49430l = new CollectionNavType<List<? extends Double>>() { // from class: androidx.navigation.serialization.InternalNavType$DoubleListType$1
        @Override // androidx.navigation.NavType
        public String b() {
            return "List<Double>";
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
            return ArraysKt.toList(SavedStateReader.p(bundleA, key));
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public List l(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return CollectionsKt.listOf(InternalNavType.f49419a.e().l(value));
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
            if (list == null) {
                SavedStateWriter.w(bundleA, key);
            } else {
                SavedStateWriter.n(bundleA, key, CollectionsKt.toDoubleArray(list));
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
                arrayList.add(String.valueOf(((Number) it.next()).doubleValue()));
            }
            return arrayList;
        }

        @Override // androidx.navigation.NavType
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public boolean j(List list, List list2) {
            return ArraysKt.contentDeepEquals(list != null ? (Double[]) list.toArray(new Double[0]) : null, list2 != null ? (Double[]) list2.toArray(new Double[0]) : null);
        }
    };

    private InternalNavType() {
    }

    public final NavType a() {
        return f49421c;
    }

    public final NavType b() {
        return f49429k;
    }

    public final NavType c() {
        return f49430l;
    }

    public final NavType d() {
        return f49423e;
    }

    public final NavType e() {
        return f49422d;
    }

    public final NavType f() {
        return f49424f;
    }

    public final NavType g() {
        return f49420b;
    }

    public final NavType h() {
        return f49425g;
    }

    public final NavType i() {
        return f49426h;
    }

    public final NavType j() {
        return f49427i;
    }

    public final NavType k() {
        return f49428j;
    }
}
