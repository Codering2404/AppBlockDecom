package com.google.android.gms.fido.u2f.api.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class ClientData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f72707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f72708b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f72709c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ChannelIdValue f72710d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder implements Cloneable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f72711a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f72712b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f72713c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private ChannelIdValue f72714d;

        Builder(String str, String str2, String str3, ChannelIdValue channelIdValue) {
            this.f72711a = str;
            this.f72712b = str2;
            this.f72713c = str3;
            this.f72714d = channelIdValue;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Builder clone() {
            return new Builder(this.f72711a, this.f72712b, this.f72713c, this.f72714d);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientData)) {
            return false;
        }
        ClientData clientData = (ClientData) obj;
        return this.f72707a.equals(clientData.f72707a) && this.f72708b.equals(clientData.f72708b) && this.f72709c.equals(clientData.f72709c) && this.f72710d.equals(clientData.f72710d);
    }

    public int hashCode() {
        return ((((((this.f72707a.hashCode() + 31) * 31) + this.f72708b.hashCode()) * 31) + this.f72709c.hashCode()) * 31) + this.f72710d.hashCode();
    }
}
