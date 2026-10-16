package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class FontProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LruCache f34187a = new LruCache(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator f34188b = new Comparator() { // from class: androidx.core.provider.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return FontProvider.a((byte[]) obj, (byte[]) obj2);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ContentQueryWrapper {
        static ContentQueryWrapper a(Context context, Uri uri) {
            return new ContentQueryWrapperApi24Impl(context, uri);
        }

        Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);

        void close();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f34189a;

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f34189a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e3) {
                Log.w("FontsProvider", "Unable to query the content provider", e3);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = this.f34189a;
            if (contentProviderClient != null) {
                contentProviderClient.release();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentProviderClient f34190a;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.f34190a = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor b(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            ContentProviderClient contentProviderClient = this.f34190a;
            if (contentProviderClient == null) {
                return null;
            }
            try {
                return contentProviderClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
            } catch (RemoteException e3) {
                Log.w("FontsProvider", "Unable to query the content provider", e3);
                return null;
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            ContentProviderClient contentProviderClient = this.f34190a;
            if (contentProviderClient != null) {
                contentProviderClient.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ProviderCacheKey {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f34191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f34192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        List f34193c;

        ProviderCacheKey(String str, String str2, List list) {
            this.f34191a = str;
            this.f34192b = str2;
            this.f34193c = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProviderCacheKey)) {
                return false;
            }
            ProviderCacheKey providerCacheKey = (ProviderCacheKey) obj;
            return Objects.equals(this.f34191a, providerCacheKey.f34191a) && Objects.equals(this.f34192b, providerCacheKey.f34192b) && Objects.equals(this.f34193c, providerCacheKey.f34193c);
        }

        public int hashCode() {
            return Objects.hash(this.f34191a, this.f34192b, this.f34193c);
        }
    }

    public static /* synthetic */ int a(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b3 = bArr[i3];
            byte b4 = bArr2[i3];
            if (b3 != b4) {
                return b3 - b4;
            }
        }
        return 0;
    }

    private static List b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean c(List list, List list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!Arrays.equals((byte[]) list.get(i3), (byte[]) list2.get(i3))) {
                return false;
            }
        }
        return true;
    }

    private static List d(FontRequest fontRequest, Resources resources) {
        return fontRequest.b() != null ? fontRequest.b() : FontResourcesParserCompat.c(resources, fontRequest.c());
    }

    static FontsContractCompat.FontFamilyResult e(Context context, List list, CancellationSignal cancellationSignal) {
        Trace.a("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                FontRequest fontRequest = (FontRequest) list.get(i3);
                ProviderInfo providerInfoF = f(context.getPackageManager(), fontRequest, context.getResources());
                if (providerInfoF == null) {
                    return FontsContractCompat.FontFamilyResult.b(1, null);
                }
                arrayList.add(g(context, fontRequest, providerInfoF.authority, cancellationSignal));
            }
            return FontsContractCompat.FontFamilyResult.a(0, arrayList);
        } finally {
            Trace.b();
        }
    }

    static ProviderInfo f(PackageManager packageManager, FontRequest fontRequest, Resources resources) {
        Trace.a("FontProvider.getProvider");
        try {
            List listD = d(fontRequest, resources);
            ProviderCacheKey providerCacheKey = new ProviderCacheKey(fontRequest.e(), fontRequest.f(), listD);
            ProviderInfo providerInfo = (ProviderInfo) f34187a.get(providerCacheKey);
            if (providerInfo != null) {
                return providerInfo;
            }
            String strE = fontRequest.e();
            ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
            if (providerInfoResolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
            }
            if (!providerInfoResolveContentProvider.packageName.equals(fontRequest.f())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + fontRequest.f());
            }
            List listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
            Collections.sort(listB, f34188b);
            for (int i3 = 0; i3 < listD.size(); i3++) {
                ArrayList arrayList = new ArrayList((Collection) listD.get(i3));
                Collections.sort(arrayList, f34188b);
                if (c(listB, arrayList)) {
                    f34187a.put(providerCacheKey, providerInfoResolveContentProvider);
                    return providerInfoResolveContentProvider;
                }
            }
            Trace.b();
            return null;
        } finally {
            Trace.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e1  */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v2, types: [androidx.core.provider.FontProvider$ContentQueryWrapper] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static androidx.core.provider.FontsContractCompat.FontInfo[] g(android.content.Context r16, androidx.core.provider.FontRequest r17, java.lang.String r18, android.os.CancellationSignal r19) {
        /*
            Method dump skipped, instruction units count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.provider.FontProvider.g(android.content.Context, androidx.core.provider.FontRequest, java.lang.String, android.os.CancellationSignal):androidx.core.provider.FontsContractCompat$FontInfo[]");
    }
}
