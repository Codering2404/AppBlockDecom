package androidx.datastore.preferences.protobuf;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LazyFieldLite {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ByteString f36480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ExtensionRegistryLite f36481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected volatile MessageLite f36482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile ByteString f36483d;

    protected void a(MessageLite messageLite) {
        if (this.f36482c != null) {
            return;
        }
        synchronized (this) {
            if (this.f36482c != null) {
                return;
            }
            try {
                if (this.f36480a != null) {
                    this.f36482c = (MessageLite) messageLite.h().a(this.f36480a, this.f36481b);
                    this.f36483d = this.f36480a;
                } else {
                    this.f36482c = messageLite;
                    this.f36483d = ByteString.f36020b;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f36482c = messageLite;
                this.f36483d = ByteString.f36020b;
            }
        }
    }

    public int b() {
        if (this.f36483d != null) {
            return this.f36483d.size();
        }
        ByteString byteString = this.f36480a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f36482c != null) {
            return this.f36482c.c();
        }
        return 0;
    }

    public MessageLite c(MessageLite messageLite) {
        a(messageLite);
        return this.f36482c;
    }

    public MessageLite d(MessageLite messageLite) {
        MessageLite messageLite2 = this.f36482c;
        this.f36480a = null;
        this.f36483d = null;
        this.f36482c = messageLite;
        return messageLite2;
    }

    public ByteString e() {
        if (this.f36483d != null) {
            return this.f36483d;
        }
        ByteString byteString = this.f36480a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f36483d != null) {
                    return this.f36483d;
                }
                if (this.f36482c == null) {
                    this.f36483d = ByteString.f36020b;
                } else {
                    this.f36483d = this.f36482c.b();
                }
                return this.f36483d;
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
        MessageLite messageLite = this.f36482c;
        MessageLite messageLite2 = lazyFieldLite.f36482c;
        return (messageLite == null && messageLite2 == null) ? e().equals(lazyFieldLite.e()) : (messageLite == null || messageLite2 == null) ? messageLite != null ? messageLite.equals(lazyFieldLite.c(messageLite.g())) : c(messageLite2.g()).equals(messageLite2) : messageLite.equals(messageLite2);
    }

    public int hashCode() {
        return 1;
    }
}
