package coil.util;

import android.os.SystemClock;
import java.io.File;
import kotlin.Metadata;

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
final class FileDescriptorCounter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FileDescriptorCounter f56227a = new FileDescriptorCounter();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final File f56228b = new File("/proc/self/fd");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f56229c = 30;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static long f56230d = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f56231e = true;

    private FileDescriptorCounter() {
    }

    private final boolean a() {
        int i3 = f56229c;
        f56229c = i3 + 1;
        return i3 >= 30 || SystemClock.uptimeMillis() > f56230d + ((long) 30000);
    }

    public final synchronized boolean b(Logger logger) {
        try {
            if (a()) {
                f56229c = 0;
                f56230d = SystemClock.uptimeMillis();
                String[] list = f56228b.list();
                if (list == null) {
                    list = new String[0];
                }
                int length = list.length;
                boolean z2 = length < 800;
                f56231e = z2;
                if (!z2 && logger != null && logger.getLevel() <= 5) {
                    logger.a("FileDescriptorCounter", 5, "Unable to allocate more hardware bitmaps. Number of used file descriptors: " + length, null);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return f56231e;
    }
}
