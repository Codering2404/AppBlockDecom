package cz.mobilesoft.coreblock.scene.permission.permissions;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.base.ViewState;
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
public final class PermissionComposeState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f112014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f112015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f112016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f112017d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f112018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f112019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f112020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Integer f112021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f112022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f112023k;

    public PermissionComposeState(List permissions, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Integer num, boolean z8, boolean z9) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        this.f112014a = permissions;
        this.f112015b = z2;
        this.f112016c = z3;
        this.f112017d = z4;
        this.f112018f = z5;
        this.f112019g = z6;
        this.f112020h = z7;
        this.f112021i = num;
        this.f112022j = z8;
        this.f112023k = z9;
    }

    public static /* synthetic */ PermissionComposeState b(PermissionComposeState permissionComposeState, List list, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Integer num, boolean z8, boolean z9, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = permissionComposeState.f112014a;
        }
        if ((i3 & 2) != 0) {
            z2 = permissionComposeState.f112015b;
        }
        if ((i3 & 4) != 0) {
            z3 = permissionComposeState.f112016c;
        }
        if ((i3 & 8) != 0) {
            z4 = permissionComposeState.f112017d;
        }
        if ((i3 & 16) != 0) {
            z5 = permissionComposeState.f112018f;
        }
        if ((i3 & 32) != 0) {
            z6 = permissionComposeState.f112019g;
        }
        if ((i3 & 64) != 0) {
            z7 = permissionComposeState.f112020h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            num = permissionComposeState.f112021i;
        }
        if ((i3 & Function.MAX_NARGS) != 0) {
            z8 = permissionComposeState.f112022j;
        }
        if ((i3 & 512) != 0) {
            z9 = permissionComposeState.f112023k;
        }
        boolean z10 = z8;
        boolean z11 = z9;
        boolean z12 = z7;
        Integer num2 = num;
        boolean z13 = z5;
        boolean z14 = z6;
        return permissionComposeState.a(list, z2, z3, z4, z13, z14, z12, num2, z10, z11);
    }

    public final PermissionComposeState a(List permissions, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, Integer num, boolean z8, boolean z9) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        return new PermissionComposeState(permissions, z2, z3, z4, z5, z6, z7, num, z8, z9);
    }

    public final boolean c() {
        return this.f112017d;
    }

    public final List d() {
        return this.f112014a;
    }

    public final Integer e() {
        return this.f112021i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionComposeState)) {
            return false;
        }
        PermissionComposeState permissionComposeState = (PermissionComposeState) obj;
        return Intrinsics.areEqual(this.f112014a, permissionComposeState.f112014a) && this.f112015b == permissionComposeState.f112015b && this.f112016c == permissionComposeState.f112016c && this.f112017d == permissionComposeState.f112017d && this.f112018f == permissionComposeState.f112018f && this.f112019g == permissionComposeState.f112019g && this.f112020h == permissionComposeState.f112020h && Intrinsics.areEqual(this.f112021i, permissionComposeState.f112021i) && this.f112022j == permissionComposeState.f112022j && this.f112023k == permissionComposeState.f112023k;
    }

    public final boolean f() {
        return this.f112019g;
    }

    public final boolean g() {
        return this.f112023k;
    }

    public final boolean h() {
        return this.f112020h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.f112014a.hashCode() * 31) + Boolean.hashCode(this.f112015b)) * 31) + Boolean.hashCode(this.f112016c)) * 31) + Boolean.hashCode(this.f112017d)) * 31) + Boolean.hashCode(this.f112018f)) * 31) + Boolean.hashCode(this.f112019g)) * 31) + Boolean.hashCode(this.f112020h)) * 31;
        Integer num = this.f112021i;
        return ((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.f112022j)) * 31) + Boolean.hashCode(this.f112023k);
    }

    public final boolean i() {
        return this.f112022j;
    }

    public final boolean j() {
        return this.f112015b;
    }

    public final boolean k() {
        return this.f112018f;
    }

    public String toString() {
        return "PermissionComposeState(permissions=" + this.f112014a + ", isLoading=" + this.f112015b + ", showPrivacyExplanation=" + this.f112016c + ", allowSkipping=" + this.f112017d + ", isProblems=" + this.f112018f + ", showAccessibilityDisclaimer=" + this.f112019g + ", showSuccess=" + this.f112020h + ", problemTitleRes=" + this.f112021i + ", isAdvancedProtectionBlockingAccessibility=" + this.f112022j + ", showAdvancedProtectionSteps=" + this.f112023k + ")";
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PermissionComposeState(java.util.List r2, boolean r3, boolean r4, boolean r5, boolean r6, boolean r7, boolean r8, java.lang.Integer r9, boolean r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r1 = this;
            r13 = r12 & 1
            if (r13 == 0) goto L8
            java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
        L8:
            r13 = r12 & 2
            if (r13 == 0) goto Ld
            r3 = 1
        Ld:
            r13 = r12 & 4
            r0 = 0
            if (r13 == 0) goto L13
            r4 = r0
        L13:
            r13 = r12 & 8
            if (r13 == 0) goto L18
            r5 = r0
        L18:
            r13 = r12 & 16
            if (r13 == 0) goto L1d
            r6 = r0
        L1d:
            r13 = r12 & 32
            if (r13 == 0) goto L22
            r7 = r0
        L22:
            r13 = r12 & 64
            if (r13 == 0) goto L27
            r8 = r0
        L27:
            r13 = r12 & 128(0x80, float:1.8E-43)
            if (r13 == 0) goto L2c
            r9 = 0
        L2c:
            r13 = r12 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L31
            r10 = r0
        L31:
            r12 = r12 & 512(0x200, float:7.17E-43)
            if (r12 == 0) goto L41
            r13 = r0
            r11 = r9
            r12 = r10
            r9 = r7
            r10 = r8
            r7 = r5
            r8 = r6
            r5 = r3
            r6 = r4
            r3 = r1
            r4 = r2
            goto L4c
        L41:
            r13 = r11
            r12 = r10
            r10 = r8
            r11 = r9
            r8 = r6
            r9 = r7
            r6 = r4
            r7 = r5
            r4 = r2
            r5 = r3
            r3 = r1
        L4c:
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.permission.permissions.PermissionComposeState.<init>(java.util.List, boolean, boolean, boolean, boolean, boolean, boolean, java.lang.Integer, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
