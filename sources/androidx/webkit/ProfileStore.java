package androidx.webkit;

import androidx.webkit.internal.ProfileStoreImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface ProfileStore {
    static ProfileStore getInstance() {
        if (WebViewFeatureInternal.f53961c0.d()) {
            return ProfileStoreImpl.getInstance();
        }
        throw WebViewFeatureInternal.a();
    }

    boolean deleteProfile(String str);

    List<String> getAllProfileNames();

    Profile getOrCreateProfile(String str);

    Profile getProfile(String str);
}
