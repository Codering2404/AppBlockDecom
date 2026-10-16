package cz.mobilesoft.coreblock.scene.premium.host;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallChrome {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RemoteButtonText f113173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f113174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f113175c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f113176d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f113177e;

    public PaywallChrome(RemoteButtonText remoteButtonText, Integer num, Integer num2, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(remoteButtonText, "remoteButtonText");
        this.f113173a = remoteButtonText;
        this.f113174b = num;
        this.f113175c = num2;
        this.f113176d = z2;
        this.f113177e = z3;
    }

    public final Integer a() {
        return this.f113175c;
    }

    public final Integer b() {
        return this.f113174b;
    }

    public final RemoteButtonText c() {
        return this.f113173a;
    }

    public final boolean d() {
        return this.f113177e;
    }

    public final boolean e() {
        return this.f113176d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallChrome)) {
            return false;
        }
        PaywallChrome paywallChrome = (PaywallChrome) obj;
        return this.f113173a == paywallChrome.f113173a && Intrinsics.areEqual(this.f113174b, paywallChrome.f113174b) && Intrinsics.areEqual(this.f113175c, paywallChrome.f113175c) && this.f113176d == paywallChrome.f113176d && this.f113177e == paywallChrome.f113177e;
    }

    public int hashCode() {
        int iHashCode = this.f113173a.hashCode() * 31;
        Integer num = this.f113174b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f113175c;
        return ((((iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Boolean.hashCode(this.f113176d)) * 31) + Boolean.hashCode(this.f113177e);
    }

    public String toString() {
        return "PaywallChrome(remoteButtonText=" + this.f113173a + ", defaultButtonTextId=" + this.f113174b + ", customDrawable=" + this.f113175c + ", showTrialNotIncludedForMonthlyOffer=" + this.f113176d + ", showLoadingEvenWhenInitializing=" + this.f113177e + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PaywallChrome(cz.mobilesoft.coreblock.scene.premium.host.RemoteButtonText r2, java.lang.Integer r3, java.lang.Integer r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            cz.mobilesoft.coreblock.scene.premium.host.RemoteButtonText r2 = cz.mobilesoft.coreblock.scene.premium.host.RemoteButtonText.None
        L6:
            r8 = r7 & 2
            r0 = 0
            if (r8 == 0) goto Lc
            r3 = r0
        Lc:
            r8 = r7 & 4
            if (r8 == 0) goto L11
            r4 = r0
        L11:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L17
            r5 = r0
        L17:
            r7 = r7 & 16
            if (r7 == 0) goto L22
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L28
        L22:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L28:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.host.PaywallChrome.<init>(cz.mobilesoft.coreblock.scene.premium.host.RemoteButtonText, java.lang.Integer, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
