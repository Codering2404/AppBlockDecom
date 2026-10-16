package androidx.datastore.core;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
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
public final class SharedCounter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Factory f35798b = new Factory(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NativeSharedCounter f35799c = new NativeSharedCounter();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35800a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final SharedCounter b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            int fd = parcelFileDescriptor.getFd();
            if (c().nativeTruncateFile(fd) != 0) {
                throw new IOException("Failed to truncate counter file");
            }
            long jNativeCreateSharedCounter = c().nativeCreateSharedCounter(fd);
            if (jNativeCreateSharedCounter >= 0) {
                return new SharedCounter(jNativeCreateSharedCounter, null);
            }
            throw new IOException("Failed to mmap counter file");
        }

        public final SharedCounter a(Function0 produceFile) throws Throwable {
            ParcelFileDescriptor parcelFileDescriptorOpen;
            Intrinsics.checkNotNullParameter(produceFile, "produceFile");
            try {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open((File) produceFile.invoke(), 939524096);
                try {
                    SharedCounter sharedCounterB = b(parcelFileDescriptorOpen);
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    return sharedCounterB;
                } catch (Throwable th) {
                    th = th;
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptorOpen = null;
            }
        }

        public final NativeSharedCounter c() {
            return SharedCounter.f35799c;
        }

        public final void d() {
            System.loadLibrary("datastore_shared_counter");
        }

        private Factory() {
        }
    }

    public /* synthetic */ SharedCounter(long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3);
    }

    public final int b() {
        return f35799c.nativeGetCounterValue(this.f35800a);
    }

    public final int c() {
        return f35799c.nativeIncrementAndGetCounterValue(this.f35800a);
    }

    private SharedCounter(long j3) {
        this.f35800a = j3;
    }
}
