package androidx.glance.appwidget;

import android.content.ComponentName;
import android.content.Context;
import androidx.compose.ui.unit.DpSize;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
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
public final class TranslationContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f38509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f38510b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f38511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LayoutConfiguration f38512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f38513e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f38514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AtomicInteger f38515g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final InsertedViewInfo f38516h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicBoolean f38517i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f38518j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f38519k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f38520l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final boolean f38521m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Integer f38522n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final ComponentName f38523o;

    public /* synthetic */ TranslationContext(Context context, int i3, boolean z2, LayoutConfiguration layoutConfiguration, int i4, boolean z3, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j3, int i5, int i6, boolean z4, Integer num, ComponentName componentName, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i3, z2, layoutConfiguration, i4, z3, atomicInteger, insertedViewInfo, atomicBoolean, j3, i5, i6, z4, num, componentName);
    }

    public static /* synthetic */ TranslationContext c(TranslationContext translationContext, Context context, int i3, boolean z2, LayoutConfiguration layoutConfiguration, int i4, boolean z3, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j3, int i5, int i6, boolean z4, Integer num, ComponentName componentName, int i7, Object obj) {
        return translationContext.b((i7 & 1) != 0 ? translationContext.f38509a : context, (i7 & 2) != 0 ? translationContext.f38510b : i3, (i7 & 4) != 0 ? translationContext.f38511c : z2, (i7 & 8) != 0 ? translationContext.f38512d : layoutConfiguration, (i7 & 16) != 0 ? translationContext.f38513e : i4, (i7 & 32) != 0 ? translationContext.f38514f : z3, (i7 & 64) != 0 ? translationContext.f38515g : atomicInteger, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? translationContext.f38516h : insertedViewInfo, (i7 & Function.MAX_NARGS) != 0 ? translationContext.f38517i : atomicBoolean, (i7 & 512) != 0 ? translationContext.f38518j : j3, (i7 & 1024) != 0 ? translationContext.f38519k : i5, (i7 & 2048) != 0 ? translationContext.f38520l : i6, (i7 & 4096) != 0 ? translationContext.f38521m : z4, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? translationContext.f38522n : num, (i7 & 16384) != 0 ? translationContext.f38523o : componentName);
    }

    public final TranslationContext a() {
        return c(this, null, 0, false, null, 0, false, null, null, null, 0L, 0, 0, true, null, null, 28671, null);
    }

    public final TranslationContext b(Context context, int i3, boolean z2, LayoutConfiguration layoutConfiguration, int i4, boolean z3, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j3, int i5, int i6, boolean z4, Integer num, ComponentName componentName) {
        return new TranslationContext(context, i3, z2, layoutConfiguration, i4, z3, atomicInteger, insertedViewInfo, atomicBoolean, j3, i5, i6, z4, num, componentName, null);
    }

    public final TranslationContext d(int i3) {
        return c(this, null, 0, false, null, 0, false, null, null, null, 0L, 0, 0, false, Integer.valueOf(i3), null, 24575, null);
    }

    public final TranslationContext e(InsertedViewInfo insertedViewInfo, int i3) {
        return c(this, null, 0, false, null, i3, false, null, insertedViewInfo, null, 0L, 0, 0, false, null, null, 32623, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TranslationContext)) {
            return false;
        }
        TranslationContext translationContext = (TranslationContext) obj;
        return Intrinsics.areEqual(this.f38509a, translationContext.f38509a) && this.f38510b == translationContext.f38510b && this.f38511c == translationContext.f38511c && Intrinsics.areEqual(this.f38512d, translationContext.f38512d) && this.f38513e == translationContext.f38513e && this.f38514f == translationContext.f38514f && Intrinsics.areEqual(this.f38515g, translationContext.f38515g) && Intrinsics.areEqual(this.f38516h, translationContext.f38516h) && Intrinsics.areEqual(this.f38517i, translationContext.f38517i) && DpSize.h(this.f38518j, translationContext.f38518j) && this.f38519k == translationContext.f38519k && this.f38520l == translationContext.f38520l && this.f38521m == translationContext.f38521m && Intrinsics.areEqual(this.f38522n, translationContext.f38522n) && Intrinsics.areEqual(this.f38523o, translationContext.f38523o);
    }

    public final TranslationContext f(int i3) {
        return c(this, null, 0, false, null, 0, true, null, null, null, 0L, i3, 0, false, null, null, 31711, null);
    }

    public final TranslationContext g(int i3, int i4) {
        return c(this, null, 0, false, null, 0, false, new AtomicInteger(i4), null, null, 0L, i3, 0, false, null, null, 31679, null);
    }

    public final TranslationContext h(RemoteViewsInfo remoteViewsInfo) {
        return c(e(remoteViewsInfo.b(), 0), null, 0, false, null, 0, false, new AtomicInteger(1), null, new AtomicBoolean(false), 0L, 0, 0, false, null, null, 32447, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2 */
    public int hashCode() {
        int iHashCode = ((this.f38509a.hashCode() * 31) + Integer.hashCode(this.f38510b)) * 31;
        boolean z2 = this.f38511c;
        ?? r12 = z2;
        if (z2) {
            r12 = 1;
        }
        int i3 = (iHashCode + r12) * 31;
        LayoutConfiguration layoutConfiguration = this.f38512d;
        int iHashCode2 = (((i3 + (layoutConfiguration == null ? 0 : layoutConfiguration.hashCode())) * 31) + Integer.hashCode(this.f38513e)) * 31;
        boolean z3 = this.f38514f;
        ?? r13 = z3;
        if (z3) {
            r13 = 1;
        }
        int iHashCode3 = (((((((((((((iHashCode2 + r13) * 31) + this.f38515g.hashCode()) * 31) + this.f38516h.hashCode()) * 31) + this.f38517i.hashCode()) * 31) + DpSize.k(this.f38518j)) * 31) + Integer.hashCode(this.f38519k)) * 31) + Integer.hashCode(this.f38520l)) * 31;
        boolean z4 = this.f38521m;
        int i4 = (iHashCode3 + (z4 ? 1 : z4)) * 31;
        Integer num = this.f38522n;
        int iHashCode4 = (i4 + (num == null ? 0 : num.hashCode())) * 31;
        ComponentName componentName = this.f38523o;
        return iHashCode4 + (componentName != null ? componentName.hashCode() : 0);
    }

    public final TranslationContext i(RemoteViewsInfo remoteViewsInfo, long j3) {
        return c(e(remoteViewsInfo.b(), 0), null, 0, false, null, 0, false, new AtomicInteger(1), null, new AtomicBoolean(false), j3, 0, 0, false, null, null, 31935, null);
    }

    public final ComponentName j() {
        return this.f38523o;
    }

    public final Integer k() {
        return this.f38522n;
    }

    public final int l() {
        return this.f38510b;
    }

    public final boolean m() {
        return this.f38521m;
    }

    public final Context n() {
        return this.f38509a;
    }

    public final int o() {
        return this.f38513e;
    }

    public final int p() {
        return this.f38520l;
    }

    public final int q() {
        return this.f38519k;
    }

    public final LayoutConfiguration r() {
        return this.f38512d;
    }

    public final long s() {
        return this.f38518j;
    }

    public final InsertedViewInfo t() {
        return this.f38516h;
    }

    public String toString() {
        return "TranslationContext(context=" + this.f38509a + ", appWidgetId=" + this.f38510b + ", isRtl=" + this.f38511c + ", layoutConfiguration=" + this.f38512d + ", itemPosition=" + this.f38513e + ", isLazyCollectionDescendant=" + this.f38514f + ", lastViewId=" + this.f38515g + ", parentContext=" + this.f38516h + ", isBackgroundSpecified=" + this.f38517i + ", layoutSize=" + ((Object) DpSize.l(this.f38518j)) + ", layoutCollectionViewId=" + this.f38519k + ", layoutCollectionItemId=" + this.f38520l + ", canUseSelectableGroup=" + this.f38521m + ", actionTargetId=" + this.f38522n + ", actionBroadcastReceiver=" + this.f38523o + ')';
    }

    public final AtomicBoolean u() {
        return this.f38517i;
    }

    public final boolean v() {
        return this.f38514f;
    }

    public final boolean w() {
        return this.f38511c;
    }

    public final int x() {
        return this.f38515g.incrementAndGet();
    }

    private TranslationContext(Context context, int i3, boolean z2, LayoutConfiguration layoutConfiguration, int i4, boolean z3, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j3, int i5, int i6, boolean z4, Integer num, ComponentName componentName) {
        this.f38509a = context;
        this.f38510b = i3;
        this.f38511c = z2;
        this.f38512d = layoutConfiguration;
        this.f38513e = i4;
        this.f38514f = z3;
        this.f38515g = atomicInteger;
        this.f38516h = insertedViewInfo;
        this.f38517i = atomicBoolean;
        this.f38518j = j3;
        this.f38519k = i5;
        this.f38520l = i6;
        this.f38521m = z4;
        this.f38522n = num;
        this.f38523o = componentName;
    }

    public /* synthetic */ TranslationContext(Context context, int i3, boolean z2, LayoutConfiguration layoutConfiguration, int i4, boolean z3, AtomicInteger atomicInteger, InsertedViewInfo insertedViewInfo, AtomicBoolean atomicBoolean, long j3, int i5, int i6, boolean z4, Integer num, ComponentName componentName, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, i3, z2, layoutConfiguration, i4, (i7 & 32) != 0 ? false : z3, (i7 & 64) != 0 ? new AtomicInteger(1) : atomicInteger, (i7 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new InsertedViewInfo(0, 0, null, 7, null) : insertedViewInfo, (i7 & Function.MAX_NARGS) != 0 ? new AtomicBoolean(false) : atomicBoolean, (i7 & 512) != 0 ? DpSize.f29984b.b() : j3, (i7 & 1024) != 0 ? -1 : i5, (i7 & 2048) != 0 ? -1 : i6, (i7 & 4096) != 0 ? false : z4, (i7 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? null : num, (i7 & 16384) != 0 ? null : componentName, null);
    }
}
