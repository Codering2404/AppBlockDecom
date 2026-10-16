package androidx.room.support;

import android.content.Context;
import android.util.Log;
import androidx.room.DatabaseConfiguration;
import androidx.room.DelegatingOpenHelper;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.FileUtil;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import androidx.sqlite.util.ProcessLock;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class PrePackagedCopyOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f52775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f52776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final File f52777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Callable f52778d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f52779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final SupportSQLiteOpenHelper f52780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private DatabaseConfiguration f52781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f52782i;

    public PrePackagedCopyOpenHelper(Context context, String str, File file, Callable callable, int i3, SupportSQLiteOpenHelper delegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f52775a = context;
        this.f52776b = str;
        this.f52777c = file;
        this.f52778d = callable;
        this.f52779f = i3;
        this.f52780g = delegate;
    }

    private final void a(File file, boolean z2) throws IOException {
        ReadableByteChannel readableByteChannelNewChannel;
        if (this.f52776b != null) {
            readableByteChannelNewChannel = Channels.newChannel(this.f52775a.getAssets().open(this.f52776b));
            Intrinsics.checkNotNullExpressionValue(readableByteChannelNewChannel, "newChannel(...)");
        } else if (this.f52777c != null) {
            readableByteChannelNewChannel = new FileInputStream(this.f52777c).getChannel();
            Intrinsics.checkNotNullExpressionValue(readableByteChannelNewChannel, "getChannel(...)");
        } else {
            Callable callable = this.f52778d;
            if (callable == null) {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
            try {
                readableByteChannelNewChannel = Channels.newChannel((InputStream) callable.call());
                Intrinsics.checkNotNullExpressionValue(readableByteChannelNewChannel, "newChannel(...)");
            } catch (Exception e3) {
                throw new IOException("inputStreamCallable exception on call", e3);
            }
        }
        File fileCreateTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f52775a.getCacheDir());
        fileCreateTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(fileCreateTempFile).getChannel();
        Intrinsics.checkNotNull(channel);
        FileUtil.a(readableByteChannelNewChannel, channel);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        Intrinsics.checkNotNull(fileCreateTempFile);
        c(fileCreateTempFile, z2);
        if (fileCreateTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + fileCreateTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private final SupportSQLiteOpenHelper b(File file) {
        try {
            final int i3 = DBUtil.i(file);
            FrameworkSQLiteOpenHelperFactory frameworkSQLiteOpenHelperFactory = new FrameworkSQLiteOpenHelperFactory();
            SupportSQLiteOpenHelper.Configuration.Builder builderD = SupportSQLiteOpenHelper.Configuration.f53168f.a(this.f52775a).d(file.getAbsolutePath());
            final int iF = RangesKt.f(i3, 1);
            return frameworkSQLiteOpenHelperFactory.a(builderD.c(new SupportSQLiteOpenHelper.Callback(iF) { // from class: androidx.room.support.PrePackagedCopyOpenHelper$createFrameworkOpenHelper$configuration$1
                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void d(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void f(SupportSQLiteDatabase db) {
                    Intrinsics.checkNotNullParameter(db, "db");
                    int i4 = i3;
                    if (i4 < 1) {
                        db.r1(i4);
                    }
                }

                @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Callback
                public void g(SupportSQLiteDatabase db, int i4, int i5) {
                    Intrinsics.checkNotNullParameter(db, "db");
                }
            }).b());
        } catch (IOException e3) {
            throw new RuntimeException("Malformed database file, unable to read version.", e3);
        }
    }

    private final void c(File file, boolean z2) {
        DatabaseConfiguration databaseConfiguration = this.f52781h;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
            databaseConfiguration = null;
        }
        if (databaseConfiguration.f52143q == null) {
            return;
        }
        SupportSQLiteOpenHelper supportSQLiteOpenHelperB = b(file);
        try {
            SupportSQLiteDatabase writableDatabase = z2 ? supportSQLiteOpenHelperB.getWritableDatabase() : supportSQLiteOpenHelperB.getReadableDatabase();
            DatabaseConfiguration databaseConfiguration2 = this.f52781h;
            if (databaseConfiguration2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                databaseConfiguration2 = null;
            }
            RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback = databaseConfiguration2.f52143q;
            Intrinsics.checkNotNull(prepackagedDatabaseCallback);
            prepackagedDatabaseCallback.a(writableDatabase);
            Unit unit = Unit.f139807a;
            CloseableKt.a(supportSQLiteOpenHelperB, null);
        } finally {
        }
    }

    private final void i(boolean z2) {
        String databaseName = getDatabaseName();
        if (databaseName == null) {
            throw new IllegalStateException("Required value was null.");
        }
        File databasePath = this.f52775a.getDatabasePath(databaseName);
        DatabaseConfiguration databaseConfiguration = this.f52781h;
        DatabaseConfiguration databaseConfiguration2 = null;
        if (databaseConfiguration == null) {
            Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
            databaseConfiguration = null;
        }
        ProcessLock processLock = new ProcessLock(databaseName, this.f52775a.getFilesDir(), databaseConfiguration.f52149w);
        try {
            ProcessLock.c(processLock, false, 1, null);
            if (!databasePath.exists()) {
                try {
                    Intrinsics.checkNotNull(databasePath);
                    a(databasePath, z2);
                    processLock.d();
                    return;
                } catch (IOException e3) {
                    throw new RuntimeException("Unable to copy database file.", e3);
                }
            }
            try {
                Intrinsics.checkNotNull(databasePath);
                int i3 = DBUtil.i(databasePath);
                if (i3 == this.f52779f) {
                    processLock.d();
                    return;
                }
                DatabaseConfiguration databaseConfiguration3 = this.f52781h;
                if (databaseConfiguration3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                    databaseConfiguration3 = null;
                }
                if (databaseConfiguration3.f52130d.d(i3, this.f52779f) != null) {
                    processLock.d();
                    return;
                }
                DatabaseConfiguration databaseConfiguration4 = this.f52781h;
                if (databaseConfiguration4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("databaseConfiguration");
                } else {
                    databaseConfiguration2 = databaseConfiguration4;
                }
                if (databaseConfiguration2.e(i3, this.f52779f)) {
                    processLock.d();
                    return;
                }
                if (this.f52775a.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath, z2);
                        Unit unit = Unit.f139807a;
                    } catch (IOException e4) {
                        Log.w("ROOM", "Unable to copy database file.", e4);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                processLock.d();
                return;
            } catch (IOException e5) {
                Log.w("ROOM", "Unable to read database version.", e5);
                processLock.d();
                return;
            }
        } catch (Throwable th) {
            processLock.d();
            throw th;
        }
        processLock.d();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        getDelegate().close();
        this.f52782i = false;
    }

    public final void f(DatabaseConfiguration databaseConfiguration) {
        Intrinsics.checkNotNullParameter(databaseConfiguration, "databaseConfiguration");
        this.f52781h = databaseConfiguration;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return getDelegate().getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    public SupportSQLiteOpenHelper getDelegate() {
        return this.f52780g;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        if (!this.f52782i) {
            i(false);
            this.f52782i = true;
        }
        return getDelegate().getReadableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        if (!this.f52782i) {
            i(true);
            this.f52782i = true;
        }
        return getDelegate().getWritableDatabase();
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z2) {
        getDelegate().setWriteAheadLoggingEnabled(z2);
    }
}
