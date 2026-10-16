package androidx.browser.trusted;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.util.Log;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
class PackageIdentityUtils {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Implementation implements SignaturesCompat {
        Api28Implementation() {
        }

        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean a(String str, PackageManager packageManager, TokenContents tokenContents) {
            List listB;
            if (tokenContents.f().equals(str) && (listB = b(str, packageManager)) != null) {
                return listB.size() == 1 ? packageManager.hasSigningCertificate(str, tokenContents.e(0), 1) : tokenContents.equals(TokenContents.c(str, listB));
            }
            return false;
        }

        public List b(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 134217728);
            ArrayList arrayList = new ArrayList();
            SigningInfo signingInfo = packageInfo.signingInfo;
            if (!signingInfo.hasMultipleSigners()) {
                arrayList.add(PackageIdentityUtils.a(signingInfo.getSigningCertificateHistory()[0]));
                return arrayList;
            }
            for (Signature signature : signingInfo.getApkContentsSigners()) {
                arrayList.add(PackageIdentityUtils.a(signature));
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Pre28Implementation implements SignaturesCompat {
        @Override // androidx.browser.trusted.PackageIdentityUtils.SignaturesCompat
        public boolean a(String str, PackageManager packageManager, TokenContents tokenContents) {
            List listB;
            if (str.equals(tokenContents.f()) && (listB = b(str, packageManager)) != null) {
                return tokenContents.equals(TokenContents.c(str, listB));
            }
            return false;
        }

        public List b(String str, PackageManager packageManager) throws PackageManager.NameNotFoundException {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            ArrayList arrayList = new ArrayList(packageInfo.signatures.length);
            for (Signature signature : packageInfo.signatures) {
                byte[] bArrA = PackageIdentityUtils.a(signature);
                if (bArrA == null) {
                    return null;
                }
                arrayList.add(bArrA);
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface SignaturesCompat {
        boolean a(String str, PackageManager packageManager, TokenContents tokenContents);
    }

    static byte[] a(Signature signature) {
        try {
            return MessageDigest.getInstance("SHA256").digest(signature.toByteArray());
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static SignaturesCompat b() {
        return new Api28Implementation();
    }

    static boolean c(String str, PackageManager packageManager, TokenContents tokenContents) {
        try {
            return b().a(str, packageManager, tokenContents);
        } catch (PackageManager.NameNotFoundException | IOException e3) {
            Log.e("PackageIdentity", "Could not check if package matches token.", e3);
            return false;
        }
    }
}
