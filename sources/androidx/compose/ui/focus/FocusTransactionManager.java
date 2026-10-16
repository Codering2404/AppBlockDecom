package androidx.compose.ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class FocusTransactionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableScatterMap f25558a = ScatterMapKt.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f25559b = new MutableVector(new Function0[16], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f25560c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25561d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        this.f25560c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        this.f25558a.k();
        this.f25560c = false;
        MutableVector mutableVector = this.f25559b;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            ((Function0) objArr[i3]).invoke();
        }
        this.f25559b.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            r14 = this;
            androidx.collection.MutableScatterMap r0 = r14.f25558a
            java.lang.Object[] r1 = r0.f3109b
            long[] r0 = r0.f3108a
            int r2 = r0.length
            int r2 = r2 + (-2)
            r3 = 0
            if (r2 < 0) goto L47
            r4 = r3
        Ld:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L42
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L27:
            if (r9 >= r7) goto L40
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L3c
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.focus.FocusTargetNode r10 = (androidx.compose.ui.focus.FocusTargetNode) r10
            r10.q2()
        L3c:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L27
        L40:
            if (r7 != r8) goto L47
        L42:
            if (r4 == r2) goto L47
            int r4 = r4 + 1
            goto Ld
        L47:
            androidx.collection.MutableScatterMap r0 = r14.f25558a
            r0.k()
            r14.f25560c = r3
            androidx.compose.runtime.collection.MutableVector r0 = r14.f25559b
            r0.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusTransactionManager.g():void");
    }

    public final int h() {
        return this.f25561d;
    }

    public final boolean i() {
        return this.f25560c;
    }

    public final FocusStateImpl j(FocusTargetNode focusTargetNode) {
        if (ComposeUiFlags.f25107g) {
            throw new IllegalStateException("uncommittedFocusState must not be accessed when isTrackFocusEnabled is on");
        }
        return (FocusStateImpl) this.f25558a.e(focusTargetNode);
    }

    public final void k(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        if (ComposeUiFlags.f25107g) {
            return;
        }
        FocusStateImpl focusStateImpl2 = (FocusStateImpl) this.f25558a.e(focusTargetNode);
        if (focusStateImpl2 == null) {
            focusStateImpl2 = FocusStateImpl.f25540d;
        }
        if (focusStateImpl2 != focusStateImpl) {
            this.f25561d++;
        }
        MutableScatterMap mutableScatterMap = this.f25558a;
        if (focusStateImpl != null) {
            mutableScatterMap.x(focusTargetNode, focusStateImpl);
        } else {
            InlineClassHelperKt.d("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }
}
