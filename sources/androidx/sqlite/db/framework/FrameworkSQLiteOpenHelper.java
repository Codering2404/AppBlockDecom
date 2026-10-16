package androidx.sqlite.db.framework;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
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
public final class FrameworkSQLiteOpenHelper implements SupportSQLiteOpenHelper {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f53188i = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f53189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53190b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Callback f53191c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f53192d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f53193f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f53194g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f53195h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class DBRefHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private FrameworkSQLiteDatabase f53196a;

        public DBRefHolder(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f53196a = frameworkSQLiteDatabase;
        }

        public final FrameworkSQLiteDatabase a() {
            return this.f53196a;
        }

        public final void b(FrameworkSQLiteDatabase frameworkSQLiteDatabase) {
            this.f53196a = frameworkSQLiteDatabase;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class OpenHelper extends SQLiteOpenHelper {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final Companion f53197i = new Companion(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f53198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final DBRefHolder f53199b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SupportSQLiteOpenHelper.Callback f53200c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f53201d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f53202f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ProcessLock f53203g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f53204h;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private static final class CallbackException extends RuntimeException {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final CallbackName f53205a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Throwable f53206b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public CallbackException(CallbackName callbackName, Throwable cause) {
                super(cause);
                Intrinsics.checkNotNullParameter(callbackName, "callbackName");
                Intrinsics.checkNotNullParameter(cause, "cause");
                this.f53205a = callbackName;
                this.f53206b = cause;
            }

            public final CallbackName a() {
                return this.f53205a;
            }

            @Override // java.lang.Throwable
            public Throwable getCause() {
                return this.f53206b;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CallbackName {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final CallbackName f53207a = new CallbackName("ON_CONFIGURE", 0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final CallbackName f53208b = new CallbackName("ON_CREATE", 1);

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final CallbackName f53209c = new CallbackName("ON_UPGRADE", 2);

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final CallbackName f53210d = new CallbackName("ON_DOWNGRADE", 3);

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final CallbackName f53211f = new CallbackName("ON_OPEN", 4);

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final /* synthetic */ CallbackName[] f53212g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private static final /* synthetic */ EnumEntries f53213h;

            static {
                CallbackName[] callbackNameArrA = a();
                f53212g = callbackNameArrA;
                f53213h = EnumEntriesKt.a(callbackNameArrA);
            }

            private CallbackName(String str, int i3) {
            }

            private static final /* synthetic */ CallbackName[] a() {
                return new CallbackName[]{f53207a, f53208b, f53209c, f53210d, f53211f};
            }

            public static CallbackName valueOf(String str) {
                return (CallbackName) Enum.valueOf(CallbackName.class, str);
            }

            public static CallbackName[] values() {
                return (CallbackName[]) f53212g.clone();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FrameworkSQLiteDatabase a(DBRefHolder refHolder, SQLiteDatabase sqLiteDatabase) {
                Intrinsics.checkNotNullParameter(refHolder, "refHolder");
                Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
                FrameworkSQLiteDatabase frameworkSQLiteDatabaseA = refHolder.a();
                if (frameworkSQLiteDatabaseA != null && frameworkSQLiteDatabaseA.z(sqLiteDatabase)) {
                    return frameworkSQLiteDatabaseA;
                }
                FrameworkSQLiteDatabase frameworkSQLiteDatabase = new FrameworkSQLiteDatabase(sqLiteDatabase);
                refHolder.b(frameworkSQLiteDatabase);
                return frameworkSQLiteDatabase;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f53214a;

            static {
                int[] iArr = new int[CallbackName.values().length];
                try {
                    iArr[CallbackName.f53207a.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CallbackName.f53208b.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CallbackName.f53209c.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[CallbackName.f53210d.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[CallbackName.f53211f.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f53214a = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenHelper(Context context, String str, final DBRefHolder dbRef, final SupportSQLiteOpenHelper.Callback callback, boolean z2) {
            String string;
            super(context, str, null, callback.f53167a, new DatabaseErrorHandler() { // from class: androidx.sqlite.db.framework.g
                @Override // android.database.DatabaseErrorHandler
                public final void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    FrameworkSQLiteOpenHelper.OpenHelper.b(callback, dbRef, sQLiteDatabase);
                }
            });
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(dbRef, "dbRef");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.f53198a = context;
            this.f53199b = dbRef;
            this.f53200c = callback;
            this.f53201d = z2;
            if (str == null) {
                string = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            } else {
                string = str;
            }
            this.f53203g = new ProcessLock(string, context.getCacheDir(), false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(SupportSQLiteOpenHelper.Callback callback, DBRefHolder dBRefHolder, SQLiteDatabase sQLiteDatabase) {
            Companion companion = f53197i;
            Intrinsics.checkNotNull(sQLiteDatabase);
            callback.c(companion.a(dBRefHolder, sQLiteDatabase));
        }

        private final SQLiteDatabase i(boolean z2) {
            if (z2) {
                SQLiteDatabase writableDatabase = super.getWritableDatabase();
                Intrinsics.checkNotNull(writableDatabase);
                return writableDatabase;
            }
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            Intrinsics.checkNotNull(readableDatabase);
            return readableDatabase;
        }

        private final SQLiteDatabase j(boolean z2) throws Throwable {
            File parentFile;
            String databaseName = getDatabaseName();
            boolean z3 = this.f53204h;
            if (databaseName != null && !z3 && (parentFile = this.f53198a.getDatabasePath(databaseName).getParentFile()) != null) {
                parentFile.mkdirs();
                if (!parentFile.isDirectory()) {
                    Log.w("SupportSQLite", "Invalid database parent file, not a directory: " + parentFile);
                }
            }
            try {
                return i(z2);
            } catch (Throwable unused) {
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException unused2) {
                }
                try {
                    return i(z2);
                } catch (Throwable th) {
                    th = th;
                    if (th instanceof CallbackException) {
                        CallbackException callbackException = (CallbackException) th;
                        Throwable cause = callbackException.getCause();
                        int i3 = WhenMappings.f53214a[callbackException.a().ordinal()];
                        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4) {
                            throw cause;
                        }
                        if (i3 != 5) {
                            throw new NoWhenBranchMatchedException();
                        }
                        if (!(cause instanceof SQLiteException)) {
                            throw cause;
                        }
                        th = cause;
                    }
                    if (!(th instanceof SQLiteException) || databaseName == null || !this.f53201d) {
                        throw th;
                    }
                    this.f53198a.deleteDatabase(databaseName);
                    try {
                        return i(z2);
                    } catch (CallbackException e3) {
                        throw e3.getCause();
                    }
                }
            }
        }

        public final SupportSQLiteDatabase c(boolean z2) {
            SupportSQLiteDatabase supportSQLiteDatabaseF;
            try {
                this.f53203g.b((this.f53204h || getDatabaseName() == null) ? false : true);
                this.f53202f = false;
                SQLiteDatabase sQLiteDatabaseJ = j(z2);
                if (this.f53202f) {
                    close();
                    supportSQLiteDatabaseF = c(z2);
                } else {
                    supportSQLiteDatabaseF = f(sQLiteDatabaseJ);
                }
                this.f53203g.d();
                return supportSQLiteDatabaseF;
            } catch (Throwable th) {
                this.f53203g.d();
                throw th;
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public void close() {
            try {
                ProcessLock.c(this.f53203g, false, 1, null);
                super.close();
                this.f53199b.b(null);
                this.f53204h = false;
            } finally {
                this.f53203g.d();
            }
        }

        public final FrameworkSQLiteDatabase f(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            return f53197i.a(this.f53199b, sqLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!this.f53202f && this.f53200c.f53167a != db.getVersion()) {
                db.setMaxSqlCacheSize(1);
            }
            try {
                this.f53200c.b(f(db));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f53207a, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            try {
                this.f53200c.d(f(sqLiteDatabase));
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f53208b, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase db, int i3, int i4) {
            Intrinsics.checkNotNullParameter(db, "db");
            this.f53202f = true;
            try {
                this.f53200c.e(f(db), i3, i4);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f53210d, th);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            if (!this.f53202f) {
                try {
                    this.f53200c.f(f(db));
                } catch (Throwable th) {
                    throw new CallbackException(CallbackName.f53211f, th);
                }
            }
            this.f53204h = true;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i3, int i4) {
            Intrinsics.checkNotNullParameter(sqLiteDatabase, "sqLiteDatabase");
            this.f53202f = true;
            try {
                this.f53200c.g(f(sqLiteDatabase), i3, i4);
            } catch (Throwable th) {
                throw new CallbackException(CallbackName.f53209c, th);
            }
        }
    }

    public FrameworkSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f53189a = context;
        this.f53190b = str;
        this.f53191c = callback;
        this.f53192d = z2;
        this.f53193f = z3;
        this.f53194g = LazyKt.b(new Function0() { // from class: androidx.sqlite.db.framework.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FrameworkSQLiteOpenHelper.c(this.f53220a);
            }
        });
    }

    private final OpenHelper b() {
        return (OpenHelper) this.f53194g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final OpenHelper c(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        OpenHelper openHelper;
        if (frameworkSQLiteOpenHelper.f53190b == null || !frameworkSQLiteOpenHelper.f53192d) {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.f53189a, frameworkSQLiteOpenHelper.f53190b, new DBRefHolder(null), frameworkSQLiteOpenHelper.f53191c, frameworkSQLiteOpenHelper.f53193f);
        } else {
            openHelper = new OpenHelper(frameworkSQLiteOpenHelper.f53189a, new File(SupportSQLiteCompat.Api21Impl.a(frameworkSQLiteOpenHelper.f53189a), frameworkSQLiteOpenHelper.f53190b).getAbsolutePath(), new DBRefHolder(null), frameworkSQLiteOpenHelper.f53191c, frameworkSQLiteOpenHelper.f53193f);
        }
        openHelper.setWriteAheadLoggingEnabled(frameworkSQLiteOpenHelper.f53195h);
        return openHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f53194g.isInitialized()) {
            b().close();
        }
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.f53190b;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return b().c(false);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return b().c(true);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z2) {
        if (this.f53194g.isInitialized()) {
            b().setWriteAheadLoggingEnabled(z2);
        }
        this.f53195h = z2;
    }
}
