package androidx.room.util;

import androidx.room.util.TableInfo;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.github.appintro.AppIntroBaseFragmentKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class SchemaInfoUtilKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f52964a = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    public static final int a(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        if (StringsKt.a0(upperCase, "INT", false, 2, null)) {
            return 3;
        }
        if (StringsKt.a0(upperCase, "CHAR", false, 2, null) || StringsKt.a0(upperCase, "CLOB", false, 2, null) || StringsKt.a0(upperCase, "TEXT", false, 2, null)) {
            return 2;
        }
        if (StringsKt.a0(upperCase, "BLOB", false, 2, null)) {
            return 5;
        }
        return (StringsKt.a0(upperCase, "REAL", false, 2, null) || StringsKt.a0(upperCase, "FLOA", false, 2, null) || StringsKt.a0(upperCase, "DOUB", false, 2, null)) ? 4 : 1;
    }

    private static final Map b(SQLiteConnection sQLiteConnection, String str) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA table_info(`" + str + "`)");
        try {
            if (!sQLiteStatementG2.B2()) {
                Map mapEmptyMap = MapsKt.emptyMap();
                AutoCloseableKt.a(sQLiteStatementG2, null);
                return mapEmptyMap;
            }
            int iA = SQLiteStatementUtil.a(sQLiteStatementG2, "name");
            int iA2 = SQLiteStatementUtil.a(sQLiteStatementG2, "type");
            int iA3 = SQLiteStatementUtil.a(sQLiteStatementG2, "notnull");
            int iA4 = SQLiteStatementUtil.a(sQLiteStatementG2, "pk");
            int iA5 = SQLiteStatementUtil.a(sQLiteStatementG2, "dflt_value");
            Map mapCreateMapBuilder = MapsKt.createMapBuilder();
            do {
                String strF2 = sQLiteStatementG2.f2(iA);
                mapCreateMapBuilder.put(strF2, new TableInfo.Column(strF2, sQLiteStatementG2.f2(iA2), sQLiteStatementG2.getLong(iA3) != 0, (int) sQLiteStatementG2.getLong(iA4), sQLiteStatementG2.isNull(iA5) ? null : sQLiteStatementG2.f2(iA5), 2));
            } while (sQLiteStatementG2.B2());
            Map mapBuild = MapsKt.build(mapCreateMapBuilder);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return mapBuild;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.a(sQLiteStatementG2, th);
                throw th2;
            }
        }
    }

    private static final List c(SQLiteStatement sQLiteStatement) {
        int iA = SQLiteStatementUtil.a(sQLiteStatement, "id");
        int iA2 = SQLiteStatementUtil.a(sQLiteStatement, "seq");
        int iA3 = SQLiteStatementUtil.a(sQLiteStatement, "from");
        int iA4 = SQLiteStatementUtil.a(sQLiteStatement, "to");
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        while (sQLiteStatement.B2()) {
            listCreateListBuilder.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(iA), (int) sQLiteStatement.getLong(iA2), sQLiteStatement.f2(iA3), sQLiteStatement.f2(iA4)));
        }
        return CollectionsKt.sorted(CollectionsKt.build(listCreateListBuilder));
    }

    private static final Set d(SQLiteConnection sQLiteConnection, String str) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int iA = SQLiteStatementUtil.a(sQLiteStatementG2, "id");
            int iA2 = SQLiteStatementUtil.a(sQLiteStatementG2, "seq");
            int iA3 = SQLiteStatementUtil.a(sQLiteStatementG2, "table");
            int iA4 = SQLiteStatementUtil.a(sQLiteStatementG2, "on_delete");
            int iA5 = SQLiteStatementUtil.a(sQLiteStatementG2, "on_update");
            List listC = c(sQLiteStatementG2);
            sQLiteStatementG2.reset();
            Set setCreateSetBuilder = SetsKt.createSetBuilder();
            while (sQLiteStatementG2.B2()) {
                if (sQLiteStatementG2.getLong(iA2) == 0) {
                    int i3 = (int) sQLiteStatementG2.getLong(iA);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj : listC) {
                        if (((ForeignKeyWithSequence) obj).c() == i3) {
                            arrayList3.add(obj);
                        }
                    }
                    int size = arrayList3.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2 = arrayList3.get(i4);
                        i4++;
                        ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj2;
                        arrayList.add(foreignKeyWithSequence.b());
                        arrayList2.add(foreignKeyWithSequence.d());
                    }
                    setCreateSetBuilder.add(new TableInfo.ForeignKey(sQLiteStatementG2.f2(iA3), sQLiteStatementG2.f2(iA4), sQLiteStatementG2.f2(iA5), arrayList, arrayList2));
                }
            }
            Set setBuild = SetsKt.build(setCreateSetBuilder);
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return setBuild;
        } finally {
        }
    }

    private static final TableInfo.Index e(SQLiteConnection sQLiteConnection, String str, boolean z2) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int iA = SQLiteStatementUtil.a(sQLiteStatementG2, "seqno");
            int iA2 = SQLiteStatementUtil.a(sQLiteStatementG2, "cid");
            int iA3 = SQLiteStatementUtil.a(sQLiteStatementG2, "name");
            int iA4 = SQLiteStatementUtil.a(sQLiteStatementG2, AppIntroBaseFragmentKt.ARG_DESC);
            if (iA != -1 && iA2 != -1 && iA3 != -1 && iA4 != -1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                while (sQLiteStatementG2.B2()) {
                    if (((int) sQLiteStatementG2.getLong(iA2)) >= 0) {
                        int i3 = (int) sQLiteStatementG2.getLong(iA);
                        String strF2 = sQLiteStatementG2.f2(iA3);
                        String str2 = sQLiteStatementG2.getLong(iA4) > 0 ? "DESC" : "ASC";
                        linkedHashMap.put(Integer.valueOf(i3), strF2);
                        linkedHashMap2.put(Integer.valueOf(i3), str2);
                    }
                }
                List listSortedWith = CollectionsKt.sortedWith(linkedHashMap.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.d((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
                    }
                });
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
                Iterator it = listSortedWith.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Map.Entry) it.next()).getValue());
                }
                List list = CollectionsKt.toList(arrayList);
                List listSortedWith2 = CollectionsKt.sortedWith(linkedHashMap2.entrySet(), new Comparator() { // from class: androidx.room.util.SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        return ComparisonsKt.d((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
                    }
                });
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith2, 10));
                Iterator it2 = listSortedWith2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((String) ((Map.Entry) it2.next()).getValue());
                }
                TableInfo.Index index = new TableInfo.Index(str, z2, list, CollectionsKt.toList(arrayList2));
                AutoCloseableKt.a(sQLiteStatementG2, null);
                return index;
            }
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return null;
        } finally {
        }
    }

    private static final Set f(SQLiteConnection sQLiteConnection, String str) throws Exception {
        SQLiteStatement sQLiteStatementG2 = sQLiteConnection.G2("PRAGMA index_list(`" + str + "`)");
        try {
            int iA = SQLiteStatementUtil.a(sQLiteStatementG2, "name");
            int iA2 = SQLiteStatementUtil.a(sQLiteStatementG2, "origin");
            int iA3 = SQLiteStatementUtil.a(sQLiteStatementG2, "unique");
            if (iA != -1 && iA2 != -1 && iA3 != -1) {
                Set setCreateSetBuilder = SetsKt.createSetBuilder();
                while (sQLiteStatementG2.B2()) {
                    if (Intrinsics.areEqual("c", sQLiteStatementG2.f2(iA2))) {
                        TableInfo.Index indexE = e(sQLiteConnection, sQLiteStatementG2.f2(iA), sQLiteStatementG2.getLong(iA3) == 1);
                        if (indexE == null) {
                            AutoCloseableKt.a(sQLiteStatementG2, null);
                            return null;
                        }
                        setCreateSetBuilder.add(indexE);
                    }
                }
                Set setBuild = SetsKt.build(setCreateSetBuilder);
                AutoCloseableKt.a(sQLiteStatementG2, null);
                return setBuild;
            }
            AutoCloseableKt.a(sQLiteStatementG2, null);
            return null;
        } finally {
        }
    }

    public static final TableInfo g(SQLiteConnection connection, String tableName) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(tableName, "tableName");
        return new TableInfo(tableName, b(connection, tableName), d(connection, tableName), f(connection, tableName));
    }
}
