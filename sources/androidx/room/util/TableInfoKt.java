package androidx.room.util;

import androidx.room.util.TableInfo;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
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
public final class TableInfoKt {
    private static final boolean a(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < str.length()) {
            char cCharAt = str.charAt(i3);
            int i6 = i5 + 1;
            if (i5 == 0 && cCharAt != '(') {
                return false;
            }
            if (cCharAt == '(') {
                i4++;
            } else if (cCharAt == ')' && i4 - 1 == 0 && i5 != str.length() - 1) {
                return false;
            }
            i3++;
            i5 = i6;
        }
        return i4 == 0;
    }

    public static final boolean b(String current, String str) {
        Intrinsics.checkNotNullParameter(current, "current");
        if (Intrinsics.areEqual(current, str)) {
            return true;
        }
        if (!a(current)) {
            return false;
        }
        String strSubstring = current.substring(1, current.length() - 1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return Intrinsics.areEqual(StringsKt.t1(strSubstring).toString(), str);
    }

    public static final boolean c(TableInfo.Column column, Object obj) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.a() != column2.a() || !Intrinsics.areEqual(column.f52972a, column2.f52972a) || column.f52974c != column2.f52974c) {
            return false;
        }
        String str = column.f52976e;
        String str2 = column2.f52976e;
        if (column.f52977f == 1 && column2.f52977f == 2 && str != null && !b(str, str2)) {
            return false;
        }
        if (column.f52977f == 2 && column2.f52977f == 1 && str2 != null && !b(str2, str)) {
            return false;
        }
        int i3 = column.f52977f;
        return (i3 == 0 || i3 != column2.f52977f || (str == null ? str2 == null : b(str, str2))) && column.f52978g == column2.f52978g;
    }

    public static final boolean d(TableInfo.ForeignKey foreignKey, Object obj) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (Intrinsics.areEqual(foreignKey.f52979a, foreignKey2.f52979a) && Intrinsics.areEqual(foreignKey.f52980b, foreignKey2.f52980b) && Intrinsics.areEqual(foreignKey.f52981c, foreignKey2.f52981c) && Intrinsics.areEqual(foreignKey.f52982d, foreignKey2.f52982d)) {
            return Intrinsics.areEqual(foreignKey.f52983e, foreignKey2.f52983e);
        }
        return false;
    }

    public static final boolean e(TableInfo.Index index, Object obj) {
        Intrinsics.checkNotNullParameter(index, "<this>");
        if (index == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Index)) {
            return false;
        }
        TableInfo.Index index2 = (TableInfo.Index) obj;
        if (index.f52986b == index2.f52986b && Intrinsics.areEqual(index.f52987c, index2.f52987c) && Intrinsics.areEqual(index.f52988d, index2.f52988d)) {
            return StringsKt.U(index.f52985a, "index_", false, 2, null) ? StringsKt.U(index2.f52985a, "index_", false, 2, null) : Intrinsics.areEqual(index.f52985a, index2.f52985a);
        }
        return false;
    }

    public static final boolean f(TableInfo tableInfo, Object obj) {
        Set set;
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!Intrinsics.areEqual(tableInfo.f52967a, tableInfo2.f52967a) || !Intrinsics.areEqual(tableInfo.f52968b, tableInfo2.f52968b) || !Intrinsics.areEqual(tableInfo.f52969c, tableInfo2.f52969c)) {
            return false;
        }
        Set set2 = tableInfo.f52970d;
        if (set2 == null || (set = tableInfo2.f52970d) == null) {
            return true;
        }
        return Intrinsics.areEqual(set2, set);
    }

    public static final String g(Collection collection) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return StringsKt.j(CollectionsKt.joinToString$default(collection, ",\n", "\n", "\n", 0, null, null, 56, null), null, 1, null) + "},";
    }

    public static final int h(TableInfo.Column column) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        return (((((column.f52972a.hashCode() * 31) + column.f52978g) * 31) + (column.f52974c ? 1231 : 1237)) * 31) + column.f52975d;
    }

    public static final int i(TableInfo.ForeignKey foreignKey) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        return (((((((foreignKey.f52979a.hashCode() * 31) + foreignKey.f52980b.hashCode()) * 31) + foreignKey.f52981c.hashCode()) * 31) + foreignKey.f52982d.hashCode()) * 31) + foreignKey.f52983e.hashCode();
    }

    public static final int j(TableInfo.Index index) {
        Intrinsics.checkNotNullParameter(index, "<this>");
        return ((((((StringsKt.U(index.f52985a, "index_", false, 2, null) ? -1184239155 : index.f52985a.hashCode()) * 31) + (index.f52986b ? 1 : 0)) * 31) + index.f52987c.hashCode()) * 31) + index.f52988d.hashCode();
    }

    public static final int k(TableInfo tableInfo) {
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        return (((tableInfo.f52967a.hashCode() * 31) + tableInfo.f52968b.hashCode()) * 31) + tableInfo.f52969c.hashCode();
    }

    private static final void l(Collection collection) {
        StringsKt.j(CollectionsKt.joinToString$default(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        StringsKt.j(" }", null, 1, null);
    }

    private static final void m(Collection collection) {
        StringsKt.j(CollectionsKt.joinToString$default(collection, ",", null, null, 0, null, null, 62, null), null, 1, null);
        StringsKt.j("},", null, 1, null);
    }

    public static final String n(TableInfo.Column column) {
        Intrinsics.checkNotNullParameter(column, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Column {\n            |   name = '");
        sb.append(column.f52972a);
        sb.append("',\n            |   type = '");
        sb.append(column.f52973b);
        sb.append("',\n            |   affinity = '");
        sb.append(column.f52978g);
        sb.append("',\n            |   notNull = '");
        sb.append(column.f52974c);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.f52975d);
        sb.append("',\n            |   defaultValue = '");
        String str = column.f52976e;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final String o(TableInfo.ForeignKey foreignKey) {
        Intrinsics.checkNotNullParameter(foreignKey, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.f52979a);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.f52980b);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.f52981c);
        sb.append("',\n            |   columnNames = {");
        m(CollectionsKt.sorted(foreignKey.f52982d));
        Unit unit = Unit.f139807a;
        sb.append(unit);
        sb.append("\n            |   referenceColumnNames = {");
        l(CollectionsKt.sorted(foreignKey.f52983e));
        sb.append(unit);
        sb.append("\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final String p(TableInfo.Index index) {
        Intrinsics.checkNotNullParameter(index, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Index {\n            |   name = '");
        sb.append(index.f52985a);
        sb.append("',\n            |   unique = '");
        sb.append(index.f52986b);
        sb.append("',\n            |   columns = {");
        m(index.f52987c);
        Unit unit = Unit.f139807a;
        sb.append(unit);
        sb.append("\n            |   orders = {");
        l(index.f52988d);
        sb.append(unit);
        sb.append("\n            |}\n        ");
        return StringsKt.j(StringsKt.p(sb.toString(), null, 1, null), null, 1, null);
    }

    public static final String q(TableInfo tableInfo) {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(tableInfo, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.f52967a);
        sb.append("',\n            |    columns = {");
        sb.append(g(CollectionsKt.sortedWith(tableInfo.f52968b.values(), new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(((TableInfo.Column) obj).f52972a, ((TableInfo.Column) obj2).f52972a);
            }
        })));
        sb.append("\n            |    foreignKeys = {");
        sb.append(g(tableInfo.f52969c));
        sb.append("\n            |    indices = {");
        Set set = tableInfo.f52970d;
        if (set == null || (listEmptyList = CollectionsKt.sortedWith(set, new Comparator() { // from class: androidx.room.util.TableInfoKt$toStringCommon$$inlined$sortedBy$2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ComparisonsKt.d(((TableInfo.Index) obj).f52985a, ((TableInfo.Index) obj2).f52985a);
            }
        })) == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        sb.append(g(listEmptyList));
        sb.append("\n            |}\n        ");
        return StringsKt.p(sb.toString(), null, 1, null);
    }
}
