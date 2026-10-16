package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.common.api.Status;
import com.revenuecat.purchases.common.Constants;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzao {
    public static Status a(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return new Status(17499);
        }
        String[] strArrSplit = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, 2);
        strArrSplit[0] = strArrSplit[0].trim();
        if (strArrSplit.length > 1 && (str2 = strArrSplit[1]) != null) {
            strArrSplit[1] = str2.trim();
        }
        List listAsList = Arrays.asList(strArrSplit);
        return listAsList.size() > 1 ? b((String) listAsList.get(0), (String) listAsList.get(1)) : b((String) listAsList.get(0), null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static Status b(String str, String str2) {
        int i3;
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -2130504259:
                if (str.equals("USER_CANCELLED")) {
                    b3 = 0;
                }
                break;
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    b3 = 1;
                }
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    b3 = 2;
                }
                break;
            case -2005236790:
                if (str.equals("INTERNAL_SUCCESS_SIGN_OUT")) {
                    b3 = 3;
                }
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    b3 = 4;
                }
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    b3 = 5;
                }
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    b3 = 6;
                }
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    b3 = 7;
                }
                break;
            case -1699246888:
                if (str.equals("INVALID_RECAPTCHA_VERSION")) {
                    b3 = 8;
                }
                break;
            case -1603818979:
                if (str.equals("RECAPTCHA_NOT_ENABLED")) {
                    b3 = 9;
                }
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    b3 = 10;
                }
                break;
            case -1584641425:
                if (str.equals("UNAUTHORIZED_DOMAIN")) {
                    b3 = Ascii.VT;
                }
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    b3 = Ascii.FF;
                }
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    b3 = Ascii.CR;
                }
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    b3 = Ascii.SO;
                }
                break;
            case -1368998244:
                if (str.equals("INVALID_HOSTING_LINK_DOMAIN")) {
                    b3 = Ascii.SI;
                }
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    b3 = Ascii.DLE;
                }
                break;
            case -1340100504:
                if (str.equals("INVALID_TENANT_ID")) {
                    b3 = 17;
                }
                break;
            case -1242922234:
                if (str.equals("ALTERNATE_CLIENT_IDENTIFIER_REQUIRED")) {
                    b3 = Ascii.DC2;
                }
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    b3 = 19;
                }
                break;
            case -1202691903:
                if (str.equals("SECOND_FACTOR_EXISTS")) {
                    b3 = Ascii.DC4;
                }
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    b3 = Ascii.NAK;
                }
                break;
            case -1063710844:
                if (str.equals("ADMIN_ONLY_OPERATION")) {
                    b3 = Ascii.SYN;
                }
                break;
            case -974503964:
                if (str.equals("MISSING_OR_INVALID_NONCE")) {
                    b3 = Ascii.ETB;
                }
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    b3 = Ascii.CAN;
                }
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    b3 = Ascii.EM;
                }
                break;
            case -749743758:
                if (str.equals("MFA_ENROLLMENT_NOT_FOUND")) {
                    b3 = Ascii.SUB;
                }
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    b3 = Ascii.ESC;
                }
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    b3 = Ascii.FS;
                }
                break;
            case -595928767:
                if (str.equals("TIMEOUT")) {
                    b3 = Ascii.GS;
                }
                break;
            case -505579581:
                if (str.equals("INVALID_REQ_TYPE")) {
                    b3 = Ascii.RS;
                }
                break;
            case -406804866:
                if (str.equals("INVALID_LOGIN_CREDENTIALS")) {
                    b3 = Ascii.US;
                }
                break;
            case -380728810:
                if (str.equals("INVALID_RECAPTCHA_ACTION")) {
                    b3 = 32;
                }
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    b3 = Framer.ENTER_FRAME_PREFIX;
                }
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    b3 = 34;
                }
                break;
            case -217128228:
                if (str.equals("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                    b3 = 35;
                }
                break;
            case -122667194:
                if (str.equals("MISSING_MFA_ENROLLMENT_ID")) {
                    b3 = 36;
                }
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    b3 = 37;
                }
                break;
            case -52772551:
                if (str.equals("CAPTCHA_CHECK_FAILED")) {
                    b3 = 38;
                }
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    b3 = 39;
                }
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    b3 = 40;
                }
                break;
            case 210308040:
                if (str.equals("UNSUPPORTED_FIRST_FACTOR")) {
                    b3 = 41;
                }
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    b3 = 42;
                }
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    b3 = 43;
                }
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    b3 = 44;
                }
                break;
            case 423563023:
                if (str.equals("MISSING_MFA_PENDING_CREDENTIAL")) {
                    b3 = Framer.STDIN_FRAME_PREFIX;
                }
                break;
            case 429251986:
                if (str.equals("UNSUPPORTED_PASSTHROUGH_OPERATION")) {
                    b3 = 46;
                }
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    b3 = 47;
                }
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    b3 = 48;
                }
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    b3 = Framer.STDOUT_FRAME_PREFIX;
                }
                break;
            case 492515765:
                if (str.equals("MISSING_CLIENT_TYPE")) {
                    b3 = Framer.STDERR_FRAME_PREFIX;
                }
                break;
            case 530628231:
                if (str.equals("MISSING_RECAPTCHA_VERSION")) {
                    b3 = 51;
                }
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    b3 = 52;
                }
                break;
            case 582457886:
                if (str.equals("UNVERIFIED_EMAIL")) {
                    b3 = 53;
                }
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    b3 = 54;
                }
                break;
            case 745638750:
                if (str.equals("INVALID_MFA_PENDING_CREDENTIAL")) {
                    b3 = 55;
                }
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    b3 = 56;
                }
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    b3 = 57;
                }
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    b3 = 58;
                }
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    b3 = 59;
                }
                break;
            case 886186878:
                if (str.equals("REQUIRES_SECOND_FACTOR_AUTH")) {
                    b3 = 60;
                }
                break;
            case 895302372:
                if (str.equals("MISSING_CLIENT_IDENTIFIER")) {
                    b3 = 61;
                }
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    b3 = 62;
                }
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    b3 = 63;
                }
                break;
            case 1034932393:
                if (str.equals("INVALID_PENDING_TOKEN")) {
                    b3 = 64;
                }
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    b3 = 65;
                }
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    b3 = 66;
                }
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    b3 = 67;
                }
                break;
            case 1113992697:
                if (str.equals("INVALID_RECAPTCHA_TOKEN")) {
                    b3 = 68;
                }
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    b3 = 69;
                }
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    b3 = 70;
                }
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    b3 = 71;
                }
                break;
            case 1308491624:
                if (str.equals("MISSING_RECAPTCHA_TOKEN")) {
                    b3 = 72;
                }
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    b3 = 73;
                }
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    b3 = 74;
                }
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    b3 = 75;
                }
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    b3 = 76;
                }
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    b3 = 77;
                }
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    b3 = 78;
                }
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    b3 = 79;
                }
                break;
            case 2063209097:
                if (str.equals("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                    b3 = 80;
                }
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    b3 = 81;
                }
                break;
        }
        switch (b3) {
            case 0:
                i3 = 18001;
                break;
            case 1:
                i3 = 17033;
                break;
            case 2:
                i3 = 17057;
                break;
            case 3:
                i3 = 17091;
                break;
            case 4:
            case 31:
            case 64:
                i3 = 17004;
                break;
            case 5:
                i3 = 17068;
                break;
            case 6:
                i3 = 17052;
                break;
            case 7:
                i3 = 17061;
                break;
            case 8:
                i3 = 17206;
                break;
            case 9:
                i3 = 17200;
                break;
            case 10:
                i3 = 17029;
                break;
            case 11:
                i3 = 17038;
                break;
            case 12:
                i3 = 17030;
                break;
            case 13:
                i3 = 17034;
                break;
            case 14:
                i3 = 17044;
                break;
            case 15:
                i3 = 17214;
                break;
            case 16:
                i3 = 17021;
                break;
            case 17:
                i3 = 17079;
                break;
            case 18:
                i3 = 18002;
                break;
            case 19:
                i3 = 17046;
                break;
            case 20:
                i3 = 17087;
                break;
            case 21:
            case 73:
                i3 = 17008;
                break;
            case 22:
                i3 = 17085;
                break;
            case 23:
                i3 = 17094;
                break;
            case 24:
                i3 = 17064;
                break;
            case 25:
                i3 = 17016;
                break;
            case 26:
                i3 = 17084;
                break;
            case 27:
                i3 = 17035;
                break;
            case 28:
                i3 = 17014;
                break;
            case 29:
            case 67:
                i3 = 17020;
                break;
            case 30:
                i3 = 17207;
                break;
            case 32:
                i3 = 17203;
                break;
            case 33:
            case 52:
                i3 = 17006;
                break;
            case 34:
                i3 = 17062;
                break;
            case 35:
                i3 = 17088;
                break;
            case 36:
                i3 = 17082;
                break;
            case 37:
            case 40:
                i3 = 17011;
                break;
            case 38:
                i3 = 17056;
                break;
            case 39:
                i3 = 17026;
                break;
            case 41:
                i3 = 17089;
                break;
            case 42:
                i3 = 17032;
                break;
            case 43:
                i3 = 17041;
                break;
            case 44:
                i3 = 17074;
                break;
            case 45:
                i3 = 17081;
                break;
            case 46:
                i3 = 17095;
                break;
            case 47:
                i3 = 17007;
                break;
            case 48:
                i3 = 17017;
                break;
            case 49:
                i3 = 17065;
                break;
            case 50:
                i3 = 17204;
                break;
            case 51:
                i3 = 17205;
                break;
            case 53:
                i3 = 17086;
                break;
            case 54:
                i3 = 17075;
                break;
            case 55:
                i3 = 17083;
                break;
            case 56:
                i3 = 17049;
                break;
            case 57:
                i3 = 17071;
                break;
            case 58:
                i3 = 17002;
                break;
            case 59:
                i3 = 17058;
                break;
            case 60:
                i3 = 17078;
                break;
            case 61:
                i3 = 17093;
                break;
            case 62:
                i3 = 17031;
                break;
            case 63:
            case 77:
                i3 = 17010;
                break;
            case 65:
                i3 = 17000;
                break;
            case 66:
                i3 = 17009;
                break;
            case 68:
                i3 = 17202;
                break;
            case 69:
                i3 = 17051;
                break;
            case 70:
                i3 = 17043;
                break;
            case 71:
                i3 = 17025;
                break;
            case 72:
                i3 = 17201;
                break;
            case 74:
                i3 = 17005;
                break;
            case 75:
                i3 = 17042;
                break;
            case 76:
                i3 = 17028;
                break;
            case 78:
                i3 = 17040;
                break;
            case 79:
                i3 = 17045;
                break;
            case 80:
                i3 = 17090;
                break;
            case 81:
                i3 = 17073;
                break;
            default:
                i3 = 17499;
                break;
        }
        if (i3 != 17499) {
            return new Status(i3, str2);
        }
        if (str2 == null) {
            return new Status(i3, str);
        }
        return new Status(i3, str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2);
    }
}
