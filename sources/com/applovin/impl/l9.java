package com.applovin.impl;

import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Charsets;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.applovin.impl.x6;
import com.applovin.impl.y7;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class l9 implements y7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final y7.c f61168d = new y7.c() { // from class: com.applovin.impl.zy
        @Override // com.applovin.impl.y7.c
        public final y7 a(UUID uuid) {
            return l9.b(uuid);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final UUID f61169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MediaDrm f61170b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f61171c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            return mediaDrm.requiresSecureDecoder(str);
        }
    }

    private l9(UUID uuid) {
        b1.a(uuid);
        b1.a(!t2.f63861b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f61169a = uuid;
        MediaDrm mediaDrm = new MediaDrm(a(uuid));
        this.f61170b = mediaDrm;
        this.f61171c = 1;
        if (t2.f63863d.equals(uuid) && e()) {
            a(mediaDrm);
        }
    }

    private static boolean e() {
        return "ASUS_Z00AD".equals(xp.f65030d);
    }

    @Override // com.applovin.impl.y7
    public y7.d b() {
        MediaDrm.ProvisionRequest provisionRequest = this.f61170b.getProvisionRequest();
        return new y7.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.applovin.impl.y7
    public int c() {
        return 2;
    }

    @Override // com.applovin.impl.y7
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public k9 d(byte[] bArr) {
        return new k9(a(this.f61169a), bArr, xp.f65027a < 21 && t2.f63863d.equals(this.f61169a) && "L3".equals(a("securityLevel")));
    }

    private static void a(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static byte[] e(byte[] bArr) {
        ah ahVar = new ah(bArr);
        int iM = ahVar.m();
        short sO = ahVar.o();
        short sO2 = ahVar.o();
        if (sO != 1 || sO2 != 1) {
            oc.c("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sO3 = ahVar.o();
        Charset charset = Charsets.UTF_16LE;
        String strA = ahVar.a(sO3, charset);
        if (strA.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strA.indexOf(qRMDmh.vAQjC);
        if (iIndexOf == -1) {
            oc.d("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strA.substring(0, iIndexOf) + "<LA_URL>https://x</LA_URL>" + strA.substring(iIndexOf);
        int i3 = iM + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i3);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i3);
        byteBufferAllocate.putShort(sO);
        byteBufferAllocate.putShort(sO2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    @Override // com.applovin.impl.y7
    public void c(byte[] bArr) {
        this.f61170b.closeSession(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ y7 b(UUID uuid) {
        try {
            return c(uuid);
        } catch (sp unused) {
            oc.b("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new f7();
        }
    }

    public static l9 c(UUID uuid) throws sp {
        try {
            return new l9(uuid);
        } catch (UnsupportedSchemeException e3) {
            throw new sp(1, e3);
        } catch (Exception e4) {
            throw new sp(2, e4);
        }
    }

    @Override // com.applovin.impl.y7
    public y7.a a(byte[] bArr, List list, int i3, HashMap map) throws NotProvisionedException {
        x6.b bVarA;
        byte[] bArrB;
        String strA;
        if (list != null) {
            bVarA = a(this.f61169a, list);
            bArrB = b(this.f61169a, (byte[]) b1.a(bVarA.f64866f));
            strA = a(this.f61169a, bVarA.f64865d);
        } else {
            bVarA = null;
            bArrB = null;
            strA = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f61170b.getKeyRequest(bArr, bArrB, strA, i3, map);
        byte[] bArrA = a(this.f61169a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && bVarA != null && !TextUtils.isEmpty(bVarA.f64864c)) {
            defaultUrl = bVarA.f64864c;
        }
        return new y7.a(bArrA, defaultUrl, xp.f65027a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.applovin.impl.y7
    public byte[] d() {
        return this.f61170b.openSession();
    }

    @Override // com.applovin.impl.y7
    public Map b(byte[] bArr) {
        return this.f61170b.queryKeyStatus(bArr);
    }

    @Override // com.applovin.impl.y7
    public byte[] b(byte[] bArr, byte[] bArr2) {
        if (t2.f63862c.equals(this.f61169a)) {
            bArr2 = i3.b(bArr2);
        }
        return this.f61170b.provideKeyResponse(bArr, bArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static byte[] b(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = com.applovin.impl.t2.f63864e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = com.applovin.impl.ji.a(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = e(r4)
            byte[] r4 = com.applovin.impl.ji.a(r0, r4)
        L18:
            int r1 = com.applovin.impl.xp.f65027a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = com.applovin.impl.t2.f63863d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.applovin.impl.xp.f65029c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.applovin.impl.xp.f65030d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = com.applovin.impl.ji.a(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.l9.b(java.util.UUID, byte[]):byte[]");
    }

    public String a(String str) {
        return this.f61170b.getPropertyString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(y7.b bVar, MediaDrm mediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2) {
        bVar.a(this, bArr, i3, i4, bArr2);
    }

    @Override // com.applovin.impl.y7
    public void a(byte[] bArr) throws DeniedByServerException {
        this.f61170b.provideProvisionResponse(bArr);
    }

    @Override // com.applovin.impl.y7
    public synchronized void a() {
        int i3 = this.f61171c - 1;
        this.f61171c = i3;
        if (i3 == 0) {
            this.f61170b.release();
        }
    }

    @Override // com.applovin.impl.y7
    public void a(byte[] bArr, byte[] bArr2) {
        this.f61170b.restoreKeys(bArr, bArr2);
    }

    @Override // com.applovin.impl.y7
    public void a(final y7.b bVar) {
        this.f61170b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.applovin.impl.yy
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i3, int i4, byte[] bArr2) {
                this.f65270a.a(bVar, mediaDrm, bArr, i3, i4, bArr2);
            }
        });
    }

    @Override // com.applovin.impl.y7
    public boolean a(byte[] bArr, String str) {
        if (xp.f65027a >= 31) {
            return a.a(this.f61170b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f61169a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    private static x6.b a(UUID uuid, List list) {
        if (!t2.f63863d.equals(uuid)) {
            return (x6.b) list.get(0);
        }
        if (xp.f65027a >= 28 && list.size() > 1) {
            x6.b bVar = (x6.b) list.get(0);
            int length = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                x6.b bVar2 = (x6.b) list.get(i3);
                byte[] bArr = (byte[]) b1.a(bVar2.f64866f);
                if (xp.a((Object) bVar2.f64865d, (Object) bVar.f64865d) && xp.a((Object) bVar2.f64864c, (Object) bVar.f64864c) && ji.a(bArr)) {
                    length += bArr.length;
                }
            }
            byte[] bArr2 = new byte[length];
            int i4 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                byte[] bArr3 = (byte[]) b1.a(((x6.b) list.get(i5)).f64866f);
                int length2 = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i4, length2);
                i4 += length2;
            }
            return bVar.a(bArr2);
        }
        for (int i6 = 0; i6 < list.size(); i6++) {
            x6.b bVar3 = (x6.b) list.get(i6);
            int iD = ji.d((byte[]) b1.a(bVar3.f64866f));
            int i7 = xp.f65027a;
            if ((i7 < 23 && iD == 0) || (i7 >= 23 && iD == 1)) {
                return bVar3;
            }
        }
        return (x6.b) list.get(0);
    }

    private static UUID a(UUID uuid) {
        return (xp.f65027a >= 27 || !t2.f63862c.equals(uuid)) ? uuid : t2.f63861b;
    }

    private static String a(UUID uuid, String str) {
        return (xp.f65027a < 26 && t2.f63862c.equals(uuid) && ("video/mp4".equals(str) || "audio/mp4".equals(str))) ? "cenc" : str;
    }

    private static byte[] a(UUID uuid, byte[] bArr) {
        return t2.f63862c.equals(uuid) ? i3.a(bArr) : bArr;
    }
}
