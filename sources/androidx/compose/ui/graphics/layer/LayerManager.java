package androidx.compose.ui.graphics.layer;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import androidx.collection.MutableObjectList;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.graphics.CanvasHolder;
import java.util.Locale;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class LayerManager {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f26228g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final boolean f26229h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CanvasHolder f26230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableScatterSet f26231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageReader f26232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f26233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private MutableObjectList f26234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f26235f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return LayerManager.f26229h;
        }

        private Companion() {
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        f26229h = Intrinsics.areEqual(lowerCase, "robolectric");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0090  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void d(androidx.collection.ScatterSet r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            boolean r2 = r1.f()
            if (r2 == 0) goto Lc4
            boolean r2 = androidx.compose.ui.graphics.layer.LayerManager.f26229h
            if (r2 != 0) goto Lc4
            android.media.ImageReader r2 = r0.f26232c
            r3 = 1
            if (r2 != 0) goto L24
            r2 = 3
            android.media.ImageReader r2 = android.media.ImageReader.newInstance(r3, r3, r3, r2)
            androidx.compose.ui.graphics.layer.x r4 = new androidx.compose.ui.graphics.layer.x
            r4.<init>()
            android.os.Handler r5 = r0.f26233d
            r2.setOnImageAvailableListener(r4, r5)
            r0.f26232c = r2
        L24:
            android.view.Surface r2 = r2.getSurface()
            androidx.compose.ui.graphics.layer.LockHardwareCanvasHelper r4 = androidx.compose.ui.graphics.layer.LockHardwareCanvasHelper.f26249a
            android.graphics.Canvas r4 = r4.a(r2)
            r0.f26235f = r3
            androidx.compose.ui.graphics.CanvasHolder r5 = r0.f26230a
            androidx.compose.ui.graphics.AndroidCanvas r6 = r5.a()
            android.graphics.Canvas r6 = r6.B()
            androidx.compose.ui.graphics.AndroidCanvas r7 = r5.a()
            r7.C(r4)
            androidx.compose.ui.graphics.AndroidCanvas r7 = r5.a()
            r4.save()
            r8 = 0
            r4.clipRect(r8, r8, r3, r3)
            java.lang.Object[] r3 = r1.f3116b
            long[] r1 = r1.f3115a
            int r9 = r1.length
            int r9 = r9 + (-2)
            if (r9 < 0) goto L96
            r10 = r8
        L56:
            r11 = r1[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L90
            int r13 = r10 - r9
            int r13 = ~r13
            int r13 = r13 >>> 31
            r14 = 8
            int r13 = 8 - r13
            r15 = r8
        L70:
            if (r15 >= r13) goto L8e
            r16 = 255(0xff, double:1.26E-321)
            long r16 = r11 & r16
            r18 = 128(0x80, double:6.3E-322)
            int r16 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r16 >= 0) goto L89
            int r16 = r10 << 3
            int r16 = r16 + r15
            r16 = r3[r16]
            r8 = r16
            androidx.compose.ui.graphics.layer.GraphicsLayer r8 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r8
            r8.i(r7)
        L89:
            long r11 = r11 >> r14
            int r15 = r15 + 1
            r8 = 0
            goto L70
        L8e:
            if (r13 != r14) goto L96
        L90:
            if (r10 == r9) goto L96
            int r10 = r10 + 1
            r8 = 0
            goto L56
        L96:
            r4.restore()
            androidx.compose.ui.graphics.AndroidCanvas r1 = r5.a()
            r1.C(r6)
            r1 = 0
            r0.f26235f = r1
            androidx.collection.MutableObjectList r3 = r0.f26234e
            if (r3 == 0) goto Lc1
            boolean r5 = r3.h()
            if (r5 == 0) goto Lc1
            java.lang.Object[] r5 = r3.f3081a
            int r6 = r3.f3082b
            r8 = r1
        Lb2:
            if (r8 >= r6) goto Lbe
            r1 = r5[r8]
            androidx.compose.ui.graphics.layer.GraphicsLayer r1 = (androidx.compose.ui.graphics.layer.GraphicsLayer) r1
            r0.f(r1)
            int r8 = r8 + 1
            goto Lb2
        Lbe:
            r3.t()
        Lc1:
            r2.unlockCanvasAndPost(r4)
        Lc4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.layer.LayerManager.d(androidx.collection.ScatterSet):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageReader imageReader) {
        Image imageAcquireLatestImage;
        if (imageReader == null || (imageAcquireLatestImage = imageReader.acquireLatestImage()) == null) {
            return;
        }
        imageAcquireLatestImage.close();
    }

    public final void c() {
        ImageReader imageReader = this.f26232c;
        if (imageReader != null) {
            imageReader.close();
        }
        this.f26232c = null;
    }

    public final void f(GraphicsLayer graphicsLayer) {
        if (!this.f26235f) {
            if (this.f26231b.z(graphicsLayer)) {
                graphicsLayer.g();
            }
        } else {
            MutableObjectList mutableObjectList = this.f26234e;
            if (mutableObjectList == null) {
                mutableObjectList = new MutableObjectList(0, 1, null);
                this.f26234e = mutableObjectList;
            }
            mutableObjectList.n(graphicsLayer);
        }
    }

    public final void g() {
        c();
        d(this.f26231b);
    }
}
