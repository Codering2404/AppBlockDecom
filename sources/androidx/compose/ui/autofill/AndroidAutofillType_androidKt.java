package androidx.compose.ui.autofill;

import com.applovin.sdk.AppLovinEventParameters;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidAutofillType_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final HashMap f25210a = MapsKt.hashMapOf(TuplesKt.a(AutofillType.f25225a, "emailAddress"), TuplesKt.a(AutofillType.f25226b, AppLovinEventParameters.USER_ACCOUNT_IDENTIFIER), TuplesKt.a(AutofillType.f25227c, "password"), TuplesKt.a(AutofillType.f25228d, "newUsername"), TuplesKt.a(AutofillType.f25229f, "newPassword"), TuplesKt.a(AutofillType.f25230g, "postalAddress"), TuplesKt.a(AutofillType.f25231h, "postalCode"), TuplesKt.a(AutofillType.f25232i, "creditCardNumber"), TuplesKt.a(AutofillType.f25233j, "creditCardSecurityCode"), TuplesKt.a(AutofillType.f25234k, "creditCardExpirationDate"), TuplesKt.a(AutofillType.f25235l, "creditCardExpirationMonth"), TuplesKt.a(AutofillType.f25236m, "creditCardExpirationYear"), TuplesKt.a(AutofillType.f25237n, "creditCardExpirationDay"), TuplesKt.a(AutofillType.f25238o, "addressCountry"), TuplesKt.a(AutofillType.f25239p, "addressRegion"), TuplesKt.a(AutofillType.f25240q, "addressLocality"), TuplesKt.a(AutofillType.f25241r, "streetAddress"), TuplesKt.a(AutofillType.f25242s, "extendedAddress"), TuplesKt.a(AutofillType.f25243t, "extendedPostalCode"), TuplesKt.a(AutofillType.f25244u, "personName"), TuplesKt.a(AutofillType.f25245v, "personGivenName"), TuplesKt.a(AutofillType.f25246w, "personFamilyName"), TuplesKt.a(AutofillType.f25247x, "personMiddleName"), TuplesKt.a(AutofillType.f25248y, "personMiddleInitial"), TuplesKt.a(AutofillType.f25249z, "personNamePrefix"), TuplesKt.a(AutofillType.A, "personNameSuffix"), TuplesKt.a(AutofillType.B, "phoneNumber"), TuplesKt.a(AutofillType.C, "phoneNumberDevice"), TuplesKt.a(AutofillType.D, "phoneCountryCode"), TuplesKt.a(AutofillType.E, "phoneNational"), TuplesKt.a(AutofillType.F, "gender"), TuplesKt.a(AutofillType.G, "birthDateFull"), TuplesKt.a(AutofillType.H, "birthDateDay"), TuplesKt.a(AutofillType.I, "birthDateMonth"), TuplesKt.a(AutofillType.J, "birthDateYear"), TuplesKt.a(AutofillType.K, "smsOTPCode"));

    public static final String a(AutofillType autofillType) {
        String str = (String) f25210a.get(autofillType);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unsupported autofill type");
    }
}
