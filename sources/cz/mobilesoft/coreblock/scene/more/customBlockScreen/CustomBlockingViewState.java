package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import java.util.Iterator;
import java.util.List;
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
public final class CustomBlockingViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumState f107116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f107117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f107118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f107119d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f107120f;

    public CustomBlockingViewState(PremiumState premiumState, List customBlockingScreenConfigs, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(customBlockingScreenConfigs, "customBlockingScreenConfigs");
        this.f107116a = premiumState;
        this.f107117b = customBlockingScreenConfigs;
        this.f107118c = str;
        this.f107119d = z2;
        this.f107120f = z3;
    }

    public static /* synthetic */ CustomBlockingViewState b(CustomBlockingViewState customBlockingViewState, PremiumState premiumState, List list, String str, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            premiumState = customBlockingViewState.f107116a;
        }
        if ((i3 & 2) != 0) {
            list = customBlockingViewState.f107117b;
        }
        if ((i3 & 4) != 0) {
            str = customBlockingViewState.f107118c;
        }
        if ((i3 & 8) != 0) {
            z2 = customBlockingViewState.f107119d;
        }
        if ((i3 & 16) != 0) {
            z3 = customBlockingViewState.f107120f;
        }
        boolean z4 = z3;
        String str2 = str;
        return customBlockingViewState.a(premiumState, list, str2, z2, z4);
    }

    public final CustomBlockingViewState a(PremiumState premiumState, List customBlockingScreenConfigs, String str, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        Intrinsics.checkNotNullParameter(customBlockingScreenConfigs, "customBlockingScreenConfigs");
        return new CustomBlockingViewState(premiumState, customBlockingScreenConfigs, str, z2, z3);
    }

    public final List c() {
        return this.f107117b;
    }

    public final int d() {
        CustomBlockingScreenConfigEntity customBlockingScreenConfigEntityF;
        if (!this.f107120f || (customBlockingScreenConfigEntityF = f()) == null) {
            return 0;
        }
        return customBlockingScreenConfigEntityF.l();
    }

    public final String e() {
        return this.f107118c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomBlockingViewState)) {
            return false;
        }
        CustomBlockingViewState customBlockingViewState = (CustomBlockingViewState) obj;
        return Intrinsics.areEqual(this.f107116a, customBlockingViewState.f107116a) && Intrinsics.areEqual(this.f107117b, customBlockingViewState.f107117b) && Intrinsics.areEqual(this.f107118c, customBlockingViewState.f107118c) && this.f107119d == customBlockingViewState.f107119d && this.f107120f == customBlockingViewState.f107120f;
    }

    public final CustomBlockingScreenConfigEntity f() {
        Object next;
        Iterator it = this.f107117b.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((CustomBlockingScreenConfigEntity) next).i(), this.f107118c)) {
                break;
            }
        }
        return (CustomBlockingScreenConfigEntity) next;
    }

    public final boolean g() {
        return this.f107119d;
    }

    public final boolean h() {
        return this.f107120f;
    }

    public int hashCode() {
        int iHashCode = ((this.f107116a.hashCode() * 31) + this.f107117b.hashCode()) * 31;
        String str = this.f107118c;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.f107119d)) * 31) + Boolean.hashCode(this.f107120f);
    }

    public String toString() {
        return "CustomBlockingViewState(premiumState=" + this.f107116a + ", customBlockingScreenConfigs=" + this.f107117b + ", selectedBlockingScreenConfigId=" + this.f107118c + ", isPremium=" + this.f107119d + ", isStrictModeOn=" + this.f107120f + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ CustomBlockingViewState(cz.mobilesoft.coreblock.enums.PremiumState r2, java.util.List r3, java.lang.String r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.DefaultConstructorMarker r8) {
        /*
            r1 = this;
            r8 = r7 & 1
            if (r8 == 0) goto L6
            cz.mobilesoft.coreblock.enums.PremiumState$None r2 = cz.mobilesoft.coreblock.enums.PremiumState.None.INSTANCE
        L6:
            r8 = r7 & 2
            if (r8 == 0) goto Le
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        Le:
            r8 = r7 & 4
            if (r8 == 0) goto L13
            r4 = 0
        L13:
            r8 = r7 & 8
            r0 = 0
            if (r8 == 0) goto L19
            r5 = r0
        L19:
            r7 = r7 & 16
            if (r7 == 0) goto L24
            r8 = r0
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
            goto L2a
        L24:
            r8 = r6
            r7 = r5
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
        L2a:
            r3.<init>(r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewState.<init>(cz.mobilesoft.coreblock.enums.PremiumState, java.util.List, java.lang.String, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
