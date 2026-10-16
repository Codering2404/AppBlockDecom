package cz.mobilesoft.coreblock.scene.intro;

import com.bumptech.glide.load.data.Bwyd.SbbqvQlxi;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.base.ViewState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.ImmutableSet;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class OnboardingViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImmutableSet f104589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Integer f104590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f104591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f104592d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f104593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f104594g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f104595h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f104596i;

    public OnboardingViewState(ImmutableSet selectedHelpItems, Integer num, Integer num2, long j3, long j4, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(selectedHelpItems, "selectedHelpItems");
        this.f104589a = selectedHelpItems;
        this.f104590b = num;
        this.f104591c = num2;
        this.f104592d = j3;
        this.f104593f = j4;
        this.f104594g = z2;
        this.f104595h = z3;
        this.f104596i = z4;
    }

    public static /* synthetic */ OnboardingViewState b(OnboardingViewState onboardingViewState, ImmutableSet immutableSet, Integer num, Integer num2, long j3, long j4, boolean z2, boolean z3, boolean z4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            immutableSet = onboardingViewState.f104589a;
        }
        if ((i3 & 2) != 0) {
            num = onboardingViewState.f104590b;
        }
        if ((i3 & 4) != 0) {
            num2 = onboardingViewState.f104591c;
        }
        if ((i3 & 8) != 0) {
            j3 = onboardingViewState.f104592d;
        }
        if ((i3 & 16) != 0) {
            j4 = onboardingViewState.f104593f;
        }
        if ((i3 & 32) != 0) {
            z2 = onboardingViewState.f104594g;
        }
        if ((i3 & 64) != 0) {
            z3 = onboardingViewState.f104595h;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z4 = onboardingViewState.f104596i;
        }
        boolean z5 = z4;
        boolean z6 = z2;
        long j5 = j4;
        long j6 = j3;
        Integer num3 = num2;
        return onboardingViewState.a(immutableSet, num, num3, j6, j5, z6, z3, z5);
    }

    public final OnboardingViewState a(ImmutableSet selectedHelpItems, Integer num, Integer num2, long j3, long j4, boolean z2, boolean z3, boolean z4) {
        Intrinsics.checkNotNullParameter(selectedHelpItems, "selectedHelpItems");
        return new OnboardingViewState(selectedHelpItems, num, num2, j3, j4, z2, z3, z4);
    }

    public final long c() {
        return this.f104592d;
    }

    public final long d() {
        return this.f104593f;
    }

    public final ImmutableSet e() {
        return this.f104589a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OnboardingViewState)) {
            return false;
        }
        OnboardingViewState onboardingViewState = (OnboardingViewState) obj;
        return Intrinsics.areEqual(this.f104589a, onboardingViewState.f104589a) && Intrinsics.areEqual(this.f104590b, onboardingViewState.f104590b) && Intrinsics.areEqual(this.f104591c, onboardingViewState.f104591c) && this.f104592d == onboardingViewState.f104592d && this.f104593f == onboardingViewState.f104593f && this.f104594g == onboardingViewState.f104594g && this.f104595h == onboardingViewState.f104595h && this.f104596i == onboardingViewState.f104596i;
    }

    public final boolean f() {
        return this.f104595h;
    }

    public final boolean g() {
        return this.f104594g;
    }

    public final boolean h() {
        return this.f104596i;
    }

    public int hashCode() {
        int iHashCode = this.f104589a.hashCode() * 31;
        Integer num = this.f104590b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f104591c;
        return ((((((((((iHashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Long.hashCode(this.f104592d)) * 31) + Long.hashCode(this.f104593f)) * 31) + Boolean.hashCode(this.f104594g)) * 31) + Boolean.hashCode(this.f104595h)) * 31) + Boolean.hashCode(this.f104596i);
    }

    public final OnboardingAnswersDTO i() {
        ImmutableSet immutableSet = this.f104589a;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(immutableSet, 10));
        Iterator<E> it = immutableSet.iterator();
        while (it.hasNext()) {
            arrayList.add(((OnboardingHelpItem) it.next()).b());
        }
        Integer num = this.f104590b;
        int iIntValue = num != null ? num.intValue() : -1;
        Integer num2 = this.f104591c;
        return new OnboardingAnswersDTO(arrayList, iIntValue, num2 != null ? num2.intValue() : -1, this.f104592d, this.f104593f);
    }

    public String toString() {
        return "OnboardingViewState(selectedHelpItems=" + this.f104589a + ", dailyHoursGuess=" + this.f104590b + ", dailyUnlocksGuess=" + this.f104591c + SbbqvQlxi.WONzrsKfVBZoHp + this.f104592d + ", dailyUnlocks=" + this.f104593f + ", isMultiSelectEnabled=" + this.f104594g + ", skipLogin=" + this.f104595h + ", isUserSignedIn=" + this.f104596i + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OnboardingViewState(ImmutableSet immutableSet, Integer num, Integer num2, long j3, long j4, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z5;
        boolean z6;
        boolean z7;
        immutableSet = (i3 & 1) != 0 ? ExtensionsKt.c() : immutableSet;
        num = (i3 & 2) != 0 ? null : num;
        num2 = (i3 & 4) != 0 ? null : num2;
        j3 = (i3 & 8) != 0 ? 0L : j3;
        j4 = (i3 & 16) != 0 ? 0L : j4;
        z2 = (i3 & 32) != 0 ? true : z2;
        z3 = (i3 & 64) != 0 ? false : z3;
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            z5 = false;
            z7 = z2;
            z6 = z3;
        } else {
            z5 = z4;
            z6 = z3;
            z7 = z2;
        }
        this(immutableSet, num, num2, j3, j4, z7, z6, z5);
    }
}
