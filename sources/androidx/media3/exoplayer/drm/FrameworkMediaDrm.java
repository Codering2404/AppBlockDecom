package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.common.C;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.extractor.mp4.PsshAtomUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class FrameworkMediaDrm implements ExoMediaDrm {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ExoMediaDrm.Provider f44074d = new ExoMediaDrm.Provider() { // from class: androidx.media3.exoplayer.drm.p
        @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
        public final ExoMediaDrm a(UUID uuid) {
            return FrameworkMediaDrm.o(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f44075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaDrm f44076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f44077c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api31 {
        public static boolean a(MediaDrm mediaDrm, String str, int i3) {
            return mediaDrm.requiresSecureDecoder(str, i3);
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, PlayerId playerId) {
            LogSessionId logSessionIdA = playerId.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            t.a(Assertions.e(mediaDrm.getPlaybackComponent(bArr))).setLogSessionId(logSessionIdA);
        }
    }

    private FrameworkMediaDrm(UUID uuid) {
        Assertions.e(uuid);
        Assertions.b(!C.f40542b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f44075a = uuid;
        MediaDrm mediaDrm = new MediaDrm(v(uuid));
        this.f44076b = mediaDrm;
        this.f44077c = 1;
        if (C.f40544d.equals(uuid) && C()) {
            y(mediaDrm);
        }
    }

    private static DrmInitData.SchemeData A(UUID uuid, List list) {
        if (!C.f40544d.equals(uuid)) {
            return (DrmInitData.SchemeData) list.get(0);
        }
        if (Util.f41609a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) list.get(0);
            int length = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) list.get(i3);
                byte[] bArr = (byte[]) Assertions.e(schemeData2.f40589f);
                if (Objects.equals(schemeData2.f40588d, schemeData.f40588d) && Objects.equals(schemeData2.f40587c, schemeData.f40587c) && PsshAtomUtil.c(bArr)) {
                    length += bArr.length;
                }
            }
            byte[] bArr2 = new byte[length];
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                byte[] bArr3 = (byte[]) Assertions.e(((DrmInitData.SchemeData) list.get(i5)).f40589f);
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i4, length2);
                i4 += length2;
            }
            return schemeData.a(bArr2);
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            DrmInitData.SchemeData schemeData3 = (DrmInitData.SchemeData) list.get(i6);
            int iG = PsshAtomUtil.g((byte[]) Assertions.e(schemeData3.f40589f));
            int i7 = Util.f41609a;
            if ((i7 < 23 && iG == 0) || (i7 >= 23 && iG == 1)) {
                return schemeData3;
            }
        }
        return (DrmInitData.SchemeData) list.get(0);
    }

    private boolean B() {
        if (!this.f44075a.equals(C.f40544d)) {
            return this.f44075a.equals(C.f40543c);
        }
        String strZ = z("version");
        return (strZ.startsWith("v5.") || strZ.startsWith("14.") || strZ.startsWith("15.") || strZ.startsWith("16.0")) ? false : true;
    }

    private static boolean C() {
        return "ASUS_Z00AD".equals(Build.MODEL);
    }

    public static FrameworkMediaDrm D(UUID uuid) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid);
        } catch (UnsupportedSchemeException e3) {
            throw new UnsupportedDrmException(1, e3);
        } catch (Exception e4) {
            throw new UnsupportedDrmException(2, e4);
        }
    }

    public static /* synthetic */ ExoMediaDrm o(UUID uuid) {
        try {
            return D(uuid);
        } catch (UnsupportedDrmException unused) {
            Log.d("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new DummyExoMediaDrm();
        }
    }

    public static /* synthetic */ void p(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener, MediaDrm mediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2) {
        frameworkMediaDrm.getClass();
        onEventListener.a(frameworkMediaDrm, bArr, i3, i4, bArr2);
    }

    private static byte[] q(byte[] bArr) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr);
        int iU = parsableByteArray.u();
        short sW = parsableByteArray.w();
        short sW2 = parsableByteArray.w();
        if (sW != 1 || sW2 != 1) {
            Log.g("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sW3 = parsableByteArray.w();
        Charset charset = StandardCharsets.UTF_16LE;
        String strF = parsableByteArray.F(sW3, charset);
        if (strF.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strF.indexOf("</DATA>");
        if (iIndexOf == -1) {
            Log.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strF.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strF.substring(iIndexOf);
        int i3 = iU + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putShort(sW);
        byteBufferAllocate.putShort(sW2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    private String r(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (Util.f41609a >= 33 && "https://default.url".equals(str)) {
            String strZ = z("version");
            if (Objects.equals(strZ, "1.2") || Objects.equals(strZ, "aidl-1")) {
                return "";
            }
        }
        return str;
    }

    private static byte[] s(UUID uuid, byte[] bArr) {
        return C.f40543c.equals(uuid) ? ClearKeyUtil.a(bArr) : bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] t(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = androidx.media3.common.C.f40545e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = q(r4)
            byte[] r4 = androidx.media3.extractor.mp4.PsshAtomUtil.a(r0, r4)
        L18:
            boolean r1 = w(r3)
            if (r1 == 0) goto L2e
            androidx.media3.extractor.mp4.PsshAtomUtil$PsshAtom r1 = androidx.media3.extractor.mp4.PsshAtomUtil.d(r4)
            if (r1 == 0) goto L2e
            java.util.UUID r4 = androidx.media3.common.C.f40542b
            java.util.UUID[] r2 = r1.f46809d
            byte[] r1 = r1.f46808c
            byte[] r4 = androidx.media3.extractor.mp4.PsshAtomUtil.b(r4, r2, r1)
        L2e:
            int r1 = androidx.media3.common.util.Util.f41609a
            r2 = 23
            if (r1 >= r2) goto L3c
            java.util.UUID r1 = androidx.media3.common.C.f40544d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L6e
        L3c:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L75
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L75
        L6e:
            byte[] r3 = androidx.media3.extractor.mp4.PsshAtomUtil.e(r4, r3)
            if (r3 == 0) goto L75
            return r3
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.FrameworkMediaDrm.t(java.util.UUID, byte[]):byte[]");
    }

    private static String u(UUID uuid, String str) {
        return (Util.f41609a < 26 && C.f40543c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static UUID v(UUID uuid) {
        return w(uuid) ? C.f40542b : uuid;
    }

    private static boolean w(UUID uuid) {
        return Util.f41609a < 27 && Objects.equals(uuid, C.f40543c);
    }

    private static void y(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public synchronized void a() {
        Assertions.g(this.f44077c > 0);
        this.f44077c++;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public Map b(byte[] bArr) {
        return this.f44076b.queryKeyStatus(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public ExoMediaDrm.ProvisionRequest c() {
        MediaDrm.ProvisionRequest provisionRequest = this.f44076b.getProvisionRequest();
        return new ExoMediaDrm.ProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public byte[] d() {
        return this.f44076b.openSession();
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void e(byte[] bArr, byte[] bArr2) {
        this.f44076b.restoreKeys(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void f(byte[] bArr) throws DeniedByServerException {
        this.f44076b.provideProvisionResponse(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public int g() {
        return 2;
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public boolean i(byte[] bArr, String str) throws Throwable {
        MediaCrypto mediaCrypto;
        if (Util.f41609a >= 31 && B()) {
            MediaDrm mediaDrm = this.f44076b;
            return Api31.a(mediaDrm, str, mediaDrm.getSecurityLevel(bArr));
        }
        MediaCrypto mediaCrypto2 = null;
        try {
            try {
                mediaCrypto = new MediaCrypto(v(this.f44075a), bArr);
            } catch (Throwable th) {
                th = th;
            }
        } catch (MediaCryptoException unused) {
        }
        try {
            boolean zRequiresSecureDecoderComponent = mediaCrypto.requiresSecureDecoderComponent(str);
            mediaCrypto.release();
            return zRequiresSecureDecoderComponent;
        } catch (MediaCryptoException unused2) {
            mediaCrypto2 = mediaCrypto;
            boolean z2 = !this.f44075a.equals(C.f40543c);
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            return z2;
        } catch (Throwable th2) {
            th = th2;
            mediaCrypto2 = mediaCrypto;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void j(byte[] bArr) {
        this.f44076b.closeSession(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public byte[] k(byte[] bArr, byte[] bArr2) {
        if (C.f40543c.equals(this.f44075a)) {
            bArr2 = ClearKeyUtil.b(bArr2);
        }
        return this.f44076b.provideKeyResponse(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void l(final ExoMediaDrm.OnEventListener onEventListener) {
        this.f44076b.setOnEventListener(onEventListener == null ? null : new MediaDrm.OnEventListener() { // from class: androidx.media3.exoplayer.drm.q
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2) {
                FrameworkMediaDrm.p(this.f44111a, onEventListener, mediaDrm, bArr, i3, i4, bArr2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public ExoMediaDrm.KeyRequest m(byte[] bArr, List list, int i3, HashMap map) throws NotProvisionedException {
        DrmInitData.SchemeData schemeDataA;
        byte[] bArrT;
        String strU;
        if (list != null) {
            schemeDataA = A(this.f44075a, list);
            bArrT = t(this.f44075a, (byte[]) Assertions.e(schemeDataA.f40589f));
            strU = u(this.f44075a, schemeDataA.f40588d);
        } else {
            schemeDataA = null;
            bArrT = null;
            strU = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f44076b.getKeyRequest(bArr, bArrT, strU, i3, map);
        byte[] bArrS = s(this.f44075a, keyRequest.getData());
        String strR = r(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(strR) && schemeDataA != null && !TextUtils.isEmpty(schemeDataA.f40587c)) {
            strR = schemeDataA.f40587c;
        }
        return new ExoMediaDrm.KeyRequest(bArrS, strR, Util.f41609a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public void n(byte[] bArr, PlayerId playerId) {
        if (Util.f41609a >= 31) {
            try {
                Api31.b(this.f44076b, bArr, playerId);
            } catch (UnsupportedOperationException unused) {
                Log.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    public synchronized void release() {
        int i3 = this.f44077c - 1;
        this.f44077c = i3;
        if (i3 == 0) {
            this.f44076b.release();
        }
    }

    @Override // androidx.media3.exoplayer.drm.ExoMediaDrm
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public FrameworkCryptoConfig h(byte[] bArr) {
        return new FrameworkCryptoConfig(v(this.f44075a), bArr);
    }

    public String z(String str) {
        return this.f44076b.getPropertyString(str);
    }
}
