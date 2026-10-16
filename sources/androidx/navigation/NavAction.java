package androidx.navigation;

import android.os.Bundle;
import androidx.savedstate.SavedStateReader;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f48764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private NavOptions f48765b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Bundle f48766c;

    public NavAction(int i3, NavOptions navOptions, Bundle bundle) {
        this.f48764a = i3;
        this.f48765b = navOptions;
        this.f48766c = bundle;
    }

    public final Bundle a() {
        return this.f48766c;
    }

    public final int b() {
        return this.f48764a;
    }

    public final NavOptions c() {
        return this.f48765b;
    }

    public final void d(Bundle bundle) {
        this.f48766c = bundle;
    }

    public final void e(NavOptions navOptions) {
        this.f48765b = navOptions;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NavAction)) {
            return false;
        }
        NavAction navAction = (NavAction) obj;
        if (this.f48764a != navAction.f48764a || !Intrinsics.areEqual(this.f48765b, navAction.f48765b)) {
            return false;
        }
        Bundle bundle = this.f48766c;
        Bundle bundle2 = navAction.f48766c;
        if (Intrinsics.areEqual(bundle, bundle2)) {
            return true;
        }
        return (bundle == null || bundle2 == null || !SavedStateReader.c(SavedStateReader.a(bundle), bundle2)) ? false : true;
    }

    public int hashCode() {
        int iHashCode = Integer.hashCode(this.f48764a) * 31;
        NavOptions navOptions = this.f48765b;
        int iHashCode2 = iHashCode + (navOptions != null ? navOptions.hashCode() : 0);
        Bundle bundle = this.f48766c;
        return bundle != null ? (iHashCode2 * 31) + SavedStateReader.d(SavedStateReader.a(bundle)) : iHashCode2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NavAction.class.getSimpleName());
        sb.append("(0x");
        sb.append(Integer.toHexString(this.f48764a));
        sb.append(")");
        if (this.f48765b != null) {
            sb.append(" navOptions=");
            sb.append(this.f48765b);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public /* synthetic */ NavAction(int i3, NavOptions navOptions, Bundle bundle, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i4 & 2) != 0 ? null : navOptions, (i4 & 4) != 0 ? null : bundle);
    }
}
