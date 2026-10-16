package androidx.media3.extractor.metadata.emsg;

import androidx.media3.common.Format;
import androidx.media3.common.Metadata;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class EventMessage implements Metadata.Entry {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Format f46415g = new Format.Builder().u0("application/id3").N();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Format f46416h = new Format.Builder().u0("application/x-scte35").N();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f46417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f46418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f46419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f46420d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final byte[] f46421e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f46422f;

    public EventMessage(String str, String str2, long j3, long j4, byte[] bArr) {
        this.f46417a = str;
        this.f46418b = str2;
        this.f46419c = j3;
        this.f46420d = j4;
        this.f46421e = bArr;
    }

    @Override // androidx.media3.common.Metadata.Entry
    public Format a() {
        String str = this.f46417a;
        str.getClass();
        switch (str) {
            case "urn:scte:scte35:2014:bin":
                return f46416h;
            case "https://aomedia.org/emsg/ID3":
            case "https://developer.apple.com/streaming/emsg-id3":
                return f46415g;
            default:
                return null;
        }
    }

    @Override // androidx.media3.common.Metadata.Entry
    public byte[] c() {
        if (a() != null) {
            return this.f46421e;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && EventMessage.class == obj.getClass()) {
            EventMessage eventMessage = (EventMessage) obj;
            if (this.f46419c == eventMessage.f46419c && this.f46420d == eventMessage.f46420d && Objects.equals(this.f46417a, eventMessage.f46417a) && Objects.equals(this.f46418b, eventMessage.f46418b) && Arrays.equals(this.f46421e, eventMessage.f46421e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f46422f == 0) {
            String str = this.f46417a;
            int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.f46418b;
            int iHashCode2 = str2 != null ? str2.hashCode() : 0;
            long j3 = this.f46419c;
            int i3 = (((iHashCode + iHashCode2) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f46420d;
            this.f46422f = ((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + Arrays.hashCode(this.f46421e);
        }
        return this.f46422f;
    }

    public String toString() {
        return "EMSG: scheme=" + this.f46417a + ", id=" + this.f46420d + ", durationMs=" + this.f46419c + ", value=" + this.f46418b;
    }
}
