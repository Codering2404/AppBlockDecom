package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.Context;
import cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewState;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallCopy {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f113178e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final PaywallCopy f113179f = new PaywallCopy(new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.g
        @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
        public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
            return PaywallCopy.e(context, premiumScreenViewState);
        }
    }, new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.h
        @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
        public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
            return PaywallCopy.f(context, premiumScreenViewState);
        }
    }, null, null, 12, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PaywallText f113180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final PaywallText f113181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PaywallText f113182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaywallText f113183d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PaywallCopy a() {
            return PaywallCopy.f113179f;
        }

        private Companion() {
        }
    }

    public PaywallCopy(PaywallText title, PaywallText subtitle, PaywallText rcTitle, PaywallText rcSubtitle) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(rcTitle, "rcTitle");
        Intrinsics.checkNotNullParameter(rcSubtitle, "rcSubtitle");
        this.f113180a = title;
        this.f113181b = subtitle;
        this.f113182c = rcTitle;
        this.f113183d = rcSubtitle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String e(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String g(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(Context context, PremiumScreenViewState premiumScreenViewState) {
        Intrinsics.checkNotNullParameter(context, "<unused var>");
        Intrinsics.checkNotNullParameter(premiumScreenViewState, "<unused var>");
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallCopy)) {
            return false;
        }
        PaywallCopy paywallCopy = (PaywallCopy) obj;
        return Intrinsics.areEqual(this.f113180a, paywallCopy.f113180a) && Intrinsics.areEqual(this.f113181b, paywallCopy.f113181b) && Intrinsics.areEqual(this.f113182c, paywallCopy.f113182c) && Intrinsics.areEqual(this.f113183d, paywallCopy.f113183d);
    }

    public int hashCode() {
        return (((((this.f113180a.hashCode() * 31) + this.f113181b.hashCode()) * 31) + this.f113182c.hashCode()) * 31) + this.f113183d.hashCode();
    }

    public final PaywallText j() {
        return this.f113183d;
    }

    public final PaywallText k() {
        return this.f113182c;
    }

    public final PaywallText l() {
        return this.f113181b;
    }

    public final PaywallText m() {
        return this.f113180a;
    }

    public String toString() {
        return "PaywallCopy(title=" + this.f113180a + ", subtitle=" + this.f113181b + ", rcTitle=" + this.f113182c + ", rcSubtitle=" + this.f113183d + ")";
    }

    public /* synthetic */ PaywallCopy(PaywallText paywallText, PaywallText paywallText2, PaywallText paywallText3, PaywallText paywallText4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(paywallText, paywallText2, (i3 & 4) != 0 ? new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.i
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallCopy.g(context, premiumScreenViewState);
            }
        } : paywallText3, (i3 & 8) != 0 ? new PaywallText() { // from class: cz.mobilesoft.coreblock.scene.premium.host.j
            @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallText
            public final String a(Context context, PremiumScreenViewState premiumScreenViewState) {
                return PaywallCopy.h(context, premiumScreenViewState);
            }
        } : paywallText4);
    }
}
