package androidx.compose.ui.text.android;

import kotlin.Metadata;

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
final class HorizontalPositionCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextLayout f28945a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f28946b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f28947c;

    public HorizontalPositionCache(TextLayout textLayout) {
        this.f28945a = textLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final float a(int r6, boolean r7, boolean r8, boolean r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r7 == 0) goto L1f
            androidx.compose.ui.text.android.TextLayout r2 = r5.f28945a
            android.text.Layout r2 = r2.i()
            int r2 = androidx.compose.ui.text.android.LayoutCompat_androidKt.a(r2, r6, r7)
            androidx.compose.ui.text.android.TextLayout r3 = r5.f28945a
            int r3 = r3.v(r2)
            androidx.compose.ui.text.android.TextLayout r4 = r5.f28945a
            int r2 = r4.p(r2)
            if (r6 == r3) goto L21
            if (r6 != r2) goto L1f
            goto L21
        L1f:
            r2 = r1
            goto L22
        L21:
            r2 = r0
        L22:
            int r3 = r6 * 4
            if (r9 == 0) goto L2a
            if (r2 == 0) goto L2f
            r0 = r1
            goto L2f
        L2a:
            if (r2 == 0) goto L2e
            r0 = 2
            goto L2f
        L2e:
            r0 = 3
        L2f:
            int r3 = r3 + r0
            int r0 = r5.f28946b
            if (r0 != r3) goto L37
            float r6 = r5.f28947c
            return r6
        L37:
            if (r9 == 0) goto L40
            androidx.compose.ui.text.android.TextLayout r9 = r5.f28945a
            float r6 = r9.A(r6, r7)
            goto L46
        L40:
            androidx.compose.ui.text.android.TextLayout r9 = r5.f28945a
            float r6 = r9.D(r6, r7)
        L46:
            if (r8 == 0) goto L4c
            r5.f28946b = r3
            r5.f28947c = r6
        L4c:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.android.HorizontalPositionCache.a(int, boolean, boolean, boolean):float");
    }

    public final float b(int i3) {
        return a(i3, false, false, true);
    }

    public final float c(int i3) {
        return a(i3, true, true, true);
    }

    public final float d(int i3) {
        return a(i3, false, false, false);
    }

    public final float e(int i3) {
        return a(i3, true, true, false);
    }
}
