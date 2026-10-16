package androidx.webkit.internal;

import androidx.webkit.Profile;
import androidx.webkit.ProfileStore;
import java.lang.reflect.InvocationHandler;
import java.util.List;
import org.chromium.support_lib_boundary.ProfileBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ProfileStoreImpl implements ProfileStore {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ProfileStore f53928b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ProfileStoreBoundaryInterface f53929a;

    private ProfileStoreImpl(ProfileStoreBoundaryInterface profileStoreBoundaryInterface) {
        this.f53929a = profileStoreBoundaryInterface;
    }

    public static ProfileStore getInstance() {
        if (f53928b == null) {
            f53928b = new ProfileStoreImpl(WebViewGlueCommunicator.d().getProfileStore());
        }
        return f53928b;
    }

    @Override // androidx.webkit.ProfileStore
    public boolean deleteProfile(String str) {
        if (WebViewFeatureInternal.f53961c0.d()) {
            return this.f53929a.deleteProfile(str);
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public List getAllProfileNames() {
        if (WebViewFeatureInternal.f53961c0.d()) {
            return this.f53929a.getAllProfileNames();
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public Profile getOrCreateProfile(String str) {
        if (WebViewFeatureInternal.f53961c0.d()) {
            return new ProfileImpl((ProfileBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ProfileBoundaryInterface.class, this.f53929a.getOrCreateProfile(str)));
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.ProfileStore
    public Profile getProfile(String str) {
        if (!WebViewFeatureInternal.f53961c0.d()) {
            throw WebViewFeatureInternal.a();
        }
        InvocationHandler profile = this.f53929a.getProfile(str);
        if (profile != null) {
            return new ProfileImpl((ProfileBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ProfileBoundaryInterface.class, profile));
        }
        return null;
    }
}
