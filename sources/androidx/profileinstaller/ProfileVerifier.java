package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.concurrent.futures.ResolvableFuture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class ProfileVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ResolvableFuture f51408a = ResolvableFuture.s();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f51409b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static CompilationStatus f51410c = null;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api33Impl {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Cache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f51411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f51412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f51413c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f51414d;

        Cache(int i3, int i4, long j3, long j4) {
            this.f51411a = i3;
            this.f51412b = i4;
            this.f51413c = j3;
            this.f51414d = j4;
        }

        static Cache a(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } finally {
            }
        }

        void b(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f51411a);
                dataOutputStream.writeInt(this.f51412b);
                dataOutputStream.writeLong(this.f51413c);
                dataOutputStream.writeLong(this.f51414d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Cache)) {
                Cache cache = (Cache) obj;
                if (this.f51412b == cache.f51412b && this.f51413c == cache.f51413c && this.f51411a == cache.f51411a && this.f51414d == cache.f51414d) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f51412b), Long.valueOf(this.f51413c), Integer.valueOf(this.f51411a), Long.valueOf(this.f51414d));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CompilationStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f51415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f51416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f51417c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f51418d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int i3, boolean z2, boolean z3, boolean z4) {
            this.f51415a = i3;
            this.f51417c = z3;
            this.f51416b = z2;
            this.f51418d = z4;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? Api33Impl.a(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus b(int i3, boolean z2, boolean z3, boolean z4) {
        CompilationStatus compilationStatus = new CompilationStatus(i3, z2, z3, z4);
        f51410c = compilationStatus;
        f51408a.o(compilationStatus);
        return f51410c;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0046 A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:9:0x000c, B:11:0x0010, B:16:0x0019, B:22:0x002e, B:33:0x0040, B:35:0x0046, B:36:0x004c, B:38:0x004e, B:44:0x0071, B:50:0x0094, B:51:0x0098, B:53:0x00a9, B:62:0x00ba, B:64:0x00c0, B:79:0x00dc, B:82:0x00e2, B:85:0x00e9, B:87:0x00f2, B:92:0x00fe, B:93:0x0102, B:89:0x00f8, B:56:0x00b0, B:57:0x00b4, B:95:0x0104, B:96:0x010a, B:31:0x003e, B:30:0x003b), top: B:102:0x000c, inners: #2, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x004e A[Catch: all -> 0x0012, TryCatch #1 {, blocks: (B:9:0x000c, B:11:0x0010, B:16:0x0019, B:22:0x002e, B:33:0x0040, B:35:0x0046, B:36:0x004c, B:38:0x004e, B:44:0x0071, B:50:0x0094, B:51:0x0098, B:53:0x00a9, B:62:0x00ba, B:64:0x00c0, B:79:0x00dc, B:82:0x00e2, B:85:0x00e9, B:87:0x00f2, B:92:0x00fe, B:93:0x0102, B:89:0x00f8, B:56:0x00b0, B:57:0x00b4, B:95:0x0104, B:96:0x010a, B:31:0x003e, B:30:0x003b), top: B:102:0x000c, inners: #2, #5 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.profileinstaller.ProfileVerifier.CompilationStatus c(android.content.Context r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 270
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.ProfileVerifier.c(android.content.Context, boolean):androidx.profileinstaller.ProfileVerifier$CompilationStatus");
    }
}
