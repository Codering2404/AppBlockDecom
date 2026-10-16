package androidx.sqlite.driver;

import androidx.sqlite.SQLiteDriver;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import kotlin.Metadata;
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
public final class SupportSQLiteDriver implements SQLiteDriver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SupportSQLiteOpenHelper f53226a;

    public SupportSQLiteDriver(SupportSQLiteOpenHelper openHelper) {
        Intrinsics.checkNotNullParameter(openHelper, "openHelper");
        this.f53226a = openHelper;
    }

    @Override // androidx.sqlite.SQLiteDriver
    public boolean b() {
        return true;
    }

    @Override // androidx.sqlite.SQLiteDriver
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SupportSQLiteConnection a(String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        String databaseName = this.f53226a.getDatabaseName();
        if (databaseName == null) {
            if (!Intrinsics.areEqual(fileName, ":memory:")) {
                throw new IllegalArgumentException(("This driver is configured to open an in-memory database but a file-based named '" + fileName + "' was requested.").toString());
            }
        } else if (!Intrinsics.areEqual(databaseName, fileName) && !Intrinsics.areEqual(StringsKt.i1(databaseName, '/', null, 2, null), StringsKt.i1(fileName, '/', null, 2, null))) {
            throw new IllegalArgumentException(("This driver is configured to open a database named '" + this.f53226a.getDatabaseName() + "' but '" + fileName + "' was requested.").toString());
        }
        return new SupportSQLiteConnection(this.f53226a.getWritableDatabase());
    }
}
