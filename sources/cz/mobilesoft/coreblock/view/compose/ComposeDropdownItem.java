package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
public final class ComposeDropdownItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f130457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Color f130458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Color f130459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f130460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Boolean f130461e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Boolean f130462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ImageVector f130463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Modifier f130464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Function0 f130465i;

    public /* synthetic */ ComposeDropdownItem(String str, Color color, Color color2, boolean z2, Boolean bool, Boolean bool2, ImageVector imageVector, Modifier modifier, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, color, color2, z2, bool, bool2, imageVector, modifier, function0);
    }

    public final boolean a() {
        return this.f130460d;
    }

    public final ImageVector b() {
        return this.f130463g;
    }

    public final Color c() {
        return this.f130459c;
    }

    public final Boolean d() {
        return this.f130461e;
    }

    public final Modifier e() {
        return this.f130464h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComposeDropdownItem)) {
            return false;
        }
        ComposeDropdownItem composeDropdownItem = (ComposeDropdownItem) obj;
        return Intrinsics.areEqual(this.f130457a, composeDropdownItem.f130457a) && Intrinsics.areEqual(this.f130458b, composeDropdownItem.f130458b) && Intrinsics.areEqual(this.f130459c, composeDropdownItem.f130459c) && this.f130460d == composeDropdownItem.f130460d && Intrinsics.areEqual(this.f130461e, composeDropdownItem.f130461e) && Intrinsics.areEqual(this.f130462f, composeDropdownItem.f130462f) && Intrinsics.areEqual(this.f130463g, composeDropdownItem.f130463g) && Intrinsics.areEqual(this.f130464h, composeDropdownItem.f130464h) && Intrinsics.areEqual(this.f130465i, composeDropdownItem.f130465i);
    }

    public final Function0 f() {
        return this.f130465i;
    }

    public final String g() {
        return this.f130457a;
    }

    public final Color h() {
        return this.f130458b;
    }

    public int hashCode() {
        int iHashCode = this.f130457a.hashCode() * 31;
        Color color = this.f130458b;
        int iZ = (iHashCode + (color == null ? 0 : Color.z(color.B()))) * 31;
        Color color2 = this.f130459c;
        int iZ2 = (((iZ + (color2 == null ? 0 : Color.z(color2.B()))) * 31) + Boolean.hashCode(this.f130460d)) * 31;
        Boolean bool = this.f130461e;
        int iHashCode2 = (iZ2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f130462f;
        int iHashCode3 = (iHashCode2 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        ImageVector imageVector = this.f130463g;
        return ((((iHashCode3 + (imageVector != null ? imageVector.hashCode() : 0)) * 31) + this.f130464h.hashCode()) * 31) + this.f130465i.hashCode();
    }

    public String toString() {
        return "ComposeDropdownItem(text=" + this.f130457a + ", textColor=" + this.f130458b + ", iconColor=" + this.f130459c + ", enabled=" + this.f130460d + ", lockedByStrictMode=" + this.f130461e + ", lockedByPremium=" + this.f130462f + ", icon=" + this.f130463g + ", modifier=" + this.f130464h + ", onClick=" + this.f130465i + ")";
    }

    private ComposeDropdownItem(String text, Color color, Color color2, boolean z2, Boolean bool, Boolean bool2, ImageVector imageVector, Modifier modifier, Function0 onClick) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        this.f130457a = text;
        this.f130458b = color;
        this.f130459c = color2;
        this.f130460d = z2;
        this.f130461e = bool;
        this.f130462f = bool2;
        this.f130463g = imageVector;
        this.f130464h = modifier;
        this.f130465i = onClick;
    }

    public /* synthetic */ ComposeDropdownItem(String str, Color color, Color color2, boolean z2, Boolean bool, Boolean bool2, ImageVector imageVector, Modifier modifier, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : color, (i3 & 4) != 0 ? null : color2, (i3 & 8) != 0 ? true : z2, (i3 & 16) != 0 ? null : bool, (i3 & 32) != 0 ? null : bool2, (i3 & 64) != 0 ? null : imageVector, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Modifier.b8 : modifier, function0, null);
    }
}
