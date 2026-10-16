package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import android.net.Uri;
import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.facebook.stetho.inspector.helper.qp.sKeKFMqmvNzY;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.ViewModelState;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AccountDetailViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f101164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f101165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ViewModelState f101166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f101167d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f101168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ProfileImageState f101169g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class ProfileImageState {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Deleted extends ProfileImageState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final Deleted f101170a = new Deleted();

            private Deleted() {
                super(null);
            }

            @Override // cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState.ProfileImageState
            public boolean a() {
                return true;
            }

            public boolean equals(Object obj) {
                return this == obj || (obj instanceof Deleted);
            }

            public int hashCode() {
                return -1965946601;
            }

            public String toString() {
                return "Deleted";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Local extends ProfileImageState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Uri f101171a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Local(Uri uri) {
                super(null);
                Intrinsics.checkNotNullParameter(uri, "uri");
                this.f101171a = uri;
            }

            @Override // cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState.ProfileImageState
            public boolean a() {
                return false;
            }

            public final Uri b() {
                return this.f101171a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Local) && Intrinsics.areEqual(this.f101171a, ((Local) obj).f101171a);
            }

            public int hashCode() {
                return this.f101171a.hashCode();
            }

            public String toString() {
                return "Local(uri=" + this.f101171a + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Server extends ProfileImageState {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f101172a;

            public Server(String str) {
                super(null);
                this.f101172a = str;
            }

            @Override // cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewState.ProfileImageState
            public boolean a() {
                String str = this.f101172a;
                return str == null || str.length() == 0;
            }

            public final String b() {
                return this.f101172a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof Server) && Intrinsics.areEqual(this.f101172a, ((Server) obj).f101172a);
            }

            public int hashCode() {
                String str = this.f101172a;
                if (str == null) {
                    return 0;
                }
                return str.hashCode();
            }

            public String toString() {
                return SbbqvQlxi.BOpkcjLkyWCj + this.f101172a + ")";
            }
        }

        public /* synthetic */ ProfileImageState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract boolean a();

        private ProfileImageState() {
        }
    }

    public AccountDetailViewState(String email, String str, ViewModelState profileUploadState, boolean z2, boolean z3, ProfileImageState profileImageState) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(profileUploadState, "profileUploadState");
        Intrinsics.checkNotNullParameter(profileImageState, "profileImageState");
        this.f101164a = email;
        this.f101165b = str;
        this.f101166c = profileUploadState;
        this.f101167d = z2;
        this.f101168f = z3;
        this.f101169g = profileImageState;
    }

    public static /* synthetic */ AccountDetailViewState b(AccountDetailViewState accountDetailViewState, String str, String str2, ViewModelState viewModelState, boolean z2, boolean z3, ProfileImageState profileImageState, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = accountDetailViewState.f101164a;
        }
        if ((i3 & 2) != 0) {
            str2 = accountDetailViewState.f101165b;
        }
        if ((i3 & 4) != 0) {
            viewModelState = accountDetailViewState.f101166c;
        }
        if ((i3 & 8) != 0) {
            z2 = accountDetailViewState.f101167d;
        }
        if ((i3 & 16) != 0) {
            z3 = accountDetailViewState.f101168f;
        }
        if ((i3 & 32) != 0) {
            profileImageState = accountDetailViewState.f101169g;
        }
        boolean z4 = z3;
        ProfileImageState profileImageState2 = profileImageState;
        return accountDetailViewState.a(str, str2, viewModelState, z2, z4, profileImageState2);
    }

    public final AccountDetailViewState a(String email, String str, ViewModelState profileUploadState, boolean z2, boolean z3, ProfileImageState profileImageState) {
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(profileUploadState, "profileUploadState");
        Intrinsics.checkNotNullParameter(profileImageState, "profileImageState");
        return new AccountDetailViewState(email, str, profileUploadState, z2, z3, profileImageState);
    }

    public final String c() {
        return this.f101164a;
    }

    public final String d() {
        return this.f101165b;
    }

    public final ProfileImageState e() {
        return this.f101169g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AccountDetailViewState)) {
            return false;
        }
        AccountDetailViewState accountDetailViewState = (AccountDetailViewState) obj;
        return Intrinsics.areEqual(this.f101164a, accountDetailViewState.f101164a) && Intrinsics.areEqual(this.f101165b, accountDetailViewState.f101165b) && Intrinsics.areEqual(this.f101166c, accountDetailViewState.f101166c) && this.f101167d == accountDetailViewState.f101167d && this.f101168f == accountDetailViewState.f101168f && Intrinsics.areEqual(this.f101169g, accountDetailViewState.f101169g);
    }

    public final ViewModelState f() {
        return this.f101166c;
    }

    public final boolean g() {
        return this.f101168f;
    }

    public final boolean h() {
        return this.f101167d;
    }

    public int hashCode() {
        int iHashCode = this.f101164a.hashCode() * 31;
        String str = this.f101165b;
        return ((((((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f101166c.hashCode()) * 31) + Boolean.hashCode(this.f101167d)) * 31) + Boolean.hashCode(this.f101168f)) * 31) + this.f101169g.hashCode();
    }

    public String toString() {
        return "AccountDetailViewState(email=" + this.f101164a + ", nickName=" + this.f101165b + sKeKFMqmvNzY.Omdm + this.f101166c + ", isStrictModeOn=" + this.f101167d + ", isDeletingAccount=" + this.f101168f + ", profileImageState=" + this.f101169g + ")";
    }

    public /* synthetic */ AccountDetailViewState(String str, String str2, ViewModelState viewModelState, boolean z2, boolean z3, ProfileImageState profileImageState, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? null : str2, (i3 & 4) != 0 ? Success.f128020a : viewModelState, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? false : z3, (i3 & 32) != 0 ? new ProfileImageState.Server("") : profileImageState);
    }
}
