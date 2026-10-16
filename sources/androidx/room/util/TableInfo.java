package androidx.room.util;

import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.driver.SupportSQLiteConnection;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TableInfo {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f52966e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f52968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f52969c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f52970d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Column {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final Companion f52971h = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f52972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f52974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f52975d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f52976e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f52977f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f52978g;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Column(String name, String type, boolean z2, int i3, String str, int i4) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(type, "type");
            this.f52972a = name;
            this.f52973b = type;
            this.f52974c = z2;
            this.f52975d = i3;
            this.f52976e = str;
            this.f52977f = i4;
            this.f52978g = SchemaInfoUtilKt.a(type);
        }

        public final boolean a() {
            return this.f52975d > 0;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.c(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.h(this);
        }

        public String toString() {
            return TableInfoKt.n(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TableInfo a(SQLiteConnection connection, String tableName) {
            Intrinsics.checkNotNullParameter(connection, "connection");
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            return SchemaInfoUtilKt.g(connection, tableName);
        }

        public final TableInfo b(SupportSQLiteDatabase database, String tableName) {
            Intrinsics.checkNotNullParameter(database, "database");
            Intrinsics.checkNotNullParameter(tableName, "tableName");
            return a(new SupportSQLiteConnection(database), tableName);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention
    public @interface CreatedFrom {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ForeignKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f52979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f52980b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f52981c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List f52982d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List f52983e;

        public ForeignKey(String referenceTable, String onDelete, String onUpdate, List columnNames, List referenceColumnNames) {
            Intrinsics.checkNotNullParameter(referenceTable, "referenceTable");
            Intrinsics.checkNotNullParameter(onDelete, "onDelete");
            Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
            Intrinsics.checkNotNullParameter(columnNames, "columnNames");
            Intrinsics.checkNotNullParameter(referenceColumnNames, "referenceColumnNames");
            this.f52979a = referenceTable;
            this.f52980b = onDelete;
            this.f52981c = onUpdate;
            this.f52982d = columnNames;
            this.f52983e = referenceColumnNames;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.d(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.i(this);
        }

        public String toString() {
            return TableInfoKt.o(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Index {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final Companion f52984e = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f52985a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f52986b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f52987c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f52988d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Collection] */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList] */
        public Index(String name, boolean z2, List columns, List orders) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(columns, "columns");
            Intrinsics.checkNotNullParameter(orders, "orders");
            this.f52985a = name;
            this.f52986b = z2;
            this.f52987c = columns;
            this.f52988d = orders;
            List arrayList = orders;
            if (arrayList.isEmpty()) {
                int size = columns.size();
                arrayList = new ArrayList(size);
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.add("ASC");
                }
            }
            this.f52988d = (List) arrayList;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.e(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.j(this);
        }

        public String toString() {
            return TableInfoKt.p(this);
        }
    }

    public TableInfo(String name, Map columns, Set foreignKeys, Set set) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(columns, "columns");
        Intrinsics.checkNotNullParameter(foreignKeys, "foreignKeys");
        this.f52967a = name;
        this.f52968b = columns;
        this.f52969c = foreignKeys;
        this.f52970d = set;
    }

    public static final TableInfo a(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return f52966e.b(supportSQLiteDatabase, str);
    }

    public boolean equals(Object obj) {
        return TableInfoKt.f(this, obj);
    }

    public int hashCode() {
        return TableInfoKt.k(this);
    }

    public String toString() {
        return TableInfoKt.q(this);
    }
}
