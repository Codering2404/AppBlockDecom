package androidx.room.concurrent;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class ExclusiveLock {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f52491c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Map f52492d = new LinkedHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReentrantLock f52493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final FileLock f52494b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FileLock c(String str) {
            return new FileLock(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final ReentrantLock d(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = ExclusiveLock.f52492d;
                    Object reentrantLock2 = map.get(str);
                    if (reentrantLock2 == null) {
                        reentrantLock2 = new ReentrantLock();
                        map.put(str, reentrantLock2);
                    }
                    reentrantLock = (ReentrantLock) reentrantLock2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        private Companion() {
        }
    }

    public ExclusiveLock(String filename, boolean z2) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Companion companion = f52491c;
        this.f52493a = companion.d(filename);
        this.f52494b = z2 ? companion.c(filename) : null;
    }

    public final Object b(Function0 onLocked, Function1 onLockError) {
        Intrinsics.checkNotNullParameter(onLocked, "onLocked");
        Intrinsics.checkNotNullParameter(onLockError, "onLockError");
        this.f52493a.lock();
        boolean z2 = false;
        try {
            FileLock fileLock = this.f52494b;
            if (fileLock != null) {
                fileLock.a();
            }
            z2 = true;
            try {
                Object objInvoke = onLocked.invoke();
                this.f52493a.unlock();
                return objInvoke;
            } finally {
                FileLock fileLock2 = this.f52494b;
                if (fileLock2 != null) {
                    fileLock2.b();
                }
            }
        } catch (Throwable th) {
            try {
                if (z2) {
                    throw th;
                }
                onLockError.invoke(th);
                throw new KotlinNothingValueException();
            } catch (Throwable th2) {
                this.f52493a.unlock();
                throw th2;
            }
        }
    }
}
