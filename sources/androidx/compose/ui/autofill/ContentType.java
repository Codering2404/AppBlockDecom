package androidx.compose.ui.autofill;

import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.sdk.AppLovinEventParameters;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface ContentType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f25257a = Companion.f25258a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f25258a = new Companion();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final ContentType f25259b = ContentType_androidKt.a(AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final ContentType f25260c = ContentType_androidKt.a("password");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final ContentType f25261d = ContentType_androidKt.a("emailAddress");

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final ContentType f25262e = ContentType_androidKt.a("newUsername");

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final ContentType f25263f = ContentType_androidKt.a("newPassword");

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final ContentType f25264g = ContentType_androidKt.a("postalAddress");

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final ContentType f25265h = ContentType_androidKt.a("postalCode");

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final ContentType f25266i = ContentType_androidKt.a("creditCardNumber");

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private static final ContentType f25267j = ContentType_androidKt.a("creditCardSecurityCode");

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final ContentType f25268k = ContentType_androidKt.a("creditCardExpirationDate");

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private static final ContentType f25269l = ContentType_androidKt.a("creditCardExpirationMonth");

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final ContentType f25270m = ContentType_androidKt.a("creditCardExpirationYear");

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final ContentType f25271n = ContentType_androidKt.a("creditCardExpirationDay");

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private static final ContentType f25272o = ContentType_androidKt.a("addressCountry");

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private static final ContentType f25273p = ContentType_androidKt.a("addressRegion");

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private static final ContentType f25274q = ContentType_androidKt.a("addressLocality");

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private static final ContentType f25275r = ContentType_androidKt.a("streetAddress");

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private static final ContentType f25276s = ContentType_androidKt.a("extendedAddress");

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final ContentType f25277t = ContentType_androidKt.a("extendedPostalCode");

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final ContentType f25278u = ContentType_androidKt.a("personName");

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private static final ContentType f25279v = ContentType_androidKt.a("personGivenName");

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private static final ContentType f25280w = ContentType_androidKt.a("personFamilyName");

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private static final ContentType f25281x = ContentType_androidKt.a("personMiddleName");

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private static final ContentType f25282y = ContentType_androidKt.a("personMiddleInitial");

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private static final ContentType f25283z = ContentType_androidKt.a("personNamePrefix");
        private static final ContentType A = ContentType_androidKt.a("personNameSuffix");
        private static final ContentType B = ContentType_androidKt.a(oUcQRqOVfOC.AATUy);
        private static final ContentType C = ContentType_androidKt.a("phoneNumberDevice");
        private static final ContentType D = ContentType_androidKt.a("phoneCountryCode");
        private static final ContentType E = ContentType_androidKt.a("phoneNational");
        private static final ContentType F = ContentType_androidKt.a("gender");
        private static final ContentType G = ContentType_androidKt.a("birthDateFull");
        private static final ContentType H = ContentType_androidKt.a("birthDateDay");
        private static final ContentType I = ContentType_androidKt.a("birthDateMonth");
        private static final ContentType J = ContentType_androidKt.a("birthDateYear");
        private static final ContentType K = ContentType_androidKt.a("smsOTPCode");

        private Companion() {
        }

        public final ContentType a() {
            return f25260c;
        }
    }
}
