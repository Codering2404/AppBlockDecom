package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.text.TextRangeKt;
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
public final class ChangeTracker implements TextFieldBuffer.ChangeList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableVector f10241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableVector f10242b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Change {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f10243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f10244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f10245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f10246d;

        public Change(int i3, int i4, int i5, int i6) {
            this.f10243a = i3;
            this.f10244b = i4;
            this.f10245c = i5;
            this.f10246d = i6;
        }

        public final int a() {
            return this.f10246d;
        }

        public final int b() {
            return this.f10245c;
        }

        public final int c() {
            return this.f10244b;
        }

        public final int d() {
            return this.f10243a;
        }

        public final void e(int i3) {
            this.f10246d = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Change)) {
                return false;
            }
            Change change = (Change) obj;
            return this.f10243a == change.f10243a && this.f10244b == change.f10244b && this.f10245c == change.f10245c && this.f10246d == change.f10246d;
        }

        public final void f(int i3) {
            this.f10245c = i3;
        }

        public final void g(int i3) {
            this.f10244b = i3;
        }

        public final void h(int i3) {
            this.f10243a = i3;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f10243a) * 31) + Integer.hashCode(this.f10244b)) * 31) + Integer.hashCode(this.f10245c)) * 31) + Integer.hashCode(this.f10246d);
        }

        public String toString() {
            return "Change(preStart=" + this.f10243a + ", preEnd=" + this.f10244b + ", originalStart=" + this.f10245c + ", originalEnd=" + this.f10246d + ')';
        }
    }

    public ChangeTracker(ChangeTracker changeTracker) {
        MutableVector mutableVector;
        this.f10241a = new MutableVector(new Change[16], 0);
        this.f10242b = new MutableVector(new Change[16], 0);
        if (changeTracker == null || (mutableVector = changeTracker.f10241a) == null) {
            return;
        }
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            Change change = (Change) objArr[i3];
            this.f10241a.b(new Change(change.d(), change.c(), change.b(), change.a()));
        }
    }

    private final void d(Change change, int i3, int i4, int i5) {
        int iC;
        if (this.f10242b.o() == 0) {
            iC = 0;
        } else {
            Change change2 = (Change) this.f10242b.q();
            iC = change2.c() - change2.a();
        }
        if (change == null) {
            int i6 = i3 - iC;
            change = new Change(i3, i4 + i5, i6, (i4 - i3) + i6);
        } else {
            if (change.d() > i3) {
                change.h(i3);
                change.f(i3);
            }
            if (i4 > change.c()) {
                int iC2 = change.c() - change.a();
                change.g(i4);
                change.e(i4 - iC2);
            }
            change.g(change.c() + i5);
        }
        this.f10242b.b(change);
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    public long a(int i3) {
        Change change = (Change) this.f10241a.f24389a[i3];
        return TextRangeKt.b(change.b(), change.a());
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    public int b() {
        return this.f10241a.o();
    }

    @Override // androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList
    public long c(int i3) {
        Change change = (Change) this.f10241a.f24389a[i3];
        return TextRangeKt.b(change.d(), change.c());
    }

    public final void e() {
        this.f10241a.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void f(int r7, int r8, int r9) {
        /*
            r6 = this;
            if (r7 != r8) goto L5
            if (r9 != 0) goto L5
            return
        L5:
            int r0 = java.lang.Math.min(r7, r8)
            int r7 = java.lang.Math.max(r7, r8)
            int r8 = r7 - r0
            int r9 = r9 - r8
            r8 = 0
            r1 = 0
            r2 = r1
            r1 = r8
        L14:
            androidx.compose.runtime.collection.MutableVector r3 = r6.f10241a
            int r3 = r3.o()
            if (r8 >= r3) goto L88
            androidx.compose.runtime.collection.MutableVector r3 = r6.f10241a
            java.lang.Object[] r3 = r3.f24389a
            r3 = r3[r8]
            androidx.compose.foundation.text.input.internal.ChangeTracker$Change r3 = (androidx.compose.foundation.text.input.internal.ChangeTracker.Change) r3
            int r4 = r3.d()
            if (r0 > r4) goto L2d
            if (r4 > r7) goto L2d
            goto L4f
        L2d:
            int r4 = r3.c()
            if (r0 > r4) goto L36
            if (r4 > r7) goto L36
            goto L4f
        L36:
            int r4 = r3.d()
            int r5 = r3.c()
            if (r0 > r5) goto L43
            if (r4 > r0) goto L43
            goto L4f
        L43:
            int r4 = r3.d()
            int r5 = r3.c()
            if (r7 > r5) goto L64
            if (r4 > r7) goto L64
        L4f:
            if (r2 != 0) goto L53
            r2 = r3
            goto L61
        L53:
            int r4 = r3.c()
            r2.g(r4)
            int r3 = r3.a()
            r2.e(r3)
        L61:
            int r8 = r8 + 1
            goto L14
        L64:
            int r4 = r3.d()
            if (r4 <= r7) goto L70
            if (r1 != 0) goto L70
            r6.d(r2, r0, r7, r9)
            r1 = 1
        L70:
            if (r1 == 0) goto L82
            int r4 = r3.d()
            int r4 = r4 + r9
            r3.h(r4)
            int r4 = r3.c()
            int r4 = r4 + r9
            r3.g(r4)
        L82:
            androidx.compose.runtime.collection.MutableVector r4 = r6.f10242b
            r4.b(r3)
            goto L61
        L88:
            if (r1 != 0) goto L8d
            r6.d(r2, r0, r7, r9)
        L8d:
            androidx.compose.runtime.collection.MutableVector r7 = r6.f10241a
            androidx.compose.runtime.collection.MutableVector r8 = r6.f10242b
            r6.f10241a = r8
            r6.f10242b = r7
            r7.i()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.ChangeTracker.f(int, int, int):void");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ChangeList(changes=[");
        MutableVector mutableVector = this.f10241a;
        Object[] objArr = mutableVector.f24389a;
        int iO = mutableVector.o();
        for (int i3 = 0; i3 < iO; i3++) {
            Change change = (Change) objArr[i3];
            sb.append('(' + change.b() + ',' + change.a() + ")->(" + change.d() + ',' + change.c() + ')');
            if (i3 < b() - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public /* synthetic */ ChangeTracker(ChangeTracker changeTracker, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : changeTracker);
    }
}
