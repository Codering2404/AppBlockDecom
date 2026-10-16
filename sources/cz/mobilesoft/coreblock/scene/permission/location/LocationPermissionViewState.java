package cz.mobilesoft.coreblock.scene.permission.location;

import android.content.Context;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.viewholder.StepDTO;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class LocationPermissionViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f111863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f111864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f111865c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f111866d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f111867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f111868g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f111869h;

    public LocationPermissionViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        this.f111863a = z2;
        this.f111864b = z3;
        this.f111865c = z4;
        this.f111866d = z5;
        this.f111867f = z6;
        this.f111868g = z7;
        this.f111869h = z8;
    }

    private final CharSequence a(Context context) {
        CharSequence backgroundPermissionOptionLabel = RunnabilityHelper.f129617a.s() ? context.getPackageManager().getBackgroundPermissionOptionLabel() : context.getString(R.string.F2);
        Intrinsics.checkNotNull(backgroundPermissionOptionLabel);
        return backgroundPermissionOptionLabel;
    }

    public static /* synthetic */ LocationPermissionViewState c(LocationPermissionViewState locationPermissionViewState, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = locationPermissionViewState.f111863a;
        }
        if ((i3 & 2) != 0) {
            z3 = locationPermissionViewState.f111864b;
        }
        if ((i3 & 4) != 0) {
            z4 = locationPermissionViewState.f111865c;
        }
        if ((i3 & 8) != 0) {
            z5 = locationPermissionViewState.f111866d;
        }
        if ((i3 & 16) != 0) {
            z6 = locationPermissionViewState.f111867f;
        }
        if ((i3 & 32) != 0) {
            z7 = locationPermissionViewState.f111868g;
        }
        if ((i3 & 64) != 0) {
            z8 = locationPermissionViewState.f111869h;
        }
        boolean z9 = z7;
        boolean z10 = z8;
        boolean z11 = z6;
        boolean z12 = z4;
        return locationPermissionViewState.b(z2, z3, z12, z5, z11, z9, z10);
    }

    public final LocationPermissionViewState b(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        return new LocationPermissionViewState(z2, z3, z4, z5, z6, z7, z8);
    }

    public final boolean d() {
        return this.f111868g;
    }

    public final boolean e() {
        return this.f111865c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationPermissionViewState)) {
            return false;
        }
        LocationPermissionViewState locationPermissionViewState = (LocationPermissionViewState) obj;
        return this.f111863a == locationPermissionViewState.f111863a && this.f111864b == locationPermissionViewState.f111864b && this.f111865c == locationPermissionViewState.f111865c && this.f111866d == locationPermissionViewState.f111866d && this.f111867f == locationPermissionViewState.f111867f && this.f111868g == locationPermissionViewState.f111868g && this.f111869h == locationPermissionViewState.f111869h;
    }

    public final String f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!this.f111866d) {
            String string = context.getString(R.string.ej);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (!RunnabilityHelper.f129617a.s() || this.f111864b) {
            if (!this.f111865c) {
                String string2 = context.getString(R.string.hj);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                return string2;
            }
            if (this.f111867f) {
                String string3 = context.getString(R.string.O2, a(context));
                Intrinsics.checkNotNull(string3);
                return string3;
            }
            String string4 = context.getString(R.string.M2, a(context));
            Intrinsics.checkNotNull(string4);
            return string4;
        }
        if (this.f111863a) {
            String string5 = context.getString(R.string.ej);
            Intrinsics.checkNotNull(string5);
            return string5;
        }
        if (this.f111867f) {
            String string6 = context.getString(R.string.O2, context.getString(R.string.N2));
            Intrinsics.checkNotNull(string6);
            return string6;
        }
        String string7 = context.getString(R.string.M2, context.getString(R.string.N2));
        Intrinsics.checkNotNull(string7);
        return string7;
    }

    public final boolean g() {
        return this.f111864b;
    }

    public final boolean h() {
        return this.f111863a;
    }

    public int hashCode() {
        return (((((((((((Boolean.hashCode(this.f111863a) * 31) + Boolean.hashCode(this.f111864b)) * 31) + Boolean.hashCode(this.f111865c)) * 31) + Boolean.hashCode(this.f111866d)) * 31) + Boolean.hashCode(this.f111867f)) * 31) + Boolean.hashCode(this.f111868g)) * 31) + Boolean.hashCode(this.f111869h);
    }

    public final List i(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f111866d) {
            if (!RunnabilityHelper.f129617a.s() || this.f111864b || !this.f111863a) {
                return CollectionsKt.emptyList();
            }
            String string = context.getString(R.string.I2, a(context));
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return CollectionsKt.listOf(new StepDTO(1, string));
        }
        List listCreateListBuilder = CollectionsKt.createListBuilder();
        String string2 = context.getString(R.string.P2);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        listCreateListBuilder.add(new StepDTO(1, string2));
        String string3 = context.getString(R.string.H2);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        listCreateListBuilder.add(new StepDTO(2, string3));
        int i3 = 3;
        if (!PermissionHelper.f(context)) {
            String string4 = context.getString(R.string.L2, a(context));
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            listCreateListBuilder.add(new StepDTO(3, string4));
            i3 = 4;
        }
        if (RunnabilityHelper.f129617a.t() && !PermissionHelper.h(context)) {
            String string5 = context.getString(R.string.G2);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            listCreateListBuilder.add(new StepDTO(i3, string5));
        }
        return CollectionsKt.build(listCreateListBuilder);
    }

    public final boolean j() {
        return this.f111866d;
    }

    public final boolean k() {
        return this.f111867f;
    }

    public String toString() {
        return "LocationPermissionViewState(hasFineLocation=" + this.f111863a + ", hasBackgroundLocation=" + this.f111864b + ", areServicesEnabled=" + this.f111865c + ", systemDialogWillShow=" + this.f111866d + ", isForWiFi=" + this.f111867f + ", allowSkippingPermissions=" + this.f111868g + ", isForServices=" + this.f111869h + ")";
    }

    public /* synthetic */ LocationPermissionViewState(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? false : z5, (i3 & 16) != 0 ? false : z6, (i3 & 32) != 0 ? true : z7, (i3 & 64) != 0 ? false : z8);
    }
}
