package cz.mobilesoft.coreblock.scene.permission.permissions;

import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PermissionsDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f112127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f112128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f112129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f112130d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f112131e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f112132f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f112133g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Boolean f112134h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f112135i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Integer f112136j;

    public PermissionsDTO(List initialPermissions, long j3, int i3, boolean z2, boolean z3, boolean z4, boolean z5, Boolean bool, boolean z6, Integer num) {
        Intrinsics.checkNotNullParameter(initialPermissions, "initialPermissions");
        this.f112127a = initialPermissions;
        this.f112128b = j3;
        this.f112129c = i3;
        this.f112130d = z2;
        this.f112131e = z3;
        this.f112132f = z4;
        this.f112133g = z5;
        this.f112134h = bool;
        this.f112135i = z6;
        this.f112136j = num;
    }

    public static /* synthetic */ PermissionsDTO b(PermissionsDTO permissionsDTO, List list, long j3, int i3, boolean z2, boolean z3, boolean z4, boolean z5, Boolean bool, boolean z6, Integer num, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = permissionsDTO.f112127a;
        }
        if ((i4 & 2) != 0) {
            j3 = permissionsDTO.f112128b;
        }
        if ((i4 & 4) != 0) {
            i3 = permissionsDTO.f112129c;
        }
        if ((i4 & 8) != 0) {
            z2 = permissionsDTO.f112130d;
        }
        if ((i4 & 16) != 0) {
            z3 = permissionsDTO.f112131e;
        }
        if ((i4 & 32) != 0) {
            z4 = permissionsDTO.f112132f;
        }
        if ((i4 & 64) != 0) {
            z5 = permissionsDTO.f112133g;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            bool = permissionsDTO.f112134h;
        }
        if ((i4 & Function.MAX_NARGS) != 0) {
            z6 = permissionsDTO.f112135i;
        }
        if ((i4 & 512) != 0) {
            num = permissionsDTO.f112136j;
        }
        boolean z7 = z6;
        Integer num2 = num;
        boolean z8 = z5;
        Boolean bool2 = bool;
        return permissionsDTO.a(list, j3, i3, z2, z3, z4, z8, bool2, z7, num2);
    }

    public final PermissionsDTO a(List initialPermissions, long j3, int i3, boolean z2, boolean z3, boolean z4, boolean z5, Boolean bool, boolean z6, Integer num) {
        Intrinsics.checkNotNullParameter(initialPermissions, "initialPermissions");
        return new PermissionsDTO(initialPermissions, j3, i3, z2, z3, z4, z5, bool, z6, num);
    }

    public final boolean c() {
        return this.f112131e;
    }

    public final boolean d() {
        return this.f112133g;
    }

    public final List e() {
        return this.f112127a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PermissionsDTO)) {
            return false;
        }
        PermissionsDTO permissionsDTO = (PermissionsDTO) obj;
        return Intrinsics.areEqual(this.f112127a, permissionsDTO.f112127a) && this.f112128b == permissionsDTO.f112128b && this.f112129c == permissionsDTO.f112129c && this.f112130d == permissionsDTO.f112130d && this.f112131e == permissionsDTO.f112131e && this.f112132f == permissionsDTO.f112132f && this.f112133g == permissionsDTO.f112133g && Intrinsics.areEqual(this.f112134h, permissionsDTO.f112134h) && this.f112135i == permissionsDTO.f112135i && Intrinsics.areEqual(this.f112136j, permissionsDTO.f112136j);
    }

    public final Integer f() {
        return this.f112136j;
    }

    public final int g() {
        return this.f112129c;
    }

    public final Boolean h() {
        return this.f112134h;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.f112127a.hashCode() * 31) + Long.hashCode(this.f112128b)) * 31) + Integer.hashCode(this.f112129c)) * 31) + Boolean.hashCode(this.f112130d)) * 31) + Boolean.hashCode(this.f112131e)) * 31) + Boolean.hashCode(this.f112132f)) * 31) + Boolean.hashCode(this.f112133g)) * 31;
        Boolean bool = this.f112134h;
        int iHashCode2 = (((iHashCode + (bool == null ? 0 : bool.hashCode())) * 31) + Boolean.hashCode(this.f112135i)) * 31;
        Integer num = this.f112136j;
        return iHashCode2 + (num != null ? num.hashCode() : 0);
    }

    public final boolean i() {
        return this.f112132f;
    }

    public final boolean j() {
        return this.f112135i;
    }

    public final boolean k() {
        return this.f112130d;
    }

    public String toString() {
        return "PermissionsDTO(initialPermissions=" + this.f112127a + ", profileId=" + this.f112128b + ", typeCombinations=" + this.f112129c + ", isTileService=" + this.f112130d + ", allowSkippingPermissions=" + this.f112131e + ", isProblems=" + this.f112132f + ", allowSuccessAnimation=" + this.f112133g + ", isForWifi=" + this.f112134h + ", isRecursive=" + this.f112135i + ", problemTitleRes=" + this.f112136j + ")";
    }

    public /* synthetic */ PermissionsDTO(List list, long j3, int i3, boolean z2, boolean z3, boolean z4, boolean z5, Boolean bool, boolean z6, Integer num, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, j3, i3, z2, z3, z4, z5, (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? null : bool, (i4 & Function.MAX_NARGS) != 0 ? false : z6, (i4 & 512) != 0 ? null : num);
    }
}
