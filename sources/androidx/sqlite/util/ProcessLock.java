package androidx.sqlite.util;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
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
public final class ProcessLock {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Companion f53251e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map f53252f = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f53253a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f53254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Lock f53255c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FileChannel f53256d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Lock b(String str) {
            Lock lock;
            synchronized (ProcessLock.f53252f) {
                try {
                    Map map = ProcessLock.f53252f;
                    Object reentrantLock = map.get(str);
                    if (reentrantLock == null) {
                        reentrantLock = new ReentrantLock();
                        map.put(str, reentrantLock);
                    }
                    lock = (Lock) reentrantLock;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private Companion() {
        }
    }

    public ProcessLock(String name, File file, boolean z2) {
        File file2;
        Intrinsics.checkNotNullParameter(name, "name");
        this.f53253a = z2;
        if (file != null) {
            file2 = new File(file, name + ".lck");
        } else {
            file2 = null;
        }
        this.f53254b = file2;
        this.f53255c = f53251e.b(name);
    }

    public static /* synthetic */ void c(ProcessLock processLock, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = processLock.f53253a;
        }
        processLock.b(z2);
    }

    public final void b(boolean z2) {
        this.f53255c.lock();
        if (z2) {
            try {
                File file = this.f53254b;
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(this.f53254b).getChannel();
                channel.lock();
                this.f53256d = channel;
            } catch (IOException e3) {
                this.f53256d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e3);
            }
        }
    }

    public final void d() {
        try {
            FileChannel fileChannel = this.f53256d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f53255c.unlock();
    }
}
