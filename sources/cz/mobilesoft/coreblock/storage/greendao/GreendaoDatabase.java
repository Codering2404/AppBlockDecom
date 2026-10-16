package cz.mobilesoft.coreblock.storage.greendao;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class GreendaoDatabase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f124807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f124808b;

    public GreendaoDatabase(SQLiteDatabase sQLiteDatabase, boolean z2) {
        this.f124807a = sQLiteDatabase;
        this.f124808b = z2;
    }

    public final SQLiteDatabase a() {
        return this.f124807a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GreendaoDatabase)) {
            return false;
        }
        GreendaoDatabase greendaoDatabase = (GreendaoDatabase) obj;
        return Intrinsics.areEqual(this.f124807a, greendaoDatabase.f124807a) && this.f124808b == greendaoDatabase.f124808b;
    }

    public int hashCode() {
        SQLiteDatabase sQLiteDatabase = this.f124807a;
        return ((sQLiteDatabase == null ? 0 : sQLiteDatabase.hashCode()) * 31) + Boolean.hashCode(this.f124808b);
    }

    public String toString() {
        return "GreendaoDatabase(sqLiteDatabase=" + this.f124807a + ", isReadOnly=" + this.f124808b + ")";
    }
}
