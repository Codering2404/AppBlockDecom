package cz.mobilesoft.coreblock.scene.more.signin;

import com.facebook.AccessToken;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SignInMethod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SignInMethod[] $VALUES;
    public static final Companion Companion;
    private final int icon;
    private final int title;
    public static final SignInMethod Google = new SignInMethod("Google", 0, R.string.sx, R.drawable.B2);
    public static final SignInMethod Facebook = new SignInMethod("Facebook", 1, R.string.rx, R.drawable.s2);
    public static final SignInMethod Apple = new SignInMethod("Apple", 2, R.string.px, R.drawable.E0);
    public static final SignInMethod Email = new SignInMethod("Email", 3, R.string.qx, R.drawable.E3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignInMethod a(String provider) {
            Intrinsics.checkNotNullParameter(provider, "provider");
            int iHashCode = provider.hashCode();
            if (iHashCode != -1240244679) {
                if (iHashCode != 497130182) {
                    if (iHashCode == 806169336 && provider.equals("apple_authorization_code")) {
                        return SignInMethod.Apple;
                    }
                } else if (provider.equals(AccessToken.DEFAULT_GRAPH_DOMAIN)) {
                    return SignInMethod.Facebook;
                }
            } else if (provider.equals("google")) {
                return SignInMethod.Google;
            }
            return SignInMethod.Email;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SignInMethod[] $values() {
        return new SignInMethod[]{Google, Facebook, Apple, Email};
    }

    static {
        SignInMethod[] signInMethodArr$values = $values();
        $VALUES = signInMethodArr$values;
        $ENTRIES = EnumEntriesKt.a(signInMethodArr$values);
        Companion = new Companion(null);
    }

    private SignInMethod(String str, int i3, int i4, int i5) {
        this.title = i4;
        this.icon = i5;
    }

    public static EnumEntries<SignInMethod> getEntries() {
        return $ENTRIES;
    }

    public static SignInMethod valueOf(String str) {
        return (SignInMethod) Enum.valueOf(SignInMethod.class, str);
    }

    public static SignInMethod[] values() {
        return (SignInMethod[]) $VALUES.clone();
    }

    public final int getIcon() {
        return this.icon;
    }

    public final int getTitle() {
        return this.title;
    }
}
