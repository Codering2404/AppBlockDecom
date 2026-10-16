package com.facebook.ads.redexgen.core;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.facebook.stetho.dumpapp.Framer;
import com.facebook.stetho.websocket.CloseCodes;
import java.util.Arrays;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class V5 extends Handler {
    public static byte[] A04;
    public static String[] A05 = {"4udqyVbWZXJvSc0AlbflTWwfFOYrDaDf", "2YLZ8zu95yTf3T209", "2VJPb0Yp69Qd6undQokFBSWI7sS3NGkE", "Nq0QHebF7aCImjCS8", "WfWu3jj6ZslW8HMUv7JinXygwhejXyBb", "C4PEiJW5iwJTin2vYgbWRkUl1o", "sWvNSKALPWxj", "lJrPEKSWvzui7DJNo"};
    public static final String A06;
    public final Context A00;
    public final AudienceNetworkRemoteServiceApi.MessageHandler A01;
    public final AudienceNetworkRemoteServiceApi.PackageVerifier A02;
    public final X9 A03;

    public static String A03(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 102);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        byte[] bArr = {-8, -16, -12, -13, -16, -14, -66, -53, -53, -56, -37, -59, -49, -37, -62, -47, -54, -54, -63, -56, -37, -56, -53, -61, -61, -63, -64, -13, -12, -14, -1, -31, -28, -1, -23, -28, -1, -21, -27, -7, 17, Ascii.DC2, Ascii.DLE, Ascii.GS, 0, 19, Ascii.FF, 2, 10, 3, Ascii.GS, 9, 3, Ascii.ETB, -48, -47, -49, -36, -48, -62, -49, -45, -58, -64, -62, -36, -62, -43, -47, -49, -66, -48, Ascii.NAK, Ascii.SYN, Ascii.DC4, Framer.ENTER_FRAME_PREFIX, Ascii.NAK, 7, Ascii.DC4, Ascii.CAN, Ascii.VT, 5, 7, Framer.ENTER_FRAME_PREFIX, Ascii.NAK, 6, Ascii.CR, Framer.ENTER_FRAME_PREFIX, Ascii.CAN, 7, Ascii.DC4, Ascii.NAK, Ascii.VT, 17, Ascii.DLE};
        if (A05[5].length() == 23) {
            throw new RuntimeException();
        }
        A05[5] = "AJ3";
        A04 = bArr;
    }

    static {
        A04();
        A06 = V5.class.getSimpleName();
    }

    public V5(Context context, AudienceNetworkRemoteServiceApi.MessageHandler messageHandler, AudienceNetworkRemoteServiceApi.PackageVerifier packageVerifier) {
        super(Looper.getMainLooper());
        this.A00 = context;
        this.A02 = packageVerifier;
        this.A03 = X9.A00();
        this.A01 = messageHandler;
    }

    public static Bundle A00() {
        Bundle bundle = new Bundle();
        bundle.putString(A03(72, 23, 92), A03(0, 6, 92));
        bundle.putString(A03(54, 18, 23), new JSONObject().toString());
        return bundle;
    }

    private C1762id A01(C1758iY c1758iY, String str) {
        C1762id c1762id = new C1762id(c1758iY, this.A03, str);
        c1762id.A0G(c1758iY.A0B(), c1758iY.A07());
        return c1762id;
    }

    private C1759iZ A02(C1743iI c1743iI, String str) {
        C1759iZ c1759iZ = new C1759iZ(c1743iI, this.A03, str);
        c1759iZ.A0J(c1743iI.A05, c1743iI.A02, c1743iI.A08);
        return c1759iZ;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message msg) throws Throwable {
        String strVerifyPackage;
        if (WU.A02(this)) {
            return;
        }
        try {
            if (this.A01 != null && this.A01.handleMessage(msg)) {
                return;
            }
            Messenger messenger = msg.replyTo;
            if (msg.what == 1) {
                if (messenger != null) {
                    X9.A00().A07(2, null, A00(), messenger);
                    return;
                }
                return;
            }
            String callingAppPackage = msg.getData().getString(A03(27, 13, 58));
            if (callingAppPackage == null) {
                return;
            }
            C1648gi c1648giA05 = C1021Rp.A05(this.A00, callingAppPackage);
            c1648giA05.A0F().AJS(msg.getData().getBoolean(A03(6, 21, 22), false));
            if (this.A02 != null) {
                strVerifyPackage = this.A02.verifyPackage(this.A00, msg, msg.getData().getString(A03(40, 14, 88)));
            } else {
                strVerifyPackage = null;
            }
            if (strVerifyPackage == null) {
                if (messenger != null) {
                    X9.A00().A07(20, callingAppPackage, null, messenger);
                }
                c1648giA05.A0F().AHv();
                return;
            }
            switch (msg.what) {
                case 1010:
                    if (messenger == null) {
                        return;
                    }
                    V2 v2A04 = X9.A00().A04(callingAppPackage);
                    if (v2A04 == null) {
                        v2A04 = X9.A00().A05(callingAppPackage, messenger, strVerifyPackage);
                    }
                    C1758iY intAdModel = OX.A04(c1648giA05, msg.getData(), strVerifyPackage);
                    if (v2A04.A00 == null) {
                        v2A04.A00 = A01(intAdModel, callingAppPackage);
                    } else if (v2A04.A00 instanceof C1762id) {
                        ((C1762id) v2A04.A00).A0G(intAdModel.A0B(), intAdModel.A07());
                    }
                    X9.A00().A07(CloseCodes.UNEXPECTED_CONDITION, callingAppPackage, A00(), messenger);
                    return;
                case 1012:
                case AdError.CACHE_ERROR_CODE /* 2002 */:
                    X9.A00().A08(callingAppPackage);
                    return;
                case AdError.SERVER_ERROR_CODE /* 2000 */:
                    if (messenger == null) {
                        return;
                    }
                    V2 v2A042 = X9.A00().A04(callingAppPackage);
                    if (v2A042 == null) {
                        v2A042 = X9.A00().A05(callingAppPackage, messenger, strVerifyPackage);
                    }
                    C1743iI c1743iIA05 = OX.A05(c1648giA05, msg.getData(), strVerifyPackage);
                    if (v2A042.A00 == null) {
                        v2A042.A00 = A02(c1743iIA05, callingAppPackage);
                    } else if (v2A042.A00 instanceof C1759iZ) {
                        C1759iZ c1759iZ = (C1759iZ) v2A042.A00;
                        String adId = c1743iIA05.A05;
                        c1759iZ.A0J(adId, c1743iIA05.A02, c1743iIA05.A08);
                    }
                    X9.A00().A07(AdError.INTERNAL_ERROR_CODE, callingAppPackage, A00(), messenger);
                    return;
                case AdError.INTERNAL_ERROR_2003 /* 2003 */:
                    OG ogA03 = X9.A00().A03(callingAppPackage);
                    if (ogA03 instanceof C1759iZ) {
                        RewardData rewardDataA01 = OY.A01(msg.getData());
                        C1759iZ c1759iZ2 = (C1759iZ) ogA03;
                        if (rewardDataA01 != null) {
                            c1759iZ2.A0I(rewardDataA01);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            if (A05[5].length() == 23) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[6] = "nIV8RMn07Ah5";
            strArr[1] = "ZacTvu5dUvRq7FGBf";
            WU.A00(th, this);
        }
    }
}
