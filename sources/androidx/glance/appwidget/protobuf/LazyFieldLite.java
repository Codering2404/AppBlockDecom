package androidx.glance.appwidget.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ExtensionRegistryLite f39125e = ExtensionRegistryLite.b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteString f39126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExtensionRegistryLite f39127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile MessageLite f39128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ByteString f39129d;

    protected void a(MessageLite messageLite) {
        if (this.f39128c != null) {
            return;
        }
        synchronized (this) {
            if (this.f39128c != null) {
                return;
            }
            try {
                if (this.f39126a != null) {
                    this.f39128c = (MessageLite) messageLite.h().b(this.f39126a, this.f39127b);
                    this.f39129d = this.f39126a;
                } else {
                    this.f39128c = messageLite;
                    this.f39129d = ByteString.f38830b;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f39128c = messageLite;
                this.f39129d = ByteString.f38830b;
            }
        }
    }

    public int b() {
        if (this.f39129d != null) {
            return this.f39129d.size();
        }
        ByteString byteString = this.f39126a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f39128c != null) {
            return this.f39128c.c();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.f39128c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.f39128c;
        this.f39126a = null;
        this.f39129d = null;
        this.f39128c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.f39129d != null) {
            return this.f39129d;
        }
        ByteString byteString = this.f39126a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f39129d != null) {
                    return this.f39129d;
                }
                if (this.f39128c == null) {
                    this.f39129d = ByteString.f38830b;
                } else {
                    this.f39129d = this.f39128c.b();
                }
                return this.f39129d;
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
        MessageLite messageLite = this.f39128c;
        MessageLite messageLite2 = lazyFieldLite.f39128c;
        return (messageLite == null && messageLite2 == null) ? e().equals(lazyFieldLite.e()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.c(messageLite.g())) : c(messageLite2.g()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
