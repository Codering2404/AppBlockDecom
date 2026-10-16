package androidx.credentials.provider;

import android.app.slice.Slice;
import android.app.slice.SliceSpec;
import android.os.Build;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class CredentialEntry {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f35307g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f35308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BeginGetCredentialOption f35309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CharSequence f35310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f35311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CharSequence f35312e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final BiometricPromptData f35313f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Api28Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api28Impl f35314a = new Api28Impl();

        private Api28Impl() {
        }

        public static final CredentialEntry a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            try {
                SliceSpec spec = slice.getSpec();
                String type = spec != null ? spec.getType() : null;
                if (Intrinsics.areEqual(type, "android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                    PasswordCredentialEntry passwordCredentialEntryA = PasswordCredentialEntry.f35339r.a(slice);
                    Intrinsics.checkNotNull(passwordCredentialEntryA);
                    return passwordCredentialEntryA;
                }
                if (Intrinsics.areEqual(type, "androidx.credentials.TYPE_PUBLIC_KEY_CREDENTIAL")) {
                    PublicKeyCredentialEntry publicKeyCredentialEntryA = PublicKeyCredentialEntry.f35361r.a(slice);
                    Intrinsics.checkNotNull(publicKeyCredentialEntryA);
                    return publicKeyCredentialEntryA;
                }
                CustomCredentialEntry customCredentialEntryA = CustomCredentialEntry.f35324s.a(slice);
                Intrinsics.checkNotNull(customCredentialEntryA);
                return customCredentialEntryA;
            } catch (Exception unused) {
                return CustomCredentialEntry.f35324s.a(slice);
            }
        }

        public static final Slice b(CredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (entry instanceof PasswordCredentialEntry) {
                return PasswordCredentialEntry.f35339r.b((PasswordCredentialEntry) entry);
            }
            if (entry instanceof PublicKeyCredentialEntry) {
                return PublicKeyCredentialEntry.f35361r.b((PublicKeyCredentialEntry) entry);
            }
            if (entry instanceof CustomCredentialEntry) {
                return CustomCredentialEntry.f35324s.b((CustomCredentialEntry) entry);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api34Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api34Impl f35315a = new Api34Impl();

        private Api34Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Api35Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api35Impl f35316a = new Api35Impl();

        private Api35Impl() {
        }

        public static final Slice b(CredentialEntry entry) {
            Intrinsics.checkNotNullParameter(entry, "entry");
            if (entry instanceof PasswordCredentialEntry) {
                return PasswordCredentialEntry.f35339r.b((PasswordCredentialEntry) entry);
            }
            if (entry instanceof PublicKeyCredentialEntry) {
                return PublicKeyCredentialEntry.f35361r.b((PublicKeyCredentialEntry) entry);
            }
            if (entry instanceof CustomCredentialEntry) {
                return CustomCredentialEntry.f35324s.b((CustomCredentialEntry) entry);
            }
            return null;
        }

        public static final CredentialEntry a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            try {
                SliceSpec spec = slice.getSpec();
                String type = spec != null ? spec.getType() : null;
                if (Intrinsics.areEqual(type, "android.credentials.TYPE_PASSWORD_CREDENTIAL")) {
                    PasswordCredentialEntry passwordCredentialEntryA = PasswordCredentialEntry.f35339r.a(slice);
                    Intrinsics.checkNotNull(passwordCredentialEntryA);
                    return passwordCredentialEntryA;
                }
                if (Intrinsics.areEqual(type, MrGIhy.mDuqzynyPIPQUO)) {
                    PublicKeyCredentialEntry publicKeyCredentialEntryA = PublicKeyCredentialEntry.f35361r.a(slice);
                    Intrinsics.checkNotNull(publicKeyCredentialEntryA);
                    return publicKeyCredentialEntryA;
                }
                CustomCredentialEntry customCredentialEntryA = CustomCredentialEntry.f35324s.a(slice);
                Intrinsics.checkNotNull(customCredentialEntryA);
                return customCredentialEntryA;
            } catch (Exception unused) {
                return CustomCredentialEntry.f35324s.a(slice);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CredentialEntry a(Slice slice) {
            Intrinsics.checkNotNullParameter(slice, "slice");
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.a(slice) : Api28Impl.a(slice);
        }

        private Companion() {
        }

        public final Slice b(CredentialEntry credentialEntry) {
            Intrinsics.checkNotNullParameter(credentialEntry, YgVrd.NPxVuXmI);
            return Build.VERSION.SDK_INT >= 35 ? Api35Impl.b(credentialEntry) : Api28Impl.b(credentialEntry);
        }
    }

    public CredentialEntry(String type, BeginGetCredentialOption beginGetCredentialOption, CharSequence entryGroupId, boolean z2, CharSequence charSequence, BiometricPromptData biometricPromptData) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(beginGetCredentialOption, "beginGetCredentialOption");
        Intrinsics.checkNotNullParameter(entryGroupId, "entryGroupId");
        this.f35308a = type;
        this.f35309b = beginGetCredentialOption;
        this.f35310c = entryGroupId;
        this.f35311d = z2;
        this.f35312e = charSequence;
        this.f35313f = biometricPromptData;
    }

    public final CharSequence a() {
        return this.f35312e;
    }

    public final BeginGetCredentialOption b() {
        return this.f35309b;
    }

    public final BiometricPromptData c() {
        return this.f35313f;
    }

    public final CharSequence d() {
        return this.f35310c;
    }

    public String e() {
        return this.f35308a;
    }

    public final boolean f() {
        return this.f35311d;
    }
}
