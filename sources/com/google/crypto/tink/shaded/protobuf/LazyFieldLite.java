package com.google.crypto.tink.shaded.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class LazyFieldLite {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ExtensionRegistryLite f86986e = ExtensionRegistryLite.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteString f86987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExtensionRegistryLite f86988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile MessageLite f86989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ByteString f86990d;

    protected void a(MessageLite messageLite) {
        if (this.f86989c != null) {
            return;
        }
        synchronized (this) {
            if (this.f86989c != null) {
                return;
            }
            try {
                if (this.f86987a != null) {
                    this.f86989c = (MessageLite) messageLite.h().b(this.f86987a, this.f86988b);
                    this.f86990d = this.f86987a;
                } else {
                    this.f86989c = messageLite;
                    this.f86990d = ByteString.f86695b;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f86989c = messageLite;
                this.f86990d = ByteString.f86695b;
            }
        }
    }

    public int b() {
        if (this.f86990d != null) {
            return this.f86990d.size();
        }
        ByteString byteString = this.f86987a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f86989c != null) {
            return this.f86989c.c();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.f86989c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.f86989c;
        this.f86987a = null;
        this.f86990d = null;
        this.f86989c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.f86990d != null) {
            return this.f86990d;
        }
        ByteString byteString = this.f86987a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f86990d != null) {
                    return this.f86990d;
                }
                if (this.f86989c == null) {
                    this.f86990d = ByteString.f86695b;
                } else {
                    this.f86990d = this.f86989c.b();
                }
                return this.f86990d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazyFieldLite)) {
            return false;
        }
        LazyFieldLite lazyFieldLite = (LazyFieldLite) obj;
        MessageLite messageLite = this.f86989c;
        MessageLite messageLite2 = lazyFieldLite.f86989c;
        return (messageLite == null && messageLite2 == null) ? e().equals(lazyFieldLite.e()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.c(messageLite.g())) : c(messageLite2.g()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
