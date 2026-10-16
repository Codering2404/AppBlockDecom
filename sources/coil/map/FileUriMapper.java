package coil.map;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class FileUriMapper implements Mapper<Uri, File> {
    private final boolean b(Uri uri) {
        String scheme;
        if (!Utils.r(uri) && ((scheme = uri.getScheme()) == null || Intrinsics.areEqual(scheme, "file"))) {
            String path = uri.getPath();
            if (path == null) {
                path = "";
            }
            if (StringsKt.Y0(path, '/', false, 2, null) && Utils.i(uri) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // coil.map.Mapper
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public File a(Uri uri, Options options) {
        if (!b(uri)) {
            return null;
        }
        if (!Intrinsics.areEqual(uri.getScheme(), "file")) {
            return new File(uri.toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        return null;
    }
}
