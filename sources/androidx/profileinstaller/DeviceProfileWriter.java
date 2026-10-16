package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceProfileWriter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f51376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f51377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProfileInstaller.DiagnosticsCallback f51378c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final File f51380e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f51381f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f51382g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f51383h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private DexProfileData[] f51385j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f51386k;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f51384i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f51379d = d();

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String str, String str2, String str3, File file) {
        this.f51376a = assetManager;
        this.f51377b = executor;
        this.f51378c = diagnosticsCallback;
        this.f51381f = str;
        this.f51382g = str2;
        this.f51383h = str3;
        this.f51380e = file;
    }

    private DeviceProfileWriter b(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream inputStreamG;
        try {
            inputStreamG = g(this.f51376a, this.f51383h);
        } catch (FileNotFoundException e3) {
            this.f51378c.a(9, e3);
        } catch (IOException e4) {
            this.f51378c.a(7, e4);
        } catch (IllegalStateException e5) {
            this.f51385j = null;
            this.f51378c.a(8, e5);
        }
        if (inputStreamG == null) {
            if (inputStreamG != null) {
                inputStreamG.close();
            }
            return null;
        }
        try {
            this.f51385j = ProfileTranscoder.r(inputStreamG, ProfileTranscoder.p(inputStreamG, ProfileTranscoder.f51407b), bArr, dexProfileDataArr);
            inputStreamG.close();
            return this;
        } catch (Throwable th) {
            try {
                inputStreamG.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    private void c() {
        if (!this.f51384i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 31) {
            return ProfileVersion.f51419a;
        }
        switch (i3) {
            case 28:
            case 29:
            case 30:
                return ProfileVersion.f51420b;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        try {
            return g(assetManager, this.f51382g);
        } catch (FileNotFoundException e3) {
            this.f51378c.a(6, e3);
            return null;
        } catch (IOException e4) {
            this.f51378c.a(7, e4);
            return null;
        }
    }

    private InputStream g(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f51378c.b(5, null);
            }
            return null;
        }
    }

    private DexProfileData[] i(InputStream inputStream) {
        try {
            try {
                try {
                    DexProfileData[] dexProfileDataArrX = ProfileTranscoder.x(inputStream, ProfileTranscoder.p(inputStream, ProfileTranscoder.f51406a), this.f51381f);
                    try {
                        inputStream.close();
                        return dexProfileDataArrX;
                    } catch (IOException e3) {
                        this.f51378c.a(7, e3);
                        return dexProfileDataArrX;
                    }
                } catch (IllegalStateException e4) {
                    this.f51378c.a(8, e4);
                    return null;
                }
            } catch (IOException e5) {
                this.f51378c.a(7, e5);
                return null;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException e6) {
                this.f51378c.a(7, e6);
            }
        }
    }

    private static boolean j() {
        return Build.VERSION.SDK_INT >= 31;
    }

    private void k(final int i3, final Object obj) {
        this.f51377b.execute(new Runnable() { // from class: androidx.profileinstaller.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f51430a.f51378c.a(i3, obj);
            }
        });
    }

    public boolean e() {
        if (this.f51379d == null) {
            k(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f51380e.exists()) {
            try {
                if (!this.f51380e.createNewFile()) {
                    k(4, null);
                    return false;
                }
            } catch (IOException unused) {
                k(4, null);
                return false;
            }
        } else if (!this.f51380e.canWrite()) {
            k(4, null);
            return false;
        }
        this.f51384i = true;
        return true;
    }

    public DeviceProfileWriter h() {
        DeviceProfileWriter deviceProfileWriterB;
        c();
        if (this.f51379d != null) {
            InputStream inputStreamF = f(this.f51376a);
            if (inputStreamF != null) {
                this.f51385j = i(inputStreamF);
            }
            DexProfileData[] dexProfileDataArr = this.f51385j;
            if (dexProfileDataArr != null && j() && (deviceProfileWriterB = b(dexProfileDataArr, this.f51379d)) != null) {
                return deviceProfileWriterB;
            }
        }
        return this;
    }

    public DeviceProfileWriter l() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.f51385j;
        byte[] bArr = this.f51379d;
        if (dexProfileDataArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    ProfileTranscoder.F(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e3) {
                this.f51378c.a(7, e3);
            } catch (IllegalStateException e4) {
                this.f51378c.a(8, e4);
            }
            if (!ProfileTranscoder.C(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                this.f51378c.a(5, null);
                this.f51385j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f51386k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f51385j = null;
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean m() {
        byte[] bArr = this.f51386k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f51380e);
                    try {
                        FileChannel channel = fileOutputStream.getChannel();
                        try {
                            FileLock fileLockTryLock = channel.tryLock();
                            try {
                                Encoding.l(byteArrayInputStream, fileOutputStream, fileLockTryLock);
                                k(1, null);
                                if (fileLockTryLock != null) {
                                    fileLockTryLock.close();
                                }
                                channel.close();
                                fileOutputStream.close();
                                byteArrayInputStream.close();
                                return true;
                            } finally {
                            }
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e3) {
                k(6, e3);
                return false;
            } catch (IOException e4) {
                k(7, e4);
                return false;
            }
        } finally {
            this.f51386k = null;
            this.f51385j = null;
        }
    }
}
