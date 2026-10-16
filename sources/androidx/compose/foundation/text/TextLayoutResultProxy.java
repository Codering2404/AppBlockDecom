package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.text.TextLayoutResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class TextLayoutResultProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextLayoutResult f10027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LayoutCoordinates f10028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LayoutCoordinates f10029c;

    public TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2) {
        this.f10027a = textLayoutResult;
        this.f10028b = layoutCoordinates;
        this.f10029c = layoutCoordinates2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long a(long r6) {
        /*
            r5 = this;
            androidx.compose.ui.layout.LayoutCoordinates r0 = r5.f10028b
            if (r0 == 0) goto L1e
            boolean r1 = r0.m()
            if (r1 == 0) goto L16
            androidx.compose.ui.layout.LayoutCoordinates r1 = r5.f10029c
            r2 = 0
            if (r1 == 0) goto L1c
            r3 = 0
            r4 = 2
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.layout.LayoutCoordinates.R(r1, r0, r3, r4, r2)
            goto L1c
        L16:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r2 = r0.a()
        L1c:
            if (r2 != 0) goto L24
        L1e:
            androidx.compose.ui.geometry.Rect$Companion r0 = androidx.compose.ui.geometry.Rect.f25601e
            androidx.compose.ui.geometry.Rect r2 = r0.a()
        L24:
            long r6 = androidx.compose.foundation.text.TextLayoutResultProxyKt.a(r6, r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.TextLayoutResultProxy.a(long):long");
    }

    public static /* synthetic */ int e(TextLayoutResultProxy textLayoutResultProxy, long j3, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = true;
        }
        return textLayoutResultProxy.d(j3, z2);
    }

    public final LayoutCoordinates b() {
        return this.f10029c;
    }

    public final LayoutCoordinates c() {
        return this.f10028b;
    }

    public final int d(long j3, boolean z2) {
        if (z2) {
            j3 = a(j3);
        }
        return this.f10027a.x(j(j3));
    }

    public final TextLayoutResult f() {
        return this.f10027a;
    }

    public final boolean g(long j3) {
        long j4 = j(a(j3));
        int iR = this.f10027a.r(Float.intBitsToFloat((int) (4294967295L & j4)));
        int i3 = (int) (j4 >> 32);
        return Float.intBitsToFloat(i3) >= this.f10027a.s(iR) && Float.intBitsToFloat(i3) <= this.f10027a.t(iR);
    }

    public final void h(LayoutCoordinates layoutCoordinates) {
        this.f10029c = layoutCoordinates;
    }

    public final void i(LayoutCoordinates layoutCoordinates) {
        this.f10028b = layoutCoordinates;
    }

    public final long j(long j3) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.f10028b;
        if (layoutCoordinates2 == null) {
            return j3;
        }
        if (!layoutCoordinates2.m()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.f10029c) == null) {
            return j3;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.m() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? j3 : layoutCoordinates2.S(layoutCoordinates3, j3);
    }

    public final long k(long j3) {
        LayoutCoordinates layoutCoordinates;
        LayoutCoordinates layoutCoordinates2 = this.f10028b;
        if (layoutCoordinates2 == null) {
            return j3;
        }
        if (!layoutCoordinates2.m()) {
            layoutCoordinates2 = null;
        }
        if (layoutCoordinates2 == null || (layoutCoordinates = this.f10029c) == null) {
            return j3;
        }
        LayoutCoordinates layoutCoordinates3 = layoutCoordinates.m() ? layoutCoordinates : null;
        return layoutCoordinates3 == null ? j3 : layoutCoordinates3.S(layoutCoordinates2, j3);
    }

    public /* synthetic */ TextLayoutResultProxy(TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, LayoutCoordinates layoutCoordinates2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLayoutResult, (i3 & 2) != 0 ? null : layoutCoordinates, (i3 & 4) != 0 ? null : layoutCoordinates2);
    }
}
