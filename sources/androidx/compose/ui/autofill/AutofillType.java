package androidx.compose.ui.autofill;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
@Metadata
public final class AutofillType {
    private static final /* synthetic */ AutofillType[] L;
    private static final /* synthetic */ EnumEntries M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AutofillType f25225a = new AutofillType("EmailAddress", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AutofillType f25226b = new AutofillType("Username", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AutofillType f25227c = new AutofillType("Password", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AutofillType f25228d = new AutofillType("NewUsername", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AutofillType f25229f = new AutofillType("NewPassword", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AutofillType f25230g = new AutofillType("PostalAddress", 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AutofillType f25231h = new AutofillType("PostalCode", 6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AutofillType f25232i = new AutofillType("CreditCardNumber", 7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AutofillType f25233j = new AutofillType("CreditCardSecurityCode", 8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AutofillType f25234k = new AutofillType("CreditCardExpirationDate", 9);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AutofillType f25235l = new AutofillType("CreditCardExpirationMonth", 10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AutofillType f25236m = new AutofillType("CreditCardExpirationYear", 11);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AutofillType f25237n = new AutofillType("CreditCardExpirationDay", 12);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final AutofillType f25238o = new AutofillType("AddressCountry", 13);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final AutofillType f25239p = new AutofillType("AddressRegion", 14);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final AutofillType f25240q = new AutofillType("AddressLocality", 15);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final AutofillType f25241r = new AutofillType("AddressStreet", 16);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final AutofillType f25242s = new AutofillType("AddressAuxiliaryDetails", 17);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final AutofillType f25243t = new AutofillType("PostalCodeExtended", 18);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final AutofillType f25244u = new AutofillType("PersonFullName", 19);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final AutofillType f25245v = new AutofillType("PersonFirstName", 20);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final AutofillType f25246w = new AutofillType("PersonLastName", 21);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final AutofillType f25247x = new AutofillType("PersonMiddleName", 22);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final AutofillType f25248y = new AutofillType("PersonMiddleInitial", 23);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final AutofillType f25249z = new AutofillType("PersonNamePrefix", 24);
    public static final AutofillType A = new AutofillType("PersonNameSuffix", 25);
    public static final AutofillType B = new AutofillType("PhoneNumber", 26);
    public static final AutofillType C = new AutofillType("PhoneNumberDevice", 27);
    public static final AutofillType D = new AutofillType("PhoneCountryCode", 28);
    public static final AutofillType E = new AutofillType("PhoneNumberNational", 29);
    public static final AutofillType F = new AutofillType("Gender", 30);
    public static final AutofillType G = new AutofillType("BirthDateFull", 31);
    public static final AutofillType H = new AutofillType("BirthDateDay", 32);
    public static final AutofillType I = new AutofillType("BirthDateMonth", 33);
    public static final AutofillType J = new AutofillType("BirthDateYear", 34);
    public static final AutofillType K = new AutofillType("SmsOtpCode", 35);

    static {
        AutofillType[] autofillTypeArrA = a();
        L = autofillTypeArrA;
        M = EnumEntriesKt.a(autofillTypeArrA);
    }

    private AutofillType(String str, int i3) {
    }

    private static final /* synthetic */ AutofillType[] a() {
        return new AutofillType[]{f25225a, f25226b, f25227c, f25228d, f25229f, f25230g, f25231h, f25232i, f25233j, f25234k, f25235l, f25236m, f25237n, f25238o, f25239p, f25240q, f25241r, f25242s, f25243t, f25244u, f25245v, f25246w, f25247x, f25248y, f25249z, A, B, C, D, E, F, G, H, I, J, K};
    }

    public static AutofillType valueOf(String str) {
        return (AutofillType) Enum.valueOf(AutofillType.class, str);
    }

    public static AutofillType[] values() {
        return (AutofillType[]) L.clone();
    }
}
