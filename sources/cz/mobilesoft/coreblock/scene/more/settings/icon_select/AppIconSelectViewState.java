package cz.mobilesoft.coreblock.scene.more.settings.icon_select;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.AppIcon;
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
public final class AppIconSelectViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AppIcon f109923a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AppIcon f109924b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f109925c;

    public AppIconSelectViewState(AppIcon currentIcon, AppIcon appIcon, boolean z2) {
        Intrinsics.checkNotNullParameter(currentIcon, "currentIcon");
        this.f109923a = currentIcon;
        this.f109924b = appIcon;
        this.f109925c = z2;
    }

    public static /* synthetic */ AppIconSelectViewState b(AppIconSelectViewState appIconSelectViewState, AppIcon appIcon, AppIcon appIcon2, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            appIcon = appIconSelectViewState.f109923a;
        }
        if ((i3 & 2) != 0) {
            appIcon2 = appIconSelectViewState.f109924b;
        }
        if ((i3 & 4) != 0) {
            z2 = appIconSelectViewState.f109925c;
        }
        return appIconSelectViewState.a(appIcon, appIcon2, z2);
    }

    public final AppIconSelectViewState a(AppIcon currentIcon, AppIcon appIcon, boolean z2) {
        Intrinsics.checkNotNullParameter(currentIcon, "currentIcon");
        return new AppIconSelectViewState(currentIcon, appIcon, z2);
    }

    public final AppIcon c() {
        return this.f109923a;
    }

    public final boolean d() {
        return this.f109925c;
    }

    public final AppIcon e() {
        return this.f109924b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppIconSelectViewState)) {
            return false;
        }
        AppIconSelectViewState appIconSelectViewState = (AppIconSelectViewState) obj;
        return this.f109923a == appIconSelectViewState.f109923a && this.f109924b == appIconSelectViewState.f109924b && this.f109925c == appIconSelectViewState.f109925c;
    }

    public int hashCode() {
        int iHashCode = this.f109923a.hashCode() * 31;
        AppIcon appIcon = this.f109924b;
        return ((iHashCode + (appIcon == null ? 0 : appIcon.hashCode())) * 31) + Boolean.hashCode(this.f109925c);
    }

    public String toString() {
        return "AppIconSelectViewState(currentIcon=" + this.f109923a + ", newIcon=" + this.f109924b + ", hasPremium=" + this.f109925c + ")";
    }

    public /* synthetic */ AppIconSelectViewState(AppIcon appIcon, AppIcon appIcon2, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? AppIcon.Icon1 : appIcon, (i3 & 2) != 0 ? null : appIcon2, (i3 & 4) != 0 ? false : z2);
    }
}
