package androidx.room.support;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.util.concurrent.Callable;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PrePackagedCopyOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f52784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f52785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Callable f52786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SupportSQLiteOpenHelper.Factory f52787d;

    public PrePackagedCopyOpenHelperFactory(String str, File file, Callable callable, SupportSQLiteOpenHelper.Factory delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.f52784a = str;
        this.f52785b = file;
        this.f52786c = callable;
        this.f52787d = delegate;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper a(SupportSQLiteOpenHelper.Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        return new PrePackagedCopyOpenHelper(configuration.f53169a, this.f52784a, this.f52785b, this.f52786c, configuration.f53171c.f53167a, this.f52787d.a(configuration));
    }
}
