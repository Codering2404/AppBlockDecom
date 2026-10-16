package androidx.compose.material3.pulltorefresh;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PullToRefreshDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PullToRefreshDefaults f22203a = new PullToRefreshDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Shape f22204b = RoundedCornerShapeKt.g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f22205c = Dp.g(80);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f22206d = ElevationTokens.f22534a.c();

    private PullToRefreshDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final androidx.compose.material3.pulltorefresh.PullToRefreshState r20, final boolean r21, androidx.compose.ui.Modifier r22, long r23, long r25, float r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.a(androidx.compose.material3.pulltorefresh.PullToRefreshState, boolean, androidx.compose.ui.Modifier, long, long, float, androidx.compose.runtime.Composer, int, int):void");
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1066257972, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-containerColor> (PullToRefresh.kt:419)");
        }
        long jR0 = MaterialTheme.f18110a.a(composer, 6).r0();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jR0;
    }

    public final float c() {
        return f22206d;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1441334156, i3, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.<get-indicatorColor> (PullToRefresh.kt:423)");
        }
        long jE0 = MaterialTheme.f18110a.a(composer, 6).e0();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jE0;
    }

    public final float e() {
        return f22205c;
    }

    public final Shape f() {
        return f22204b;
    }
}
