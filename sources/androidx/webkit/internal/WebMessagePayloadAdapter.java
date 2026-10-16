package androidx.webkit.internal;

import java.util.Objects;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebMessagePayloadAdapter implements WebMessagePayloadBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f53949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f53950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f53951c;

    public WebMessagePayloadAdapter(String str) {
        this.f53949a = 0;
        this.f53950b = str;
        this.f53951c = null;
    }

    private void a(int i3) {
        if (this.f53949a == i3) {
            return;
        }
        throw new IllegalStateException("Expected " + i3 + ", but type is " + this.f53949a);
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public byte[] getAsArrayBuffer() {
        a(1);
        byte[] bArr = this.f53951c;
        Objects.requireNonNull(bArr);
        return bArr;
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public String getAsString() {
        a(0);
        return this.f53950b;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[0];
    }

    @Override // org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface
    public int getType() {
        return this.f53949a;
    }

    public WebMessagePayloadAdapter(byte[] bArr) {
        this.f53949a = 1;
        this.f53950b = null;
        this.f53951c = bArr;
    }
}
