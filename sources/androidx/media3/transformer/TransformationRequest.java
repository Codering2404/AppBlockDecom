package androidx.media3.transformer;

import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.Assertions;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TransformationRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f48470a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f48471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f48472c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f48473d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f48474a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f48475b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f48476c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f48477d;

        public TransformationRequest a() {
            return new TransformationRequest(this.f48474a, this.f48475b, this.f48476c, this.f48477d);
        }

        public Builder b(String str) {
            String strR = MimeTypes.r(str);
            Assertions.b(strR == null || MimeTypes.n(strR), "Not an audio MIME type: " + strR);
            this.f48475b = strR;
            return this;
        }

        public Builder c(int i3) {
            this.f48477d = i3;
            return this;
        }

        Builder d(int i3) {
            this.f48474a = i3;
            return this;
        }

        public Builder e(String str) {
            String strR = MimeTypes.r(str);
            Assertions.b(strR == null || MimeTypes.q(strR), "Not a video MIME type: " + strR);
            this.f48476c = strR;
            return this;
        }

        public Builder() {
            this.f48474a = -1;
        }

        private Builder(TransformationRequest transformationRequest) {
            this.f48474a = transformationRequest.f48470a;
            this.f48475b = transformationRequest.f48471b;
            this.f48476c = transformationRequest.f48472c;
            this.f48477d = transformationRequest.f48473d;
        }
    }

    public Builder a() {
        return new Builder();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TransformationRequest)) {
            return false;
        }
        TransformationRequest transformationRequest = (TransformationRequest) obj;
        return this.f48470a == transformationRequest.f48470a && Objects.equals(this.f48471b, transformationRequest.f48471b) && Objects.equals(this.f48472c, transformationRequest.f48472c) && this.f48473d == transformationRequest.f48473d;
    }

    public int hashCode() {
        int i3 = this.f48470a * 31;
        String str = this.f48471b;
        int iHashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f48472c;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.f48473d;
    }

    public String toString() {
        return "TransformationRequest{outputHeight=" + this.f48470a + ", audioMimeType='" + this.f48471b + "', videoMimeType='" + this.f48472c + "', hdrMode=" + this.f48473d + '}';
    }

    private TransformationRequest(int i3, String str, String str2, int i4) {
        this.f48470a = i3;
        this.f48471b = str;
        this.f48472c = str2;
        this.f48473d = i4;
    }
}
