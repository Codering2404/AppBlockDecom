package coil.decode;

import android.content.Context;
import coil.decode.ImageSource;
import coil.util.Utils;
import java.io.Closeable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import okio.BufferedSource;
import okio.FileSystem;
import okio.Path;

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
public final class ImageSources {
    public static final ImageSource a(BufferedSource bufferedSource, final Context context) {
        return new SourceImageSource(bufferedSource, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.n(context);
            }
        }, null);
    }

    public static final ImageSource b(BufferedSource bufferedSource, final Context context, ImageSource.Metadata metadata) {
        return new SourceImageSource(bufferedSource, new Function0<File>() { // from class: coil.decode.ImageSources$ImageSource$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final File invoke() {
                return Utils.n(context);
            }
        }, metadata);
    }

    public static final ImageSource c(Path path, FileSystem fileSystem, String str, Closeable closeable) {
        return new FileImageSource(path, fileSystem, str, closeable, null);
    }

    public static /* synthetic */ ImageSource d(Path path, FileSystem fileSystem, String str, Closeable closeable, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            fileSystem = FileSystem.f145034b;
        }
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            closeable = null;
        }
        return c(path, fileSystem, str, closeable);
    }
}
