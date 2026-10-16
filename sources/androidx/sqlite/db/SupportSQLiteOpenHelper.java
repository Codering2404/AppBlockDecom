package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import android.util.Pair;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public interface SupportSQLiteOpenHelper extends Closeable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Callback {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f53166b = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f53167a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Callback(int i3) {
            this.f53167a = i3;
        }

        private final void a(String str) {
            if (StringsKt.F(str, ":memory:", true)) {
                return;
            }
            int length = str.length() - 1;
            int i3 = 0;
            boolean z2 = false;
            while (i3 <= length) {
                boolean z3 = Intrinsics.compare((int) str.charAt(!z2 ? i3 : length), 32) <= 0;
                if (z2) {
                    if (!z3) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z3) {
                    i3++;
                } else {
                    z2 = true;
                }
            }
            if (str.subSequence(i3, length + 1).toString().length() == 0) {
                return;
            }
            Log.w("SupportSQLite", "deleting the database file: " + str);
            try {
                SQLiteDatabase.deleteDatabase(new File(str));
            } catch (Exception e3) {
                Log.w("SupportSQLite", "delete failed: ", e3);
            }
        }

        public void b(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public void c(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Log.e("SupportSQLite", "Corruption reported by sqlite on database: " + db + ".path");
            if (!db.isOpen()) {
                String strG = db.g();
                if (strG != null) {
                    a(strG);
                    return;
                }
                return;
            }
            List listQ = null;
            try {
                try {
                    listQ = db.Q();
                } catch (SQLiteException unused) {
                }
                try {
                    db.close();
                } catch (IOException unused2) {
                }
                if (listQ != null) {
                    return;
                }
            } finally {
                if (listQ != null) {
                    Iterator it = listQ.iterator();
                    while (it.hasNext()) {
                        Object second = ((Pair) it.next()).second;
                        Intrinsics.checkNotNullExpressionValue(second, "second");
                        a((String) second);
                    }
                } else {
                    String strG2 = db.g();
                    if (strG2 != null) {
                        a(strG2);
                    }
                }
            }
        }

        public abstract void d(SupportSQLiteDatabase supportSQLiteDatabase);

        public void e(SupportSQLiteDatabase db, int i3, int i4) {
            Intrinsics.checkNotNullParameter(db, "db");
            throw new SQLiteException("Can't downgrade database from version " + i3 + " to " + i4);
        }

        public void f(SupportSQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
        }

        public abstract void g(SupportSQLiteDatabase supportSQLiteDatabase, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Configuration {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Companion f53168f = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f53169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f53170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Callback f53171c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f53172d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f53173e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static class Builder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Context f53174a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private String f53175b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Callback f53176c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private boolean f53177d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            private boolean f53178e;

            public Builder(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                this.f53174a = context;
            }

            public Builder a(boolean z2) {
                this.f53178e = z2;
                return this;
            }

            public Configuration b() {
                String str;
                Callback callback = this.f53176c;
                if (callback == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                }
                if (this.f53177d && ((str = this.f53175b) == null || str.length() == 0)) {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
                return new Configuration(this.f53174a, this.f53175b, callback, this.f53177d, this.f53178e);
            }

            public Builder c(Callback callback) {
                Intrinsics.checkNotNullParameter(callback, "callback");
                this.f53176c = callback;
                return this;
            }

            public Builder d(String str) {
                this.f53175b = str;
                return this;
            }

            public Builder e(boolean z2) {
                this.f53177d = z2;
                return this;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Builder a(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(Context context, String str, Callback callback, boolean z2, boolean z3) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f53169a = context;
            this.f53170b = str;
            this.f53171c = callback;
            this.f53172d = z2;
            this.f53173e = z3;
        }

        public static final Builder a(Context context) {
            return f53168f.a(context);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory {
        SupportSQLiteOpenHelper a(Configuration configuration);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z2);
}
