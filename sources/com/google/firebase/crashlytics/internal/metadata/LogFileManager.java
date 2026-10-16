package com.google.firebase.crashlytics.internal.metadata;

import com.facebook.internal.NativeProtocol;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class LogFileManager {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final NoopLogStore f88519c = new NoopLogStore();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FileStore f88520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private FileLogStore f88521b;

    public LogFileManager(FileStore fileStore) {
        this.f88520a = fileStore;
        this.f88521b = f88519c;
    }

    private File d(String str) {
        return this.f88520a.q(str, "userlog");
    }

    public void a() {
        this.f88521b.d();
    }

    public byte[] b() {
        return this.f88521b.c();
    }

    public String c() {
        return this.f88521b.b();
    }

    public final void e(String str) {
        this.f88521b.a();
        this.f88521b = f88519c;
        if (str == null) {
            return;
        }
        f(d(str), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    void f(File file, int i3) {
        this.f88521b = new QueueFileLogStore(file, i3);
    }

    public void g(long j3, String str) {
        this.f88521b.e(j3, str);
    }

    public LogFileManager(FileStore fileStore, String str) {
        this(fileStore);
        e(str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class NoopLogStore implements FileLogStore {
        private NoopLogStore() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public String b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public byte[] c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void a() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void d() {
        }

        @Override // com.google.firebase.crashlytics.internal.metadata.FileLogStore
        public void e(long j3, String str) {
        }
    }
}
