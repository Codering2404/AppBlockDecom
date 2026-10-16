package cz.mobilesoft.coreblock.scene.more.settings.notification;

import cz.mobilesoft.coreblock.enums.EmailConsentState;
import cz.mobilesoft.coreblock.enums.PendingEmailConsentState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class NewsletterConsentKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f109947a;

        static {
            int[] iArr = new int[PendingEmailConsentState.values().length];
            try {
                iArr[PendingEmailConsentState.CONSENTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PendingEmailConsentState.REFUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PendingEmailConsentState.NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f109947a = iArr;
        }
    }

    public static final boolean a(EmailConsentState emailConsent, PendingEmailConsentState pendingConsent) {
        Intrinsics.checkNotNullParameter(emailConsent, "emailConsent");
        Intrinsics.checkNotNullParameter(pendingConsent, "pendingConsent");
        int i3 = WhenMappings.f109947a[pendingConsent.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return false;
        }
        if (i3 == 3) {
            return emailConsent instanceof EmailConsentState.CONSENTED;
        }
        throw new NoWhenBranchMatchedException();
    }
}
